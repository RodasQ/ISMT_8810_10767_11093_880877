/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ColunaController implements Initializable {

    @FXML
    private TableView<Utilizador> table = new TableView<Utilizador>();
    
    private final ObservableList<Utilizador> data =
        FXCollections.observableArrayList(
            new Utilizador("9845231", "Smith", "21654258","sfs@sdg.com","Rua sdfegg","561606"),
            new Utilizador("651345", "Paulo", "23642645","sfs@sdg.com","Rua sdfegg","561606")
        );
    @FXML
    private TableColumn uti_cc_col = new TableColumn();
    @FXML
    private TableColumn uti_nome_col = new TableColumn();
    @FXML
    private TableColumn uti_cont_col = new TableColumn();
    @FXML
    private TableColumn uti_mail_col = new TableColumn();
    @FXML
    private TableColumn uti_mora_col = new TableColumn();
    @FXML
    private TableColumn uti_nif_col = new TableColumn();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
      //  table.setEditable(true);
 
        uti_cc_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("cc"));
        uti_nome_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("nome"));
        uti_cont_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("contacto"));
        uti_mail_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("email"));
        uti_mora_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("morada"));
        uti_nif_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("nif"));
 
        data.add(new Utilizador("123456789","Flavio","239444444","eu@eu.com","Rua da esquerda","123456789"));
        table.setItems(data);

    }   

    @FXML
    private void click(MouseEvent e) {
      //  e.getPickResult();
        //System.out.println(e);
        EventTarget nome = e.getTarget();
        System.out.println(nome);
        
    }
            
    
   
}


