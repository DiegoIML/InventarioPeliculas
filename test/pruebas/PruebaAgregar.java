
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
        //EJEMPLO PARA PODER AGREGAR.
        operaciones = new OperacionesBD();
        int id_inventario = 1;
        int id_pelicula = 1;
        int id_tienda = 1;
        ///////////////////////////////////////////////////////////////////////////////////
        int numFilasAntes = operaciones.numeroFilasFilm( id_pelicula);
        if (numFilasAntes == -1) fail("Ha ocurrido un error en el numFilasAntes");
        
        if ( operaciones.agregarBD(Integer.toString(id_inventario), Integer.toString(id_pelicula) , Integer.toString(id_tienda) )) {
        
            int numFilasAhora =  operaciones.numeroFilasFilm( id_pelicula);
            if (numFilasAhora == -1) fail("Ha ocurrido un error en el numFilasAhora");
            
            if (numFilasAhora == numFilasAntes)  fail("No se ha realizado el agregar correctamente. filas anterior " + numFilasAntes + " filas actual " + numFilasAhora );
        }
        else fail ("Ha ocurrido un error en el metodo agregarBD. ");
        
       
    }
}
