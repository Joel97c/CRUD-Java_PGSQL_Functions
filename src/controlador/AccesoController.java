/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import Modelo.Acceso_Model;
import Modelo.Conexion;
import Vista.Acceso;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class AccesoController {
     Conexion db = new Conexion ();  
    private Acceso vista=new Acceso();
    private Acceso_Model modelo=new Acceso_Model();
    private String login;
    private String clave;
    
    //getters y setters para el modelo
	public String getLogin() {
		return this.login;
              //  System.out.print("l login es ");
	}
	public void setLogin(String login) {
		this.login=login;
	}
	public String getClave() {
		return this.clave;
	}
	public void setClave(String clave) {
		this.clave=clave; 
	}
	
        public void BuscarUsuario() throws Exception{ 
        
        //  JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa Nombre de la Base de Dato: dPOO_usuariob_name");
          modelo.setClave(this.getClave());
          modelo.setLogin(this.getLogin());
        if(modelo.BuscarUsuario()==1){
        vista.MostrarMenu();
        }else
          vista.MostrarError();  
	
      
}
                  
                    
	
	//pasa el modelo a la vista para presentar los datos
	public void actualizarVista() {
		vista.MostrarMenu();              
                
                
	}
    
    
    
}
