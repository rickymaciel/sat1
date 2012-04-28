/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Gustavo
 */
public class DetallePago {
    
    private long idencabezadopago;
    private int anio;
    private int mes;
    private double importe;
    private long idproducto;
    
    public DetallePago()
    {
        
    }

    public long getIdencabezadopago() {
        return idencabezadopago;
    }

    public void setIdencabezadopago(long idencabezadopago) {
        this.idencabezadopago = idencabezadopago;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(long idproducto) {
        this.idproducto = idproducto;
    }

}
