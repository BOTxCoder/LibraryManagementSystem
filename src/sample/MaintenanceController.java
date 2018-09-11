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

public class MaintenanceController implements Initializable {
    @FXML
    private Button addMembership;

    @FXML
    private Button updateMemebership;

    @FXML
    private Button addBook;

    @FXML
    private Button updateBook;

    @FXML
    private Button addUpdateUser;

    @FXML
    private Button home;

    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    addMembership.setOnAction((ActionEvent actionEvent)->{
        moveTo("AddMembership.fxml");
    });
    updateMemebership.setOnAction((ActionEvent actionEvent)->{
        moveTo("UpdateMembership.fxml");
    });
    addBook.setOnAction((ActionEvent actionEvent)->{
        moveTo("AddBookMovie.fxml");
        });
    updateBook.setOnAction((ActionEvent actionEvent)->{
        moveTo("UpdateBookMovie.fxml");
        });
    addUpdateUser.setOnAction((ActionEvent actionEvent)->{
         moveTo("AddUser.fxml");
        });
    home.setOnAction((ActionEvent actionEvent )->{
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
    private void loadUI(String ui, ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ui));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
