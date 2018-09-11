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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PendingIssueRequestController implements Initializable {
    @FXML
    private Button back;

    @FXML
    private Button logout;

    @FXML
    private TableView<ModelTablePendingIssueRequest> tableVIew;

    @FXML
    private TableColumn<?, ?> membershipId;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> requestDate;

    @FXML
    private TableColumn<?, ?> requestFullfilledDate;

    ObservableList<ModelTablePendingIssueRequest>  oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
            ResultSet resultSet = connection.createStatement().executeQuery("select * from membership");
            while(resultSet.next()){
                oblist.add(new ModelTablePendingIssueRequest(
                        resultSet.getInt("membershipId"),
                        resultSet.getString("userName"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate").toLocalDate()
                ) );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        membershipId.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        Name.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        requestDate.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        requestFullfilledDate.setCellValueFactory(new PropertyValueFactory<>("category"));

        tableVIew.setItems(oblist);
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