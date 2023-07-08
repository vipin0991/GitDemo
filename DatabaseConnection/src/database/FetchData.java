package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchData {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/openshop","root","root");
		System.out.println("Driver JDBC loaded!");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from oc_user where user_id = \"1\";");
		while(rs.next()) {
			System.out.println(rs.getString("firstname"));
			System.out.println(rs.getString("lastname"));
		}
		con.close();
	}

}
