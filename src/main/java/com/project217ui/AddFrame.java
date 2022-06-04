package com.project217ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project217ui.Controllers.AddFrameController;

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

public class AddFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane addPane;

    @FXML
    private Button doneAddBT;

    @FXML
    private Button backBT;

    @FXML
    private Label introAddLB;

    @FXML
    private Label oNameLB;

    @FXML
    private TextField oNameTF;

    @FXML
    private Label oPhoneLB;

    @FXML
    private TextField oPhoneTF;

    @FXML
    private Label pAgeLB;

    @FXML
    private TextField pAgeTF;

    @FXML
    private Label pBreedLB;

    @FXML
    private TextField pBreedTF;

    @FXML
    private Label pIDLB;

    @FXML
    private TextField pIDTF;

    @FXML
    private Label pNameLB;

    @FXML
    private TextField pNameTF;

    @FXML
    private Label rVisitLB;

    @FXML
    private TextField rVisitTF;

    @FXML
    private Label titleAddLB;

    @FXML
    private Label weightLB;

    @FXML
    private Label diagnosisLB;
    
    @FXML
    private TextField weightTF;
    
    @FXML 
    private TextField diagnosisTF;
    @FXML
    private Label messageLB;
    @FXML
    void switchToAddS(ActionEvent event) throws IOException
    {
        messageLB.setText("");
        String res =AddFrameController.AddPet(oNameTF.getText(),oPhoneTF.getText(), pIDTF.getText(),pNameTF.getText(),pBreedTF.getText(), pAgeTF.getText(), rVisitTF.getText(),weightTF.getText(),diagnosisTF.getText());
        if(res=="")
        {
            Parent root = FXMLLoader.load(getClass().getResource("AddSuccessFrame.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            messageLB.setText(res);
        }        
    }

    @FXML
    void toBack(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert addPane != null : "fx:id=\"addPane\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert doneAddBT != null : "fx:id=\"doneAddBT\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert introAddLB != null : "fx:id=\"introAddLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert oNameLB != null : "fx:id=\"oNameLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert oNameTF != null : "fx:id=\"oNameTF\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert oPhoneLB != null : "fx:id=\"oPhoneLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert oPhoneTF != null : "fx:id=\"oPhoneTF\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pAgeLB != null : "fx:id=\"pAgeLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pAgeTF != null : "fx:id=\"pAgeTF\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pBreedLB != null : "fx:id=\"pBreedLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pBreedTF != null : "fx:id=\"pBreedTF\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pIDLB != null : "fx:id=\"pIDLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pIDTF != null : "fx:id=\"pIDTF\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pNameLB != null : "fx:id=\"pNameLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert pNameTF != null : "fx:id=\"pNameTF\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert rVisitLB != null : "fx:id=\"rVisitLB\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert rVisitTF != null : "fx:id=\"rVisitTF\" was not injected: check your FXML file 'AddFrame.fxml'.";
        assert titleAddLB != null : "fx:id=\"titleAddLB\" was not injected: check your FXML file 'AddFrame.fxml'.";

    }

}
