package  com.company;

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

public class RegisterMenuController {

    @FXML
    private TextField nameTxtField;

    @FXML
    private TextField educationTxtField;

    @FXML
    private TextField surnameTxtField;

    @FXML
    private TextField departmentTxtField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField loginTxtField;

    @FXML
    private TextField passwordTxtField;

    @FXML
    private TextField numberTxtField;

    @FXML
    private Button backButton;

    @FXML
    private TextField operationTxtField;




    @FXML
    void initialize () throws Exception {
        Config config = new Config();
        Connection connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());
        signupButton.setOnAction(event -> {
            String nameToInsert = nameTxtField.getText().trim();
            String surnameToInsert = surnameTxtField.getText().trim();
            String educationToInsert = educationTxtField.getText().trim();
            String departmentToInsert = departmentTxtField.getText().trim();
            String operationToInsert = operationTxtField.getText().trim();
            EmployesInfo employesInfo = new EmployesInfo(nameToInsert, surnameToInsert,educationToInsert, departmentToInsert,operationToInsert);





            String sql = "Insert into emps (name, surname, education, department, operation) VALUES (?, ?, ?, ?, ?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, employesInfo.getName());
                preparedStatement.setString(2, employesInfo.getSurname());
                preparedStatement.setString(3, employesInfo.getEducation());
                preparedStatement.setString(4, departmentToInsert);
                preparedStatement.setString(5, operationToInsert);
                preparedStatement.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
                backButton.setOnAction(event -> {
                    Stage oldStage = (Stage) backButton.getScene().getWindow();
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

