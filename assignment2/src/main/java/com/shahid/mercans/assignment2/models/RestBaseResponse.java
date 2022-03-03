package com.shahid.mercans.assignment2.models;

/**
 * Base response class to have fields common in all response classes
 * @author Shahid Farooq
 *
 */
public class RestBaseResponse {

	private int status;
	private String description;

	public RestBaseResponse(int status, String description) {
		this.status = status;
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
