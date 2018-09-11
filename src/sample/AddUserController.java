package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {

    @FXML
    private Button logout;

    @FXML
    private Button back;

    @FXML
    private RadioButton newUser;

    @FXML
    private RadioButton existingUser;

    @FXML
    private TextField name;

    @FXML
    private CheckBox isActive;

    @FXML
    private CheckBox isAdmin;

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    private boolean radioStatus;
    private RadioButton equals;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setToggleAction();
        confirm.setOnAction((ActionEvent actionEvent)->{
            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE memberships , useradmin SET memberships.status =? , useradmin.is_admin =? WHERE (SELECT memberships.adhaarCard =? WHERE membership.fistName =?)=useradmin.adhaarCard;");
                String Name = name.getText();
                Boolean activeSelected = isActive.isSelected();
                Boolean checkYesSelected = isAdmin.isSelected();

                preparedStatement.setBoolean(1, activeSelected);
                preparedStatement.setBoolean(2, checkYesSelected);
                preparedStatement.setString(3, Name);

            }catch (SQLException e){
                e.printStackTrace();
            }
            });
        back.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("Maintenance.fxml","Maintenance",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    void setToggleAction(){
        ToggleGroup toggleGroup = new ToggleGroup();
        newUser.setToggleGroup(toggleGroup);
        existingUser.setToggleGroup(toggleGroup);
        equals = (RadioButton) toggleGroup.getSelectedToggle();
        radioStatus = equals.getId().equals("radioExistingUser");
    }
}
