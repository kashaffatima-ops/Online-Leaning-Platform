package application;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class consultationFormService {
	
	public void consultationReqSubmission(int sid,String sname,String date2,String time2,String topic,int instructorid, String Course) {
		try {
			int cid=1;
	Statement mystmt = null;
	ResultSet myRs = null;
	Connection myconn = null;
	PreparedStatement pstmt = null;
	
    String url = "jdbc:mysql://localhost:3306/sdaproject";
    String username = "root";
    String password = "kashaf72152322.";
	
	myconn = DriverManager.getConnection(url, username, password);
    mystmt = myconn.createStatement();	
    myRs = mystmt.executeQuery("SELECT MAX(cID) AS maxCID FROM consultation");
	   
    
    
    
	if (myRs.next()) {  
		cid = myRs.getInt("maxCID") + 1;
	}
	 String insertSQL = "INSERT INTO consultation (cID, std_id, instructor_id, topic, cdate, ctime, course) VALUES (?, ?, ?, ?, ?, ?, ?)";
     pstmt = myconn.prepareStatement(insertSQL);

     pstmt.setInt(1, cid);
     pstmt.setInt(2, sid);
     pstmt.setInt(3, instructorid);
     pstmt.setString(4, topic);
     pstmt.setDate(5, java.sql.Date.valueOf(date2)); 
     pstmt.setString(6, time2);
     pstmt.setString(7, Course); 

     pstmt.executeUpdate();
	
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
}
