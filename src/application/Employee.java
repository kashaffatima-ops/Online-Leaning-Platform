package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Cool IT help
 */
public class Employee {
    private  final SimpleIntegerProperty EmpID;
    private  final SimpleStringProperty firstName;

    Employee(Integer id, String firstname)
    {
        this.EmpID = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstname);
    }


    public int getEmpID() {
        return EmpID.get();
    }

    public void setEmpID(int id) {
        this.EmpID.set(id);
    }



    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstname) {
        firstName.set(firstname);
    }




}


