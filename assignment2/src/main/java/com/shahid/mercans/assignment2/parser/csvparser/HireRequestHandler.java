package com.shahid.mercans.assignment2.parser.csvparser;

import com.shahid.mercans.assignment2.models.Person;
import com.shahid.mercans.assignment2.utils.CommonUtils;

/**
 * Request handler class for handling new hiring requests
 * @author Shahid Farooq
 *
 */
public class HireRequestHandler implements IParserRequestHandler {

	@Override
	public Person applyBusinessRules(Person person) {

		if ((person.getEmployeeCode() == null || person.getEmployeeCode().isEmpty())
				&& (!person.getData().containsKey("person.hire_date")
						|| person.getData().get("person.hire_date").isEmpty()))
			return null;
		if ((person.getEmployeeCode() == null || person.getEmployeeCode().isEmpty())
				&& person.getData().containsKey("person.hire_date")
				&& !person.getData().get("person.hire_date").isEmpty()) {
			String employeeCode = CommonUtils.generateEmployeeCode(person.getData().get("person.hire_date"));
			if (employeeCode != null && !employeeCode.isEmpty())
				person.setEmployeeCode(employeeCode.toUpperCase());
			else
				return null;
		}
		return person;
	}

}
