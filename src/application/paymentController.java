package application;

import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class paymentController {

    @FXML
    private TextField bankNo_tb;

    @FXML
    private Button cancel_bt;

    @FXML
    private Button confirm_bt1;

    @FXML
    private Label courseName_lbl;

    @FXML
    private TextField email_tb;

    @FXML
    private Label notify;

    @FXML
    private Label price_lbl;

    @FXML
    private TextField stdID_tb;

    @FXML
    private TextField stdName_tb;
    
    @FXML
    private Label notifyAccount_lbl;

    @FXML
    private Label notifyEmail_lbl;

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
    
    
    private String sourcePage;

    public void setSourcePage(String sourcePage) {
        this.sourcePage = sourcePage;
        initializewith();
    }

    public String getSourcePage() {
        return sourcePage;
    }

    paymentService service=new paymentService();
    
    @FXML
    public void initializewith() {
    	Integer priceOfCourse=service.checkPrice(sourcePage);
    	courseName_lbl.setText(sourcePage);
    	price_lbl.setText("RS "+priceOfCourse.toString()+".0");
    	
    	confirm_bt1.setOnAction(new EventHandler <ActionEvent>() {
    		@Override
            public void handle(ActionEvent event) {
    			
    			String email = email_tb.getText();
    			Boolean Echeck=true;
    	        if (email == null || !email.contains("@")) {
    	        	notifyEmail_lbl.setText("Enter valid email!");
    	        	Echeck=false;
    	        }else {
    	        	notifyEmail_lbl.setText("");
    	        }
    	        
    	        String bankNumber = bankNo_tb.getText();
    	        Boolean Acheck=true;
    	        if (!bankNumber.matches("\\d{16}")) {
    	            notifyAccount_lbl.setText("Should contain 16 digits");
    	            Acheck=false;
    	        }else {
    	        	notifyAccount_lbl.setText("");
    	        }
    		
    	        Boolean flag=false;
  	          
    	    	if(stdID_tb.getText().isEmpty() || stdName_tb.getText().isEmpty() || email_tb.getText().isEmpty() || bankNo_tb.getText().isEmpty() || Acheck==false || Echeck==false) {
    	    		notify.setText("(Please fill in the required information!!)");
    	        	  flag=true;
    	          }
    	          else {
    	        	  notify.setText("");
    	        	  flag=false;
    	          }
    		    
    	    	if(flag==false) {
    	    		String stdname,bankno,mail;
    	    		int stdid;
    	    		stdid=Integer.parseInt(stdID_tb.getText());
    	    		stdname=stdName_tb.getText();
    	    		mail=email_tb.getText();
    	    		bankno=bankNo_tb.getText();
    	    		
    	    		service.insertPaymentinDatabase(stdid,stdname,bankno,mail,sourcePage,priceOfCourse);
    	    		
    	    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    	        	alert.setTitle("Payment Successful");
    	        	alert.setHeaderText(null);
    	        	alert.setContentText("Payment successfull!!!!\n\n"+ "Details:\n\n" + "\tStudent name: "+ stdname + "\n\tStudent ID: "+ stdid+"\n\tEmail: "+ mail+ "\n\tBank Account no.: "+ bankno+ "\n\tAmount: "+ priceOfCourse+ "\n\tCourse name: "+ sourcePage +"\n\tDate of payemnt: "+ LocalDate.now().toString());
    	        	alert.showAndWait();
    	        	
    	        	email_tb.clear();
    	        	stdName_tb.clear();
    	        	stdID_tb.clear();
    	        	bankNo_tb.clear();
    	        	price_lbl.setText("");
    	        	courseName_lbl.setText("");
    	    	}
    	    	
    	        
    		}
    		
    	});
    }
    
}
