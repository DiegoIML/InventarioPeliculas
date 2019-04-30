package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Conexion;
import modelo.PeliculaInventario;

public class BotonBuscar implements ActionListener {
    private JTable tabla;
    private Conexion conexionBD;
    
    public BotonBuscar ( Conexion conexionBD , JTable tabla) {
      this.tabla = tabla;
      this.conexionBD = conexionBD;
    }
    
    // ACCION : obtener las peliculas del inventario disponibles para la renta.
    @Override
    public void actionPerformed(ActionEvent ae) {
       String[] columnasPelicula = new String[8];
       DefaultTableModel modelo = new DefaultTableModel();
     
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
    
       OperacionesBD operaciones = new OperacionesBD();
       operaciones.setDatosBD(conexionBD.getPuerto(), conexionBD.getUsuario(), conexionBD.getContraseña());
       
       ArrayList<PeliculaInventario> listaPeliculas =  operaciones.leerBD();
       if (listaPeliculas != null) 
       { 
           for (PeliculaInventario peliculaObtenida : listaPeliculas) {
            columnasPelicula[0] = peliculaObtenida.getI_inventory_id();
            columnasPelicula[1] = peliculaObtenida.getI_film_id();
            columnasPelicula[2] = peliculaObtenida.getF_title();
            columnasPelicula[3] = peliculaObtenida.getF_rental_duration();
            columnasPelicula[4] = peliculaObtenida.getF_length();
            columnasPelicula[5] = peliculaObtenida.getF_release_year();
            columnasPelicula[6] = peliculaObtenida.getI_store_id();
            columnasPelicula[7] = peliculaObtenida.getI_last_update();
            modelo.addRow(columnasPelicula); 
           }
           tabla.setModel(modelo);
           tabla.setVisible(true); 
       }
       else
        JOptionPane.showMessageDialog(null , "Ha ocurrido un error al ingresar a la BD");
    }
}
