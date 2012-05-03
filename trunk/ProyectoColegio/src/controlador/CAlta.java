/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

/**
 *
 * @author asus
 */
import Datos.Alta;
import Datos.Consulta;
import Datos.Modificacion;
import java.util.ArrayList;
import java.util.Collection;
import negocios.Barrio;
import negocios.Caja;
import negocios.CondicionVenta;
import negocios.Configuracion;
import negocios.ConstanciaHabilitacion;
import negocios.Departamento;
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
import negocios.Localidad;
import negocios.Matriculado;
import negocios.Nacionalidad;
import negocios.PlanoCTotal;
import negocios.PlanoTasa;
import negocios.Producto;
import negocios.ProductoTasa;
import negocios.Provincia;
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


public class CAlta {
    
    CUltimo ultimo = new CUltimo();
    
    public CAlta()
    {
    }
    public int hacerAlta(ProductoTasa pt)
    {
        Alta alta = new Alta();
        int respuesta = alta.almacenar(pt);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    public int hacerAlta(EncabezadoPago encp)
    {
        Alta alta = new Alta();
        Collection co = new ArrayList();
        long ul = ultimo.getUltimo(encp);
        encp.setIdencabezado(ul);
        int respuesta = alta.almacenar(encp);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    public int hacerAlta(EncabezadoFactura encf){
        Alta alta = new Alta();
        //Collection co = new ArrayList();
        
        //long ul = ultimo.getUltimo(encf);
        
        //encf.setNumeroFactura(ul);
        
        int respuesta = alta.almacenar(encf);        
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    public int hacerAlta(DetallePago detp)
    {
        Alta alta = new Alta();
        //Collection co = new ArrayList();
//        long ul = ultimo.getUltimo(detp);
//        detp.setIdencabezadopago(ul);
        int respuesta = alta.almacenar(detp);
//        System.out.println("Se almacenaron "+String.valueOf(respuesta)+" registros");
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    public int hacerAlta(DetalleFactura detF)
    {
        Alta alta = new Alta();
        //Collection co = new ArrayList();
//        long ul = ultimo.getUltimo(detp);
//        detp.setIdencabezadopago(ul);
        int respuesta = alta.almacenar(detF);
//        System.out.println("Se almacenaron "+String.valueOf(respuesta)+" registros");
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    
    public int hacerAlta(Documento doc)
    {
        Alta alta = new Alta();
        Collection co = new ArrayList();
        int ul = ultimo.getUltimo(doc);
        doc.setIdDocumento(ul);
        int respuesta = alta.almacenar(doc);
        return ul;
    }
    
    public int hacerAlta(PlanoCTotal planoct)
    {
        Alta alta = new Alta();
        Collection co = new ArrayList();
        int ul = ultimo.getUltimo(planoct);
        planoct.setIdplanoCTotal(ul);
        int respuesta = alta.almacenar(planoct);
        return ul;
    }
    
    public int hacerAlta(TasaAplicable tasa)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(tasa);
        tasa.setIdTasaAplicable(ul);
        int respuesta = alta.almacenar(tasa);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    
     public int hacerAlta(PlanoTasa planot)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(planot);
        planot.setIdplanotasa(ul);
        int respuesta = alta.almacenar(planot);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    
    public int hacerAltaSerie(SerieConstancia serie)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(serie);
        int respuesta = 4;
        if(ul != 0)
        {
            serie.setIdserie(ul);
            respuesta = alta.almacenar(serie);
            if (respuesta == 0)
            {
                respuesta = 3;
            }
            else{
                respuesta = 0;
            }
        }      
        return respuesta;
    }
    
    public int hacerAltaEncabezadoCP(EncabezadoCP encCP, boolean bandera)
    {
        Alta alta = new Alta();
        int respuesta = 4;
        if(bandera)
        {
            long ul = ultimo.getUltimo(encCP);
            
            if(ul != 0)
            {
                encCP.setCodigoCP(ul);
                
            }
        }
        respuesta = alta.almacenar(encCP);
        if (respuesta == 0)
            respuesta = 3;
        else
            respuesta = 0;
        return respuesta;
    }
    
    public int hacerAltaEncabezadoCT(EncabezadoCT encCT, boolean bandera)
    {
        Alta alta = new Alta();
        int respuesta = 4;
        if(bandera)
        {
            long ul = ultimo.getUltimo(encCT);
            if(ul != 0)
            {
                encCT.setCodigoCT(ul);
            }
        }
        
            respuesta = alta.almacenar(encCT);
            if (respuesta == 0)
            {
                respuesta = 3;//Codigo de error
            }
            else{
                respuesta = 0;//esta todo OK, se almaceno
            }
             
        return respuesta;
    }
    
    public int hacerAltaDetalleCP(DetalleCP detCP)
    {
        Alta alta = new Alta();
        long ul = ultimo.getUltimo(detCP);
        detCP.setIddetalleCP(ul);
        int respuesta = alta.almacenar(detCP);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    
    /**
     * Este metodo lleva a cabo el alta dell detalle de la facturacion para la cp
     * @param detCP
     * @return
     */
     public int hacerAltaDetalleFacturacionCP(DetalleCPParaFacturacion detCP)
    {
        Alta alta = new Alta();
        long ul = ultimo.getUltimo(detCP);
        detCP.setIddetalle(Integer.parseInt(String.valueOf(ul)));
        int respuesta = alta.almacenar(detCP);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    
    public int hacerAltaDetalleCT(DetalleCT detCT)
    {
        Alta alta = new Alta();
        long ul = ultimo.getUltimo(detCT);
        detCT.setIddetalleCT(ul);
        int respuesta = alta.almacenar(detCT);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    
    public int hacerAltaFoto(String foto, String matricula)
    {
        Alta alta = new Alta();
        int r = 0;
        int respuesta = alta.insertarFoto(foto, matricula);
        if (respuesta == 1)
        {
            r = 0;
        }else{
            r = 3;
        }
        return r;
    }
    
    public int hacerAlta(Configuracion conf)
    {        
        Modificacion mod = new Modificacion();
        int ul = 1;
        conf.setIdconfiguracion(ul);
        int respuesta = mod.modificar(conf);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    
    }
    
    public int hacerAlta(ConstanciaHabilitacion chab)
    {
        Alta alta = new Alta();
        int ul = 1;
        chab.setIdconstanciaHabilitacion(ul);
        int respuesta = alta.almacenar(chab);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    
    public int hacerAlta(Usuario user)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(user);
        user.setIdusuario(ul);
        int respuesta = alta.almacenar(user);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    
    public int hacerAlta(Matriculado mat)
    {
        Alta alta = new Alta();
        long ul = ultimo.getUltimo(mat);
        mat.setIdmatriculado(ul);
        int respuesta = alta.almacenar(mat);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    
    public int hacerAlta(Provincia prov)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(prov);
        prov.setIdprovincia(ul);
        int respuesta = alta.almacenar(prov);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Departamento dep)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(dep);
        dep.setIddepartamento(ul);
        int respuesta = alta.almacenar(dep);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Localidad loc)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(loc);
        loc.setIdlocalidad(ul);
        int respuesta = alta.almacenar(loc);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Barrio barrio)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(barrio);
        barrio.setIdbarrio(ul);
        int respuesta = alta.almacenar(barrio);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Rol roles)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(roles);
        roles.setIdrol(ul);
        int respuesta = alta.almacenar(roles);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Titulo titulo)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(titulo);
        titulo.setIdtitulo(ul);
        int respuesta = alta.almacenar(titulo);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(EntidadExterna ee)
    {
        Alta alta = new Alta();
        int ul =ultimo.getUltimo(ee);
        ee.setIdentidadExterna(ul);
        int respuesta = alta.almacenar(ee);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Escuela escuela)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(escuela);
        escuela.setIdescuela(ul);
        int respuesta = alta.almacenar(escuela);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Nacionalidad nac)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(nac);
        nac.setIdnacionalidad(ul);
        int respuesta = alta.almacenar(nac);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Producto prod)
    {
        Alta alta = new Alta();
        Consulta consulta = new Consulta();
        int existe = consulta.getProductoExiste(prod);
        int respuesta = 0;
        if (existe == 0)
        {
            respuesta = alta.almacenar(prod);
            if(respuesta != 0) respuesta = 0;
        }
        if(existe == 1)
        {
            respuesta = 3;
        }
        return respuesta;
    }

public int hacerAlta(Tasa tasas)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(tasas);
        tasas.setIdtasa(ul);
        int respuesta = alta.almacenar(tasas);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(TipoSeccion tsecciones)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(tsecciones);
        tsecciones.setIdtipoSeccion(ul);
        int respuesta = alta.almacenar(tsecciones);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(TipoTrabajo ttrabajo)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(ttrabajo);
        ttrabajo.setIdtipoTrabajo(ul);
        int respuesta = alta.almacenar(ttrabajo);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(TipoSuperficie tsuper)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(tsuper);
        tsuper.setIdtipoSuperficie(ul);
        int respuesta = alta.almacenar(tsuper);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

public int hacerAlta(Empresa empresa)
    {
        Alta alta = new Alta();
        Consulta consulta = new Consulta();
        Collection con = new ArrayList();
        con = consulta.getEmpresa();
        int respuesta = 0;
        if (con.size() == 0)
        {
            int indice = 1;
            empresa.setIdempresa(indice);
            respuesta = alta.almacenar(empresa);
        }else
        {
            Modificacion mod = new Modificacion();
            respuesta = mod.modificar(empresa);
        }
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    public int hacerAlta(Iva iva)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(iva);
        iva.setIdiva(ul);
        int respuesta = alta.almacenar(iva);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    public int hacerAlta(CondicionVenta cventa)
    {
        Alta alta = new Alta();
        int ul = ultimo.getUltimo(cventa);
        cventa.setIdcondicionVenta(ul);
        int respuesta = alta.almacenar(cventa);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }

    public int hacerAlta(String serie, long codigoCp, int matricula, int tasa)
    {
        Alta alta = new Alta();
        int respuesta = alta.almacenar(serie,codigoCp,matricula,tasa);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else
        {
            respuesta = 0;
        }
        return respuesta;
    }
    public int hacerAlta(Caja caja)
    {
        Alta alta = new Alta();
        int respuesta = alta.almacenar(caja);
        if (respuesta == 0)
        {
            respuesta = 3;
        }
        else{
            respuesta = 0;
        }
        return respuesta;
    }
    public int hacerAlta(TasaSeleccionada t)
    {
        Alta alta = new Alta();
        int respuesta = alta.almacenar(t);
        if (respuesta == 0)
            respuesta = 3;
        else
            respuesta = 0;
        return respuesta;
    }


}

