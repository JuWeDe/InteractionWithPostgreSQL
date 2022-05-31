package com.company;

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

import java.io.IOException;

public class ChangeProjectController {

    @FXML
    private Button goBackButton;

    @FXML
    private Button changePrjButton;

    @FXML
    private TextField changePrjNameTxt;

    @FXML
    private TextField CHANGINGprjIdTxt;

    @FXML
    private TextField addPrjStageTxt;

    @FXML
    private TextArea changePrjDescriptionAreaTxt;

    @FXML
    private TextField changePrjDeadlineTxt;

    @FXML
    private Button changeStdButton;

    @FXML
    private Label changePrjStatus;

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
        changePrjButton.setOnAction(event-> {
            String prjName = changePrjNameTxt.getText().trim();
            String prjDescription = changePrjDescriptionAreaTxt.getText().trim();
            String prjDeadline = changePrjDeadlineTxt.getText().trim(); //here!

            String prjId = String.valueOf(Integer.parseInt(CHANGINGprjIdTxt.getText().trim()));


            String sql = "UPDATE projects SET projectdescription = ?, projdeadline = ?, projname = ? WHERE convrprojid = ?;";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, prjDescription);
                preparedStatement.setString(2, prjDeadline);
                preparedStatement.setString(3, prjName);
                preparedStatement.setInt(4, Integer.parseInt(prjId));
                preparedStatement.executeUpdate();
                changePrjStatus.setText("Проект изменен");

            } catch (SQLException e) {
                e.printStackTrace();
                changePrjStatus.setText("Некорректный ввод");
            }


        });
        changeStdButton.setOnAction(event -> {
            String stage = addPrjStageTxt.getText().trim();
            String idprj = String.valueOf(Integer.parseInt(CHANGINGprjIdTxt.getText().trim()));
            String sql = "UPDATE projects SET stage = ? WHERE convrprojid = ?;";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, stage);
                preparedStatement.setInt(2, Integer.parseInt(idprj));
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        });

    }


}
