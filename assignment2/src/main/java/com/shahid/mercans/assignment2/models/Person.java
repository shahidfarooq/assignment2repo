package com.shahid.mercans.assignment2.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shahid.mercans.assignment2.configuration.DynamicConfigurationField;
import com.shahid.mercans.assignment2.configuration.FieldType;
import com.shahid.mercans.assignment2.utils.Constant;

/**
 * Model class for person entity
 * 
 * @author Shahid Farooq
 *
 */
public class Person {

	@JsonIgnore
	private int id;
	@JsonProperty("employeeCode")
	private String employeeCode;
	@JsonProperty("action")
	private String action;
	@JsonProperty("data")
	Map<String, String> data;
	@JsonProperty("payComponents")
	List<SalaryComponent> salaryComponents;

	public Person() {
	}

	public Person(String[] values, Map<String, Integer> columnsMap) {
		this.employeeCode = values[columnsMap.get("contract_workerId")];
		this.action = values[columnsMap.get("ACTION")];
		this.data = new HashMap<String, String>();
		for (DynamicConfigurationField dynamicConfigurationField : Constant.DYNAMIC_CONFIGURATION.getFields()) {
			String tempValue = values[columnsMap.get(dynamicConfigurationField.getSourceField())];
			if (dynamicConfigurationField.getFieldType().equals(FieldType.Regular)
					&& dynamicConfigurationField.getTargetEntity().equalsIgnoreCase("Person") && tempValue != null
					&& !tempValue.isEmpty())
				this.data.put(
						dynamicConfigurationField.getTargetEntity() + "." + dynamicConfigurationField.getTargetField(),
						tempValue);
		}
		ArrayList<SalaryComponent> salaryComponents = new ArrayList<SalaryComponent>();
		if (values[columnsMap.get("pay_amount")] != null && !values[columnsMap.get("pay_amount")].isEmpty()
				&& values[columnsMap.get("pay_currency")] != null && !values[columnsMap.get("pay_currency")].isEmpty()
				&& values[columnsMap.get("pay_effectiveFrom")] != null
				&& !values[columnsMap.get("pay_effectiveFrom")].isEmpty()
				&& values[columnsMap.get("pay_effectiveTo")] != null
				&& !values[columnsMap.get("pay_effectiveTo")].isEmpty()) {
			SalaryComponent salaryComponent = new SalaryComponent(values[columnsMap.get("pay_amount")],
					values[columnsMap.get("pay_currency")], values[columnsMap.get("pay_effectiveFrom")],
					values[columnsMap.get("pay_effectiveTo")]);
			salaryComponents.add(salaryComponent);
		}
		if (values[columnsMap.get("compensation_amount")] != null
				&& !values[columnsMap.get("compensation_amount")].isEmpty()
				&& values[columnsMap.get("compensation_currency")] != null
				&& !values[columnsMap.get("compensation_currency")].isEmpty()
				&& values[columnsMap.get("compensation_effectiveFrom")] != null
				&& !values[columnsMap.get("compensation_effectiveFrom")].isEmpty()
				&& values[columnsMap.get("compensation_effectiveTo")] != null
				&& !values[columnsMap.get("compensation_effectiveTo")].isEmpty()) {
			SalaryComponent salaryComponent = new SalaryComponent(values[columnsMap.get("compensation_amount")],
					values[columnsMap.get("compensation_currency")],
					values[columnsMap.get("compensation_effectiveFrom")],
					values[columnsMap.get("compensation_effectiveTo")]);
			salaryComponents.add(salaryComponent);
		}
		this.salaryComponents = salaryComponents;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public List<SalaryComponent> getSalaryComponents() {
		return salaryComponents;
	}

	public void setSalaryComponents(List<SalaryComponent> salaryComponents) {
		this.salaryComponents = salaryComponents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
