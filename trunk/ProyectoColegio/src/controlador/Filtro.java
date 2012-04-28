/*
 * Filtro.java
 *
 * Created on 2 de agosto de 2007, 09:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import negocios.Barrio;
import negocios.CondicionVenta;
import negocios.Departamento;
import negocios.DetalleCP;
import negocios.DetalleCT;
import negocios.Empresa;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.EncabezadoPago;
import negocios.EntidadExterna;
import negocios.Escuela;
import negocios.Iva;
import negocios.Localidad;
import negocios.Matriculado;
import negocios.Nacionalidad;
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
 *  Este filtro tiene la funcion de determinar que metodo getMesa() se va ejecutar
 *  Desde aqui se obtiene el par de numeros que va a decidir que tipo de opcion se va 
 *  elegir.
 */
public class Filtro {
    
    /** Creates a new instance of Filtro */
    public Filtro() 
    {
    }
    
   /* public int filtrar(PuntodeVenta pdventa)
    {
        int a;
        if(pdventa.get ==null)
            a=0;
        else
            a=1;
       return a;
    }*/
    
    public int filtrar(TasaAplicable tasa)
    {
        int a;
        if(tasa.getIdTipoConstancia() == 0)
            a=0;
        else
            a=1;
        return a;
    }
    
    public int filtrar(SerieConstancia serie)
    {
        int a;
        if(serie.getActivo() ==null)
            a=0;
        else
            a=1;
       return a;
    }
    public int filtrar(SerieFactura serie)
    {
        int a;
        if(serie.getActivo() ==null)
            a=0;
        else
            a=1;
       return a;
    }

    public int filtrar(EncabezadoCP encCP)
    {
        int a;
        if(encCP.getMatriculado() == null)
            a = 0;
        else
            a = 1;
        return a;
    }


    public int filtrar(EncabezadoCT encCT)
    {
        int a;
        if(encCT.getMatriculado() == null)
            a = 0;
        else
            a = 1;
        return a;
    }
    public int filtrar(DetalleCP detalle)
    {
        int a;
        if(detalle.getCodigoCP() == 0)
            a=0;
        else
            a=1;
        return a;
    }
     public int filtrar(DetalleCT detalle)
    {
        int a;
        if(detalle.getCodigoCT() == 0)
            a=0;
        else
            a=1;
        return a;
    }

    
    public int filtrar(Usuario user)
    {
        int a;
        if(user.getNombre() ==null)
            a=0;
        else
            a=1;
       return a;
    }
    
//    public int filtrar(Matriculado mat)
//    {
//        int a;
//        
//        if(mat.getEspecialidad() == null)
//            if(mat.getHabilitado() == null)
//                if(mat.getApellido() == null)
//                    if(mat.getMatricula() == 0)                        
//                        if(mat.getTitulo()==null)
//                            a = 0;
//                        else
//                            a = 5;
//                    else
//                        a = 4;
//                else
//                    a = 3;
//            else
//                a= 2;
//        else
//            a=1;
//       return a;
//    }
    
    public int filtrar(Matriculado mat)
    {
        int a;
        
        if(mat.getEspecialidad() == null)
            if(mat.getHabilitado() == null)
                if(mat.getApellido() == null)
                    if(mat.getMatricula() == 0)                        
                        if(mat.getTitulo().getNombre() == null)                        
                            a = 0;
                        else
                            a = 5;
                    else
                        a = 4;
                else
                    a = 3;
            else
                a= 2;
        else
            a=1;
       return a;
    }
    
    public int filtrar(EncabezadoCP encCP, String fecha1)
    {
        int a;
        
        if(encCP.getMatriculado() == null)
            a = 0;
        else
            if(fecha1.equals("0"))
                a = 1;
            else
                a = 2;
        return a;
    }
public int filtrar(EncabezadoCT encCT, String fecha1)
    {
        int a;
        
        if(encCT.getMatriculado() == null)
            a = 0;
        else
            if(fecha1.equals("0"))
                a = 1;
            else
                a = 2;
        return a;
    }

    
    public int filtrar(Barrio ba)
    {
        int a;
        if(ba.getNombre() ==null)
            a=0;
        else
            a=1;
        return a;
    }
    
    public int filtrar(Localidad loc)
    {
        int a;
        if(loc.getNombre() ==null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(Provincia prov)
    {
        int a;
        if(prov.getNombre() ==null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(Departamento dep)
    {
        int a;
        if(dep.getNombre() ==null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(Rol rol)
    {
        int a;
        if(rol.getNombre() ==null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(Titulo titulo)
    {
        int a;
        if(titulo.getNombre() ==null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(EntidadExterna ee)
    {
        int a;
        if(ee.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(Escuela esc)
    {
        int a;
        if(esc.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(Nacionalidad nac)
    {
        int a;
        if(nac.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }
    public int filtrar(String documento)
    {
        int a;
        if(documento.trim().equals("CP"))
            a=0;
        else
            a=1;
        return a;
    }
    public int filtrar(Producto prod)
    {
        int a;
        if(prod.getDenominacion() == null)
            a=0;
        else
            a=1;
        if(prod.getIdproducto() != 0)
            a=2;
        return a;
    }


    public int filtrar(Tasa tasa)
    {
        int a;
        if(tasa.getDenominacion() == null)
            a=0;
        else
            a=1;
        return a;
    }

    public int filtrar(TipoSeccion tsec)
    {
        int a;
        if(tsec.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }
    
    public int filtrar(TipoTrabajo ttrab)
    {
        int a;
        if(ttrab.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }
    
    public int filtrar(TipoSuperficie tsuper)
    {
        int a;
        if(tsuper.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }
    
    public int filtrar(Empresa emp)
    {
        int a;
        if(emp.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }
    
    public int filtrar(Iva iva)
    {
        int a;
        if(iva.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }
    
    public int filtrar(CondicionVenta cventa)
    {
        int a;
        if(cventa.getNombre() == null)
            a=0;
        else
            a=1;
        return a;
    }
    public Collection filtrarParciales(Collection constancias)
    {
        Collection temp = new ArrayList();
        Iterator i = constancias.iterator();
        while(i.hasNext())
        {
            EncabezadoCP cp = (EncabezadoCP)i.next();
            if(cp.getNumeroFactura() == 0)
                temp.add(cp);
            cp = null;
        }
        return temp;
    }
    public Collection filtrarTotales(Collection constancias)
    {
        Collection temp = new ArrayList();
        Iterator i = constancias.iterator();
        while(i.hasNext())
        {
            EncabezadoCT cp = (EncabezadoCT)i.next();
            if(cp.getNumeroFactura() == 0)
                temp.add(cp);
            cp = null;
        }
        return temp;
    }
    
public int filtrar(EncabezadoPago enc)
    {
        int a;
        if(enc.getIdmatriculado() == 0)
            a=0;
        else
            a=1;
       return a;
    }

}
