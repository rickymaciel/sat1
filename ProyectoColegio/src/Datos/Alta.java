/*
 * Alta.java
 *
 * Created on 31 de julio de 2007, 09:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Datos;

/**
 *
 * @author Administrador
 */

import negocios.ConstanciaHabilitacion;
import negocios.Provincia;
import negocios.Departamento;
import negocios.Localidad;
import negocios.Barrio;        
import java.sql.*;
import negocios.Caja;
import negocios.CondicionVenta;
import negocios.Configuracion;
import negocios.DetalleCP;
import negocios.DetalleCPParaFacturacion;
import negocios.DetalleCT;
import negocios.DetalleFactura;
import negocios.DetallePago;
import negocios.Documento;
import negocios.Empresa;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.EncabezadoFactura;
import negocios.EncabezadoPago;
import negocios.EntidadExterna;
import negocios.Escuela;
import negocios.Iva;
import negocios.Matriculado;
import negocios.Nacionalidad;
import negocios.PlanoCTotal;
import negocios.PlanoTasa;
import negocios.Producto;
import negocios.ProductoTasa;
import negocios.PuntodeVenta;
import negocios.Rol;
import negocios.SerieConstancia;
import negocios.Tasa;
import negocios.TasaAplicable;
import negocios.TasaSeleccionada;
import negocios.TipoSeccion;
import negocios.TipoSuperficie;
import negocios.TipoTrabajo;
import negocios.Titulo;
import negocios.Usuario;

/**
 *  Clase que se encarga de realizar altas en el la base de datos
 * 
 */
public class Alta extends DataManager
{
    private Statement stmt;
    private Connection conn;
    /** Creates a new instance of Alta */
    public Alta() 
    {
    }
    
    public int almacenar(Documento doc)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO documentos (iddocumento, descripcion, existe) VALUES ("
            +doc.getIdDocumento()+",'"+doc.getDescripcion()+"','"+doc.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
    
    public int almacenar(TasaAplicable tasaA)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO tasasaplicables (idtasaaplicable, idtasa, idtipoconstancia, existe, leyenda) VALUES ("
            +tasaA.getIdTasaAplicable()+","+tasaA.getIdtasa()+","+tasaA.getIdTipoConstancia()+",'"+tasaA.getExiste()+"', '"+tasaA.getLeyenda().trim()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }
 
    
    public int almacenar(EncabezadoPago encP)
    {
        System.out.println("INSERT INTO encabezadopago (idencabezadopago, idmatriculado, total, fechapago, habilitacionhasta, seriefactura, nrofactura, matricula) VALUES ("
            +encP.getIdencabezado()+","+encP.getIdmatriculado()+","+encP.getTotal()+",'"+encP.getFechapago()+"','"+encP.getHabilitacionhasta()+"',"+encP.getSeriefactura()+","+encP.getNrofactura()+","+encP.getMatricula()+")");
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO encabezadopago (idencabezadopago, idmatriculado, total, fechapago, habilitacionhasta, seriefactura, nrofactura, matricula) VALUES ("
            +encP.getIdencabezado()+","+encP.getIdmatriculado()+","+encP.getTotal()+",'"+encP.getFechapago()+"','"+encP.getHabilitacionhasta()+"',"+encP.getSeriefactura()+","+encP.getNrofactura()+","+encP.getMatricula()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
    public int almacenar(EncabezadoFactura encF)
    {
        int registrosInsertados = 0;
//        System.out.println("ALAMCENAMIENTO: " +encF.getSerieFactura()+",NRO FACTURA:"+encF.getNumeroFactura()+","+encF.getIdempresa()+","+encF.getUsuario().getIdusuario()+","+encF.getCaja().getIdcaja()+",'"+encF.getFecha()+"',"+encF.getCondicionVenta().getIdcondicionVenta()+","+encF.getIva().getIdiva()+",'"+encF.getNumeroRemito()+"',"+encF.getTotal()+",'"+encF.getCuit()+"','"+encF.getDomicilio()+"',"+encF.getMatriculado().getIdmatriculado()+",'"+encF.getNombreCliente()+"','"+encF.getAnulado()+"'");
        
        
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO encabezadofacturas (seriefactura,numerofactura,idempresa,idusuario,idcaja,fecha,idcondicionventa,idiva,numeroremito,total,cuit,domicilio,idmatriculado,nombrecliente,anulado) VALUES ("
            +encF.getSerieFactura()+","+encF.getNumeroFactura()+","+encF.getIdempresa()+","+encF.getUsuario().getIdusuario()+","+encF.getCaja().getIdcaja()+",'"+encF.getFecha()+"',"+encF.getCondicionVenta().getIdcondicionVenta()+","
            +encF.getIva().getIdiva()+",'"+encF.getNumeroRemito()+"',"+encF.getTotal()+",'"+encF.getCuit()+"','"+encF.getDomicilio()+"',"+encF.getMatriculado().getIdmatriculado()+",'"+encF.getNombreCliente()+"','"+encF.getAnulado()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }
    public int almacenar(PlanoCTotal planoT)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO planosctotal (idplanoctotal, nombre, leyenda, existe) VALUES ("+planoT.getIdplanoCTotal()+",'"+planoT.getNombre()+"','"+planoT.getLeyenda()+"','"+planoT.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
      
    public int almacenar(DetallePago detp)
    {
        System.out.println("INSERT INTO detallepago (idencabezadopago, anio, mes, importe, idproducto) VALUES ("+detp.getIdencabezadopago()+","+detp.getAnio()+","+detp.getMes()+","+detp.getImporte()+","+detp.getIdproducto()+")");
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO detallepago (idencabezadopago, anio, mes, importe, idproducto) VALUES ("+detp.getIdencabezadopago()+","+detp.getAnio()+","+detp.getMes()+","+detp.getImporte()+","+detp.getIdproducto()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
    public int almacenar(DetalleFactura detF)
    {
        int registrosInsertados = 0;
        
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            //+++++++++++++++++++++++++++++++++++++++++++++
            //Esto sirve solo para cuando el precio unitario es cero
            //Lo que sucede es que para ct cp en sus detalles como sus tasas
            //tienen precio cero, entonces, se le asignara al precio unitario
            //del detalle el subtotal calculado.
            Double pu=detF.getProducto().getPrecio();
            if (detF.getProducto().getPrecio()==0.0){
                pu=detF.getSubTotal();
            }
//            System.out.println("INSERT INTO detallefacturas (seriefactura,numerofactura,iddetalle,idproducto,detalle,descripcion,cantidad,subtotal,pu) VALUES ("
//                                +detF.getSerieFactura()+","+detF.getNumeroFactura()+","+detF.getIddetalle()+","+detF.getProducto().getIdproducto()+",'"+detF.getProducto().getDenominacion().trim().toUpperCase()+"','"+detF.getDetalle().trim().toUpperCase()+"',"+detF.getCantidad()+","+detF.getSubTotal()+","+pu+")");                     
            //+++++++++++++++++++++++++++++++++++++++++++++
            registrosInsertados = stmt.executeUpdate("INSERT INTO detallefacturas (seriefactura,numerofactura,iddetalle,idproducto,detalle,descripcion,cantidad,subtotal,pu) VALUES ("
                        +detF.getSerieFactura()+","+detF.getNumeroFactura()+","+detF.getIddetalle()+","+detF.getProducto().getIdproducto()+",'"+detF.getProducto().getDenominacion().trim().toUpperCase()+"','"+detF.getDetalle().trim().toUpperCase()+"',"+detF.getCantidad()+","+detF.getSubTotal()+","+pu+")"); 
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }
     public int almacenar(PlanoTasa planotasa)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO plano_tasa (idplanotasa, idplano, idtasa, existe) VALUES ("+planotasa.getIdplanotasa()+","+planotasa.getIdplano()+","+planotasa.getIdtasa()+",'"+planotasa.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
    
    public int almacenar(PuntodeVenta pdventa)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO puntodeventa (idpuntodeventa, nombreusuarioapertura, tipofactura, numerofacturainicial, iniciofacturacion, idempresa, limite, existe) VALUES ("+pdventa.getIdpuntodeventa()+",'"+pdventa.getNombreusuarioapertura()+"','"+pdventa.getTipofactura()+"',"+pdventa.getNumerofacturainicial()+",'"+pdventa.getIniciofacturacion()+"',"+pdventa.getLimite()+",'"+pdventa.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
    
    public int almacenar(SerieConstancia serie)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO series (idserie, serie, defecto, limite, tipoConstancia, activo, tipodecarga) VALUES ("+serie.getIdserie()+",'"+serie.getSerie()+"','"+serie.getDefecto()+"',"+serie.getLimite()+",'"+serie.getTipoConstancia()+"','"+serie.getActivo()+"','"+serie.getTipoDeCarga()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
 
    
    public int almacenar(EncabezadoCT encCT)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO encabezadoCT (seriect, codigoct,idprovincia,iddepartamento, idlocalidad, idbarrio," +
            "seriefactura, numerofactura," +
            "perito, propietario, comitente, responsable," +
            " fecha, idplanoctotal," +
            " nombreproyectista, nombredirector, nombreconductor, nombreconstructor," +
            " estadofindeobra, calle, numero, manzana, lote, anulado," +
            " idusuario, idmatriculado,superficie,total,ordentrabajo,descripcionplano,leyenda)" 
            +" VALUES ('"+encCT.getSerieCT()+"',"+encCT.getCodigoCT()+","+encCT.getProvincia().getIdprovincia()+","+encCT.getDepartamento().getIddepartamento()+","+encCT.getLocalidad().getIdlocalidad()+","+encCT.getBarrio().getIdbarrio()+
            ","+encCT.getSerieFactura()+","+encCT.getNumeroFactura()+
            ",'"+encCT.getPerito()+"','"+encCT.getPropietario()+"','"+encCT.getComitente()+"','"+encCT.getResponsable()+
            "','"+String.valueOf(encCT.getFecha())+"',"+encCT.getPlanoCTotal().getIdplanoCTotal()+
            ",'"+encCT.getNombreProyectista()+"','"+encCT.getNombreDirector()+"','"+encCT.getNombreConductor()+"','"+encCT.getNombreConstructor()+
            "','"+encCT.getEstadoFinDeObra()+"','"+encCT.getCalle()+"','"+encCT.getNumero()+"','"+encCT.getManzana()+"','"+encCT.getLote()+"','"+encCT.getAnulado()+
            "',"+encCT.getUsuario().getIdusuario()+","+encCT.getMatriculado().getIdmatriculado()+","+encCT.getSuperficie()+","+encCT.getTotal()+",'"+encCT.getOrdenTrabajo()+
            "','"+encCT.getDescripcionPlano().toUpperCase().trim()+"','"+encCT.getLeyenda().toUpperCase().trim()+"')");

            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 
    
   public int almacenar(EncabezadoCP encCP)
    {
        
//            System.out.println("VALUES ('"+encCP.getSerieCP()+"',"+encCP.getCodigoCP()+","+encCP.getProvincia().getIdprovincia()+","+encCP.getDepartamento().getIddepartamento()+","+encCP.getLocalidad().getIdlocalidad()+","+encCP.getBarrrio().getIdbarrio()+",'"+encCP.getCalle()+"','"+encCP.getNumero()+"','"+
//            encCP.getManzana()+"','"+encCP.getLote()+"',"+encCP.getSerieFactura()+","+encCP.getNumeroFactura()+",'"+encCP.getFecha()+"','"+encCP.getPropietario()+"','"+encCP.getComitente()+"','"+encCP.getAnulado()+"',"+encCP.getUsuario().getIdusuario()+","+encCP.getMatriculado().getIdmatriculado()+","+encCP.getSuperficieRelevada()+","+encCP.getSuperficieProyecto()+","+encCP.getTotal()+",'"+encCP.getOrdenTrabajo()+"')");  
            
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO encabezadocp (seriecp, codigocp, idprovincia, iddepartamento, idlocalidad, idbarrio, calle, numero, manzana, lote, seriefactura, numerofactura, fecha, propietario, comitente, anulado, idusuario, idmatriculado,superficierelevada,superficieproyecto,total,ordentrabajo, leyenda) " +
            "VALUES ('"+encCP.getSerieCP()+"',"+encCP.getCodigoCP()+","+encCP.getProvincia().getIdprovincia()+","+encCP.getDepartamento().getIddepartamento()+","+encCP.getLocalidad().getIdlocalidad()+","+encCP.getBarrrio().getIdbarrio()+",'"+encCP.getCalle()+"','"+encCP.getNumero()+"','"+
            encCP.getManzana()+"','"+encCP.getLote()+"',"+encCP.getSerieFactura()+","+encCP.getNumeroFactura()+",'"+encCP.getFecha()+"','"+encCP.getPropietario()+"','"+encCP.getComitente()+"','"+encCP.getAnulado()+"',"+encCP.getUsuario().getIdusuario()+","+encCP.getMatriculado().getIdmatriculado()+","+encCP.getSuperficieRelevada()+","+encCP.getSuperficieProyecto()+","+encCP.getTotal()+",'"+encCP.getOrdenTrabajo()+"','"+encCP.getLeyenda().trim()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 

    
    public int almacenar(DetalleCT detCT)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            
             registrosInsertados = stmt.executeUpdate("INSERT INTO detallect (iddetalle, seriect, codigoct, idtiposeccion, idtiposuperficie, superficie) " +
            "VALUES ("+detCT.getIddetalleCT()+",'"+detCT.getSerieCT()+"',"+detCT.getCodigoCT()+","+detCT.getTipoSeccion().getIdtipoSeccion()+","+detCT.getTipoSuperficie().getIdtipoSuperficie()
            +","+detCT.getSuperficie()+")");
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }  
    
    public int almacenar(DetalleCP detCP)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            
           registrosInsertados = stmt.executeUpdate("INSERT INTO detallecp (iddetalle, seriecp, codigocp, idtipotrabajo, idtiposeccion, idtiposuperficie, superficie) " +
            "VALUES ("+detCP.getIddetalleCP()+",'"+detCP.getSerieCP()+"',"+detCP.getCodigoCP()+","+detCP.getTipoTrabajo().getIdtipoTrabajo()+","+detCP.getTipoSeccion().getIdtipoSeccion()+","+detCP.getTipoSuperficie().getIdtipoSuperficie()+
            ","+detCP.getSuperficie()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }  
    
    public int almacenar(Configuracion conf)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO configuraciones (idconfiguracion, host, directoriotemp, codigomaximoCP, codigomaximoCT, idproducto) VALUES ("+conf.getIdconfiguracion()+",'"+conf.getHost()+"','"+conf.getDirectorioTemp()+"',"+conf.getCodigoMaximoCP()+","+conf.getCodigoMaximoCT()+","+conf.getIdproducto()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }  
    
     /**
     * @return Copia la foto del matriculado desde la carpeta temporaria hacia la base de datos
     * @return Devuelve un booleano: 1 = si ejecuto correctamento la sentencia.O 0 = si fallo porque no existe la foto o esta mal el origen
     * @param nombreFoto 
      *@param matricula 
     */
    public int insertarFoto(String nombreFoto, String matricula)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("insert into imagenes (matricula,imagen) values ("+matricula+",lo_import('"+nombreFoto+"'))");
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }
   
   public int almacenar(ConstanciaHabilitacion chab)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO  (idconstanciahabilitacion, leyenda1, leyenda2, leyenda3, leyenda4) VALUES ("+chab.getIdconstanciaHabilitacion()+",'"+chab.getLeyenda1()+"','"+chab.getLeyenda2()+"','"+chab.getLeyenda3()+"','"+chab.getLeyenda4()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }  
    
   public int almacenar(Usuario user)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Usuarios (idusuario, nombre, password, nivel, existe) VALUES ("+user.getIdusuario()+",'"+user.getNombre()+"','"+user.getPassword()+"',"+user.getNivel()+",'"+user.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  } 
    
    
     /** Almacena un nuevo usuario en la tabla Usuarios
      * @return devuelve la cantidad de registros insertados, si devuelve 0 (cero) es que hubo un fallo y no se insertaron registros
      */
    
    public int almacenar(Matriculado mat)
    {
        int registrosInsertados = 0;
        try 
        { 
            
//            System.out.println("ID MATRICULADO: "+mat.getIdmatriculado());
            
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO matriculados (idmatriculado, matricula, apellido, nombres, dni, calle, nacimiento, email, telefonotrabajo, web, cuit, cuil, habilitado, idbarrio, idprovincia, iddepartamento, idlocalidad, idnacionalidad, iddepartamentoprofesional, idlocalidadprofesional, idbarrioprofesional, calleprofesional, fechainscripcion, libro, folio, idescuela, fechaegresodeescuela, idtitulo, especialidad, existe, telefonoparticular, telefonocelular, ingresosBrutos, idiva)" +
            " VALUES ("+mat.getIdmatriculado()+","+mat.getMatricula()+",'"+mat.getApellido()+"','"+mat.getNombres()+"','"+mat.getDni()+"','"+mat.getCalle()+"','"+mat.getNacimiento()+"','"+mat.getEmail()+"','"+mat.getTelefonoTrabajo()+"','"+mat.getWeb()+"','"+mat.getCuit()+"','"+mat.getCuil()+"','"+mat.getHabilitado()+"',"+mat.getBarrio().getIdbarrio()+
            ","+mat.getProvincia().getIdprovincia()+","+mat.getDepartamento().getIddepartamento()+","+mat.getLocalidad().getIdlocalidad()+","+mat.getNacionalidad().getIdnacionalidad()+","+mat.getDepartamentoProfesional().getIddepartamento()+","+mat.getLocalidadProfesional().getIdlocalidad()+","+mat.getBarrioProfesional().getIdbarrio()+",'"+mat.getCalleProfesional()+"','"+mat.getFechaInscripcion()+"','"+mat.getLibro()+"','"+mat.getFolio()+"',"+mat.getEscuela().getIdescuela()+",'"+mat.getFechaEgresoDeEscuela()+"',"+mat.getTitulo().getIdtitulo()+",'"+mat.getEspecialidad()+"','"+mat.getExiste()+
            "','"+mat.getTelefonoParticular()+"','"+mat.getTelefonoCelular()+"','"+mat.getIngresosBrutos()+"',"+mat.getIva().getIdiva()+")");
            this.cerrar();
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return registrosInsertados;
    }

    
    public int almacenar(Provincia provincia)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO provincias (idprovincia, nombre, existe) VALUES ("+provincia.getIdprovincia()+",'"+provincia.getNombre()+"','"+provincia.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }
    
public int almacenar(Departamento departamento)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Departamentos (iddepartamento, nombre, idprovincia, existe) VALUES ("+departamento.getIddepartamento()+",'"+departamento.getNombre()+"',"+departamento.getProvincia().getIdprovincia()+",'"+departamento.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Localidad localidad)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Localidades (idlocalidad, nombre, iddepartamento, existe) VALUES ("+localidad.getIdlocalidad()+",'"+localidad.getNombre()+"',"+localidad.getDepartamento().getIddepartamento()+",'"+localidad.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Barrio barrio)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Barrios (idbarrio, nombre, idlocalidad, existe) VALUES ("+barrio.getIdbarrio()+",'"+barrio.getNombre()+"',"+barrio.getLocalidad().getIdlocalidad()+",'"+barrio.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }
  
public int almacenar(Rol roles)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Roles (idrol, nombre, existe) VALUES ("+roles.getIdrol()+",'"+roles.getNombre()+"','"+roles.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Titulo titulo)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Titulos (idtitulo, nombre, abreviacion, existe) VALUES ("+titulo.getIdtitulo()+",'"+titulo.getNombre()+"','"+titulo.getAbreviacion()+"','"+titulo.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(EntidadExterna ee)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO EntidadesExternas (identidadExterna, nombre, existe) VALUES ("+ee.getIdentidadExterna()+",'"+ee.getNombre()+"','"+ee.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Escuela escuela)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO escuelas (idescuela, nombre, direccion, telefono, mail, fax, idprovincia, iddepartamento, idlocalidad, codigopostal, existe) VALUES ("
            +escuela.getIdescuela()+",'"+escuela.getNombre()+"','"+escuela.getDireccion()+"','"+escuela.getTelefono()+"','"+escuela.getMail()+"','"
            +escuela.getFax()+"',"+escuela.getProvincia().getIdprovincia()+","+escuela.getDepartamento().getIddepartamento()+","+escuela.getLocalidad().getIdlocalidad()+",'"+escuela.getCodigoPostal()+"','"+escuela.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Nacionalidad nac)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Nacionalidades (idnacionalidad, nombre, existe) VALUES ("+nac.getIdnacionalidad()+",'"+nac.getNombre()+"','"+nac.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Producto prod)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Productos (idproducto, denominacion, precio, existe) VALUES ("+prod.getIdproducto()+",'"+prod.getDenominacion()+"',"+prod.getPrecio()+",'"+prod.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Tasa tasas)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Tasas(idtasa, denominacion, indice, tasaminima, observacion, existe) VALUES ("+tasas.getIdtasa()+",'"+tasas.getDenominacion()+"',"+tasas.getIndice()+","+tasas.getTasaMinima()+",'"+tasas.getObservacion()+"','"+tasas.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(TipoSeccion tseccion)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO TipoSecciones (idtiposeccion, nombre, existe) VALUES ("+tseccion.getIdtipoSeccion()+",'"+tseccion.getNombre()+"','"+tseccion.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(TipoTrabajo ttrabajo)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO TipoTrabajos (idtipoTrabajo, nombre, leyenda, existe) VALUES ("+ttrabajo.getIdtipoTrabajo()+",'"+ttrabajo.getNombre()+"','"+ttrabajo.getLeyenda()+"','"+ttrabajo.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(TipoSuperficie tsuper)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO tipoSuperficies (idtipoSuperficie, nombre, modificador, existe) VALUES ("+tsuper.getIdtipoSuperficie()+",'"+tsuper.getNombre()+"',"+ tsuper.getModificador() +",'"+tsuper.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Empresa empresa)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
//            System.out.println("id empresa: "+String.valueOf(empresa.getIdempresa()));
//            System.out.println("nombre: "+empresa.getNombre());
            registrosInsertados = stmt.executeUpdate("INSERT INTO Empresa (idempresa, nombre, titular, direccion, telefono, fax, codigopostal, idprovincia, idlocalidad, iddepartamento, cuit, ingresosbrutos, inicioactividades, idiva, existe, idbarrio) VALUES ("
            +empresa.getIdempresa()+",'"+empresa.getNombre()+"','"+empresa.getTitular()+"','"+empresa.getDireccion()+"','"+empresa.getTelefono()+"','"+empresa.getFax()+"','"+empresa.getCodigoPostal()+"',"+empresa.getProvincia().getIdprovincia()+","
            +empresa.getLocalidad().getIdlocalidad()+","+empresa.getDepartamento().getIddepartamento()+",'"+empresa.getCuit()+"','"+empresa.getIngresosBrutos()+"','"+empresa.getInicioActividades()+"',"+empresa.getIva().getIdiva()+",'"+empresa.getExiste()+"',"+empresa.getBarrio().getIdbarrio()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(Iva iva)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO Iva (idiva, nombre, existe) VALUES ("+iva.getIdiva()+",'"+iva.getNombre()+"','"+iva.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }

public int almacenar(CondicionVenta cventa)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO condicionVenta (idcondicionVenta, nombre, existe) VALUES ("+cventa.getIdcondicionVenta()+",'"+cventa.getNombre()+"','"+cventa.getExiste()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
  }


public int almacenar(String serie, long codigoCp, int matricula, int tasa)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO enc_mat_cp (seriecp, codigocp, idMatriculado, idTasaAplicable) VALUES ('"+serie+"',"+codigoCp+","+matricula+","+tasa+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 

    public int almacenar(Caja caja){
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO cajas (idcaja, fechaapertura, fechacierre, total, idusuariocierre, saldoinicial, estado) VALUES ("
            +caja.getIdcaja()+",'"+caja.getFechaapertura()+"','"+caja.getFechacierre()+"',"+caja.getTotal()+","+caja.getUsuariocierre().getIdusuario()+","+caja.getSaldoinicial()+",'"+caja.getEstado()+"')");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
            while (ex !=null)
            {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
        return registrosInsertados;
    } 

private void cerrar()
    {
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
public int almacenar(TasaSeleccionada t)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO enc_mat_ct (serieCT, codigoct, idtasa, monto,superficie) VALUES ('"
            +t.getSerieCT()+"',"+t.getCodigoCT()+","+t.getIdTasa()+","+t.getMonto()+","+t.getSuperficie()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }

public int almacenar(DetalleCPParaFacturacion detCP)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            
           registrosInsertados = stmt.executeUpdate("INSERT INTO detallecpparafacturacion (seriecp, codigocp, iddetalle, idproducto, detalle, cantidad, tiposuperficie, valorsuperficie, nombretasa, valorindicedetasa, tasaminimaaplicada, subtotal) " +
            "VALUES ('"+detCP.getSerieCP().trim()+"',"+detCP.getCodigoCP()+","+detCP.getIddetalle()+","+detCP.getProducto().getIdproducto()+",'"+detCP.getDetalle().trim()+"',"+detCP.getCantidad()+
            ",'"+detCP.getTipoSuperficie().trim()+"',"+detCP.getValorSuperficie()+",'"+detCP.getNombreTasa().trim()+"',"+detCP.getValorIndiceDeTasa()+","+detCP.getTasaMinimaAplicada()+","+detCP.getSubTotal()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    }
public int almacenar(ProductoTasa pt)
    {
        int registrosInsertados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosInsertados = stmt.executeUpdate("INSERT INTO productos_tasas (codigoproducto, codigotasa) VALUES ("
            +pt.getCodigoproducto()+","+pt.getCodigotasa()+")");  
            this.cerrar();
        }
        catch (SQLException ex)
        {
          while (ex !=null)
        {
          ex.printStackTrace();
          ex = ex.getNextException();
        }
     }
        return registrosInsertados;
    } 


}
