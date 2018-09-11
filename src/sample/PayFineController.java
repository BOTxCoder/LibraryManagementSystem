package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PayFineController implements Initializable {

    @FXML
    private ComboBox<?> bookName;

    @FXML
    private ComboBox<?> authorName;

    @FXML
    private ComboBox<?> serialNumber;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private DatePicker actualReturnDate;

    @FXML
    private TextField fineCal;

    @FXML
    private CheckBox checkpaid;

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
