package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class ChangeEmployerController {



    @FXML
    private ComboBox<String> selectEmpComboBox;

    @FXML
    private TextField depToChangeTxtField;

    @FXML
    private Button transferButton;

    @FXML
    private Label transferstatus;

    @FXML
    private Button goBackButton;

    @FXML
    private Button downloadDataButton;


    @FXML
    void initialize() throws SQLException {
        Config config = new Config();
        Connection connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());
        goBackButton.setOnAction(event -> {
            Stage oldStage = (Stage) goBackButton.getScene().getWindow();
            oldStage.hide();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Menu");
                stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        downloadDataButton.setOnAction(event-> {

            ObservableList<String> newlistchoose = FXCollections.observableArrayList(PickEmployees());
            selectEmpComboBox.setValue("Menu");
            selectEmpComboBox.setItems(newlistchoose);

        });
        transferButton.setOnAction(event-> {

            String sql = "UPDATE employees SET department = ? WHERE empid = ?;";
            String dep = depToChangeTxtField.getText().trim();
            String id = String.valueOf(1);

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, dep);
                preparedStatement.setInt(2, Integer.parseInt(id));
                preparedStatement.executeUpdate();
                transferstatus.setText("Сотрудник переведен");

            } catch (SQLException e) {
                e.printStackTrace();
                transferstatus.setText("Некорректный ввод");
            }

        });

    }
    public ArrayList<String> PickEmployees(){
        Config config = new Config();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select name, surname from employees";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet word = preparedStatement.executeQuery();
            ArrayList<String> list = new ArrayList<String>();
            String arr = null;

            while (word.next()) {
                String em = word.getString("name");
                arr = em.replace("\n", ",");
                list.add(arr.trim());

            }
            return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
