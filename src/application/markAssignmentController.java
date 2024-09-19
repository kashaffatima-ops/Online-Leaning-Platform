package application;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class markAssignmentController {
	@FXML
	private TableView<assignments> assigntable;
    @FXML
    private TextField assignid;

    @FXML
    private TableColumn<assignments, Integer> assignmentid;

    @FXML
    private TextField newmarks;

    @FXML
    private Button show_bt;

    @FXML
    private TableColumn<assignments, Integer> studentid;

    @FXML
    private Button submit_bt;
    
    @FXML
    private Button back;

    @FXML
    void baclkbutton(javafx.event.ActionEvent event) throws IOException {
        		try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InstructorHomePage.fxml"));
			        Parent root = (Parent) fxmlLoader.load(); 
			        InstructorHomePageController ctrlrPointer = (InstructorHomePageController) fxmlLoader.getController();
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
    public void initialize() {
        assignmentid.setCellValueFactory(new PropertyValueFactory<>("assign_id"));
        studentid.setCellValueFactory(new PropertyValueFactory<>("stuid"));

    }

    @FXML
    void showassignments(ActionEvent event) {
     try {
    	 String url = "jdbc:mysql://localhost:3306/sdaproject";
         String username = "root";
         String password = "kashaf72152322.";
         
         Connection myconn = null;
 		  java.sql.Statement mystmt = null;
 		  ResultSet myRs = null;
 		 
 		  
 		 
         myconn = DriverManager.getConnection(url, username, password);


         System.out.println("Connected Successfully");
		  mystmt = myconn.createStatement();
		  
		 
		  String sql = "select assign_id , stuid  from assignments;";

		  
          myRs =mystmt.executeQuery(sql);
          ObservableList<assignments> assign = FXCollections.observableArrayList();
          myRs.next();
          while (myRs.next()) {
              assignments ass = new assignments(myRs.getInt("assign_id"), myRs.getInt("stuid"));
              assign.add(ass);
          }

          assigntable.setItems(assign);
        

		  
    	}catch (Exception exc) {
			exc.printStackTrace();
		}
    	
    }

    @FXML
    void submitmarks(ActionEvent event) {
    	 try {
	       	 String url = "jdbc:mysql://localhost:3306/sdaproject";
	            String username = "root";
	            String password = "kashaf72152322.";
	            
	            Connection myconn = null;
	    		  java.sql.Statement mystmt = null;
	    		  ResultSet myRs = null;
	    		  int stuid;
	    		  int assigid=0;
	    		  int mark=0;
	    		  assigid = Integer.parseInt(assignid.getText());
	    		  mark = Integer.parseInt(newmarks.getText());
	    		 
	            myconn = DriverManager.getConnection(url, username, password);
	          System.out.println("Connected Successfully");
	   		  mystmt = myconn.createStatement();
	   		  
	   		 String sql1 = "select stuid from assignments where assign_id = ?";
	         String sql = "Insert Into marked_assignments(assign_id, stuid, marks) Values (?, ?, ?)";

	         PreparedStatement prep1 = myconn.prepareStatement(sql1);
	         prep1.setInt(1, assigid);
	         myRs = prep1.executeQuery();
	         stuid = 0;
	         if (myRs.next()) {
	             stuid = myRs.getInt("stuid");
	         }

	         PreparedStatement prep = myconn.prepareStatement(sql);
	         prep.setInt(1, assigid);
	         prep.setInt(2, stuid);
	         prep.setInt(3, mark);
	         prep.executeUpdate();
	    	}catch (Exception exc) {
	   			exc.printStackTrace();
	   		}
    }

}
