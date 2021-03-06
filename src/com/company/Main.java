package com.company;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class Main extends Application {



    public static void main(String[] args) throws Exception{
        launch(args);
        }

   @Override

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginform.fxml"));
        primaryStage.setTitle("Log in");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();

    }
}