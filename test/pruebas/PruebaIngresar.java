
package pruebas;

import controlador.OperacionesExcel;
import javax.swing.JTable;
import static org.junit.Assert.fail;
import org.junit.Test;


public class PruebaIngresar {
    
    public PruebaIngresar() {
    }
    @Test
    public void pruebaIngresar () {
     JTable tabla = new JTable();
     OperacionesExcel usoExcel = new OperacionesExcel(tabla); 
      if (!usoExcel.leer_BD())
          fail("Ha fallado el ingreso del excel a la tabla.");
    }
}
