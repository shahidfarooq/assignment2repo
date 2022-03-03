package com.shahid.mercans.assignment2.parser.csvparser;

import com.shahid.mercans.assignment2.models.Person;

/**
 * Class implementing business rules for change in employee information
 * @author Shahid Farooq
 *
 */
public class ChangeRequestHandler implements IParserRequestHandler {

	@Override
	public Person applyBusinessRules(Person person) {
		if ((person.getEmployeeCode() == null || person.getEmployeeCode().isEmpty()))
			return null;
		return person;
	}

}
