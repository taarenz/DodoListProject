package main.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.TodoItem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    // vars
    // variabli per il cambio di scena
    // variabili per il cambio di scena
    private Stage stage;
    private Scene scene;

    @FXML
    private GridPane gridPaneTodo;  // griglia dove saranno riposti i vari postit con all'interno la todo
    @FXML
    private ScrollPane scrollPane;  // serve per permettere di scorrere la lista


    // oggetti di scena
    @FXML
    private Button bottoneCreaTodo;

    // contiene tutti i dodo che bisogna inserire
    private List<TodoItem> listaTodo = new ArrayList<>();

    // indica la riga dela matrice a cui si è arrivati
    private int righeGrid = 0;

    // metodo initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        scrollPane.setFitToWidth(true);

        try {
            for(int i=0; i<listaTodo.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("todoItem.fxml"));
                AnchorPane box = fxmlLoader.load();

                GridPane.setMargin(box, new Insets(20, 0, 0, 20));

                TodoController controllerTodo = fxmlLoader.getController();
                controllerTodo.setData(listaTodo.get(i));

                gridPaneTodo.add(box, 0, ++righeGrid);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // metodo che permette di aggiungere un dodo alla lista
    @FXML
    public void aggiungiTodo (ActionEvent event) throws Exception{
        // apertura del'FXML corretto
        FXMLLoader loader = new FXMLLoader(getClass().getResource("aggiungi-view.fxml"));
        Parent root = loader.load();

        scene = new Scene(root);
        stage = new Stage();
        // settings per lo stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Aggiunta DODO");
        stage.setScene(scene);
        stage.show();
    }

}