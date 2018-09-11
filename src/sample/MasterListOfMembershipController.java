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

public class MasterListOfMembershipController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button back;

    @FXML
    private Button logout;

    @FXML
    private TableView<ModelTable2> tableView;

    @FXML
    private TableColumn<?, ?> membershipId;

    @FXML
    private TableColumn<?, ?> memberName;

    @FXML
    private TableColumn<?, ?> contactNumber;

    @FXML
    private TableColumn<?, ?> contactAddress;

    @FXML
    private TableColumn<?, ?> adhaarCard;

    @FXML
    private TableColumn<?, ?> startDate;

    @FXML
    private TableColumn<?, ?> endDate;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private TableColumn<?, ?> fine;

    ObservableList<ModelTable2> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
            ResultSet resultSet = connection.createStatement().executeQuery("select * from memberships");
            while(resultSet.next()){
                oblist.add(new ModelTable2(
                        resultSet.getInt("membershipId"),
                        resultSet.getInt("adhaarCard"),
                        resultSet.getString("firstName"),
                        resultSet.getString("contactAddress"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate").toLocalDate(),
                        resultSet.getString("status"),
                        resultSet.getInt("contactNo"),
                        resultSet.getInt("fine")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        membershipId.setCellValueFactory(new PropertyValueFactory<>("membershipId"));
        memberName.setCellValueFactory(new PropertyValueFactory<>("memberNameName"));
        adhaarCard.setCellValueFactory(new PropertyValueFactory<>("aadharNo"));
        contactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        contactAddress.setCellValueFactory(new PropertyValueFactory<>("contactAddress"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
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
