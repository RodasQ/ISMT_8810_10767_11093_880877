/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
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
            new Utilizador("589624782", "André","01-07-1989", "915896547","andre@gmail.com","Rua do Brasil","Coimbra","842498745","Aluno"),
            new Utilizador("289756586", "Flávio","10-05-1990", "912568749","flavio@gmail.com","Praça da República","Coimbra","125483314","Aluno"),
            new Utilizador("965235783", "Rodrigo","03-02-1994", "962315696", "rodrigo@email.com","Avenida", "Coimbra", "654236957","Aluno")
        );
    @FXML
    private TableView<Livro> tableLiv = new TableView<Livro>();
    
        private final ObservableList<Livro> dataLivros =
        FXCollections.observableArrayList(
            new Livro("1","Anjos e Demónios","policial","Dan Brown","Asa","01-04-2003","Requisitado","Não"),
            new Livro("2","Harry Potter e a Câmera dos Segredos","magia","J.K.Rowlings","Asa","01-02-2001","Requisitado","Não"),
            new Livro("3","Juntos Para Sempre", "Ficção Literária", "W. Bruce Cameron","Asa","04-04-2017","Livre","Não")
        );
    @FXML
    private TableView<Requisicao> tableReq = new TableView<Requisicao>();
    
        private final ObservableList<Requisicao> dataRequisicao =
        FXCollections.observableArrayList(
            new Requisicao("1","589624782","16-04-2017",""),
            new Requisicao("2","289756586","03-05-2017","21-04-2018"),
            new Requisicao("2","589624782","22-04-2018","")
        );
        
    @FXML
    private TableView<Funcionario> tablefunc = new TableView<Funcionario>();
    
        private final ObservableList<Funcionario> dataFuncionario =
        FXCollections.observableArrayList(
            new Funcionario("Maria","Loira","123","Funcionario"),
            new Funcionario("John","admin","admin","Administrador")   
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
    private TableColumn uti_tipo_col = new TableColumn();
    
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
    private TableColumn req_dias_col = new TableColumn();
    
    @FXML
    private TableColumn func_nome_col = new TableColumn();
    @FXML
    private TableColumn func_login_col = new TableColumn();
    @FXML
    private TableColumn func_pass_col = new TableColumn();
    @FXML
    private TableColumn func_tipo_col = new TableColumn();
    
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
    @FXML
    private Pane regFuncWindow;
    @FXML
    private TextField regFuncNome;
    @FXML
    private TextField regFuncLogin;
    @FXML
    private Text regFuncErroNome;
    @FXML
    private Text regFuncErroPass;
    @FXML
    private Text regFuncErroLogin;
    @FXML
    private TextField regFuncPass;
    @FXML
    private Text regFuncErroTipo;
    @FXML
    private ComboBox<String> regFuncTipo;
    @FXML
    private ComboBox<String> regUtiTipo;
    @FXML
    private Text regUtiErroTipo;





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
        uti_tipo_col.setCellValueFactory(
                new PropertyValueFactory("tipo"));
        
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
        req_dias_col.setCellValueFactory(
                new PropertyValueFactory("dias"));
          
        func_nome_col.setCellValueFactory(
                new PropertyValueFactory("nome"));
        func_login_col.setCellValueFactory(
                new PropertyValueFactory("login"));
        func_pass_col.setCellValueFactory(
                new PropertyValueFactory("password"));
        func_tipo_col.setCellValueFactory(
                new PropertyValueFactory("tipo"));
 
        
        uti_cc_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_cont_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_dNasc_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_loc_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_mail_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_mora_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_nif_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_nome_col.setCellFactory(TextFieldTableCell.forTableColumn());
        uti_tipo_col.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        
        liv_aut_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_data_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_edi_col.setCellFactory(TextFieldTableCell.forTableColumn());
      //  liv_ina_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_nLiv_col.setCellFactory(TextFieldTableCell.forTableColumn());
       // liv_requi_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_tema_col.setCellFactory(TextFieldTableCell.forTableColumn());
        liv_titu_col.setCellFactory(TextFieldTableCell.forTableColumn());
        
//        req_nLiv_col.setCellFactory(TextFieldTableCell.forTableColumn());
//        req_cc_col.setCellFactory(TextFieldTableCell.forTableColumn());
//        req_dReq_col.setCellFactory(TextFieldTableCell.forTableColumn());
//        req_dEnt_col.setCellFactory(TextFieldTableCell.forTableColumn());

        func_nome_col.setCellFactory(TextFieldTableCell.forTableColumn());
        func_login_col.setCellFactory(TextFieldTableCell.forTableColumn());
        func_pass_col.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        tableUti.setItems(dataUtilizadores);
        tableLiv.setItems(dataLivros);
        tableReq.setItems(dataRequisicao);
        tablefunc.setItems(dataFuncionario);
        fecharJanelas();
        
       // regFuncTipo.getItems().removeAll(regFuncTipo.getItems());
        regFuncTipo.getItems().addAll("Funcionario", "Administrador");
        regFuncTipo.getSelectionModel().select("Funcionario");
        
        //regUtiTipo.getItems().removeAll(regUtiTipo.getItems());
        regUtiTipo.getItems().addAll("Aluno","Docente", "Funcionario");
        regUtiTipo.getSelectionModel().select("Aluno");
        
        
        //System.out.println(tableUti.getItems().size());
        //System.out.println(uti_cc_col.getCellData(0));
        //colunaIndexOf("289756586");
        //System.out.println(LivNIndexOf("1"));

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
            dataUtilizadores.add(new Utilizador(regUtiCc.getText(), regUtiNome.getText(),regUtiDataNasc.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),regUtiCont.getText(),regUtiEmail.getText(),regUtiMorada.getText(),regUtiLocalidade.getText(),regUtiNif.getText(),regUtiTipo.getValue()));
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Registo com sucesso");
            alert.setHeaderText("Utilizador registado com sucesso!");
            //alert.setContentText("I have a great message for you!");
            alert.showAndWait();
            fecharJanelas();
        }
    }
    
    private boolean validarRegistarUtilizadorContacto(String cont)
    {
        boolean flag = true;
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
        return flag;
    }
    
    private boolean validarRegistarUtilizadorNif(String nif)
    {
        boolean flag = true;
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
        if (flag)
        {
            int checkSum=0;
        //calculate checkSum
        for (int i=0; i<nif.length()-1; i++){
            checkSum+=(nif.charAt(i)-'0')*(nif.length()-i);
        }
        int checkDigit=11-(checkSum % 11);
        //if checkDigit is higher than TEN set it to zero
        if (checkDigit>=10)
                        checkDigit=0;
                
        //compare checkDigit with the last number of NIF
         flag = checkDigit==nif.charAt(nif.length()-1)-'0';
                 if(!flag)
                 {
                    regUtiErroNif.setVisible(true);
                    regUtiErroNif.setText("Numero fiscal Inválido");
                    regUtiErroNif.setFill(Paint.valueOf("Red"));
                 }
                
        }
        return flag;
    }
    
    private boolean validarRegistarUtilizadorEmail(String mail)
    {
        boolean flag = true;
        if(mail.indexOf("@")==-1) //verifica se o e-mail tem o @
        {
            regUtiErroEmail.setVisible(true);
            regUtiErroEmail.setText("Email Inválido");
            regUtiErroEmail.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    
    private boolean validarRegistarUtilizadorNome(String nome)
    {
         boolean flag = true;
        if (nome.length() == 0)
        {
            regUtiErroNome.setVisible(true);
            regUtiErroNome.setText("Nome Inválido");
            regUtiErroNome.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    
    private boolean validarRegistarUtilizadorCc(String cc)
    {
        boolean flag = true;
        if (cc.length() == 0)
        {
            regUtiErroCc.setVisible(true);
            regUtiErroCc.setText("CC/TR Inválido");
            regUtiErroCc.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    private boolean validarRegistarUtilizadorMorada(String morada)
    {
        boolean flag = true;
        if (morada.length() == 0)
        {
            regUtiErroMorada.setVisible(true);
            regUtiErroMorada.setText("Morada Inválido");
            regUtiErroMorada.setFill(Paint.valueOf("Red"));
            flag = false;
        }   
        return flag;
    }
    private boolean validarRegistarUtilizadorDNascimento()
    {
        boolean flag = true;
        if (regUtiDataNasc.getValue() == null)
        {
            regUtiErroData.setVisible(true);
            regUtiErroData.setText("Data Inválida");
            regUtiErroData.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    private boolean validarRegistarUtilizadorDNascimentoString(String d)
    {
        boolean flag = true;
        if (d.length() == 0)
        {
            regUtiErroData.setVisible(true);
            regUtiErroData.setText("Data Inválida");
            regUtiErroData.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    private boolean validarRegistarUtilizadorLocalidade(String local)
    {
        boolean flag = true;
        if (local.length() == 0)
        {
            regUtiErroLocalidade.setVisible(true);
            regUtiErroLocalidade.setText("Morada Inválido");
            regUtiErroLocalidade.setFill(Paint.valueOf("Red"));
            flag = false;
        }  
        return flag;
    }
    
    private boolean validarRegistarUtilizadorTipo()
    {
       boolean flag = false;
       if (regUtiTipo.getValue() == null)
       {//marca
           flag = false;
       }
       else if (regUtiTipo.getValue().equals("Funcionario") || regUtiTipo.getValue().equals("Aluno") || regUtiTipo.getValue().equals("Docente"))
       {
           flag = true;
       }
        
        if (flag == false)
        {
            regUtiErroTipo.setVisible(true);
            regUtiErroTipo.setText("Apenas são válidos: Aluno, Docente e Funcionario");
            regUtiErroTipo.setFill(Paint.valueOf("Red"));
        }
        
        return flag;
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
        regUtiErroLocalidade.setVisible(false);
        regUtiErroData.setVisible(false);
        if(validarRegistarUtilizadorContacto(regUtiCont.getText()) == false)
            flag = false;
        if(validarRegistarUtilizadorNif(regUtiNif.getText()) == false)
            flag = false;
        if(validarRegistarUtilizadorEmail(regUtiEmail.getText())== false)
            flag = false;
        if(validarRegistarUtilizadorNome(regUtiNome.getText())== false)
            flag = false;
        if(validarRegistarUtilizadorCc(regUtiCc.getText())== false)
            flag = false;
        if(validarRegistarUtilizadorMorada(regUtiMorada.getText())== false)
            flag = false;
        if(validarRegistarUtilizadorDNascimento()== false)
            flag = false;
        if(validarRegistarUtilizadorLocalidade(regUtiLocalidade.getText())== false)
            flag = false;
        if(validarRegistarUtilizadorTipo()== false)
            flag = false;

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
            dataLivros.add(new Livro(regLivNum.getText(), regLivTitulo.getText(), regLivTema.getText(), regLivAutor.getText(), regLivEditora.getText(), regLivData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),"Livre","Não")); 
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Registo com sucesso");
            alert.setHeaderText("Livro registado com sucesso!");
            //alert.setContentText("I have a great message for you!");
            alert.showAndWait();
            fecharJanelas();
        }
        
    }

    private boolean validarRegistarLivroNum(String n)
    {
        boolean flag = true;
        if (isInteger(n) == 0)
        {
            regLiviErroNumero.setVisible(true);
            regLiviErroNumero.setText("Contem caraters invalidos");
            regLiviErroNumero.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    
    private boolean validarRegistarLivroTitulo(String titulo)
    {
        boolean flag = true;
        if (titulo.length() == 0)
        {
            regLiviErroTitulo.setVisible(true);
            regLiviErroTitulo.setText("Titulo Inválido");
            regLiviErroTitulo.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    
    private boolean validarRegistarLivroTema(String tema)
    {
        boolean flag = true;
        if (tema.length() == 0)
        {
            regLiviErroTema.setVisible(true);
            regLiviErroTema.setText("Tema Inválido");
            regLiviErroTema.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    private boolean validarRegistarLivroAutor(String autor)
    {
        boolean flag = true;
        if (autor.length() == 0)
        {
            regLiviErroAutor.setVisible(true);
            regLiviErroAutor.setText("Autor Inválido");
            regLiviErroAutor.setFill(Paint.valueOf("Red"));
            flag = false;
        }
            return flag;
    }
    
    private boolean validarRegistarLivroEditora(String editora)
    {
        boolean flag = true;
        if (editora.length() == 0)
        {
            regLiviErroEditora.setVisible(true);
            regLiviErroEditora.setText("Editora Inválido");
            regLiviErroEditora.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    
    private boolean validarRegistarLivroData()
    {
        boolean flag = true;
        if (regLivData.getValue() == null)
        {
            regLiviErroData.setVisible(true);
            regLiviErroData.setText("Data Inválida");
            regLiviErroData.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        
        return flag;
    }
    private boolean validarRegistarLivroDataSring(String d)
    {
        boolean flag = true;
        if (d.length() == 0)
        {
            regLiviErroData.setVisible(true);
            regLiviErroData.setText("Data Inválida");
            regLiviErroData.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        
        return flag;
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
        
        if(validarRegistarLivroNum(regLivNum.getText()) == false)
            flag = false;
        if(validarRegistarLivroTitulo(regLivTitulo.getText())== false)
            flag = false;
        if(validarRegistarLivroTema(regLivTema.getText())== false)
            flag = false;
        if(validarRegistarLivroAutor(regLivAutor.getText())== false)
            flag = false;
        if(validarRegistarLivroEditora(regLivEditora.getText())== false)
            flag = false;
        if(validarRegistarLivroData()== false)
            flag = false;

        if(flag)
        {
            return true;
        }
        else return false;
    }
    
    private boolean validarRegistarFuncionarioNome(String s)
    {
        boolean flag = true;
        if (s.length() == 0)
        {
            regFuncErroNome.setVisible(true);
            regFuncErroNome.setText("Nome inválido");
            regFuncErroNome.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        
        return flag;
    }
    
    private boolean validarRegistarFuncionarioLogin(String s)
    {
        boolean flag = true;
        if (s.length() == 0)
        {
            regFuncErroLogin.setVisible(true);
            regFuncErroLogin.setText("Login Inválido");
            regFuncErroLogin.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        
        return flag;
    }
    
    private boolean validarRegistarFuncionarioPass(String s)
    {
        boolean flag = true;
        if (s.length() == 0)
        {
            regFuncErroPass.setVisible(true);
            regFuncErroPass.setText("Password Inválida");
            regFuncErroPass.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        
        return flag;
    }
    
    private boolean validarRegistarFuncionarioTipo()
    {
        boolean flag = false;
        if (regFuncTipo.getValue() == null)
        {//marca
            flag = false;
        }
       else if (regFuncTipo.getValue().equals("Funcionario") || regFuncTipo.getValue().equals("Administrador"))
       {
           flag = true;
       }
        
        if (flag == false)
        {
            regFuncErroTipo.setVisible(true);
            regFuncErroTipo.setText("Apenas são válidos: Funcionario e Administrador");
            regFuncErroTipo.setFill(Paint.valueOf("Red"));
        }
        
        return flag;
    }
    
    
    private boolean validarRegistarFuncionario()
    {
        boolean flag = true;
        regFuncErroNome.setVisible(false);
        regFuncErroLogin.setVisible(false);
        regFuncErroPass.setVisible(false);
        regFuncErroTipo.setVisible(false);
         
        if(validarRegistarFuncionarioNome(regFuncNome.getText()) == false)
            flag = false;
        if(validarRegistarFuncionarioLogin(regFuncLogin.getText()) == false)
            flag = false;
        if(validarRegistarFuncionarioPass(regFuncPass.getText()) == false)
            flag = false;
        if(validarRegistarFuncionarioTipo() == false)
            flag = false;     
        
        if(flag)
        {
            return true;
        }
        else return false;
    }
    
    
    
    @FXML
    private void registarFuncionario(ActionEvent event) 
    {
        
        if(validarRegistarFuncionario())
        {
            dataFuncionario.add(new Funcionario(regFuncNome.getText(), regFuncLogin.getText(), regFuncPass.getText(), regFuncTipo.getValue()));
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Registo com sucesso");
            alert.setHeaderText("Funcionário registado com sucesso!");
            //alert.setContentText("I have a great message for you!");
            alert.showAndWait();
            fecharJanelas();
        }
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
        tablefunc.setVisible(false);
        regLivWindow.setVisible(false);
        regUtiWindow.setVisible(false);
        regReqWindow.setVisible(false);
        regFuncWindow.setVisible(false);
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
        calcularDias();
    }
    
    @FXML
    private void pesquisarFuncionarios(ActionEvent event) 
    {
       fecharJanelas();
       tablefunc.setVisible(true);
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
    private void registarFuncionarioJanela(ActionEvent event) {
        fecharJanelas();
        regFuncWindow.setVisible(true);
    }

    @FXML
    private void registarRequisicao(ActionEvent event) 
    {
        if (validarRegistarRequisicao())
        {
            dataRequisicao.add(new Requisicao(regReqLivro.getText(), regReqCC.getText(),regReqDReq.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),""));
            int l = LivNIndexOf(regReqLivro.getText());
            tableLiv.getSelectionModel().select(l);
            tableLiv.getSelectionModel().getSelectedItem().setRequisitado("Requisitado");
            tableLiv.refresh();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Registo com sucesso");
            alert.setHeaderText("Requisição registada com sucesso!");
            //alert.setContentText("I have a great message for you!");
            alert.showAndWait();
            fecharJanelas();
            fecharJanelas();
        }
        
    }
    
    private boolean validarRegistarRequisicaoCc(String s)
    {
        boolean flag = true;
        if (UtiCcIndexOf(s) == -1)
        {
            regReqErroCc.setVisible(true);
            regReqErroCc.setText("Numero de CC/TR não registado");
            regReqErroCc.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        
        if (ReqCcPorEntregarLivro(s))
        {
            regReqErroCc.setVisible(true);
            regReqErroCc.setText("Utilizador tem um livro por entregar!");
            regReqErroCc.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    
    private boolean validarRegistarRequisicaoLivro(String s)
    {
        boolean flag = true;
        int l = LivNIndexOf(s);
        if (l == -1)
        {
            regReqErroLivro.setVisible(true);
            regReqErroLivro.setText("Numero do Livro não registado");
            regReqErroLivro.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (liv_requi_col.getCellData(l) == "Requisitado")
        {
            regReqErroLivro.setVisible(true);
            regReqErroLivro.setText("O livro já se encontra requisitado");
            regReqErroLivro.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        if (liv_ina_col.getCellData(l) == "Inativo")
        {
            regReqErroLivro.setVisible(true);
            regReqErroLivro.setText("O livro já não se encontra Ativo");
            regReqErroLivro.setFill(Paint.valueOf("Red"));
            flag = false; 
        }
        return flag;
    }
    
    private boolean validarRegistarRequisicaoDRequisito()
    {
        boolean flag = true;
        if (regReqDReq.getValue() == null)
        {
            regReqErroDReq.setVisible(true);
            regReqErroDReq.setText("Data Inválida");
            regReqErroDReq.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    private boolean validarRegistarRequisicaoDRequisitoString(String s)
    {
        boolean flag = true;
        if (s.length() == 0)
        {
            regReqErroDReq.setVisible(true);
            regReqErroDReq.setText("Data Inválida");
            regReqErroDReq.setFill(Paint.valueOf("Red"));
            flag = false;
        }
        return flag;
    }
    
    private boolean validarRegistarRequisicao()
    {
        boolean flag = true;
        regReqErroCc.setVisible(false);
        regReqErroDEnt.setVisible(false);
        regReqErroDReq.setVisible(false);
        regReqErroLivro.setVisible(false);
        
        if(validarRegistarRequisicaoCc(regReqCC.getText()) == false)
            flag = false;
        if(validarRegistarRequisicaoLivro(regReqLivro.getText()) == false)
            flag = false;
        if(validarRegistarRequisicaoDRequisito() == false)
            flag = false;
      
        if(flag)
        {
            return true;
        }
        else return false;
    }
    
    private int UtiCcIndexOf(String st)
    {
        int z = -1;
        for (int i = 0; i< tableUti.getItems().size(); i++)
        {
            if(uti_cc_col.getCellData(i).equals(st))
                z = i;         
        }

        return z;
    }
    
    private int LivNIndexOf(String st)
    {
        int z = -1;
        for (int i = 0; i< tableLiv.getItems().size(); i++)
        {
            if(liv_nLiv_col.getCellData(i).equals(st))
                z = i;         
        }
           
        return z;
    }
    
    private int ReqCcIndexOf(String st)
    {
        int z = -1;
        for (int i = 0; i< tableReq.getItems().size(); i++)
        {
            if(req_cc_col.getCellData(i).equals(st))
                z = i;         
        }

        return z;
    }
    
    private int ReqLivNIndexOf(String st)
    {
        int z = -1;
        for (int i = 0; i< tableReq.getItems().size(); i++)
        {
            if(req_nLiv_col.getCellData(i).equals(st))
                z = i;         
        }
           
        return z;
    }
    
    private boolean ReqCcPorEntregarLivro(String st)
    {
        for (int i = 0; i< tableReq.getItems().size(); i++)
        {
            if(req_cc_col.getCellData(i).equals(st))
            {
                if(req_dEnt_col.getCellData(i).equals(""))
                {
                    System.out.println("Utilizador tem livro por entregar!");
                    return true;
                }
            }
        }
        return false;
    }
    
    @FXML
    private void apagarLinhaUtilizador(ActionEvent event) 
    {
     //   MyDataType selectedItem = tableUti.getSelectionModel().getSelectedItem();
       if(ReqCcIndexOf(tableUti.getSelectionModel().getSelectedItem().getCc()) == -1)
       {
            tableUti.getItems().remove(tableUti.getSelectionModel().getSelectedItem());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Apagado com sucesso");
            alert.setHeaderText("Utilizador apagado com sucesso!");
            //alert.setContentText("I have a great message for you!");
            alert.showAndWait();
       }
       else
       {
           Alert alert = new Alert(AlertType.ERROR); 
           alert.setTitle("Erro a apagar campo"); 
           alert.setHeaderText("Não pode apagar este utilixador por ele já ter efetuado requisições anteriormente"); 
          // alert.setContentText("Ooops, there was an error!"); 
           alert.showAndWait();
       }
        //apenas deixa apagar se não existir nenhuma requisição feita
    }
    
    @FXML
    private void InativoLinhaLivro(ActionEvent event) 
    {
        tableLiv.getSelectionModel().getSelectedItem().setInativo("Inativo");
        tableLiv.refresh();
    }
    @FXML
    private void ativoLinhaLivro(ActionEvent event) 
    {
        tableLiv.getSelectionModel().getSelectedItem().setInativo("Não");
        tableLiv.refresh();
    }

    @FXML
    private void apagarLinhaRequisicao(ActionEvent event) {
        tableReq.getItems().remove(tableReq.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void pesquisarLivroReq(ActionEvent event) 
    {
        int f = LivNIndexOf(tableReq.getSelectionModel().getSelectedItem().getNLivro());
        if (f == -1)
        {
            System.out.println("erro inesperado!\nDentro do pesquisarLivroReq");
        }
        else
        {
           pesquisarLivro(new ActionEvent());
           tableLiv.getSelectionModel().select(f);
        }
        
    }

    @FXML
    private void pesquisarUtiReq(ActionEvent event) 
    {
        int f = UtiCcIndexOf(tableReq.getSelectionModel().getSelectedItem().getCc());
        if (f == -1)
        {
            System.out.println("erro inesperado!\nDentro do pesquisarLivroReq");
        }
        else
        {
           pesquisarUtilizador(new ActionEvent());
           tableUti.getSelectionModel().select(f);
        }
    }

    @FXML
    private void entregarLivro(ActionEvent event) 
    {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date datatemp = new Date();
        
        System.out.println(tableReq.getSelectionModel().getSelectedItem().getDEntrega());
        
        int f = LivNIndexOf(tableReq.getSelectionModel().getSelectedItem().getNLivro());
        if (f == -1)
        {
            System.out.println("erro inesperado!\nDentro do entregarLivro");
        }
        else if (tableReq.getSelectionModel().getSelectedItem().getDEntrega() != "")
        {
           Alert alert = new Alert(AlertType.ERROR); 
           alert.setTitle("Erro a registar entrega"); 
           alert.setHeaderText("Este livro já foi entregue"); 
          // alert.setContentText("Ooops, there was an error!"); 
           alert.showAndWait();
        }
        else
        {       
           tableReq.getSelectionModel().getSelectedItem().setDEntrega(dateFormat.format(datatemp).toString());
           tableReq.refresh();
           tableLiv.getSelectionModel().select(f);
           tableLiv.getSelectionModel().getSelectedItem().setRequisitado("Livre");
           tableLiv.refresh();
        }
    }

    @FXML
    private void apagarLinhaFuncionario(ActionEvent event) 
    {
        tablefunc.getItems().remove(tablefunc.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void editarUtiCc(TableColumn.CellEditEvent event) 
    {
        
        if(validarRegistarUtilizadorCc(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setCc(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarUtiNome(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarUtilizadorNome(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setNome(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarUtiDN(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarUtilizadorDNascimentoString(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setDNascimento(event.getNewValue().toString());
           //ver isto mais tarde, melhorar a validação do edit das datas
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarUtiContacto(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarUtilizadorContacto(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setContacto(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarUtiEmail(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarUtilizadorEmail(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setEmail(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarUtiMorada(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarUtilizadorMorada(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setMorada(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarUtiLocalidade(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarUtilizadorLocalidade(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setLocalidade(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarUtiNif(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarUtilizadorNif(event.getNewValue().toString()) == true)
        {
           tableUti.getSelectionModel().getSelectedItem().setNif(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarLivroNum(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarLivroNum(event.getNewValue().toString()) == true)
        {
           tableLiv.getSelectionModel().getSelectedItem().setNLivro(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarLivroTitulo(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarLivroTitulo(event.getNewValue().toString()) == true)
        {
           tableLiv.getSelectionModel().getSelectedItem().setTitulo(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarLivroTema(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarLivroTema(event.getNewValue().toString()) == true)
        {
           tableLiv.getSelectionModel().getSelectedItem().setTema(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarLivroAutor(TableColumn.CellEditEvent event)
    {
        if(validarRegistarLivroAutor(event.getNewValue().toString()) == true)
        {
           tableLiv.getSelectionModel().getSelectedItem().setAutor(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarLivroEditora(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarLivroEditora(event.getNewValue().toString()) == true)
        {
           tableLiv.getSelectionModel().getSelectedItem().setEditora(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();
    }

    @FXML
    private void editarLivroData(TableColumn.CellEditEvent event) 
    {
        if(validarRegistarLivroDataSring(event.getNewValue().toString()) == true)
        {
           tableLiv.getSelectionModel().getSelectedItem().setData(event.getNewValue().toString());
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Erro a editar"); 
            alert.setHeaderText("Colocou um valor inválido"); 
          //  alert.setContentText("Ooops, there was an error!"); 
            alert.showAndWait();
        }
        tableUti.refresh();  
    }
    public int stringToInt(String s)
    {
        try{
            return Integer.valueOf(s);
        }catch (Exception e)
        {
            return -1;
        }
    }
    
    
    
    private void calcularDias()
    {
        //chamar esta função qaundo a janela Requisições é aberta!
        //falta fazer esta função
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data1;
        Date data2 = new Date();
        long resultado;
        int dias;
        Requisicao temp = new Requisicao("","","","");
        
        for (int i = 0; i< tableReq.getItems().size(); i++)
        {
            try {
                data1 = formatter.parse(req_dReq_col.getCellData(i).toString());
                data2 = new Date();
                if(req_dEnt_col.getCellData(i).toString() != "")
                {
                   data2 = formatter.parse(req_dEnt_col.getCellData(i).toString());
                }
                resultado = data2.getTime() - data1.getTime();
                dias = (int) (resultado / (1000*60*60*24));
                
                temp = tableReq.getItems().get(i);               
                temp.setDias(Integer.toString(dias));
                
                tableReq.getItems().set(i, temp);
            } catch (ParseException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    
   
    @FXML
    private void gravarUtilizador()
    {
        //falta chamar esta função
        File ficheiro = new File("Utilizadores.bin");
        ObjectOutputStream escrita;
        int i=0;      
        try{
            escrita = new ObjectOutputStream(new FileOutputStream(ficheiro));
            
            for(i=0;i<dataUtilizadores.size();i++)
            {
                escrita.writeObject(uti_cc_col.getCellData(i));
                escrita.writeObject(uti_nome_col.getCellData(i));
                escrita.writeObject(uti_dNasc_col.getCellData(i));
                escrita.writeObject(uti_cont_col.getCellData(i));
                escrita.writeObject(uti_mail_col.getCellData(i));
                escrita.writeObject(uti_mora_col.getCellData(i));
                escrita.writeObject(uti_loc_col.getCellData(i));
                escrita.writeObject(uti_nif_col.getCellData(i));
                escrita.writeObject(uti_tipo_col.getCellData(i));
            }
            
            //escrita.writeObject(data.toString());
            
            escrita.close();
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a gravar tabela dos Utilizadores: " + ex);
        }   
    }
    
    @FXML
    private void carregarUtilizador()
    {
        //falta chamar esta função
        File ficheiro = new File("Utilizadores.bin");
            ObjectInputStream leitura = null; 
        try{    
        while (true)
        {
            dataUtilizadores.remove(0);
        }
        }catch (Exception ex){
            //vazio de proposito
        }    
        try{
            leitura = new ObjectInputStream(new FileInputStream(ficheiro));
            //while((String nome=(String) leitura.readObject())!=eof())
            while(true)
            {
                
                String s1 = (String) leitura.readObject();
                String s2 = (String) leitura.readObject();
                String s3 = (String) leitura.readObject();
                String s4 = (String) leitura.readObject();
                String s5 = (String) leitura.readObject();
                String s6 = (String) leitura.readObject();
                String s7 = (String) leitura.readObject();
                String s8 = (String) leitura.readObject();
                String s9 = (String) leitura.readObject();
                
                dataUtilizadores.add(new Utilizador(s1,s2,s3,s4,s5,s6,s7,s8,s9));
                
            }
            
            
         //   data.addAll(leitura.readObject());
         }catch (Exception ex) 
        {
            if (ex.getClass() == IOException.class)
            {
                System.out.println("Deu erro a carregar utilizadores: " + ex);
            }
            else if (ex instanceof EOFException)
            {                
                System.out.println("eof");
            }
        }  finally
        {
            try {
                leitura.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    @FXML
    private void gravarLivro()
    {
        //falta chamar esta função
        File ficheiro = new File("Livros.bin");
        ObjectOutputStream escrita;
        int i=0;      
        try{
            escrita = new ObjectOutputStream(new FileOutputStream(ficheiro));
            
            for(i=0;i<dataLivros.size();i++)
            {
                escrita.writeObject(liv_nLiv_col.getCellData(i));
                escrita.writeObject(liv_titu_col.getCellData(i));
                escrita.writeObject(liv_tema_col.getCellData(i));
                escrita.writeObject(liv_aut_col.getCellData(i));
                escrita.writeObject(liv_edi_col.getCellData(i));
                escrita.writeObject(liv_data_col.getCellData(i));
                escrita.writeObject(liv_requi_col.getCellData(i));
                escrita.writeObject(liv_ina_col.getCellData(i));
            }
            
            //escrita.writeObject(data.toString());
            
            escrita.close();
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a gravar tabela dos Livros: " + ex);
        }   
    }

    @FXML
    private void carregarLivros()
    {
        //falta chamar esta função
        File ficheiro = new File("Livros.bin");
            ObjectInputStream leitura = null; 
            
            
        try{    
            while (true)
            {
                dataLivros.remove(0);
            }
        }catch (Exception ex){
            //vazio de proposito
        }      
              
        try{
            leitura = new ObjectInputStream(new FileInputStream(ficheiro));
            //while((String nome=(String) leitura.readObject())!=eof())
            while(true)
            {
                
                String s1 = (String) leitura.readObject();
                String s2 = (String) leitura.readObject();
                String s3 = (String) leitura.readObject();
                String s4 = (String) leitura.readObject();
                String s5 = (String) leitura.readObject();
                String s6 = (String) leitura.readObject();
                String s7 = (String) leitura.readObject();
                String s8 = (String) leitura.readObject();
                
                dataLivros.add(new Livro(s1,s2,s3,s4,s5,s6,s7,s8));
                
            }
            
            
         //   data.addAll(leitura.readObject());
         }catch (Exception ex) 
        {
            if (ex.getClass() == IOException.class)
            {
                System.out.println("Deu erro a carregar livros: " + ex);
            }
            else if (ex instanceof EOFException)
            {                
                System.out.println("eof");
            }
        }  finally
        {
            try {
                leitura.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    @FXML
    private void gravarRequisicao()
    {
        //falta chamar esta função
        File ficheiro = new File("Requisicao.bin");
        ObjectOutputStream escrita;
        int i=0;      
        try{
            escrita = new ObjectOutputStream(new FileOutputStream(ficheiro));
            
            for(i=0;i<dataRequisicao.size();i++)
            {
                escrita.writeObject(req_nLiv_col.getCellData(i));
                escrita.writeObject(req_cc_col.getCellData(i));
                escrita.writeObject(req_dReq_col.getCellData(i));
                escrita.writeObject(req_dEnt_col.getCellData(i));
            }
            
            //escrita.writeObject(data.toString());
            
            escrita.close();
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a gravar tabela das requisições: " + ex);
        }   
    }
    
    @FXML
    private void carregarRequisicao()
    {
        //falta chamar esta função
        File ficheiro = new File("Requisicao.bin");
            ObjectInputStream leitura = null; 
            
        try{    
            while (true)
            {
                dataRequisicao.remove(0);
            }
        }catch (Exception ex){
            //vazio de proposito
        }  
            
            
        try{
            leitura = new ObjectInputStream(new FileInputStream(ficheiro));
            //while((String nome=(String) leitura.readObject())!=eof())
            while(true)
            {
                
                String s1 = (String) leitura.readObject();
                String s2 = (String) leitura.readObject();
                String s3 = (String) leitura.readObject();
                String s4 = (String) leitura.readObject();
                
                dataRequisicao.add(new Requisicao(s1,s2,s3,s4));           
            }
            
            
         //   data.addAll(leitura.readObject());
         }catch (Exception ex) 
        {
            if (ex.getClass() == IOException.class)
            {
                System.out.println("Deu erro a carregar requisição: " + ex);
            }
            else if (ex instanceof EOFException)
            {                
                System.out.println("eof");
            }
        }  finally
        {
            try {
                leitura.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    @FXML
    private void gravarFuncionario()
    {
        //falta chamar esta função
        File ficheiro = new File("Funcionario.bin");
        ObjectOutputStream escrita;
        int i=0;      
        try{
            escrita = new ObjectOutputStream(new FileOutputStream(ficheiro));
            
            for(i=0;i<dataFuncionario.size();i++)
            {
                escrita.writeObject(func_nome_col.getCellData(i));
                escrita.writeObject(func_login_col.getCellData(i));
                escrita.writeObject(func_pass_col.getCellData(i));
                escrita.writeObject(func_tipo_col.getCellData(i));
            }
            
            //escrita.writeObject(data.toString());
            
            escrita.close();
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a gravar tabela dos funcionarios: " + ex);
        }   
    }
    
    @FXML
    private void carregarFuncionario()
    {
        //falta chamar esta função
        File ficheiro = new File("Funcionario.bin");
            ObjectInputStream leitura = null; 
        
            
        try{    
            while (true)
            {
                dataFuncionario.remove(0);
            }
        }catch (Exception ex){
            //vazio de proposito
        }  
              
        try{
            leitura = new ObjectInputStream(new FileInputStream(ficheiro));
            //while((String nome=(String) leitura.readObject())!=eof())
            while(true)
            {
                
                String s1 = (String) leitura.readObject();
                String s2 = (String) leitura.readObject();
                String s3 = (String) leitura.readObject();
                String s4 = (String) leitura.readObject();
                
                dataFuncionario.add(new Funcionario(s1,s2,s3,s4));           
            }
            
            
         //   data.addAll(leitura.readObject());
         }catch (Exception ex) 
        {
            if (ex.getClass() == IOException.class)
            {
                System.out.println("Deu erro a carregar funcionario: " + ex);
            }
            else if (ex instanceof EOFException)
            {                
                System.out.println("eof");
            }
        }  finally
        {
            try {
                leitura.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void LoginJanela(ActionEvent event) 
    {
        
    }

}

