package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.PeliculaInventario;

public class OperacionesBD extends Conexion{

    
    public ArrayList<PeliculaInventario> leerBD () {
       PreparedStatement ps;
       ResultSet rs;
       Connection conn = getConexion(); 
       ArrayList<PeliculaInventario> listaPeliculas = new ArrayList<>(); 
       try {
                 String leeBD = 
                 "       (Select tabla.inventory_id , tabla.film_id , tabla.title , MAX(tabla.rental_duration) , tabla.length , tabla.release_year , tabla.store_id , tabla.last_update\n" +
                 "    From  (Select i.inventory_id , i.film_id , f.title , f.rental_duration , f.length , f.release_year , i.store_id , i.last_update  \n" +
                 "          From inventory as i , film as f , rental as r\n" +
                 "		  Where i.film_id = f.film_id and  r.inventory_id = i.inventory_id and r.rental_date is not null 	       \n" +
                 "    Order by f.title , i.inventory_id ASC	) as tabla \n" +
                 "    Where  inventory_id = tabla.inventory_id  and film_id = tabla.film_id\n" +
                 "    Group by tabla.inventory_id  , tabla.film_id , tabla.title ,  tabla.length , tabla.release_year , tabla.store_id , tabla.last_update	  \n" +
                 "	)\n" +
                 "	union all\n" +
                 "	(\n" +
                 "	Select distinct i.inventory_id , i.film_id , f.title , f.rental_duration , f.length , f.release_year , i.store_id , i.last_update  \n" +
                 "    From inventory as i , film as f \n" +
                 "    Where i.film_id =  f.film_id and  i.inventory_id not in (Select r.inventory_id From rental r)\n" +
                 "    )\n" +
                 "	Order by  title , inventory_id ASC; ";
           

                ps = conn.prepareStatement(leeBD);
                rs = ps.executeQuery();
                while (rs.next()) {
                    
                     PeliculaInventario peliculaNueva = new PeliculaInventario( rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8)  );
                     listaPeliculas.add(peliculaNueva);
   
                 }
                 conn.close();
                 return listaPeliculas;
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
               
            }
       return listaPeliculas;
    }
    
    public boolean agregarBD (String inventory_id , String film_id , String store_id ){
       boolean exito  = false;
       PreparedStatement ps;
       ResultSet rs;
       Connection conn = getConexion();  
       String leeBD  = "Select Max(inventory_id) From inventory ;" ;
        
            try {
                  ps = conn.prepareStatement(leeBD);
                  rs = ps.executeQuery();
                

                 int last_inventory_id = 0;
                 if (rs.next()) {
                     last_inventory_id = rs.getInt(1) + 1;
                 }
                 //System.out.println("Valor del ultimo id = " + last_inventory_id);
                 String insertarBD = "insert into inventory(inventory_id ,film_id , store_id , last_update ) values  (?,?,?,localtimestamp)"  ;
                 ps = conn.prepareStatement(insertarBD);
                 ps.setInt (1 , last_inventory_id  );
                 ps.setInt (2 ,Integer.parseInt(film_id ));
                 ps.setInt (3 ,Integer.parseInt(store_id));
                 //ps.set
                 int res = ps.executeUpdate();
                 if (res > 0) {
                        JOptionPane.showMessageDialog(null , "Se ha creado una copia en el inventario");
                        exito = true;
                 }
                 else  {
                       JOptionPane.showMessageDialog(null , "no se ha podido agregar el inventario");
                 }
                 conn.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
                
            }
       return exito;
    }
    
    public boolean actualizarBD( String antiguoIdInventario, String antiguoIdPelicula , String antiguoIdTienda, String nuevoIdInventario, String nuevoIdPelicula, String nuevoIdTienda) {
       boolean exito = false;
       PreparedStatement ps;
       Connection conn = getConexion(); 
            try {
                  String actualizarBD = "update inventory set inventory_id = ? , film_id = ? , store_id  = ? , last_update = localtimestamp  where inventory_id = ? and film_id = ? and store_id = ?"  ;
                  ps = conn.prepareStatement(actualizarBD);
                  ps.setInt (1 ,Integer.parseInt(nuevoIdInventario));
                  ps.setInt (2 ,Integer.parseInt(nuevoIdPelicula ));
                  ps.setInt (3 ,Integer.parseInt(nuevoIdTienda));
                  ps.setInt (4 ,Integer.parseInt(antiguoIdInventario)) ;
                  ps.setInt (5 , Integer.parseInt(antiguoIdPelicula));
                  ps.setInt (6 , Integer.parseInt(antiguoIdTienda));
                 int res = ps.executeUpdate();
                 if (res > 0) {
                        JOptionPane.showMessageDialog(null , "Se ha podido actualizar el inventario");
                        exito = true;
                 }
                 else  {
                       JOptionPane.showMessageDialog(null , "no se ha podido actualizar el inventario");
                 }
                 conn.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
               
            }
       return exito;
       
    }
    
    public boolean eliminarBD (String inventory_id) {
       boolean exito = false;
       PreparedStatement ps;
       ResultSet rs;
       Connection conn = getConexion(); 
            try {
                 String insertarBD = "delete from inventory where inventory_id  = ?"  ;
                 ps = conn.prepareStatement(insertarBD);
                 //rs = ps.executeQuery();
                 //PreparedStatement ps =conn.prepareStatement(insertarBD);
                 ps.setInt (1 , (Integer.parseInt(inventory_id))  );
                 int res = ps.executeUpdate();
                 if (res > 0) {
                        JOptionPane.showMessageDialog(null , "Se ha eliminado una copia en el inventario");
                        exito = true;
                 }
                 else  {
                       JOptionPane.showMessageDialog(null , "no se ha podido eliminar una copia en el inventario");
                 }
                 conn.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
               
            }
       return exito;
    }
      
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public boolean haSidoAgregado ( int nuevo_id) {
        boolean cierto = true;
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = getConexion();     
            try {
                String consultaBD = "SELECT i.film_id FROM inventory as i WHERE i.film_id = ?;";
                ps = conn.prepareStatement(consultaBD);
                ps.setInt( 1, nuevo_id);
                rs = ps.executeQuery();
                int valor = 0;
                 if (rs.next()) {   
                     valor = rs.getInt(1);
                 }
                 if (valor == 0) 
                     cierto = false;
                 conn.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error en el metodo haSidoAgregado(int): "+e.getMessage());          
            }
        return cierto;
    }
    
    ////////////////////////////////////////////////////////////
    public boolean haSidoEliminado ( int eliminado_id) {
      boolean cierto = false;
      PreparedStatement ps;
      ResultSet rs;
      Connection conn = getConexion();     
            try {
                String consultaBD = "SELECT i.film_id FROM inventory as i WHERE i.film_id = ?;";
                ps = conn.prepareStatement(consultaBD);
                ps.setInt( 1, eliminado_id);
                rs = ps.executeQuery();
                int valor = 0;
                 if (rs.next()) {   
                     valor = rs.getInt(1);
                 }
                 if (valor == 0) 
                     cierto = true;
                 conn.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error en el metodo haSidoEliminado(int): "+e.getMessage());          
            }
      return cierto;
    }
    ////////////////////////////////////////////////////////////
    public boolean haSidoActualizado ( int anterior_inventory_id  , int anterior_film_id , int anterior_store_id ) 
    {
        boolean cierto = false;
        PreparedStatement ps;
        ResultSet rs;
        Connection conn = getConexion();     
            try {
                String consultaBD = "SELECT i.inventory_id , i.film_id  , i.store.id FROM inventory as i WHERE i.inventory_id = ? and i.film_id = ? and i.store_id = ?;";
                ps = conn.prepareStatement(consultaBD);
                ps.setInt( 1, anterior_inventory_id);
                ps.setInt( 2, anterior_film_id);
                ps.setInt( 3, anterior_store_id);
                rs = ps.executeQuery();
                 int inventory_id = 0;                          
                 if (rs.next()) {   
                     inventory_id =rs.getInt(1);
                     
                 }
                 if (inventory_id == 0) 
                     cierto = true;
                 conn.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error en el metodo haSidoActualizado(int,int,int): "+e.getMessage());          
            }
        return cierto;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
}
