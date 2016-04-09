/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdistribuidossocketcliente;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sistemasdistribuidossocketcliente.Gui.VentanaLlamada;

/**
 *
 * @author kryshedz
 */
public class SistemasDistribuidosSocketCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SistemasDistribuidosSocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
        VentanaLlamada ventana=new VentanaLlamada();
        ventana.setVisible(true);
    }
    
}
