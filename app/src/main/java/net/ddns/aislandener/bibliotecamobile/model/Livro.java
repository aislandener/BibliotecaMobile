package net.ddns.aislandener.bibliotecamobile.model;

import android.content.ContentValues;
import android.database.Cursor;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.Hashtable;

/**
 * Created by aislandener on 29/01/16.
 */
public class Livro implements KvmSerializable{


    private int id;
    private String titulo;
    private String autores;
    private int edicao;
    private String editora;
    private String cidade;
    private int ano;
    private String descricao;

    public Livro() {
    }

    public Livro(Cursor cursor){
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.titulo = cursor.getString(cursor.getColumnIndex("titulo"));
        this.autores = cursor.getString(cursor.getColumnIndex("autores"));
        this.edicao = cursor.getInt(cursor.getColumnIndex("edicao"));
        this.editora = cursor.getString(cursor.getColumnIndex("editora"));
        this.cidade = cursor.getString(cursor.getColumnIndex("cidade"));
        this.ano = cursor.getInt(cursor.getColumnIndex("ano"));
        this.descricao = cursor.getString(cursor.getColumnIndex("descricao"));
    }
    public Livro(SoapObject response) {
        this.id = Integer.parseInt(response.getProperty("id").toString());;
        this.titulo = response.getProperty("titulo").toString();;
        this.autores = response.getProperty("autores").toString();;
        this.edicao = Integer.parseInt(response.getProperty("edicao").toString());;
        this.editora = response.getProperty("editora").toString();;
        this.cidade = response.getProperty("cidade").toString();;
           this.ano = Integer.parseInt(response.getProperty("ano").toString());;
        this.descricao = response.getProperty("descricao").toString();;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        if (id != livro.id) return false;
        if (edicao != livro.edicao) return false;
        if (ano != livro.ano) return false;
        if (!titulo.equals(livro.titulo)) return false;
        if (!autores.equals(livro.autores)) return false;
        if (!editora.equals(livro.editora)) return false;
        if (!cidade.equals(livro.cidade)) return false;
        return descricao.equals(livro.descricao);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + titulo.hashCode();
        result = 31 * result + autores.hashCode();
        result = 31 * result + edicao;
        result = 31 * result + editora.hashCode();
        result = 31 * result + cidade.hashCode();
        result = 31 * result + ano;
        result = 31 * result + descricao.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues(); 

        cv.put("id",id);
        cv.put("titulo",titulo);
        cv.put("autores",autores);
        cv.put("edicao",edicao);
        cv.put("editora",editora);
        cv.put("cidade",cidade);
        cv.put("ano",ano);
        cv.put("descricao",descricao);

        return cv;
    }

    //Metodos do KvmSerializable

    @Override
    public Object getProperty(int arg0) {
        switch (arg0){
            case 0:
                return id;
            case 1:
                return titulo;
            case 2:
                return autores;
            case 3:
                return edicao;
            case 4:
                return editora;
            case 5:
                return cidade;
            case 6:
                return ano;
            case 7:
                return descricao;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 8;
    }

    /**
     * Propriedades do KvmSerializable
     * (Index => Propriedades)
     * <br />0 => ID
     * <br />1 => Titulo
     * <br />2 => Autores
     * <br />3 => Edição
     * <br />4 => Editora
     * <br />5 => Cidade
     * <br />6 => Ano
     * <br />7 => Descrição
     * */
    @Override
    public void setProperty(int index, Object value) {
        switch(index){
            case 0:
                id = (int) value;
                break;
            case 1:
                titulo = value.toString();
                break;
            case 2:
                autores = value.toString();
                break;
            case 3:
                edicao = (int) value;
                break;
            case 4:
                editora = value.toString();
                break;
            case 5:
                cidade = value.toString();
                break;
            case 6:
                ano = (int) value;
                break;
            case 7:
                descricao = value.toString();
                break;
            default:
                break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo info) {
        switch(i){
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "titulo";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "autores";
                break;
            case 3:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "edicao";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "editora";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "cidade";
                break;
            case 6:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "ano";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "descricao";
                break;
        }
    }

    public String getInnerText() {
        return null;
    }

    public void setInnerText(String s) {

    }
}