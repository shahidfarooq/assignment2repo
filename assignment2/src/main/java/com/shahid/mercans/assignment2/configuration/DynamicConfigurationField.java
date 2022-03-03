package com.shahid.mercans.assignment2.configuration;

/**
 * Model class for DynamicConfigurationField
 * @author Shahid Farooq
 *
 */
public class DynamicConfigurationField {

	private FieldType fieldType;
	private String sourceField;
	private DataType dataType;
	private Boolean isMandatory;
	private String mappingKey;
	private String targetEntity;
	private String targetField;
	private String dateFormat;
	private String validationPattern;
	private Integer regexCaptureGroupNr;

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public Boolean getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public String getMappingKey() {
		return mappingKey;
	}

	public void setMappingKey(String mappingKey) {
		this.mappingKey = mappingKey;
	}

	public String getTargetEntity() {
		return targetEntity;
	}

	public void setTargetEntity(String targetEntity) {
		this.targetEntity = targetEntity;
	}

	public String getTargetField() {
		return targetField;
	}

	public void setTargetField(String targetField) {
		this.targetField = targetField;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getValidationPattern() {
		return validationPattern;
	}

	public void setValidationPattern(String validationPattern) {
		this.validationPattern = validationPattern;
	}

	public Integer getRegexCaptureGroupNr() {
		return regexCaptureGroupNr;
	}

	public void setRegexCaptureGroupNr(Integer regexCaptureGroupNr) {
		this.regexCaptureGroupNr = regexCaptureGroupNr;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
