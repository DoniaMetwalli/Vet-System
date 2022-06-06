package com.project217ui.Views;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.project217ui.App;
public class DeleteSuccessFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button delNextBT;

    @FXML
    private Pane delSuPane;

    @FXML
    private Label delSucLB;

    @FXML
    void switchToOptionMD(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(App.Instance().getClass().getResource("OptionsFrame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert delNextBT != null;
        assert delSuPane != null;
        assert delSucLB != null;

    }

}
