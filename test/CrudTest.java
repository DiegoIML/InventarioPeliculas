import controlador.OperacionesBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.PeliculaInventario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class CrudTest {
    
    public OperacionesBD operaciones;
    public Conexion conexion;
    public CrudTest() {
    }
    
   // @BeforeClass
    public static void setUpClass() {
    }
    
   // @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         conexion = new Conexion(); 
         conexion.setConn( conexion.getConexion());
         if (conexion.getConn() == null)
             fail("no se logro conectar a la BD");
    }
    @Test
    public void pruebaEliminar() {
        //EJEMPLO PARA PODER ELIMINAR.
        int id_inventario = 1;
        //int id_pelicula = 1;
        //int id_tienda = 1;
        ///////////////////////////////////////////////////////////////////////////////////
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
    @Test
    public void pruebaBuscar() {
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
    
    @Test
    public void pruebaAgregar() {
        //EJEMPLO PARA PODER AGREGAR.
        
        int id_inventario = 1;
        int id_pelicula = 1;
        int id_tienda = 1;
        ///////////////////////////////////////////////////////////////////////////////////
        int numFilasAntes = operaciones.numeroFilas(id_inventario, id_pelicula, id_tienda);
        if (numFilasAntes == -1) fail("Ha ocurrido un error en el numFilasAntes");
        
        if ( operaciones.agregarBD(Integer.toString(id_inventario), Integer.toString(id_pelicula) , Integer.toString(id_tienda) )) {
        
            int numFilasAhora =  operaciones.numeroFilas(id_inventario, id_pelicula, id_tienda);
            if (numFilasAhora == -1) fail("Ha ocurrido un error en el numFilasAhora");
        
            if (numFilasAhora > numFilasAntes) {
                ///ESTA CORRECTO. 
            }
            else fail("No se ha realizado el agregar correctamente.");
        }
        else fail ("Ha ocurrido un error en el metodo agregarBD. ");
        
       
    }
    @Test
    public void pruebaBotonActualizar() {
        int antiguoIdInventario = 1;
        int antiguoIdPelicula = 4;
        int antiguoIdTienda = 6;
        int nuevoIdInventario = 2;
        int nuevoIdPelicula = 3; 
        int nuevoIdTienda = 6;
        if(operaciones.actualizarBD(Integer.toString(antiguoIdInventario), Integer.toString(antiguoIdPelicula) ,Integer.toString( antiguoIdTienda), Integer.toString(nuevoIdInventario), Integer.toString(nuevoIdPelicula), Integer.toString(nuevoIdTienda))) {
           if (operaciones.sigueAun(antiguoIdInventario , antiguoIdPelicula , antiguoIdTienda)) 
           fail("No se ha cambiado el valor antiguo");    
        }
        else fail("Ha ocurrido un error en el metodo actualizarBD.");
    }
    
    //@After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
