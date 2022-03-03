package com.shahid.mercans.assignment2.utils;

import com.shahid.mercans.assignment2.configuration.DynamicConfiguration;

/**
 * Class defining the constant values used across the project
 * @author Shahid Farooq
 *
 */
public class Constant {

	public static String FILE_PATH = "";
	public static DynamicConfiguration DYNAMIC_CONFIGURATION;
	
	public static String DB_URL;
	public static String DB_USERNAME;
	public static String DB_PASSWORD;
	public static String DB_MAX_POOL_SIZE;

	public static String GLOBAL_INPUT_DATE_FORMAT = "ddMMyy";
	public static String GLOBAL_OUTPUT_DATE_FORMAT = "yyyy-MM-dd";
	public static String GENERATE_EMPLOYEE_CODE_DATE_FORMAT = "yyMMdd";

	public static final String HIRE_EMPLOYEE_CODE_AND_FIRST_DATE_MISSING = "Hire request is missing both employee code and first date";

	public static final int REST_BAD_REQUEST_ERROR_CODE = 400;
	public static final String REST_BAD_REQUEST_ERROR_DESCRIPTION = "Filename is not correct";
	public static final int REST_SUCCESS_CODE = 200;
	public static final String REST_SUCCESS_DESCRIPTION = "Request processed successfully";

}
