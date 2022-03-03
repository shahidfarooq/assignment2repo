package com.shahid.mercans.assignment2;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

/**
 * Spring boot main application executed as entry point to project
 * @author Shahid Farooq
 *
 */
@SpringBootApplication
public class Assignment2Application {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		SpringApplication.run(Assignment2Application.class, args);
	}
}
