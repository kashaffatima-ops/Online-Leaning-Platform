package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
public class courseSearchService implements Initializable {

    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Employee> tableview;
    @FXML private TableColumn<Employee, String> EmpID;
    @FXML private TableColumn<Employee, String> empName;

    @FXML
    private Button back;

    private final ObservableList<Employee> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        EmpID.setCellValueFactory(new PropertyValueFactory<>("EmpID"));
        empName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        Employee emp1 = new Employee(1, "C++");
        Employee emp2 = new Employee(2, "Python");
        Employee emp3 = new Employee(3, "Js");

        dataList.addAll(emp1,emp2, emp3);

        FilteredList<Employee> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
       
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (employee.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; 
                }
                else
                    return false; 
            });
        });

        SortedList<Employee> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        tableview.setItems(sortedData);

        back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
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
		});
		

    }

}

