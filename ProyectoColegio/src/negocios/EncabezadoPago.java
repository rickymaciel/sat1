/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class EncabezadoPago {

    private long idencabezado;
    private long idmatriculado;
    private double total;
    private Date fechapago;
    private Date habilitacionhasta;
    private long seriefactura;
    private long nrofactura;
    private long matricula;
        
    public EncabezadoPago()
    {
        
    }

    public long getIdencabezado() {
        return idencabezado;
    }

    public void setIdencabezado(long idencabezado) {
        this.idencabezado = idencabezado;
    }

    public long getIdmatriculado() {
        return idmatriculado;
    }

    public void setIdmatriculado(long idmatriculado) {
        this.idmatriculado = idmatriculado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Date getHabilitacionhasta() {
        return habilitacionhasta;
    }

    public void setHabilitacionhasta(Date habilitacionhasta) {
        this.habilitacionhasta = habilitacionhasta;
    }

    public long getSeriefactura() {
        return seriefactura;
    }

    public void setSeriefactura(long seriefactura) {
        this.seriefactura = seriefactura;
    }

    public long getNrofactura() {
        return nrofactura;
    }

    public void setNrofactura(long nrofactura) {
        this.nrofactura = nrofactura;
    }

    public long getMatricula()
    {
        return matricula;
    }

    public void setMatricula(long matricula)
    {
        this.matricula = matricula;
    }
}
