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
import java.util.ArrayList;
import java.util.Collection;
import negocios.Producto;

/**
 *
 * @author marcelo
 */
public class DetallePagoSql extends DataManagerAlumnos
{

    public DetallePagoSql() {
    }
    
    public Collection<DetallePago> getPagos(long idPago)
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT encabezado_id, detalles_id, productos_id FROM detalle_pagos "
                    + "WHERE encabezado_id = "+idPago); 
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
        Collection<DetallePago> detalles = new ArrayList<DetallePago>();
        try
        {
            while (resul.next())
            {
                DetallePago d = new DetallePago();
                d.setIdPago(resul.getLong(1));
                d.setIdDetalle(resul.getLong(2));
                d.setProducto(this.getProducto(resul.getInt(3)));
                detalles.add(d);
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
        return detalles;
    }
    
    public int guardarDetalle(DetallePago pago)
    {
        Statement stmt = null;
        Connection conn = null;
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            System.out.println("INSERT INTO detalle_pagos (productos_id, encabezado_id) "
                    + "VALUES ("+pago.getProducto().getIdproducto()+" ,"+pago.getIdPago()+")");  
            
            registrosInsertados = stmt.executeUpdate("INSERT INTO detalle_pagos (productos_id, encabezado_id) "
                    + "VALUES ("+pago.getProducto().getIdproducto()+" ,"+pago.getIdPago()+")");  
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
    
    
    private Producto getProducto(int id)
    {
        ProductosSql sql = new ProductosSql();
        return sql.getProducto(id);
    }
    
}
