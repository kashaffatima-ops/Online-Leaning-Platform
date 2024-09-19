package application;


import application.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class registerService {

    public boolean registerStudent(String username, String password) throws Exception {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDatabaseConnection();
        
		int cid=1;
	Statement mystmt = null;
	ResultSet myRs = null;
	Connection myconn = null;
	PreparedStatement pstmt = null;
	
    String url = "jdbc:mysql://localhost:3306/sdaproject";
    String username1 = "root";
    String password1 = "kashaf72152322.";
	
	myconn = DriverManager.getConnection(url, username1, password1);
    mystmt = myconn.createStatement();	
    
        myRs = mystmt.executeQuery("SELECT MAX(id) AS maxCID FROM students");
 	   
    	if (myRs.next()) {  
    		cid = myRs.getInt("maxCID") + 1;
    	}
        
        String insertUserSql = "INSERT INTO students (id,name, password) VALUES (?,?, ?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertUserSql)) {
        	preparedStatement.setInt(1, cid);
        	preparedStatement.setString(2, username);
            preparedStatement.setString(3, password); // Consider hashing the password here
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) { // Check for SQL state for duplicate entry
                return false;
            }
            throw e; // Re-throw the exception if it is not a duplication error
        }
    }

    public boolean registerTeacher(String username, String password) throws Exception {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDatabaseConnection();
        
        int cid=1;
    	Statement mystmt = null;
    	ResultSet myRs = null;
    	Connection myconn = null;
    	PreparedStatement pstmt = null;
    	
        String url = "jdbc:mysql://localhost:3306/sdaproject";
        String username1 = "root";
        String password1 = "kashaf72152322.";
    	
    	myconn = DriverManager.getConnection(url, username1, password1);
        mystmt = myconn.createStatement();	
        
            myRs = mystmt.executeQuery("SELECT MAX(id) AS maxCID FROM students");
     	   
        	if (myRs.next()) {  
        		cid = myRs.getInt("maxCID") + 1;
        	}

        
        String insertUserSql = "INSERT INTO instructor (id,name, password) VALUES (?,?, ?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertUserSql)) {
        	preparedStatement.setInt(1, cid);
        	preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            // Consider hashing the password here
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) { 
                return false;
            }
            throw e; 
        }
    }
}

