/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author marcelo
 */
public class Pago 
{
    
    private long idPago;
    private long idCuota;
    private double monto = 0.0;
    private Date fecha;
    private int serFactura;
    private long numeroFactura;

    public Pago() {
    }

    public long getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(long idCuota) {
        this.idCuota = idCuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getIdPago() {
        return idPago;
    }

    public void setIdPago(long idPago) {
        this.idPago = idPago;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getSerFactura() {
        return serFactura;
    }

    public void setSerFactura(int serFactura) {
        this.serFactura = serFactura;
    }
    
    
    
}
