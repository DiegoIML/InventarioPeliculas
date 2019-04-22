package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.PeliculaInventario;

public class BotonBuscar implements ActionListener {
        //COMPLETA LOS VALORES DE LA TABLA.
    private JTable tabla;
    public BotonBuscar (JTable tabla) {
      this.tabla = tabla;
    }

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
       
       OperacionesBD operaciones = new OperacionesBD();
       ArrayList<PeliculaInventario> listaPeliculas =  operaciones.leerBD();
       if (listaPeliculas != null) 
       { 
           for (PeliculaInventario peliculaObtenida : listaPeliculas) {
           //modelo.addRow(peliculaObtenida);
           //modelo.addRow(listaPeliculas.toArray());
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
       else System.out.println("Ha ocurrido un error al ingresar a la BD");
    }
}
