
package Controlador;
import Vista.Inicio;
public class Controlador_Acceso {
  private String Contrasena;
  private String Usuario;
  private int Edad;
  
  
  public String getContrasena(){
  return this.Contrasena;
  }
  public void setContrasena(String Contrasena){
  this.Contrasena=Contrasena;
  }
  public String getUsuario(){
  return this.Usuario;
  }
  public void setUsuario(String Usuario){
  this.Usuario=Usuario;
  }
   public int getEdad(){
  return this.Edad;
  }
  public void setEdad(int Edad){
  this.Edad=Edad;
  }
  
  public void Validar(){
      if ((this.Contrasena.equals("123")) && (this.Usuario.equals("Miguel")) &&(this.Edad ==19)) {
      // System.out.println("La Contraseña y El Usuario son validos ");
      Inicio Mensaje=new Inicio();
      Mensaje.Mostrar_Mensaje_Exitoso(); 
      } else { 
      Inicio Error=new Inicio();
      Error.Mostrar_Mensaje_Erroneo();    
      //System.out.println("La Contraseña y El Usuario  no son validos ");   
      }
  }
}
