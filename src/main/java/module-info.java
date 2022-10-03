module main.app.progettotodolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.app to javafx.fxml;
    exports main.app;
}