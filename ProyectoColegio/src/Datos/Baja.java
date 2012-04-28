/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

/**
 *
 * @author asus
 */
 
import java.io.*;
import java.sql.*;
import negocios.Barrio;
import negocios.CondicionVenta;
import negocios.Departamento;
import negocios.Documento;
import negocios.Empresa;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
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

public class Baja extends DataManager{

    private Connection conn;
    private Statement stmt;
    
    public Baja()
    {
        
    }
    
    public int eliminarEncabezadoPago(long idcuota)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("DELETE FROM encabezadopago WHERE idencabezadopago = "+idcuota);  
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
        return registrosBorrados;
    }
    
    public int eliminarDetallePago(long idcuota)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("DELETE FROM detallepago WHERE idencabezadopago = "+idcuota);  
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
        return registrosBorrados;
    }
    public int eliminarItemDetallePago(long idpagoKey,int anioKey, int mesKey)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("DELETE FROM detallepago WHERE idencabezadopago = "+idpagoKey+" AND anio="+anioKey+" AND mes="+mesKey);  
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
        return registrosBorrados;
    }
    public int eliminar(Documento doc)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE documentos SET  existe = 'N' WHERE iddocumento = "+doc.getIdDocumento());  
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
        return registrosBorrados;
    }
    
    public int eliminar(TasaAplicable tasaA)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("DELETE FROM tasasaplicables WHERE idtipoconstancia = "+tasaA.getIdTipoConstancia());  
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
        return registrosBorrados;
    }
    
    public int eliminar(PlanoCTotal planoct)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE planosctotal SET  existe = 'N' WHERE idplanoctotal = "+planoct.getIdplanoCTotal());  
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
        return registrosBorrados;
    }
    
     public int eliminar(PlanoTasa planot)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            System.out.println("UPDATE plano_tasa SET  existe = 'N' WHERE idplano = "+planot.getIdplano());  
            registrosBorrados = stmt.executeUpdate("UPDATE plano_tasa SET  existe = 'N' WHERE idplano = "+planot.getIdplano());  
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
        return registrosBorrados;
    }
    
    public int eliminar(PuntodeVenta pdventa)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE puntodeventa SET  existe = 'N' WHERE idpuntodeventa = "+pdventa.getIdpuntodeventa());  
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
        return registrosBorrados;
    }
    
    public int eliminar(SerieConstancia serie)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE series SET  activo = 'N' WHERE idserie = "+serie.getIdserie());  
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
        return registrosBorrados;
    }
    
    public int eliminar(EncabezadoCP encCP)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE encabezadocp SET  anulado = 'S' WHERE seriecp = '"+encCP.getCodigoCP()+"' AND codigocp = "+encCP.getCodigoCP());  
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
        return registrosBorrados;
    }
    
    public int eliminar(EncabezadoCT encCT)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE encabezadoct SET  eliminado = 'S' WHERE seriect = '"+encCT.getSerieCT()+"' AND codigoct = "+encCT.getCodigoCT());  
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
        return registrosBorrados;
    }
    
    public int eliminarFoto(String matricula)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("delete from imagenes where matricula= "+matricula);  
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
        return registrosBorrados;
    }
    
    public int eliminar(Usuario user)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Usuarios SET  existe = 'N' WHERE idusuario = "+user.getIdusuario());  
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
        return registrosBorrados;
    }
    
    public int eliminar(Matriculado mat)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Matriculados SET  existe = 'N' WHERE idmatriculado = "+mat.getIdmatriculado());  
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
        return registrosBorrados;
    }
    
    public int eliminar(Provincia prov)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Provincias SET  existe = 'N' WHERE idprovincia = "+prov.getIdprovincia());  
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
        return registrosBorrados;
    }
 
    public int eliminar(Departamento dep)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Departamentos SET  existe = 'N' WHERE iddepartamento = "+dep.getIddepartamento());  
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
        return registrosBorrados;
    }
     
    public int eliminar(Localidad loc)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Localidades SET  existe = 'N' WHERE idlocalidad= "+loc.getIdlocalidad());  
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
        return registrosBorrados;
    } 
     
    public int eliminar(Barrio barrio)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Barrios SET  existe = 'N' WHERE idbarrio = "+barrio.getIdbarrio());  
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
        return registrosBorrados;
    }
    
    public int eliminar(Rol roles)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Roles SET  existe = 'N' WHERE idroles = "+roles.getIdrol());  
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
        return registrosBorrados;
    }
    
    public int eliminar(Titulo titulo)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE titulos SET  existe = 'N' WHERE idtitulo = "+titulo.getIdtitulo());  
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
        return registrosBorrados;
    }
    
    public int eliminar(EntidadExterna ee)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE entidadesExternas SET  existe = 'N' WHERE identidadexterna = "+ee.getIdentidadExterna());  
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
        return registrosBorrados;
    }
    
    public int eliminar(Escuela escuela)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Escuelas SET  existe = 'N' WHERE idescuela = "+escuela.getIdescuela());  
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
        return registrosBorrados;
    }
    
public int eliminar(Nacionalidad nac)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Nacionalidades SET  existe = 'N' WHERE idnacionalidad = "+nac.getIdnacionalidad());  
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
        return registrosBorrados;
    }    
    
public int eliminar(Producto productos)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Productos SET  existe = 'N' WHERE idproducto = "+productos.getIdproducto());  
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
        return registrosBorrados;
    }

public int eliminar(Tasa tasas)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE Tasas SET  existe = 'N' WHERE idtasa = "+tasas.getIdtasa());  
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
        return registrosBorrados;
    }

public int eliminar(TipoSeccion tseccion)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE tipoSecciones SET  existe = 'N' WHERE idtipoSeccion  = "+tseccion.getIdtipoSeccion());  
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
        return registrosBorrados;
    }

public int eliminar(TipoTrabajo ttrabajo)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE tipoTrabajos SET  existe = 'N' WHERE idtipoTrabajo = "+ttrabajo.getIdtipoTrabajo());  
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
        return registrosBorrados;
    }

public int eliminar(TipoSuperficie tsuper)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE tipoSuperficies SET  existe = 'N' WHERE idtipoSuperficie = "+tsuper.getIdtipoSuperficie());  
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
        return registrosBorrados;
    }

public int eliminar(Empresa empresa)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE empresa SET  existe = 'N' WHERE idempresa = "+empresa.getIdempresa());  
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
        return registrosBorrados;
    }

public int eliminar(Iva iva)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE iva SET  existe = 'N' WHERE idiva = "+iva.getIdiva());  
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
        return registrosBorrados;
    }

public int eliminar(CondicionVenta cventa)
    {
        int registrosBorrados = 0;
        try 
        { 
            conn = super.getConection();
            stmt = conn.createStatement();
            registrosBorrados = stmt.executeUpdate("UPDATE condicionVenta SET  existe = 'N' WHERE idcondicionVenta = "+cventa.getIdcondicionVenta());  
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
        return registrosBorrados;
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
