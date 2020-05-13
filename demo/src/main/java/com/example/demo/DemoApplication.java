package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(DemoApplication.class, args);
		 

	      // Step 2: Establish the connection to the database 
	      //String url = "jdbc:mysql://10.1.101.52:3306/sec_schema"; 
	      //String url = "jdbc:mysql://localhost:3306/sec_schema"; 
	      String url =  "jdbc:mysql://localhost:3306/sec_schema?user=mysql&password=root";
	      System.out.println("This statement Before connection");
	      try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); 
	      Connection conn = DriverManager.getConnection(url); 
		  //Connection conn = DriverManager.getConnection(url,"mysql","root");  
	      System.out.println("This statement after connection");
	      }catch(SQLException ex) {
	    	  System.out.println("state "+ex.getSQLState());
	    	  System.out.println("message "+ex.getMessage());
	    	  System.out.println("state "+ex.getErrorCode());
	    	  
	      }
	
	}

}
