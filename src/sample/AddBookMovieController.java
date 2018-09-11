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
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddBookMovieController implements Initializable {
    @FXML
    private RadioButton radioBook;

    @FXML
    private RadioButton radioMovie;

    @FXML
    private TextField BookOrMovie;

    @FXML
    private TextField authorName;

    @FXML
    private TextField category;

    @FXML
    private TextField status;

    @FXML
    private TextField cost;

    @FXML
    private TextField serialNumber;
    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField Quantity;

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    private Button logout;

    @FXML
    private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        back.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("Maintenance.fxml","Maintenance",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    private void setConfirm(ActionEvent actionEvent) throws SQLException {
        if (radioBook.isSelected()) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem", "root", "ani");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into  Books values(?,?,?,?,?,?,?,?)");
            int  SerialNumber = Integer.parseInt(serialNumber.getText());
            String Name = BookOrMovie.getText();
            String AuthorName = authorName.getText();
            String Category = category.getText();
            String Status = category.getText();
            int Cost = Integer.parseInt(cost.getText());
            LocalDate date = datePicker.getValue();
            int copies = Integer.parseInt(Quantity.getText());
            preparedStatement.setString(1, String.valueOf(SerialNumber));
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, AuthorName);
            preparedStatement.setString(4, Category);
            preparedStatement.setString(5, Status);
            preparedStatement.setString(6, String.valueOf(Cost));
            preparedStatement.setString(7, String.valueOf(date));
            preparedStatement.setString(8, String.valueOf(copies));
            preparedStatement.executeUpdate();
        }
        if (radioMovie.isSelected()) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem", "root", "ani");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into  movie values(?,?,?,?,?,?,?,?)");
            int  SerialNumber = Integer.parseInt(serialNumber.getText());
            String Name = BookOrMovie.getText();
            String AuthorName = authorName.getText();
            String Category = category.getText();
            String Status = category.getText();
            int Cost = Integer.parseInt(cost.getText());
            LocalDate date = datePicker.getValue();
            int copies = Integer.parseInt(Quantity.getText());
            preparedStatement.setString(1, String.valueOf(SerialNumber));
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, AuthorName);
            preparedStatement.setString(4, Category);
            preparedStatement.setString(5, Status);
            preparedStatement.setString(6, String.valueOf(Cost));
            preparedStatement.setString(7, String.valueOf(date));
            preparedStatement.setString(8, String.valueOf(copies));
            preparedStatement.executeUpdate();
        }
    }
}
