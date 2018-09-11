package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class IssueBookController implements Initializable {
    @FXML
    private Button logout;

    @FXML
    private ComboBox<String> bookName;

    @FXML
    private ComboBox<String> authorName;

    @FXML
    private DatePicker issueDate;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TextArea remarks;

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    private Button back;


    private final ObservableList<String> observableList = FXCollections.observableArrayList();
    private final ObservableList<String> observableList1 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem","root","ani");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT BookName , AuthorName,startDate, endDate ,from books");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                observableList.add(resultSet.getString("BookName"));
                observableList1.add(resultSet.getString("AuthorName"));
                issueDate.getValue();
                returnDate.getValue();
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
}
