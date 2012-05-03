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
//import java.util.Iterator;
import dominio.Cuota;
import dominio.Pago;

/**
 *
 * @author marcelo
 */
public class CuotasSql extends DataManagerAlumnos 
{

    public CuotasSql() {
    }
    
    
    public Collection<Cuota> getCuotasAlumnoInscripcion(long idAlumno, long idInscripcion)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT cuotas_id, periodo, alumnos_id, inscripciones_id, monto, pagado, facturas_serie, facturas_numero, cuota FROM cuotas "
                    + "where pagado = false "
                    + "AND alumnos_id = '"+idAlumno+"' "
                    + "AND inscripciones_id = '"+idInscripcion+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection<Cuota> co = new ArrayList<Cuota>();   
        try
        {
            while (resu.next())
            {
                Cuota c = new Cuota();
                c.setId(resu.getLong(1));
                c.setPeriodo(resu.getTimestamp(2));
                c.setIdAlumno(resu.getLong(3));
                c.setInscripcion(resu.getLong(4));
                c.setMonto(resu.getDouble(5));
                c.setPagado(resu.getBoolean(6));
                c.setSerieFactura(resu.getInt(7));
                c.setNumeroFactura(resu.getLong(8));
                c.setCuota(resu.getBoolean(9));
                c.setPago(this.getPago(c.getId()));
                co.add(c);
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
    
    public int modificarCuota(Cuota cuota)
    {
        Statement stmt = null;
        Connection conn = null;
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("UPDATE cuotas "
                    + "SET monto = '"+cuota.getMonto()+"' , pagado = '"+cuota.isPagado()+"', facturas_serie = '"+cuota.getSerieFactura()+"', facturas_numero = '"+cuota.getNumeroFactura()+"')");
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
        try
        {
          stmt.close();
          conn.close();
        } 
        catch(SQLException e)
        {
          while (e != null)
          {
             e.printStackTrace();
             e = e.getNextException();
          }         
        }  
     }
        return registrosInsertados;
    } 
    
    
    private Pago getPago(long idCuota)
    {
        PagosSql p = new PagosSql();
        return p.gePagosAlumno(idCuota);
    }
    
}
