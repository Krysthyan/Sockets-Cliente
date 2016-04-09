    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidossocketcliente.Utilidades;

import java.io.Serializable;

/**
 *
 * @author kryshedz
 */
public class Llamada implements Serializable{
    
    private String numeroTelefono;
    private int hora;
    private int minutos;
    private int segundos;
    

    public Llamada(String numeroTelefono,int hora, int minutos, int segundos) {
        this.numeroTelefono=numeroTelefono;
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    
    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the minutos
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * @param minutos the minutos to set
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    /**
     * @return the segundos
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

   
    
    public float cobrarLlamada(String tipoLlamada){
        float cobroMin=(float) 0.0;
        float cobroHora=(float)0.0;
        float cobroTotal=(float)0.0;
        switch(tipoLlamada){
            case("internacional"):
                cobroMin=(float) (this.minutos*0.25);
                cobroHora=(float)(this.hora*15);
                if(this.minutos==0 && this.hora==0){
                    cobroTotal=(float) 0.25;
                    
                }else{
                    if(this.segundos>0)
                        cobroTotal=(float) (cobroHora+cobroMin+0.25);
                    else
                        cobroTotal=(float) (cobroHora+cobroMin);
                }
                break;
                
            case("nacionalConvencional"):
                cobroMin=(float) (this.minutos*0.20);
                cobroHora=(float)(this.hora*12);
                if(this.minutos==0 && this.hora==0){
                    cobroTotal= (float) 0.20;
                }else{
                    if(this.segundos>0)
                        cobroTotal=(float) (cobroHora+cobroMin+0.20);
                    else
                        cobroTotal=(float) (cobroHora+cobroMin);
                }
                break;
                
            case("celularNacional"):
                cobroMin=(float) (this.minutos*0.10);
                cobroHora=(float)(this.hora*6);
                System.out.println(this.hora+" "+this.minutos+" "+this.segundos);
                if(this.minutos==0 && this.hora==0){
                    cobroTotal= (float) 0.10;
                }else{
                    if(this.segundos>0)
                        cobroTotal=(float) (cobroHora+cobroMin+0.10);
                    else
                        cobroTotal=(float) (cobroHora+cobroMin);
                }
                break;
            default:
                cobroTotal=(float) 0.0;
                
        }
        return cobroTotal;
        
    }

    /**
     * @return the numeroTelefono
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * @param numeroTelefono the numeroTelefono to set
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
   
}
