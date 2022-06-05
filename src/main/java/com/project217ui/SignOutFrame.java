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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignOutFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBT;

    @FXML
    private Label credLB;

    @FXML
    private Pane signOutPane;

    @FXML
    private Button signoutBT;

    @FXML
    private Label signoutLB;

    @FXML
    private Label usernLB;

    @FXML
    private TextField usernTF;

    @FXML
    private Label userpLB;

    @FXML
    private TextField userpTF;

    @FXML
    void quitSystem(ActionEvent event) throws IOException 
    {
        // get a handle to the stage
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void switchToOptions(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert backBT != null;
        assert credLB != null;
        assert signOutPane != null;
        assert signoutBT != null;
        assert signoutLB != null;
        assert usernLB != null;
        assert usernTF != null;
        assert userpLB != null;
        assert userpTF != null;

    }

}
