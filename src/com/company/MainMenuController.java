package com.company;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MainMenuController {
    @FXML
    private Button manageEmpButton;

    @FXML
    private Button receiveButton;

    @FXML
    private Button regEmpButton;

    @FXML
    private Button createProjectButton;

    @FXML
    private Button changprojectButton;

    @FXML
    void initialize() throws SQLException {
        Config config = new Config();
        Connection connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());
        regEmpButton.setOnAction(event -> {
            Stage oldstage = (Stage) regEmpButton.getScene().getWindow();
            oldstage.hide();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("reg.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Registration");
                stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        manageEmpButton.setOnAction(event -> {
            Stage oldstage = (Stage) manageEmpButton.getScene().getWindow();
            oldstage.hide();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("empTransfer.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Change department");
                stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        createProjectButton.setOnAction(event -> {
            Stage oldstage = (Stage) createProjectButton.getScene().getWindow();
            oldstage.hide();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("createProject.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Create new project");
                stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        changprojectButton.setOnAction(event -> {
            Stage oldstage = (Stage) changprojectButton.getScene().getWindow();
            oldstage.hide();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("changeProject.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Change project");
                stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        receiveButton.setOnAction(event -> {
            Stage oldstage = (Stage) changprojectButton.getScene().getWindow();
            oldstage.hide();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("view.fxml"));
                Stage stage = new Stage();
                stage.setTitle("View data");
                stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
