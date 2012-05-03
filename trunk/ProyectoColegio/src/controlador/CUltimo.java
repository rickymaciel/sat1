/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import Datos.Consulta;
import java.util.*;
import negocios.Barrio;
import negocios.Caja;
import negocios.CondicionVenta;
import negocios.Departamento;
import negocios.DetalleCP;
import negocios.DetalleCPParaFacturacion;
import negocios.DetalleCT;
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
import negocios.Localidad;
import negocios.Matriculado;
import negocios.Nacionalidad;
import negocios.PlanoCTotal;
import negocios.PlanoTasa;
import negocios.Producto;
import negocios.Provincia;
import negocios.Rol;
import negocios.SerieConstancia;
import negocios.SerieFactura;
import negocios.Tasa;
import negocios.TasaAplicable;
import negocios.TipoSeccion;
import negocios.TipoSuperficie;
import negocios.TipoTrabajo;
import negocios.Titulo;
import negocios.Usuario;

/**
 *
 * @author Administrador
 */

public class CUltimo {

    
    public CUltimo()
    {
        
    }
    
    public long getUltimo(EncabezadoPago encp)
    {
        Collection co = new ArrayList();
        EncabezadoPago ultima = new EncabezadoPago();
        Consulta consulta = new Consulta();
        long ultimo = 0;
        long max = 0;
        co = consulta.getEncabezadoPago();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (EncabezadoPago)it.next();
                if(max == 0) max = ultima.getIdencabezado();
                if(ultima.getIdencabezado() > max) max = ultima.getIdencabezado();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    public long getUltimo(EncabezadoFactura encF)//El encabezadoFactura tiene q tener cargado la Serie
    {
        //Collection co = new ArrayList();
        //EncabezadoFactura ultima = new EncabezadoFactura();
        Consulta consulta = new Consulta();
        long ultimo = consulta.getEncabezadoFactxSerie(encF.getSerieFactura());
        
        SerieFactura serieF = new SerieFactura();
        serieF = consulta.getUnaSerieFactura(encF.getSerieFactura());
        if(ultimo > serieF.getLimite()){
            ultimo = 0;
        }
        return ultimo;              
    }
    public long getUltimoManual(EncabezadoFactura encF)//El encabezadoFactura tiene q tener cargado la Serie
    {
        //Collection co = new ArrayList();
        //EncabezadoFactura ultima = new EncabezadoFactura();
        Consulta consulta = new Consulta();
        long ultimo = encF.getNumeroFactura();
        
        SerieFactura serieF = new SerieFactura();
        serieF = consulta.getUnaSerieFactura(encF.getSerieFactura());
        if(ultimo > serieF.getLimite()){
            ultimo = 0;
        }
        return ultimo;              
    }
    
     public long getUltimoTablaEnc(EncabezadoPago encp)
    {
        Collection co = new ArrayList();
        EncabezadoPago ultima = new EncabezadoPago();
        Consulta consulta = new Consulta();
        long ultimo = 0;
        long max = 0;
        co = consulta.getEncabezadoPago();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (EncabezadoPago)it.next();
                if(max == 0) max = ultima.getIdencabezado();
                if(ultima.getIdencabezado() > max) max = ultima.getIdencabezado();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    public long getUltimo(DetallePago detp)
    {
        Collection co = new ArrayList();
        DetallePago ultima = new DetallePago();
        Consulta consulta = new Consulta();
        long ultimo = 0;
        long max = 0;
        co = consulta.getDetallePago();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (DetallePago)it.next();
                if(max == 0) max = ultima.getIdencabezadopago();
                if(ultima.getIdencabezadopago() > max) max = ultima.getIdencabezadopago();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    
    public int getUltimo(Documento doc)
    {
        Collection co = new ArrayList();
        Documento ultima = new Documento();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getDocumento("algo");
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Documento)it.next();
                if(max == 0) max = ultima.getIdDocumento();
                if(ultima.getIdDocumento() > max) max = ultima.getIdDocumento();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    
    public int getUltimo(TasaAplicable tasa)
    {
        Collection co = new ArrayList();
        TasaAplicable ultima = new TasaAplicable();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTasaAplicable();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (TasaAplicable)it.next();
                if(max == 0) max = ultima.getIdTasaAplicable();
                if(ultima.getIdTasaAplicable() > max) max = ultima.getIdTasaAplicable();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    
    public int getUltimo(PlanoCTotal planoct)
    {
        Collection co = new ArrayList();
        PlanoCTotal ultima = new PlanoCTotal();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getPlanoCTotal();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (PlanoCTotal)it.next();
                if(max == 0) max = ultima.getIdplanoCTotal();
                if(ultima.getIdplanoCTotal() > max) max = ultima.getIdplanoCTotal();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    
    public int getUltimo(PlanoTasa planot)
    {
        Collection co = new ArrayList();
        PlanoTasa ultima = new PlanoTasa();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getPlanoTasa();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (PlanoTasa)it.next();
                if(max == 0) max = ultima.getIdplanotasa();
                if(ultima.getIdplanotasa() > max) max = ultima.getIdplanotasa();
            }
        }  
        max++;    
        return max;     
    }
    
    public int getUltimo(SerieConstancia serie)
    {
        Collection co = new ArrayList();
        SerieConstancia ultima = new SerieConstancia();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getSerie();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (SerieConstancia)it.next();
                if(max == 0) max = ultima.getIdserie();
                if(ultima.getIdserie() > max) max = ultima.getIdserie();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    
    public long getUltimo(EncabezadoCP encCP)
    {
        Consulta consulta = new Consulta();
        long ultimo = consulta.getEncabezadoCPxSerie(encCP.getSerieCP());
        SerieConstancia serieC = new SerieConstancia();
        serieC = consulta.getUnaSerie(encCP.getSerieCP(),"P");
        if(ultimo > serieC.getLimite())
        {
            ultimo = 0;
        }
        return ultimo;     
    }
    
    public long getUltimo(EncabezadoCT encCT)
    {
        Consulta consulta = new Consulta();
        long ultimo = consulta.getEncabezadoCTxSerie(encCT.getSerieCT());
        SerieConstancia serieC = new SerieConstancia();
        serieC = consulta.getUnaSerie(encCT.getSerieCT(),"T");
        if(ultimo > serieC.getLimite())
        {
            ultimo = 0;
        }
        return ultimo;     
    }
    
   public long getUltimo(DetalleCP detCP)
    {
        Consulta consulta = new Consulta();
        long ultimo = consulta.getIdDetalleCPxSerie(detCP.getSerieCP());
        return ultimo;     
    }
   
   public long getUltimo(DetalleCPParaFacturacion detalle)
    {
        Consulta consulta = new Consulta();
        long ultimo = consulta.getIdDetalleFacturacionCPxSerie(detalle.getSerieCP());
        return ultimo;     
    }

    
   public long getUltimo(DetalleCT detCT)
    {
        Consulta consulta = new Consulta();
        long ultimo = consulta.getIdDetalleCTxSerie(detCT.getSerieCT());
        return ultimo;     
    }
    
    public int getUltimo(Usuario user)
    {
        Collection co = new ArrayList();
        Usuario ultima = new Usuario();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoUsuario();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Usuario)it.next();
                if(max == 0) max = ultima.getIdusuario();
                if(ultima.getIdusuario() > max) max = ultima.getIdusuario();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    }
    
    public Long getUltimo(Matriculado mat)
    {        
        Consulta consulta = new Consulta();
        Long ultimo = consulta.getMatricula();
        return ultimo;     
    }
    
    public int getUltimo(Barrio barrio)
    {
        Collection co = new ArrayList();
        Barrio ultima = new Barrio();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoBarrio();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Barrio)it.next();
                if(max == 0) max = ultima.getIdbarrio();
                if(ultima.getIdbarrio() > max) max = ultima.getIdbarrio();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    
    public int getUltimo(Localidad loc)
    {
        Collection co = new ArrayList();
        Localidad ultima = new Localidad();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoLocalidad();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Localidad)it.next();
                if(max == 0) max = ultima.getIdlocalidad();
                if(ultima.getIdlocalidad() > max) max = ultima.getIdlocalidad();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    }
   
    public int getUltimo(Departamento dep)
    {
        Collection co = new ArrayList();
        Departamento ultima = new Departamento();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoDepartamento();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Departamento)it.next();
                if(max == 0) max = ultima.getIddepartamento();
                if(ultima.getIddepartamento() > max) max = ultima.getIddepartamento();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    }
    
    public int getUltimo(Provincia prov)
    {
        Collection co = new ArrayList();
        Provincia ultima = new Provincia();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoProvincia();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Provincia)it.next();
                if(max == 0) max = ultima.getIdprovincia();
                if(ultima.getIdprovincia() > max) max = ultima.getIdprovincia();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    }
    
    public int getUltimo(Rol rol)
    {
        Collection co = new ArrayList();
        Rol ultima = new Rol();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoRol();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Rol)it.next();
                if(max == 0) max = ultima.getIdrol();
                if(ultima.getIdrol() > max) max = ultima.getIdrol();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    }
    
    public int getUltimo(Titulo titulo)
    {
        Collection co = new ArrayList();
        Titulo ultima = new Titulo();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoTitulo();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Titulo)it.next();
                if(max == 0) max = ultima.getIdtitulo();
                if(ultima.getIdtitulo() > max) max = ultima.getIdtitulo();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    }
    
    public int getUltimo(EntidadExterna ee)
    {
        Collection co = new ArrayList();
        EntidadExterna ultima = new EntidadExterna();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoEntidadExterna();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (EntidadExterna)it.next();
                if(max == 0) max = ultima.getIdentidadExterna();
                if(ultima.getIdentidadExterna() > max) max = ultima.getIdentidadExterna();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    }
    
   public int getUltimo(Escuela esc)
    {
        Collection co = new ArrayList();
        Escuela ultima = new Escuela();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoEscuela();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Escuela)it.next();
                if(max == 0) max = ultima.getIdescuela();
                if(ultima.getIdescuela() > max) max = ultima.getIdescuela();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(Nacionalidad nac)
    {
        Collection co = new ArrayList();
        Nacionalidad ultima = new Nacionalidad();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoNacionalidad();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Nacionalidad)it.next();
                if(max == 0) max = ultima.getIdnacionalidad();
                if(ultima.getIdnacionalidad() > max) max = ultima.getIdnacionalidad();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(Producto prod)
    {
        Collection co = new ArrayList();
        Producto ultima = new Producto();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoProducto();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Producto)it.next();
                if(max == 0) max = ultima.getIdproducto();
                if(ultima.getIdproducto() > max) max = ultima.getIdproducto();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(Tasa tasa)
    {
        Collection co = new ArrayList();
        Tasa ultima = new Tasa();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoTasa();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Tasa)it.next();
                if(max == 0) max = ultima.getIdtasa();
                if(ultima.getIdtasa() > max) max = ultima.getIdtasa();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(TipoSeccion tsecc)
    {
        Collection co = new ArrayList();
        TipoSeccion ultima = new TipoSeccion();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoTipoSeccion();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (TipoSeccion)it.next();
                if(max == 0) max = ultima.getIdtipoSeccion();
                if(ultima.getIdtipoSeccion() > max) max = ultima.getIdtipoSeccion();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(TipoTrabajo ttrab)
    {
        Collection co = new ArrayList();
        TipoTrabajo ultima = new TipoTrabajo();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoTipoTrabajo();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (TipoTrabajo)it.next();
                if(max == 0) max = ultima.getIdtipoTrabajo();
                if(ultima.getIdtipoTrabajo() > max) max = ultima.getIdtipoTrabajo();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(TipoSuperficie tsuper)
    {
        Collection co = new ArrayList();
        TipoSuperficie ultima = new TipoSuperficie();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoTipoSuperficie();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (TipoSuperficie)it.next();
                if(max == 0) max = ultima.getIdtipoSuperficie();
                if(ultima.getIdtipoSuperficie() > max) max = ultima.getIdtipoSuperficie();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(Empresa emp)
    {
        Collection co = new ArrayList();
        Empresa ultima = new Empresa();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoEmpresa();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Empresa)it.next();
                if(max == 0) max = ultima.getIdempresa();
                if(ultima.getIdempresa() > max) max = ultima.getIdempresa();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(Iva iva)
    {
        Collection co = new ArrayList();
        Iva ultima = new Iva();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoIva();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Iva)it.next();
                if(max == 0) max = ultima.getIdiva();
                if(ultima.getIdiva() > max) max = ultima.getIdiva();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    
    public int getUltimo(CondicionVenta cventa)
    {
        Collection co = new ArrayList();
        CondicionVenta ultima = new CondicionVenta();
        Consulta consulta = new Consulta();
        int ultimo = 0;
        int max = 0;
        co = consulta.getTodoCondicionVenta();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (CondicionVenta)it.next();
                if(max == 0) max = ultima.getIdcondicionVenta();
                if(ultima.getIdcondicionVenta() > max) max = ultima.getIdcondicionVenta();
            }
        }  
        ultimo = max + 1;    
        return ultimo;     
    } 
    public long getUltimo(Caja caja)
    {
        Collection co = new ArrayList();
        Caja ultima = new Caja();
        Consulta consulta = new Consulta();
        long ultimo = 0;
        long max = 0;
        co = consulta.getCaja();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                ultima = (Caja)it.next();
                if(max == 0) max = ultima.getIdcaja();
                if(ultima.getIdcaja() > max) max = ultima.getIdcaja();
            }
        }  
        ultimo = max + 1;     
        return ultimo;     
    }
    
}
