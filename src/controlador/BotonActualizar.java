
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;


public class BotonActualizar implements ActionListener {
    private JTable tabla;
    private JTextField casillaIdInventario;
    private JTextField casillaIdPelicula;
    private JTextField casillaIdTienda;
    
    public BotonActualizar(JTable tabla , JTextField casillaIdInventario, JTextField casillaIdPelicula, JTextField casillaIdTienda ) {
        this.tabla = tabla;
        this.casillaIdInventario = casillaIdInventario;
        this.casillaIdPelicula = casillaIdPelicula;
        this.casillaIdTienda = casillaIdTienda;        
    }
    
    public boolean comprobarCasillaIdInventario() {
       boolean correcto = false;
              String valor = casillaIdInventario.getText();
              if (!valor.isEmpty()) {
                  String regexp = "^\\d+$";
                  if (Pattern.matches(regexp , valor)) {
                     correcto = true;  
                  }
              }
       return  correcto;
    }
    
    public boolean comprobarCasillaIdPelicula() {
    
    }

    public boolean comprobarCasillaIdTienda() {
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         if (tabla.isVisible()) {
              DefaultTableModel aux = (DefaultTableModel) tabla.getModel();
              String antiguoIdInventario =  String.valueOf(aux.getValueAt(tabla.getSelectedRow(),0)); 
              String antiguoIdPelicula   =  String.valueOf(aux.getValueAt(tabla.getSelectedRow(),1));
              String antiguoIdTienda     =  String.valueOf(aux.getValueAt(tabla.getSelectedRow(),6)); 
              String nuevoIdInventario   =  casillaIdInventario.getText();
              String nuevoIdPelicula     =  casillaIdPelicula.getText(); 
              String nuevoIdTienda       =  casillaIdTienda.getText();
              OperacionesBD operaciones = new OperacionesBD();
              operaciones.actualizarBD(antiguoIdInventario, antiguoIdPelicula, antiguoIdTienda, nuevoIdInventario, nuevoIdPelicula, nuevoIdTienda);
              
         }
         else 
         {
           JOptionPane.showMessageDialog(null , "La tabla inventario debe ser visible");
         }
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
