
package controlador;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class OperacionesExcel {
    private JTable tabla;
    public OperacionesExcel (JTable tabla) {
       this.tabla = tabla;
    }
    
     public boolean crear_Excel() {
        boolean exito = false;
        if (tabla.isVisible()) {
            
            WorkbookSettings configuracion = new WorkbookSettings();
            configuracion.setEncoding("ISO-8859-1");
            try {
                WritableWorkbook libro = Workbook.createWorkbook(new File("InventarioTienda.xls") , configuracion);
                WritableSheet planilla = libro.createSheet("Inventario Peliculas" , 0);
                DefaultTableModel modelo =(DefaultTableModel) tabla.getModel();
                String [] etiquetasColumnas =  { "ID_Inventario" , "ID_Pelicula" , "Titulo_Pelicula" , "Dias_Renta_Pelicula" , "Duracion_Pelicula" , "Año_Estreno_Pelicula" , "ID_Tienda" , "Ultima_Actualizacion_Inventario"} ;
                //////////////////////////////////////////////////////////////////////////////////////
                for (int  k = 0 ; k < modelo.getColumnCount() ; k++ ) {
                     planilla.addCell(new jxl.write.Label(k,0, etiquetasColumnas[k]));
                }
                /////////////////////////////////////////////////////////////////////////////////////
                for ( int i = 0 ; i < modelo.getRowCount() ; i++) {
                    for (int j = 0 ; j < modelo.getColumnCount() ; j++){
                      planilla.addCell(new jxl.write.Label(j,i, (String) modelo.getValueAt(i,j)));
                    }
                }
                libro.write();
                libro.close();
                JOptionPane.showMessageDialog(null , "Se ha completado la descarga exitosamente.");
                exito = true;
                } catch (IOException ex) {
                Logger.getLogger(BotonDescargar.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null , "Ha ocurrido un error al intentar descargar el inventario.");
            } catch (WriteException ex) {
                Logger.getLogger(BotonDescargar.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null , "Ha ocurrido un error al intentar descargar el inventario.");
            }
        }
        else  JOptionPane.showMessageDialog(null , "La tabla inventario debe ser visible");
        
        
        return exito;
    }
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
      public boolean leer_BD () {
        boolean exito = false ;
        try {
             File archivo = new File("InventarioTienda.xls");
             Workbook libro = Workbook.getWorkbook(archivo);
             Sheet planilla = libro.getSheet(0);
             //Iterator iteradorFilas = planilla.rowIterator();   
             int filas = planilla.getRows();
             int columnas  = planilla.getColumns();
             
             
             DefaultTableModel modelo =(DefaultTableModel) tabla.getModel();
             if(!tabla.isVisible()) {  
                    modelo.addColumn("ID_Inventario");
                    modelo.addColumn("ID_Pelicula");
                    modelo.addColumn("Titulo_Pelicula");
                    modelo.addColumn("Dias_Renta_Pelicula");
                    modelo.addColumn("Duracion_Pelicula");
                    modelo.addColumn("Año_Estreno_Pelicula");
                    modelo.addColumn("ID_Tienda");
                    modelo.addColumn("Ultima_Actualizacion_Inventario");
                    tabla.setModel(modelo);
                    TableColumnModel modeloColumna = tabla.getColumnModel();
                    modeloColumna.getColumn(0).setPreferredWidth(120);
                    modeloColumna.getColumn(1).setPreferredWidth(120);
                    modeloColumna.getColumn(2).setPreferredWidth(200);
                    modeloColumna.getColumn(3).setPreferredWidth(150);
                    modeloColumna.getColumn(4).setPreferredWidth(120);
                    modeloColumna.getColumn(5).setPreferredWidth(120);
                    modeloColumna.getColumn(6).setPreferredWidth(120);
                    modeloColumna.getColumn(7).setPreferredWidth(250);
             }
             //tabla.setModel(modelo);
             String[] columnasInventario = new String[8]; 
             for (int i = 1 ; i < filas ; i++) {
                 
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
             JOptionPane.showMessageDialog(null , "Se ha ingresado el excel exitosamente.");
             exito = true;
             
        } catch (IOException ex) {
            Logger.getLogger(BotonIngresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(BotonIngresar.class.getName()).log(Level.SEVERE, null, ex);
        }
      return exito;
    }
      
      
}
