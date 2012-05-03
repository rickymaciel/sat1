/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author SERVER
 */

public class MostrarTotales 
{
    private String detalle;
    private double tasaMinima;
    private double tasa;
    private double superficie;
    private double tatal;
    
    public MostrarTotales()
    {
        
    }

    public String getDetalle()
    {
        return detalle;
    }

    public void setDetalle(String detalle)
    {
        this.detalle = detalle;
    }

    public double getTatal()
    {
        return tatal;
    }

    public void setTatal(double tatal)
    {
        this.tatal = tatal;
    }

    public double getTasaMinima()
    {
        return tasaMinima;
    }

    public void setTasaMinima(double tasaMinima)
    {
        this.tasaMinima = tasaMinima;
    }

    public double getSuperficie()
    {
        return superficie;
    }

    public void setSuperficie(double superficie)
    {
        this.superficie = superficie;
    }

    public double getTasa()
    {
        return tasa;
    }

    public void setTasa(double tasa)
    {
        this.tasa = tasa;
    }

}
