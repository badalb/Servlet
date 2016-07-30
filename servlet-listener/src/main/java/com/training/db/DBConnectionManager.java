package com.training.db;

import java.sql.Connection;

public class DBConnectionManager {

	@SuppressWarnings("unused")
	private String dbURL;
	@SuppressWarnings("unused")
	private String user;
	@SuppressWarnings("unused")
	private String password;
	private Connection con;

	public DBConnectionManager(String url, String u, String p) {
		this.dbURL = url;
		this.user = u;
		this.password = p;
		// create db connection now

	}

	public Connection getConnection() {
		return this.con;
	}

	public void closeConnection() {
		// close DB connection here
	}
}
