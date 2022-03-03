package com.shahid.mercans.assignment2.parser.csvparser;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.shahid.mercans.assignment2.models.Person;
import com.shahid.mercans.assignment2.utils.Constant;

/**
 * Class implementing ParserRequestHandler interface and responisble for applying termination business rules
 * @author Shahid Farooq
 *
 */
public class TerminateRequestHandler implements IParserRequestHandler {

	@Override
	public Person applyBusinessRules(Person person) {
		if ((person.getEmployeeCode() == null || person.getEmployeeCode().isEmpty()))
			return null;
		if ((!person.getData().containsKey("person.termination_date")
				|| person.getData().get("person.termination_date").isEmpty()))
			person.getData().put("person.termination_date",
					new SimpleDateFormat(Constant.GLOBAL_INPUT_DATE_FORMAT).format(new Date()));
		return person;
	}
}
