module com.project217ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;
    opens com.project217ui.Views to javafx.fxml;
    exports com.project217ui;
}

