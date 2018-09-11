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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OverdueReturnController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button back;

    @FXML
    private Button logout;

    @FXML
    private TableView<ModelTable4> tableView;

    @FXML
    private TableColumn<?, ?> serialNumber;

    @FXML
    private TableColumn<?, ?> bookName;

    @FXML
    private TableColumn<?, ?> membershipId;

    @FXML
    private TableColumn<?, ?> dateOfIssue;

    @FXML
    private TableColumn<?, ?> dateOfReturn;

    @FXML
    private TableColumn<?, ?> fine;

    ObservableList<ModelTable4> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
            ResultSet resultSet = connection.createStatement().executeQuery("select membershipId , adhaarCard, firstName , startDate , endDate,fine from memberships");
            while(resultSet.next()){
                oblist.add(new ModelTable4(
                        resultSet.getInt("membershipId"),
                        resultSet.getInt("adhaarCard"),
                        resultSet.getString("firstName"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate").toLocalDate(),
                        resultSet.getInt("fine")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        serialNumber.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        bookName.setCellValueFactory(new PropertyValueFactory<>("memberShipId"));
        membershipId.setCellValueFactory(new PropertyValueFactory<>("Name"));
        dateOfIssue.setCellValueFactory(new PropertyValueFactory<>("dateOfIssue"));
        dateOfReturn.setCellValueFactory(new PropertyValueFactory<>("dateOfReturn"));
        fine.setCellValueFactory(new PropertyValueFactory<>("fine"));

        tableView.setItems(oblist);

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


