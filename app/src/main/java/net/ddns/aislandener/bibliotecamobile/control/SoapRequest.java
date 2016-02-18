package net.ddns.aislandener.bibliotecamobile.control;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class SoapRequest {

    //Endereço do Serviço
    private final String URL="http://177.103.139.64:8080/WS/Biblioteca";

    //Definições das operações disponíveis no Serviço
    protected final String NAMESPACE="http://service/";

    //Este método é responsável por envelopar as
    //informações que serão transmitidas para o
    //Serviço
    protected SoapSerializationEnvelope getEnvelope(
            SoapObject obj){

        SoapSerializationEnvelope env =
                new SoapSerializationEnvelope(
                        SoapEnvelope.VER11);

        //env.dotNet = true;
        env.setOutputSoapObject(obj);
        return env;
    }


    //Método responsável por transportar (enviar)
    //os dados até o Serviço
    protected HttpTransportSE getTransport(){
        HttpTransportSE ht = new HttpTransportSE(URL);
        ht.debug = true;
        return ht;
    }


/*
    private Object chamarOperacao(String operacao,  SoapObject obj){

        Object resultado = null;
        SoapSerializationEnvelope env = getEnvelope(obj);
        HttpTransportSE ht = getTransport();
        try{
            String ACAO = NAMESPACE+operacao;
            ht.call(ACAO,env);
            SoapPrimitive res = (SoapPrimitive)
                    env.getResponse();

            //Converter a resposta de acordo com o
            //tipo de retorno da operação
            resultado = res;
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return resultado;
    }
    */

/*
    private List<Object> chamarOperacaoRetornarLista(
			String operacao,  SoapObject obj){

        List<Object> lista = null;
        SoapSerializationEnvelope env = getEnvelope(obj);
        HttpTransportSE ht = getTransport();


        try{
            String ACAO = NAMESPACE+operacao;
            ht.call(ACAO,env);

			//Retorno no formato de um Objeto ou uma
			//lista de Objeto
			SoapObject resposta = (SoapObject)env.bodyIn;

             lista = new ArrayList<Object>();

			for (int i = 0; i < resposta.getPropertyCount(); i++) {
				SoapObject obje = (SoapObject)resposta.getProperty(i);

				//Exibir os atributos do Objeto
//				System.out.println(obj.getProperty(0).toString());

			}
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return lista;
    }*/


	/*
    public String FahrenheitToCelsius(String valor){
        String OPERACAO = "FahrenheitToCelsius";
        SoapObject obj = new SoapObject(NAMESPACE,
                OPERACAO);
        obj.addProperty("Fahrenheit",valor);
        return chamarOperacao(OPERACAO,obj);
    }

    public String CelsiusToFahrenheit(String valor){
        String OPERACAO = "CelsiusToFahrenheit";
        SoapObject obj = new SoapObject(NAMESPACE,
                OPERACAO);
        obj.addProperty("Celsius",valor);
        return chamarOperacao(OPERACAO,obj);
    }*/



}