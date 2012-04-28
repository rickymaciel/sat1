/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

/**
 *
 * @author Administrador
 */
import java.sql.*;
//import java.text.ParseException;
import java.util.*;
import javax.swing.JOptionPane;
import negocios.Barrio;
import negocios.Caja;
import negocios.CondicionVenta;
import negocios.Configuracion;
import negocios.ConstanciaHabilitacion;
import negocios.Departamento;
import negocios.DetalleCP;
import negocios.DetalleCT;
import negocios.DetallePago;
import negocios.Documento;
import negocios.Empresa;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.EncabezadoDetallePago;
import negocios.EncabezadoFactura;
import negocios.EncabezadoPago;
import negocios.EntidadExterna;
import negocios.Escuela;
import negocios.Iva;
import negocios.Localidad;
import negocios.Matriculado;
import negocios.Nacionalidad;
import negocios.PlanoCTotal;
import negocios.PlanoTasa;
import negocios.Producto;
import negocios.Provincia;
import negocios.PuntodeVenta;
import negocios.Rol;
import negocios.SerieConstancia;
import negocios.SerieFactura;
import negocios.Tasa;
import negocios.TasaAplicable;
import negocios.TasaSeleccionada;
import negocios.TipoSeccion;
import negocios.TipoSuperficie;
import negocios.TipoTrabajo;
import negocios.Titulo;
import negocios.Usuario;
import java.util.Date;
import negocios.DetalleFactura;

public class Consulta extends DataManager{
    
    private ResultSet res = null;
    private Statement stmt = null;
    private Connection conn = null;
    
    public Consulta(){
        
    }
    
    public Collection getDocumento()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT iddocumento, descripcion, existe FROM documentos WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Documento doc = new Documento();
                doc.setIdDocumento(resu.getInt(1));
                doc.setDescripcion(resu.getString(2));
                doc.setExiste(resu.getString(3));
                co.add(doc);
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
    
     public Collection getDocumento(String algo)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT iddocumento, descripcion, existe FROM documentos"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Documento doc = new Documento();
                doc.setIdDocumento(resu.getInt(1));
                doc.setDescripcion(resu.getString(2));
                doc.setExiste(resu.getString(3));
                co.add(doc);
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
    
    public Collection getTasaAplicable()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtasaaplicable, idtasa, idtipoconstancia, existe FROM tasasaplicables"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TasaAplicable tasaA = new TasaAplicable();
                tasaA.setIdTasaAplicable(resu.getInt(1));
                tasaA.setIdtasa(resu.getInt(2));
                tasaA.setIdTipoConstancia(resu.getInt(3));
                tasaA.setExiste(resu.getString(4));
                co.add(tasaA);
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
    
    public Collection getTasaAplicablexConstancia(int tipocons)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtasaaplicable, idtasa, idtipoconstancia, existe FROM tasasaplicables WHERE idtipoconstancia = "+tipocons); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TasaAplicable tasaA = new TasaAplicable();
                tasaA.setIdTasaAplicable(resu.getInt(1));
                tasaA.setIdtasa(resu.getInt(2));
                tasaA.setIdTipoConstancia(resu.getInt(3));
                tasaA.setExiste(resu.getString(4));
                co.add(tasaA);
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
    public Long getEncabezadoFactxSerie(int serieFactura)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
       try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT (max(numerofactura)+1) as ultimafactura FROM encabezadofacturas where seriefactura = "+serieFactura); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
       long resultado = 0;   
        try
        {
            resu.next();
            if (resu.getInt(1)==0){ //si es una nueva serie y nohay facturas entonces
                resultado=1;
            }else{
                resultado = resu.getLong(1);
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
        return resultado;        
    }
    
     public Collection getEncabezadoPago(EncabezadoPago encpago)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
       try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM enc_pago where idmatriculado = "+encpago.getIdmatriculado()); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        Collection co = new ArrayList();
       try
        {
           while (resu.next())
           {
                EncabezadoPago encp = new EncabezadoPago(); 
                encp.setIdencabezado(resu.getLong(1));
                encp.setIdmatriculado(resu.getLong(2));
                encp.setTotal(resu.getDouble(3));
                encp.setFechapago(resu.getDate(4));
                encp.setHabilitacionhasta(resu.getDate(5));
                encp.setSeriefactura(resu.getLong(6));
                encp.setNrofactura(resu.getLong(7));
                encp.setMatricula(resu.getLong(8));
                co.add(encp);
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
    
    public Collection getEncabezadoPago()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
       try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM enc_pago "); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        Collection co = new ArrayList();
       try
        {
           while (resu.next())
           {
                EncabezadoPago encp = new EncabezadoPago(); 
                encp.setIdencabezado(resu.getLong(1));
                encp.setIdmatriculado(resu.getLong(2));
                encp.setTotal(resu.getDouble(3));
                encp.setFechapago(resu.getDate(4));
                encp.setHabilitacionhasta(resu.getDate(5));
                encp.setSeriefactura(resu.getLong(6));
                encp.setNrofactura(resu.getLong(7));
                encp.setMatricula(resu.getLong(8));
                co.add(encp);
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
    
            public EncabezadoPago getEncabezadoPago(int matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        EncabezadoPago encp = new EncabezadoPago();
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("Select * from enc_pagoxmat('"+matricula+"')"); 
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
                resu.next();
                encp.setIdencabezado(resu.getLong(1));
                encp.setIdmatriculado(resu.getInt(2));
                encp.setTotal(resu.getDouble(3));
                encp.setFechapago(resu.getDate(4));
                encp.setHabilitacionhasta(resu.getDate(5));
                encp.setSeriefactura(resu.getLong(6));
                encp.setNrofactura(resu.getLong(7));
                encp.setMatricula(resu.getLong(8));
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
        return encp;        
    }
    
    public Collection getPlanoCTotal()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idplanoctotal, nombre, leyenda, existe FROM planosctotal"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                PlanoCTotal planoT = new PlanoCTotal();
                planoT.setIdplanoCTotal(resu.getInt(1));
                planoT.setNombre(resu.getString(2));
                planoT.setLeyenda(resu.getString(3));
                planoT.setExiste(resu.getString(4));
                co.add(planoT);
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
    
    public Collection getDetallePago()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM detalle_pago"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetallePago detp = new DetallePago();
                detp.setIdencabezadopago(resu.getLong(1));
                detp.setAnio(resu.getInt(2));
                detp.setMes(resu.getInt(3));
                detp.setImporte(resu.getDouble(4));
                detp.setIdproducto(resu.getLong(5));
                co.add(detp);
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
    public Collection getDetallePagoXMatricula(int matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select ep.idencabezadopago, ep.matricula, ep.fechapago, ep.seriefactura, ep.nrofactura,"
                +" dp.anio, dp.mes, dp.importe, dp.idproducto"
                +" from encabezadopago ep,detallepago dp"
                +" where ep.idencabezadopago=dp.idencabezadopago and ep.matricula = "+matricula
                +" and ep.seriefactura > 0 and ep.nrofactura > 0 order by dp.anio, dp.mes"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EncabezadoDetallePago encdetp = new EncabezadoDetallePago();
                encdetp.setIdencabezado(resu.getLong(1));
                encdetp.setMatricula(resu.getLong(2));
                encdetp.setFechapago(resu.getDate(3));
                encdetp.setSeriefactura(resu.getLong(4));
                encdetp.setNrofactura(resu.getLong(5));
                
                encdetp.setAnio(resu.getInt(6));
                encdetp.setMes(resu.getInt(7));
                encdetp.setImporte(resu.getDouble(8));
                encdetp.setIdproducto(resu.getLong(9));
                co.add(encdetp);
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
    public Collection getDetallePago(long idencabezado,int anio)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM det_pago2('"+idencabezado+"','"+anio+"')"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetallePago detp = new DetallePago();
                detp.setIdencabezadopago(resu.getLong(1));
                detp.setAnio(resu.getInt(2));
                detp.setMes(resu.getInt(3));
                detp.setImporte(resu.getDouble(4));
                detp.setIdproducto(resu.getLong(5));
                co.add(detp);
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
    public Collection getDetallePago(long idencabezado)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            //resu = stmte.executeQuery("SELECT * FROM det_pago3('"+idencabezado+"')"); 
            resu = stmte.executeQuery("SELECT idencabezadopago, anio, mes, importe, idproducto FROM detallepago WHERE idencabezadopago = "+ idencabezado +" ORDER BY anio ,mes"); 
            
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetallePago detp = new DetallePago();
                detp.setIdencabezadopago(resu.getLong(1));
                detp.setAnio(resu.getInt(2));
                detp.setMes(resu.getInt(3));
                detp.setImporte(resu.getDouble(4));
                detp.setIdproducto(resu.getLong(5));
                co.add(detp);
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
    /**
     * 
     * @param origen variable que le informa al metodo si es que quiere devolver solo las tasas activas o todas las tasas, incluyendo las pasivas
     *          origen 0 -> devolver solo las activas
     *          origen 1 -> devolver todas, incluyendo las pasivas
     * @return
     */
    public Collection getPlanoTasa(int origen)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        String sql = "";
        if(origen == 0)
            sql = "SELECT idplanotasa, idplano, idtasa, existe FROM plano_tasa WHERE existe = 'S'";
        else
            sql = "SELECT idplanotasa, idplano, idtasa, existe FROM plano_tasa";
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            //resu = stmte.executeQuery("SELECT idplanotasa, idplano, idtasa, existe FROM plano_tasa WHERE existe = 'S'"); 
            resu = stmte.executeQuery(sql); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                PlanoTasa planoT = new PlanoTasa();
                planoT.setIdplanotasa(resu.getInt(1));
                planoT.setIdplano(resu.getInt(2));
                planoT.setIdtasa(resu.getInt(3));
                planoT.setExiste(resu.getString(4));
                co.add(planoT);
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
    
    public Collection getEncabezadoCP(String fechaI, String fechaF, int matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_cp2 WHERE matricula = '"+matricula+"' AND fecha BETWEEN '"+fechaI+"' AND '"+fechaF+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
               EncabezadoCP encCP = new EncabezadoCP();
               encCP.setSerieCP(resu.getString(1));
               encCP.setCodigoCP(resu.getLong(2));
               Provincia prov = new Provincia();
               prov.setIdprovincia(resu.getInt(3));
               prov.setNombre(resu.getString(4));
               encCP.setProvincia(prov);
               Departamento dep = new Departamento();
               dep.setIddepartamento(resu.getInt(5));
               dep.setNombre(resu.getString(6));
               encCP.setDepartamento(dep);
               Localidad loc = new Localidad();
               loc.setIdlocalidad(resu.getInt(7));
               loc.setNombre(resu.getString(8));
               encCP.setLocalidad(loc);
               Barrio barrio = new Barrio();
               barrio.setIdbarrio(resu.getInt(9));
               barrio.setNombre(resu.getString(10));
               encCP.setBarrrio(barrio);
               encCP.setCalle(resu.getString(11));
               encCP.setNumero(resu.getString(12));
               encCP.setManzana(resu.getString(13));
               encCP.setLote(resu.getString(14));
               encCP.setSerieFactura(resu.getInt(15));
               encCP.setNumeroFactura(resu.getLong(16));
               encCP.setDia(resu.getFloat(17));
               encCP.setMes(resu.getFloat(18));
               encCP.setAnio(resu.getFloat(19));
               encCP.setHora(resu.getFloat(20));
               encCP.setMinutos(resu.getFloat(21));
               encCP.setSegundos(resu.getFloat(22));
               encCP.setPropietario(resu.getString(23));
               encCP.setComitente(resu.getString(24));
               encCP.setAnulado(resu.getString(25));
               Usuario user = new  Usuario();
               user.setIdusuario(resu.getInt(26));
               user.setNombre(resu.getString(27));
               encCP.setUsuario(user);
               Matriculado mat = new Matriculado();
               mat.setIdmatriculado(resu.getInt(28));
               mat.setMatricula(resu.getInt(29));
               mat.setApellido(resu.getString(30));
               mat.setNombres(resu.getString(31));
               Titulo titulo = new Titulo();
               titulo.setIdtitulo(resu.getInt(32));
               titulo.setAbreviacion(resu.getString(33));
               encCP.setSuperficieRelevada(resu.getDouble(34));
               encCP.setSuperficieProyecto(resu.getDouble(35));
               encCP.setTotal(resu.getDouble(36));
               encCP.setOrdenTrabajo(resu.getString(37));
               encCP.setFecha(resu.getTimestamp(38));
               mat.setTitulo(titulo);
               encCP.setMatriculado(mat);
               
                co.add(encCP);
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

    
    public Collection getPlanoTasa()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idplanotasa, idplano, idtasa, existe FROM plano_tasa"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                PlanoTasa planoT = new PlanoTasa();
                planoT.setIdplanotasa(resu.getInt(1));
                planoT.setIdplano(resu.getInt(2));
                planoT.setIdtasa(resu.getInt(3));
                planoT.setExiste(resu.getString(4));
                co.add(planoT);
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

    public Collection getPuntodeventa()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idpuntodeventa, nombreusuarioapertura, tipofactura, numerofacturainicial, iniciofacturacion, limite, existe FROM puntodeventa"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                PuntodeVenta pdventa = new PuntodeVenta();
                pdventa.setIdpuntodeventa(resu.getInt(1));
                pdventa.setNombreusuarioapertura(resu.getString(2));
                pdventa.setTipofactura(resu.getString(3));
                pdventa.setNumerofacturainicial(resu.getLong(4));
                pdventa.setIniciofacturacion(resu.getString(5));
//                pdventa.setIdempresa(resu.getInt(6));
                pdventa.setLimite(resu.getLong(6));
                pdventa.setExiste(resu.getString(7));
                co.add(pdventa);
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
    
    public Collection getSerie()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idserie, serie, defecto, limite, tipoConstancia, activo, tipodecarga FROM series ORDER BY idserie"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                SerieConstancia serie = new SerieConstancia();
                serie.setIdserie(resu.getInt(1));
                serie.setSerie(resu.getString(2));
                serie.setDefecto(resu.getString(3));
                serie.setLimite(resu.getLong(4));
                serie.setTipoConstancia(resu.getString(5));
                serie.setActivo(resu.getString(6));
                serie.setTipoDeCarga(resu.getString(7));
                co.add(serie);
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

    
    public Collection getSerieActivas()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idserie, serie, defecto, limite, tipoConstancia, activo, tipodecarga FROM series WHERE activo = 'S' ORDER BY idserie"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                SerieConstancia serie = new SerieConstancia();
                serie.setIdserie(resu.getInt(1));
                serie.setSerie(resu.getString(2));
                serie.setDefecto(resu.getString(3));
                serie.setLimite(resu.getLong(4));
                serie.setTipoConstancia(resu.getString(5));
                serie.setActivo(resu.getString(6));
                serie.setTipoDeCarga(resu.getString(7));
                co.add(serie);
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
    public Collection getSerieActivasFacturas()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idserie, serie, defecto, limite, activo, tipodecarga FROM seriesfacturas WHERE activo = 'S' ORDER BY serie"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                SerieFactura serie = new SerieFactura();
                serie.setIdserie(resu.getInt(1));
                serie.setSerie(resu.getInt(2));
                serie.setDefecto(resu.getString(3));
                serie.setLimite(resu.getLong(4));
                serie.setActivo(resu.getString(5));
                serie.setTipoDeCarga(resu.getString(6));
                co.add(serie);
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
    public Collection getSerieFacturas()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idserie, serie, defecto, limite, activo, tipodecarga FROM seriesfacturas ORDER BY serie"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                SerieFactura serie = new SerieFactura();
                serie.setIdserie(resu.getInt(1));
                serie.setSerie(resu.getInt(2));
                serie.setDefecto(resu.getString(3));
                serie.setLimite(resu.getLong(4));
                serie.setActivo(resu.getString(5));
                serie.setTipoDeCarga(resu.getString(6));
                co.add(serie);
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
    public SerieConstancia getUnaSerie(String serie, String tipo)// Trae una serie de una cosntancia parcial o total
    {
        SerieConstancia se= new SerieConstancia();
        Collection co = new ArrayList();
        co = this.getSerieActivas();
        Iterator it = co.iterator();
        while(it.hasNext())
        {
            SerieConstancia s = (SerieConstancia)it.next();
            if(serie.equals(s.getSerie().trim()))
                if(tipo.equals(s.getTipoConstancia().trim()))
                    se = s;
        }
        return se;
    }
    public SerieFactura getUnaSerieFactura(int serieF)// Trae una serie de una Factura
    {
        SerieFactura se= new SerieFactura();
        Collection co = new ArrayList();
        co = this.getSerieActivasFacturas();
        Iterator it = co.iterator();
        while(it.hasNext()){
            SerieFactura s = (SerieFactura)it.next();
            if(serieF==s.getSerie())                
                    se = s;
        }
        return se;
    }
    
//    public Collection getEncabezadoCP()
//    {
//        ResultSet resu = null;
//        Statement stmte = null;
//        Connection conne = null;
//        try 
//        { 
//            conne = super.getConection();      
//            stmte = conne.createStatement();  
//            resu = stmte.executeQuery("SELECT * FROM encabezado_cp2"); 
//        }
//        catch (SQLException ex)
//        {
//            while (ex !=null)
//            {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } 
//        Collection co = new ArrayList();   
//        try
//        {
//            while (resu.next())
//            {
//               EncabezadoCP encCP = new EncabezadoCP();
//               encCP.setSerieCP(resu.getString(1));
//               encCP.setCodigoCP(resu.getLong(2));
//               Provincia prov = new Provincia();
//               prov.setIdprovincia(resu.getInt(3));
//               prov.setNombre(resu.getString(4));
//               encCP.setProvincia(prov);
//               Departamento dep = new Departamento();
//               dep.setIddepartamento(resu.getInt(5));
//               dep.setNombre(resu.getString(6));
//               encCP.setDepartamento(dep);
//               Localidad loc = new Localidad();
//               loc.setIdlocalidad(resu.getInt(7));
//               loc.setNombre(resu.getString(8));
//               encCP.setLocalidad(loc);
//               Barrio barrio = new Barrio();
//               barrio.setIdbarrio(resu.getInt(9));
//               barrio.setNombre(resu.getString(10));
//               encCP.setBarrrio(barrio);
//               encCP.setCalle(resu.getString(11));
//               encCP.setNumero(resu.getString(12));
//               encCP.setManzana(resu.getString(13));
//               encCP.setLote(resu.getString(14));
//               encCP.setSerieFactura(resu.getInt(15));
//               encCP.setNumeroFactura(resu.getLong(16));
//               encCP.setDia(resu.getFloat(17));
//               encCP.setMes(resu.getFloat(18));
//               encCP.setAnio(resu.getFloat(19));
//               encCP.setHora(resu.getFloat(20));
//               encCP.setMinutos(resu.getFloat(21));
//               encCP.setSegundos(resu.getFloat(22));
//               encCP.setPropietario(resu.getString(23));
//               encCP.setComitente(resu.getString(24));
//               encCP.setAnulado(resu.getString(25));
//               Usuario user = new  Usuario();
//               user.setIdusuario(resu.getInt(26));
//               user.setNombre(resu.getString(27));
//               encCP.setUsuario(user);
//               Matriculado mat = new Matriculado();
//               mat.setIdmatriculado(resu.getInt(28));
//               mat.setMatricula(resu.getInt(29));
//               mat.setApellido(resu.getString(30));
//               mat.setNombres(resu.getString(31));
//               Titulo titulo = new Titulo();
//               titulo.setIdtitulo(resu.getInt(32));
//               titulo.setAbreviacion(resu.getString(33));
//               mat.setTitulo(titulo);
//               encCP.setMatriculado(mat);
//               
//               co.add(encCP);
//           }
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
//        return co;        
//    }
    public Collection getEncabezadoCP()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_cp2"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
               EncabezadoCP encCP = new EncabezadoCP();
               encCP.setSerieCP(resu.getString(1));
               encCP.setCodigoCP(resu.getLong(2));
               Provincia prov = new Provincia();
               prov.setIdprovincia(resu.getInt(3));
               prov.setNombre(resu.getString(4));
               encCP.setProvincia(prov);
               Departamento dep = new Departamento();
               dep.setIddepartamento(resu.getInt(5));
               dep.setNombre(resu.getString(6));
               encCP.setDepartamento(dep);
               Localidad loc = new Localidad();
               loc.setIdlocalidad(resu.getInt(7));
               loc.setNombre(resu.getString(8));
               encCP.setLocalidad(loc);
               Barrio barrio = new Barrio();
               barrio.setIdbarrio(resu.getInt(9));
               barrio.setNombre(resu.getString(10));
               encCP.setBarrrio(barrio);
               encCP.setCalle(resu.getString(11));
               encCP.setNumero(resu.getString(12));
               encCP.setManzana(resu.getString(13));
               encCP.setLote(resu.getString(14));
               encCP.setSerieFactura(resu.getInt(15));
               encCP.setNumeroFactura(resu.getLong(16));
               encCP.setDia(resu.getFloat(17));
               encCP.setMes(resu.getFloat(18));
               encCP.setAnio(resu.getFloat(19));
               encCP.setHora(resu.getFloat(20));
               encCP.setMinutos(resu.getFloat(21));
               encCP.setSegundos(resu.getFloat(22));
               encCP.setPropietario(resu.getString(23));
               encCP.setComitente(resu.getString(24));
               encCP.setAnulado(resu.getString(25));
               Usuario user = new  Usuario();
               user.setIdusuario(resu.getInt(26));
               user.setNombre(resu.getString(27));
               encCP.setUsuario(user);
               Matriculado mat = new Matriculado();
               mat.setIdmatriculado(resu.getInt(28));
               mat.setMatricula(resu.getInt(29));
               mat.setApellido(resu.getString(30));
               mat.setNombres(resu.getString(31));
               Titulo titulo = new Titulo();
               titulo.setIdtitulo(resu.getInt(32));
               titulo.setAbreviacion(resu.getString(33));
               encCP.setSuperficieRelevada(resu.getDouble(34));
               encCP.setSuperficieProyecto(resu.getDouble(35));
               encCP.setTotal(resu.getDouble(36));
               encCP.setOrdenTrabajo(resu.getString(37));
               encCP.setFecha(resu.getTimestamp(38));
               mat.setTitulo(titulo);
               encCP.setMatriculado(mat);
               
                co.add(encCP);
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
    public Collection getEncabezadoCPxMatricula(int matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_cp2 WHERE matricula = "+matricula); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
               EncabezadoCP encCP = new EncabezadoCP();
               encCP.setSerieCP(resu.getString(1));
               encCP.setCodigoCP(resu.getLong(2));
               Provincia prov = new Provincia();
               prov.setIdprovincia(resu.getInt(3));
               prov.setNombre(resu.getString(4));
               encCP.setProvincia(prov);
               Departamento dep = new Departamento();
               dep.setIddepartamento(resu.getInt(5));
               dep.setNombre(resu.getString(6));
               encCP.setDepartamento(dep);
               Localidad loc = new Localidad();
               loc.setIdlocalidad(resu.getInt(7));
               loc.setNombre(resu.getString(8));
               encCP.setLocalidad(loc);
               Barrio barrio = new Barrio();
               barrio.setIdbarrio(resu.getInt(9));
               barrio.setNombre(resu.getString(10));
               encCP.setBarrrio(barrio);
               encCP.setCalle(resu.getString(11));
               encCP.setNumero(resu.getString(12));
               encCP.setManzana(resu.getString(13));
               encCP.setLote(resu.getString(14));
               encCP.setSerieFactura(resu.getInt(15));
               encCP.setNumeroFactura(resu.getLong(16));
               encCP.setDia(resu.getFloat(17));
               encCP.setMes(resu.getFloat(18));
               encCP.setAnio(resu.getFloat(19));
               encCP.setHora(resu.getFloat(20));
               encCP.setMinutos(resu.getFloat(21));
               encCP.setSegundos(resu.getFloat(22));
               encCP.setPropietario(resu.getString(23));
               encCP.setComitente(resu.getString(24));
               encCP.setAnulado(resu.getString(25));
               Usuario user = new  Usuario();
               user.setIdusuario(resu.getInt(26));
               user.setNombre(resu.getString(27));
               encCP.setUsuario(user);
               Matriculado mat = new Matriculado();
               mat.setIdmatriculado(resu.getInt(28));
               mat.setMatricula(resu.getInt(29));
               mat.setApellido(resu.getString(30));
               mat.setNombres(resu.getString(31));
               Titulo titulo = new Titulo();
               titulo.setIdtitulo(resu.getInt(32));
               titulo.setAbreviacion(resu.getString(33));
               encCP.setSuperficieRelevada(resu.getDouble(34));
               encCP.setSuperficieProyecto(resu.getDouble(35));
               encCP.setTotal(resu.getDouble(36));
               encCP.setOrdenTrabajo(resu.getString(37));
               encCP.setFecha(resu.getTimestamp(38));
               mat.setTitulo(titulo);
               encCP.setMatriculado(mat);
               
                co.add(encCP);
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
    
    public Collection getEncabezadoCPxFecha(String fechaI, String fechaF)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_cp2 WHERE fecha BETWEEN '"+fechaI+"' AND '"+fechaF+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
               EncabezadoCP encCP = new EncabezadoCP();
               encCP.setSerieCP(resu.getString(1));
               encCP.setCodigoCP(resu.getLong(2));
               Provincia prov = new Provincia();
               prov.setIdprovincia(resu.getInt(3));
               prov.setNombre(resu.getString(4));
               encCP.setProvincia(prov);
               Departamento dep = new Departamento();
               dep.setIddepartamento(resu.getInt(5));
               dep.setNombre(resu.getString(6));
               encCP.setDepartamento(dep);
               Localidad loc = new Localidad();
               loc.setIdlocalidad(resu.getInt(7));
               loc.setNombre(resu.getString(8));
               encCP.setLocalidad(loc);
               Barrio barrio = new Barrio();
               barrio.setIdbarrio(resu.getInt(9));
               barrio.setNombre(resu.getString(10));
               encCP.setBarrrio(barrio);
               encCP.setCalle(resu.getString(11));
               encCP.setNumero(resu.getString(12));
               encCP.setManzana(resu.getString(13));
               encCP.setLote(resu.getString(14));
               encCP.setSerieFactura(resu.getInt(15));
               encCP.setNumeroFactura(resu.getLong(16));
               encCP.setDia(resu.getFloat(17));
               encCP.setMes(resu.getFloat(18));
               encCP.setAnio(resu.getFloat(19));
               encCP.setHora(resu.getFloat(20));
               encCP.setMinutos(resu.getFloat(21));
               encCP.setSegundos(resu.getFloat(22));
               encCP.setPropietario(resu.getString(23));
               encCP.setComitente(resu.getString(24));
               encCP.setAnulado(resu.getString(25));
               Usuario user = new  Usuario();
               user.setIdusuario(resu.getInt(26));
               user.setNombre(resu.getString(27));
               encCP.setUsuario(user);
               Matriculado mat = new Matriculado();
               mat.setIdmatriculado(resu.getInt(28));
               mat.setMatricula(resu.getInt(29));
               mat.setApellido(resu.getString(30));
               mat.setNombres(resu.getString(31));
               Titulo titulo = new Titulo();
               titulo.setIdtitulo(resu.getInt(32));
               titulo.setAbreviacion(resu.getString(33));
               encCP.setSuperficieRelevada(resu.getDouble(34));
               encCP.setSuperficieProyecto(resu.getDouble(35));
               encCP.setTotal(resu.getDouble(36));
               encCP.setOrdenTrabajo(resu.getString(37));
               encCP.setFecha(resu.getTimestamp(38));
               mat.setTitulo(titulo);
               encCP.setMatriculado(mat);
               
                co.add(encCP);
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
    
    public long getEncabezadoCPxSerie(String seriecp)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        long resultado = 0;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select (max(e.codigoCP)+1) as nuevocodigo from encabezadoCP e,series s where e.serieCP=s.serie AND e.serieCP='"+seriecp+"' AND tipoconstancia='P'"); 
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
            resu.next();
            //resultado = resu.getLong(1);
            if (resu.getLong(1)==0){ //si es una nueva serie y nohay constancias entonces
                resultado=1;
            }else{
                resultado = resu.getLong(1);
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
        return resultado;        
    }
    
    
    public Collection getEncabezadoCT()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_ct"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EncabezadoCT encCT = new EncabezadoCT();
                encCT.setSerieCT(resu.getString(1));
                encCT.setCodigoCT(resu.getLong(2));
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(3));
                prov.setNombre(resu.getString(4));
                encCT.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(5));
                dep.setNombre(resu.getString(6));
                encCT.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(7));
                loc.setNombre(resu.getString(8));
                encCT.setLocalidad(loc);
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(resu.getInt(9));
                barrio.setNombre(resu.getString(10));
                encCT.setBarrio(barrio);
                encCT.setSerieFactura(resu.getInt(11));
                encCT.setNumeroFactura(resu.getLong(12));
                encCT.setPerito(resu.getString(13));
                encCT.setPropietario(resu.getString(14));
                encCT.setResponsable(resu.getString(15));
                encCT.setComitente(resu.getString(16));
                encCT.setDia(resu.getLong(17));
                encCT.setMes(resu.getFloat(18));
                encCT.setAnio(resu.getFloat(19));
                encCT.setHora(resu.getFloat(20));
                encCT.setMinutos(resu.getFloat(21));
                encCT.setSegundos(resu.getFloat(22));
                PlanoCTotal  pt = new PlanoCTotal();
                pt.setIdplanoCTotal(resu.getInt(23));
                pt.setNombre(resu.getString(24));
                pt.setLeyenda(resu.getString(25));
                encCT.setPlanoCTotal(pt);
                encCT.setNombreProyectista(resu.getString(26));
                encCT.setNombreDirector(resu.getString(27));
                encCT.setNombreConductor(resu.getString(28));
                encCT.setNombreConstructor(resu.getString(29));
                encCT.setEstadoFinDeObra(resu.getString(30));
                encCT.setCalle(resu.getString(31));
                encCT.setNumero(resu.getString(32));
                encCT.setManzana(resu.getString(33));
                encCT.setLote(resu.getString(34));
                encCT.setAnulado(resu.getString(35));
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(36));
                user.setNombre(resu.getString(37));
                encCT.setUsuario(user);
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(resu.getInt(38));
                mat.setApellido(resu.getString(39));
                mat.setNombres(resu.getString(40));
                mat.setMatricula(resu.getInt(41));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(resu.getInt(42));
                titulo.setAbreviacion(resu.getString(43));
                encCT.setSuperficie(resu.getDouble(44));
                encCT.setTotal(resu.getDouble(45));
                encCT.setOrdenTrabajo(resu.getString(46));
                mat.setTitulo(titulo);
                encCT.setMatriculado(mat);
                encCT.setFecha(resu.getTimestamp(47));
                co.add(encCT);
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

    
//    public Collection getEncabezadoCTxMatricula(int matricula)
//    {
//        ResultSet resu = null;
//        Statement stmte = null;
//        Connection conne = null;
//        try 
//        { 
//            conne = super.getConection();      
//            stmte = conne.createStatement();  
//            resu = stmte.executeQuery("SELECT * FROM encabezado_ct WHERE matricula = "+matricula); 
//        }
//        catch (SQLException ex)
//        {
//            while (ex !=null)
//            {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } 
//        Collection co = new ArrayList();   
//        try
//        {
//            while (resu.next())
//            {
//               EncabezadoCT encCT = new EncabezadoCT();
//                encCT.setSerieCT(resu.getString(1));
//                encCT.setCodigoCT(resu.getLong(2));
//                Provincia prov = new Provincia();
//                prov.setIdprovincia(resu.getInt(3));
//                prov.setNombre(resu.getString(4));
//                encCT.setProvincia(prov);
//                Departamento dep = new Departamento();
//                dep.setIddepartamento(resu.getInt(5));
//                dep.setNombre(resu.getString(6));
//                Localidad loc = new Localidad();
//                loc.setIdlocalidad(resu.getInt(7));
//                loc.setNombre(resu.getString(8));
//                Barrio barrio = new Barrio();
//                barrio.setIdbarrio(resu.getInt(9));
//                barrio.setNombre(resu.getString(10));
//                encCT.setBarrio(barrio);
//                encCT.setSerieFactura(resu.getInt(11));
//                encCT.setNumeroFactura(resu.getLong(12));
//                encCT.setPerito(resu.getString(13));
//                encCT.setPropietario(resu.getString(14));
//                encCT.setResponsable(resu.getString(15));
//                encCT.setComitente(resu.getString(16));
//                encCT.setDia(resu.getLong(17));
//                encCT.setMes(resu.getFloat(18));
//                encCT.setAnio(resu.getFloat(19));
//                encCT.setHora(resu.getFloat(20));
//                encCT.setMinutos(resu.getFloat(21));
//                encCT.setSegundos(resu.getFloat(22));
//                PlanoCTotal  pt = new PlanoCTotal();
//                pt.setIdplanoCTotal(resu.getInt(23));
//                encCT.setPlanoCTotal(pt);
//                encCT.setNombreProyectista(resu.getString(24));
//                encCT.setNombreDirector(resu.getString(25));
//                encCT.setNombreConductor(resu.getString(26));
//                encCT.setNombreConstructor(resu.getString(27));
//                encCT.setEstadoFinDeObra(resu.getString(28));
//                encCT.setCalle(resu.getString(29));
//                encCT.setNumero(resu.getString(30));
//                encCT.setManzana(resu.getString(31));
//                encCT.setLote(resu.getString(32));
//                encCT.setAnulado(resu.getString(33));
//                Usuario user = new Usuario();
//                user.setIdusuario(resu.getInt(34));
//                user.setNombre(resu.getString(35));
//                encCT.setUsuario(user);
//                Matriculado mat = new Matriculado();
//                mat.setIdmatriculado(resu.getInt(36));
//                mat.setApellido(resu.getString(37));
//                mat.setNombres(resu.getString(38));
//                mat.setMatricula(resu.getInt(39));
//                Titulo titulo = new Titulo();
//                titulo.setIdtitulo(resu.getInt(40));
//                titulo.setAbreviacion(resu.getString(41));
//                mat.setTitulo(titulo);
//                encCT.setMatriculado(mat);
//                encCT.setFecha(resu.getTimestamp(47));
//                co.add(encCT);
//           }
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
//        return co;        
//    }
    public Collection getEncabezadoCTxMatricula(int matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_ct WHERE matricula = "+matricula); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EncabezadoCT encCT = new EncabezadoCT();
                encCT.setSerieCT(resu.getString(1));
                encCT.setCodigoCT(resu.getLong(2));
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(3));
                prov.setNombre(resu.getString(4));
                encCT.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(5));
                dep.setNombre(resu.getString(6));
                encCT.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(7));
                loc.setNombre(resu.getString(8));
                encCT.setLocalidad(loc);
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(resu.getInt(9));
                barrio.setNombre(resu.getString(10));
                encCT.setBarrio(barrio);
                encCT.setSerieFactura(resu.getInt(11));
                encCT.setNumeroFactura(resu.getLong(12));
                encCT.setPerito(resu.getString(13));
                encCT.setPropietario(resu.getString(14));
                encCT.setResponsable(resu.getString(15));
                encCT.setComitente(resu.getString(16));
                encCT.setDia(resu.getLong(17));
                encCT.setMes(resu.getFloat(18));
                encCT.setAnio(resu.getFloat(19));
                encCT.setHora(resu.getFloat(20));
                encCT.setMinutos(resu.getFloat(21));
                encCT.setSegundos(resu.getFloat(22));
                PlanoCTotal  pt = new PlanoCTotal();
                pt.setIdplanoCTotal(resu.getInt(23));
                pt.setNombre(resu.getString(24));
                pt.setLeyenda(resu.getString(25));
                encCT.setPlanoCTotal(pt);
                encCT.setNombreProyectista(resu.getString(26));
                encCT.setNombreDirector(resu.getString(27));
                encCT.setNombreConductor(resu.getString(28));
                encCT.setNombreConstructor(resu.getString(29));
                encCT.setEstadoFinDeObra(resu.getString(30));
                encCT.setCalle(resu.getString(31));
                encCT.setNumero(resu.getString(32));
                encCT.setManzana(resu.getString(33));
                encCT.setLote(resu.getString(34));
                encCT.setAnulado(resu.getString(35));
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(36));
                user.setNombre(resu.getString(37));
                encCT.setUsuario(user);
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(resu.getInt(38));
                mat.setApellido(resu.getString(39));
                mat.setNombres(resu.getString(40));
                mat.setMatricula(resu.getInt(41));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(resu.getInt(42));
                titulo.setAbreviacion(resu.getString(43));
                encCT.setSuperficie(resu.getDouble(44));
                encCT.setTotal(resu.getDouble(45));
                encCT.setOrdenTrabajo(resu.getString(46));
                mat.setTitulo(titulo);
                encCT.setMatriculado(mat);
                encCT.setFecha(resu.getTimestamp(47));
                co.add(encCT);
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
    
public Collection getEncabezadoCT(String fechaI, String fechaF, int matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_ct WHERE matricula = '"+matricula+"' AND fecha BETWEEN '"+fechaI+"' AND '"+fechaF+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EncabezadoCT encCT = new EncabezadoCT();
                encCT.setSerieCT(resu.getString(1));
                encCT.setCodigoCT(resu.getLong(2));
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(3));
                prov.setNombre(resu.getString(4));
                encCT.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(5));
                dep.setNombre(resu.getString(6));
                encCT.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(7));
                loc.setNombre(resu.getString(8));
                encCT.setLocalidad(loc);
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(resu.getInt(9));
                barrio.setNombre(resu.getString(10));
                encCT.setBarrio(barrio);
                encCT.setSerieFactura(resu.getInt(11));
                encCT.setNumeroFactura(resu.getLong(12));
                encCT.setPerito(resu.getString(13));
                encCT.setPropietario(resu.getString(14));
                encCT.setResponsable(resu.getString(15));
                encCT.setComitente(resu.getString(16));
                encCT.setDia(resu.getLong(17));
                encCT.setMes(resu.getFloat(18));
                encCT.setAnio(resu.getFloat(19));
                encCT.setHora(resu.getFloat(20));
                encCT.setMinutos(resu.getFloat(21));
                encCT.setSegundos(resu.getFloat(22));
                PlanoCTotal  pt = new PlanoCTotal();
                pt.setIdplanoCTotal(resu.getInt(23));
                pt.setNombre(resu.getString(24));
                pt.setLeyenda(resu.getString(25));
                encCT.setPlanoCTotal(pt);
                encCT.setNombreProyectista(resu.getString(26));
                encCT.setNombreDirector(resu.getString(27));
                encCT.setNombreConductor(resu.getString(28));
                encCT.setNombreConstructor(resu.getString(29));
                encCT.setEstadoFinDeObra(resu.getString(30));
                encCT.setCalle(resu.getString(31));
                encCT.setNumero(resu.getString(32));
                encCT.setManzana(resu.getString(33));
                encCT.setLote(resu.getString(34));
                encCT.setAnulado(resu.getString(35));
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(36));
                user.setNombre(resu.getString(37));
                encCT.setUsuario(user);
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(resu.getInt(38));
                mat.setApellido(resu.getString(39));
                mat.setNombres(resu.getString(40));
                mat.setMatricula(resu.getInt(41));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(resu.getInt(42));
                titulo.setAbreviacion(resu.getString(43));
                encCT.setSuperficie(resu.getDouble(44));
                encCT.setTotal(resu.getDouble(45));
                encCT.setOrdenTrabajo(resu.getString(46));
                mat.setTitulo(titulo);
                encCT.setMatriculado(mat);
                encCT.setFecha(resu.getTimestamp(47));
                co.add(encCT);
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
    public Collection getEncabezadoCTxFecha(String fechaI, String fechaF)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encabezado_ct WHERE fecha BETWEEN '"+fechaI+"' AND '"+fechaF+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EncabezadoCT encCT = new EncabezadoCT();
                encCT.setSerieCT(resu.getString(1));
                encCT.setCodigoCT(resu.getLong(2));
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(3));
                prov.setNombre(resu.getString(4));
                encCT.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(5));
                dep.setNombre(resu.getString(6));
                encCT.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(7));
                loc.setNombre(resu.getString(8));
                encCT.setLocalidad(loc);
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(resu.getInt(9));
                barrio.setNombre(resu.getString(10));
                encCT.setBarrio(barrio);
                encCT.setSerieFactura(resu.getInt(11));
                encCT.setNumeroFactura(resu.getLong(12));
                encCT.setPerito(resu.getString(13));
                encCT.setPropietario(resu.getString(14));
                encCT.setResponsable(resu.getString(15));
                encCT.setComitente(resu.getString(16));
                encCT.setDia(resu.getLong(17));
                encCT.setMes(resu.getFloat(18));
                encCT.setAnio(resu.getFloat(19));
                encCT.setHora(resu.getFloat(20));
                encCT.setMinutos(resu.getFloat(21));
                encCT.setSegundos(resu.getFloat(22));
                PlanoCTotal  pt = new PlanoCTotal();
                pt.setIdplanoCTotal(resu.getInt(23));
                pt.setNombre(resu.getString(24));
                pt.setLeyenda(resu.getString(25));
                encCT.setPlanoCTotal(pt);
                encCT.setNombreProyectista(resu.getString(26));
                encCT.setNombreDirector(resu.getString(27));
                encCT.setNombreConductor(resu.getString(28));
                encCT.setNombreConstructor(resu.getString(29));
                encCT.setEstadoFinDeObra(resu.getString(30));
                encCT.setCalle(resu.getString(31));
                encCT.setNumero(resu.getString(32));
                encCT.setManzana(resu.getString(33));
                encCT.setLote(resu.getString(34));
                encCT.setAnulado(resu.getString(35));
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(36));
                user.setNombre(resu.getString(37));
                encCT.setUsuario(user);
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(resu.getInt(38));
                mat.setApellido(resu.getString(39));
                mat.setNombres(resu.getString(40));
                mat.setMatricula(resu.getInt(41));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(resu.getInt(42));
                titulo.setAbreviacion(resu.getString(43));
                encCT.setSuperficie(resu.getDouble(44));
                encCT.setTotal(resu.getDouble(45));
                encCT.setOrdenTrabajo(resu.getString(46));
                mat.setTitulo(titulo);
                encCT.setMatriculado(mat);
                encCT.setFecha(resu.getTimestamp(47));
                co.add(encCT);
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
    
    public long getEncabezadoCTxSerie(String seriect)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select (max(e.codigoCT)+1) as nuevocodigo from encabezadoCT e,series s where e.serieCT=s.serie AND e.serieCT='"+seriect+"' AND tipoconstancia='T'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        long resultado = 0;   
        try
        {
            resu.next();
            if (resu.getLong(1)==0){ //si es una nueva serie y nohay constancias entonces
                resultado=1;
            }else{
                resultado = resu.getLong(1);
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
        return resultado;        
    }
    
    public Collection getDetalleCP()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM detalle_cp1"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetalleCP detCP = new DetalleCP();
                detCP.setIddetalleCP(resu.getLong(1));
                detCP.setSerieCP(resu.getString(2));
                detCP.setCodigoCP(resu.getInt(3));
                TipoTrabajo ttrab = new TipoTrabajo();
                ttrab.setIdtipoTrabajo(resu.getInt(4));
                detCP.setTipoTrabajo(ttrab);
                TipoSeccion tsecc = new TipoSeccion();
                tsecc.setIdtipoSeccion(resu.getInt(5));
                detCP.setTipoSeccion(tsecc);
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(6));
                detCP.setTipoSuperficie(tsuper);
                detCP.setSuperficie(resu.getDouble(7));
                co.add(detCP);
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
    
    public Collection getDetalleCPxSerieyCodigo(String seriecp, long codigocp)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM detalle_cp1 WHERE seriecp = '"+seriecp+"' AND codigocp = "+codigocp); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetalleCP detCP = new DetalleCP();
                detCP.setIddetalleCP(resu.getLong(1));
                detCP.setSerieCP(resu.getString(2));
                detCP.setCodigoCP(resu.getInt(3));
                TipoTrabajo ttrab = new TipoTrabajo();
                ttrab.setIdtipoTrabajo(resu.getInt(4));
                ttrab.setNombre(resu.getString(5));
                detCP.setTipoTrabajo(ttrab);
                TipoSeccion tsecc = new TipoSeccion();
                tsecc.setIdtipoSeccion(resu.getInt(6));
                tsecc.setNombre(resu.getString(7));
                detCP.setTipoSeccion(tsecc);
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(8));
                tsuper.setNombre(resu.getString(9));
                detCP.setTipoSuperficie(tsuper);
                detCP.setSuperficie(resu.getDouble(10));
                co.add(detCP);
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
    
    public Collection armarDetalleCP(String serie, String codigo)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * from tasasAplicablesCP('"+serie.trim()+"',"+codigo.trim()+")"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Tasa t = new Tasa();
                t.setIndice(resu.getDouble(1));
                t.setTasaMinima(resu.getDouble(2));
                t.setIdtasa(resu.getInt(3));
                t.setDenominacion(resu.getString(4));
                t.setObservacion(resu.getString(5));
                t.setExiste(resu.getString(6));
                co.add(t);
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
    
    public Collection armarDetalleCT(String serie, String codigo)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM tasasAplicablesCT('"+serie.trim()+"',"+codigo.trim()+")"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Tasa t = new Tasa();
                t.setIndice(resu.getDouble(1));
                t.setTasaMinima(resu.getDouble(2));
                t.setIdtasa(resu.getInt(3));
                t.setDenominacion(resu.getString(4));
                t.setObservacion(resu.getString(5));
                t.setExiste(resu.getString(6));
                co.add(t);
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

    public Collection getTasasSelecciondas(String serie, long codigo)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        Collection co = new ArrayList();
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
                resu = stmte.executeQuery("SELECT idTasa, monto FROM enc_mat_ct WHERE codigoct = "+codigo+ " AND seriect = '"+serie.trim()+"'"); 
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
                TasaSeleccionada t = new TasaSeleccionada();
                t.setCodigoCT(codigo);
                t.setIdTasa(resu.getInt(1));
                t.setMonto(resu.getDouble(2));
                t.setSerieCT(serie);
                co.add(t);
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

    public long getIdDetalleCPxSerie(String seriecp)
    {   //Devuelve elultimo valor del idetalle de const totales
        //sirve para hacer el alta de un nuevo detalle de const total
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select (max(d.iddetalle)+1) as nuevocodigo from detalleCP d"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        long resultado = 0;   
        try
        {
            resu.next();
            if (resu.getLong(1)==0){ //si es una nueva serie y nohay constancias entonces
                resultado=1;
            }else{
                resultado = resu.getLong(1);
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
        return resultado;        
    }

    
    public long getIdDetalleCTxSerie(String seriect)
    {   //Devuelve elultimo valor del idetalle de const totales
        //sirve para hacer el alta de un nuevo detalle de const total
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select (max(d.iddetalle)+1) as nuevocodigo from detalleCT d"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        long resultado = 0;   
        try
        {
            resu.next();
            if (resu.getLong(1)==0){ //si es una nueva serie y nohay constancias entonces
                resultado=1;
            }else{
                resultado = resu.getLong(1);
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
        return resultado;        
    }
    
    public Collection getDetalleCT()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM detalle_ct"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetalleCT detCT = new DetalleCT();
                detCT.setIddetalleCT(resu.getLong(1));
                detCT.setSerieCT(resu.getString(2));
                detCT.setCodigoCT(resu.getLong(3));
                TipoSeccion tsecc = new TipoSeccion();
                tsecc.setIdtipoSeccion(resu.getInt(4));
                detCT.setTipoSeccion(tsecc);
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(5));
                tsuper.setNombre(resu.getString(6));
                detCT.setTipoSuperficie(tsuper);
                detCT.setSuperficie(resu.getDouble(7));
                co.add(detCT);
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
    
    public Collection getDetalleCTxSerieyCodigo(String seriect, long codigoct)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM detalle_ct WHERE seriect = '"+seriect+"' AND codigoct = "+codigoct); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetalleCT detCT = new DetalleCT();
                detCT.setIddetalleCT(resu.getLong(1));
                detCT.setSerieCT(resu.getString(2));
                detCT.setCodigoCT(resu.getLong(3));
                TipoSeccion tsecc = new TipoSeccion();
                tsecc.setIdtipoSeccion(resu.getInt(4));
                tsecc.setNombre(resu.getString(5));
                detCT.setTipoSeccion(tsecc);
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(6));
                tsuper.setNombre(resu.getString(7));
                detCT.setTipoSuperficie(tsuper);
                detCT.setSuperficie(resu.getDouble(8));
                co.add(detCT);
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

    
    public Collection getDetalleCTxSerie(String seriect)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM detalle_ct WHERE seriect = '"+seriect+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetalleCT detCT = new DetalleCT();
                detCT.setIddetalleCT(resu.getLong(1));
                detCT.setSerieCT(resu.getString(2));
                detCT.setCodigoCT(resu.getLong(3));
                TipoSeccion tsecc = new TipoSeccion();
                tsecc.setIdtipoSeccion(resu.getInt(4));
                detCT.setTipoSeccion(tsecc);
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(5));
                tsuper.setNombre(resu.getString(6));
                detCT.setTipoSuperficie(tsuper);
                detCT.setSuperficie(resu.getDouble(7));
                co.add(detCT);
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
    
    public Collection getConfiguracion()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idconfiguracion, host, directoriotemp, codigomaximoCP, codigomaximoCT, idproducto FROM configuraciones"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Configuracion conf = new Configuracion();
                conf.setIdconfiguracion(resu.getInt(1));
                conf.setHost(resu.getString(2));
                conf.setDirectorioTemp(resu.getString(3));
                conf.setCodigoMaximoCP(resu.getLong(4));
                conf.setCodigoMaximoCT(resu.getLong(5));
                conf.setIdproducto(resu.getInt(6));
                co.add(conf);
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
    
    /**
     * Extrae la foto del matriculado desde la base de datos hacia una carpeta temporaria
     * indicada
     * Devuelve un booleano:
     *      true = si ejecuto correctamento la sentencia
     *      false = si fallo porque no existe la foto o esta mal el destino
     */
    public boolean recuperarFoto(String destino, String matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        boolean respuesta = false;
        respuesta = this.existeFoto(matricula);        
//        System.out.println("EXISTE LA FOTO EN TABLA IMAGENES?: "+ respuesta);
        if (respuesta){//jorge        
            try{ 
                conne = super.getConection();      
                stmte = conne.createStatement();  
                resu = stmte.executeQuery("select lo_export(imagenes.imagen, '"+destino+"') from imagenes where matricula = "+matricula);
            }catch (SQLException ex){
                respuesta=false;//jorge
                JOptionPane.showMessageDialog(null,"La foto si existe pero no se mostrar por la incorrecta\nconfiguracion del directorio de imagenes\nvalla al menu configuraciones y cambie la direccion de este directorio\nespecifique direccion del servidor o la direccion de la PC donde se almacenara temporalmente las imagenes recuperadas de la Base de Datos","Atencion",JOptionPane.WARNING_MESSAGE);
                while (ex !=null){
                    ex.printStackTrace();
                    ex = ex.getNextException();
                }
            }
        }//jorge
        
        try{
          if (resu!=null){  
            resu.close();
            stmte.close();
            conne.close();
          }
        } catch(SQLException e){
          while (e != null){
             e.printStackTrace();
             e = e.getNextException();
          }         
        }      
        return respuesta;        
    }
    
    public boolean existeFoto( String matricula)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        boolean respuesta = false;
        try { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select matricula from imagenes where matricula = "+matricula);
            if (resu.next()){
                respuesta = true;
            }
        }catch (SQLException ex){
            while (ex !=null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
//        if (resu == null)
//        {
//            respuesta = false;
//        }else{
//            respuesta = true;
//        }
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
        return respuesta;        
    }
    
    public Collection getConstanciaHabilitacion()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idconstanciahabilitacion, leyenda1, leyenda2, leyenda3, leyenda4 FROM constanciashabilitaciones"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                ConstanciaHabilitacion chab = new ConstanciaHabilitacion();
                chab.setIdconstanciaHabilitacion(resu.getInt(1));
                chab.setLeyenda1(resu.getString(2));
                chab.setLeyenda2(resu.getString(3));
                chab.setLeyenda3(resu.getString(4));
                chab.setLeyenda4(resu.getString(5));
                co.add(chab);
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
    
    public Collection getUsuario()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idusuario, nombre, password, nivel, existe FROM usuarios WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(1));
                user.setNombre(resu.getString(2));
                user.setPassword(resu.getString(3));
                user.setNivel(resu.getInt(4));
                user.setExiste(resu.getString(5));
                co.add(user);
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
    
    public Usuario getUser(String nombre)
    {
        Usuario u = new Usuario();
        Collection co = new ArrayList();
        co = this.getUsuario();
        Iterator it = co.iterator();
        while(it.hasNext())
        {
            Usuario t = (Usuario)it.next();
            if(t.getNombre().trim().equals(nombre))
                u = t;
        }
        return u;
    }
    
    public Collection getUsuario(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idusuario, nombre, password, nivel, existe FROM usuarios WHERE existe = 'S'AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(1));
                user.setNombre(resu.getString(2));
                user.setPassword(resu.getString(3));
                user.setNivel(resu.getInt(4));
                user.setExiste(resu.getString(5));
                co.add(user);
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
    
    public Collection getTodoUsuario()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idusuario FROM usuarios"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(1));
                co.add(user);
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
    
    public Collection getMatriculado()
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery("select * from matfechseparadas4 WHERE existe = 'S'");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));
                mat.setDni(res.getString(5));
                mat.setCalle(res.getString(6));
                mat.setDiaNac(res.getFloat(7));
                mat.setMesNac(res.getFloat(8));
                mat.setAnioNac(res.getFloat(9));
                mat.setEmail(res.getString(10));
                mat.setTelefonoTrabajo(res.getString(11));
                mat.setWeb(res.getString(12));
                mat.setCuit(res.getString(13));
                mat.setCuil(res.getString(14));
                mat.setHabilitado(res.getString(15));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(res.getInt(16));
                barrio.setNombre(res.getString(17));
                mat.setBarrio(barrio);
                Provincia prov = new Provincia();
                prov.setIdprovincia(res.getInt(18));
                prov.setNombre(res.getString(19));
                mat.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(res.getInt(20));
                dep.setNombre(res.getString(21));
                mat.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(res.getInt(22));
                loc.setNombre(res.getString(23));
                mat.setLocalidad(loc);
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(res.getInt(24));
                nac.setNombre(res.getString(25));
                mat.setNacionalidad(nac);
                Departamento depprof = new Departamento();
                depprof.setIddepartamento(res.getInt(26));
                depprof.setNombre(res.getString(27));
                mat.setDepartamentoProfesional(depprof);
                Localidad locprof = new Localidad();
                locprof.setIdlocalidad(res.getInt(28));
                locprof.setNombre(res.getString(29));
                mat.setLocalidadProfesional(locprof);
                Barrio barrioprof = new Barrio();
                barrioprof.setIdbarrio(res.getInt(30));
                barrioprof.setNombre(res.getString(31));
                mat.setBarrioProfesional(barrioprof);
                mat.setCalleProfesional(res.getString(32));
                mat.setDiaIns(res.getFloat(33));
                mat.setMesIns(res.getFloat(34));
                mat.setAnioIns(res.getFloat(35));
                mat.setLibro(res.getString(36));
                mat.setFolio(res.getString(37));
                Escuela esc = new Escuela();
                esc.setIdescuela(res.getInt(38));
                esc.setNombre(res.getString(39));
                mat.setEscuela(esc);
                mat.setDiaEgr(res.getFloat(40));
                mat.setMesEgr(res.getFloat(41));
                mat.setAnioEgr(res.getFloat(42));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(43));
                titulo.setAbreviacion(res.getString(44));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(45));
                mat.setExiste(res.getString(46));
                mat.setTelefonoParticular(res.getString(47));
                mat.setTelefonoCelular(res.getString(48));
                mat.setIngresosBrutos(res.getString(49));
                Iva iva = new Iva();
                iva.setIdiva(res.getInt(50));
                iva.setNombre(res.getString(51));
                mat.setIva(iva);
                co.add(mat);
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
        this.cerrar();
        return co;
    }
    public Collection getMatriculado2()
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery("select * from matfechseparadas4_reducido WHERE existe = 'S'");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            
            while (res.next())
            {
                Matriculado mat = new Matriculado();                
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));                
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(5));
                titulo.setAbreviacion(res.getString(6));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(7));
                mat.setExiste(res.getString(8));                
                co.add(mat);
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
        this.cerrar();
        return co;
    }
    public Collection getMatriculadoxParametros2(String parametros)
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery("select * from matfechseparadas4_reducido WHERE existe = 'S' AND "+parametros);
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));                
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(5));
                titulo.setAbreviacion(res.getString(6));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(7));
                mat.setExiste(res.getString(8));                
                co.add(mat);
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
        this.cerrar();
        return co;
    }
    public Collection getMatriculadoxParametros(String parametros)
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery("select * from matfechseparadas4 WHERE existe = 'S' AND "+parametros);
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));
                mat.setDni(res.getString(5));
                mat.setCalle(res.getString(6));
                mat.setDiaNac(res.getFloat(7));
                mat.setMesNac(res.getFloat(8));
                mat.setAnioNac(res.getFloat(9));
                mat.setEmail(res.getString(10));
                mat.setTelefonoTrabajo(res.getString(11));
                mat.setWeb(res.getString(12));
                mat.setCuit(res.getString(13));
                mat.setCuil(res.getString(14));
                mat.setHabilitado(res.getString(15));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(res.getInt(16));
                barrio.setNombre(res.getString(17));
                mat.setBarrio(barrio);
                Provincia prov = new Provincia();
                prov.setIdprovincia(res.getInt(18));
                prov.setNombre(res.getString(19));
                mat.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(res.getInt(20));
                dep.setNombre(res.getString(21));
                mat.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(res.getInt(22));
                loc.setNombre(res.getString(23));
                mat.setLocalidad(loc);
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(res.getInt(24));
                nac.setNombre(res.getString(25));
                mat.setNacionalidad(nac);
                Departamento depprof = new Departamento();
                depprof.setIddepartamento(res.getInt(26));
                depprof.setNombre(res.getString(27));
                mat.setDepartamentoProfesional(depprof);
                Localidad locprof = new Localidad();
                locprof.setIdlocalidad(res.getInt(28));
                locprof.setNombre(res.getString(29));
                mat.setLocalidadProfesional(locprof);
                Barrio barrioprof = new Barrio();
                barrioprof.setIdbarrio(res.getInt(30));
                barrioprof.setNombre(res.getString(31));
                mat.setBarrioProfesional(barrioprof);
                mat.setCalleProfesional(res.getString(32));
                mat.setDiaIns(res.getFloat(33));
                mat.setMesIns(res.getFloat(34));
                mat.setAnioIns(res.getFloat(35));
                mat.setLibro(res.getString(36));
                mat.setFolio(res.getString(37));
                Escuela esc = new Escuela();
                esc.setIdescuela(res.getInt(38));
                esc.setNombre(res.getString(39));
                mat.setEscuela(esc);
                mat.setDiaEgr(res.getFloat(40));
                mat.setMesEgr(res.getFloat(41));
                mat.setAnioEgr(res.getFloat(42));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(43));
                titulo.setAbreviacion(res.getString(44));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(45));
                mat.setExiste(res.getString(46));
                mat.setTelefonoParticular(res.getString(47));
                mat.setTelefonoCelular(res.getString(48));
                mat.setIngresosBrutos(res.getString(49));
                Iva iva = new Iva();
                iva.setIdiva(res.getInt(50));
                iva.setNombre(res.getString(51));
                mat.setIva(iva);
                co.add(mat);
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
        this.cerrar();
        return co;
    }
    
    public Collection getMatriculado(int matricula)
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery(" select * from matxmatricula3('S','"+matricula+"%')");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
               Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));
                mat.setDni(res.getString(5));
                mat.setCalle(res.getString(6));
                mat.setDiaNac(res.getFloat(7));
                mat.setMesNac(res.getFloat(8));
                mat.setAnioNac(res.getFloat(9));
                mat.setEmail(res.getString(10));
                mat.setTelefonoTrabajo(res.getString(11));
                mat.setWeb(res.getString(12));
                mat.setCuit(res.getString(13));
                mat.setCuil(res.getString(14));
                mat.setHabilitado(res.getString(15));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(res.getInt(16));
                barrio.setNombre(res.getString(17));
                mat.setBarrio(barrio);
                Provincia prov = new Provincia();
                prov.setIdprovincia(res.getInt(18));
                prov.setNombre(res.getString(19));
                mat.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(res.getInt(20));
                dep.setNombre(res.getString(21));
                mat.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(res.getInt(22));
                loc.setNombre(res.getString(23));
                mat.setLocalidad(loc);
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(res.getInt(24));
                nac.setNombre(res.getString(25));
                mat.setNacionalidad(nac);
                Departamento depprof = new Departamento();
                depprof.setIddepartamento(res.getInt(26));
                depprof.setNombre(res.getString(27));
                mat.setDepartamentoProfesional(depprof);
                Localidad locprof = new Localidad();
                locprof.setIdlocalidad(res.getInt(28));
                locprof.setNombre(res.getString(29));
                mat.setLocalidadProfesional(locprof);
                Barrio barrioprof = new Barrio();
                barrioprof.setIdbarrio(res.getInt(30));
                barrioprof.setNombre(res.getString(31));
                mat.setBarrioProfesional(barrioprof);
                mat.setCalleProfesional(res.getString(32));
                mat.setDiaIns(res.getFloat(33));
                mat.setMesIns(res.getFloat(34));
                mat.setAnioIns(res.getFloat(35));
                mat.setLibro(res.getString(36));
                mat.setFolio(res.getString(37));
                Escuela esc = new Escuela();
                esc.setIdescuela(res.getInt(38));
                esc.setNombre(res.getString(39));
                mat.setEscuela(esc);
                mat.setDiaEgr(res.getFloat(40));
                mat.setMesEgr(res.getFloat(41));
                mat.setAnioEgr(res.getFloat(42));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(43));
                titulo.setAbreviacion(res.getString(44));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(45));
                mat.setExiste(res.getString(46));
                mat.setTelefonoParticular(res.getString(47));
                mat.setTelefonoCelular(res.getString(48));
                Iva iva = new Iva();
                iva.setIdiva(res.getInt(50));
                iva.setNombre(res.getString(51));
                mat.setIva(iva);
                co.add(mat);
        
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
        this.cerrar();
        return co;
    }
    
    public Matriculado getUnMatriculado(int matricula)
    {
        Matriculado mat = new Matriculado();
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery(" select * from mat_matricula('S','"+matricula+"')");
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
                if(res.next())
                {
                    if (res.getInt(1)>0){
                        mat.setIdmatriculado(res.getInt(1));
                        mat.setMatricula(res.getInt(2));
                        mat.setApellido(res.getString(3).trim());
                        mat.setNombres(res.getString(4).trim());
                        mat.setDni(res.getString(5).trim());
                        mat.setCalle(res.getString(6).trim());
                        mat.setDiaNac(res.getFloat(7));
                        mat.setMesNac(res.getFloat(8));
                        mat.setAnioNac(res.getFloat(9));                        
                        mat.setEmail(res.getString(10).trim());
                        mat.setTelefonoTrabajo(res.getString(11).trim());
                        mat.setWeb(res.getString(12).trim());
                        mat.setCuit(res.getString(13).trim().trim());
                        mat.setCuil(res.getString(14).trim().trim());
                        mat.setHabilitado(res.getString(15).trim());
                        Barrio barrio = new Barrio();
                        barrio.setIdbarrio(res.getInt(16));
                        barrio.setNombre(res.getString(17).trim());
                        mat.setBarrio(barrio);
                        Provincia prov = new Provincia();
                        prov.setIdprovincia(res.getInt(18));
                        prov.setNombre(res.getString(19).trim());
                        mat.setProvincia(prov);
                        Departamento dep = new Departamento();
                        dep.setIddepartamento(res.getInt(20));
                        dep.setNombre(res.getString(21).trim());
                        mat.setDepartamento(dep);
                        Localidad loc = new Localidad();
                        loc.setIdlocalidad(res.getInt(22));
                        loc.setNombre(res.getString(23).trim());
                        mat.setLocalidad(loc);
                        Nacionalidad nac = new Nacionalidad();
                        nac.setIdnacionalidad(res.getInt(24));
                        nac.setNombre(res.getString(25).trim());
                        mat.setNacionalidad(nac);
                        Departamento depprof = new Departamento();
                        depprof.setIddepartamento(res.getInt(26));
                        depprof.setNombre(res.getString(27).trim());
                        mat.setDepartamentoProfesional(depprof);
                        Localidad locprof = new Localidad();
                        locprof.setIdlocalidad(res.getInt(28));
                        locprof.setNombre(res.getString(29).trim());
                        mat.setLocalidadProfesional(locprof);
                        Barrio barrioprof = new Barrio();
                        barrioprof.setIdbarrio(res.getInt(30));
                        barrioprof.setNombre(res.getString(31).trim());
                        mat.setBarrioProfesional(barrioprof);
                        mat.setCalleProfesional(res.getString(32).trim());
                        mat.setDiaIns(res.getFloat(33));
                        mat.setMesIns(res.getFloat(34));
                        mat.setAnioIns(res.getFloat(35));
                        mat.setLibro(res.getString(36).trim());
                        mat.setFolio(res.getString(37).trim());
                        Escuela esc = new Escuela();
                        esc.setIdescuela(res.getInt(38));
                        esc.setNombre(res.getString(39).trim());
                        mat.setEscuela(esc);
                        mat.setDiaEgr(res.getFloat(40));
                        mat.setMesEgr(res.getFloat(41));
                        mat.setAnioEgr(res.getFloat(42));
                        Titulo titulo = new Titulo();
                        titulo.setIdtitulo(res.getInt(43));
                        titulo.setAbreviacion(res.getString(44).trim());
                        mat.setTitulo(titulo);
                        mat.setEspecialidad(res.getString(45).trim());
                        mat.setExiste(res.getString(46).trim());
                        mat.setTelefonoParticular(res.getString(47).trim());
                        mat.setTelefonoCelular(res.getString(48).trim());
                        mat.setIngresosBrutos(res.getString(49).trim());
                        Iva iva=new Iva();
                        iva.setIdiva(res.getInt(50));
                        iva.setNombre(res.getString(51).trim());
                        iva.setExiste("S");
                        mat.setIva(iva);   
                    }
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
        this.cerrar();
        return mat;
    }
    
    public Collection getMatriculadoTitulo(String existe ,String nombretitulo)
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery(" select * from matxtitulo('"+existe+"','"+nombretitulo+"%')");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
               Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));
                mat.setDni(res.getString(5));
                mat.setCalle(res.getString(6));
                mat.setDiaNac(res.getFloat(7));
                mat.setMesNac(res.getFloat(8));
                mat.setAnioNac(res.getFloat(9));
                mat.setEmail(res.getString(10));
                mat.setTelefonoTrabajo(res.getString(11));
                mat.setWeb(res.getString(12));
                mat.setCuit(res.getString(13));
                mat.setCuil(res.getString(14));
                mat.setHabilitado(res.getString(15));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(res.getInt(16));
                barrio.setNombre(res.getString(17));
                mat.setBarrio(barrio);
                Provincia prov = new Provincia();
                prov.setIdprovincia(res.getInt(18));
                prov.setNombre(res.getString(19));
                mat.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(res.getInt(20));
                dep.setNombre(res.getString(21));
                mat.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(res.getInt(22));
                loc.setNombre(res.getString(23));
                mat.setLocalidad(loc);
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(res.getInt(24));
                nac.setNombre(res.getString(25));
                mat.setNacionalidad(nac);
                Departamento depprof = new Departamento();
                depprof.setIddepartamento(res.getInt(26));
                depprof.setNombre(res.getString(27));
                mat.setDepartamentoProfesional(depprof);
                Localidad locprof = new Localidad();
                locprof.setIdlocalidad(res.getInt(28));
                locprof.setNombre(res.getString(29));
                mat.setLocalidadProfesional(locprof);
                Barrio barrioprof = new Barrio();
                barrioprof.setIdbarrio(res.getInt(30));
                barrioprof.setNombre(res.getString(31));
                mat.setBarrioProfesional(barrioprof);
                mat.setCalleProfesional(res.getString(32));
                mat.setDiaIns(res.getFloat(33));
                mat.setMesIns(res.getFloat(34));
                mat.setAnioIns(res.getFloat(35));
                mat.setLibro(res.getString(36));
                mat.setFolio(res.getString(37));
                Escuela esc = new Escuela();
                esc.setIdescuela(res.getInt(38));
                esc.setNombre(res.getString(39));
                mat.setEscuela(esc);
                mat.setDiaEgr(res.getFloat(40));
                mat.setMesEgr(res.getFloat(41));
                mat.setAnioEgr(res.getFloat(42));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(43));
                titulo.setAbreviacion(res.getString(44));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(45));
                mat.setExiste(res.getString(46));
                mat.setTelefonoParticular(res.getString(47));
                mat.setTelefonoCelular(res.getString(48));
                
                co.add(mat);
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
        this.cerrar();
        return co;
    }
    
    public Collection getMatriculado(String especialidad)
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
             res = stmt.executeQuery(" select * from matxespecialidad3('S','"+especialidad+"%')");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
               Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));
                mat.setDni(res.getString(5));
                mat.setCalle(res.getString(6));
                mat.setDiaNac(res.getFloat(7));
                mat.setMesNac(res.getFloat(8));
                mat.setAnioNac(res.getFloat(9));
                mat.setEmail(res.getString(10));
                mat.setTelefonoTrabajo(res.getString(11));
                mat.setWeb(res.getString(12));
                mat.setCuit(res.getString(13));
                mat.setCuil(res.getString(14));
                mat.setHabilitado(res.getString(15));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(res.getInt(16));
                barrio.setNombre(res.getString(17));
                mat.setBarrio(barrio);
                Provincia prov = new Provincia();
                prov.setIdprovincia(res.getInt(18));
                prov.setNombre(res.getString(19));
                mat.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(res.getInt(20));
                dep.setNombre(res.getString(21));
                mat.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(res.getInt(22));
                loc.setNombre(res.getString(23));
                mat.setLocalidad(loc);
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(res.getInt(24));
                nac.setNombre(res.getString(25));
                mat.setNacionalidad(nac);
                Departamento depprof = new Departamento();
                depprof.setIddepartamento(res.getInt(26));
                depprof.setNombre(res.getString(27));
                mat.setDepartamentoProfesional(depprof);
                Localidad locprof = new Localidad();
                locprof.setIdlocalidad(res.getInt(28));
                locprof.setNombre(res.getString(29));
                mat.setLocalidadProfesional(locprof);
                Barrio barrioprof = new Barrio();
                barrioprof.setIdbarrio(res.getInt(30));
                barrioprof.setNombre(res.getString(31));
                mat.setBarrioProfesional(barrioprof);
                mat.setCalleProfesional(res.getString(32));
                mat.setDiaIns(res.getFloat(33));
                mat.setMesIns(res.getFloat(34));
                mat.setAnioIns(res.getFloat(35));
                mat.setLibro(res.getString(36));
                mat.setFolio(res.getString(37));
                Escuela esc = new Escuela();
                esc.setIdescuela(res.getInt(38));
                esc.setNombre(res.getString(39));
                mat.setEscuela(esc);
                mat.setDiaEgr(res.getFloat(40));
                mat.setMesEgr(res.getFloat(41));
                mat.setAnioEgr(res.getFloat(42));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(43));
                titulo.setAbreviacion(res.getString(44));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(45));
                mat.setExiste(res.getString(46));
                mat.setTelefonoParticular(res.getString(47));
                mat.setTelefonoCelular(res.getString(48));
                
                co.add(mat);
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
        this.cerrar();
        return co;
    }
    
    private Titulo getTit(Collection titulos, int idTitulo)
    {
        Titulo titulo = new Titulo();
        titulo.setNombre(" ");
        Iterator it = titulos.iterator();
        while(it.hasNext())
        {
            Titulo t = (Titulo)it.next();
            if(t.getIdtitulo() == idTitulo)
                titulo = t;
        }
        return titulo;
    }
    
     public Collection getMatriculado(String habilitado, String algo)
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery(" select * from matxhabilitado3('S','"+habilitado+"')");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
               Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));
                mat.setDni(res.getString(5));
                mat.setCalle(res.getString(6));
                mat.setDiaNac(res.getFloat(7));
                mat.setMesNac(res.getFloat(8));
                mat.setAnioNac(res.getFloat(9));
                mat.setEmail(res.getString(10));
                mat.setTelefonoTrabajo(res.getString(11));
                mat.setWeb(res.getString(12));
                mat.setCuit(res.getString(13));
                mat.setCuil(res.getString(14));
                mat.setHabilitado(res.getString(15));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(res.getInt(16));
                barrio.setNombre(res.getString(17));
                mat.setBarrio(barrio);
                Provincia prov = new Provincia();
                prov.setIdprovincia(res.getInt(18));
                prov.setNombre(res.getString(19));
                mat.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(res.getInt(20));
                dep.setNombre(res.getString(21));
                mat.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(res.getInt(22));
                loc.setNombre(res.getString(23));
                mat.setLocalidad(loc);
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(res.getInt(24));
                nac.setNombre(res.getString(25));
                mat.setNacionalidad(nac);
                Departamento depprof = new Departamento();
                depprof.setIddepartamento(res.getInt(26));
                depprof.setNombre(res.getString(27));
                mat.setDepartamentoProfesional(depprof);
                Localidad locprof = new Localidad();
                locprof.setIdlocalidad(res.getInt(28));
                locprof.setNombre(res.getString(29));
                mat.setLocalidadProfesional(locprof);
                Barrio barrioprof = new Barrio();
                barrioprof.setIdbarrio(res.getInt(30));
                barrioprof.setNombre(res.getString(31));
                mat.setBarrioProfesional(barrioprof);
                mat.setCalleProfesional(res.getString(32));
                mat.setDiaIns(res.getFloat(33));
                mat.setMesIns(res.getFloat(34));
                mat.setAnioIns(res.getFloat(35));
                mat.setLibro(res.getString(36));
                mat.setFolio(res.getString(37));
                Escuela esc = new Escuela();
                esc.setIdescuela(res.getInt(38));
                esc.setNombre(res.getString(39));
                mat.setEscuela(esc);
                mat.setDiaEgr(res.getFloat(40));
                mat.setMesEgr(res.getFloat(41));
                mat.setAnioEgr(res.getFloat(42));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(43));
                titulo.setAbreviacion(res.getString(44));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(45));
                mat.setExiste(res.getString(46));
                mat.setTelefonoParticular(res.getString(47));
                mat.setTelefonoCelular(res.getString(48));
                
                co.add(mat);
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
        this.cerrar();
        return co;
    }
    
     public Collection getMatriculado(String apellido, int nada)
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery(" select * from matxapellido3('S','"+apellido+"%')");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
               Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                mat.setMatricula(res.getInt(2));
                mat.setApellido(res.getString(3));
                mat.setNombres(res.getString(4));
                mat.setDni(res.getString(5));
                mat.setCalle(res.getString(6));
                mat.setDiaNac(res.getFloat(7));
                mat.setMesNac(res.getFloat(8));
                mat.setAnioNac(res.getFloat(9));
                mat.setEmail(res.getString(10));
                mat.setTelefonoTrabajo(res.getString(11));
                mat.setWeb(res.getString(12));
                mat.setCuit(res.getString(13));
                mat.setCuil(res.getString(14));
                mat.setHabilitado(res.getString(15));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(res.getInt(16));
                barrio.setNombre(res.getString(17));
                mat.setBarrio(barrio);
                Provincia prov = new Provincia();
                prov.setIdprovincia(res.getInt(18));
                prov.setNombre(res.getString(19));
                mat.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(res.getInt(20));
                dep.setNombre(res.getString(21));
                mat.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(res.getInt(22));
                loc.setNombre(res.getString(23));
                mat.setLocalidad(loc);
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(res.getInt(24));
                nac.setNombre(res.getString(25));
                mat.setNacionalidad(nac);
                Departamento depprof = new Departamento();
                depprof.setIddepartamento(res.getInt(26));
                depprof.setNombre(res.getString(27));
                mat.setDepartamentoProfesional(depprof);
                Localidad locprof = new Localidad();
                locprof.setIdlocalidad(res.getInt(28));
                locprof.setNombre(res.getString(29));
                mat.setLocalidadProfesional(locprof);
                Barrio barrioprof = new Barrio();
                barrioprof.setIdbarrio(res.getInt(30));
                barrioprof.setNombre(res.getString(31));
                mat.setBarrioProfesional(barrioprof);
                mat.setCalleProfesional(res.getString(32));
                mat.setDiaIns(res.getFloat(33));
                mat.setMesIns(res.getFloat(34));
                mat.setAnioIns(res.getFloat(35));
                mat.setLibro(res.getString(36));
                mat.setFolio(res.getString(37));
                Escuela esc = new Escuela();
                esc.setIdescuela(res.getInt(38));
                esc.setNombre(res.getString(39));
                mat.setEscuela(esc);
                mat.setDiaEgr(res.getFloat(40));
                mat.setMesEgr(res.getFloat(41));
                mat.setAnioEgr(res.getFloat(42));
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(res.getInt(43));
                titulo.setAbreviacion(res.getString(44));
                mat.setTitulo(titulo);
                mat.setEspecialidad(res.getString(45));
                mat.setExiste(res.getString(46));
                mat.setTelefonoParticular(res.getString(47));
                mat.setTelefonoCelular(res.getString(48));
                
                co.add(mat);
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
        this.cerrar();
        return co;
    } 
   
    public Long getMatricula()
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery("select (max(m.idmatriculado)+1) as nuevocodigo from matriculados m");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        long respuesta = 0;   
        
        try
        {
           res.next();
           if (res.getLong(1)==0){ //si es una nueva serie y nohay constancias entonces
                respuesta = 1;
            }else{
                respuesta = res.getLong(1);
            } 
           
//           System.out.println("El CODIGO OBTENIDO DE MATRICULA ES: "+respuesta);
        }
        catch(SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        this.cerrar();
        return respuesta;
    }  
           
    public Collection getTodoMatriculado()
    {
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery("SELECT idmatriculado FROM Matriculados"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (res.next())
            {
                Matriculado mat = new Matriculado();
                mat.setIdmatriculado(res.getInt(1));
                co.add(mat);
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
        this.cerrar();
        return co;
    }

    public Collection getBarrio()
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;
      try 
      { 
        connec = super.getConection();      
        stmte = connec.createStatement(); 
        resul = stmte.executeQuery("SELECT Barrios.idbarrio, Barrios.nombre, Barrios.idlocalidad, Barrios.existe, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Barrios, Localidades, Departamentos, Provincias WHERE Barrios.existe = 'S'"+ 
        "AND Barrios.idlocalidad = Localidades.idlocalidad AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Barrios.nombre"); 
      }
      catch (SQLException ex)
      {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
     Collection co = new ArrayList();   
    try
    {
     while (resul.next())
     {
         Barrio barrio = new Barrio();
         barrio.setIdbarrio(resul.getInt(1));
         barrio.setNombre(resul.getString(2));
         barrio.setExiste(resul.getString(4));
         
         
         Localidad loc = new Localidad();
         loc.setIdlocalidad(resul.getInt(3));
         loc.setNombre(resul.getString(5));
         loc.setExiste(resul.getString(7));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resul.getInt(6));
         dep.setNombre(resul.getString(8));
         dep.setExiste(resul.getString(10));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resul.getInt(9));
         prov.setNombre(resul.getString(11));
         prov.setExiste(resul.getString(12));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         barrio.setLocalidad(loc);
         
         co.add(barrio);
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
     return co;
    }
    
    public Barrio getBarrioxNom(String nomBar,String nomLoc,String nomDep)
    {
       ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;
        Barrio barrio = new Barrio();
      try 
      { 
        connec = super.getConection();      
        stmte = connec.createStatement(); 
        resul = stmte.executeQuery("SELECT Barrios.idbarrio, Barrios.nombre, Barrios.idlocalidad, Barrios.existe, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Barrios, Localidades, Departamentos, Provincias WHERE Barrios.existe = 'S' AND Barrios.nombre = '"+nomBar+"' AND Localidades.nombre = '"+nomLoc+"' AND Departamentos.nombre = '"+nomDep+"'"+
        " AND Barrios.idlocalidad = Localidades.idlocalidad AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Barrios.nombre"); 
        
    }
     catch (SQLException ex)
     {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
     Collection co = new ArrayList();   
    try
    {
     while (resul.next())
     {                
         barrio.setIdbarrio(resul.getInt(1));
         barrio.setNombre(resul.getString(2));
         barrio.setExiste(resul.getString(4));
         
         
         Localidad loc = new Localidad();
         loc.setIdlocalidad(resul.getInt(3));
         loc.setNombre(resul.getString(5));
         loc.setExiste(resul.getString(7));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resul.getInt(6));
         dep.setNombre(resul.getString(8));
         dep.setExiste(resul.getString(10));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resul.getInt(9));
         prov.setNombre(resul.getString(11));
         prov.setExiste(resul.getString(12));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         barrio.setLocalidad(loc);
         
         co.add(barrio);
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
     return barrio;
    } 
    
    public Collection getBarrioxLoc(int idLoc)
    {
       ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;
      try 
      { 
        connec = super.getConection();      
        stmte = connec.createStatement(); 
        resul = stmte.executeQuery("SELECT Barrios.idbarrio, Barrios.nombre, Barrios.idlocalidad, Barrios.existe, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Barrios, Localidades, Departamentos, Provincias WHERE Barrios.existe = 'S' AND Barrios.idLocalidad = '"+idLoc+"'"+ 
        "AND Barrios.idlocalidad = Localidades.idlocalidad AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Barrios.nombre"); 
      }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
     Collection co = new ArrayList();   
    try
    {
     while (resul.next())
     {
         Barrio barrio = new Barrio();
         barrio.setIdbarrio(resul.getInt(1));
         barrio.setNombre(resul.getString(2));
         barrio.setExiste(resul.getString(4));
         
         
         Localidad loc = new Localidad();
         loc.setIdlocalidad(resul.getInt(3));
         loc.setNombre(resul.getString(5));
         loc.setExiste(resul.getString(7));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resul.getInt(6));
         dep.setNombre(resul.getString(8));
         dep.setExiste(resul.getString(10));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resul.getInt(9));
         prov.setNombre(resul.getString(11));
         prov.setExiste(resul.getString(12));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         barrio.setLocalidad(loc);
         
         co.add(barrio);
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
     return co;
    } 
    
    public Collection getBarrio(String nombre)
    {
       ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;
      try 
      { 
        connec = super.getConection();      
        stmte = connec.createStatement(); 
        resul = stmte.executeQuery("SELECT Barrios.idbarrio, Barrios.nombre, Barrios.idlocalidad, Barrios.existe, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Barrios, Localidades, Departamentos, Provincias WHERE Barrios.existe = 'S' AND Barrios.nombre LIKE '"+nombre+"%'"+ 
        "AND Barrios.idlocalidad = Localidades.idlocalidad AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Barrios.nombre"); 
     }
     catch (SQLException ex)
     {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
     Collection co = new ArrayList();   
    try
    {
     while (resul.next())
     {
         Barrio barrio = new Barrio();
         barrio.setIdbarrio(resul.getInt(1));
         barrio.setNombre(resul.getString(2));
         barrio.setExiste(resul.getString(4));
         
         
         Localidad loc = new Localidad();
         loc.setIdlocalidad(resul.getInt(3));
         loc.setNombre(resul.getString(5));
         loc.setExiste(resul.getString(7));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resul.getInt(6));
         dep.setNombre(resul.getString(8));
         dep.setExiste(resul.getString(10));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resul.getInt(9));
         prov.setNombre(resul.getString(11));
         prov.setExiste(resul.getString(12));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         barrio.setLocalidad(loc);
         
         co.add(barrio);
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
     return co;
    } 
       
    public Collection getTodoBarrio()
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement(); 
            resul = stmte.executeQuery("SELECT Barrios.idbarrio FROM Barrios"); 
        
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resul.next())
            {
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(resul.getInt(1));
                co.add(barrio);
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
     return co;
    }
       
    public Collection getLocalidad()
    {
     ResultSet resu = null;
     Statement stmte = null;
     Connection conne = null;
      try 
      { 
      conne = super.getConection();      
      stmte = conne.createStatement();  
      resu = stmte.executeQuery("SELECT Localidades.idlocalidad, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Localidades, Departamentos, Provincias WHERE Localidades.existe = 'S'"+ 
        "AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Localidades.nombre"); 
    }
     catch (SQLException ex)
     {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
    Collection co = new ArrayList();   
     try
    {
     while (resu.next())
     {
         Localidad loc = new Localidad();
         loc.setIdlocalidad(resu.getInt(1));
         loc.setNombre(resu.getString(2));
         loc.setExiste(resu.getString(4));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resu.getInt(3));
         dep.setNombre(resu.getString(5));
         dep.setExiste(resu.getString(7));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resu.getInt(6));
         prov.setNombre(resu.getString(8));
         prov.setExiste(resu.getString(9));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         
         co.add(loc);
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
    
    public Localidad getLocalidadxNom(String nombreLocalidad,String nombreDepartamento)
    {
//     Localidad localidad=new Localidad();
     
     ResultSet resu = null;
     Statement stmte = null;
     Connection conne = null;
     Localidad loc = new Localidad();
     
      try 
      { 
      conne = super.getConection();      
      stmte = conne.createStatement();  
      resu = stmte.executeQuery("SELECT Localidades.idlocalidad, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Localidades, Departamentos, Provincias WHERE Localidades.existe = 'S'"+ 
        "AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia AND localidades.nombre = '"+nombreLocalidad+"' AND departamentos.nombre = '"+nombreDepartamento+"'"); 
    }
     catch (SQLException ex)
     {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
    Collection co = new ArrayList();   
     try
    {
     while (resu.next())
     {
         
         loc.setIdlocalidad(resu.getInt(1));
         loc.setNombre(resu.getString(2));
         loc.setExiste(resu.getString(4));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resu.getInt(3));
         dep.setNombre(resu.getString(5));
         dep.setExiste(resu.getString(7));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resu.getInt(6));
         prov.setNombre(resu.getString(8));
         prov.setExiste(resu.getString(9));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         
         co.add(loc);
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
     return loc;
     
    }
    
    public Collection getLocalidadxDep(int iddep)
    {
     ResultSet resu = null;
     Statement stmte = null;
     Connection conne = null;
      try 
      { 
      conne = super.getConection();      
      stmte = conne.createStatement();  
      resu = stmte.executeQuery("SELECT Localidades.idlocalidad, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Localidades, Departamentos, Provincias WHERE Localidades.existe = 'S'"+ 
        "AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia AND localidades.iddepartamento = "+iddep+" ORDER BY Localidades.nombre"); 
    }
     catch (SQLException ex)
     {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
    Collection co = new ArrayList();   
     try
    {
     while (resu.next())
     {
         Localidad loc = new Localidad();
         loc.setIdlocalidad(resu.getInt(1));
         loc.setNombre(resu.getString(2));
         loc.setExiste(resu.getString(4));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resu.getInt(3));
         dep.setNombre(resu.getString(5));
         dep.setExiste(resu.getString(7));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resu.getInt(6));
         prov.setNombre(resu.getString(8));
         prov.setExiste(resu.getString(9));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         
         co.add(loc);
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
    
    public Collection getLocalidad(String nombre)
    {
      ResultSet resu = null;
     Statement stmte = null;
     Connection conne = null;
      try 
      { 
      conne = super.getConection();      
      stmte = conne.createStatement();  
      resu = stmte.executeQuery("SELECT Localidades.idlocalidad, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Localidades, Departamentos, Provincias WHERE Localidades.existe = 'S' AND Localidades.nombre LIKE '"+nombre+"%'"+  
        "AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Localidades.nombre"); 
    }
     catch (SQLException ex)
     {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
    Collection co = new ArrayList();   
     try
    {
     while (resu.next())
     {
         Localidad loc = new Localidad();
         loc.setIdlocalidad(resu.getInt(1));
         loc.setNombre(resu.getString(2));
         loc.setExiste(resu.getString(4));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resu.getInt(3));
         dep.setNombre(resu.getString(5));
         dep.setExiste(resu.getString(7));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resu.getInt(6));
         prov.setNombre(resu.getString(8));
         prov.setExiste(resu.getString(9));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         
         co.add(loc);
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
    
    public Localidad geIdLocalidad(String nombre)
    {
     ResultSet resu = null;
     Statement stmte = null;
     Connection conne = null;
     Localidad loc = new Localidad();
      try 
      { 
      conne = super.getConection();      
      stmte = conne.createStatement();  
      resu = stmte.executeQuery("SELECT Localidades.idlocalidad, Localidades.nombre, Localidades.iddepartamento,Localidades.existe, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Localidades, Departamentos, Provincias WHERE Localidades.existe = 'S' AND Localidades.nombre = '"+nombre+"'"+  
        "AND Localidades.iddepartamento = Departamentos.iddepartamento AND Departamentos.idprovincia = Provincias.idprovincia"); 
    }
     catch (SQLException ex)
     {
        while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     } 
    Collection co = new ArrayList();   
     try
    {
     while (resu.next())
     {
         
         loc.setIdlocalidad(resu.getInt(1));
         loc.setNombre(resu.getString(2));
         loc.setExiste(resu.getString(4));
         
         Departamento dep = new Departamento();
         dep.setIddepartamento(resu.getInt(3));
         dep.setNombre(resu.getString(5));
         dep.setExiste(resu.getString(7));
         
         Provincia prov = new Provincia();
         prov.setIdprovincia(resu.getInt(6));
         prov.setNombre(resu.getString(8));
         prov.setExiste(resu.getString(9));
         
         dep.setProvincia(prov);
         loc.setDepartamento(dep);
         
         co.add(loc);
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
     return loc;
    } 
     
    public Collection getTodoLocalidad()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT Localidades.idlocalidad FROM Localidades"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(1));
                co.add(loc);
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
         
    public Collection getProvincia()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idprovincia, nombre, existe FROM Provincias WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(1));
                prov.setNombre(resu.getString(2));
                prov.setExiste(resu.getString(3));
                co.add(prov);
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
    
    public Collection getProvincia(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idprovincia, nombre, existe FROM Provincias WHERE existe = 'S'AND Provincias.nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(1));
                prov.setNombre(resu.getString(2));
                prov.setExiste(resu.getString(3));
                co.add(prov);
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
    
    public Provincia getIdProvincia(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        Provincia prov=new Provincia();
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idprovincia, nombre, existe FROM Provincias WHERE existe = 'S'AND Provincias.nombre = '"+nombre+"'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                prov.setIdprovincia(resu.getInt(1));
                prov.setNombre(resu.getString(2));
                prov.setExiste(resu.getString(3));
                co.add(prov);
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
        return prov;     
    }
    
    public Collection getTodoProvincia()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idprovincia FROM Provincias"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(1));
                co.add(prov);
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
      
    public Collection getDepartamento()
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT Departamentos.iddepartamento, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Departamentos, Provincias WHERE Departamentos.existe = 'S'"+ 
            "AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Departamentos.nombre"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();  
        try
        {
            while (resul.next())
            {
                Departamento dep = new Departamento();
                dep.setIddepartamento(resul.getInt(1));
                dep.setNombre(resul.getString(2));
                dep.setExiste(resul.getString(4));
                
                Provincia prov = new Provincia();
                prov.setIdprovincia(resul.getInt(3));
                prov.setNombre(resul.getString(5));
                prov.setExiste(resul.getString(6));
                
                dep.setProvincia(prov);
                
                co.add(dep);
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
        return co;
    }
    
    public Collection getDepartamentoxProv(int idprov)
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT Departamentos.iddepartamento, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Departamentos, Provincias WHERE Departamentos.existe = 'S'"+ 
            "AND Departamentos.idprovincia = Provincias.idprovincia AND provincias.idprovincia = "+idprov+" ORDER BY Departamentos.nombre"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();  
        try
        {
            while (resul.next())
            {
                Departamento dep = new Departamento();
                dep.setIddepartamento(resul.getInt(1));
                dep.setNombre(resul.getString(2));
                dep.setExiste(resul.getString(4));
                
                Provincia prov = new Provincia();
                prov.setIdprovincia(resul.getInt(3));
                prov.setNombre(resul.getString(5));
                prov.setExiste(resul.getString(6));
                
                dep.setProvincia(prov);
                
                co.add(dep);
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
        return co;
    }
    
    public Collection getDepartamento(String nombre)
    {
       ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT Departamentos.iddepartamento, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Departamentos, Provincias WHERE Departamentos.existe = 'S'AND Departamentos.nombre LIKE '"+nombre+"%'"+
            "AND Departamentos.idprovincia = Provincias.idprovincia ORDER BY Departamentos.nombre"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();  
        try
        {
            while (resul.next())
            {
                Departamento dep = new Departamento();
                dep.setIddepartamento(resul.getInt(1));
                dep.setNombre(resul.getString(2));
                dep.setExiste(resul.getString(4));
                
                Provincia prov = new Provincia();
                prov.setIdprovincia(resul.getInt(3));
                prov.setNombre(resul.getString(5));
                prov.setExiste(resul.getString(6));
                
                dep.setProvincia(prov);
                
                co.add(dep);
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
        return co;
    }
   
   public Departamento getIdDepartamento(String nombre)
    {
       ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;
        Departamento dep = new Departamento();
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT Departamentos.iddepartamento, Departamentos.nombre, Departamentos.idprovincia, Departamentos.existe, Provincias.nombre, Provincias.existe FROM Departamentos, Provincias WHERE Departamentos.existe = 'S'AND Departamentos.nombre = '"+nombre+"'"+
            "AND Departamentos.idprovincia = Provincias.idprovincia"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();  
        try
        {
            while (resul.next())
            {
                dep.setIddepartamento(resul.getInt(1));
                dep.setNombre(resul.getString(2));
                dep.setExiste(resul.getString(4));
                
                Provincia prov = new Provincia();
                prov.setIdprovincia(resul.getInt(3));
                prov.setNombre(resul.getString(5));
                prov.setExiste(resul.getString(6));
                
                dep.setProvincia(prov);
                
                co.add(dep);
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
        return dep;
    }
    
   public Collection getTodoDepartamento()
    {
        ResultSet resul = null;
        Statement stmte = null;
        Connection connec = null;  
        try 
        { 
            connec = super.getConection();      
            stmte = connec.createStatement();  
            resul = stmte.executeQuery("SELECT Departamentos.iddepartamento FROM Departamentos"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();  
        try
        {
            while (resul.next())
            {
                Departamento dep = new Departamento();
                dep.setIddepartamento(resul.getInt(1));
                co.add(dep);
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
        return co;
    }
    
    public Collection getRol()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idrol, nombre, existe FROM Roles WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Rol rol = new Rol();
                rol.setIdrol(resu.getInt(1));
                rol.setNombre(resu.getString(2));
                rol.setExiste(resu.getString(3));
                co.add(rol);
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
    
    public Collection getRol(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idrol, nombre, existe FROM Roles WHERE existe = 'S' AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Rol rol = new Rol();
                rol.setIdrol(resu.getInt(1));
                rol.setNombre(resu.getString(2));
                rol.setExiste(resu.getString(3));
                co.add(rol);
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
    
    public Collection getTodoRol()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idrol FROM Roles"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Rol rol = new Rol();
                rol.setIdrol(resu.getInt(1));
                co.add(rol);
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
          
    public Collection getTitulo()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtitulo, nombre, abreviacion, existe FROM Titulos WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(resu.getInt(1));
                titulo.setNombre(resu.getString(2));
                titulo.setAbreviacion(resu.getString(3));
                titulo.setExiste(resu.getString(4));
                co.add(titulo);
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
    
    public Collection getTitulo(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtitulo, nombre, abreviacion, existe FROM Titulos WHERE existe = 'S' AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(resu.getInt(1));
                titulo.setNombre(resu.getString(2));
                titulo.setAbreviacion(resu.getString(3));
                titulo.setExiste(resu.getString(4));
                co.add(titulo);
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
    
    public Titulo getTitulo(int id)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        Titulo titulo = new Titulo();
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtitulo, nombre FROM Titulos WHERE existe = 'S' AND idtitulo = "+String.valueOf(id)); 
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
                titulo.setIdtitulo(resu.getInt(1));
                titulo.setNombre(resu.getString(2));
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
        return titulo;        
    } 
    
    public Collection getTodoTitulo()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtitulo FROM Titulos"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Titulo titulo = new Titulo();
                titulo.setIdtitulo(resu.getInt(1));
                co.add(titulo);
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
    
    public Collection getEntidadExterna()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT identidadexterna, nombre, existe FROM entidadesExternas WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EntidadExterna ee = new EntidadExterna();
                ee.setIdentidadExterna(resu.getInt(1));
                ee.setNombre(resu.getString(2));
                ee.setExiste(resu.getString(3));
                co.add(ee);
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
    
    public Collection getEntidadExterna(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT identidadexterna, nombre, existe FROM entidadesExternas WHERE existe = 'S' AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EntidadExterna ee = new EntidadExterna();
                ee.setIdentidadExterna(resu.getInt(1));
                ee.setNombre(resu.getString(2));
                ee.setExiste(resu.getString(3));
                co.add(ee);
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
    
public Collection getTodoEntidadExterna()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT identidadexterna FROM entidadesExternas"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EntidadExterna ee = new EntidadExterna();
                ee.setIdentidadExterna(resu.getInt(1));
                co.add(ee);
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
    
    public Collection getEscuela()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT Escuelas.idescuela, Escuelas.nombre, Escuelas.direccion, Escuelas.telefono, Escuelas.mail, Escuelas.fax, Escuelas.idprovincia,Provincias.nombre, Escuelas.iddepartamento, Departamentos.nombre, Escuelas.idlocalidad, Localidades.nombre, Escuelas.codigopostal, Escuelas.existe FROM escuelas, provincias, departamentos, localidades WHERE Escuelas.existe = 'S'"+ 
            "AND Escuelas.idprovincia = Provincias.idprovincia AND Escuelas.iddepartamento = Departamentos.iddepartamento AND Escuelas.idlocalidad = Localidades.idlocalidad");
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Escuela esc = new Escuela();
                esc.setIdescuela(resu.getInt(1));
                esc.setNombre(resu.getString(2));
                esc.setDireccion(resu.getString(3));
                esc.setTelefono(resu.getString(4));
                esc.setMail(resu.getString(5));
                esc.setFax(resu.getString(6));
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(7));
                prov.setNombre(resu.getString(8));
                esc.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(9));
                dep.setNombre(resu.getString(10));
                esc.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(11));
                loc.setNombre(resu.getString(12));
                esc.setLocalidad(loc);
                esc.setCodigoPostal(resu.getString(13));
                esc.setExiste(resu.getString(14));
                co.add(esc);
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
    
    public Collection getEscuela(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
             resu = stmte.executeQuery("SELECT Escuelas.idescuela, Escuelas.nombre, Escuelas.direccion, Escuelas.telefono, Escuelas.mail, Escuelas.fax, Escuelas.idprovincia,Provincias.nombre, Escuelas.iddepartamento, Departamentos.nombre, Escuelas.idlocalidad, Localidades.nombre, Escuelas.codigopostal, Escuelas.existe FROM escuelas, provincias, departamentos, localidades WHERE Escuelas.existe = 'S'"+ 
            "AND Escuelas.idprovincia = Provincias.idprovincia AND Escuelas.iddepartamento = Departamentos.iddepartamento AND Escuelas.idlocalidad = Localidades.idlocalidad AND Escuelas.nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Escuela esc = new Escuela();
                esc.setIdescuela(resu.getInt(1));
                esc.setNombre(resu.getString(2));
                esc.setDireccion(resu.getString(3));
                esc.setTelefono(resu.getString(4));
                esc.setMail(resu.getString(5));
                esc.setFax(resu.getString(6));
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(7));
                prov.setNombre(resu.getString(8));
                esc.setProvincia(prov);
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(9));
                dep.setNombre(resu.getString(10));
                esc.setDepartamento(dep);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(11));
                loc.setNombre(resu.getString(12));
                esc.setLocalidad(loc);
                esc.setCodigoPostal(resu.getString(13));
                esc.setExiste(resu.getString(14));
                co.add(esc);
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
    
    public Collection getTodoEscuela()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idescuela FROM escuelas"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Escuela esc = new Escuela();
                esc.setIdescuela(resu.getInt(1));
                co.add(esc);
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
    
   public Collection getNacionalidad()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idnacionalidad, nombre, existe FROM Nacionalidades WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(resu.getInt(1));
                nac.setNombre(resu.getString(2));
                nac.setExiste(resu.getString(3));
                co.add(nac);
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
    
    public Collection getNacionalidad(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idnacionalidad, nombre, existe FROM Nacionalidades WHERE existe = 'S' AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(resu.getInt(1));
                nac.setNombre(resu.getString(2));
                nac.setExiste(resu.getString(3));
                co.add(nac);
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
    
    public Collection getTodoNacionalidad()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idnacionalidad FROM Nacionalidades"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Nacionalidad nac = new Nacionalidad();
                nac.setIdnacionalidad(resu.getInt(1));
                co.add(nac);
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
    public Collection getProducto()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idproducto, denominacion, precio, existe FROM Productos WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Producto prod = new Producto();
                prod.setIdproducto(resu.getInt(1));
                prod.setDenominacion(resu.getString(2));
                prod.setPrecio(resu.getDouble(3));
                prod.setExiste(resu.getString(4));
                co.add(prod);
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
    
    public int getProductoExiste(Producto produc)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idproducto FROM Productos WHERE idproducto = "+produc.getIdproducto()); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Producto prod = new Producto();
                prod.setIdproducto(resu.getInt(1));
//                System.out.println("cargo un elemento a la coleccion producto");
                co.add(prod);
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
       return co.size();        
    } 
    
    public Collection getProducto(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idproducto, denominacion, precio, existe FROM Productos WHERE existe = 'S' AND denominacion LIKE'"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Producto prod = new Producto();
                prod.setIdproducto(resu.getInt(1));
                prod.setDenominacion(resu.getString(2));
                prod.setPrecio(resu.getDouble(3));
                prod.setExiste(resu.getString(4));
                co.add(prod);
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
    
    public Producto getProducto(int idproducto)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        Producto prod = new Producto();
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idproducto, denominacion, precio, existe FROM Productos WHERE existe = 'S' AND idproducto  = "+idproducto); 
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
            resu.next();
            prod.setIdproducto(resu.getInt(1));
            prod.setDenominacion(resu.getString(2));
            prod.setPrecio(resu.getDouble(3));
            prod.setExiste(resu.getString(4));
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
        return prod;        
    } 
    
    public Collection getTodoProducto()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idproducto FROM Productos"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Producto prod = new Producto();
                prod.setIdproducto(resu.getInt(1));
                co.add(prod);
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
    
    public Collection getTasa()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtasa, denominacion, indice, tasaminima, observacion, existe FROM Tasas WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Tasa tasa = new Tasa();
                tasa.setIdtasa(resu.getInt(1));
                tasa.setDenominacion(resu.getString(2));
                tasa.setIndice(resu.getDouble(3));
                tasa.setTasaMinima(resu.getDouble(4));
                tasa.setObservacion(resu.getString(5));
                tasa.setExiste(resu.getString(6));
                co.add(tasa);
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
    
    public Collection getTasa(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtasa, denominacion, indice, tasaminima, observacion, existe FROM Tasas WHERE existe = 'S' AND denominacion LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Tasa tasa = new Tasa();
                tasa.setIdtasa(resu.getInt(1));
                tasa.setDenominacion(resu.getString(2));
                tasa.setIndice(resu.getDouble(3));
                tasa.setTasaMinima(resu.getDouble(4));
                tasa.setObservacion(resu.getString(5));
                tasa.setExiste(resu.getString(6));
                co.add(tasa);
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
    
 public Collection getTodoTasa()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtasa FROM Tasas"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Tasa tasa = new Tasa();
                tasa.setIdtasa(resu.getInt(1));
                co.add(tasa);
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
       
    public Collection getTipoSeccion()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtipoSeccion, nombre, existe FROM TipoSecciones WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoSeccion tsec = new TipoSeccion();
                tsec.setIdtipoSeccion(resu.getInt(1));
                tsec.setNombre(resu.getString(2));
                tsec.setExiste(resu.getString(3));
                co.add(tsec);
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
    
    public Collection getTipoSeccion(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtipoSeccion, nombre, existe FROM TipoSecciones WHERE existe = 'S' AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoSeccion tsec = new TipoSeccion();
                tsec.setIdtipoSeccion(resu.getInt(1));
                tsec.setNombre(resu.getString(2));
                tsec.setExiste(resu.getString(3));
                co.add(tsec);
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
    
    public Collection getTodoTipoSeccion()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtipoSeccion FROM TipoSecciones"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoSeccion tsec = new TipoSeccion();
                tsec.setIdtipoSeccion(resu.getInt(1));
                co.add(tsec);
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
    
    public Collection getTipoTrabajo()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtipoTrabajo, nombre, leyenda, existe FROM tipotrabajos WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoTrabajo ttrab = new TipoTrabajo();
                ttrab.setIdtipoTrabajo(resu.getInt(1));
                ttrab.setNombre(resu.getString(2));
                ttrab.setLeyenda(resu.getString(3));
                ttrab.setExiste(resu.getString(4));
                co.add(ttrab);
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
    
    public Collection getTipoTrabajo(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtipoTrabajo, nombre, leyenda, existe FROM tipotrabajos WHERE existe = 'S' AND nombre LIKE'"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoTrabajo ttrab = new TipoTrabajo();
                ttrab.setIdtipoTrabajo(resu.getInt(1));
                ttrab.setNombre(resu.getString(2));
                ttrab.setLeyenda(resu.getString(3));
                ttrab.setExiste(resu.getString(4));
                co.add(ttrab);
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
    
    public Collection getTodoTipoTrabajo()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtipoTrabajo FROM tipotrabajos"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoTrabajo ttrab = new TipoTrabajo();
                ttrab.setIdtipoTrabajo(resu.getInt(1));
                co.add(ttrab);
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
    
    public Collection getTipoSuperficie()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtiposuperficie, nombre, modificador, existe FROM tiposuperficies WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(1));
                tsuper.setNombre(resu.getString(2));
                tsuper.setModificador(resu.getDouble(3));
                tsuper.setExiste(resu.getString(4));
                co.add(tsuper);
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
    
    public Collection getTipoSuperficie(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtiposuperficie, nombre, modificador, existe FROM tiposuperficies WHERE existe = 'S' AND nombre LIKE'"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(1));
                tsuper.setNombre(resu.getString(2));
                tsuper.setModificador(resu.getDouble(3));
                tsuper.setExiste(resu.getString(4));
                co.add(tsuper);
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
    
public Collection getTodoTipoSuperficie()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idtipoSuperficie FROM tiposuperficies"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                TipoSuperficie tsuper = new TipoSuperficie();
                tsuper.setIdtipoSuperficie(resu.getInt(1));
                co.add(tsuper);
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
    
    public Collection getEmpresa()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT empresa.idempresa, empresa.nombre, empresa.titular, empresa.direccion, empresa.telefono, empresa.fax, empresa.codigopostal, empresa.idprovincia, provincias.nombre, empresa.idlocalidad, localidades.nombre, empresa.iddepartamento, departamentos.nombre, empresa.cuit, empresa.ingresosbrutos, empresa.inicioactividades, empresa.idiva, iva.nombre, empresa.existe, empresa.idbarrio, barrios.nombre FROM empresa, provincias, departamentos,localidades, barrios, iva WHERE empresa.existe = 'S'" +
            "AND empresa.idbarrio = barrios.idbarrio AND empresa.idlocalidad = localidades.idlocalidad AND empresa.iddepartamento = departamentos.iddepartamento AND empresa.idprovincia = provincias.idprovincia AND empresa.idiva = iva.idiva"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Empresa emp = new Empresa();
                emp.setIdempresa(resu.getInt(1));
                emp.setNombre(resu.getString(2));
                emp.setTitular(resu.getString(3));
                emp.setDireccion(resu.getString(4));
                emp.setTelefono(resu.getString(5));
                emp.setFax(resu.getString(6));
                emp.setCodigoPostal(resu.getString(7));
                
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(8));
                prov.setNombre(resu.getString(9));
                emp.setProvincia(prov);
                
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(10));
                loc.setNombre(resu.getString(11));
                emp.setLocalidad(loc);
                
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(12));
                dep.setNombre(resu.getString(13));
                emp.setDepartamento(dep);
                
                emp.setCuit(resu.getString(14));
                
                emp.setIngresosBrutos(resu.getString(15));
                emp.setInicioActividades(resu.getString(16));
                Iva iva = new Iva();
                iva.setIdiva(resu.getInt(17));
                iva.setNombre(resu.getString(18));
                emp.setIva(iva);
                emp.setExiste(resu.getString(19));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(resu.getInt(20));
                barrio.setNombre(resu.getString(21));
                emp.setBarrio(barrio);
                co.add(emp);
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

    public Collection getEmpresa(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT empresa.idempresa, empresa.nombre, empresa.titular, empresa.direccion, empresa.telefono, empresa.fax, empresa.codigopostal, empresa.idprovincia, provincias.nombre, empresa.idlocalidad, localidades.nombre, empresa.iddepartamento, departamentos.nombre, empresa.cuit, empresa.ingresosbrutos, empresa.inicioactividades, empresa.idiva, iva.nombre, empresa.existe, empresa.idbarrio, barrios.nombre FROM empresa, provincias, departamentos,localidades, barrios, iva WHERE empresa.existe = 'S'" +
            "AND empresa.idbarrio = barrios.idbarrio AND empresa.idlocalidad = localidades.idlocalidad AND empresa.iddepartamento = departamentos.iddepartamento AND empresa.idprovincia = provincias.idprovincia AND empresa.idiva = iva.idiva AND empresa.nombre LIKE '"+nombre+"%'");
        }
            catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Empresa emp = new Empresa();
                emp.setIdempresa(resu.getInt(1));
                emp.setNombre(resu.getString(2));
                emp.setTitular(resu.getString(3));
                emp.setDireccion(resu.getString(4));
                emp.setTelefono(resu.getString(5));
                emp.setFax(resu.getString(6));
                emp.setCodigoPostal(resu.getString(7));
                Provincia prov = new Provincia();
                prov.setIdprovincia(resu.getInt(8));
                prov.setNombre(resu.getString(9));
                emp.setProvincia(prov);
                Localidad loc = new Localidad();
                loc.setIdlocalidad(resu.getInt(10));
                loc.setNombre(resu.getString(11));
                emp.setLocalidad(loc);
                Departamento dep = new Departamento();
                dep.setIddepartamento(resu.getInt(12));
                dep.setNombre(resu.getString(13));
                emp.setDepartamento(dep);
                emp.setCuit(resu.getString(14));
                
                emp.setIngresosBrutos(resu.getString(15));
                emp.setInicioActividades(resu.getString(16));
                Iva iva = new Iva();
                iva.setIdiva(resu.getInt(17));
                iva.setNombre(resu.getString(18));
                emp.setIva(iva);
                emp.setExiste(resu.getString(19));
                Barrio barrio = new Barrio();
                barrio.setIdbarrio(resu.getInt(20));
                barrio.setNombre(resu.getString(21));
                emp.setBarrio(barrio);
                co.add(emp);
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
            
    public Collection getTodoEmpresa()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idempresa FROM empresa"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Empresa emp = new Empresa();
                emp.setIdempresa(resu.getInt(1));
                co.add(emp);
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
    
    public Collection getIva()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idiva, nombre, existe FROM iva WHERE existe = 'S'");  
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Iva iva = new Iva();
                iva.setIdiva(resu.getInt(1));
                iva.setNombre(resu.getString(2));
                iva.setExiste(resu.getString(3));
                co.add(iva);
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

public Collection getIva(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idiva, nombre, existe FROM iva WHERE existe = 'S' AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Iva iva = new Iva();
                iva.setIdiva(resu.getInt(1));
                iva.setNombre(resu.getString(2));
                iva.setExiste(resu.getString(3));
                co.add(iva);
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

    public Collection getTodoIva()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idiva FROM iva"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Iva iva = new Iva();
                iva.setIdiva(resu.getInt(1));
                co.add(iva);
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

    public Collection getCondicionVenta()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idcondicionventa, nombre, existe FROM condicionventa WHERE existe = 'S'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                CondicionVenta cventa = new CondicionVenta();
                cventa.setIdcondicionVenta(resu.getInt(1));
                cventa.setNombre(resu.getString(2));
                cventa.setExiste(resu.getString(3));
                co.add(cventa);
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
    
    public Collection getCondicionVenta(String nombre)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idcondicionventa, nombre, existe FROM condicionventa WHERE existe = 'S' AND nombre LIKE '"+nombre+"%'"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                CondicionVenta cventa = new CondicionVenta();
                cventa.setIdcondicionVenta(resu.getInt(1));
                cventa.setNombre(resu.getString(2));
                cventa.setExiste(resu.getString(3));
                co.add(cventa);
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
    
public Collection getTodoCondicionVenta()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT idcondicionventa FROM condicionventa"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                CondicionVenta cventa = new CondicionVenta();
                cventa.setIdcondicionVenta(resu.getInt(1));
                co.add(cventa);
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

    public Collection getEspecialidades()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT especialidad FROM especialidades_mat"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {                
                co.add(resu.getString(1));
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
    
    public boolean verificarNroConstancia(String numero, String serie)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        boolean bandera = true; // true significa que no hay numeros repetidos
        int contador = 0;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
                resu = stmte.executeQuery("SELECT codigocp FROM encabezadocp WHERE codigocp = "+numero+ " AND seriecp = '"+serie.trim()+"'"); 
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
                contador++;
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
        if(contador != 0)
            bandera = false;
        return bandera;        
    }
    
    public boolean verificarNroConstanciaTotal(String numero, String serie)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        boolean bandera = true; // true significa que no hay numeros repetidos
        int contador = 0;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
                resu = stmte.executeQuery("SELECT codigoct FROM encabezadoct WHERE codigoct = "+numero+ " AND seriect = '"+serie.trim()+"'"); 
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
                contador++;
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
        if(contador != 0)
            bandera = false;
        return bandera;        
    }
    public boolean verificarNroFactura(String numero, String serie)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        boolean bandera = true; // true significa que no hay numeros repetidos
        int contador = 0;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
                resu = stmte.executeQuery("SELECT numerofactura FROM encabezadofacturas WHERE numerofactura = "+numero+ " AND seriefactura = '"+serie.trim()+"'"); 
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
                contador++;
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
        if(contador != 0)
            bandera = false;
        return bandera;        
    }
public double getTotalFactura(long idcaja)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        double resultado = 0;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select (sum(e.total)) as total from encabezadofacturas e where e.idcaja='"+idcaja+"'"); 
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
            resu.next();
            if (resu.getDouble(1)==0){ //si es una nueva serie y nohay constancias entonces
                resultado=1;
            }else{
                resultado = resu.getDouble(1);
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
        return resultado;        
    }
    
    public Collection getCaja()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM listarcajas "); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Caja caja = new Caja();
                caja.setIdcaja(resu.getLong(1));
                caja.setFechaapertura(resu.getTimestamp(2));
                caja.setFechacierre(resu.getTimestamp(3));
                caja.setTotal(resu.getDouble(4));
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(5));
                user.setNombre(resu.getString(6));
                caja.setUsuariocierre(user);
                caja.setSaldoinicial(resu.getDouble(7));
                caja.setEstado(resu.getString(8));
                co.add(caja);
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
    public Collection getCajasTodas()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM listarcajas2 order by idcaja"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Caja caja = new Caja();
                caja.setIdcaja(resu.getLong(1));
                caja.setFechaapertura(resu.getTimestamp(2));
                caja.setFechacierre(resu.getTimestamp(3));
                caja.setTotal(resu.getDouble(4));
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(5));
                user.setNombre(resu.getString(6));
                caja.setUsuariocierre(user);
                caja.setSaldoinicial(resu.getDouble(7));
                caja.setEstado(resu.getString(8));
                co.add(caja);
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
    public Collection getUltimaCaja()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try{ 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select * from listarcajas2 where idcaja = (select max(idcaja) from cajas)"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                Caja caja = new Caja();
                caja.setIdcaja(resu.getLong(1));
                caja.setFechaapertura(resu.getTimestamp(2));
                caja.setFechacierre(resu.getTimestamp(3));
                caja.setTotal(resu.getDouble(4));
                Usuario user = new Usuario();
                user.setIdusuario(resu.getInt(5));
                user.setNombre(resu.getString(6));
                caja.setUsuariocierre(user);
                caja.setSaldoinicial(resu.getDouble(7));
                caja.setEstado(resu.getString(8));
                co.add(caja);
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
    private void cerrar(){
      try{
          res.close();
          stmt.close();
          conn.close();
      } catch(SQLException e){
          while (e != null){
             e.printStackTrace();
             e = e.getNextException();
          }         
      }      
    }
    public Producto getProducto(String codigo, String algo)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM obtenerProductos("+codigo.trim()+")"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Producto p = new Producto();
        try
        {
            while (resu.next())
            {
                
                p.setIdproducto(resu.getInt(1));
                p.setDenominacion(resu.getString(2));
                p.setPrecio(resu.getDouble(3));
                p.setExiste(resu.getString(4));
                
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
        return p;
    }
  public Collection getEncabezadoFactura(long idcaja)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encfacturasxseriexnro WHERE idcaja = "+idcaja+" ORDER BY idcaja, seriefactura, numerofactura"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EncabezadoFactura encf = new EncabezadoFactura();
                encf.setSerieFactura(resu.getInt(1));
                encf.setNumeroFactura(resu.getLong(2));
                encf.setIdempresa(resu.getInt(3));
                Caja caja = new Caja();
                caja.setIdcaja(resu.getLong(6));
                encf.setCaja(caja);
                encf.setFecha(resu.getTimestamp(7));
                CondicionVenta cond = new CondicionVenta();
                cond.setIdcondicionVenta(resu.getInt(8));
                cond.setNombre(resu.getString(9));
                encf.setCondicionVenta(cond);
                encf.setTotal(resu.getDouble(13));
                encf.setNombreCliente(resu.getString(17));
                encf.setAnulado(resu.getString(18));
                co.add(encf);
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
  public Collection getEncabezadoFacturaTodas()
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM encfacturasxseriexnro ORDER BY idcaja, seriefactura, numerofactura"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                EncabezadoFactura encf = new EncabezadoFactura();
                encf.setSerieFactura(resu.getInt(1));
                encf.setNumeroFactura(resu.getLong(2));
                encf.setIdempresa(resu.getInt(3));
                Caja caja = new Caja();
                caja.setIdcaja(resu.getLong(6));
                encf.setCaja(caja);
                encf.setFecha(resu.getTimestamp(7));
                CondicionVenta cond = new CondicionVenta();
                cond.setIdcondicionVenta(resu.getInt(8));
                cond.setNombre(resu.getString(9));
                encf.setCondicionVenta(cond);
                encf.setTotal(resu.getDouble(13));
                encf.setNombreCliente(resu.getString(17));
                encf.setAnulado(resu.getString(18));
                co.add(encf);
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
  public Collection getDetalleFactura(EncabezadoFactura ef)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("SELECT * FROM detallefacturas WHERE seriefactura = "+ef.getSerieFactura()+" AND numerofactura = "+ef.getNumeroFactura()+" ORDER BY iddetalle"); 
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } 
        Collection co = new ArrayList();   
        try
        {
            while (resu.next())
            {
                DetalleFactura detF = new DetalleFactura();
                detF.setSerieFactura(resu.getInt(1));
                detF.setNumeroFactura(resu.getLong(2));
                detF.setIddetalle(resu.getInt(3));
                
                Producto prod = new Producto();
                prod.setIdproducto(resu.getInt(4));
                prod.setDenominacion(resu.getString(5));                
                prod.setPrecio(resu.getDouble(9));
                detF.setProducto(prod);
                
                detF.setDetalle(resu.getString(6));
                detF.setCantidad(resu.getInt(7));
                detF.setSubTotal(resu.getDouble(8));
                
                co.add(detF);
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
//  public Collection getHistorialPagos(Integer mat)
//    {
//        ResultSet resu = null;
//        Statement stmte = null;
//        Connection conne = null;
//        try 
//        { 
//            conne = super.getConection();      
//            stmte = conne.createStatement();  
//            resu = stmte.executeQuery("select ep.idencabezadopago, ep.fechapago, ep.seriefactura,ep.nrofactura, dp.anio, dp.mes, dp.importe from encabezadopago ep,detallepago dp where ep.idencabezadopago=dp.idencabezadopago and ep.matricula = "+mat); 
//        }
//        catch (SQLException ex)
//        {
//            while (ex !=null)
//            {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } 
//        Collection co = new ArrayList();   
//        try
//        {
//            while (resu.next())
//            {
//                EncabezadoPago encPago = new EncabezadoPago();
//                encPago.setIdencabezado(resu.getLong(1));
//                encPago.setFechapago(resu.getTimestamp(2));
//                encPago.setSeriefactura(resu.getInt(3));
//                encPago.setNrofactura(resu.getLong(4));
//                
//                DetallePago detPago=new DetallePago();
//                detPago.setIdencabezadopago(resu.getLong(1));
//                detPago.setAnio(5);
//                detPago.setMes(6);
//                detPago.setImporte(7);
//                
//                
//                
//                co.add(encPago);
//                co.add(detPago);
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
//        return co;        
//    }
  public Matriculado getMatriculadoconfechas(int matricula)
    {
        Matriculado mat = new Matriculado();
        try 
        { 
            conn = super.getConection();  
            stmt = conn.createStatement();  
            res = stmt.executeQuery(" select * from matconfechas where matricula ="+matricula);
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
                if(res.next())
                {
                    if (res.getInt(1)>0){
                        mat.setIdmatriculado(res.getInt(1));
                        mat.setMatricula(res.getInt(2));
                        mat.setApellido(res.getString(3).trim());
                        mat.setNombres(res.getString(4).trim());
                        mat.setDni(res.getString(5).trim());
                        mat.setHabilitado(res.getString(6).trim());
                        mat.setFechaInscripcion(res.getDate(7));
                    }
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
        this.cerrar();
        return mat;
    }
  
  public Date getFechaEncabezadoPago(long idmatriculado)
    {
        ResultSet resu = null;
        Statement stmte = null;
        Connection conne = null;
        Date fecha = new Date();
        try 
        { 
            conne = super.getConection();      
            stmte = conne.createStatement();  
            resu = stmte.executeQuery("select (max(e.habilitacionhasta)) as ultimafecha from encabezadopago e where e.idmatriculado="+idmatriculado); 
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
            resu.next();
            fecha = resu.getDate(1);
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
        return fecha;        
    }

}
