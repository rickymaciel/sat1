/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import negocios.Producto;

/**
 *
 * @author marcelo
 */
public class DetallePago 
{
    private long idDetalle;
    private Producto producto;
    private long idPago;

    public DetallePago() {
    }

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public long getIdPago() {
        return idPago;
    }

    public void setIdPago(long idPago) {
        this.idPago = idPago;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
