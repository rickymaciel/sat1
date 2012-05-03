/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author marcelo gonzalez
 */
public class DetalleFacturacionCP extends DetalleCP
{
    private String denominacion;
    private String trabajo;
    private double tasaMinima;
    private double total;
    
    public DetalleFacturacionCP()
    {
        
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public double getTasaMinima() {
        return tasaMinima;
    }

    public void setTasaMinima(double tasaMinima) {
        this.tasaMinima = tasaMinima;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
