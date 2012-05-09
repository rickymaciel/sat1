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
import negocios.Producto;

/**
 *
 * @author marcelo
 */
public class ProductosSql extends DataManagerAlumnos
{

    public ProductosSql() {
    }
    
    public int guardarProducto(Producto producto)
    {
        Statement stmt = null;
        Connection conn = null;
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO productos_aplicables (productos_id, denominacion, precio) "
                    + "VALUES ("+producto.getIdproducto()+" , '"+producto.getDenominacion()+"' , "+producto.getPrecio()+")");  
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
    
    public Collection<Producto> getAll()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT productos_id, denominacion, precio FROM productos_aplicables ");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection<Producto> productos = new ArrayList<Producto>();
        try
        {
            while (resu.next())
            {
                Producto p = new Producto();
                p.setIdproducto(resu.getInt(1));
                p.setDenominacion(resu.getString(2));
                p.setPrecio(resu.getDouble(3));
                productos.add(p);
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
        return productos;        
    }
    
    public Producto getProducto(int id)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT productos_id, denominacion, precio FROM productos_aplicables "
                    + "WHERE productos_id = '"+id+"'");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Producto producto = new Producto();
        try
        {
            while (resu.next())
            {
                producto.setIdproducto(resu.getInt(1));
                producto.setDenominacion(resu.getString(2));
                producto.setPrecio(resu.getDouble(3));
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
        return producto;        
    }
    
}
