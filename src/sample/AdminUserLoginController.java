package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminUserLoginController implements Initializable{

    @FXML
    private TextField user;

    @FXML
    private TextField password;

    @FXML
    private Button login;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void setLogin(ActionEvent actionEvent) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from useradmin where Username =? and Password =?");
            preparedStatement.setString(1, user.getText());
            preparedStatement.setString(2, password.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                SwitchFXML switchFXML = new SwitchFXML();
                if (resultSet.getBoolean("is_admin")) {
                    switchFXML.switchFxml("AdminHomePage.fxml", "Home", actionEvent);
                } else {
                    switchFXML.switchFxml("UserHomePage.fxml", "Home", actionEvent);

                }
            } else {
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setContentText("Username or Password was incorrect.");
           alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
