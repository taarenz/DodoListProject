package main.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.TodoItem;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.InflaterInputStream;

public class TodoController implements Initializable {
    // vars
    @FXML
    private TextField titoloTodo;

    @FXML
    private TextArea descrizioneTodo;

    @FXML
    private TextField dataScadenzaTodo;  // entro quando va eseguito

    @FXML
    private Button bottoneModifica;

    @FXML
    private Button bottoneConfermaModifica;

    @FXML
    private Button bottoneAnnullaModifca;



    // metodo che inserisce
    public void setData(TodoItem item) {
        String titolo = item.getTitolo();
        String descrizione = item.getDescrizione();
        String dataScadenza = item.getDataTodo().toString();

        // set dei valori sopra
        titoloTodo.setText(titolo);
        descrizioneTodo.setText(descrizione);
        dataScadenzaTodo.setText(dataScadenza);
    }

    @FXML
    public void modificaElemento () {
        // instanza delle variabili temporanee
        String tmpTitolo = titoloTodo.getText();
        String tmpDescrizione = descrizioneTodo.getText();
        String tmpData = dataScadenzaTodo.getText();

        titoloTodo.setEditable(true);
        descrizioneTodo.setEditable(true);
        dataScadenzaTodo.setEditable(true);

        titoloTodo.setStyle("-fx-border-width: 1px; -fx-border-color: #cc7722;");
        descrizioneTodo.setStyle("-fx-background-color: #cc7722;");
        dataScadenzaTodo.setStyle("-fx-border-width: 1px; -fx-border-color: #cc7722;");

        bottoneConfermaModifica.setVisible(true);
        bottoneAnnullaModifca.setVisible(true);

        bottoneConfermaModifica.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                titoloTodo.setEditable(false);
                descrizioneTodo.setEditable(false);
                dataScadenzaTodo.setEditable(false);

                titoloTodo.setText(titoloTodo.getText());
                descrizioneTodo.setText(descrizioneTodo.getText());
                dataScadenzaTodo.setText(dataScadenzaTodo.getText());

                bottoneConfermaModifica.setVisible(false);
                bottoneAnnullaModifca.setVisible(false);

                // set dello stile
                titoloTodo.setStyle("");
                descrizioneTodo.setStyle("");
                dataScadenzaTodo.setStyle("");
            }
        });

        bottoneAnnullaModifca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                titoloTodo.setEditable(false);
                descrizioneTodo.setEditable(false);
                dataScadenzaTodo.setEditable(false);

                titoloTodo.setText(tmpTitolo);
                descrizioneTodo.setText(tmpDescrizione);
                dataScadenzaTodo.setText(tmpData);

                bottoneConfermaModifica.setVisible(false);
                bottoneAnnullaModifca.setVisible(false);

                // set dello stile
                titoloTodo.setStyle("");
                descrizioneTodo.setStyle("");
                dataScadenzaTodo.setStyle("");
            }
        });
    }

    @FXML
    public void eliminaElemento () {

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        descrizioneTodo.setWrapText(true);

        titoloTodo.setEditable(false);
        descrizioneTodo.setEditable(false);
        dataScadenzaTodo.setEditable(false);

        bottoneConfermaModifica.setVisible(false);
        bottoneAnnullaModifca.setVisible(false);
    }
}
