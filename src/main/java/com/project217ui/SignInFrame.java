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

public class SignInFrame {

    @FXML
    private Button enterSignBT;

    @FXML
    private Label introLB;

    @FXML
    private Pane mainPane;

    @FXML
    private Label passwordLB;

    @FXML
    private TextField passwordTF;

    @FXML
    private Label signinLB;

    @FXML
    private Label usernameLB;

    @FXML
    private TextField usernameTF;

    @FXML
    void switchToOptions(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
