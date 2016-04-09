/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidossocketcliente.Utilidades;
import javax.sound.sampled.*;
import java.io.*;
/**
 *
 * @author kryshedz
 */

 
public class GrabarAudio {
    AudioFormat formatoAudio;
    TargetDataLine targetDataLine;
    File archivoAudio = null;
    // record duration, in milliseconds

    public GrabarAudio(String nombreAudio) {
        this.archivoAudio=new File("src/"+nombreAudio+".wav");
    }
    
    
    
    class CapturarThread extends Thread{
        public void run(){
            AudioFileFormat.Type tipoArchivo = AudioFileFormat.Type.WAVE;

            try{
                targetDataLine.open(formatoAudio);
                targetDataLine.start();
                AudioSystem.write(new AudioInputStream(targetDataLine),tipoArchivo,archivoAudio);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private void capturarAudio(){
        try{
            formatoAudio = obtenerFormatoAudio();
            DataLine.Info dataLineInfo =new DataLine.Info(TargetDataLine.class,formatoAudio);
            targetDataLine = (TargetDataLine)AudioSystem.getLine(dataLineInfo);

            new CapturarThread().start();
        }catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    private AudioFormat obtenerFormatoAudio(){
        float sampleRate = 8000.0F;
        //8000,11025,16000,22050,44100
        int sampleSizeInBits = 16;
        //8,16
        int channels = 1;
        //1,2
        boolean signed = true;
        //true,false
        boolean bigEndian = false;
        //true,false
        return new AudioFormat(sampleRate,sampleSizeInBits,channels,signed,bigEndian);
    }
    public void incio(){
        capturarAudio();
    }  
    public void stop(){
        targetDataLine.stop();
        targetDataLine.close();
    } 
        
}