/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidossocketcliente.Srv;

import java.io.File;
import java.io.IOException;
import sistemasdistribuidossocketcliente.Utilidades.Llamada;

/**
 *
 * @author kryshedz
 */
public class LlamadaSrv {
    ConeccionSocket coneccionSocket;
    
    public void conectar(String direccionIp) throws IOException{
        coneccionSocket=new ConeccionSocket(direccionIp);
    }
    public void enviarAudio(String direccionIp,String nombreArchivo) throws IOException{
        conectar(direccionIp);
        File archivo=new File("src/"+nombreArchivo);
        int tamAudio=(int) archivo.length();
        
        coneccionSocket.tipoEnvio("AUDIO",tamAudio);
        coneccionSocket.envioNombreArchivo(nombreArchivo);
        coneccionSocket.enviarDatosArchivo(archivo, tamAudio);
        coneccionSocket.cerrarConecionTotal();
        
    }
    public void enviarObjeto(String direccionIp,String numeroTelefono,int hora,int min,int seg) throws IOException{
        conectar(direccionIp);
        Llamada llamada=new Llamada(numeroTelefono,hora,min,seg);
        coneccionSocket.enviarDatosObjeto(llamada);
        System.out.println("llamada srv");
    }
    public float recibirCobro() throws IOException{
        return coneccionSocket.recibirDatosCosto();
    }
    public void cerrarConeccion() throws IOException{
     
        coneccionSocket.cerrarConecionTotal();
    }
    
    public void validarNumero(String numero) throws NumeroInvalidoException{
        int numeroLng=numero.length();
        if(numeroLng!=7 && numeroLng!=10 && numeroLng!=13)
            throw new NumeroInvalidoException("El numero ingresado es incorrecto");
    }
}
