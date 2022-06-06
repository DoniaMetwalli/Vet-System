package com.project217ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private static App instance;
    public static App Instance()
    {
        return instance;
    }
    @Override
    public void start(Stage stage) throws IOException 
    {
        instance =this;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignInFrame.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setTitle("CutePet Vet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        
        launch();
    }

}