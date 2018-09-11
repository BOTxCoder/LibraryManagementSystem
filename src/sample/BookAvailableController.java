package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class BookAvailableController implements Initializable {
    @FXML
    private ComboBox<String> bookName;

    @FXML
    private ComboBox<String> authorName;

    @FXML
    private Button back;

    @FXML
    private Button search;

    @FXML
    private Button logout;

    private final ObservableList<String> observableList = FXCollections.observableArrayList();
    private final ObservableList<String> observableList1 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     try{
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem","root","ani");
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT BookName , AuthorName from books");
         ResultSet resultSet = preparedStatement.executeQuery();
         while (resultSet.next()) {
             observableList.add(resultSet.getString("BookName"));
             observableList1.add(resultSet.getString("AuthorName"));
         }
         bookName.setItems(observableList);
         authorName.setItems(observableList1);
     } catch (SQLException e1) {
         e1.printStackTrace();
     }


        back.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("Transaction.fxml","Maintenance",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
    public  void  setSearch(ActionEvent actionEvent) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem","root","ani");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT BookName , AuthorName , SerialNumber , Status FROM books");
        preparedStatement.setString(1, bookName.getSelectionModel().getSelectedItem());
        preparedStatement.setString(2, authorName.getSelectionModel().getSelectedItem());
        ResultSet resultSet = preparedStatement.executeQuery();
    }
}
