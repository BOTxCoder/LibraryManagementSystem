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

public class TransactionController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button bookAvailable;

    @FXML
    private Button issueBook;

    @FXML
    private Button returnBook;

    @FXML
    private Button home;
    @FXML
    private Button payFine;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        home.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("AdminHomePage.fxml","Maintenance",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bookAvailable.setOnAction((ActionEvent actionEvent)->{
            moveTo("BookAvailable.fxml");
        });

        issueBook.setOnAction((ActionEvent actionEvent)->{
            moveTo("IssueBook.fxml");
        });

        returnBook.setOnAction((ActionEvent actionEvent)->{
            moveTo("ReturnBook.fxml");
        });
        payFine.setOnAction((ActionEvent actionEvent)->{
         moveTo("PayFine.fxml");
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