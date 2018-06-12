/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
       //     new Utilizador("589624782", "André","01-07-1989", "915896547","andre@gmail.com","Rua do Brasil","Coimbra","842498745","Aluno"),
       //     new Utilizador("289756586", "Flávio","10-05-1990", "912568749","flavio@gmail.com","Praça da República","Coimbra","125483314","Aluno"),
       //     new Utilizador("965235783", "Rodrigo","03-02-1994", "962315696", "rodrigo@email.com","Avenida", "Coimbra", "654236957","Aluno")
        );
    @FXML
    private TableView<Livro> tableLiv = new TableView<Livro>();
    
        private final ObservableList<Livro> dataLivros =
        FXCollections.observableArrayList(
       //     new Livro("1","Anjos e Demónios","policial","Dan Brown","Asa","01-04-2003","Requisitado","Não"),
       //     new Livro("2","Harry Potter e a Câmera dos Segredos","magia","J.K.Rowlings","Asa","01-02-2001","Requisitado","Não"),
       //     new Livro("3","Juntos Para Sempre", "Ficção Literária", "W. Bruce Cameron","Asa","04-04-2017","Livre","Não")
        );
    @FXML
    private TableView<Requisicao> tableReq = new TableView<Requisicao>();
    
        private final ObservableList<Requisicao> dataRequisicao =
        FXCollections.observableArrayList(
       //     new Requisicao("1","589624782","16-04-2017",""),
       //     new Requisicao("2","289756586","03-05-2017","21-04-2018"),
       //     new Requisicao("2","589624782","22-04-2018","") 
        );
        
    @FXML
    private TableView<Funcionario> tablefunc = new TableView<Funcionario>();
    
        private final ObservableList<Funcionario> dataFuncionario =
        FXCollections.observableArrayList(
       //     new Funcionario("Maria","Loira","123","Funcionario"),
       //     new Funcionario("John","admin","admin","Administrador")   
        );
    
    @FXML
    private TableColumn <Utilizador, String> uti_cc_col  = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_nome_col = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_cont_col = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_mail_col = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_mora_col = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_nif_col = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_dNasc_col = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_loc_col = new TableColumn();
    @FXML
    private TableColumn <Utilizador, String> uti_tipo_col = new TableColumn();
    
    @FXML
    private TableColumn <Livro, String> liv_nLiv_col = new TableColumn();
    @FXML
    private TableColumn <Livro, String> liv_titu_col = new TableColumn();
    @FXML
    private TableColumn <Livro, String> liv_tema_col = new TableColumn();
    @FXML
    private TableColumn <Livro, String> liv_aut_col = new TableColumn();
    @FXML
    private TableColumn <Livro, String> liv_edi_col = new TableColumn();
    @FXML
    private TableColumn <Livro, String> liv_data_col = new TableColumn();
    @FXML
    private TableColumn <Livro, String> liv_requi_col = new TableColumn();
    @FXML
    private TableColumn <Livro, String> liv_ina_col = new TableColumn();
    
    @FXML
    private TableColumn <Requisicao, String> req_nLiv_col = new TableColumn();
    @FXML
    private TableColumn <Requisicao, String> req_cc_col = new TableColumn();
    @FXML
    private TableColumn <Requisicao, String> req_dReq_col = new TableColumn();
    @FXML
    private TableColumn <Requisicao, String> req_dEnt_col = new TableColumn();
    @FXML
    private TableColumn <Requisicao, Integer> req_dias_col = new TableColumn();
    
    @FXML
    private TableColumn <Funcionario, String> func_nome_col = new TableColumn();
    @FXML
    private TableColumn <Funcionario, String> func_login_col = new TableColumn();
    @FXML
    private TableColumn <Funcionario, String> func_pass_col = new TableColumn();
    @FXML
    private TableColumn <Funcionario, String> func_tipo_col = new TableColumn();
    
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

    private int diasAtrasoPermitidos = 5;
    private float multaPorDia = 1;
    @FXML
    private Pane formLogin;
    @FXML
    private TextField campoLogin;
    @FXML
    private PasswordField campoPass;
    @FXML
    private Text erroDeLogin;

    private String login = "aluno";
    @FXML
    private Menu menuGravar;
    @FXML
    private Menu menuCarregar;
    @FXML
    private MenuItem menuPesqUti;
    @FXML
    private MenuItem menuPesqReq;
    @FXML
    private MenuItem menuPesqFunc;
    @FXML
    private MenuItem menuRegFunc;
    @FXML
    private Menu menuConfig;
    @FXML
    private MenuItem menuLogout;
    @FXML
    private MenuItem menuLogin;
    @FXML
    private Menu menuReg;
    @FXML
    private MenuItem menuFloatRegLiv;
    @FXML
    private MenuItem menuFloatAtivo;
    @FXML
    private MenuItem menuFloatInativo;
    @FXML
    private Menu menuGravarCSV;
    @FXML
    private Menu menuCarregarCSV;
    @FXML
    private TextField utiFilteredField;
    @FXML
    private TextField livFilteredField;
    @FXML
    private TextField reqFilteredField;
    @FXML
    private TextField funcFilteredField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
      //  table.setEditable(true);
 
        uti_cc_col.setCellValueFactory(cellData -> cellData.getValue().ccProperty());
        uti_nome_col.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        uti_dNasc_col.setCellValueFactory(cellData -> cellData.getValue().dNascimentoProperty());
        uti_cont_col.setCellValueFactory(cellData -> cellData.getValue().contactoProperty());
        uti_mail_col.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        uti_mora_col.setCellValueFactory(cellData -> cellData.getValue().moradaProperty());
        uti_loc_col.setCellValueFactory(cellData -> cellData.getValue().localidadeProperty());
        uti_nif_col.setCellValueFactory(cellData -> cellData.getValue().nifProperty());
        uti_tipo_col.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        
        liv_nLiv_col.setCellValueFactory(cellData -> cellData.getValue().nLivroProperty());
        liv_titu_col.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        liv_tema_col.setCellValueFactory(cellData -> cellData.getValue().temaProperty());
        liv_aut_col.setCellValueFactory(cellData -> cellData.getValue().autorProperty());
        liv_edi_col.setCellValueFactory(cellData -> cellData.getValue().editoraProperty());
        liv_data_col.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
        liv_requi_col.setCellValueFactory(cellData -> cellData.getValue().requisitadoProperty());
        liv_ina_col.setCellValueFactory(cellData -> cellData.getValue().inativoProperty());
        
        req_nLiv_col.setCellValueFactory(cellData -> cellData.getValue().nLivroProperty());
        req_cc_col.setCellValueFactory(cellData -> cellData.getValue().ccProperty());
        req_dReq_col.setCellValueFactory(cellData -> cellData.getValue().dRequisicaoProperty());
        req_dEnt_col.setCellValueFactory(cellData -> cellData.getValue().dEntregaProperty());
        req_dias_col.setCellValueFactory(
                new PropertyValueFactory("dias"));
          
        func_nome_col.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        func_login_col.setCellValueFactory(cellData -> cellData.getValue().loginProperty());
        func_pass_col.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        func_tipo_col.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
 
        
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
        
        FilteredList<Utilizador> filteredDataUti = new FilteredList<>(dataUtilizadores, p -> true);

        utiFilteredField.textProperty().addListener((observableUti, oldValueUti, newValueUti) -> {
            filteredDataUti.setPredicate(utilizador -> {
                //if filter text is empty, display all scores.
                if (newValueUti == null || newValueUti.isEmpty()) {
                    return true;
                }
                
                //Compare score e valores
                
                String lowerCaseFilter = newValueUti.toLowerCase();
                
                if (utilizador.getCc().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getNome().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getDNascimento().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getContacto().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getEmail().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getMorada().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getLocalidade().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getNif().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (utilizador.getTipo().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                
                return false;
            });
        });
        
        SortedList<Utilizador> sortedDataUti = new SortedList<>(filteredDataUti);
        
        sortedDataUti.comparatorProperty().bind(tableUti.comparatorProperty());
        
        tableUti.setItems(sortedDataUti);
        
        
        
        FilteredList<Livro> filteredDataLiv = new FilteredList<>(dataLivros, p -> true);

        livFilteredField.textProperty().addListener((observableLiv, oldValueLiv, newValueLiv) -> {
            filteredDataLiv.setPredicate(livro -> {
                //if filter text is empty, display all scores.
                if (newValueLiv == null || newValueLiv.isEmpty()) {
                    return true;
                }
                
                //Compare score e valores
                
                String lowerCaseFilter = newValueLiv.toLowerCase();
                
                if (livro.getNLivro().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (livro.getTitulo().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (livro.getTema().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (livro.getAutor().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (livro.getEditora().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (livro.getData().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (livro.getRequisitado().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (livro.getInativo().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                
                return false;
            });
        });
        
        SortedList<Livro> sortedDataLiv = new SortedList<>(filteredDataLiv);
        
        sortedDataLiv.comparatorProperty().bind(tableLiv.comparatorProperty());
        
        tableLiv.setItems(sortedDataLiv);
        
        
        
//        FilteredList<Requisicao> filteredDataReq = new FilteredList<>(dataRequisicao, p -> true);
//
//        reqFilteredField.textProperty().addListener((observableReq, oldValueReq, newValueReq) -> {
//            filteredDataReq.setPredicate(requisicao -> {
//                //if filter text is empty, display all scores.
//                if (newValueReq == null || newValueReq.isEmpty()) {
//                    return true;
//                }
//                
//                //Compare score e valores
//                
//                String lowerCaseFilter = newValueReq.toLowerCase();
//                
//                if (requisicao.getNLivro().toLowerCase().contains(lowerCaseFilter))
//                {
//                    return true;
//                }
//                else if (requisicao.getCc().toLowerCase().contains(lowerCaseFilter))
//                {
//                    return true;
//                }
//                else if (requisicao.getDRequisicao().toLowerCase().contains(lowerCaseFilter))
//                {
//                    return true;
//                }
//                else if (requisicao.getDEntrega().toLowerCase().contains(lowerCaseFilter))
//                {
//                    return true;
//                }
//                
//                return false;
//            });
//        });
//        
//        SortedList<Requisicao> sortedDataReq = new SortedList<>(filteredDataReq);
//        
//        sortedDataReq.comparatorProperty().bind(tableReq.comparatorProperty());
//        
//        tableReq.setItems(sortedDataReq);



        FilteredList<Funcionario> filteredDataFunc = new FilteredList<>(dataFuncionario, p -> true);

        funcFilteredField.textProperty().addListener((observableFunc, oldValueFunc, newValueFunc) -> {
            filteredDataFunc.setPredicate(funcionario -> {
                //if filter text is empty, display all scores.
                if (newValueFunc == null || newValueFunc.isEmpty()) {
                    return true;
                }
                
                //Compare score e valores
                
                String lowerCaseFilter = newValueFunc.toLowerCase();
                
                if (funcionario.getNome().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (funcionario.getLogin().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (funcionario.getPassword().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                else if (funcionario.getTipo().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                
                return false;
            });
        });
        
        SortedList<Funcionario> sortedDataFunc = new SortedList<>(filteredDataFunc);
        
        sortedDataFunc.comparatorProperty().bind(tablefunc.comparatorProperty());
        
        tablefunc.setItems(sortedDataFunc);
        
        carregarConf();
        carregarFuncionario();
        carregarLivros();
        carregarRequisicao(); 
        carregarUtilizador();

        loginRestricoes();
        

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
        formLogin.setVisible(false);
        utiFilteredField.setVisible(false);
        livFilteredField.setVisible(false);
        reqFilteredField.setVisible(false);
        funcFilteredField.setVisible(false);
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
        utiFilteredField.setVisible(true);
    }

    @FXML
    private void pesquisarLivro(ActionEvent event) 
    {
        fecharJanelas();
        tableLiv.setVisible(true);
        livFilteredField.setVisible(true);
    }

    @FXML
    private void pesquisarRequisicoes(ActionEvent event) 
    {
        fecharJanelas();
        tableReq.setVisible(true);
       // reqFilteredField.setVisible(true);
        calcularDias();
        req_dEnt_col.setSortType(TableColumn.SortType.ASCENDING);
        req_dias_col.setSortType(TableColumn.SortType.DESCENDING);
        tableReq.getSortOrder().setAll(req_dEnt_col,req_dias_col);
    }
    
    @FXML
    private void pesquisarFuncionarios(ActionEvent event) 
    {
       fecharJanelas();
       tablefunc.setVisible(true);
       funcFilteredField.setVisible(true); 
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
    
     private int FuncLoginIndexOf(String st)
    {
        int z = -1;
        for (int i = 0; i< tablefunc.getItems().size(); i++)
        {
            if(func_login_col.getCellData(i).equals(st))
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
           
           dataUtilizadores.remove(tableUti.getSelectionModel().getSelectedIndex()); //função com o filteredList
           
         //   tableUti.getItems().remove(tableUti.getSelectionModel().getSelectedItem()); //função sem o filteredList
           
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
        tableReq.getItems().remove(tableReq.getSelectionModel().getSelectedItem()); //função sem filteredList
       // dataRequisicao.remove(tableReq.getSelectionModel().getSelectedIndex()); //função para filteredList
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Apagado com sucesso");
        alert.setHeaderText("Requisição apagada com sucesso!");
        //alert.setContentText("I have a great message for you!");
        alert.showAndWait();
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
        else if (!tableReq.getSelectionModel().getSelectedItem().getDEntrega().equals(""))
        {
           Alert alert = new Alert(AlertType.ERROR); 
           alert.setTitle("Erro a registar entrega"); 
           alert.setHeaderText("Este livro já foi entregue"); 
          // alert.setContentText("Ooops, there was an error!"); 
           alert.showAndWait();
        }
        else
        {       
           if (diasAtrasoPermitidos < tableReq.getSelectionModel().getSelectedItem().getDias())
           {
                Alert alert = new Alert(AlertType.WARNING); 
                alert.setTitle("Multa a pagar"); 
                float m = (tableReq.getSelectionModel().getSelectedItem().getDias() - diasAtrasoPermitidos) * multaPorDia; //sem filteredList
               // float m = (dataRequisicao.get(tableReq.getSelectionModel().getSelectedIndex()).getDias() - diasAtrasoPermitidos) * multaPorDia; //com filteredList
                
                alert.setHeaderText(""); 
                alert.setContentText("Este utiliador tem a pagar " + m + "€ de multa"); 
                alert.showAndWait();
           }
            
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
        //não tem verificação para não poder apagar todos os admins, porque partimos do principio que o administrador do sistema percebe de informática!
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
    
    public float stringToFloat(String s)
    {
        try{
            return Float.valueOf(s);
        }catch (Exception e)
        {
            return -1;
        }
    }
    
    
    
    private void calcularDias()
    {
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
                if(!req_dEnt_col.getCellData(i).toString().equals(""))
                {
                   data2 = formatter.parse(req_dEnt_col.getCellData(i).toString());
                }
                resultado = data2.getTime() - data1.getTime();
                dias = (int) (resultado / (1000*60*60*24));
                
                temp = tableReq.getItems().get(i);               
                temp.setDias(dias);
                
                tableReq.getItems().set(i, temp);
            } catch (ParseException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    
   
    @FXML
    private void gravarUtilizador()
    {
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
    
    private void gravarConf()
    {
        File ficheiro = new File("Configuracoes.bin");
        ObjectOutputStream escrita;      
        try{
            escrita = new ObjectOutputStream(new FileOutputStream(ficheiro));
            
            escrita.writeObject(diasAtrasoPermitidos);
            escrita.writeObject(multaPorDia);
            
            escrita.close();
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a gravar configuracoes: " + ex);
        }   
    }
    
    private void carregarConf()
    {
        File ficheiro = new File("Configuracoes.bin");
            ObjectInputStream leitura = null; 
        
              
        try{
            leitura = new ObjectInputStream(new FileInputStream(ficheiro));
            //while((String nome=(String) leitura.readObject())!=eof())
            while(true)
            {
                diasAtrasoPermitidos = (Integer) leitura.readObject();
                multaPorDia = (Float) leitura.readObject();          
            }
            
            
         //   data.addAll(leitura.readObject());
         }catch (Exception ex) 
        {
            if (ex.getClass() == IOException.class)
            {
                System.out.println("Deu erro a carregar configuracoes: " + ex);
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
        fecharJanelas();
        formLogin.setVisible(true);        

        //função abaixo a aparecer depois de fazermos login
        //alertarAtraso();
    }
    
    @FXML
    private void definirAlertaAtraso(ActionEvent event) 
    {
        TextInputDialog dialog = new TextInputDialog(Integer.toString(diasAtrasoPermitidos));
        dialog.setTitle("Configurações");
        dialog.setHeaderText("");
        dialog.setContentText("Dias em atraso permitidos para devolver um livro:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            if(stringToInt(result.get()) != -1)
            {
                diasAtrasoPermitidos = stringToInt(result.get());
                System.out.println(diasAtrasoPermitidos);
            }
        }
        gravarConf();

    }
    
    private void alertarAtraso()
    {
        calcularDias();
        int i;
        String lista = "";
        for(i=0;i<dataRequisicao.size();i++)
            {
                
                if (stringToInt(req_dias_col.getCellData(i).toString()) > diasAtrasoPermitidos && req_dEnt_col.getCellData(i).equals(""))
                {
                   lista += "Nome: ";
                   lista += uti_nome_col.getCellData(UtiCcIndexOf(req_cc_col.getCellData(i).toString())).toString();
                   lista += "\t\tcc/tr: ";
                   lista += req_cc_col.getCellData(i).toString();
                   lista += "\n";             
                }
                System.out.println(lista); 

            }
        
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Utilizadores com livros em atraso!");
            alert.setHeaderText("");
            alert.setContentText(lista);
            alert.showAndWait();
    }

    @FXML
    private void botaoLogin(ActionEvent event) 
    {
      erroDeLogin.setVisible(false);
      int pos = FuncLoginIndexOf(campoLogin.getText());  
      
      if (pos ==-1)
            {
            erroDeLogin.setVisible(true);
            erroDeLogin.setText("Username Inválido");
            }
      else {
            if (func_pass_col.getCellData(pos).toString().equals(campoPass.getText()))
            {
                if (func_tipo_col.getCellData(pos).toString().equals("Funcionario"))                   
                {
                    login = "func";
                }  
                else if (func_tipo_col.getCellData(pos).toString().equals("Administrador"))
                {
                    login = "admin";
                }
                loginRestricoes();
                fecharJanelas();
                alertarAtraso();
            }
            else
            {
                erroDeLogin.setVisible(true);
                erroDeLogin.setText("Password Incorrecta");
            }
           }
    }

    @FXML
    private void definirMultaAtraso(ActionEvent event) 
    {
        TextInputDialog dialog = new TextInputDialog(Float.toString(multaPorDia));
        dialog.setTitle("Configurações");
        dialog.setHeaderText("");
        dialog.setContentText("Multa a pagar por dia em atraso:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            if(stringToFloat(result.get()) != -1)
            {
                multaPorDia = stringToFloat(result.get());
                System.out.println(multaPorDia);
            }
        }  
        gravarConf();
    }

    @FXML
    private void sairLogout(ActionEvent event) 
    {
        login = "aluno";
        loginRestricoes();
        menuLogout.setVisible(false);
        menuLogin.setVisible(true);
    }

    private void loginRestricoes() 
    {
        if (login.equals("aluno")) 
        {
            alunoRestricoes();
        } 
        else if(login.equals("func"))
                {
                    funcRestricoes();
                }
                else if(login.equals("admin"))
                        { 
                         adminRestricoes();
                         menuLogout.setVisible(true);
                         menuLogin.setVisible(false);
                        }         
                        else {
                               Alert alert = new Alert(AlertType.ERROR);
                               alert.setContentText("Erro estranho de Login");
                               alert.showAndWait();
                             }
    }
   
    private void alunoRestricoes()
    {
        menuGravar.setVisible(false);
        menuCarregar.setVisible(false);
        menuPesqUti.setVisible(false);
        menuPesqReq.setVisible(false);
        menuPesqFunc.setVisible(false);
        menuRegFunc.setVisible(false);
        menuConfig.setVisible(false);
        menuReg.setVisible(false);
        menuFloatRegLiv.setVisible(false);
        menuFloatAtivo.setVisible(false);
        menuFloatInativo.setVisible(false);
        menuGravarCSV.setVisible(false);
        menuCarregarCSV.setVisible(false);
    }
    private void funcRestricoes()
    {
        menuGravar.setVisible(false);
        menuCarregar.setVisible(false);
        menuPesqUti.setVisible(true);
        menuPesqReq.setVisible(true);
        menuPesqFunc.setVisible(false);
        menuRegFunc.setVisible(false);
        menuConfig.setVisible(true);
        menuReg.setVisible(true);
        menuFloatRegLiv.setVisible(true);
        menuFloatAtivo.setVisible(true);
        menuFloatInativo.setVisible(true);
        menuGravarCSV.setVisible(false);
        menuCarregarCSV.setVisible(false);
    }
    
    private void adminRestricoes()
    {
        menuGravar.setVisible(true);
        menuCarregar.setVisible(true);
        menuPesqUti.setVisible(true);
        menuPesqReq.setVisible(true);
        menuPesqFunc.setVisible(true);
        menuRegFunc.setVisible(true);
        menuConfig.setVisible(true);
        menuReg.setVisible(true);
        menuFloatRegLiv.setVisible(true);
        menuFloatAtivo.setVisible(true);
        menuFloatInativo.setVisible(true);
        menuGravarCSV.setVisible(true);
        menuCarregarCSV.setVisible(true);
    }

    @FXML
    private void gravarUtilizadorCSV(ActionEvent event) 
    {
        int i=0;      
        try{
            
            PrintWriter pw = new PrintWriter(new File("Utilizadores.csv"));  
            for(i=0;i<dataUtilizadores.size();i++)
            {
                String s = "\"" + uti_cc_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_nome_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_dNasc_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_cont_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_mail_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_mora_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_loc_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_nif_col.getCellData(i).toString() + "\""
                        + ";" + "\"" +  uti_tipo_col.getCellData(i).toString() + "\"" + "\n";
               pw.write(s);
            }
            
            pw.close();
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a exportar tabela dos Utilizadores: " + ex);
        }  
    }

    @FXML
    private void gravarLivroCSV(ActionEvent event) 
    {
        int i=0;      
        try{
            PrintWriter pw = new PrintWriter(new File("Livros.csv"));  
            
            for(i=0;i<dataLivros.size();i++)
            {
                String s ="\"" + liv_nLiv_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + liv_titu_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + liv_tema_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + liv_aut_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + liv_edi_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + liv_data_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + liv_requi_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + liv_ina_col.getCellData(i).toString() + "\"" + "\n";
                
                pw.write(s);

            }
            
            pw.close();
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a exportar tabela dos Livros: " + ex);
        }   
    }

    @FXML
    private void gravarRequisicaoCSV(ActionEvent event) 
    {
        int i=0;      
        try{
            PrintWriter pw = new PrintWriter(new File("Requisicao.csv"));  
            
            for(i=0;i<dataRequisicao.size();i++)
            {
                String s ="\"" + req_nLiv_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + req_cc_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + req_dReq_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + req_dEnt_col.getCellData(i).toString() + "\"" + "\n";
                
                pw.write(s);
            }
            
            pw.close();
            
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a exportar tabela das requisições: " + ex);
        }   
        
    }

    @FXML
    private void gravarFuncionarioCSV(ActionEvent event) 
    {
        int i=0;      
        try{
            PrintWriter pw = new PrintWriter(new File("Funcionario.csv"));            

            for(i=0;i<dataFuncionario.size();i++)
            {
                String s = "\"" + func_nome_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + func_login_col.getCellData(i).toString() + "\""
                        + ";" + "\"" + func_pass_col.getCellData(i).toString()+ "\""
                        + ";" + "\"" + func_tipo_col.getCellData(i).toString() + "\"" + "\n";
                
                pw.write(s);
            }
            
            pw.close();
            
         }catch (Exception ex) 
        {
            System.out.println("Deu erro a exportar tabela dos funcionarios: " + ex);
        }   
    }

    @FXML
    private void carregarUtilizadorCSV(ActionEvent event) 
    {
        BufferedReader br = null; 
        String line = "";
        try{    
        while (true)
        {
            dataUtilizadores.remove(0);
        }
        }catch (Exception ex){
            //vazio de proposito
        }    
        try{
            br = new BufferedReader(new FileReader("Utilizadores.csv"));
            while((line = br.readLine()) !=null)
            {               
                String[] s = line.split(";");
                
                dataUtilizadores.add(new Utilizador(s[0].substring(1, s[0].length()-1),
                        s[1].substring(1, s[1].length()-1),
                        s[2].substring(1, s[2].length()-1),
                        s[3].substring(1, s[3].length()-1),
                        s[4].substring(1, s[4].length()-1),
                        s[5].substring(1, s[5].length()-1),
                        s[6].substring(1, s[6].length()-1),
                        s[7].substring(1, s[7].length()-1),
                        s[8].substring(1, s[8].length()-1))); 
                
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
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void carregarLivroCSV(ActionEvent event) 
    {
        BufferedReader br = null; 
        String line = "";
        try{    
        while (true)
        {
            dataLivros.remove(0);
        }
        }catch (Exception ex){
            //vazio de proposito
        }    
        try{
            br = new BufferedReader(new FileReader("Livros.csv"));
            while((line = br.readLine()) !=null)
            {               
                String[] s = line.split(";");
                
                dataLivros.add(new Livro(s[0].substring(1, s[0].length()-1),
                        s[1].substring(1, s[1].length()-1),
                        s[2].substring(1, s[2].length()-1),
                        s[3].substring(1, s[3].length()-1),
                        s[4].substring(1, s[4].length()-1),
                        s[5].substring(1, s[5].length()-1),
                        s[6].substring(1, s[6].length()-1),
                        s[7].substring(1, s[7].length()-1))); 
                
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
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void carregarRequisicaoCSV(ActionEvent event) 
    {
        BufferedReader br = null; 
        String line = "";
              
        try{    
            while (true)
            {
                dataRequisicao.remove(0);
            }
        }catch (Exception ex){
            //vazio de proposito
        }  
            
            
        try{
            br = new BufferedReader(new FileReader("Requisicao.csv"));
            while((line = br.readLine()) !=null)
            {
                String[] s = line.split(";");
                
                dataRequisicao.add(new Requisicao(s[0].substring(1, s[0].length()-1),s[1].substring(1, s[1].length()-1),s[2].substring(1, s[2].length()-1),s[3].substring(1, s[3].length()-1))); 
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
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void carregarFuncionarioCSV(ActionEvent event) 
    {
        BufferedReader br = null; 
        String line = "";
              
        try{    
            while (true)
            {
                dataFuncionario.remove(0);
            }
        }catch (Exception ex){
            //vazio de proposito
        }  
            
            
        try{
            br = new BufferedReader(new FileReader("Funcionario.csv"));
            while((line = br.readLine()) !=null)
            {
                String[] s = line.split(";");
                
                dataFuncionario.add(new Funcionario(s[0].substring(1, s[0].length()-1),
                        s[1].substring(1, s[1].length()-1),
                        s[2].substring(1, s[2].length()-1),
                        s[3].substring(1, s[3].length()-1))); 
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
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ColunaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
}

