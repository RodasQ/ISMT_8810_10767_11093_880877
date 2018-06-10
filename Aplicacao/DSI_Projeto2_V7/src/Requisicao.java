
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zoide
 */
public class Requisicao {
    private final SimpleStringProperty nLivro;
    private final SimpleStringProperty cc;
    private final SimpleStringProperty dRequisicao;
    private final SimpleStringProperty dEntrega;
    private final SimpleIntegerProperty dias;
    

    Requisicao(String snLivro, String scc, String sdRequisicao, String sdEntrega) {
        this.nLivro = new SimpleStringProperty(snLivro);
        this.cc = new SimpleStringProperty(scc);
        this.dRequisicao = new SimpleStringProperty(sdRequisicao);
        this.dEntrega = new SimpleStringProperty(sdEntrega);
        this.dias = new SimpleIntegerProperty();
    }
    
    
    public String getNLivro() {
        return nLivro.get();
    }
 
    public void setNLivro(String s) {
        nLivro.set(s);
    }
    
    public StringProperty nLivroProperty()
        {
            return nLivro;
        }
    
    public String getCc() {
        return cc.get();
    }
 
    public void setCc(String s) {
        cc.set(s);
    }
    
    public StringProperty ccProperty()
        {
            return cc;
        }
    
    public String getDRequisicao() {
        return dRequisicao.get();
    }
 
    public void setDRequisicao(String s) {
        dRequisicao.set(s);
    }
    
    public StringProperty dRequisicaoProperty()
        {
            return dRequisicao;
        }
    
    public String getDEntrega() {
        return dEntrega.get();
    }
 
    public void setDEntrega(String s) {
        dEntrega.set(s);
    }
    
    public StringProperty dEntregaProperty()
        {
            return dEntrega;
        }
    
    public Integer getDias() {
        return dias.get();
    }
 
    public void setDias(Integer s) {
        dias.set(s);
    }
    
    public IntegerProperty diasProperty()
        {
            return dias;
        }
}
