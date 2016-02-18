package net.ddns.aislandener.bibliotecamobile.control;

import net.ddns.aislandener.bibliotecamobile.model.Usuario;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SoapUsuario extends SoapRequest{

    private Usuario login(SoapObject obj,String OPERACAO){
        SoapSerializationEnvelope enviar = getEnvelope(obj);
        HttpTransportSE trasmicao = getTransport();
        try {
            String ACAO = NAMESPACE+OPERACAO+"/";
            trasmicao.call(ACAO, enviar);

            SoapObject resposta = (SoapObject) enviar.getResponse();

            return new Usuario(resposta);

        }catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }

    public Usuario login(String email, String senha){
        String OPERACAO = "login";
        SoapObject obj = new SoapObject(NAMESPACE,OPERACAO);
        obj.addProperty("email",email);
        obj.addProperty("senha",senha);
        return login(obj,OPERACAO);
    }

    public Usuario buscaUsuario(int id){
        String OPERACAO = "buscaUsuario";
        SoapObject obj = new SoapObject(NAMESPACE,OPERACAO);
        obj.addProperty("id",id);
        return login(obj,OPERACAO);
    }



    private List<Usuario> listaUsers(SoapObject obj){
        List<Usuario> users = new ArrayList<>();
        SoapSerializationEnvelope enviar = getEnvelope(obj);
        HttpTransportSE trasmicao = getTransport();
        try {
            String ACAO = NAMESPACE+"listarUsuario/";
            trasmicao.call(ACAO, enviar);

            Vector<SoapObject> resposta = (Vector<SoapObject>) enviar.getResponse();

            for (SoapObject response : resposta){
                users.add(new Usuario(response));
            }

            return users;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public List<Usuario> listAllUsers(){
        String OPERACAO = "listarUsuario";
        SoapObject objeto = new SoapObject(NAMESPACE,OPERACAO);
        objeto.addProperty("nome","");
        return listaUsers(objeto);
    }

}
