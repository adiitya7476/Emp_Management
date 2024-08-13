package com.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connections {

	public static Connection connect()
	{
		String url = "jdbc:mysql://localhost:3306/Emp_Management";
		String user = "root";
		String pass = "12345";
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
