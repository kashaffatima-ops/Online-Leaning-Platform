package application;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class CppCoursesController {
    @FXML
    private Button watchcppvideo;
    @FXML
    private Button watchcppplaylist;

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
    
    
    public void cppvidclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cppwebview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 532);
        Stage cppwebview = new Stage();
        cppwebview.setScene(scene);
        cppwebview.show();
    }

    public void watchcppplaylistclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cppwebview2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 532);
        Stage cppwebview2 = new Stage();
        cppwebview2.setScene(scene);
        cppwebview2.show();
        
        Stage currentStage = (Stage) watchcppplaylist.getScene().getWindow();
        currentStage.close();
    }
}