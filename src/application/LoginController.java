package application;



import application.DatabaseConnection;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.loginService;
import javafx.scene.Node;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    @FXML
    private TextField UsernameTextField;
    @FXML
    private TextField PasswordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerPageButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;

    private loginService logService = new loginService();
    

    @FXML
    public void cancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void loginButtonClicked(ActionEvent event) {
       if(!UsernameTextField.getText().isBlank() || !PasswordTextField.getText().isBlank()) {
           String result = logService.validateLogin(UsernameTextField.getText(), PasswordTextField.getText());
           loginMessageLabel.setText(result);
           
           if(result=="STUDENT LOGIN SUCCESSFUL") {
        	   StudentHomePage(event);
           }else {
        	   InstructorHomePage(event);
           }
           
           
       }else{
           loginMessageLabel.setText("Please fill in required data!!");
       }
    }

    public void registerButtonClicked(ActionEvent event){
        
    	try{
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
            Parent root = (Parent) fxmlLoader.load(); 
            RegisterController ctrlrPointer = (RegisterController) fxmlLoader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Learncademy");
            stage.setScene(scene);
            stage.show();
        	}catch(Exception e){
                e.printStackTrace();
                e.getCause();
            }
    	
    	    }

    public void StudentHomePage(ActionEvent event) {
    	try{
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
    	}catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    
    public void InstructorHomePage(ActionEvent event) {
    	try{
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
        	}catch(Exception e){
                e.printStackTrace();
                e.getCause();
            }
    }

}