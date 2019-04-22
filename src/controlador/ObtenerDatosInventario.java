
package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ObtenerDatosInventario extends MouseAdapter{
    
    private JTable tabla;
    private JTextField casillaIdInventario;
    private JTextField casillaIdPelicula;
    private JTextField casillaIdTienda;
  
    public ObtenerDatosInventario(JTable tabla , JTextField casillaIdInventario, JTextField casillaIdPelicula, JTextField casillaIdTienda) {
        this.tabla = tabla;
        this.casillaIdInventario = casillaIdInventario;
        this.casillaIdPelicula = casillaIdPelicula;
        this.casillaIdTienda = casillaIdTienda; 
    }

    @Override
    public void mouseClicked(MouseEvent me) {
         if (tabla.isVisible()) {
              //DefaultTableModel aux = (DefaultTableModel) tabla.getModel();
              String seleccionIdInventario =  String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0)); 
              String seleccionIdPelicula   =  String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),1));
              String seleccionIdTienda     =  String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),6)); 
              casillaIdInventario.setText(seleccionIdInventario);
              casillaIdPelicula.setText(seleccionIdPelicula);
              casillaIdTienda.setText(seleccionIdTienda);
              System.out.println(" " + casillaIdInventario + " " + casillaIdPelicula + " " + casillaIdTienda );
        }
        else {
        System.out.println("La tabla es invisible");
        }
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
}
