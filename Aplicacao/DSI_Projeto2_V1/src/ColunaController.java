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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ColunaController implements Initializable {

    @FXML
    private TableView<Utilizador> tableUti = new TableView<Utilizador>();
    
    private final ObservableList<Utilizador> dataUtilizadores =
        FXCollections.observableArrayList(
            new Utilizador("9845231", "Smith", "21654258","sfs@sdg.com","Rua sdfegg","561606"),
            new Utilizador("651345", "Paulo", "23642645","sfs@sdg.com","Rua sdfegg","561606")
        );
    @FXML
    private TableView<Livro> tableLiv = new TableView<Livro>();
    
        private final ObservableList<Livro> dataLivros =
        FXCollections.observableArrayList(
            new Livro("123","titulo","tema","autor","editora","data","N","N"),
            new Livro("1223","titulo2","tema2","autor2","editora2","data2","N","N")
        );
    @FXML
    private TableView<Requisicao> tableReq = new TableView<Requisicao>();
    
        private final ObservableList<Requisicao> dataRequisicao =
        FXCollections.observableArrayList(
            new Requisicao("123","12345789","dataRe","DataEnt"),
            new Requisicao("1223","987654321","dataRe2","DataEnt2")
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
    
    @FXML
    private TableColumn liv_nLiv_col = new TableColumn();
    @FXML
    private TableColumn liv_titu_col = new TableColumn();
    @FXML
    private TableColumn liv_tema_col = new TableColumn();
    @FXML
    private TableColumn liv_aut_col = new TableColumn();
    @FXML
    private TableColumn liv_edi_col = new TableColumn();
    @FXML
    private TableColumn liv_data_col = new TableColumn();
    @FXML
    private TableColumn liv_requi_col = new TableColumn();
    @FXML
    private TableColumn liv_ina_col = new TableColumn();
    
    @FXML
    private TableColumn req_nLiv_col = new TableColumn();
    @FXML
    private TableColumn req_cc_col = new TableColumn();
    @FXML
    private TableColumn req_dReq_col = new TableColumn();
    @FXML
    private TableColumn req_dEnt_col = new TableColumn();
    @FXML
    private TextField regUtiCc;
    @FXML
    private TextField RegUtiNome;
    @FXML
    private TextField RegUtiCont;
    @FXML
    private TextField RegUtiEmail;
    @FXML
    private TextField RegUtiMorada;
    @FXML
    private TextField RegUtiNif;
    @FXML
    private TextField regLivNum;
    @FXML
    private TextField regLivTitulo;
    @FXML
    private TextField regLivEditora;
    @FXML
    private TextField regLivAutor;
    @FXML
    private DatePicker regLivData;
    @FXML
    private TextField regLivTema;
    @FXML
    private Text regLiviErroNumero;
    @FXML
    private Text regLiviErroTitulo;
    @FXML
    private Text regLiviErroAutor;
    @FXML
    private Text regLiviErroEditora;
    @FXML
    private Text regLiviErroTema;
    @FXML
    private Text regLiviErroData;
    @FXML
    private Text regUtiErroCc;
    @FXML
    private Text regUtiErroContacto;
    @FXML
    private Text regUtiErroNome;
    @FXML
    private Text regUtiErroEmail;
    @FXML
    private Text regUtiErroMorada;
    @FXML
    private Text regUtiErroNif;
    @FXML
    private Pane regUtiWindow;
    @FXML
    private Pane regLivWindow;



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
        
        liv_nLiv_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("nLivro"));
        liv_titu_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("titulo"));
        liv_tema_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("tema"));
        liv_aut_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("autor"));
        liv_edi_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("editora"));
        liv_data_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("data"));
        liv_requi_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("requisitado"));
        liv_ina_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("inativo"));
        
        req_nLiv_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("nLivro"));
        req_cc_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("cc"));
        req_dReq_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("dRequisicao"));
        req_dEnt_col.setCellValueFactory(
                new PropertyValueFactory<Utilizador, String>("dEntrega"));
 
        dataUtilizadores.add(new Utilizador("123456789","Flavio","239444444","eu@eu.com","Rua da esquerda","123456789"));
        tableUti.setItems(dataUtilizadores);
        tableLiv.setItems(dataLivros);
        tableReq.setItems(dataRequisicao);
        fecharJanelas();

    }   

    @FXML
    private void click(MouseEvent e) {
      //  e.getPickResult();
        //System.out.println(e);
        EventTarget nome = e.getTarget();
        System.out.println(nome);
        
    }

    @FXML
    private void registarUtilizador(ActionEvent event) 
    {
        boolean flag = true;
        regUtiErroCc.setVisible(false);
        regUtiErroContacto.setVisible(false);
        regUtiErroEmail.setVisible(false);
        regUtiErroMorada.setVisible(false);
        regUtiErroNif.setVisible(false);
        regUtiErroNome.setVisible(false);
        String cont = new String(RegUtiCont.getText());
        if (isInteger(cont) == 0)
        {
            regUtiErroContacto.setVisible(true);
            regUtiErroContacto.setText("Contem caraters invalidos");
            regUtiErroContacto.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if(cont.length() != 9)
        {
            regUtiErroContacto.setVisible(true);
            regUtiErroContacto.setText("Numero de telefone Inválido");
            regUtiErroContacto.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        String nif = new String(RegUtiNif.getText());
        if (isInteger(nif) == 0)
        {
            regUtiErroNif.setVisible(true);
            regUtiErroNif.setText("Contem caraters invalidos");
            regUtiErroNif.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if(nif.length() != 9)
        {
            regUtiErroNif.setVisible(true);
            regUtiErroNif.setText("Numero fiscal Inválido");
            regUtiErroNif.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        String mail = new String(RegUtiEmail.getText());
        if(mail.indexOf("@")==-1) //verifica se o e-mail tem o @
        {
            regUtiErroEmail.setVisible(true);
            regUtiErroEmail.setText("Email Inválido");
            regUtiErroEmail.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (RegUtiNome.getText().length() == 0)
        {
            regUtiErroNome.setVisible(true);
            regUtiErroNome.setText("Nome Inválido");
            regUtiErroNome.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (regUtiCc.getText().length() == 0)
        {
            regUtiErroCc.setVisible(true);
            regUtiErroCc.setText("CC/TR Inválido");
            regUtiErroCc.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (RegUtiMorada.getText().length() == 0)
        {
            regUtiErroMorada.setVisible(true);
            regUtiErroMorada.setText("Morada Inválido");
            regUtiErroMorada.setFill(Paint.valueOf("Red"));
            flag = false;
        }     
        if(flag)
        {
            dataUtilizadores.add(new Utilizador(regUtiCc.getText(),RegUtiNome.getText(),cont,mail,RegUtiMorada.getText(),nif));
            fecharJanelas();
            //falta chamar a função da janela que confirma registo com sucesso
        }
    }

    @FXML
    private void registarLivro(ActionEvent event) 
    {
        boolean flag = true;
        regLiviErroAutor.setVisible(false);
        regLiviErroData.setVisible(false);
        regLiviErroEditora.setVisible(false);
        regLiviErroNumero.setVisible(false);
        regLiviErroTema.setVisible(false);
        regLiviErroTitulo.setVisible(false);
        
        String n = new String(regLivNum.getText());
        if (isInteger(n) == 0)
        {
            regLiviErroNumero.setVisible(true);
            regLiviErroNumero.setText("Contem caraters invalidos");
            regLiviErroNumero.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (regLivTitulo.getText().length() == 0)
        {
            regLiviErroTitulo.setVisible(true);
            regLiviErroTitulo.setText("Titulo Inválido");
            regLiviErroTitulo.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (regLivTema.getText().length() == 0)
        {
            regLiviErroTema.setVisible(true);
            regLiviErroTema.setText("Tema Inválido");
            regLiviErroTema.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (regLivAutor.getText().length() == 0)
        {
            regLiviErroAutor.setVisible(true);
            regLiviErroAutor.setText("Autor Inválido");
            regLiviErroAutor.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (regLivEditora.getText().length() == 0)
        {
            regLiviErroEditora.setVisible(true);
            regLiviErroEditora.setText("Editora Inválido");
            regLiviErroEditora.setFill(Paint.valueOf("Red"));
            flag = false;
        }
       // falta validação para ver se a data está vazia -> regLivData.get
       // falta fazer o add
        
    }

    @FXML
    private void sairJanela(ActionEvent event) 
    {
        fecharJanelas();
    }
    
    public void fecharJanelas()
    {
        tableUti.setVisible(false);
        tableReq.setVisible(false);
        tableLiv.setVisible(false);
        regLivWindow.setVisible(false);
        regUtiWindow.setVisible(false);
    }
            
    public int isInteger(String test){
        try{
            return Integer.parseInt(test.trim());
        }catch(Exception e){
            return 0;
        }
    }
    

    @FXML
    private void pesquisarUtilizador(ActionEvent event) 
    {
        fecharJanelas();
        tableUti.setVisible(true);
    }

    @FXML
    private void pesquisarLivro(ActionEvent event) 
    {
        fecharJanelas();
        tableLiv.setVisible(true);
    }

    @FXML
    private void pesquisarRequisicoes(ActionEvent event) 
    {
        fecharJanelas();
        tableReq.setVisible(true);
    }

    @FXML
    private void registarUtilizadorJanela(ActionEvent event) 
    {
        fecharJanelas();
        regUtiWindow.setVisible(true);
    }

    @FXML
    private void registarLivroJanela(ActionEvent event) 
    {
        fecharJanelas();
        regLivWindow.setVisible(true);
    }

    @FXML
    private void registarRequisicoesJanela(ActionEvent event) {
    }
   
}


