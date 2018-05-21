/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
        

/**
 *
 * @author User
 */
public class BiblioEasy extends Application {
    
    @Override
    public void start (Stage stage) throws Exception {
        initUI(stage);
    }
    
    private void initUI(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("coluna.fxml"));
         Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
   
}

