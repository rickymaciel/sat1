/*
 * DataManager.java
 *
 * Created on 30 de julio de 2007, 10:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

import java.sql.*;
import java.io.*;
import javax.swing.JOptionPane;

/** Esta clase es la responsable de establecer la conexion con la base de datos y brindar
 * el statemen para poder interactuar con ella.
 *
 * @author Administrador
 */

public class DataManager 
{
    private String driver;
    private Connection conn;
    public Statement st;
    private String dsn = "";
    
  /** getConection() devuelve la conexion a la base de datos
 */
public void defDriver()
{
    //Defino el tipo de driver con el nombre y nada mas
    this.driver= "org.postgresql.Driver";
}
    
 public Connection  getConection()
 {
    defDriver();
//    dsn = "jdbc:postgresql://192.168.1.3:5432/sat1?";
    
//    dsn = "jdbc:postgresql://192.168.81.100:5432/sat2?";
//    dsn = "jdbc:postgresql://127.0.0.1:5432/satCTJ15sept?";
    dsn = "jdbc:postgresql://127.0.0.1:5432/colegio?";
    try
    {
      /** creo la conexion para el caso de usar una base de datos Postgres */
        Class.forName(driver);
//      conn = DriverManager.getConnection(dsn+"user=postgres&password=jorge1515");
      conn = DriverManager.getConnection(dsn+"user=postgres&password=postgres");
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de Datos","Error de Conexión...",JOptionPane.WARNING_MESSAGE);
//        System.out.println("Error conexion");
//        System.out.println("dentro del catch "+ex.getMessage());
    }
    return conn;
 }
 
 
 /*
 public  Connection getConection(String conexion)
 { 
     //Connection conection;   
        String driver="com.hxtt.sql.access.AccessDriver";                     // defino el Driver
        String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
        File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());    
        String rutaReporte=obtenerRutaArriba(3,sourceFile1);
        rutaReporte=rutaReporte+"\\bd\\mikonos.mdb";
        String url="jdbc:access:/"+rutaReporte;   // y su URL o ruta    
        String username="";   // el nombre de usuario y el password los dejo en blanco
        String password="";
        try
        {
            Class.forName(driver);  //Registrar Driver
            
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        try
        {
            conection = DriverManager.getConnection(url, username, password); //Establecer conexion
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } //Establecer conexion
        return conection;
    
 }*/
 
 /*
 public  Connection getConection()
 { 
     //Connection conection;   
     String driver="com.hxtt.sql.access.AccessDriver";                     // defino el Driver
        URL rutaURL = this.getClass().getResource("/db/mikonos.mdb");
        System.out.println("Path: "+rutaURL.getPath());
        String url="jdbc:access:"+rutaURL.getPath();   // y su URL o ruta    
        String username="";   // el nombre de usuario y el password los dejo en blanco
        String password="";
        try
        {
            Class.forName(driver);  //Registrar Driver
            
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        try
        {
            conection = DriverManager.getConnection(url, username, password); //Establecer conexion
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } //Establecer conexion
        return conection;
    
 }*/
 
 
 
/** getStat(Connection co) devuelve el statement para poder empezar a ejecutar
 * sentencias SQL
 */
 public Statement getStat(Connection co)
 {
   try
    {
      // creo el Statement
      Statement stmt = co.createStatement();
      st = stmt;
    }
  catch (SQLException sqle)
  {
    sqle.printStackTrace();
  }
   return st;
 }
 
 
 public String obtenerRutaArriba(int nivel,File fileConRutaInicial){              
       File rutaActual=fileConRutaInicial;
       for (int i=1;i<nivel;i++){
            rutaActual=new File(rutaActual.getParent());
       }       
       String ruta=rutaActual.getPath().replaceAll("file:","");
       ruta=ruta.replaceAll("%20"," ");
       return ruta;
  }
    
}
