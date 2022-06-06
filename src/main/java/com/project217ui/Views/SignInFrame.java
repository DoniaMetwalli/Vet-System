package com.project217ui.Views;

import com.project217ui.App;
import com.project217ui.Controllers.SignInController;

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
import com.project217ui.App;

public class SignInFrame {

    // Retrieve ui elements from the FXML file

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

    /**
     * Exits the program
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void quitSystem(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // do what you have to do
        stage.close();
        // get a handle to the stage
    }

    /**
     * Logs Into the program and switches to Login Screen
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void switchToOptions(ActionEvent event) throws IOException {
        if (SignInController.CheckLoginInfo(usernameTF.getText(), passwordTF.getText())) {
            Parent root = FXMLLoader.load(App.Instance().getClass().getResource("OptionsFrame.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println(usernameTF.getText() + passwordTF.getText());
            messageLB.setText("Incorrect Username or Password");
        }
    }

}
