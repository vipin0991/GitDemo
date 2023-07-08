package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCsv {

	public static void main(String[] args) throws IOException, SQLException {
		String line = ""; 
		String[] employee;
		int row = 0;
		// TODO Auto-generated method stub
		
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/openshop","root","root");
		System.out.println("Driver JDBC loaded!");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from oc_user where user_id = \"1\";");
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\Selenium\\workspace\\ExcelDriven\\TestData.csv"));
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{   
			employee = line.split(","); 
			if(row==2) {
                if (rs.next()) {
                    // Retrieve the data from the database row
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");

                    // Compare CSV data with database data
                    if (employee[0].equals(firstname)) {
                        System.out.println("Data matches!");
                    } else {
                        System.out.println("Data does not match!");
                    }
                }
			//System.out.println(employee[0] + " " + employee[1] +" "+employee[2]);  
			}
			row++;
		}
		//System.out.println(ar.length);
		}  
}

