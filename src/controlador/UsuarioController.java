/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.*;
import Vista.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class UsuarioController {
  Conexion db = new Conexion ();  
  Usuario_Model modelo=new Usuario_Model();
  Usuario vista=new Usuario();
    private String Usuario;
     private String Clave;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Login,String Clave) {
        this.Clave = Clave;
    }
     
      public void BuscarUsuario(String usuario) throws Exception{ 
     
       if(modelo.BuscarUsuario(usuario)==1){
        vista.MostrarDatos(modelo.getUsuario(),modelo.getClave(),modelo.getId(),modelo.isActivo());
        }else
         vista.MostrarMensaje("2");  
	
      }
      public void GuardarUsuario(String usuario,String clave) throws Exception{ 
     
       if(modelo.GuardarUsuario(usuario,clave)==1){
         vista.MostrarMensaje("1");
        }else
         vista.MostrarError("Usuario no Guardardo");  
	}
     public void ModificarUsuario(String usuario,String clave,String id) throws Exception{ 
     
       if(modelo.ModificarUsuario(usuario,clave,true,id)==1){
         vista.MostrarMensaje("3");
        }else
         vista.MostrarError("Error al Modificar Datos");  
	}
     
     public void EliminarUsuario(String id) throws Exception{ 
     
       if(modelo.EliminarUsuario(id)==1){
         vista.MostrarMensaje("4");
          vista.MostrarDatos("","",0,true);
        }else
         vista.MostrarError("Error al Eliminar Datos");  
	}
} 
     

