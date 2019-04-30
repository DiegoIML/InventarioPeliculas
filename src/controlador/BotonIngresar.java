
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BotonIngresar implements ActionListener {
    private JTable tabla;
    private JFrame ventana;

    public BotonIngresar (JTable tabla , JFrame ventana) {
      this.tabla = tabla;
      this.ventana = ventana;
    }
    
    //Accion : ingresa el archivo excel en la tabla.
    @Override
    public void actionPerformed(ActionEvent ae) {
      JFileChooser fc = new JFileChooser();
      FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel" , "xls", "xlsx");
      fc.setFileFilter(filtro);
      int seleccion = fc.showOpenDialog(ventana);
      if(seleccion == JFileChooser.APPROVE_OPTION) {
         File fichero = fc.getSelectedFile();   
         if (fichero.getName().endsWith(".xls") || fichero.getName().endsWith(".xlsx")) {
             OperacionesExcel usoExcel = new OperacionesExcel(tabla); 
             usoExcel.leer_Excel(fichero);
         }
         else  JOptionPane.showMessageDialog(null , "No ha seleccionado ningun archivo.");

      }
    }
    
}
