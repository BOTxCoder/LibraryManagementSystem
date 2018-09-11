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

public class MasterListOfMoviesController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button back;

    @FXML
    private Button logout;

    @FXML
    private TableView<ModelTable1> tableView;

    @FXML
    private TableColumn<?, ?> serialNumber;

    @FXML
    private TableColumn<?, ?> movieName;

    @FXML
    private TableColumn<?, ?> authorName;

    @FXML
    private TableColumn<?, ?> category;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private TableColumn<?, ?> cost;

    @FXML
    private TableColumn<?, ?> procurementDate;

    ObservableList<ModelTable1> oblist  = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "ani");
            ResultSet resultSet = connection.createStatement().executeQuery("select * from movie");
            while(resultSet.next()){
                oblist.add(new ModelTable1(resultSet.getInt("SerialNumber"),
                        resultSet.getString("MovieName"),
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
        serialNumber.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        movieName.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        authorName.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        procurementDate.setCellValueFactory(new PropertyValueFactory<>("procurementDate"));
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
