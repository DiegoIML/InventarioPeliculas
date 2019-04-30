
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BotonDescargar implements ActionListener{
    private JTable tabla;
    private JFrame ventana;
    public BotonDescargar(JTable tabla , JFrame ventana) {
     this.tabla = tabla;
     this.ventana = ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      OperacionesExcel usoExcel = new OperacionesExcel(tabla);  
      JFileChooser fc = new JFileChooser();
      FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel" , "xls", "xlsx");
      fc.setFileFilter(filtro);
      int seleccion = fc.showSaveDialog(ventana);
      if(seleccion == JFileChooser.APPROVE_OPTION) {
         File fichero = fc.getSelectedFile();
         if (fichero.getName().endsWith("xls") || fichero.getName().endsWith("xlsx")) {
             usoExcel.crear_Excel(new File(fichero.getPath()));
         }
         else {
            String direccion = fichero.getPath() + ".xls";
            usoExcel.crear_Excel(new File(direccion));
        }
 
      }
      
    }
    
    
}
