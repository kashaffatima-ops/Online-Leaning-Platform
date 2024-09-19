package application;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class viewrankingController {
	  
	 @FXML
	    private TableColumn<ranks, Integer> id;

	    @FXML
	    private TableColumn<ranks, Integer> mark;

	    @FXML
	    private TableView<ranks> ranktable;
	    
	    @FXML
	    private Button back;

	    @FXML
	    public void initialize() {
	        id.setCellValueFactory(new PropertyValueFactory<>("stuid"));
	        mark.setCellValueFactory(new PropertyValueFactory<>("marks"));

	    }
	

    @FXML
    private Button view_bt;

    @FXML
    void viewrank(ActionEvent event) {
    	try {


            String url = "jdbc:mysql://localhost:3306/sdaproject";
            String username = "root";
            String password = "kashaf72152322.";
            
            Connection myconn = null;
    		  java.sql.Statement mystmt = null;
    		  ResultSet myRs = null;
    		  String title;
    		  String author;
    		  
    		 
            myconn = DriverManager.getConnection(url, username, password);


            System.out.println("Connected Successfully");
   		  mystmt = myconn.createStatement();
   		  
   		 
   		  String sql = "select stuid , sum(marks) as marks from marked_assignments group by stuid;";

   		 	   
             myRs =mystmt.executeQuery(sql);
             ObservableList<ranks> rank = FXCollections.observableArrayList();

             while (myRs.next()) {
                 ranks ra = new ranks(myRs.getInt("stuid"), myRs.getInt("marks"));
                 rank.add(ra);
             }

             ranktable.setItems(rank);
           

   		  
       	}catch (Exception exc) {
   			exc.printStackTrace();
   		}
    }
    
    @FXML
    void baclkbutton(javafx.event.ActionEvent event) throws IOException {
        		try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StudentHomePage.fxml"));
			        Parent root = (Parent) fxmlLoader.load(); 
			        StudentHomePageController ctrlrPointer = (StudentHomePageController) fxmlLoader.getController();
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

}