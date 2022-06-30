package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ViewMenuController {


    @FXML
    private Button downloadEmpButton;

    @FXML
    private ComboBox<String> employeesBox;

    @FXML
    private ComboBox<String> projectBox;

    @FXML
    private Button downloadPrjButton;

    @FXML
    private Button goBackButton;

    @FXML
    void initialize() {
        goBackButton.setOnAction(event -> {
            Stage oldStage = (Stage) goBackButton.getScene().getWindow();
            oldStage.hide();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Data view");
                stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        downloadEmpButton.setOnAction(event -> {
            ObservableList<String> listToComboBox = FXCollections.observableArrayList(PickEmployees());
            employeesBox.setValue("Сотрудники");
            employeesBox.setItems(listToComboBox);
        });
        downloadPrjButton.setOnAction(event-> {
            ObservableList<String> listToComboBox2 = FXCollections.observableArrayList(PickProjects());
            projectBox.setValue("Проекты");
            projectBox.setItems(listToComboBox2);

        });

    }

    public ArrayList<String> PickProjects() {
        Config config = new Config();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from projects";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet word = preparedStatement.executeQuery();
            ArrayList<String> list2 = new ArrayList<String>();
            String arrId = null;
            String arrName = null;
            String arrSurname = null;
            String arrEducation = null;
            String arrDepartment = null;
            String arrOperation = null;


            while (word.next()) {
                String em = word.getString("convrprojid");
                arrId = em.replace("\n", ",");

                String em1 = word.getString("projname");
                arrName = em1.replace("\n", ",");

                String em2 = word.getString("projectdescription");
                arrSurname = em2.replace("\n", ",");

                String em3 = word.getString("stage");
                arrEducation = em3.replace("\n", ",");

                String em4 = word.getString("projecttype");
                arrDepartment = em4.replace("\n", ",");

                String em5 = word.getString("projdeadline");
                arrOperation = em5.replace("\n", ",");

                list2.add(arrName.trim() + " " + arrSurname + " " + arrEducation + " "
                        + arrDepartment + " " + arrOperation);


            }
            return list2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> PickEmployees() {
        Config config = new Config();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from emps";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet word = preparedStatement.executeQuery();
            ArrayList<String> list = new ArrayList<String>();
            String arrName = null;
            String arrSurname = null;
            String arrEducation = null;
            String arrDepartment = null;
            String arrOperation = null;


            while (word.next()) {

                String em1 = word.getString("name");
                arrName = em1.replace("\n", ",");

                String em2 = word.getString("surname");
                arrSurname = em2.replace("\n", ",");

                String em3 = word.getString("education");
                arrEducation = em3.replace("\n", ",");

                String em4 = word.getString("department");
                arrDepartment = em4.replace("\n", ",");

                String em5 = word.getString("operation");
                arrOperation = em5.replace("\n", ",");

                list.add(arrName.trim() + " " + arrSurname + " " + arrEducation + " "
                        + arrDepartment + " " + arrOperation);


            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
