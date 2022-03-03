package com.shahid.mercans.assignment2.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shahid.mercans.assignment2.dao.PersonDao;
import com.shahid.mercans.assignment2.dao.PersonEntity;
import com.shahid.mercans.assignment2.models.AddRecordResponse;
import com.shahid.mercans.assignment2.models.Person;
import com.shahid.mercans.assignment2.models.Request;
import com.shahid.mercans.assignment2.models.SalaryComponent;
import com.shahid.mercans.assignment2.utils.Constant;

/**
 * Controller class to expose REST interface for manipulating database records based on input
 * @author Shahid Farooq
 *
 */
@RestController
public class AddRecrodController {

	@RequestMapping(value = "/add/record", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public AddRecordResponse addRecordToDatabase(@RequestBody Request request) {
		AddRecordResponse addRecordResponse = new AddRecordResponse(Constant.REST_SUCCESS_CODE,
				Constant.REST_SUCCESS_DESCRIPTION);
		PersonDao personDao = new PersonDao();
		for (Person person : request.getPersons()) {
			if (person.getAction().equalsIgnoreCase("hire") && personDao.getPersonByCode(new PersonEntity(person))) {
				int id = personDao.insertPerson(new PersonEntity(person));
				for (SalaryComponent salaryComponent : person.getSalaryComponents()) {
					personDao.insertSalary(salaryComponent, id);
				}
			} else if (person.getAction().equalsIgnoreCase("change"))
				personDao.changePerson(new PersonEntity(person));
			else if (person.getAction().equalsIgnoreCase("terminate"))
				personDao.terminatePerson(new PersonEntity(person));
		}
		return addRecordResponse;
	}

}
