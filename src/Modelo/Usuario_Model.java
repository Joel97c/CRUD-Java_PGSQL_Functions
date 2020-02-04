/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author home
 */
public class Usuario_Model {
    private Integer id;
    private String Usuario;
    private String Clave;
    private boolean Estado;
    Conexion db=new Conexion();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public boolean isActivo() {
        return Estado;
    }

    public void setActivo(boolean Activo) {
        this.Estado = Activo;
    }
    
 public int BuscarUsuario(String usuario) throws Exception {
    int valor=0;
     if (db.Conectar()==1) {
            String Query = "SELECT * FROM usuarios where usuario='"+usuario+"'" ;
            System.out.println("el SQL en Usuario es "+Query);          
            ResultSet resultado=db.EjecutarSQL(Query);
          // JOptionPane.showMessageDialog(null, "consulta ejecutadas es "+ Query);          
           if (resultado.next()) {
                System.out.println("Login: " + resultado.getString("usuario") + " " + "clave: " + resultado.getString("clave"));
                this.id=resultado.getInt("id_usuario");
                this.Usuario=resultado.getString("usuario");
                this.Clave=resultado.getString("clave");
                this.Estado=resultado.getBoolean("estado");               
                valor= 1;
            }else {
               valor= 0;
          
           }
            db.desconectar();
           }
            else {  }
           return valor;
    }
    
     public int GuardarUsuario(String usuario,String clave) throws Exception {
    int valor=0;
     if (db.Conectar()==1) {
         String Query="insert into usuarios (usuario,clave,estado) values ('"+usuario+"','"
              +clave+"',true)";
          //  String Query = "SELECT * FROM usuarios where usuario='"+usuario+"'" ;
            System.out.println("el SQL para Guardar en Usuario es "+Query);          
           // ResultSet resultado=db.EjecutarSQL(Query);
          // JOptionPane.showMessageDialog(null, "consulta ejecutadas es "+ Query);          
            if(db.ejecutar(Query)){                              
                valor= 1;
            }else {
               valor= 0;
          
           }
            db.desconectar();
           }
            else {  }
           return valor;
    }
    
     
     public int ModificarUsuario(String usuario,String clave,boolean estado,String id) throws Exception {
    int valor=0;
     if (db.Conectar()==1) {
         String Query="update usuarios set usuario='"+usuario+"',clave='"+clave+"',estado="+estado+" where id_usuario="+id;
           //String Query = "SELECT * FROM usuarios where usuario='"+usuario+"'" ;
            System.out.println("el SQL para Modificar en Usuario es "+Query);          
            ResultSet resultado=db.EjecutarSQL(Query);
          // JOptionPane.showMessageDialog(null, "consulta ejecutadas es "+ Query);          
           if(db.ejecutar(Query)){                              
                valor= 1;
            }else {
               valor= 0;
          
           }
            db.desconectar();
           }
            else {  }
           return valor;
    }
    
   public int EliminarUsuario(String id) throws Exception {
    int valor=0;
     if (db.Conectar()==1) {
         String Query="delete from usuarios where id_usuario="+id;
           //  String Query = "SELECT * FROM usuarios where usuario='"+usuario+"'" ;
            System.out.println("el SQL para Eliminar en Usuario es "+Query);          
            ResultSet resultado=db.EjecutarSQL(Query);
          // JOptionPane.showMessageDialog(null, "consulta ejecutadas es "+ Query);          
           if(db.ejecutar(Query)){                              
                valor= 1;
            }else {
               valor= 0;
          
           }
            db.desconectar();
           }
            else {  }
           return valor;
    } 
}
