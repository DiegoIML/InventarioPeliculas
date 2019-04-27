package pruebas;

import controlador.OperacionesBD;
import java.util.ArrayList;
import modelo.PeliculaInventario;
import org.junit.Test;
import static org.junit.Assert.*;


public class PruebaBuscar {
    private OperacionesBD operaciones;
      
    public PruebaBuscar() {
    }

     @Test
    public void pruebaBuscar() {
                 operaciones = new OperacionesBD();
                 ArrayList<PeliculaInventario> listaInventario = operaciones.leerBD();
                 int numFilas  = operaciones.numeroFilas();
                 if (numFilas == -1) {
                       fail("Ha ocurrido un error en numFilas");
                 }
                 else  {
                    if (numFilas != listaInventario.size()){
                        fail("No es igual la lista de elemento obtenida.");
                    }
                 
                  }
               
    }
}
