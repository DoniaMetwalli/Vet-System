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

public class OptionsFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBT;

    @FXML
    private Label addLB;

    @FXML
    private Button deleteBT;

    @FXML
    private Label deleteLB;

    @FXML
    private Button exitBT;

    @FXML
    private Label exitLB;

    @FXML
    private Pane optionsPane;

    @FXML
    private Label titleLB;

    @FXML
    private Button viewBT;

    @FXML
    private Label viewLB;

    @FXML
    void switchToAdd(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("AddFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToDelete(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToView(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewPetFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void closeButton(ActionEvent event) throws IOException 
    {
        // get a handle to the stage
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void initialize() {
        assert addBT != null : "fx:id=\"addBT\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert addLB != null : "fx:id=\"addLB\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert deleteBT != null : "fx:id=\"deleteBT\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert deleteLB != null : "fx:id=\"deleteLB\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert exitBT != null : "fx:id=\"exitBT\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert exitLB != null : "fx:id=\"exitLB\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert optionsPane != null : "fx:id=\"optionsPane\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert titleLB != null : "fx:id=\"titleLB\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert viewBT != null : "fx:id=\"viewBT\" was not injected: check your FXML file 'OptionsFrame.fxml'.";
        assert viewLB != null : "fx:id=\"viewLB\" was not injected: check your FXML file 'OptionsFrame.fxml'.";

    }

}
