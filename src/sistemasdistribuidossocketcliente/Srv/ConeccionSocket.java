/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidossocketcliente.Srv;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import sistemasdistribuidossocketcliente.Utilidades.Llamada;

/**
 *
 * @author kryshedz
 */

public class ConeccionSocket {
    public static Socket SOCKET_CLIENTE;
    DataOutputStream envio;
    DataInputStream recibo;
    BufferedInputStream bufferedAudio;

    public ConeccionSocket(String direccionIp) throws IOException {
        SOCKET_CLIENTE=new Socket(direccionIp, 9999);
    }
    
    
    

    public void tipoEnvio(String tipo,int tamano) throws IOException{
        envio=new DataOutputStream(SOCKET_CLIENTE.getOutputStream());
        envio.writeUTF(tipo);
        envio.writeInt(tamano);
        
        
    }
    public void envioNombreArchivo(String nombre) throws IOException{
        envio=new DataOutputStream(SOCKET_CLIENTE.getOutputStream());



        envio.writeUTF(nombre);
    }
    public String tipoRecibo() throws IOException{
        recibo=new DataInputStream(SOCKET_CLIENTE.getInputStream());
        return recibo.readUTF().toString();
        
    }
    public void enviarDatosArchivo(File archivo,int tamanoArchivo) throws IOException{
        envio=new DataOutputStream(SOCKET_CLIENTE.getOutputStream());
        FileInputStream flujoEntradaAudio=new FileInputStream(archivo);
        bufferedAudio=new BufferedInputStream(flujoEntradaAudio);
        

        byte[] archivoByte=new byte[tamanoArchivo];
        
        bufferedAudio.read(archivoByte);
        
        for (int i = 0; i < archivoByte.length; i++) {
            envio.write(archivoByte[i]);
        }
        
        
    }
    public void enviarDatosObjeto(Llamada objeto) throws IOException{
        System.out.println("enviar objeto");
        envio=new DataOutputStream(SOCKET_CLIENTE.getOutputStream());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(bos);
        ous.writeObject(objeto);
        ous.close();
        byte[] cadenaByte = bos.toByteArray();
        int tamObj=cadenaByte.length;
        System.out.println("envio tipo objeto");
        this.tipoEnvio("OBJETO", tamObj);
        for (int i = 0; i < cadenaByte.length; i++) {
            envio.write(cadenaByte[i]);
        }
        
        
        
    }
    public float recibirDatosCosto() throws IOException{
        recibo=new DataInputStream(SOCKET_CLIENTE.getInputStream());
        return recibo.readFloat();
        
    }
    public void cerrarConecionTotal() throws IOException{
        if(recibo != null)
            recibo.close();
        if(envio != null)
            envio.close();
        if(bufferedAudio!=null)
            bufferedAudio.close();
        if(SOCKET_CLIENTE != null)
            SOCKET_CLIENTE.close();
    }
    
   
    
    
    

    
}
