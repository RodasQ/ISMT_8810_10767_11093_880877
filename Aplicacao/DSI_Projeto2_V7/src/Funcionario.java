
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
public class Funcionario {
        private final SimpleStringProperty nome;
        private final SimpleStringProperty login;
        private final SimpleStringProperty password;
        private final SimpleStringProperty tipo;
        
        Funcionario(String snome, String slogin, String spassword, String stipo)
        {
            this.nome = new SimpleStringProperty(snome);
            this.login = new SimpleStringProperty(slogin);
            this.password = new SimpleStringProperty(spassword);
            this.tipo = new SimpleStringProperty(stipo);
        }
    
        
        public String getNome() {
            return nome.get();
        }
 
        public void setNome(String s) {
            nome.set(s);
        }
        
        public StringProperty nomeProperty()
        {
            return nome;
        }
        
        public String getLogin() {
            return login.get();
        }
 
        public void setLogin(String s) {
            login.set(s);
        }
        
        public StringProperty loginProperty()
        {
            return login;
        }
        
        public String getPassword() {
            return password.get();
        }
 
        public void setPassword(String s) {
            password.set(s);
        }
        
        public StringProperty passwordProperty()
        {
            return password;
        }
        
        public String getTipo() {
            return tipo.get();
        }
 
        public void setTipo(String s) {
            tipo.set(s);
        }
        
        public StringProperty tipoProperty()
        {
            return tipo;
        }
}
