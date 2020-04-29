package com.sec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class App 
{
	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@mysqlz04.sasken.com:1521:gurukulnew", "gurukulread", "hou9Ki_e")) {

			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

