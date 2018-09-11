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

public class MasterListOfBooksController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button back;

    @FXML
    private Button logout;

    @FXML
    private TableView<ModelTable> tableView;

    @FXML
    private TableColumn<?, ?> SerialNumber;

    @FXML
    private TableColumn<?, ?> BookName;

    @FXML
    private TableColumn<?, ?> AuthorName;

    @FXML
    private TableColumn<?, ?> ategory;

    @FXML
    private TableColumn<?, ?> Status;

    @FXML
    private TableColumn<?, ?> Cost;

    @FXML
    private TableColumn<?, ?> ProcurementDate;

    ObservableList<ModelTable> oblist  = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
            ResultSet resultSet = connection.createStatement().executeQuery("select * from books");
            while(resultSet.next()){
                oblist.add(new ModelTable(resultSet.getInt("SerialNumber"),
                        resultSet.getString("BookName"),
                        resultSet.getString("AuthorName"),
                        resultSet.getString("Category"),
                        resultSet.getString("Status"),
                        resultSet.getInt("Cost"),
                        resultSet.getDate("ProcrumentDate").toLocalDate())
                        );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        SerialNumber.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        BookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        AuthorName.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        ategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        Status.setCellValueFactory(new PropertyValueFactory<>("status"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        ProcurementDate.setCellValueFactory(new PropertyValueFactory<>("procurementDate"));
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
