package application;

import javafx.scene.Node;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class JsCoursesController {
    @FXML
    private Button watchjsvid;
    @FXML
    private Button watchjsplaylist;
    @FXML
    private Button back;
    @FXML
    void baclkbutton(javafx.event.ActionEvent event) throws IOException {
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
    

    public void watchjsvidclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("jswebview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 532);
        Stage jswebview = new Stage();
        jswebview.setScene(scene);
        jswebview.show();

        Stage currentStage = (Stage) watchjsvid.getScene().getWindow();
        currentStage.close();
    }

    public void watchjsplaylistclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("jswebview2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 532);
        Stage jswebview = new Stage();
        jswebview.setScene(scene);
        jswebview.show();

        Stage currentStage = (Stage) watchjsplaylist.getScene().getWindow();
        currentStage.close();
    }
}
