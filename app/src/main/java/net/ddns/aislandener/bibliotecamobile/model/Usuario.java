package net.ddns.aislandener.bibliotecamobile.model;

import android.content.ContentValues;
import android.database.Cursor;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.Hashtable;

public class Usuario implements KvmSerializable {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(SoapObject soapObject){
        id = Integer.parseInt(soapObject.getProperty("id").toString());
        nome = soapObject.getProperty("nome").toString();
        telefone = soapObject.getProperty("telefone").toString();
        email = soapObject.getProperty("email").toString();
        senha = soapObject.getProperty("senha").toString();
    }

    public Usuario(Cursor cursor){
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.nome = cursor.getString(cursor.getColumnIndex("nome"));
        this.email = cursor.getString(cursor.getColumnIndex("email"));
        this.senha = cursor.getString(cursor.getColumnIndex("senha"));
        this.telefone = cursor.getString(cursor.getColumnIndex("telefone"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put("id", this.id);
        cv.put("nome", this.nome);
        cv.put("email", this.email);
        cv.put("telefone", this.telefone);
        cv.put("senha", this.senha);
        return cv;
    }

    //A partir desta linha, será utilizado para o kSOAP2
    //poder se organizar ao receber do WS

    //Este metodo é como se fosse um “get especial”
    //Você passa o índice da propriedade que você quer buscar

    public Object getProperty(int arg0) {
        switch(arg0) {
            case 0:
                return id;
            case 1:
                return nome;
            case 2:
                return telefone;
            case 3:
                return email;
            case 4:
                return senha;
        }

        return null;
    }

    //Este método retorna a quantidade de propriedades que a classe
    //possui
    public int getPropertyCount() {
        return 5;
    }

    //Este metodo define as informações das propriedades para o
    //ksoap. Nunca precisei utilizar este método. Mas o ksoap
    //precisa dele para definir o tipo complexo

    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
        switch(index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nome";
                break;

            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "telefone";
                break;

            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "email";
                break;

            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "senha";
                break;

            default: break;
        }
    }

    public String getInnerText() {
        return null;
    }

    public void setInnerText(String s) {

    }

    //Este metodo é como se fosse um “set especial”
    //você passa o índice da propriedade e o valor
    public void setProperty(int index, Object value) {
        switch(index) {
            case 0:
                id = (int) value;
                break;
            case 1:
                nome = value.toString();
                break;

            case 2:
                telefone = value.toString();
                break;

            case 3:
                email = value.toString();
                break;

            case 4:
                senha = value.toString();
                break;

            default:
                break;
        }
    }

}