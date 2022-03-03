package com.shahid.mercans.assignment2.configuration;

/**
 * ENUM class defining values for data types
 * @author Shahid Farooq
 *
 */
public enum DataType {

	Text("Text"), Integer("Integer"), Decimal("Decimal"), Bool("Bool"), Date("Date");

	private String type;

	DataType(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
