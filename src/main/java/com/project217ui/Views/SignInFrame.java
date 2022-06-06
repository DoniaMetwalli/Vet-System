package com.project217ui.Views;

import java.io.IOException;

import com.project217ui.App;
import com.project217ui.Controllers.SignInController;

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
    private Label messageLB;

    @FXML
    private Button quitBT;

    @FXML
    void quitSystem(ActionEvent event) throws IOException 
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // do what you have to do
        stage.close();
        // get a handle to the stage
    }
    @FXML
    void switchToOptions(ActionEvent event) throws IOException
    {
        if(SignInController.CheckLoginInfo(usernameTF.getText(), passwordTF.getText()))
        {
            System.out.println("MMMMMM");
            
            
            Parent root = FXMLLoader.load(App.Instance().getClass().getResource("OptionsFrame.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            System.out.println(usernameTF.getText()+passwordTF.getText());
            messageLB.setText("Incorrect Username or Password");
        }
    }

}
