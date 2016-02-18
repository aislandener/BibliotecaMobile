package net.ddns.aislandener.bibliotecamobile.control;


import net.ddns.aislandener.bibliotecamobile.model.Livro;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * Created by aislandener on 29/01/16.
 */
public class SoapLivro extends SoapRequest {

    private List<Livro> listBooks(SoapObject obj){
        List<Livro> books = new ArrayList<>();
        SoapSerializationEnvelope enviar = getEnvelope(obj);
        HttpTransportSE trasmicao = getTransport();
        try{
            String ACAO = NAMESPACE+"pesquisarLivros/";
            trasmicao.call(ACAO,enviar);

            Vector<SoapObject> resposta = (Vector<SoapObject>) enviar.getResponse();

            for(SoapObject response : resposta){
                books.add(new Livro(response));
            }
            if(!books.isEmpty()){
                return books;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Livro> listBooks(String nomeLivro){
        String OPERACAO = "pesquisarLivros";
        SoapObject obj = new SoapObject(NAMESPACE,OPERACAO);
        obj.addProperty("nome_livro",nomeLivro);
        return listBooks(obj);
    }

    private Livro listBook(SoapObject obj){
        Livro book;
        SoapSerializationEnvelope enviar = getEnvelope(obj);
        HttpTransportSE trasmicao = getTransport();
        try{
            String ACAO = NAMESPACE+"pesquisarLivros/";
            trasmicao.call(ACAO, enviar);

            SoapObject resposta = (SoapObject) enviar.getResponse();
            book = new Livro(resposta);

            return book;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Livro listBook(int idLivro){
        String OPERACAO = "pesquisarLivro";
        SoapObject obj = new SoapObject(NAMESPACE,OPERACAO);
        obj.addProperty("id_livro",idLivro);
        return listBook(obj);
    }

}

