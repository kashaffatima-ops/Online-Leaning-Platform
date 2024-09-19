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

public class PyCoursesController {
    @FXML
    private Button watchpyvid;
    @FXML
    private Button watchpyplaylist;
    @FXML
    private Button back;
    @FXML
    void baclkbutton(javafx.event.ActionEvent event) throws IOException {
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
	    	}
			
    }


    public void pyvidclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pywebview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 532);
        Stage pywebview = new Stage();
        pywebview.setScene(scene);
        pywebview.show();

        Stage currentStage = (Stage) watchpyvid.getScene().getWindow();
        currentStage.close();
    }

    public void watchpyplaylistclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pywebview2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 532);
        Stage pywebview2 = new Stage();
        pywebview2.setScene(scene);
        pywebview2.show();

        Stage currentStage = (Stage) watchpyplaylist.getScene().getWindow();
        currentStage.close();
    }
}