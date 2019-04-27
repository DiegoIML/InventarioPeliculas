
package pruebas;

import controlador.OperacionesBD;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaActualizar {
    OperacionesBD operaciones;
    public PruebaActualizar() {
    }
    
    @Test
    public void pruebaBotonActualizar() {
        operaciones = new OperacionesBD();
        int antiguoIdInventario = 2;
        int antiguoIdPelicula = 1;
        int antiguoIdTienda = 1;
        int nuevoIdInventario = 1;
        int nuevoIdPelicula = 1; 
        int nuevoIdTienda = 1;
        if(operaciones.actualizarBD(Integer.toString(antiguoIdInventario), Integer.toString(antiguoIdPelicula) ,Integer.toString( antiguoIdTienda), Integer.toString(nuevoIdInventario), Integer.toString(nuevoIdPelicula), Integer.toString(nuevoIdTienda))) {
           if (!operaciones.haSidoActualizado(antiguoIdInventario , antiguoIdPelicula , antiguoIdTienda)) 
           fail("NO SE HA ACTUALIZADO CORRECTAMENTE EN LA BASE DE DATOS.");    
        }
        else fail("Ha ocurrido un error en el metodo actualizarBD.");
    }
    
   
}
