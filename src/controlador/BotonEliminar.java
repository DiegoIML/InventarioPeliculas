package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BotonEliminar implements ActionListener {
   private JTable tabla;
   public BotonEliminar( JTable tabla) {
       this.tabla = tabla;
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (tabla.isVisible()) {
                 DefaultTableModel aux = (DefaultTableModel) tabla.getModel();   
                 String inventory_id = String.valueOf(aux.getValueAt(tabla.getSelectedRow(),0));
                 OperacionesBD operaciones = new OperacionesBD();
                 operaciones.eliminarBD(inventory_id);
        }
        else 
           JOptionPane.showMessageDialog(null , "La tabla inventario debe ser visible");
    }
}
