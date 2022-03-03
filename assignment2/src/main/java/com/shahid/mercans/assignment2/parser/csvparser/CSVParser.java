package com.shahid.mercans.assignment2.parser.csvparser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.shahid.mercans.assignment2.configuration.DataType;
import com.shahid.mercans.assignment2.configuration.DynamicConfigurationField;
import com.shahid.mercans.assignment2.models.Person;
import com.shahid.mercans.assignment2.models.Request;
import com.shahid.mercans.assignment2.utils.CommonUtils;
import com.shahid.mercans.assignment2.utils.Constant;

/**
 * CSV Parser class, responsible for driving the parsing logic of CSV and applying validation and business rules
 * @author Shahid Farooq
 *
 */
public class CSVParser {

	List<String> errors = new ArrayList<String>();

	public Request process(String filename) {
		CSVParser csvParser = new CSVParser();
		List<String[]> list = csvParser.getAllLinesFromCSV(filename);
		List<String[]> listProcessed;
		Map<String, Integer> columnMap;
		if (list != null) {
			columnMap = getColumnsMap(list.get(0));
			list.remove(0);
			listProcessed = validateRecords(list, columnMap);
			List<Person> persons = getPersonsList(listProcessed, columnMap);
			return buildRequestandPrintJson(persons, filename);
		}
		return null;
	}

	private List<String[]> getAllLinesFromCSV(String filename) {
		try (CSVReader csvReader = new CSVReader(new FileReader(Constant.FILE_PATH + filename));) {
			return csvReader.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Map<String, Integer> getColumnsMap(String[] columnName) {
		Map<String, Integer> columnMap = new HashMap<String, Integer>();
		if (columnName != null) {
			for (int i = 0; i < columnName.length; i++)
				columnMap.put(columnName[i], i);
		}
		return columnMap;
	}

	private List<String[]> validateRecords(List<String[]> list, Map<String, Integer> columnMap) {
		List<String[]> listProcessed = new ArrayList<String[]>();
		int index = 0;
		for (String[] currentRow : list) {
			index++;
			for (DynamicConfigurationField configurationField : Constant.DYNAMIC_CONFIGURATION.getFields()) {
				String value = currentRow[columnMap.get(configurationField.getSourceField())];
				if (configurationField.getIsMandatory() && (value == null || value.isEmpty()))
					errors.add(configurationField.getSourceField() + " is null or empty at row " + index);
				if (configurationField.getValidationPattern() != null
						&& !configurationField.getValidationPattern().isEmpty()) {
					if (!Pattern.matches(configurationField.getValidationPattern(), value)) {
						value = "";
						errors.add(configurationField.getSourceField() + " is not valid at row " + index);
					}
				}
				if (configurationField.getDateFormat() != null && !configurationField.getDateFormat().isEmpty()) {
					String newValue = CommonUtils.convertDateFormat(configurationField.getDateFormat(),
							Constant.GLOBAL_OUTPUT_DATE_FORMAT, value);
					if (newValue != null && !newValue.isEmpty())
						value = newValue;
					else {
						value = "";
						errors.add(configurationField.getSourceField() + " is not a valid date at row " + index);
					}
				}
				if (configurationField.getDataType().equals(DataType.Decimal)
						|| configurationField.getDataType().equals(DataType.Integer)) {
					if (!NumberUtils.isParsable(value)) {
						value = "";
						errors.add(configurationField.getSourceField() + " is not a valid data type " + index);
					}
				}
				if (configurationField.getMappingKey() != null && !configurationField.getMappingKey().isEmpty()) {
					value = Constant.DYNAMIC_CONFIGURATION.getMappings().get(configurationField.getMappingKey())
							.get(value.toLowerCase());
				}
				currentRow[columnMap.get(configurationField.getSourceField())] = value;
			}
			listProcessed.add(currentRow);
		}
		return listProcessed;
	}

	private List<Person> getPersonsList(List<String[]> listProcessed, Map<String, Integer> columnMap) {
		ArrayList<Person> persons = new ArrayList<Person>();
		RequestHandlerFactory requestHandlerFactory = new RequestHandlerFactory();
		for (String[] currentRow : listProcessed) {
			Person person = new Person(currentRow, columnMap);
			if (person.getAction() == null || person.getAction().isEmpty())
				System.out.println("Record is discarded as action is missing");
			else {
				IParserRequestHandler iParserRequestHandler = requestHandlerFactory
						.getRequestHandler(person.getAction());
				person = iParserRequestHandler.applyBusinessRules(person);
				if (person != null)
					persons.add(person);
				else
					System.out.println("Record is discarded as mandatory fields missing");
			}
		}
		return persons;
	}

	private Request buildRequestandPrintJson(List<Person> persons, String filename) {
		Request request = new Request();
		request.setFname(filename);
		request.setPersons(persons);
		request.setUuid(UUID.randomUUID().toString());
		request.setErros(errors);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return request;
	}
}
