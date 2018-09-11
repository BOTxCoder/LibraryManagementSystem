package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReturnBookController implements Initializable {

    @FXML
    private ComboBox<?> bookName;

    @FXML
    private ComboBox<?> authorName;

    @FXML
    private ComboBox<?> serialNumber;

    @FXML
    private DatePicker issueDate;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TextArea remarks;

    @FXML
    private Button back;

    @FXML
    private Button search;

    @FXML
    private Button logout;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        back.setOnAction((ActionEvent actionEvent)->{
            SwitchFXML switchFXML = new SwitchFXML();
            try {
                switchFXML.switchFxml("Transaction.fxml","Maintenance",actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
