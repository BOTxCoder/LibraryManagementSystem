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
import java.util.ResourceBundle;

public class UserHomePageController implements Initializable {
    @FXML
    private TableView<ModelTableUserHome> tableView;

    @FXML
    private TableColumn<?, ?> CodeNF;

    @FXML
    private TableColumn<?, ?> CodeNT;

    @FXML
    private TableColumn<?, ?> Topics;

    @FXML
    private Button reports;

    @FXML
    private Button transactions;

    @FXML
    private Button logout;

    @FXML
    private Button back;

    ObservableList<ModelTableUserHome> observableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     CodeNF.setCellValueFactory(new PropertyValueFactory<>("codeNumberFrom"));
     CodeNT.setCellValueFactory(new PropertyValueFactory<>("codeNumberTo"));
     Topics.setCellValueFactory(new PropertyValueFactory<>("category"));
     tableView.setItems(observableList);


        back.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("AdminUserLogin.fxml","Login",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        transactions.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("Transaction.fxml","Transactions",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        reports.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("Reports.fxml","Reports",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}
