/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
//importamos todas las clases del paquete SQL
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//Importamos la Clase JOptionPane para emitir mensajes con Swing
import javax.swing.JOptionPane;

/**
 *
 * @author ITSY
 * Esta clase contiene todos los métodos relacionados al manejo de la base de datos 
 * y la conexión con el servidor*/

public class Conexion {
    //1. creamos una vaiable global,
    //La clese Connection se encuentra dentro del paquete java.sql.Connection, por lo que se debe importar
    private static Connection Conexion;
     private  Statement sentencia;
    
    //"postgres","123","POO_usuario"
     //Parametros de Configuración
// private final String Servidor="localhost";
 //private final String Puerto="3306";//3306
 private final String db_name="POO_usuario";//
 private final String user="postgres";//
 private final String pass="12345";//
 //private final String URL="jdbc:mysql://"+Servidor+":"+Puerto+"/"+BD;//
     
     
     
     
     
    //2. Este método permite iniciar una conexión con el servidor Conexion
    // REcibe por paramentros:
    //user:Nombre del Usuario
    //pass:contraseña de la base de Datos
    //db_name:Nombre de la Base de DAto
   
    public void MySQLConnection(String user, String pass, String db_name) throws Exception {
        try {
            //Cargamos el Driver, previmente se debe agregar al programa Libraries/MySQL ODBC
            Class.forName("com.mysql.jdbc.Driver");
            /*
            Una vez cargado el driver es necesario crear un objeto del tipo Connection, para administrar la conexión. 
            Una aplicación puede utilizar DriverManager para obtener un objeto de tipo conexión,
            Connection, con una base de datos. 
            La conexión se especifica siguiendo una sintaxis basada en la especificación más amplia de los URL, 
            de la forma:jdbc:subprotocolo//servidor:puerto/base de datos             
            */
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            
            if (Conexion != null)
         {
                        JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa Nombre de la Base de Dato: "+db_name+" Usuario "+user+" Clave "+pass);
            
         }else {JOptionPane.showMessageDialog(null, "Error en Conexion");}
            
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public int  Conectar(/*String user, String pass, String db_name*/) throws Exception {
           //Cargamos el Driver, previmente se debe agregar al programa Libraries/MySQL ODBC
            Class.forName("org.postgresql.Driver");
            /*
            Una vez cargado el driver es necesario crear un objeto del tipo Connection, para administrar la conexión. 
            Una aplicación puede utilizar DriverManager para obtener un objeto de tipo conexión,
            Connection, con una base de datos. 
            La conexión se especifica siguiendo una sintaxis basada en la especificación más amplia de los URL, 
            de la forma:jdbc:subprotocolo//servidor:puerto/base de datos             
            */
            Conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + db_name, user, pass);
            
            if (Conexion != null)
         { 
                 //       JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa Nombre de la Base de Dato: "+db_name+" Usuario "+user+" Clave "+pass);
            return 1;
         }else {
              
                //JOptionPane.showMessageDialog(null, "Error en Conexion");
            return 0;
          
           }
 }
  public void desconectar() throws SQLException {                  
            if(Conexion!=null){
                 Conexion.close();
             //    JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
                 Conexion=null;
            }else{
            JOptionPane.showMessageDialog(null, "no se puede cerrar una conexion que no ha sido iniciada");
            }
       
    } 

  public boolean ejecutar(String SQL){
    boolean estado=false;
     try {
         sentencia=Conexion.createStatement();
         sentencia.execute(SQL);
         sentencia.close();
         estado=true;
     } catch (SQLException ex) {
         System.err.println("Error: ConetorBD.ejecutar(SQL) "+SQL);
     }
    
return estado;
}
 
 public ResultSet EjecutarSQL(String sql){
 ResultSet resultado=null;

     try {
         sentencia= Conexion.createStatement();
         resultado=sentencia.executeQuery(sql);
     } catch (SQLException ex) {
         System.err.println("Error: ConetorBD.Seleccionar(SQL) "+sql);
         System.err.println("Error: "+ex.getMessage());
         Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
     } 
 return resultado;
 } 
 
 
 
  /********************************************************************************************
    
    Este método permite cerrar la conexion
    *********************************************************************************************/
     public void closeConnection() {
        try {
             if (Conexion != null)
         {
            Conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
         }else{
             JOptionPane.showMessageDialog(null, "Debe iniciar una conexion");
             }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
     /********************************************************************************************
    
   Método que permite crear una Base de DAtos, y recibe por parametro el nombre de la Base de Datos     /********************************************************************************************
    
   Método que permite crear una Base de DAtos, y recibe por parametro el nombre de la Base de Datos     /********************************************************************************************
    
   Método que permite crear una Base de DAtos, y recibe por parametro el nombre de la Base de Datos     /********************************************************************************************
    
   Método que permite crear una Base de DAtos, y recibe por parametro el nombre de la Base de Datos
    *********************************************************************************************/

    public void createDB(String name) throws Exception {
        try {
            //se crea la sentencia que nos permite crear una Base de Datos
            String Query = "CREATE DATABASE " + name;
             // Se crea un objeto de tipo Statement, para realizar la consulta
            Statement st = Conexion.createStatement();
            //ejecuta la sentencia
            st.executeUpdate(Query);
            closeConnection();
            MySQLConnection("root", "", name);
JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  /********************************************************************************************
    
   Método que permite crear tablas a la Base de DAtos, y recibe por parametro el nombre de la Base de Datos
    *********************************************************************************************/
   
public void createTable(String name) {
        try {
            String Query = "CREATE TABLE " + name + ""
                    + "(ID VARCHAR(25),Nombre VARCHAR(50), Apellido VARCHAR(50),"
                    + " Edad VARCHAR(3), Sexo VARCHAR(1))"; 
 // Se crea un Statement, para realizar la consulta
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
JOptionPane.showMessageDialog(null, "Se ha creado la tabla " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/********************************************************************************************
    
   Método que permite ingresar datos a la tabla
    *********************************************************************************************/

public void insertData(String table_name, int ID, String name, String lastname, String categoria, int dpt) {
        try {
            /*INSERT INTO `empleado` (`id_Empleado`, `Nombre`, `Apellido`, `Categoria`, `id_dpartamento`) VALUES ('1', 'yyy', 'hhh', 'eeee', '1');*/
            String Query = "INSERT INTO " + table_name + " VALUES("+ ID + ",'"+name + "','"+ lastname + "','"+ categoria +"',"+ dpt+ ")";
            System.out.println("SQL: "+Query);
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
/********************************************************************************************
    
   Método que retorna los valores
    *********************************************************************************************/


public void getValues(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID") + " "
                        + "Nombre: " + resultSet.getString("Nombre") + " " + resultSet.getString("Apellido") + " "
                        + "Edad: " + resultSet.getString("Edad") + " "
                        + "Sexo: " + resultSet.getString("Sexo"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }

/********************************************************************************************
    
   Método para borrar registros
    *********************************************************************************************/

public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }

}