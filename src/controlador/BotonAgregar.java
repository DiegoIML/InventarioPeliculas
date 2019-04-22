package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BotonAgregar implements ActionListener {
    private final JTable tabla; 
    
    public BotonAgregar(JTable tabla) {
        this.tabla =tabla;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
    if (tabla.isVisible()) {      
        DefaultTableModel aux = (DefaultTableModel) tabla.getModel();   
        String inventory_id = String.valueOf(aux.getValueAt(tabla.getSelectedRow(),0));
        String film_id = String.valueOf(aux.getValueAt(tabla.getSelectedRow(),1));
        String store_id = String.valueOf(aux.getValueAt(tabla.getSelectedRow(),6));
        OperacionesBD operaciones = new OperacionesBD();
        operaciones.agregarBD(inventory_id, film_id, store_id);    
    }
    else
          JOptionPane.showMessageDialog(null , "La tabla inventario debe ser visible");
    }
}
