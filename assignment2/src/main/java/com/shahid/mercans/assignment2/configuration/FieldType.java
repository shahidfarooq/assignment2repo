package com.shahid.mercans.assignment2.configuration;

/**
 * ENUM class defining values for FiledTypes
 * @author Shahid Farooq
 *
 */
public enum FieldType {

	Regular("Regular"), ActionCode("ActionCode"), EmployeeCode("EmployeeCode");

	private final String value;

	FieldType(final String fieldType) {
		value = fieldType;
	}

	public String getValue() {
		return value;
	}
}
