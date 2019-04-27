
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;



public class BotonIngresar implements ActionListener {
    private JTable tabla;

    public BotonIngresar (JTable tabla) {
      this.tabla = tabla;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
      OperacionesExcel usoExcel = new OperacionesExcel(tabla); 
      usoExcel.leer_BD();
    }
    
}
