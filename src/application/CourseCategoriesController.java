package application;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;

public class CourseCategoriesController {
    @FXML
    private Button cppcourses;
    @FXML
    private Button pycourses;
    @FXML
    private Button jscourses;

    @FXML
    private Button back;

    public void cppbuttonclicked(javafx.event.ActionEvent event) throws IOException {
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

    public void pybuttonclicked(javafx.event.ActionEvent event) throws IOException {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pythonMainHomePage.fxml"));
	        Parent root = (Parent) fxmlLoader.load(); 
	        pythonMainHome ctrlrPointer = (pythonMainHome) fxmlLoader.getController();
	        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        currentStage.close();
	        Scene scene = new Scene(root);
	        Stage stage=new Stage();
	        stage.setTitle("Learncademy");
	        stage.setScene(scene);
	        stage.show();
	}catch(Exception e) {
		e.printStackTrace();
	}    }

    public void jsbuttonclicked(javafx.event.ActionEvent event) throws IOException {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JsMainHomePage.fxml"));
	        Parent root = (Parent) fxmlLoader.load(); 
	        JsMainHome ctrlrPointer = (JsMainHome) fxmlLoader.getController();
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