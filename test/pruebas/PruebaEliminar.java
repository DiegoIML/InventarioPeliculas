
package pruebas;

import controlador.OperacionesBD;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PruebaEliminar {
    OperacionesBD operaciones;
    public PruebaEliminar() {
    }

    @Test
    public void pruebaEliminar() {
        operaciones = new OperacionesBD();
        int id_inventario = 1;
        if ( operaciones.eliminarBD(Integer.toString(id_inventario) )) {
            if ( !operaciones.haSidoEliminado(id_inventario)) {
               fail("NO SE HA ELIMINADO CORRECTAMENTE EN LA BASE DE DATOS , COMPRUEBA QUE EL ID ESTE EN EL INVENTARIO.");
           }
        }
        else fail ("Ha ocurrido un error en el metodo agregarBD. ");
        
    }
    
}
