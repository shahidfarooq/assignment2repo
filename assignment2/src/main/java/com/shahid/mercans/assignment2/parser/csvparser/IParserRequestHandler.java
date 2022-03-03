package com.shahid.mercans.assignment2.parser.csvparser;

import com.shahid.mercans.assignment2.models.Person;

/**
 * Interface defining method for request handlers which must be implemented by any request handler class
 * @author Shahid Farooq
 *
 */
public interface IParserRequestHandler {

	public Person applyBusinessRules(Person person);
}
