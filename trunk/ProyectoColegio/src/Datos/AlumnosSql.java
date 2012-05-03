/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import dominio.Alumno;

/**
 *
 * @author marcelo
 */
public class AlumnosSql extends DataManagerAlumnos
{

    public AlumnosSql() {
    }
    
    
    public Alumno getAlumno(long dni)
    {
        Alumno a = null;
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT alumnos_id, legajo, apellido, nombre, dni, telefono_fijo, telefono_celular, email FROM alumnos WHERE activo = true AND dni = '"+dni+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        try
        {
            while(resu.next())
            {
                a = new Alumno();
                a.setId(resu.getLong(1));
                a.setLegajo(resu.getLong(2));
                a.setApellido(resu.getString(3));
                a.setNombres(resu.getString(4));
                a.setDni(resu.getString(5));
                a.setTelefonoFijo(resu.getString(6));
                a.setTelefonoCelular(resu.getString(7));
                a.setEmail(resu.getString(8));
            }
        }
        catch(SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        try
        {
          resu.close();
          stmte.close();
          conne.close();
        } 
        catch(SQLException e)
        {
          while (e != null)
          {
             e.printStackTrace();
             e = e.getNextException();
          }         
        }      
        return a;
    }
    
    public Alumno getAlumno(long codigo, String algo)
    {
        Alumno a = null;
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT alumnos_id, legajo, apellido, nombre, dni, telefono_fijo, telefono_celular, email FROM alumnos WHERE activo = true AND alumnos_id = '"+codigo+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        try
        {
            while(resu.next())
            {
                a = new Alumno();
                a.setId(resu.getLong(1));
                a.setLegajo(resu.getLong(2));
                a.setApellido(resu.getString(3));
                a.setNombres(resu.getString(4));
                a.setDni(resu.getString(5));
                a.setTelefonoFijo(resu.getString(6));
                a.setTelefonoCelular(resu.getString(7));
                a.setEmail(resu.getString(8));
            }
        }
        catch(SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        try
        {
          resu.close();
          stmte.close();
          conne.close();
        } 
        catch(SQLException e)
        {
          while (e != null)
          {
             e.printStackTrace();
             e = e.getNextException();
          }         
        }      
        return a;
    }
    
    
    
    public Iterator<Alumno> getAll()
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT alumnos_id, legajo, apellido, nombre, dni, telefono_fijo, telefono_celular, email FROM alumnos"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection<Alumno> co = new ArrayList<Alumno>();  
        try
        {
            while (resul.next())
            {
                Alumno a = new Alumno();
                a.setId(resul.getLong(1));
                a.setLegajo(resul.getLong(2));
                a.setApellido(resul.getString(3));
                a.setNombres(resul.getString(4));
                a.setDni(resul.getString(5));
                a.setTelefonoFijo(resul.getString(6));
                a.setTelefonoCelular(resul.getString(7));
                a.setEmail(resul.getString(8));
                co.add(a);
             }
        }
        catch(SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        try{
          resul.close();
          stmte.close();
          connec.close();
        } catch(SQLException e){
          while (e != null){
             e.printStackTrace();
             e = e.getNextException();
          }         
        }      
        return co.iterator();
    }
    
}
