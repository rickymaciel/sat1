/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Collection;
import java.util.Date;
import negocios.Producto;

/**
 *
 * @author marcelo
 */
public class Cuota 
{
    private long id;
    private Date periodo;
    private long idAlumno;
    private long inscripcion;
    private double monto;
    private boolean pagado;
    private int serieFactura;
    private long numeroFactura;
    private boolean cuota;
    private Collection <Pago> pagos;
    private Pago pago;
    private Producto producto;
    

    public Cuota() {
    }

    public boolean isCuota() {
        return cuota;
    }

    public void setCuota(boolean cuota) {
        this.cuota = cuota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public long getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(long inscripcion) {
        this.inscripcion = inscripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public int getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(int serieFactura) {
        this.serieFactura = serieFactura;
    }

    public Collection<Pago> getPagos() {
        return pagos;
    }

    public void setPago(Collection<Pago> pagos) {
        this.pagos = pagos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    
    
}
