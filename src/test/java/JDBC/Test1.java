package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	public static void main(String[] args) throws SQLException {

		// This is for connecting to the mysqul database with user name and password.

		/**
		 * URl syntax:- "jdbc:mysql://"+host+":"+port+"/databasename"
		 * 
		 * here:- "host"==> since you running in local machine so localhost "port"==>
		 * since mysql is rinning in 3306 so it will be port "database name"==> my
		 * database name which is there in mysql is qadbt
		 * 
		 * USERNAME:- root is mysql user name
		 * 
		 * PASSWORD:- Password@123 is mysql password
		 * 
		 * 
		 */
		String host = "localhost";
		String port = "3306";
		String databasename = "qadbt";
		String userName = "root";
		String password = "Password@123";

		// Storing the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databasename + "", userName, password);

		// Storing the connection in form statemenet
		Statement statement = connection.createStatement();

		// This is to execute the query by using below method and storing in one variable
		ResultSet resultSet = statement.executeQuery("select * from EXAM_RESULTS where First_Name='GRACE';");

		/**
		 * AllWays note result set will retunt list in fisrt index base data will be
		 * store so use result set variablename . next() function with while it will
		 * help and move to 1 index directly
		 * 
		 * If Not add that one you will get runtime error saying result set exception
		 */

		while (resultSet.next()) {
			System.out.println(resultSet.getString("STUDENT_ID"));
			System.out.println(resultSet.getString("FIRST_NAME"));
			System.out.println(resultSet.getString("LAST_NAME"));
			System.out.println(resultSet.getString("EXAM_ID"));
			System.out.println(resultSet.getString("EXAM_SCORE"));
		}
		/**
		 * Out Put:-11
		 *          GRACE
		 *          BROWN
		 *          1
		 *          78 
		 *          11
		 *          GRACE
		 *          BROWN
		 *          2
		 *          72
		 */
		
		
		/**
		 * It is best and good prctices to close all the resources
		 */
        resultSet.close();
        statement.close();
        connection.close();
	}

}
