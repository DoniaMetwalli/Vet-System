package com.project217ui.Views;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.project217ui.Controllers.ViewPetFrameController;

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
import com.project217ui.App;
public class ViewPetFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button updateViewBT;

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
    private Label diagnosisViewLB;
    
    @FXML
    private Label weightViewLB;
    
    @FXML
    private TextField weightViewTF;

    @FXML
    private TextField diagnosisViewTF;

    @FXML
    void getPet(ActionEvent event) throws IOException
    {
        HashMap<String,String> petInfo = ViewPetFrameController.RetrievePetInfo(pIDViewTF.getText());
        if (petInfo==null|| petInfo.isEmpty())
        {
            resultsViewLB.setText("Results: ID not Found");
            oNameViewTF.setText("");
            pNameViewTF.setText("");
            oPhoneViewTF.setText("");
            pBreedViewTF.setText("");
            reasonViewTF.setText("");
            diagnosisViewTF.setText("");
            pAgeViewTF.setText("");
            weightViewTF.setText("");
        }
        else
        {
            pNameViewTF.setText(petInfo.get("PetName"));
            oNameViewTF.setText(petInfo.get("OwnerName"));
            oPhoneViewTF.setText(petInfo.get("OwnerPhone"));
            pBreedViewTF.setText( petInfo.get("PetBreed"));
            reasonViewTF.setText(petInfo.get("VisitReason"));
            diagnosisViewTF.setText(petInfo.get("Diagnosis"));
            pAgeViewTF.setText(petInfo.get("Age"));
            weightViewTF.setText(petInfo.get("Weight"));
        }        
    }

    @FXML
    void switchToOptionsMV(ActionEvent event) throws IOException
    {        
        if(ViewPetFrameController.UpdatePetInfo(oNameViewTF.getText(), oPhoneViewTF.getText(), pIDViewTF.getText(), pNameViewTF.getText(), pBreedViewTF.getText(),pAgeViewTF.getText(), reasonViewTF.getText(), weightViewTF.getText(), diagnosisViewTF.getText()).equals(""))
        {
            Parent root = FXMLLoader.load(App.Instance().getClass().getResource("OptionsFrame.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            resultsViewLB.setText("Results: Error Updating Pet");
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
        assert updateViewBT != null;
        assert oNameViewLB != null;
        assert oNameViewTF != null;
        assert oPhoneViewLB != null;
        assert oPhoneViewTF != null;
        assert pAgeViewLB != null;
        assert pAgeViewTF != null;
        assert pBreedViewLB != null;
        assert pBreedViewTF != null;
        assert pIDViewLB != null;
        assert pIDViewTF != null;
        assert pNameViewLB != null;
        assert pNameViewTF != null;
        assert reasonViewLB != null;
        assert reasonViewTF != null;
        assert resultsViewLB != null;
        assert searchViewBT != null;
        assert viewLB != null;

    }

}
