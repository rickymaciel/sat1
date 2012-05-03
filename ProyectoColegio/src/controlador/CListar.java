/*
 * CListar.java
 *
 * Created on 2 de agosto de 2007, 09:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controlador;

/**
 *  Esta clase es el controlador del Listado, por lo  tanto al ser llamada dede
 *  establecer que tipo de listado debe mostrar de acuerdo con los datos que recibe.
 *      Codigo  !   Controlador
 *          0   !       0       ! 0	se recibe sin parametros    
 *          0   !       1       ! 1	se recibe el parametro nombre 
 *          1   !       0       ! 2	se recibe el parametro codigo 
 *          1   !       1       ! 3	se recibe los dos parametros (codigo y controlador) 
 * 
 */
import java.util.*;
import negocios.Barrio;
import Datos.Consulta;
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
import negocios.SerieFactura;
import negocios.Tasa;
import negocios.TasaAplicable;
import negocios.TipoSeccion;
import negocios.TipoSuperficie;
import negocios.TipoTrabajo;
import negocios.Titulo;
import negocios.Usuario;

public class CListar 
{
    
    /** Creates a new instance of CListar */
    public CListar() 
    {
    }
    public Collection listarAnuladosCP()
    {
        Consulta consulta = new Consulta();
        Collection co = new ArrayList();
        co = consulta.getAnuladoCP();
        return co;
    }
    public Collection hacerListado(ProductoTasa pt)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getProductoTasa();
        return co;
    }

    public Collection listarAnuladosCT()
    {
        Consulta consulta = new Consulta();
        Collection co = new ArrayList();
        co = consulta.getAnuladoCT();
        return co;
    }
    
    public boolean buscarCodigoProducto(ProductoTasa pt)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        boolean resp = false;
        co = con.getProductoTasa();
        Iterator it = co.iterator();
        while(it.hasNext())
        {
            ProductoTasa prodtasa = (ProductoTasa)it.next();
//            System.out.println("comparacion en la busqueda = "+pt.getCodigoproducto()+"=="+prodtasa.getCodigoproducto());
            if(pt.getCodigoproducto()== prodtasa.getCodigoproducto() || pt.getCodigotasa()==prodtasa.getCodigotasa()) resp = true;
        }
        return resp;
    }

    public Collection hacerListado(EncabezadoPago encp)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        Filtro filtro = new Filtro();
        switch(filtro.filtrar(encp))
        {
            case 0:
                    co = con.getEncabezadoPago();
                    break;
            case 1:
                    co = con.getEncabezadoPago(encp);
                    break;
        }
        return co;
    }
    public Collection hacerListadoDetalleCT(DetalleCT detalle)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(detalle);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getDetalleCT();
                    break;
            case 1:
                    co = con.getDetalleCTxSerieyCodigo(detalle.getSerieCT(), detalle.getCodigoCT());
                    break;
        }
        return co;
    }
    public Collection hacerListado(DetallePago detp)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getDetallePago(detp.getIdencabezadopago(),detp.getAnio());
        return co;
    }
    
    public Collection hacerListado(Documento doc)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getDocumento();
        return co;
    }
    
    public Collection hacerListadoTasaAplicable(TasaAplicable tasaa)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(tasaa);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getTasaAplicable();
                    break;
            case 1:
                    co = con.getTasaAplicablexConstancia(tasaa.getIdTipoConstancia());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(PlanoCTotal planoT)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getPlanoCTotal();
        return co;
    }
        
    public Collection hacerListado(PlanoTasa planoT)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getPlanoTasa(0);
        return co;
    }
    public Collection hacerListado(SerieConstancia serie)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(serie);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getSerie();
                    break;
            case 1:
                    co = con.getSerieActivas();
                    break;
        }
        return co;
    }
    public Collection hacerListado(SerieFactura serie)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(serie);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getSerieFacturas();
                    break;
            case 1:
                    co = con.getSerieActivasFacturas();
                    break;
        }
        return co;
    }
    public Collection hacerListadoEncabezadoCPxFecha(String  fInicial, String fFinal)
    {
       Collection co = new ArrayList();
       Consulta con = new Consulta();
       co = con.getEncabezadoCPxFecha(fInicial, fFinal);
       return co;
    }
    /**
     * 
     * @param encCP Clase encabezadoCP que contiene el encabezado de la cosntancia parcial
     * @param filtrar especifica si es que hay que filtrar la colecion por algun campo
     *          valores:
     *                  0 -> no filtrar
     *                  1 -> devolver solo aquellas que no fueron facturadas (numero de factura igual a 0)
     * @param fecha1 se cuando se desea obtener los encabezados entre dos fechas
     * si no se desea obtener entre dos fechas se debe pasar un valo cero '0'.
     * @param fecha2 se cuando se desea obtener los encabezados entre dos fechas
     * si no se desea obtener entre dos fechas se debe pasar un valo cero '0'.
     * @return co devuelve la coleccion con los encabezados filtrados o no.
     */
    public Collection hacerListadoEncabezadoCP(EncabezadoCP encCP, int filtrar, String fecha1, String fecha2)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(encCP, fecha1);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getEncabezadoCP();
                    break;
            case 1:
                    co = con.getEncabezadoCPxMatricula(encCP.getMatriculado().getMatricula());
                    break;
            case 2:
                    co = con.getEncabezadoCP(fecha1+" 00:00:00", fecha2+" 23:59:59", encCP.getMatriculado().getMatricula());
                    break;
        }
        
        if(filtrar == 1)
            co = filtro.filtrarParciales(co);
        return co;
    }
/**
     * 
     * @param encCT Clase encabezadoCT que contiene el encabezado de la cosntancia total
     * @param filtrar especifica si es que hay que filtrar la colecion por algun campo
     *          valores:
     *                  0 -> no filtrar
     *                  1 -> devolver solo aquellas que no fueron facturadas (numero de factura igual a 0)
     * @param fecha1 se cuando se desea obtener los encabezados entre dos fechas
     * si no se desea obtener entre dos fechas se debe pasar un valo cero '0'.
     * @param fecha2 se cuando se desea obtener los encabezados entre dos fechas
     * si no se desea obtener entre dos fechas se debe pasar un valo cero '0'.
     * @return co devuelve la coleccion con los encabezados filtrados o no.
     */
    public Collection hacerListadoEncabezadoCT(EncabezadoCT encCT, int filtrar, String fecha1, String fecha2)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(encCT,fecha1);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
//        System.out.println("La fecha que recibe CLIstar es: "+fecha1+" y el filtro devuelve: "+respuesta);
        switch(respuesta)
        {
            case 0:
                    co = con.getEncabezadoCT();
                    break;
            case 1:
                    co = con.getEncabezadoCTxMatricula(encCT.getMatriculado().getMatricula());
                    break;
            case 2:
                    co = con.getEncabezadoCT(fecha1+" 00:00:00", fecha2+" 23:59:59", encCT.getMatriculado().getMatricula());
                    break;
        }
        if(filtrar == 1)
            co = filtro.filtrarTotales(co);
        return co;
    }
    
    /**
     * 
     * @param encCP Clase encabezadoCP que contiene el encabezado de la cosntancia parcial
     * @param filtrar especifica si es que hay que filtrar la colecion por algun campo
     *          valores:
     *                  0 -> no filtrar
     *                  1 -> devolver solo aquellas que no fueron facturadas (numero de factura igual a 0)
     * @return co devuelve la coleccion con los encabezados filtrados o no.
     */
    public Collection hacerListadoEncabezadoCP(EncabezadoCP encCP, int filtrar)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(encCP);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getEncabezadoCP();
                    break;
            case 1:
                    co = con.getEncabezadoCPxMatricula(encCP.getMatriculado().getMatricula());
                    break;
        }
        
        if(filtrar == 1)
            co = filtro.filtrarParciales(co);
        return co;
    }

    
    
    public Collection hacerListadoEncabezadoCTxFecha(String  fInicial, String fFinal)
    {
       Collection co = new ArrayList();
       Consulta con = new Consulta();
       co = con.getEncabezadoCTxFecha(fInicial, fFinal);
       return co;
    }
    
    /**
     * 
     * @param encCT Clase encabezadoCT que contiene el encabezado de la cosntancia total
     * @param filtrar especifica si es que hay que filtrar la colecion por algun campo
     *          valores:
     *                  0 -> no filtrar
     *                  1 -> devolver solo aquellas que no fueron facturadas (numero de factura igual a 0)
     * @return co devuelve la coleccion con los encabezados filtrados o no.
     */
    public Collection hacerListadoEncabezadoCT(EncabezadoCT encCT, int filtrar)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(encCT);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getEncabezadoCT();
                    break;
            case 1:
                    co = con.getEncabezadoCTxMatricula(encCT.getMatriculado().getMatricula());
                    break;
        }
        if(filtrar == 1)
            co = filtro.filtrarTotales(co);
        return co;
    }

    
    public int validarNombre(String nombre)
    {
       int esta = 0;
       CListar listar = new CListar();
       Collection co = new ArrayList();
       Usuario user2 = new Usuario();
       co = listar.hacerListado(user2);
       Iterator it = co.iterator();
       while(it.hasNext())
        {
            Usuario u = (Usuario)it.next();
            if(nombre.trim().equals(u.getNombre().trim()))
                esta = 1;
        }
        return esta;
       
    }
    
    public boolean obtenerfoto(String destino, String matricula)
    {
        boolean resp = false;
        Consulta consulta = new Consulta();
        resp = consulta.recuperarFoto(destino, matricula);
        return resp;
    }
    
    public Configuracion hacerListado(Configuracion conf)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getConfiguracion();
        Configuracion c = new Configuracion();
        if (co.size() != 0)
        {
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                c = (Configuracion)it.next();
            }
        }
        return c;
    }
    
    public Collection hacerListado(ConstanciaHabilitacion chab)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getConstanciaHabilitacion();
        return co;
    }
    
    public Collection hacerListado(Usuario user)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(user);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getUsuario();
                    break;
            case 1:
                    co = con.getUsuario(user.getNombre());
                    break;
        }
        return co;
    }
    
    public Matriculado soloMatriculado(Matriculado mat)
    {
        Matriculado resp = new Matriculado();
        Consulta consulta = new Consulta();
        resp = consulta.getUnMatriculado(mat.getMatricula());
        return resp;
    }
    
    public Collection hacerListado(Matriculado mat)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(mat);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getMatriculado();
                    break;
            case 1:
                    co = con.getMatriculado(mat.getEspecialidad());
                    break;
            case 2:
                    co = con.getMatriculado(mat.getHabilitado(),mat.getNombres());
                    break;
            case 3:
                    co = con.getMatriculado(mat.getApellido(),respuesta);
                    break;
            case 4:
                    co = con.getMatriculado(mat.getMatricula());
                    break;
            case 5 :
                    co =con.getMatriculadoTitulo(mat.getExiste(), mat.getTitulo().getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListadoMat(String param)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        if(param == null)
        {
            co = con.getMatriculado();
        }else{
            co = con.getMatriculadoxParametros(param);
        }
        return co;
    }
    public Collection hacerListadoMat2(String param)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        if(param == null)
        {
            co = con.getMatriculado2();
        }else{
            co = con.getMatriculadoxParametros2(param);
        }
        return co;
    }
    
    public Collection hacerListado(Barrio barrio)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(barrio);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getBarrio();
                    break;
            case 1:
                    co = con.getBarrio(barrio.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(Localidad loc)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(loc);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getLocalidad();
                    break;
            case 1:
                    co = con.getLocalidad(loc.getNombre());
                    break;
        }
        return co;
    }
    
     public Collection hacerListado(Provincia prov)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(prov);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getProvincia();
                    break;
            case 1:
                    co = con.getProvincia(prov.getNombre());
                    break;
        }
        return co;
    }
    
     public Collection hacerListado(Departamento dep)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(dep);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getDepartamento();
                    break;
            case 1:
                    co = con.getDepartamento(dep.getNombre());
                    break;
        }
        return co;
    }
    
     public Collection hacerListado(Rol rol)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(rol);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getRol();
                    break;
            case 1:
                    co = con.getRol(rol.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(Titulo titulo)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(titulo);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getTitulo();
                    break;
            case 1:
                    co = con.getTitulo(titulo.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(EntidadExterna ee)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(ee);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getEntidadExterna();
                    break;
            case 1:
                    co = con.getEntidadExterna(ee.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(Escuela esc)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(esc);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getEscuela();
                    break;
            case 1:
                    co = con.getEscuela(esc.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(Nacionalidad nac)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(nac);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getNacionalidad();
                    break;
            case 1:
                    co = con.getNacionalidad(nac.getNombre());
                    break;
        }
        return co;
    }
    
    public Producto obtenerProducto(int idproducto)
    {
        Consulta con = new Consulta();
        Producto res = new Producto();
        res = con.getProducto(idproducto);
        return res;
    }
    
    public Collection hacerListado(Producto prod)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(prod);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getProducto();
                    break;
            case 1:
                    co = con.getProducto(prod.getDenominacion());
                    break;
            case 2:
                    co.clear();
                    co.add(con.getProducto(prod.getIdproducto()));
                    break;
        }
        return co;
    }
    public Collection hacerListadoDetalleCP(DetalleCP detalle)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(detalle);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getDetalleCP();
                    break;
            case 1:
                    co = con.getDetalleCPxSerieyCodigo(detalle.getSerieCP(), detalle.getCodigoCP());
                    break;
        }
        return co;
    }
    public Collection armarDetalleFactura(String serie, String codigo, String documento)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(documento);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                // obtiene una coleccion de tasas aplicables a constancias parciales
                    co = con.armarDetalleCP(serie, codigo); 
                    break;
            case 1:
                // obtiene una coleccion de tasas aplicables a constancias totales
                    co = con.armarDetalleCT(serie, codigo);
                    break;
        }
        return co;
    }
    public Producto listar(Tasa tasa)
    {
        Producto prod = new Producto();
        Consulta con = new Consulta();
        prod = con.getProducto(String.valueOf(tasa.getIdtasa()), "algo");
        return prod;
    }
    public Collection listar(String serie, long codigo)
    {
        Consulta con = new Consulta();
        return con.getTasasSelecciondas(serie, codigo);
    }

    public Collection hacerListado(Tasa tasa)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(tasa);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getTasa();
                    break;
            case 1:
                    co = con.getTasa(tasa.getDenominacion());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(TipoSeccion tsec)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(tsec);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getTipoSeccion();
                    break;
            case 1:
                    co = con.getTipoSeccion(tsec.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(TipoTrabajo ttrab)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(ttrab);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getTipoTrabajo();
                    break;
            case 1:
                    co = con.getTipoTrabajo(ttrab.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(TipoSuperficie tsuper)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(tsuper);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getTipoSuperficie();
                    break;
            case 1:
                    co = con.getTipoSuperficie(tsuper.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(Empresa emp)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(emp);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getEmpresa();
                    break;
            case 1:
                    co = con.getEmpresa(emp.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(Iva iva)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(iva);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getIva();
                    break;
            case 1:
                    co = con.getIva(iva.getNombre());
                    break;
        }
        return co;
    }
    
    public Collection hacerListado(CondicionVenta cventa)
    {
        Filtro filtro = new Filtro();
        int respuesta = filtro.filtrar(cventa);
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        switch(respuesta)
        {
            case 0:
                    co = con.getCondicionVenta();
                    break;
            case 1:
                    co = con.getCondicionVenta(cventa.getNombre());
                    break;
        }
        return co;
    }
    public double totalCaja(Caja caja)
    {
        Consulta con = new Consulta();
        return con.getTotalFactura(caja.getIdcaja());
    }
    
    public Caja ultimaCaja(Caja caja)
    {
//        Collection co = new ArrayList();
//        co = this.hacerListado(caja);
//        Iterator it = co.iterator();
//        Caja c = new Caja();
        
        Collection co = new ArrayList();
        Consulta consul=new Consulta();        
        co = consul.getUltimaCaja();
        Iterator it = co.iterator();
        Caja c = new Caja();        
        
        if(co.size() == 0){//este es el caso en que la base de datos Cajas este vacia
            caja.setIdcaja(0);
            caja.setEstado("C");
        }else{
            while(it.hasNext())
            {
                c = (Caja)it.next();
                caja = c;
//                System.out.println("ID CAJA EN COLLECTION: "+caja.getIdcaja());
            }
        }
        return caja;
    }
    
    public Collection hacerListado(Caja caja){
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getCaja();
        return co;
    }
    public Collection hacerListadoCajas(){
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getCajasTodas();
        return co;
    }
     public Collection hacerListado(EncabezadoFactura encf)
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getEncabezadoFactura(encf.getCaja().getIdcaja());
        return co;
    }
    public Collection hacerListadoTodasLasFacturas()
    {
        Consulta con = new Consulta();
        Collection co = new ArrayList();
        co = con.getEncabezadoFacturaTodas();
        return co;
    }
     public Matriculado parcialxMatriculado(Matriculado mat)
    {
        Matriculado resp = new Matriculado();
        Consulta consulta = new Consulta();
        resp = consulta.getMatriculadoconfechas(mat.getMatricula());
        return resp;
    }
     public Date ultimaFechaEncabezadoPago(long idmatriculado)
    {
        Consulta con = new Consulta();
        Date resp = con.getFechaEncabezadoPago(idmatriculado);
        return resp;
    }
     public Caja unaCaja(long idcaja)
    {
        Caja resp = new Caja();
        Consulta consulta = new Consulta();
        resp = consulta.getUnaCaja(idcaja);
        return resp;
    }
    public int cantidadCajas()
    {
        Consulta con = new Consulta();
        int cantidad = con.cantidadCajas();
        return cantidad;
    }
    public int cantidadMat(String tipo)
    {
        Consulta con = new Consulta();
        int cantidad = con.cantidadMatriculados(tipo);
        return cantidad;
    }
}
