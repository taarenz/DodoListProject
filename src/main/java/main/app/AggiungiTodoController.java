package main.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.TodoItem;

import java.net.URL;
import java.util.ResourceBundle;

public class AggiungiTodoController implements Initializable {
    // variabili
    private TodoItem tmp;  // oggetto temporaneo che verrà poi caricato nella

    @FXML
    private TextField textFieldTitolo;  // indica il textfield in cui verrà inserito il titolo

    @FXML
    private TextArea textAreaDescrizione;

    @FXML
    private DatePicker datePicker;  // datepicker per la data dell'evento

    @FXML
    private Button confermaButton;

    @FXML
    private Button annulla;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textAreaDescrizione.setWrapText(true);
    }
}
