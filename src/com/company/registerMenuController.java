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

public class registerMenuController {

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
            String name = nameTxtField.getText().trim();
            String surname = surnameTxtField.getText().trim();
            String education = educationTxtField.getText().trim();
            String department = departmentTxtField.getText().trim();


            int idEmp = Integer.parseInt(numberTxtField.getText().trim());
            String operation = operationTxtField.getText().trim();
            EmployesInfo employesInfo = new EmployesInfo(idEmp, name, surname, education, department, operation);



            String sql = "Insert into employees VALUES (?, ?, ?, ?, ?, ?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, employesInfo.getId());
                preparedStatement.setString(2, employesInfo.getName());
                preparedStatement.setString(3, employesInfo.getSurname());
                preparedStatement.setString(4, employesInfo.getEducation());
                preparedStatement.setString(5, employesInfo.getDepartment());
                preparedStatement.setString(6, employesInfo.getOperation());
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

