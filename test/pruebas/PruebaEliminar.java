
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
        int numFilasAntes = operaciones.numeroFilas(id_inventario);
        if (numFilasAntes == -1) fail("Ha ocurrido un error en el numFilasAntes");
        
        if ( operaciones.eliminarBD(Integer.toString(id_inventario) )) {
        
            int numFilasAhora =  operaciones.numeroFilas(id_inventario);
            if (numFilasAhora == -1) fail("Ha ocurrido un error en el numFilasAhora");
        
            if (numFilasAhora < numFilasAntes) {
                ///ESTA CORRECTO. 
            }
            else fail("No se ha realizado el agregar correctamente.");
        }
        else fail ("Ha ocurrido un error en el metodo agregarBD. ");
        
    }
    
}
