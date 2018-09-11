package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ActiveIssuesController implements Initializable
{      @FXML
private BorderPane borderPane;

    @FXML
    private Button back;

    @FXML
    private Button logout;

    @FXML
    private TableView<ModelTable3> tableView;
    @FXML
    private TableColumn<?, ?> serialNumber;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> membershipId;

    @FXML
    private TableColumn<?, ?> issueDate;

    @FXML
    private TableColumn<?, ?> returnDate;

    ObservableList<ModelTable3> observableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT a.SerialNumber , a.BookName , b.membershipId , b.startDate , b.endDate FROM memberships b JOIN books a ON b.membershipId = a.SerialNumer)");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                observableList.add(new ModelTable3(
                        resultSet.getInt("SerialNumber"),
                        resultSet.getString("BookName"),
                        resultSet.getInt("membershipId"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate").toLocalDate()
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        serialNumber.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        Name.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        membershipId.setCellValueFactory(new PropertyValueFactory<>("membershipId"));
        issueDate.setCellValueFactory(new PropertyValueFactory<>("dateOfIssue"));
        returnDate.setCellValueFactory(new PropertyValueFactory<>("dateOfReturn"));
        tableView.setItems(observableList);


        back.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("Reports.fxml","Maintenance",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    }
