/*
 * CFacturacion.java
 *
 * Created on 4 de octubre de 2007, 10:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controlador;

import java.util.Collection;
import java.util.Iterator;
import negocios.DetalleFactura;
import negocios.DetallePago;
import negocios.EncabezadoFactura;
import negocios.EncabezadoPago;

/**
 *
 * @author Gonzalez, Omar Marcelo
 */
public class CFacturacion
{
  //  private VentanaPedidos ventanaPedidos = new VentanaPedidos();
    
    /** Crea una nueva instancia de CFacturacion */
    public CFacturacion()
    {
        //this.ventanaPedidos = ventanaPedidos;
    }
    
    /**
     *Este metodo se encarga de dar de alta el encabezado y detalle de la Constancias Parciales
     *@param e objeto EncabezadoCP que contiene los datos necesarios para cargar en la tabla EncFactura.
     *@param detalles coleccion de objetos del tipo DetalleCP que contiene los datos necesarios para cargar en la tabla DetFactura.
     *@return respuesta contiene la respuesta a devolver a la ventana VentanaCerrarMesa, los valores pueden ser:
     *0 -> error de entrada/salida
     *1 -> operacion exitosa
     *4 -> error en el indice que sobrepasa el rando al insertar el encabezado (definido en la tabla configuracion) 
     */
    
    /*public int facturar(EncabezadoCP e, Collection detalle)
    {
        int respuesta = 0;
        CAlta calta = new CAlta();
        int registrosAlmacenados = calta.hacerAltaEncabezadoCP(e);
        respuesta = registrosAlmacenados; // si es 4 es porque esta fuera del rango establecido en Configuraicon.codigomaximoCP
        if (respuesta != 4)
        {
            if(respuesta != 0) // solo se guarda el detalle de la factura si se guardo correctamente el encabezado
            {
                // se almacenan los detalles de la factura
                Iterator it = detalle.iterator();
                while(it.hasNext())
                {
                    DetalleCP d = (DetalleCP)it.next();
                    registrosAlmacenados = calta.hacerAltaDetalleCP(d);
                }
                respuesta = registrosAlmacenados;
            }
        } 
        return respuesta;
    }*/
           
    /**
     *Este metodo se encarga de dar de alta el encabezado y detalle del Constancias Totales
     *@param e objeto EncabezadoCT que contiene los datos necesarios para cargar en la tabla EncTicket.
     *@param detalles coleccion de objetos del tipo DetalleCT que contiene los datos necesarios para cargar en la tabla DetTicket.
     *@return respuesta contiene la respuesta a devolver a la ventana VentanaCerrarMesa, los valores pueden ser:
     *0 -> error de entrada/salida
     *1 -> operacion exitosa
     *4 -> error en el indice que sobrepasa el rando al insertar el encabezado (definido en la tabla configuracion) 
     */
   /* public int guardarTicket(EncabezadoCT e, Collection detalle)
    {
        int respuesta = 0;
        CAlta calta = new CAlta();
        int registrosAlmacenados = calta.hacerAltaEncabezadoCT(e);
        respuesta = registrosAlmacenados; // si es 4 es porque esta fuera del rango establecido en Configuraicon.codigomaximoCT
        if (respuesta != 4)
        {
            if(respuesta != 0) // solo se guarda el detalle de la factura si se guardo correctamente el encabezado
            {
                // se almacenan los detalles de la factura
                Iterator it = detalle.iterator();
                while(it.hasNext())
                {
                    DetalleCT d = (DetalleCT)it.next();
                    registrosAlmacenados = calta.hacerAltaDetalleCT(d);
                }
                respuesta = registrosAlmacenados;
            }
        } 
        return respuesta;
    }*/
    
    public int facturar(EncabezadoPago e, Collection detalle)
    {
        int respuesta = 0;
        boolean bandera = true;
        CAlta calta = new CAlta();
        int registrosAlmacenados = calta.hacerAlta(e);
//        System.out.println("Cuando se guarda el encabezado pago, el metodo devuelve: "+String.valueOf(registrosAlmacenados));
        //System.out.println(e.get)
        respuesta = registrosAlmacenados; // si es 4 es porque esta fuera del rango establecido en Configuraicon.codigomaximoCP
        if (respuesta != 4)
        {
            if(respuesta == 0) // solo se guarda el detalle de la factura si se guardo correctamente el encabezado
            {
                // se almacenan los detalles de la factura
                Iterator it = detalle.iterator();
                while(it.hasNext())
                {
                    DetallePago d = (DetallePago)it.next();
                    registrosAlmacenados = calta.hacerAlta(d);
//                    System.out.println("Cuando se guarda el detalle pago, el metodo devuelve: "+String.valueOf(registrosAlmacenados));
                    if(registrosAlmacenados != 0)
                        bandera = false;
                }
                respuesta = registrosAlmacenados;
            }
        } 
        if(!bandera)
            respuesta = 0;
        else
            respuesta = 1;
        return respuesta;
    }
    public int facturar(EncabezadoFactura e, Collection detalleFactura)
    {
        int respuesta = 0;
        boolean bandera = true;
        CAlta calta = new CAlta();
        int registrosAlmacenados = calta.hacerAlta(e);
//        System.out.println("Cuando se guarda el encabezado pago, el metodo devuelve: "+String.valueOf(registrosAlmacenados));
        //System.out.println(e.get)
        respuesta = registrosAlmacenados; // si es 4 es porque esta fuera del rango establecido en Configuraicon.codigomaximoCP
        if (respuesta != 4)
        {
            if(respuesta == 0) // solo se guarda el detalle de la factura si se guardo correctamente el encabezado
            {
                
//                System.out.println("SE GUARDO CORRECTAMENTE EL ENCABEZADO...");
//                 se almacenan los detalles de la factura
                Iterator it = detalleFactura.iterator();
                while(it.hasNext()){
                    DetalleFactura d = (DetalleFactura)it.next();                    
                    registrosAlmacenados = calta.hacerAlta(d);
                    d=null;
                    if(registrosAlmacenados != 0)
                        bandera = false;
                }
                respuesta = registrosAlmacenados;
            }
        } 
        if(!bandera)
            respuesta = 0;
        else
            respuesta = 1;
        return respuesta;
    }
}
