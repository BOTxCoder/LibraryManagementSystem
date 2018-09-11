package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UpdateBookMovieController implements Initializable {
    @FXML
    private ComboBox<String> bookcombo;

    @FXML
    private TextField serailNumber;

    @FXML
    private ComboBox<String> statusCombo;

    @FXML
    private RadioButton book;

    @FXML
    private RadioButton movie;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    private Button logout;

    @FXML
    private Button back;

    ObservableList<String> observableList = FXCollections.observableArrayList();
    ObservableList<String> list = FXCollections.observableArrayList("Active","inactive");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookcombo.setItems(observableList);
        statusCombo.setItems(list);
        if (book.isSelected()) {
            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ECheckout", "root", "ani");
                ResultSet resultSet = connection.createStatement().executeQuery("select * from books");
                while (resultSet.next()) {
                    observableList.add(resultSet.getString("BookName"));
                }
                String SerialNumber  = serailNumber.getText();
                LocalDate Date  = datepicker.getValue();
                PreparedStatement preparedStatement = connection.prepareStatement("update books set ProcrumentDate =? where SerialNumber =?");
                preparedStatement.setString(1,Date.toString());
                preparedStatement.setString(2,SerialNumber);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(movie.isSelected()){
            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ECheckout", "root", "ani");
                ResultSet resultSet = connection.createStatement().executeQuery("select * from movie");
                while (resultSet.next()) {
                    observableList.add(resultSet.getString("MovieName"));
                }
                String SerialNumber  = serailNumber.getText();
                LocalDate Date  = datepicker.getValue();
                PreparedStatement preparedStatement = connection.prepareStatement("update books set ProcrumentDate =? where SerialNumber =?");
                preparedStatement.setString(1,Date.toString());
                preparedStatement.setString(2,SerialNumber);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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