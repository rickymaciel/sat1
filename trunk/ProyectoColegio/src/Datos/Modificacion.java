/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

/**
 *
 * @author asus
 */

import java.sql.*;
import negocios.Barrio;
import negocios.Caja;
import negocios.CondicionVenta;
import negocios.Configuracion;
import negocios.Departamento;
import negocios.DetalleCP;
import negocios.DetalleCT;
import negocios.Documento;
import negocios.Empresa;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
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
import negocios.Tasa;
import negocios.TasaAplicable;
import negocios.TipoSeccion;
import negocios.TipoSuperficie;
import negocios.TipoTrabajo;
import negocios.Titulo;
import negocios.Usuario;

public class Modificacion extends DataManager {

    private Connection conn;
    private Statement stmt;

    public Modificacion()
    {
        
    }
    
    public int modificar(EncabezadoPago encp)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE encabezadopago SET idencabezadopago = "+encp.getIdencabezado()+", idmatriculado = "+encp.getIdmatriculado()+", total = "+encp.getTotal()+", fechapago = '"+encp.getFechapago()+"', habilitacionhasta = '"+encp.getHabilitacionhasta()+"', seriefactura = "+encp.getSeriefactura()+", nrofactura = "+encp.getNrofactura()+" WHERE idencabezadopago = "+encp.getIdencabezado());
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
        return registrosModificados;
    }
    public int modificarTotalEncPago(EncabezadoPago encp)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE encabezadopago SET total = "+encp.getTotal()+", habilitacionhasta = '"+encp.getHabilitacionhasta()+"' WHERE idencabezadopago = "+encp.getIdencabezado());
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
        return registrosModificados;
    }
    
    public int modificar(Documento doc)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE documentos SET iddocumento = "+doc.getIdDocumento()+", descripcion = '"+doc.getDescripcion()+"', existe = '"+doc.getExiste()+"' WHERE iddocumento = "+doc.getIdDocumento());
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
        return registrosModificados;
    }
    
    public int modificar(TasaAplicable tasaA)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE planosctotal SET idtasaaplicable = "+tasaA.getIdTasaAplicable()+", idtasa = "+tasaA.getIdtasa()+", idtipoconstancia = "+tasaA.getIdTipoConstancia()+", existe = '"+tasaA.getExiste()+"' WHERE idtasaaplicable = "+tasaA.getIdTasaAplicable());
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
        return registrosModificados;
    }
    
    public int modificar(PlanoCTotal planoct)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE planosctotal SET idplanoctotal = "+planoct.getIdplanoCTotal()+", nombre = '"+planoct.getNombre()+"', leyenda = '"+planoct.getLeyenda()+"', existe = '"+planoct.getExiste()+"' WHERE idplanoctotal = "+planoct.getIdplanoCTotal());
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
        return registrosModificados;
    }
    
    public int modificar(PlanoTasa planot)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE plano_tasa SET idplanotasa = "+planot.getIdplanotasa()+", idplano = "+planot.getIdplano()+", idtasa = "+planot.getIdtasa()+", existe = '"+planot.getExiste()+"' WHERE idplanotasa = "+planot.getIdplanotasa());
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
        return registrosModificados;
    }
    
    public int modificar(PuntodeVenta pdventa)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE puntodeventa SET idpuntodeventa = "+pdventa.getIdpuntodeventa()+", nombreusuarioapertura = '"+pdventa.getNombreusuarioapertura()+"', tipofactura = '"+pdventa.getTipofactura()+"', numerofacturainicial = "+pdventa.getNumerofacturainicial()+", iniciofacturacion = '"+pdventa.getIniciofacturacion()+"',"+" limite = "+pdventa.getLimite()+", existe = '"+pdventa.getExiste()+"' WHERE idpuntodeventa = "+pdventa.getIdpuntodeventa());
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
        return registrosModificados;
    }
    
    public int modificar(SerieConstancia serie)
    {
        int registrosModificados = 0;
        int registrosPorDefectoAnulados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosPorDefectoAnulados = stmt.executeUpdate("UPDATE series SET defecto = 'N' WHERE tipoconstancia = '"+serie.getTipoConstancia()+"'");
          registrosModificados = stmt.executeUpdate("UPDATE series SET idserie = "+serie.getIdserie()+", serie = '"+serie.getSerie()+"', defecto = '"+serie.getDefecto()+"', limite = "+serie.getLimite()+", tipoConstancia = '"+serie.getTipoConstancia()+"', activo = '"+serie.getActivo()+"' WHERE idserie = "+serie.getIdserie());
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
        return registrosModificados;
    }

    
    
    public int modificar(EncabezadoCP encCP)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE encabezadocp SET seriecp = '"+encCP.getSerieCP()+"', codigocp = "+encCP.getCodigoCP()+", idprovincia = "+encCP.getProvincia().getIdprovincia()+", iddepartamento = "+ encCP.getDepartamento().getIddepartamento()+", idlocalidad = "+encCP.getLocalidad().getIdlocalidad()+", idbarrio = "+encCP.getBarrrio().getIdbarrio()+
          ", calle = '"+encCP.getCalle()+"', numero = '"+encCP.getNumero()+"', manzana = '"+encCP.getManzana()+"', lote = '"+encCP.getLote()+"', seriefactura = "+encCP.getSerieFactura()+", numerofactura = "+encCP.getNumeroFactura()+", fecha = '"+encCP.getFecha()+"', propietario = '"+encCP.getPropietario()+"', comitente = '"+encCP.getComitente()+"', anulado = '"+encCP.getAnulado()+
          "', idusuario = "+encCP.getUsuario().getIdusuario()+", idmatriculado = "+encCP.getMatriculado().getIdmatriculado()+        
          " WHERE seriecp = '"+encCP.getSerieCP()+"' AND codigocp = "+encCP.getCodigoCP());
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
        return registrosModificados;
    }
    
    public int anularFactura(EncabezadoFactura enc)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE encabezadofacturas SET anulado = 'S' WHERE seriefactura = "+enc.getSerieFactura()+" AND numerofactura = "+enc.getNumeroFactura());
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
        return registrosModificados;
    }
    public int modificar(EncabezadoCT encCT)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          
          registrosModificados = stmt.executeUpdate("UPDATE encabezadoct SET seriect = '"+encCT.getSerieCT()+"', codigoct = "+encCT.getCodigoCT()+", idprovincia = "+encCT.getProvincia().getIdprovincia()+", iddepartamento = "+encCT.getDepartamento().getIddepartamento()+", idlocalidad = "+encCT.getLocalidad().getIdlocalidad()+", idbarrio = "+encCT.getBarrio().getIdbarrio()+
          ", seriefactura = "+encCT.getSerieFactura()+", numerofactura = "+encCT.getNumeroFactura()+", perito = '"+encCT.getPerito().trim()+"', propietario = '"+encCT.getPropietario().trim()+"', responsable = '"+encCT.getResponsable().trim()+"', comitente = '"+encCT.getComitente().trim()+"',  fecha = '"+encCT.getFecha()+"', idplanoctotal = "+encCT.getPlanoCTotal().getIdplanoCTotal()+
          ", nombreproyectista = '"+encCT.getNombreProyectista().trim()+"', nombredirector = '"+encCT.getNombreDirector().trim()+"', nombreconductor = '"+encCT.getNombreConductor().trim()+"', nombreconstructor = '"+encCT.getNombreConstructor().trim()+
          "', estadofindeobra = '"+encCT.getEstadoFinDeObra()+"', calle = '"+encCT.getCalle().trim()+"', numero = '"+encCT.getNumero().trim()+"', manzana = '"+encCT.getManzana().trim()+"', lote = '"+encCT.getLote().trim()+"', anulado = '"+encCT.getAnulado()+"', idusuario = "+encCT.getUsuario().getIdusuario()+", idmatriculado = "+encCT.getMatriculado().getIdmatriculado()+       
          " WHERE seriect = '"+encCT.getSerieCT()+"' AND codigoct = "+encCT.getCodigoCT());
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
        return registrosModificados;
    }
    public int modificarPonerCTconFacturaEnCero(String serie, Long codigo)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE encabezadoct SET seriefactura=0, numerofactura=0 WHERE seriect = '"+ serie +"' AND codigoct = "+codigo);
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
        return registrosModificados;
    }
    public int modificarPonerCPconFacturaEnCero(String serie, Long codigo)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE encabezadocp SET seriefactura=0, numerofactura=0 WHERE seriecp = '"+ serie +"' AND codigocp = "+codigo);
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
        return registrosModificados;
    }
    public int modificarPonerEncabezadoPagoconFacturaEnCero(Long idPago)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE encabezadopago SET seriefactura=0, nrofactura=0 WHERE idencabezadopago = "+idPago);
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
        return registrosModificados;
    }
    
    
//    public int modificar(EncabezadoCT encCT)
//    {
//        int registrosModificados = 0;
//        try 
//        { 
//          conn = super.getConection();
//          stmt = conn.createStatement();
//          registrosModificados = stmt.executeUpdate("UPDATE encabezadoct SET seriect = '"+encCT.getSerieCT()+"', codigoct = "+encCT.getCodigoCT()+", idprovincia = "+encCT.getProvincia().getIdprovincia()+", iddepartamento = "+encCT.getDepartamento().getIddepartamento()+", idlocalidad = "+encCT.getLocalidad().getIdlocalidad()+", idbarrio = "+encCT.getBarrio().getIdbarrio()+
//          ", seriefactura = "+encCT.getSerieFactura()+", numerofactura = "+encCT.getNumeroFactura()+", perito = '"+encCT.getPerito()+"', propietario = '"+encCT.getPropietario()+"', responsable = '"+encCT.getResponsable()+"', comitente = '"+encCT.getComitente()+"',  fecha = '"+encCT.getFecha()+"', idplanoctotal = "+encCT.getPlanoCTotal()+
//          "', nombreproyectista = '"+encCT.getNombreProyectista()+"', nombredirector = '"+encCT.getNombreDirector()+"', nombreconductor = '"+encCT.getNombreConductor()+"', nombreconstructor = '"+encCT.getNombreConstructor()+
//          "', estadofindeobra = '"+encCT.getEstadoFinDeObra()+"', calle = '"+encCT.getCalle()+"', numero = '"+encCT.getNumero()+"', manzana = '"+encCT.getManzana()+"', lote = '"+encCT.getLote()+"', anulado = '"+encCT.getAnulado()+"', idusuario = "+encCT.getUsuario().getIdusuario()+", idmatriculado = "+encCT.getMatriculado().getIdmatriculado()+       
//          " WHERE seriect = '"+encCT.getSerieCT()+"' AND codigoct = "+encCT.getCodigoCT());
//          this.cerrar();
//     }
//      catch (SQLException ex)
//     {
//        while (ex !=null)
//        {
//          ex.printStackTrace();
//          ex = ex.getNextException();
//        }
//     }
//        return registrosModificados;
//    }

    public int modificar(DetalleCP detCP)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE detallecp SET iddetalle = "+detCP.getIddetalleCP()+", seriecp = '"+detCP.getSerieCP()+"', codigocp = "+detCP.getCodigoCP()+", idtipotrabajo = "+detCP.getTipoTrabajo().getIdtipoTrabajo()+", idtiposeccion = "+detCP.getTipoSeccion().getIdtipoSeccion()+", idtiposuperficie = "+detCP.getTipoSuperficie().getIdtipoSuperficie()+
          ", superficie = "+detCP.getSuperficie()+" WHERE iddetalle = "+detCP.getIddetalleCP());
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
        return registrosModificados;
    }
    
    public int modificar(DetalleCT detCT)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE detallect SET iddetalle = "+detCT.getIddetalleCT()+", seriect = '"+detCT.getSerieCT()+"', codigoCT = "+detCT.getCodigoCT()+", idtiposeccion = "+detCT.getTipoSeccion().getIdtipoSeccion()+", idtiposuperficie = "+detCT.getTipoSuperficie().getIdtipoSuperficie()+", superficie = "+detCT.getSuperficie()+
          " WHERE iddetalle = "+detCT.getIddetalleCT());
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
        return registrosModificados;
    }
    
    public int modificar(Configuracion conf)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Configuraciones SET idconfiguracion = "+conf.getIdconfiguracion()+", host = '"+conf.getHost()+"', directorioTemp = '"+conf.getDirectorioTemp()+"', codigomaximocp = "+conf.getCodigoMaximoCP()+", codigomaximoct = "+conf.getCodigoMaximoCT()+", idproducto = "+conf.getIdproducto()+"WHERE idconfiguracion = "+conf.getIdconfiguracion());
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
        return registrosModificados;
    }
           
    public int modificarFoto(String foto, String matricula)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("Update imagenes set imagen=lo_import('"+foto+"') where matricula="+matricula);
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
        return registrosModificados;
    }
    
    public int modificar(Usuario user)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Usuarios SET idusuario = "+user.getIdusuario()+", nombre = '"+user.getNombre()+"', password = '"+user.getPassword()+"', nivel = "+user.getNivel()+", existe = '"+user.getExiste()+"' WHERE idusuario = "+user.getIdusuario());
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
        return registrosModificados;
    }
    
    public int modificar(Matriculado mat)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Matriculados SET idmatriculado = "+mat.getIdmatriculado()+", matricula = "+mat.getMatricula()+", apellido = '"+mat.getApellido()+"', nombres = '"+mat.getNombres()+"', dni = '"+mat.getDni()+"', calle = '"+mat.getCalle()+"', nacimiento = '"+mat.getNacimiento()+"', email = '"+mat.getEmail()+"', telefonotrabajo = '"+mat.getTelefonoTrabajo()+"', web = '"+mat.getWeb()+"', cuit = '"+mat.getCuit()+"', cuil = '"+mat.getCuil()
          +"', habilitado = '"+mat.getHabilitado()+"', idbarrio = "+mat.getBarrio().getIdbarrio()+", idprovincia = "+mat.getProvincia().getIdprovincia()+", iddepartamento = "+mat.getDepartamento().getIddepartamento()+", idlocalidad = "+mat.getLocalidad().getIdlocalidad()+", idnacionalidad = "+mat.getNacionalidad().getIdnacionalidad()+", iddepartamentoprofesional = "+mat.getDepartamentoProfesional().getIddepartamento()
          +", idlocalidadprofesional = "+mat.getLocalidadProfesional().getIdlocalidad()+", idbarrioprofesional = "+mat.getBarrioProfesional().getIdbarrio()+", calleprofesional = '"+mat.getCalleProfesional()+"', fechainscripcion = '"+mat.getFechaInscripcion()+"', libro = '"+mat.getLibro()+"', folio = '"+mat.getFolio()+"', idescuela = "+mat.getEscuela().getIdescuela()
          +", fechaegresodeescuela = '"+mat.getFechaEgresoDeEscuela()+"', idtitulo = "+mat.getTitulo().getIdtitulo()+", especialidad = '"+mat.getEspecialidad()+"', existe = '"+mat.getExiste()+"', telefonoparticular = '"+mat.getTelefonoParticular()+"', telefonocelular = '"+mat.getTelefonoCelular()+"', ingresosBrutos = '"+mat.getIngresosBrutos()+"', idiva = "+mat.getIva().getIdiva()+" WHERE idmatriculado = "+mat.getIdmatriculado());
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
        return registrosModificados;
    }

    
    public int modificar(Provincia prov)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Provincias SET idprovincia = "+prov.getIdprovincia()+", nombre = '"+prov.getNombre()+"', existe = '"+prov.getExiste()+"' WHERE idprovincia = "+prov.getIdprovincia());
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
        return registrosModificados;
    }

    public int modificar(Departamento dep)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Departamentos SET iddepartamento = "+dep.getIddepartamento()+", nombre = '"+dep.getNombre()+"', idprovincia = "+dep.getProvincia().getIdprovincia()+", existe = '"+dep.getExiste()+"' WHERE iddepartamento = "+dep.getIddepartamento());
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
        return registrosModificados;
    }
    
    public int modificar(Localidad loc)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Localidades SET idlocalidad = "+loc.getIdlocalidad()+", nombre = '"+loc.getNombre()+"' , iddepartamento = "+loc.getDepartamento().getIddepartamento()+", existe = '"+loc.getExiste()+"' WHERE idlocalidad = "+loc.getIdlocalidad());
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
        return registrosModificados;
    } 
    
    public int modificar(Barrio barrio)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Barrios SET idbarrio = "+barrio.getIdbarrio()+", nombre = '"+barrio.getNombre()+"', idlocalidad = "+barrio.getLocalidad().getIdlocalidad()+", existe = '"+barrio.getExiste()+"' WHERE idbarrio = '"+barrio.getIdbarrio()+"'");
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
        return registrosModificados;
    } 
    
     public int modificar(Rol rol)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Roles SET idrol = "+rol.getIdrol()+", nombre = '"+rol.getNombre()+"', existe = '"+rol.getExiste()+"' WHERE idrol = "+rol.getIdrol());
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
        return registrosModificados;
    }
    
     public int modificar(Titulo titulo)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Titulos SET idtitulo = "+titulo.getIdtitulo()+", nombre = '"+titulo.getNombre()+"', abreviacion = '"+titulo.getAbreviacion()+"', existe = '"+titulo.getExiste()+"' WHERE idtitulo = "+titulo.getIdtitulo());
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
        return registrosModificados;
    }
    
   public int modificar(EntidadExterna ee)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE entidadesexternas SET identidadexterna = "+ee.getIdentidadExterna()+", nombre = '"+ee.getNombre()+"', existe = '"+ee.getExiste()+"' WHERE identidadexterna = "+ee.getIdentidadExterna());
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
        return registrosModificados;
    }  
   
   public int modificar(Escuela escuela)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Escuelas SET idescuela = "+escuela.getIdescuela()+", nombre = '"+escuela.getNombre()+"', direccion = '"+escuela.getDireccion()+"', telefono = '"+escuela.getTelefono()+"', mail = '"+escuela.getMail()+"', fax ='"+escuela.getFax()+"', idprovincia = "+escuela.getProvincia().getIdprovincia()
          +", iddepartamento = "+escuela.getDepartamento().getIddepartamento()+", idlocalidad = "+escuela.getLocalidad().getIdlocalidad()+", codigopostal = '"+escuela.getCodigoPostal()+"', existe = '"+escuela.getExiste()+"' WHERE idescuela = "+escuela.getIdescuela());
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
        return registrosModificados;
    }  
   
   public int modificar(Nacionalidad nac)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Nacionalidades SET idnacionalidad = "+nac.getIdnacionalidad()+", nombre = '"+nac.getNombre()+"', existe = '"+nac.getExiste()+"' WHERE idnacionalidad = "+nac.getIdnacionalidad());
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
        return registrosModificados;
    }  
   
   public int modificar(Producto prod)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Productos SET idproducto = "+prod.getIdproducto()+", denominacion = '"+prod.getDenominacion()+"', precio = "+prod.getPrecio()+", existe = '"+prod.getExiste()+"' WHERE idproducto = "+prod.getIdproducto());
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
        return registrosModificados;
    }  
   
   public int modificar(Tasa tasa)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Tasas SET idtasa = "+tasa.getIdtasa()+", denominacion = '"+tasa.getDenominacion()+"', indice = "+tasa.getIndice()+", tasaminima = "+tasa.getTasaMinima()+", observacion = '"+tasa.getObservacion()+"', existe = '"+tasa.getExiste()+"' WHERE idtasa = "+tasa.getIdtasa());
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
        return registrosModificados;
    }  
   
   public int modificar(TipoSeccion tseccion)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE tipoSecciones SET idtipoSeccion = "+tseccion.getIdtipoSeccion()+", nombre = '"+tseccion.getNombre()+"', existe = '"+tseccion.getExiste()+"' WHERE idtiposeccion = "+tseccion.getIdtipoSeccion());
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
        return registrosModificados;
    }  
   
   public int modificar(TipoTrabajo ttrabajo)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE tipoTrabajos SET idtipoTrabajo = "+ttrabajo.getIdtipoTrabajo()+", nombre = '"+ttrabajo.getNombre()+"', leyenda = '"+ttrabajo.getLeyenda()+"', existe = '"+ttrabajo.getExiste()+"' WHERE idtipoTrabajo = "+ttrabajo.getIdtipoTrabajo());
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
        return registrosModificados;
    }  
   
    public int modificar(TipoSuperficie tsuper)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE tiposuperficies SET idtiposuperficie = "+tsuper.getIdtipoSuperficie()+", nombre = '"+tsuper.getNombre()+"', modificador = "+tsuper.getModificador()+", existe = '"+tsuper.getExiste()+"' WHERE idtipoSuperficie = "+tsuper.getIdtipoSuperficie());
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
        return registrosModificados;
    }
  
    public int modificar(Empresa empresa)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Empresa SET idempresa = "+empresa.getIdempresa()+", nombre = '"+empresa.getNombre()+"', titular = '"+empresa.getTitular()+"', direccion = '"+empresa.getDireccion()+"', telefono = '"+empresa.getTelefono()
          +"', fax = '"+empresa.getFax()+"', codigopostal = '"+empresa.getCodigoPostal()+"', idprovincia ="+empresa.getProvincia().getIdprovincia()+", idlocalidad = "+empresa.getLocalidad().getIdlocalidad()+", iddepartamento = "+empresa.getDepartamento().getIddepartamento()
          +", cuit = '"+empresa.getCuit()+"', ingresosbrutos = '"+empresa.getIngresosBrutos()+"', inicioactividades = '"+empresa.getInicioActividades()+"', idiva = "+empresa.getIva().getIdiva()+", existe = '"+empresa.getExiste()+"', idbarrio = "+empresa.getBarrio().getIdbarrio()+" WHERE idempresa = "+empresa.getIdempresa());
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
        return registrosModificados;
    }
    
    public int modificar(Iva iva)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE Iva SET idiva = "+iva.getIdiva()+", nombre = '"+iva.getNombre()+"', existe = '"+iva.getExiste()+"' WHERE idiva = "+iva.getIdiva());
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
        return registrosModificados;
    }
   
    public int modificar(CondicionVenta cventa)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          registrosModificados = stmt.executeUpdate("UPDATE condicionventa SET idcondicionventa = "+cventa.getIdcondicionVenta()+", nombre = '"+cventa.getNombre()+"', existe = '"+cventa.getExiste()+"' WHERE idcondicionVenta = "+cventa.getIdcondicionVenta());
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
        return registrosModificados;
    }
    
    public int modificar(Caja caja)
    {
        int registrosModificados = 0;
        try 
        { 
          conn = super.getConection();
          stmt = conn.createStatement();
          //registrosModificados = stmt.executeUpdate("UPDATE cajas SET idcaja = "+caja.getIdcaja()+", fechaapertura = '"+caja.getFechaapertura()+"', fechacierre = '"+caja.getFechacierre()+"', total = "+caja.getTotal()+", idusuariocierre = "+caja.getUsuariocierre().getIdusuario()+", saldoinicial = "+caja.getSaldoinicial()+", estado = '"+caja.getEstado()+"' WHERE idcaja = "+caja.getIdcaja());
          registrosModificados = stmt.executeUpdate("UPDATE cajas SET idcaja = "+caja.getIdcaja()+", fechacierre = '"+caja.getFechacierre()+"', total = "+caja.getTotal()+", idusuariocierre = "+caja.getUsuariocierre().getIdusuario()+", saldoinicial = "+caja.getSaldoinicial()+", estado = '"+caja.getEstado()+"' WHERE idcaja = "+caja.getIdcaja());
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
        return registrosModificados;
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
 
    
}
