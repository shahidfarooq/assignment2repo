package com.shahid.mercans.assignment2.configuration;

import java.util.List;
import java.util.Map;

/**
 * Class holding all dynamic configurations
 * @author Shahid Farooq
 *
 */
public class DynamicConfiguration {

	private String fileNamePattern;
	private Map<String, Map<String, String>> mappings;
	private List<DynamicConfigurationField> fields;

	public String getFileNamePattern() {
		return fileNamePattern;
	}

	public void setFileNamePattern(String fileNamePattern) {
		this.fileNamePattern = fileNamePattern;
	}

	public Map<String, Map<String, String>> getMappings() {
		return mappings;
	}

	public void setMappings(Map<String, Map<String, String>> mappings) {
		this.mappings = mappings;
	}

	public List<DynamicConfigurationField> getFields() {
		return fields;
	}

	public void setFields(List<DynamicConfigurationField> fields) {
		this.fields = fields;
	}
}
