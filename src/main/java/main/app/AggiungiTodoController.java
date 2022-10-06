package main.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TodoItem;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Button annullaButton;

    private MainController controller;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textAreaDescrizione.setWrapText(true); // permette di bloccare lo scorrimento laterale della text area
        datePicker.getEditor().setEditable(true);  // disabilita la possibilità di editare i text field del dp
    }

    // quando si clicca il bottone aggiungi
    @FXML
    public void creaOggettoTODO () throws ParseException {
        // formato della data
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        // verifica che tutti i campi siano compilati
        if(fieldCheck()){
            // check corretto
            // creazione dell'oggetto
            try {
                String titolo = textFieldTitolo.getText();
                String descrizione = textAreaDescrizione.getText();
                String data = ft.format(ft.parse(this.datePicker.getValue().toString()));

                TodoItem item = new TodoItem(titolo, descrizione, data);

                if(!ridondanzaCheck(item)){
                    controller.aggiungiOggettoLista(item);

                    //chiusura popup
                    chiusuraFinestra();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "ERRORE, E' già stato inserito un postit identico.");
                    alert.showAndWait();
                }

            } catch (Exception e){
                System.out.println(e.toString());
                Alert alert = new Alert(Alert.AlertType.WARNING, "ERRORE, Inserire correttamente tutti i campi.\n(La data va inserita nel seguente formato (YYYY-MM-DD).");
                alert.showAndWait();
            }

        } else{
            // pop up errore
            Alert alert = new Alert(Alert.AlertType.WARNING, "ERRORE, Inserire correttamente tutti i campi.");
            alert.showAndWait();
        }
    }

    private boolean fieldCheck() {
        // verifica del titolo
        if(textFieldTitolo.getText() == ""){
            return false;
        }

        // verifica della descrizione
        if(textAreaDescrizione.getText() == ""){
            return false;
        }

        // verifica del date picker
        if(datePicker.getValue() == null) {
            return false;
        }

        return true;
    }

    private boolean ridondanzaCheck(TodoItem item) {
        for(int i=0; i<controller.getListaTodo().size(); i++){
            if(item.equals(controller.getListaTodo().get(i))){
                return true;
            }
        }
        return false;
    }

    // funzione per chiudere la finestra
    @FXML
    private void chiusuraFinestra() {
        // get a handle to the stage
        Stage stage = (Stage) annullaButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void setMainController (MainController controller){
        this.controller = controller;
    }
}
