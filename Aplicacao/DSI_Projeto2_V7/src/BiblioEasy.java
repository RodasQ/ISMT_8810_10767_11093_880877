/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.stage.WindowEvent;
        

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

        stage.setTitle("BiblioEasy");
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) 
            {
                
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sair?");
                alert.setHeaderText("Quer sair sem gravar?");
              //  alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                {
                    Platform.exit();
                    System.exit(0);
                } else {
                    event.consume();
}
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
   
}

