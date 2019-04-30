package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

public class BotonEliminar implements ActionListener {
   private JTable tabla;
   private Conexion conexionBD;
   public BotonEliminar(Conexion conexionBD , JTable tabla) {
       this.conexionBD = conexionBD;
       this.tabla = tabla;
   }
   //Accion : elimina la copia seleccionada del inventario.
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (tabla.isVisible()) {
                 DefaultTableModel aux = (DefaultTableModel) tabla.getModel();   
                 String inventory_id = String.valueOf(aux.getValueAt(tabla.getSelectedRow(),0));
                 
                 OperacionesBD operaciones = new OperacionesBD();
                 operaciones.setDatosBD(conexionBD.getPuerto(), conexionBD.getUsuario(), conexionBD.getContraseña());
                 
                 operaciones.eliminarBD(inventory_id);
        }
        else 
           JOptionPane.showMessageDialog(null , "La tabla inventario debe ser visible");
    }
}
