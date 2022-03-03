package com.shahid.mercans.assignment2.models;

/**
 * Model for ParseFileResponse
 * @author Shahid Farooq
 *
 */
public class ParseFileResponse extends RestBaseResponse {

	private Request request;

	public ParseFileResponse(int status, String description, Request request) {
		super(status, description);
		this.request = request;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}
