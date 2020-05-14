package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);

		String SCL = "jdbc:mysql://mysqlz04.sasken.com:3306/gurukulnew ";

		String SEC = "jdbc:mysql://10.1.101.52:3306/sec_schema?user=mysql&password=root&useUnicode=true&characterEncoding=UTF-8";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("This statement Before connection");
			Connection conn = DriverManager.getConnection(SCL, "gurukulread", "hou9Ki_e");
			System.out.println("connected to Gurukuldb");

			System.out.println("trying connection to  SEC DB");

			//Connection conn1 = DriverManager.getConnection(SEC, "mysql", "root");
			Connection conn1=DriverManager.getConnection(SEC);
			System.out.println("connected to SEC DB");
		} catch (SQLException ex) {
			System.out.println("state " + ex.getSQLState());
			System.out.println("message " + ex.getMessage());
			System.out.println("error " + ex.getErrorCode());

		}

	}

}
