package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class submitAssignmentController {
	@FXML
	private TextField filepath;
	@FXML
	private TextField newfile;
    @FXML
    private Button submit_bt;
    @FXML
    private Label output_text;
    @FXML
    private Button back;
    @FXML
    void baclkbutton(javafx.event.ActionEvent event) throws IOException {
        		try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cppMainHomePage.fxml"));
			        Parent root = (Parent) fxmlLoader.load(); 
			        cppMainHome ctrlrPointer = (cppMainHome) fxmlLoader.getController();
			        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			        currentStage.close();
			        Scene scene = new Scene(root);
			        Stage stage=new Stage();
			        stage.setTitle("Learncademy");
			        stage.setScene(scene);
			        stage.show();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
    }
    
    @FXML
    void submit_assignment(ActionEvent event) {
    	String file = filepath.getText();
    	String outfile = newfile.getText();
    	
    	 String inputFilePath = file+".txt";
	        String outputFilePath = outfile+".txt";

	        try  {

	        	BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
		        String content="";    
	            String line;
		            while ((line = reader.readLine()) != null) {
		                content=content+line; 
		            }
		            writer.write(content);
	                writer.close();
		            output_text.setText("submitted successfully");
		        } catch (IOException e) {
		        	output_text.setText("ERROR: while accessing file");
		        	e.printStackTrace();
		        }
	        
	        //database insertion
	        try {
	       	 String url = "jdbc:mysql://localhost:3306/sdaproject";
	            String username = "root";
	            String password = "kashaf72152322.";
	            
	            Connection myconn = null;
	    		  java.sql.Statement mystmt = null;
	    		  ResultSet myRs = null;
	    		  int stuid=0;
	    		  
	    		  
	    		 
	            myconn = DriverManager.getConnection(url, username, password);


	            System.out.println("Connected Successfully");
	   		  mystmt = myconn.createStatement();
	   		  
	   		  String sql1 = "select userid from currentuser Order By currid DESC limit 1;";
	   		  String sql = "Insert Into Assignments(stuid,status) Values (?, 'unmarked');";

	   		 myRs =mystmt.executeQuery(sql1);
	   		  
	   		 if(myRs.next())
	   		 stuid = myRs.getInt("userid");
	   		 
	   		  PreparedStatement prep = myconn.prepareStatement(sql);
	   		  int i=1;
	   		  
	   			    prep.setInt(1, stuid); 
	   			   
	             prep.executeUpdate();
	    	}catch (Exception exc) {
	   			exc.printStackTrace();
	   		}
    }

}
