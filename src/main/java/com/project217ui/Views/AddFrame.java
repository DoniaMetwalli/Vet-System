package com.project217ui.Views;

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
import com.project217ui.App;
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
            Parent root = FXMLLoader.load(App.Instance().getClass().getResource("AddSuccessFrame.fxml"));
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
        Parent root = FXMLLoader.load(App.Instance().getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert addPane != null;
        assert doneAddBT != null;
        assert introAddLB != null;
        assert oNameLB != null;
        assert oNameTF != null;
        assert oPhoneLB != null;
        assert oPhoneTF != null;
        assert pAgeLB != null;
        assert pAgeTF != null;
        assert pBreedLB != null;
        assert pBreedTF != null;
        assert pIDLB != null;
        assert pIDTF != null;
        assert pNameLB != null;
        assert pNameTF != null;
        assert rVisitLB != null;
        assert rVisitTF != null;
        assert titleAddLB != null;

    }

}
