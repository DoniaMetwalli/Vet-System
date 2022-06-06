
package com.project217ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project217ui.Controllers.SignUpWindowController;

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

public class SignUpFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBT;

    @FXML
    private Label credLB;

    @FXML
    private Pane signUpPane;

    @FXML
    private Button signUpBT;

    @FXML
    private Label signUpLB;

    @FXML
    private Label usernLB;

    @FXML
    private TextField usernTF;

    @FXML
    private Label userpLB;

    @FXML
    private TextField userpTF;

    @FXML
    private Label messageLB;
    @FXML
    void addDoctor(ActionEvent event) throws IOException 
    {
        if(SignUpWindowController.SignUp(usernTF.getText(), userpTF.getText()))
        {
            Parent root = FXMLLoader.load(getClass().getResource("SignUpSuccessFrame.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            messageLB.setText("Adding the Doctor Failed, username already in use");
        }
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
        assert signUpPane != null;
        assert signUpBT != null;
        assert signUpLB != null;
        assert usernLB != null;
        assert usernTF != null;
        assert userpLB != null;
        assert userpTF != null;
        assert messageLB !=null;
    }

}
