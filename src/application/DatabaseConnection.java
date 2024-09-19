package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseConnection;

    public Connection getDatabaseConnection() {
        String databaseName = "sdaproject";
        String databaseUser = "root";
        String databasePassword = "kashaf72152322.";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;
        try{
            databaseConnection = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseConnection;
    }
}
