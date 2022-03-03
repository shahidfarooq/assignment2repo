package com.shahid.mercans.assignment2.configuration;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahid.mercans.assignment2.utils.Constant;

/**
 * Event listener class, listening on ApplicationStartup responsible for initializing configuration
 * @author Shahid Farooq
 *
 */
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("com.shahid.mercans.assignment2.configuration.config");
		if(resourceBundle.containsKey("file.path"))
			Constant.FILE_PATH = resourceBundle.getString("file.path");
		else
			Constant.FILE_PATH = "E:\\Personal Work\\Assignment 2 Mercans\\";
		Constant.DB_URL = resourceBundle.getString("mysql.url");
		Constant.DB_USERNAME = resourceBundle.getString("mysql.username");
		Constant.DB_PASSWORD = resourceBundle.getString("mysql.password");
		Constant.DB_MAX_POOL_SIZE = resourceBundle.getString("mysql.maximumPoolSize");
		
		// create object mapper instance
		ObjectMapper mapper = new ObjectMapper();
		// convert JSON file to configuration object
		File resource;
		try {
			resource = new ClassPathResource("dynamic_config.json").getFile();
			Constant.DYNAMIC_CONFIGURATION = mapper.readValue(resource, DynamicConfiguration.class);
			System.out.println(Constant.DYNAMIC_CONFIGURATION.getFileNamePattern());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid configuration file");
		}
	}
}