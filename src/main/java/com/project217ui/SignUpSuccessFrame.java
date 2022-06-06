package com.project217ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUpSuccessFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label addSuLB;

    @FXML
    private Pane addSuccessPane;

    @FXML
    private Button nextAddBT;

    @FXML
    void switchToOptionMA(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert addSuLB != null;
        assert addSuccessPane != null;
        assert nextAddBT != null;

    }

}
