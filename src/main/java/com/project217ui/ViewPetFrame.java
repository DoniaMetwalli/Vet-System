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
import javafx.stage.Stage;

public class ViewPetFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button doneViewBT;

    @FXML
    private Button backBT;

    @FXML
    private Label oNameViewLB;

    @FXML
    private TextField oNameViewTF;

    @FXML
    private Label oPhoneViewLB;

    @FXML
    private TextField oPhoneViewTF;

    @FXML
    private Label pAgeViewLB;

    @FXML
    private TextField pAgeViewTF;

    @FXML
    private Label pBreedViewLB;

    @FXML
    private TextField pBreedViewTF;

    @FXML
    private Label pIDViewLB;

    @FXML
    private TextField pIDViewTF;

    @FXML
    private Label pNameViewLB;

    @FXML
    private TextField pNameViewTF;

    @FXML
    private Label reasonViewLB;

    @FXML
    private TextField reasonViewTF;

    @FXML
    private Label resultsViewLB;

    @FXML
    private Button searchViewBT;

    @FXML
    private Label viewLB;

    @FXML
    void switchToOptionsMV(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        assert doneViewBT != null : "fx:id=\"doneViewBT\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert oNameViewLB != null : "fx:id=\"oNameViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert oNameViewTF != null : "fx:id=\"oNameViewTF\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert oPhoneViewLB != null : "fx:id=\"oPhoneViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert oPhoneViewTF != null : "fx:id=\"oPhoneViewTF\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pAgeViewLB != null : "fx:id=\"pAgeViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pAgeViewTF != null : "fx:id=\"pAgeViewTF\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pBreedViewLB != null : "fx:id=\"pBreedViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pBreedViewTF != null : "fx:id=\"pBreedViewTF\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pIDViewLB != null : "fx:id=\"pIDViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pIDViewTF != null : "fx:id=\"pIDViewTF\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pNameViewLB != null : "fx:id=\"pNameViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert pNameViewTF != null : "fx:id=\"pNameViewTF\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert reasonViewLB != null : "fx:id=\"reasonViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert reasonViewTF != null : "fx:id=\"reasonViewTF\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert resultsViewLB != null : "fx:id=\"resultsViewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert searchViewBT != null : "fx:id=\"searchViewBT\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";
        assert viewLB != null : "fx:id=\"viewLB\" was not injected: check your FXML file 'ViewPetFrame.fxml'.";

    }

}
