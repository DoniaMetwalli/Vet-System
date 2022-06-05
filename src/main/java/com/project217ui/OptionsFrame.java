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
    private Button signoutBT;

    @FXML
    private Label signoutLB;

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
    void switchToSignOut(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("SignOutFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void initialize() {
        assert addBT != null;
        assert addLB != null;
        assert deleteBT != null;
        assert deleteLB != null;
        assert signoutBT != null;
        assert signoutLB != null;
        assert optionsPane != null;
        assert titleLB != null;
        assert viewBT != null;
        assert viewLB != null;

    }

}
