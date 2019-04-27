
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.Conexion;
import vista.VistaConexion;


public class BotonConectar implements ActionListener {

   private Conexion conexionBD ;
   private JFrame vista;
   
   public BotonConectar (JFrame vista , Conexion conexionBD) {
     this.vista = vista;
     this.conexionBD = conexionBD;
   }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        VistaConexion dialogo = new VistaConexion(this.vista,true,conexionBD);
        dialogo.setVisible(true);
    }
    
    
    
}
