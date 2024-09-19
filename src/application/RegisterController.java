package application;


import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import application.registerService;

public class RegisterController {
    @FXML
    private Button backButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label labelField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField usernameField;
    @FXML
    private RadioButton teacherOption;
    @FXML
    private RadioButton studentOption;

    private registerService regService = new registerService();

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 458);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) labelField.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void registerButtonClicked(ActionEvent event) {
        if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            labelField.setText("PASSWORDS DON'T MATCH");
            return;
        }

        try {
            boolean isRegistered = false;
            if (studentOption.isSelected()) {
                isRegistered = regService.registerStudent(usernameField.getText(), passwordField.getText());
            } else if (teacherOption.isSelected()) {
                isRegistered = regService.registerTeacher(usernameField.getText(), passwordField.getText());
            } else {
                labelField.setText("Please select either Student or Teacher.");
                return;
            }

            if (isRegistered) {
                labelField.setText("REGISTERED SUCCESSFULLY");
            } else {
                labelField.setText("USERNAME ALREADY IN USE. PLEASE CHOOSE A DIFFERENT ONE");
            }
            
            if (studentOption.isSelected()) {
            	StudentHomePage(event);
            }
            else {
            	InstructorHomePage(event);
            }
            
        } catch (Exception e) {
            labelField.setText(e.getMessage());
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
