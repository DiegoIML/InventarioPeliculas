
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
    
    private Conexion conexionBD;
    private JTable tabla;
    private JTextField casillaIdInventario;
    private JTextField casillaIdPelicula;
    private JTextField casillaIdTienda;
    
    public BotonActualizar(Conexion conexionBD ,JTable tabla , JTextField casillaIdInventario, JTextField casillaIdPelicula, JTextField casillaIdTienda ) {
        this.tabla = tabla;
        this.casillaIdInventario = casillaIdInventario;
        this.casillaIdPelicula = casillaIdPelicula;
        this.casillaIdTienda = casillaIdTienda;
        this.conexionBD = conexionBD;        
    }
    
    // ESTADO : funciona Bien.
    // ACCION : comprobar si el dato en a casilla ID_INVENTARIO es Correcto.
    
    public boolean comprobarCasillaIdInventario() {
       boolean correcto = false;
              String valor = casillaIdInventario.getText();
              if (!valor.isEmpty()) {
                 if(valor.equals("0")) {
                     JOptionPane.showMessageDialog(null ,"El valor de ID_Inventario debe ser un número entero positivo mayor que cero.");
                 }
                 else {
                      String regexp = "^\\d+$";
                      if(Pattern.matches(regexp , valor)) {
                      correcto = true;  
                      }
                 }    
              }
              else  {
                   JOptionPane.showMessageDialog(null ,"Debe ingresar un valor para el campo ID_Inventario.");
              }
       return  correcto;
    }
    
    // ESTADO : funciona Bien.
    // ACCION : comprobar si el dato en a casilla ID_PELICULA es Correcto.
    
    public boolean comprobarCasillaIdPelicula() {
       boolean correcto = false;
             String valor = casillaIdPelicula.getText();
             if (!valor.isEmpty()) {        
                if(valor.equals("0")) {
                    JOptionPane.showMessageDialog(null ,"El valor del ID_Pelicula debe ser un número entero positivo mayor que cero.");
                 }
                 else {
                      String regexp = "^\\d+$";
                      if(Pattern.matches(regexp , valor)) {
                      correcto = true;  
                      }
                 }    
       
             }
             else {
                 JOptionPane.showMessageDialog(null ,"Debe ingresar un valor para el campo ID_Pelicula.");
             }
       return correcto;      
    }

    // ESTADO : funciona Bien.
    // ACCION : comprobar si el dato en a casilla ID_TIENDA es Correcto.
    
    public boolean comprobarCasillaIdTienda() {
       boolean correcto = false;
             String valor = casillaIdTienda.getText();
             if (!valor.isEmpty()) {
                    if(valor.equals("0")) {
                     JOptionPane.showMessageDialog(null ,"El valor del ID_Tienda debe ser un número entero positivo mayor que cero.");
                 }
                 else {
                      String regexp = "^\\d+$";
                      if(Pattern.matches(regexp , valor)) {
                      correcto = true;  
                      }
                 }            
                   
             }
             else {
                   JOptionPane.showMessageDialog(null ,"Debe ingresar un valor para el campo ID_Tienda.");
             }
       return correcto;     
    }
    
    //ACCION : cambiar los datos del inventario seleccionado.
    @Override
    public void actionPerformed(ActionEvent ae) {
         if (tabla.isVisible()) {
              DefaultTableModel aux = (DefaultTableModel) tabla.getModel();
              if ( comprobarCasillaIdInventario() && comprobarCasillaIdPelicula() && comprobarCasillaIdTienda()) {
                String antiguoIdInventario =  String.valueOf(aux.getValueAt(tabla.getSelectedRow(),0)); 
                String antiguoIdPelicula   =  String.valueOf(aux.getValueAt(tabla.getSelectedRow(),1));
                String antiguoIdTienda     =  String.valueOf(aux.getValueAt(tabla.getSelectedRow(),6)); 
                String nuevoIdInventario   =  casillaIdInventario.getText();
                String nuevoIdPelicula     =  casillaIdPelicula.getText(); 
                String nuevoIdTienda       =  casillaIdTienda.getText();
                
                OperacionesBD operaciones = new OperacionesBD();
                operaciones.setDatosBD(conexionBD.getPuerto(), conexionBD.getUsuario(), conexionBD.getContraseña());            
                operaciones.actualizarBD(antiguoIdInventario, antiguoIdPelicula, antiguoIdTienda, nuevoIdInventario, nuevoIdPelicula, nuevoIdTienda);
                
              } else  {
                JOptionPane.showMessageDialog(null ,"Ingrese bien los campos de texto.");
              }
              
         }
         else  {
           JOptionPane.showMessageDialog(null , "La tabla inventario debe ser visible");
         }
    }
    
    
    
}
