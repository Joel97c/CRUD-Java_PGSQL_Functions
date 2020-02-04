/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author home
 */


public class Acceso_Model {
    private String login;
    private String clave;
    Conexion db=new Conexion();
 //private static Connection Conexion;
// Conexion c=new Conexion();
 
    public void setLogin(String login) {
        this.login = login;
        System.out.println("El login es "+this.login);
    }

    public void setClave(String clave) {
        this.clave = clave;
         System.out.println("La clave es "+this.clave);
    }

    public String getLogin() {
        return this.login;
    }

    public String getClave() {
        return this.clave;
    }

    public Acceso_Model(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }
    public Acceso_Model() {
       
    }
  /* public int BuscarUsuario(){
     
       
	if (this.getClave().equals("123") && this.getLogin().equals("yogle"))
        {
            return 1;
          //  Admin_oper m=new Admin_oper(); 
        //    m.setVisible(true); 
           // dispose(); 
        } else {
              return 2;      
            //JOptionPane.showMessageDialog(this,"USUARIO / CONTRASEÑA INCORRECTA");
        }
	}*/
   
   public int BuscarUsuario() throws Exception {
    int valor=0;
     if (db.Conectar()==1) {
            String Query = "SELECT * FROM usuarios where usuario='"+this.getLogin()+"' and clave='"+this.getClave()+"'" ;
            System.out.println("elSQL es "+Query);          
            ResultSet resultado=db.EjecutarSQL(Query);
          // JOptionPane.showMessageDialog(null, "consulta ejecutadas es "+ Query);          
           if (resultado.next()) {
                System.out.println("Login: " + resultado.getString("usuario") + " " + "clave: " + resultado.getString("clave"));
                valor= 1;
            }else {valor= 0;}
            db.desconectar();
           }
            else {  }
           return valor;
    }
}
