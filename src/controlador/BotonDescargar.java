
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class BotonDescargar implements ActionListener{
    private JTable tabla;
    public BotonDescargar(JTable tabla) {
     this.tabla = tabla;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      OperacionesExcel usoExcel = new OperacionesExcel(tabla); 
      usoExcel.crear_Excel();  
    }
    
    
}
