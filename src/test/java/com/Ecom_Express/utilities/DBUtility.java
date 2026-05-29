package com.Ecom_Express.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	private static Connection con;

	public static Connection getConnection() throws Exception {

		ReadConfig config = new ReadConfig();

		if (con == null || con.isClosed()) {

			con = DriverManager.getConnection(config.getDBURL(), config.getDBUser(), config.getDBPassword());
		}

		return con;
	}
}