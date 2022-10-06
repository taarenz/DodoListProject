package model;

import java.util.Date;
import java.util.Objects;

public class TodoItem {
    // attributi
    static int base_id = 100;

    private String titolo;
    private String descrizione;
    private String dataTodo;  // indica la data di quando va fatto l'impegno

    //construttore
    public TodoItem(String titolo, String descrizione, String dataTodo) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataTodo = dataTodo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(titolo, todoItem.titolo) && Objects.equals(descrizione, todoItem.descrizione) && Objects.equals(dataTodo, todoItem.dataTodo);
    }

    public void clone(TodoItem i){
        this.titolo = i.titolo;
        this.descrizione = i.descrizione;
        this.dataTodo = i.dataTodo;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataTodo='" + dataTodo + '\'' +
                '}';
    }
}
