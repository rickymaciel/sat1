/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominio.Carrera;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author marcelo
 */
public class CarrerasSql extends DataManagerAlumnos
{

    public CarrerasSql() {
    }
    
    
    public Carrera getCarrera(int id)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        Carrera carrera = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT carreras_id, nombre, cursos FROM carreras"); 
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
                carrera = new Carrera();
                carrera.setId(resu.getInt(1));
                carrera.setNombre(resu.getString(2));
                carrera.setCursos(resu.getInt(3));
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
        return carrera;
    }
    
//    /**
//     * A traves de este metodo recolecto las carreras en las que esta inscripto un alumno
//     * @param idAlumno
//     * @return 
//     */
//    public Iterator<Carrera> getCarrerasAlumno(long idAlumno)
//    {
//        ResultSet resu = null;
//        Statement stmte = null;
//        Connection conne = null;
//        Carrera carrera = null;
//        try 
//        { 
//            conne = super.getConection();      
//            stmte = conne.createStatement();  
//            resu = stmte.executeQuery("SELECT c.carreras_id, c.nombre, c.cursos from carreras AS c "
//                    + "WHERE c.carreras_id in (SELECT i.carreras_id "
//                    + "FROM inscripciones AS i WHERE i.alumnos_id = '"+idAlumno+"')"); 
//        }
//        catch (SQLException ex)
//        {
//            while (ex !=null)
//            {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } 
//        Collection<Carrera> co = new ArrayList<Carrera>();
//        int cont = 1;
//        try
//        {
//            while(resu.next())
//            {
//                carrera = new Carrera();
//                carrera.setId(resu.getInt(1));
//                carrera.setNombre(resu.getString(2));
//                carrera.setCursos(resu.getInt(3));
//                System.out.println("guardando "+cont);
//                cont++;
//                co.add(carrera);
//            }
//        }
//        catch(SQLException ex)
//        {
//            while (ex !=null)
//            {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        }
//        try
//        {
//          resu.close();
//          stmte.close();
//          conne.close();
//        } 
//        catch(SQLException e)
//        {
//          while (e != null)
//          {
//             e.printStackTrace();
//             e = e.getNextException();
//          }         
//        }      
//        return co.iterator();
//    }
    
    /**
     * A traves de este metodo recolecto las carreras en las que esta inscripto un alumno
     * @param idAlumno
     * @return 
     */
    public Collection<Carrera> getCarrerasAlumno(long idAlumno)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        Carrera carrera = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT c.carreras_id, c.nombre, c.cursos from carreras AS c "
                    + "WHERE c.carreras_id in (SELECT i.carreras_id "
                    + "FROM inscripciones AS i WHERE i.alumnos_id = '"+idAlumno+"')"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection<Carrera> co = new ArrayList<Carrera>();
        int cont = 1;
        try
        {
            while(resu.next())
            {
                carrera = new Carrera();
                carrera.setId(resu.getInt(1));
                carrera.setNombre(resu.getString(2));
                carrera.setCursos(resu.getInt(3));
                System.out.println("guardando "+cont);
                cont++;
                co.add(carrera);
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
        return co;
    }
    
}
