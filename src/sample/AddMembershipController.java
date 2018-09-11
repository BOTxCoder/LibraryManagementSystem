package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddMembershipController implements Initializable {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField contactNumber;

    @FXML
    private TextField ConteactAddress;

    @FXML
    private DatePicker start;

    @FXML
    private DatePicker end;

    @FXML
    private RadioButton sixMonth;

    @FXML
    private RadioButton oneYear;

    @FXML
    private RadioButton twoYear;

    @FXML
    private Button cancel;

    @FXML
    private Button back;

    @FXML
    private Button confirm;

    @FXML
    private Button logout;

    String membership ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirm.setOnAction((ActionEvent actionEvent) -> {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem", "root", "ani");
                PreparedStatement preparedStatement = connection.prepareStatement("insert into  memberships values(?,?,?,?,?,?,?)");
                String FirstName = firstName.getText();
                String LastName = lastName.getText();
                long  ContactNumber = Integer.parseInt(contactNumber.getText());
                String ContactAddress = ConteactAddress.getText();
                LocalDate StartDate  = start.getValue();
                LocalDate EndDate  = end.getValue();
                preparedStatement.setString(1, FirstName);
                preparedStatement.setString(2, LastName);
                preparedStatement.setString(3, String.valueOf(ContactNumber));
                preparedStatement.setString(4, ContactAddress);
                preparedStatement.setString(5, String.valueOf(StartDate));
                preparedStatement.setString(6, String.valueOf(EndDate));
                preparedStatement.setString(7, membership);
                if(sixMonth.isSelected()){
                    this.membership = "Six Month";
                }

                if(oneYear.isSelected()){
                    this.membership = "1 year";
                }
                if(twoYear.isSelected()){
                    this.membership = "2 year";
                }

                preparedStatement.executeUpdate();
            } catch (Exception e) {
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
}