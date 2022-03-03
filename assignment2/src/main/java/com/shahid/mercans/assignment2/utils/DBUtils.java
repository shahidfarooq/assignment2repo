package com.shahid.mercans.assignment2.utils;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Class to maintain database connectivity and connection pooling using Hikari Connection pooling
 * @author Shahid Farooq
 *
 */
public class DBUtils {

	private static HikariDataSource dataSource;
	
	private DBUtils(){
		
	}

	public static HikariDataSource getDatasource() {
		if (dataSource == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				HikariConfig config = new HikariConfig();
				config.setJdbcUrl(Constant.DB_URL);
				config.setUsername(Constant.DB_USERNAME);
				config.setPassword(Constant.DB_PASSWORD);
				config.addDataSourceProperty("maximumPoolSize", Constant.DB_MAX_POOL_SIZE);
				dataSource = new HikariDataSource(config);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return getDatasource().getConnection();
	}

}
