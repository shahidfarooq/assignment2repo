package com.shahid.mercans.assignment2.controller;

import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shahid.mercans.assignment2.models.ParseFileResponse;
import com.shahid.mercans.assignment2.models.Request;
import com.shahid.mercans.assignment2.parser.csvparser.CSVParser;
import com.shahid.mercans.assignment2.utils.Constant;

/**
 * Controller class exposing interface to parse csv file whose name is passed as input
 * @author Shahid Farooq
 *
 */
@RestController
public class ParseCsvController {

	@RequestMapping(value = "/parse/csv/{filename}", produces = "application/json", method = RequestMethod.GET)
	public ParseFileResponse parseCsvFile(@PathVariable("filename") String fileName) {
		Request request = null;
		ParseFileResponse fileResponse = null;
		if (Pattern.matches(Constant.DYNAMIC_CONFIGURATION.getFileNamePattern(), fileName)) {
			CSVParser csvParser = new CSVParser();
			request = csvParser.process(fileName);
			if (request != null)
				fileResponse = new ParseFileResponse(Constant.REST_SUCCESS_CODE, Constant.REST_SUCCESS_DESCRIPTION,
						request);
			else
				fileResponse = new ParseFileResponse(Constant.REST_BAD_REQUEST_ERROR_CODE,
						Constant.REST_BAD_REQUEST_ERROR_DESCRIPTION, request);
		} else
			fileResponse = new ParseFileResponse(Constant.REST_BAD_REQUEST_ERROR_CODE,
					Constant.REST_BAD_REQUEST_ERROR_DESCRIPTION, request);
		return fileResponse;
	}

}
