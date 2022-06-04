module com.project217ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.project217ui to javafx.fxml;
    exports com.project217ui;
}

