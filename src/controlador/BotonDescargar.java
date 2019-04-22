
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class BotonDescargar implements ActionListener{
    private JTable tabla;
    public BotonDescargar(JTable tabla) {
     this.tabla = tabla;
    }
    
    
    public void crear_Excel() {
        if (tabla.isVisible()) {
            
            
            
            
            WorkbookSettings configuracion = new WorkbookSettings();
            configuracion.setEncoding("ISO-8859-1");
            try {
                WritableWorkbook libro = Workbook.createWorkbook(new File("InventarioTienda.xls") , configuracion);
                WritableSheet planilla = libro.createSheet("Inventario Peliculas" , 0);
                DefaultTableModel modelo =(DefaultTableModel) tabla.getModel();
                for ( int i = 0 ; i < modelo.getRowCount() ; i++) {
                    for (int j = 0 ; j < modelo.getColumnCount() ; j++){
                      planilla.addCell(new jxl.write.Label(j,i, (String) modelo.getValueAt(i,j)));
                    }
                }
                libro.write();
                libro.close();
                /*
                Workbook libro = new XSSWorkbook();
                Sheet planilla = libro.createSheet("Inventario Pelculas");
               
                String peliculaInventario[] = new String[8] ;
                for ( int i = 0 ; i < modelo.getRowCount() ; i++) {
                Row fila = planilla.createRow(i);
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,1)  );
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,2)  );
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,3)  );
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,4)  );
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,5)  );
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,6)  );
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,7)  );
                fila.createCell(i).cellValue( (String) modelo.getValueAt(i,8)  );
                // Y como agrego XD
                }
                
                try
                {
                FileOutputStream archivoSalida = new FileOutputStream("InventarioTienda.xlsx");
                libro.write(archivoSalida);
                archivoSalida.close();
                }
            */} catch (IOException ex) {
                Logger.getLogger(BotonDescargar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (WriteException ex) {
                Logger.getLogger(BotonDescargar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else  JOptionPane.showMessageDialog(null , "La tabla inventario debe ser visible");
        
        
      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      crear_Excel();  
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
