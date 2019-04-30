
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
    //ingresa los datos del inventario a las casillas de texto.
    @Override
    public void mousePressed(MouseEvent me) {
         if (tabla.isVisible()) {
              String seleccionIdInventario =  String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0)); 
              String seleccionIdPelicula   =  String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),1));
              String seleccionIdTienda     =  String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),6)); 
              casillaIdInventario.setText(seleccionIdInventario);
              casillaIdPelicula.setText(seleccionIdPelicula);
              casillaIdTienda.setText(seleccionIdTienda);
        }
    }

   
    
    
    
}
