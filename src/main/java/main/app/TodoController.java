package main.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.TodoItem;

public class TodoController {
    // vars
    @FXML
    private Label titoloTodo;

    @FXML
    private Label descrizioneTodo;

    @FXML
    private Label dataScadenzaTodo;  // entro quando va eseguito


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
}
