package com.shahid.mercans.assignment2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Salary model class
 * @author Shahid Farooq
 *
 */
public class SalaryComponent {

	@JsonProperty("startDate")
	private String startDate;
	@JsonProperty("endDate")
	private String endDate;
	@JsonProperty("amount")
	private double amount;
	@JsonProperty("currency")
	private String currency;

	public SalaryComponent() {
	}

	public SalaryComponent(String amount, String currency, String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.currency = currency;
		this.amount = Double.parseDouble(amount);
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
