package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateProjectController {
    @FXML
    private TextField prjTypeTxt;

    @FXML
    private TextField prjNameTxt;

    @FXML
    private TextField prjIdTxt;

    @FXML
    private TextField prjStageTxt;

    @FXML
    private TextArea prjDescriptionAreaTxt;

    @FXML
    private TextField prjDeadlineTxt;

    @FXML
    private Button prjcreateButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Label madeUpPrjStatus;

    @FXML
    void initialize() throws SQLException {
        Config config = new Config();
        Connection connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());

        prjcreateButton.setOnAction(event-> {
            String prjName = prjNameTxt.getText().trim();
            String prjStage = prjStageTxt.getText().trim();
            String prjDescription = prjDescriptionAreaTxt.getText().trim();
            String prjDeadline = prjDeadlineTxt.getText().trim(); //here!
            String prjType = prjTypeTxt.getText().trim();
            if (prjType.equals("агрегаты бп") || prjType.equals("приводные преобразователи частоты")) {  //here
                String prjId = String.valueOf(Integer.parseInt(prjIdTxt.getText().trim()));


                String sql = "Insert into projects VALUES (?, ?, ?, ?, ?, ?);";

                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, Integer.parseInt(prjId));
                    preparedStatement.setString(2, prjName);
                    preparedStatement.setString(3, prjDescription);
                    preparedStatement.setString(4, prjStage);
                    preparedStatement.setString(5, prjType);
                    preparedStatement.setString(6, prjDeadline);

                    preparedStatement.executeUpdate();
                    madeUpPrjStatus.setText("Проект создан");

                } catch (SQLException e) {
                    e.printStackTrace();
                    madeUpPrjStatus.setText("Некорректный ввод");
                }
            }
            else madeUpPrjStatus.setText("Введите правильный тип проекта (агрегаты бп или приводные преобразователи частоты)");

        });
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
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
