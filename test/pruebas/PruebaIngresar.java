
package pruebas;

import controlador.OperacionesExcel;
import java.io.File;
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
      if (!usoExcel.leer_Excel(new File("ArchivoTest.xls")))
          fail("Ha fallado el ingreso del excel a la tabla.");
    }
}
