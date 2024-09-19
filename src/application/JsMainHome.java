package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JsMainHome {

    @FXML
    private Button ConsultationForm_bt;

    @FXML
    private Button Content_bt;

    @FXML
    private Button Payment_bt;

    @FXML
    private Button SubmitAssignment_bt;

    @FXML
    private Button back;

    @FXML
    void baclkbutton(javafx.event.ActionEvent event) throws IOException {
        		try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("categories.fxml"));
			        Parent root = (Parent) fxmlLoader.load(); 
			        CourseCategoriesController ctrlrPointer = (CourseCategoriesController) fxmlLoader.getController();
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
    
    public void initialize() {
    
    	ConsultationForm_bt.setOnAction(new EventHandler<ActionEvent>() {
		@Override
        public void handle(ActionEvent event) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JSconsultationForm.fxml"));
		        Parent root = (Parent) fxmlLoader.load(); 
		        JSconsultationFormController ctrlrPointer = (JSconsultationFormController) fxmlLoader.getController();
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
	});
	
	
    Content_bt.setOnAction(new EventHandler<ActionEvent>() {
		@Override
        public void handle(ActionEvent event) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("jscourses.fxml"));
		        Parent root = (Parent) fxmlLoader.load(); 
		        JsCoursesController ctrlrPointer = (JsCoursesController) fxmlLoader.getController();
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
	});
	
	
    Payment_bt.setOnAction(new EventHandler<ActionEvent>() {
		@Override
        public void handle(ActionEvent event) {
			try {
    		    FXMLLoader SceneLoader = new FXMLLoader(getClass().getResource("payment.fxml"));
    	        Parent root = (Parent) SceneLoader.load(); 	    	        
    	        paymentController ctrlrPointer = (paymentController) SceneLoader.getController();
    	        ctrlrPointer.setSourcePage("Js");
    	        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        currentStage.close();
		        Scene scene = new Scene(root);
		        Stage stage=new Stage();
    	        stage.setScene(scene);
    	        stage.show();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		}
	});

    SubmitAssignment_bt.setOnAction(new EventHandler<ActionEvent>() {
		@Override
        public void handle(ActionEvent event) {
			try {
    		    FXMLLoader SceneLoader = new FXMLLoader(getClass().getResource("submitAssignment.fxml"));
    	        Parent root = (Parent) SceneLoader.load(); 
    	        
    	        submitAssignmentController ctrlrPointer = (submitAssignmentController) SceneLoader.getController();
    	        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        currentStage.close();
		        Scene scene = new Scene(root);
		        Stage stage=new Stage();
		        
    	        stage.setScene(scene);
    	        stage.show();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		}
	});
    
	}

    
}
