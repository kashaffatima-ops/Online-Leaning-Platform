package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class paymentService {
	
	
	public Integer checkPrice(String course) {
		Integer p=0;
		try {
	Statement mystmt = null;
	ResultSet myRs = null;
	Connection myconn = null;
	PreparedStatement pstmt = null;
	
    String url = "jdbc:mysql://localhost:3306/sdaproject";
    String username = "root";
    String password = "kashaf72152322.";
	
	myconn = DriverManager.getConnection(url, username, password);
    mystmt = myconn.createStatement();	
    String insertSQL1 = "SELECT price FROM courses where cname=?";
    pstmt = myconn.prepareStatement(insertSQL1);
    pstmt.setString(1, course);
    myRs = pstmt.executeQuery();
    
    if (myRs.next())
	p= myRs.getInt("price"); 
    
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	
	return p;
	}
	
	public void insertPaymentinDatabase(int stdid,String stdname,String bankno,String mail,String sourcePage,Integer priceOfCourse) {
		
		Integer cid=0;
		String currentDate = LocalDate.now().toString();
		try {
	Statement mystmt = null;
	ResultSet myRs = null;
	Connection myconn = null;
	PreparedStatement pstmt = null;
	
    String url = "jdbc:mysql://localhost:3306/sdaproject";
    String username = "root";
    String password = "kashaf72152322.";
	
	myconn = DriverManager.getConnection(url, username, password);
    mystmt = myconn.createStatement();	
    String insertSQL1 = "SELECT cid FROM courses where cname=?";
    pstmt = myconn.prepareStatement(insertSQL1);
    pstmt.setString(1, sourcePage);
    myRs = pstmt.executeQuery();
    
    if (myRs.next())
	cid= myRs.getInt("cid"); 
    
    int pid=1;
    myRs = mystmt.executeQuery("SELECT MAX(payment_id) AS maxPID FROM payment");
	   
	if (myRs.next()) {  
		pid = myRs.getInt("maxPID") + 1;
	}
    
    insertSQL1="INSERT INTO payment (payment_id, student_id, email, accountNo, course_id, amount, payment_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    pstmt = myconn.prepareStatement(insertSQL1);

    pstmt.setInt(1, pid);
    pstmt.setInt(2, stdid);
    pstmt.setString(3, mail);
    pstmt.setString(4, bankno);
    pstmt.setInt(5, cid);
    pstmt.setInt(6, priceOfCourse);
    pstmt.setString(7, currentDate);

    pstmt.executeUpdate();

		}
		catch (Exception e) {
            e.printStackTrace();
        }
	
	}
	
}
