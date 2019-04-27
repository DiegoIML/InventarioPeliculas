
package pruebas;

import controlador.OperacionesBD;
import org.junit.Test;
import static org.junit.Assert.*;


public class PruebaAgregar {
    OperacionesBD operaciones;
    public PruebaAgregar() {
    }
    
    
    @Test
    public void pruebaAgregar() {
        operaciones = new OperacionesBD();
        int id_inventario = 5000;
        int id_pelicula = 1;
        int id_tienda = 1;

        if ( operaciones.agregarBD(Integer.toString(id_inventario), Integer.toString(id_pelicula) , Integer.toString(id_tienda) )) {
           if ( !operaciones.haSidoAgregado(id_inventario)) {
               fail("NO SE HA AGREGADO CORRECTAMENTE EN LA BASE DE DATOS , COMPRUEBA QUE EL ID NO ESTE EN EL INVENTARIO.");
           }
        }
        else fail ("Ha ocurrido un error en el metodo agregarBD. ");
        
       
    }
}
