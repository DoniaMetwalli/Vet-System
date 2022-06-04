package com.project217ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project217ui.Controllers.DeletePetFrameController;
import java.util.HashMap;
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

public class DeleteFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteBT;

    @FXML
    private Button backBT;

    @FXML
    private Pane deletePane;

    @FXML
    private Label introDeleteLB;

    @FXML
    private Label oNameDelLB;

    @FXML
    private TextField oNameDelTF;

    @FXML
    private Label oPhoneDelLB;

    @FXML
    private TextField oPhoneDelTF;

    @FXML
    private TextField pAgeDelTF;

    @FXML
    private Label pBreedDelLB;

    @FXML
    private TextField pBreedDelTF;

    @FXML
    private Label pNameDelLB;

    @FXML
    private TextField pNameDelTF;

    @FXML
    private TextField petIDDelTF;

    @FXML
    private Label reasonDelLB;

    @FXML
    private TextField reasonDelTF;

    @FXML
    private Label resultsLB;

    @FXML
    private Button searchBT;

    @FXML
    private Label searchPIDLB;

    @FXML
    private Label titleDeleteLB;

    @FXML
    private Label diagnosisDelLB;
    
    @FXML
    private Label weightDelLB;
    
    @FXML
    private TextField weightDelTF;

    @FXML
    private TextField diagnosisDelTF;

     @FXML
    void getPet(ActionEvent event) throws IOException
    {
        HashMap<String,String> petInfo = DeletePetFrameController.RetrievePetInfo(petIDDelTF.getText());
        if (petInfo==null|| petInfo.isEmpty())
        {
            resultsLB.setText(resultsLB.getText()+" ID not Found");
            oNameDelTF.setText("");
            pNameDelTF.setText("");
            oPhoneDelTF.setText("");
            pBreedDelTF.setText("");
            reasonDelTF.setText("");
            diagnosisDelTF.setText("");
            pAgeDelTF.setText("");
            weightDelTF.setText("");
        }
        else
        {
            pNameDelTF.setText(petInfo.get("PetName"));
            oNameDelTF.setText(petInfo.get("OwnerName"));
            oPhoneDelTF.setText(petInfo.get("OwnerPhone"));
            pBreedDelTF.setText( petInfo.get("PetBreed"));
            reasonDelTF.setText(petInfo.get("VisitReason"));
            diagnosisDelTF.setText(petInfo.get("Diagnosis"));
            pAgeDelTF.setText(petInfo.get("Age"));
            weightDelTF.setText(petInfo.get("Weight"));
        }        
    }

    @FXML
    void switchToDelS(ActionEvent event) throws IOException
    {
        if(DeletePetFrameController.RetrievePetInfo(petIDDelTF.getText())!=null&&DeletePetFrameController.RemovePet(petIDDelTF.getText()))
        {
            Parent root = FXMLLoader.load(getClass().getResource("DeleteSuccessFrame.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            resultsLB.setText("Results: Pet Couldn't be removed recheck ID");
        }
    }

    @FXML
    void toBackD(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert deleteBT != null : "fx:id=\"deleteBT\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert deletePane != null : "fx:id=\"deletePane\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert introDeleteLB != null : "fx:id=\"introDeleteLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert oNameDelLB != null : "fx:id=\"oNameDelLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert oNameDelTF != null : "fx:id=\"oNameDelTF\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert oPhoneDelLB != null : "fx:id=\"oPhoneDelLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert oPhoneDelTF != null : "fx:id=\"oPhoneDelTF\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert pAgeDelTF != null : "fx:id=\"pAgeDelTF\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert pBreedDelLB != null : "fx:id=\"pBreedDelLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert pBreedDelTF != null : "fx:id=\"pBreedDelTF\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert pNameDelLB != null : "fx:id=\"pNameDelLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert pNameDelTF != null : "fx:id=\"pNameDelTF\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert petIDDelTF != null : "fx:id=\"petIDDelTF\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert reasonDelLB != null : "fx:id=\"reasonDelLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert reasonDelTF != null : "fx:id=\"reasonDelTF\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert resultsLB != null : "fx:id=\"resultsLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert searchBT != null : "fx:id=\"searchBT\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert searchPIDLB != null : "fx:id=\"searchPIDLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";
        assert titleDeleteLB != null : "fx:id=\"titleDeleteLB\" was not injected: check your FXML file 'DeleteFrame.fxml'.";

    }

}
