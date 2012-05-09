/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominio.DetallePago;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dominio.Pago;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author marcelo
 */
public class PagosSql extends DataManagerAlumnos
{

    public PagosSql() {
    }
    
    public Collection<Pago> getPagosAlumno(long idCuota)
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT pagos_id, fecha, monto, cuotas_id, facturas_serie, facturas_numero FROM encabezado_pagos "
                    + "WHERE cuotas_id = '"+idCuota+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection<Pago> pagos = new ArrayList<Pago>();
        DetallePagoSql sql = new DetallePagoSql();
        try
        {
            while (resul.next())
            {
                Pago p = new Pago();
                p.setIdPago(resul.getLong(1));
                p.setFecha(resul.getDate(2));
                p.setMonto(resul.getDouble(3));
                p.setIdCuota(resul.getLong(4));
                p.setSerFactura(resul.getInt(5));
                p.setNumeroFactura(resul.getLong(6));
                p.setDetalles(sql.getPagos(p.getIdPago()));
                pagos.add(p);
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
        return pagos;
    }
    
    public Pago getPagosAlumno(long idCuota, String algo)
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT monto FROM encabezado_pagos "
                    + "WHERE cuotas_id = '"+idCuota+"'"); 
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
                monto += resul.getDouble(1);
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
    
    public Collection<Pago> getPagosAFacturar()
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT pagos_id, fecha, monto, cuotas_id, facturas_serie, facturas_numero FROM encabezado_pagos "
                    + "WHERE facturas_serie = '0' "
                    + "AND facturas_numero = '0'"); 
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
        Collection<Pago> pagos = new ArrayList<Pago>();
        DetallePagoSql sql = new DetallePagoSql();
        try
        {
            while (resul.next())
            {
                Pago p = new Pago();
                p.setIdPago(resul.getLong(1));
                p.setFecha(resul.getDate(2));
                p.setMonto(resul.getDouble(3));
                p.setIdCuota(resul.getLong(4));
                p.setSerFactura(resul.getInt(5));
                p.setNumeroFactura(resul.getLong(6));
                p.setDetalles(sql.getPagos(p.getIdPago()));
                pagos.add(p);
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
        return pagos;
    }
    
    private long getUltimoId()
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT pagos_id FROM encabezado_pagos "
                    + "ORDER BY pagos_id DESC LIMIT 1"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        long ultimo = 0;
        try
        {
            while (resul.next())
            {
                ultimo =resul.getLong(1);
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
        return ultimo;
    }
    
    public void guardarPago(Pago pago)
    {
        Statement stmt = null;
        Connection conn = null;
        long registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO encabezado_pagos (fecha, monto, cuotas_id, facturas_serie, facturas_numero) "
                    + "VALUES ('"+pago.getFecha()+"' ,'"+pago.getMonto()+"' , '"+pago.getIdCuota()+"','"+pago.getSerFactura()+"','"+pago.getNumeroFactura()+"') ");
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
        if(registrosInsertados != 0)
        {
            pago.setIdCuota(registrosInsertados);
            this.guardarDetalles(pago);
        }
//        return registrosInsertados;
    } 
    
    private void guardarDetalles(Pago p)
    {
        DetallePagoSql sql = new DetallePagoSql();
        long idPago = this.getUltimoId();
        
        if(!p.getDetalles().isEmpty())
        {
            Iterator<DetallePago> it = p.getDetalles().iterator();
            while(it.hasNext())
            {
                DetallePago d = it.next();
                d.setIdPago(idPago);
                sql.guardarDetalle(d);
            }
        }
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
            registrosInsertados = stmt.executeUpdate("UPDATE encabezado_pagos "
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
