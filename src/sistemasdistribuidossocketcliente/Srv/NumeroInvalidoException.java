/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidossocketcliente.Srv;

/**
 *
 * @author kryshedz
 */
public class NumeroInvalidoException extends Exception {
    private final String mensaje;
    public NumeroInvalidoException(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
