package model;

import java.util.Date;

public class TodoItem {
    // attributi
    static int base_id = 100;

    private String titolo;
    private String descrizione;
    private String dataTodo;  // indica la data di quando va fatto l'impegno
    private int id;  // indica id univoco

    //construttore
    public TodoItem(String titolo, String descrizione, String dataTodo) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataTodo = dataTodo;

        this.base_id += 100;
    }

    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getDataTodo() {
        return dataTodo;
    }
    public void setDataTodo(String dataTodo) {
        this.dataTodo = dataTodo;
    }


}
