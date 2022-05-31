package com.company;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Button logInButton;


    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label loginstatus;

    @FXML
    private Button goBackButton;

    @FXML
    void initialize() {
        logInButton.setOnAction(event -> {
            String login = loginTextField.getText().trim();
            String password = passwordTextField.getText().trim();
            if (login.equals("admin") & password.equals("gfhjkmckj;ysq")) {
                Stage oldStage = (Stage) logInButton.getScene().getWindow();
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
            } else {
                String noInfoStatus = "Неверные логин или пароль!";
                loginstatus.setText(noInfoStatus);
            }
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
