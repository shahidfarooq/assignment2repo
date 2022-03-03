package com.shahid.mercans.assignment2.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Utilities class having methods commonly used across the project
 * @author Shahid Farooq
 *
 */
public class CommonUtils {

	/**
	 * Method generates employee code based on first working date
	 * @param firstDate
	 * @return
	 */
	public static String generateEmployeeCode(String firstDate) {
		String employeeCode = null;
		String sixDigits = CommonUtils.convertDateFormat(Constant.GLOBAL_INPUT_DATE_FORMAT,
				Constant.GENERATE_EMPLOYEE_CODE_DATE_FORMAT, firstDate);
		if (sixDigits != null && !sixDigits.isEmpty())
			employeeCode = sixDigits.concat(Integer.toHexString(new Random().nextInt(254) + 1));
		return employeeCode;
	}

	/**
	 * Method converts the date format from one to another as provided
	 * @param fromFormat
	 * @param toFormat
	 * @param input
	 * @return
	 */
	public static String convertDateFormat(String fromFormat, String toFormat, String input) {
		String result = null;
		SimpleDateFormat fromDateFormat = new SimpleDateFormat(fromFormat);
		SimpleDateFormat toDateFormat = new SimpleDateFormat(toFormat);
		try {
			result = toDateFormat.format(fromDateFormat.parse(input));
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Method to parse date from string
	 * @param input
	 * @return
	 */
	public static Date getDateFromString(String input) {
		try {
			return new SimpleDateFormat(Constant.GLOBAL_OUTPUT_DATE_FORMAT).parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
