package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Conexion;

public class BotonActualizarDatosBD implements ActionListener{
   private Conexion conexionBD;
   private JTextField campoPuerto;
   private JTextField campoUsuario;
   private JTextField campoContraseña;
   
   public BotonActualizarDatosBD (Conexion conexionBD , JTextField campoPuerto , JTextField campoUsuario , JTextField campoContraseña) {
        this.conexionBD = conexionBD;
        this.campoPuerto =  campoPuerto;
        this.campoUsuario = campoUsuario;
        this.campoContraseña = campoContraseña;       
   }
   
    // ESTADO : funciona Bien.
    // ACCION : comprobar si el dato en la casilla PUERTO es Correcto.
   
   public boolean comprobarCampoPuerto() {
      boolean correcto = false;
              String valor = campoPuerto.getText();
              if (!valor.isEmpty()) {
                  
                 if(valor.equals("0")) {
                     JOptionPane.showMessageDialog(null ,"El valor del Puerto debe ser un número entero positivo mayor que cero.");
                 }
                 else {
                      String regexp = "^\\d+$";
                      if(Pattern.matches(regexp , valor)) {
                      correcto = true;  
                      }
                 }   
              } else  {
                   JOptionPane.showMessageDialog(null ,"Debe ingresar un valor para el campo Puerto.");
              }
       return  correcto;
   }
    // ESTADO : funcion Bien.
    // ACCION : comprobar si el dato en la casilla PUERTO es Correcto.
   
   public boolean comprobarCampoUsuario() {
     boolean correcto = false;
     String valor = campoUsuario.getText();
              if (!valor.isEmpty()) {
                     correcto = true;  
              } else  {
                   JOptionPane.showMessageDialog(null ,"No ha ingresado un valor en el campo Usuario. ");
              }
     return correcto;
   }
   
   
    // ESTADO : funciona Bien.
    // ACCION : comprobar si el dato en la casilla CONTRASEÑA es Correcto.
   
   public boolean comprobarCampoContraseña(){
     boolean correcto = false;
     String valor = campoContraseña.getText();
              if (!valor.isEmpty()) {
                     correcto = true;  
              } else  {
                   JOptionPane.showMessageDialog(null ,"No ha ingresado un valor en el campo Contraseña. ");
              }
     return correcto;
   }
   
    // ACCION : cambiar los datos del inventario seleccionado.
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (comprobarCampoPuerto() && comprobarCampoUsuario() && comprobarCampoContraseña()){
            conexionBD.setDatosBD(campoPuerto.getText(), campoUsuario.getText(), campoContraseña.getText());
            JOptionPane.showMessageDialog(null , "Los Datos han sido actualizados");
        }

    }
   
   
}
