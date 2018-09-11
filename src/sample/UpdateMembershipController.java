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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UpdateMembershipController implements Initializable {
    @FXML
    private TextField membershipId;

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
    private RadioButton oneYear1;

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    private Button logout;

    @FXML
    private Button back;

    String string;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    confirm.setOnAction((ActionEvent actionEvent)->{
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem", "root", "ani");
            PreparedStatement preparedStatement = connection.prepareStatement("update memberships set startDate =? , endDate = ? where membershipId=?");
            LocalDate startDate = start.getValue();
            LocalDate endDate = end.getValue();
            int MembershipId = Integer.parseInt(membershipId.getText());
            preparedStatement.setString(1, String.valueOf(startDate));
            preparedStatement.setString(2, String.valueOf(endDate));
            preparedStatement.setString(3, String.valueOf(MembershipId));
            preparedStatement.executeUpdate();
            if(sixMonth.isSelected()) this.string = "Six Month";
            if(sixMonth.isSelected()) this.string = "1 year";
            if(sixMonth.isSelected()) this.string = "2 year";
        } catch (SQLException e) {
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
