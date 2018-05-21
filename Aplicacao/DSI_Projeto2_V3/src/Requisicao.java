
import javafx.beans.property.SimpleStringProperty;

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
    

    Requisicao(String snLivro, String scc, String sdRequisicao, String sdEntrega) {
        this.nLivro = new SimpleStringProperty(snLivro);
        this.cc = new SimpleStringProperty(scc);
        this.dRequisicao = new SimpleStringProperty(sdRequisicao);
        this.dEntrega = new SimpleStringProperty(sdEntrega);
    }
    
    
    public String getNLivro() {
        return nLivro.get();
    }
 
    public void setNLivro(String s) {
        nLivro.set(s);
    }
    
    public String getCc() {
        return cc.get();
    }
 
    public void setCc(String s) {
        cc.set(s);
    }
    
    public String getDRequisicao() {
        return dRequisicao.get();
    }
 
    public void setDRequisicao(String s) {
        dRequisicao.set(s);
    }
    
    public String getDEntrega() {
        return dEntrega.get();
    }
 
    public void setDEntrega(String s) {
        dEntrega.set(s);
    }
}
