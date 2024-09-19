package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class cppconsultationFormController {

    @FXML
    private TextField Topic_tb;

    @FXML
    private AnchorPane backanachor;

    @FXML
    private DatePicker date_dp;

    @FXML
    private AnchorPane frontanchor;

    @FXML
    private TextField stdID_tb;

    @FXML
    private TextField stdName_tb;

    @FXML
    private Button submit_bt1;

    @FXML
    private ComboBox<String> time_cb;
    
    @FXML
    private Label notify;
    
    @FXML
    private ImageView imageview;
    
    @FXML
    private Button back;
    
    consultationFormService service = new consultationFormService();
    
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
    
    @FXML
    public void initialize() {
    	Image myImage = new Image(getClass().getResourceAsStream("cpplightblue.jpg"));
    	imageview.setImage(myImage);
		
    	
    	time_cb.getItems().addAll("3:00 pm", "3:15 pm", "3:30 pm","3:45 pm"); 
    	
    	submit_bt1.setOnAction(new EventHandler <ActionEvent>() {
    		@Override
            public void handle(ActionEvent event) {
    			String date="";
    			if (date_dp.getValue() != null) {
                   date = date_dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }
    			
    			String time="";
    			if (time_cb.getValue() != null) {
                    time = time_cb.getValue();
                }
    			
    			Boolean flag=false;
    	          
    	    	if(Topic_tb.getText().isEmpty() || stdID_tb.getText().isEmpty() || stdName_tb.getText().isEmpty() || date.isEmpty() || time.isEmpty()) {
    	    		notify.setText("(Please fill in the required information!!)");
    	        	  flag=true;
    	          }
    	          else {
    	        	  notify.setText("");
    	        	  flag=false;
    	          }
    		    
    	    	if(flag==false) {
    	    		String name,date2,time2,topic;
    	    		int id;
    	    		id=Integer.parseInt(stdID_tb.getText());
    	    		name=stdName_tb.getText();
    	    		date2=date_dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	    		time2 = time_cb.getValue();
    	    		topic=Topic_tb.getText();
    	    		
    	    		addConsultationForm(id,name,date2,time2,topic);
    	    		
    	    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    	        	alert.setTitle("Submission Successful");
    	        	alert.setHeaderText(null);
    	        	alert.setContentText("Consultation request submitted successfully!!!!");
    	        	alert.showAndWait();
    	        	
    	        	Topic_tb.clear();
    	        	stdName_tb.clear();
    	        	stdID_tb.clear();
    	        	date_dp.setValue(null);
    	        	time_cb.setValue(null);
    	    	}
    	    	else {
    	    		
    	    	}
    			
    		}
    		
    	});

    }
    
    public void addConsultationForm(int sid,String sname,String date2,String time2,String topic) {
    	int instructorid=0;
    	try {
    		Statement mystmt = null;
    		ResultSet myRs = null;
    		Connection myconn = null;
    		
    	    String url = "jdbc:mysql://localhost:3306/sdaproject";
    	    String username = "root";
    	    String password = "kashaf72152322.";
    		
    		myconn = DriverManager.getConnection(url, username, password);
    	    mystmt = myconn.createStatement();	
		    myRs=mystmt.executeQuery("Select instructor_id from courses where cname='C++'");
		    if (myRs.next()) {  
	            instructorid = myRs.getInt("instructor_id");
	        }
		    }
    			catch (Exception e) {
    	            e.printStackTrace();
    	        }

    	
    	service.consultationReqSubmission(sid,sname,date2,time2,topic,instructorid,"C++");
    	return;
    }
    
    
}
