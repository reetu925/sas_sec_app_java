package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	  public static void main(String[] args) throws Exception {
	        SpringApplication.run(DemoApplication.class, args);
	        
	        String SCL_URL = "jdbc:mysql://mysqlz04.sasken.com:3306/gurukulnew";
	        String SCLuserName = "gurukulread";
	        String SCLpassword = "hou9Ki_e";
	        
	        getConnection(SCL_URL, SCLuserName,SCLpassword);
	        
	        String SEC_URL = "jdbc:mysql://10.1.101.52:3306/sec_schema";
	        String SECuserName = "root";
	        String SECpassword = "root";
	        
	        getConnection(SEC_URL,SECuserName,SECpassword);
	        
	     }
	        public static Connection getConnection(String url, String username, String password)
	        {
	            Connection connection = null;
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	                System.out.println("This statement Before connection");
	                connection = DriverManager.getConnection(url, username, password);
	                System.out.println("connected to"+url);
	                Statement stmt = null;
	                
	                stmt = connection.createStatement();
	                ResultSet rs = stmt.executeQuery("show variables like '%version%'");
	                String Value = null;
	                String Variable = null;
	                List<String> list=new ArrayList<String>();
	                while (rs.next()) {
	                	 Value= rs.getString("Value");
	                	 Variable=rs.getString("Variable_name");
	                	list.add(Variable+ ":"+Value);

	                }
	               for(String str:list) {
	            	   System.out.println(str);
	               }
	              
	            } catch (SQLException ex) {
	                System.out.println("state " + ex.getSQLState());
	                System.out.println("message " + ex.getMessage());
	                System.out.println("error " + ex.getErrorCode());
	                System.out.println("inside SQL exception");
	                System.out.println("stack trace  " );
	                ex.printStackTrace();
	            }
	            catch (Exception ex) {
	                ex.printStackTrace();
	            }
	            return connection;
	    }

	/*public static void main(String[] args) throws Exception {
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

	}*/

}
