
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
 public class Utilizador {
 
        private final SimpleStringProperty cc;
        private final SimpleStringProperty nome;
        private final SimpleStringProperty dNascimento;
        private final SimpleStringProperty contacto;
        private final SimpleStringProperty email;
        private final SimpleStringProperty morada;
        private final SimpleStringProperty localidade;
        private final SimpleStringProperty nif;
        private final SimpleStringProperty tipo;
 
        Utilizador(String scc, String snome,String sdNascimento, String scontacto, String semail, String smorada,String slocalidade, String snif, String stipo) {
            this.cc = new SimpleStringProperty(scc);
            this.nome = new SimpleStringProperty(snome);
            this.dNascimento = new SimpleStringProperty(sdNascimento);
            this.contacto = new SimpleStringProperty(scontacto);
            this.email = new SimpleStringProperty(semail);
            this.morada = new SimpleStringProperty(smorada);
            this.localidade = new SimpleStringProperty(slocalidade);
            this.nif = new SimpleStringProperty(snif);
            this.tipo = new SimpleStringProperty(stipo);
        }
 
        public String getCc() {
            return cc.get();
        }
 
        public void setCc(String scc) {
            cc.set(scc);
        }
 
        public String getNome() {
            return nome.get();
        }
 
        public void setNome(String snome) {
            nome.set(snome);
        }
        
        public String getDNascimento() {
            return dNascimento.get();
        }
 
        public void setDNascimento(String s) {
            dNascimento.set(s);
        }
        
        public String getContacto() {
            return contacto.get();
        }
 
        public void setContacto(String scontacto) {
            contacto.set(scontacto);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String smail) {
            email.set(smail);
        }
        
        public String getMorada() {
            return morada.get();
        }
 
        public void setMorada(String smorada) {
            morada.set(smorada);
        }
        public String getLocalidade() {
            return localidade.get();
        }
 
        public void setLocalidade(String s) {
            localidade.set(s);
        }
        
        public String getNif() {
            return nif.get();
        }
 
        public void setNif(String snif) {
            email.set(snif);
        }
        
        public String getTipo() {
            return tipo.get();
        }
 
        public void setTipo(String snif) {
            tipo.set(snif);
        }
    }
