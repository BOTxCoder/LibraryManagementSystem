package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button masterListOfBooks;

    @FXML
    private Button masterListOfMovies;

    @FXML
    private Button masterListOfMembership;

    @FXML
    private Button activeIssues;

    @FXML
    private Button overdueReturns;

    @FXML
    private Button pendingIssueRequest;

    @FXML
    private Button home;

    private void loadUI(String ui, ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ui));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        borderPane.setCenter(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        masterListOfBooks.setOnAction((ActionEvent actionEvent)->{
            moveTo("MasterListOfBooks.fxml");
        });
        masterListOfMovies.setOnAction((ActionEvent actionEvent)->{
            moveTo("MasterListOfMovies.fxml");
        });
        masterListOfMembership.setOnAction((ActionEvent actionEvent)->{

            moveTo("MasterListOfMembership.fxml");
        });
        activeIssues.setOnAction((ActionEvent actionEvent)->{

            moveTo("ActiveIssues.fxml");
        });
        overdueReturns.setOnAction((ActionEvent actionEvent)->{

            moveTo("OverdueReturn.fxml");
        });
        pendingIssueRequest.setOnAction((ActionEvent actionEvent)->{
         moveTo("PendingIssueRequest.fxml");
        });
        home.setOnAction((ActionEvent actionEvent)->{
            try {
                loadUI("AdminHomePage.fxml",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
    private void moveTo(String fxml) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane.setCenter(root);
    }

}
