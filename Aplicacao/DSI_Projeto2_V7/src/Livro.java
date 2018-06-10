
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
public class Livro {
    private final SimpleStringProperty nLivro;
    private final SimpleStringProperty titulo;
    private final SimpleStringProperty tema;
    private final SimpleStringProperty autor;
    private final SimpleStringProperty editora;
    private final SimpleStringProperty data;
    private final SimpleStringProperty requisitado;
    private final SimpleStringProperty inativo;
    
    
    Livro(String snLivro, String stitulo, String stema, String sautor, String seditora, String sdata, String srequisitado, String sinativo) {
        this.nLivro = new SimpleStringProperty(snLivro);
        this.titulo = new SimpleStringProperty(stitulo);
        this.tema = new SimpleStringProperty(stema);
        this.autor = new SimpleStringProperty(sautor);
        this.editora = new SimpleStringProperty(seditora);
        this.data = new SimpleStringProperty(sdata);
        this.requisitado = new SimpleStringProperty(srequisitado);
        this.inativo = new SimpleStringProperty(sinativo);
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
    
    public String getTitulo() {
        return titulo.get();
    }
 
    public void setTitulo(String s) {
        titulo.set(s);
    }
    
    public StringProperty tituloProperty()
        {
            return titulo;
        }
    
    public String getTema() {
        return tema.get();
    }
 
    public void setTema(String s) {
        tema.set(s);
    }
    
    public StringProperty temaProperty()
        {
            return tema;
        }
    
    public String getAutor() {
        return autor.get();
    }
 
    public void setAutor(String s) {
        autor.set(s);
    }
    
    public StringProperty autorProperty()
        {
            return autor;
        }
    
    public String getEditora() {
        return editora.get();
    }
 
    public void setEditora(String s) {
        editora.set(s);
    }
    
    public StringProperty editoraProperty()
        {
            return editora;
        }
    
    public String getData() {
        return data.get();
    }
 
    public void setData(String s) {
        data.set(s);
    }
    
    public StringProperty dataProperty()
        {
            return data;
        }
    
    public String getRequisitado() {
        return requisitado.get();
    }
 
    public void setRequisitado(String s) {
        requisitado.set(s);
    }
    
    public StringProperty requisitadoProperty()
        {
            return requisitado;
        }
    
    public String getInativo() {
        return inativo.get();
    }
 
    public void setInativo(String s) {
        inativo.set(s);
    }
    
    public StringProperty inativoProperty()
        {
            return inativo;
        }

    
}
