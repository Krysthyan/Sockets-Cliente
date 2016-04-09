/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasdistribuidossocketcliente.Utilidades;

import sistemasdistribuidossocketcliente.Gui.VentanaLlamada;

/**
 *
 * @author kryshedz
 */

 
public class Cronometro extends Thread {
    private int nuMin=0; 
    private int nuSeg=0;
    private int nuHora=0;
    public Cronometro(){ 
        super();
    }
    public void run() {
     //El Contador de Horas   
        try {//si ocurre un error al dormir el proceso(sleep(999))
            for (; ;){ //inicio del for infinito           
               if(getNuSeg()!=59) {//si no es el ultimo segundo
                   nuSeg++; //incremento el numero de segundos                                  
                }else{
                    if(getNuMin()!=59){//si no es el ultimo minuto
                        nuSeg=0;//pongo en cero los segundos 
                        nuMin++;//incremento el numero de minutos
                    }else{//incremento el numero de horas
                            nuHora++;
                            nuMin=0;//pongo en cero los minutos
                            nuSeg=0;//pongo en cero los segundos           
                    }
                }               
               VentanaLlamada.labelTime.setText(getNuHora()+":"+getNuMin()+":"+getNuSeg());
               
            sleep(999);
            }            
        } catch (Exception ex) {
             System.out.println(ex.getMessage());//Imprima el error
        }                 
    }

    /**
     * @return the nuMin
     */
    public int getNuMin() {
        return nuMin;
    }

    /**
     * @return the nuSeg
     */
    public int getNuSeg() {
        return nuSeg;
    }

    /**
     * @return the nuHora
     */
    public int getNuHora() {
        return nuHora;
    }
    

}
   
