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

public class DeleteSuccessFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button delNextBT;

    @FXML
    private Pane delSuPane;

    @FXML
    private Label delSucLB;

    @FXML
    void switchToOptionMD(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert delNextBT != null : "fx:id=\"delNextBT\" was not injected: check your FXML file 'DeleteSuccessFrame.fxml'.";
        assert delSuPane != null : "fx:id=\"delSuPane\" was not injected: check your FXML file 'DeleteSuccessFrame.fxml'.";
        assert delSucLB != null : "fx:id=\"delSucLB\" was not injected: check your FXML file 'DeleteSuccessFrame.fxml'.";

    }

}
