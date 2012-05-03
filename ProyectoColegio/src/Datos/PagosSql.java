/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dominio.Pago;

/**
 *
 * @author marcelo
 */
public class PagosSql extends DataManagerAlumnos
{

    public PagosSql() {
    }
    
    public Pago gePagosAlumno(long idCuota)
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT monto FROM pagos WHERE cuotas_id = '"+idCuota+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        double monto = 0.0;
        try
        {
            while (resul.next())
            {
                monto+= resul.getDouble(1);
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
        Pago p = new Pago();
        p.setMonto(monto);
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
        return p;
    }
    
    public int guardarPago(Pago pago)
    {
        Statement stmt = null;
        Connection conn = null;
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO pagos (fecha, monto, cuotas_id, facturas_serie, facturas_numero) "
                    + "VALUES ('"+pago.getFecha()+"' ,'"+pago.getMonto()+"' , '"+pago.getIdCuota()+"','"+pago.getSerFactura()+"','"+pago.getNumeroFactura()+"')");  
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
    
    public int modificarPago(Pago pago)
    {
        Statement stmt = null;
        Connection conn = null;
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("UPDATE pagos "
                    + "SET fecha = '"+pago.getFecha()+"', monto = '"+pago.getMonto()+"' , cuotas_id = '"+pago.getIdCuota()+"', facturas_serie = '"+pago.getSerFactura()+"', facturas_numero = '"+pago.getNumeroFactura()+"')");
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
    
    
    
}
