package application;

import application.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class loginService {

    public String validateLogin(String username, String password) {
        DatabaseConnection connectNow = new DatabaseConnection();
        String verifyStudentLogin = "SELECT count(1) FROM students WHERE name = ? AND password = ?";
        String verifyTeacherLogin = "SELECT count(1) FROM instructor WHERE name = ? AND password = ?";

        try (Connection connectDB = connectNow.getDatabaseConnection();
             PreparedStatement studentStatement = connectDB.prepareStatement(verifyStudentLogin);
             PreparedStatement teacherStatement = connectDB.prepareStatement(verifyTeacherLogin)) {

            studentStatement.setString(1, username);
            studentStatement.setString(2, password);
            ResultSet studentResult = studentStatement.executeQuery();

            teacherStatement.setString(1, username);
            teacherStatement.setString(2, password);
            ResultSet teacherResult = teacherStatement.executeQuery();

            if (studentResult.next()) {
                int studentCount = studentResult.getInt(1);
                if (studentCount == 1) {
                    return "STUDENT LOGIN SUCCESSFUL";
                }
            }

            if (teacherResult.next()) {
                int teacherCount = teacherResult.getInt(1);
                if (teacherCount == 1) {
                    return "TEACHER LOGIN SUCCESSFUL";
                }
            }

            return "LOGIN FAILED";
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred. Please try again later.";
        }
    }
}
