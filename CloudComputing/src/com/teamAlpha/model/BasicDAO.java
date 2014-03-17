package com.teamAlpha.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class BasicDAO {

	private Connection connection;

	public Connection getConnection()
	{
		return connection;

	}

	public BasicDAO(String dbPropertiesFile) throws SQLException,
	ClassNotFoundException, IOException {

		Properties dbProp = new Properties();
		FileReader reader = new FileReader(dbPropertiesFile);
		dbProp.load(reader);

		Class.forName(dbProp.getProperty("jdbcDriver"));

		connection = DriverManager.getConnection(dbProp
				.getProperty("connectionString")
				+ "?user="
				+ dbProp.getProperty("userName")
				+ "&password="
				+ dbProp.getProperty("password"));
	}

}
