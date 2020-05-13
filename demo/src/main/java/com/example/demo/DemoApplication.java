package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(DemoApplication.class, args);
		  Class.forName("com.mysql.jdbc.Driver"); 

	      // Step 2: Establish the connection to the database 
	      //String url = "jdbc:mysql://localhost:3306/sec_schema"; 
	      String url = "jdbc:mysql://10.1.101.52:3306/sec_schema"; 
	      System.out.println("This statement Before connection");
	      Connection conn = DriverManager.getConnection(url,"mysql","root"); 
		  //Connection conn = DriverManager.getConnection(url,"root","mysql");  
	      System.out.println("This statement after connection");
	
	}

}
