/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominio.Alumno;
import dominio.Carrera;
import dominio.Inscripcion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author marcelo
 */
public class InscripcionesSql extends DataManagerAlumnos
{

    public InscripcionesSql() {
    }
    
//    public Iterator<Inscripcion> getInscrpciones(long idAlumno)
//    {
//        ResultSet resu = null;
//        Statement stmte = null;
//        Connection conne = null;
//        try 
//        { 
//            conne = super.getConection();      
//            stmte = conne.createStatement();  
//            resu = stmte.executeQuery("SELECT inscripciones_id, alumnos_id, carreras_id FROM inscripciones "
//                    + "where alumnos_id = '"+idAlumno+"' "
//                    + "GROUP BY carreras_id"); 
//        }
//        catch (SQLException ex)
//        {
//            while (ex !=null)
//            {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } 
//        Collection<Inscripcion> co = new ArrayList<Inscripcion>();   
//        try
//        {
//            while (resu.next())
//            {
//                Inscripcion i = new Inscripcion();
//                i.setId(resu.getInt(1));
//                i.setAlumno(this.getAlumno(resu.getLong(2)));
//                i.setCarrera(this.getCarrera(resu.getInt(3)));
//                co.add(i);
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
//        try{
//          resu.close();
//          stmte.close();
//          conne.close();
//        } catch(SQLException e){
//          while (e != null){
//             e.printStackTrace();
//             e = e.getNextException();
//          }         
//        }      
//        return co.iterator();        
//    }
    
    public Collection<Inscripcion> getCursos(int idCarrera, long idAlumno)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT curso, fecha, inscripciones_id, alumnos_id, carreras_id FROM inscripciones "
                    + "WHERE carreras_id = '"+idCarrera+"' "
                    + "AND alumnos_id = '"+idAlumno+"' "
                    + "ORDER BY fecha desc"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection<Inscripcion> co = new ArrayList<Inscripcion>();   
        try
        {
            while (resu.next())
            {
                Inscripcion i = new Inscripcion();
                i.setCurso(resu.getInt(1));
                Calendar anio = Calendar.getInstance();
                Date d = resu.getDate(2);
                anio.setTime(d);
                i.setAnio(anio.get(Calendar.YEAR));
                i.setId(resu.getInt(3));
                i.setAlumno(this.getAlumno(resu.getLong(4)));
                i.setCarrera(this.getCarrera(resu.getInt(5)));
                co.add(i);
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
          resu.close();
          stmte.close();
          conne.close();
        } catch(SQLException e){
          while (e != null){
             e.printStackTrace();
             e = e.getNextException();
          }         
        }      
        return co;        
    }
    
    private Alumno getAlumno(long id)
    {
        AlumnosSql a = new AlumnosSql();
        return a.getAlumno(id, null);
    }
    
    private Carrera getCarrera(int id)
    {
        CarrerasSql c = new CarrerasSql();
        return c.getCarrera(id);
    }
    
}
