/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.cell.TextFieldTableCell;
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
            new Utilizador("589624782", "André","01-07-1989", "915896547","andre@gmail.com","Rua do Brasil","Coimbra","842498745"),
            new Utilizador("289756586", "Flávio","10-05-1990", "912568749","flavio@gmail.com","Praça da República","Coimbra","125483314")
        );
    @FXML
    private TableView<Livro> tableLiv = new TableView<Livro>();
    
        private final ObservableList<Livro> dataLivros =
        FXCollections.observableArrayList(
            new Livro("1","Anjos e Demónios","policial","Dan Brown","Asa","01-04-2003","N","N"),
            new Livro("2","Harry Potter e a Câmera dos Segredos","magia","J.K.Rowlings","Asa","01-02/2001","N","N")
        );
    @FXML
    private TableView<Requisicao> tableReq = new TableView<Requisicao>();
    
        private final ObservableList<Requisicao> dataRequisicao =
        FXCollections.observableArrayList(
            new Requisicao("1","589624782","16-05-2018","A colocar"),
            new Requisicao("2","289756586","03-05-2017","A colocar")
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
    private TableColumn uti_dNasc_col = new TableColumn();
    @FXML
    private TableColumn uti_loc_col = new TableColumn();
    
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
    @FXML
    private Text regUtiErroData;
    @FXML
    private Text regUtiErroLocalidade;
    @FXML
    private TextField regUtiNome;
    @FXML
    private DatePicker regUtiDataNasc;
    @FXML
    private TextField regUtiCont;
    @FXML
    private TextField regUtiEmail;
    @FXML
    private TextField regUtiMorada;
    @FXML
    private TextField regUtiLocalidade;
    @FXML
    private TextField regUtiNif;
    @FXML
    private Pane regReqWindow;
    @FXML
    private TextField regReqCC;
    @FXML
    private TextField regReqLivro;
    @FXML
    private Text regReqErroCc;
    @FXML
    private Text regReqErroDReq;
    @FXML
    private Text regReqErroLivro;
    @FXML
    private Text regReqErroDEnt;
    @FXML
    private DatePicker regReqDReq;
    @FXML
    private DatePicker regReqDEnt;
    @FXML
    private Pane regReqEntregaWindow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
      //  table.setEditable(true);
 
        uti_cc_col.setCellValueFactory(
                new PropertyValueFactory("cc"));
        uti_nome_col.setCellValueFactory(
                new PropertyValueFactory("nome"));
        uti_dNasc_col.setCellValueFactory(
                new PropertyValueFactory("dNascimento"));
        uti_cont_col.setCellValueFactory(
                new PropertyValueFactory("contacto"));
        uti_mail_col.setCellValueFactory(
                new PropertyValueFactory("email"));
        uti_mora_col.setCellValueFactory(
                new PropertyValueFactory("morada"));
        uti_loc_col.setCellValueFactory(
                new PropertyValueFactory("localidade"));
        uti_nif_col.setCellValueFactory(
                new PropertyValueFactory("nif"));
        
        liv_nLiv_col.setCellValueFactory(
                new PropertyValueFactory("nLivro"));
        liv_titu_col.setCellValueFactory(
                new PropertyValueFactory("titulo"));
        liv_tema_col.setCellValueFactory(
                new PropertyValueFactory("tema"));
        liv_aut_col.setCellValueFactory(
                new PropertyValueFactory("autor"));
        liv_edi_col.setCellValueFactory(
                new PropertyValueFactory("editora"));
        liv_data_col.setCellValueFactory(
                new PropertyValueFactory("data"));
        liv_requi_col.setCellValueFactory(
                new PropertyValueFactory("requisitado"));
        liv_ina_col.setCellValueFactory(
                new PropertyValueFactory("inativo"));
        
        req_nLiv_col.setCellValueFactory(
                new PropertyValueFactory("nLivro"));
        req_cc_col.setCellValueFactory(
                new PropertyValueFactory("cc"));
        req_dReq_col.setCellValueFactory(
                new PropertyValueFactory("dRequisicao"));
        req_dEnt_col.setCellValueFactory(
                new PropertyValueFactory("dEntrega"));
 
        
        uti_cc_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_cont_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_dNasc_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_loc_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_mail_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_mora_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_nif_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_nome_col.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        liv_aut_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_data_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_edi_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_ina_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_nLiv_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_requi_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_tema_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_titu_col.setCellFactory(TextFieldTableCell.forTableColumn());
        
        req_nLiv_col.setCellFactory(TextFieldTableCell.forTableColumn());
        req_cc_col.setCellFactory(TextFieldTableCell.forTableColumn());
        req_dReq_col.setCellFactory(TextFieldTableCell.forTableColumn());
        req_dEnt_col.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
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
        if(validarRegistarUtilizador())
        {
            dataUtilizadores.add(new Utilizador(regUtiCc.getText(),regUtiNome.getText(),regUtiDataNasc.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),regUtiCont.getText(),regUtiEmail.getText(),regUtiMorada.getText(),regUtiLocalidade.getText(),regUtiNif.getText()));
            fecharJanelas();
            //falta chamar a função da janela que confirma registo com sucesso
        }
    }
    
    private boolean validarRegistarUtilizador ()
    {
        boolean flag = true;
        regUtiErroCc.setVisible(false);
        regUtiErroContacto.setVisible(false);
        regUtiErroEmail.setVisible(false);
        regUtiErroMorada.setVisible(false);
        regUtiErroNif.setVisible(false);
        regUtiErroNome.setVisible(false);
        String cont = new String(regUtiCont.getText());
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
        String nif = new String(regUtiNif.getText());
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
        String mail = new String(regUtiEmail.getText());
        if(mail.indexOf("@")==-1) //verifica se o e-mail tem o @
        {
            regUtiErroEmail.setVisible(true);
            regUtiErroEmail.setText("Email Inválido");
            regUtiErroEmail.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (regUtiNome.getText().length() == 0)
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
        if (regUtiMorada.getText().length() == 0)
        {
            regUtiErroMorada.setVisible(true);
            regUtiErroMorada.setText("Morada Inválido");
            regUtiErroMorada.setFill(Paint.valueOf("Red"));
            flag = false;
        }   
        if (regUtiDataNasc.getValue() == null)
        {
            regUtiErroLocalidade.setVisible(true);
            regUtiErroLocalidade.setText("Data Inválida");
            regUtiErroLocalidade.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (regUtiLocalidade.getText().length() == 0)
        {
            regUtiErroLocalidade.setVisible(true);
            regUtiErroLocalidade.setText("Morada Inválido");
            regUtiErroLocalidade.setFill(Paint.valueOf("Red"));
            flag = false;
        }  
        if(flag)
        {
            System.out.println("true");
            return true;
        }
        else return false;
    }

    @FXML
    private void registarLivro(ActionEvent event) 
    {
        if(validarRegistarLivro())
        {
        //    String datatest = regLivData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            dataLivros.add(new Livro(regLivNum.getText(), regLivTitulo.getText(), regLivTema.getText(), regLivAutor.getText(), regLivEditora.getText(), regLivData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), "N", "N"));
            fecharJanelas();
        }
        
    }

    private boolean validarRegistarLivro()
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
        if (regLivData.getValue() == null)
        {
            regLiviErroData.setVisible(true);
            regLiviErroData.setText("Data Inválida");
            regLiviErroData.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if(flag)
        {
            return true;
        }
        else return false;
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
        regReqWindow.setVisible(false);
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
    private void registarRequisicoesJanela(ActionEvent event) 
    {
        fecharJanelas();
        regReqWindow.setVisible(true);
        regReqEntregaWindow.setVisible(false);
    }

    @FXML
    private void registarRequisicao(ActionEvent event) 
    {
        validarRegistarRequisicao();
    }
    
    private boolean validarRegistarRequisicao()
    {
        boolean flag = true;
        regReqErroCc.setVisible(false);
        regReqErroDEnt.setVisible(false);
        regReqErroDReq.setVisible(false);
        regReqErroLivro.setVisible(false);
        
        System.out.println(uti_cc_col.getCellData(2));
            //    contains(regReqCC.getText()));
        return true;
    }
    
    private int colunaIndexOf()
    {
        return 0;
    }
   
}


