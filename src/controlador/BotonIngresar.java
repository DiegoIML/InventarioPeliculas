
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class BotonIngresar implements ActionListener {
    private JTable tabla;

    public BotonIngresar (JTable tabla) {
      this.tabla = tabla;
    }
    
    
    
    
    public void leer_BD () {
        try {
             File archivo = new File("InventarioTienda.xls");
             Workbook libro = Workbook.getWorkbook(archivo);
             Sheet planilla = libro.getSheet(0);
             //Iterator iteradorFilas = planilla.rowIterator();   
             int filas = planilla.getRows();
             int columnas  = planilla.getColumns();
             DefaultTableModel modelo =(DefaultTableModel) tabla.getModel();
             modelo.addColumn("ID_Inventario");
             modelo.addColumn("ID_Pelicula");
             modelo.addColumn("Titulo_Pelicula");
             modelo.addColumn("Dias_Renta_Pelicula");
             modelo.addColumn("Duracion_Pelicula");
             modelo.addColumn("Año_Estreno_Pelicula");
             modelo.addColumn("ID_Tienda");
             modelo.addColumn("Ultima_Actualizacion_Inventario");
             tabla.setModel(modelo);
             String[] columnasInventario = new String[8]; 
             for (int i = 0 ; i < filas ; i++) {
                 
                 for (int j = 0 ; j < columnas ; j++)  {
                     Cell celda = planilla.getCell(j,i);
                     columnasInventario[j] = celda.getContents();
                    // modelo.setValueAt( celda ,i , j);
                 }
                 modelo.addRow(columnasInventario);
             }
             tabla.setModel(modelo);
             tabla.setVisible(true);
             libro.close();
             
        } catch (IOException ex) {
            Logger.getLogger(BotonIngresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(BotonIngresar.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        leer_BD();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
