package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InstructorHomePageController  {


    @FXML
    private Button mark_bt;
	
    @FXML
    private Button Signout_bt;

    @FXML
    private Button categories_bt;

    @FXML
    private Button ranking_bt;

    @FXML
    private Button search_bt;

    public void initialize() {
		
    	mark_bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("markAssignment.fxml"));
			        Parent root = (Parent) fxmlLoader.load(); 
			        markAssignmentController ctrlrPointer = (markAssignmentController) fxmlLoader.getController();
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
		
		
        Signout_bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			        Parent root = (Parent) fxmlLoader.load(); 
			        LoginController ctrlrPointer = (LoginController) fxmlLoader.getController();
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
		
		
        search_bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search.fxml"));
			        Parent root = (Parent) fxmlLoader.load(); 
			        courseSearchService ctrlrPointer = (courseSearchService) fxmlLoader.getController();
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
		
		
        ranking_bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				try {
	    		    FXMLLoader SceneLoader = new FXMLLoader(getClass().getResource("viewranking.fxml"));
	    	        Parent root = (Parent) SceneLoader.load(); 	    	        
	    	        viewrankingController ctrlrPointer = (viewrankingController) SceneLoader.getController();
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

        categories_bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				try {
	    		    FXMLLoader SceneLoader = new FXMLLoader(getClass().getResource("categories.fxml"));
	    	        Parent root = (Parent) SceneLoader.load(); 
	    	        
	    	        CourseCategoriesController ctrlrPointer = (CourseCategoriesController) SceneLoader.getController();
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
