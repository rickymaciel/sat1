/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class DetalleCPParaFacturacion extends DetalleFactura
{
    
    private String serieCP;

    private long codigoCP;
    
    private String tipoSuperficie;
    
    private double valorSuperficie;
    
    private String nombreTasa;
    
    private double valorIndiceDeTasa;
    
    private  double tasaMinimaAplicada;


    public DetalleCPParaFacturacion(){
    }
    

    public String getTipoSuperficie() {
        return tipoSuperficie;
    }

    public void setTipoSuperficie(String tipoSuperficie) {
        this.tipoSuperficie = tipoSuperficie;
    }

    public double getValorSuperficie() {
        return valorSuperficie;
    }

    public void setValorSuperficie(double valorSuperficie) {
        this.valorSuperficie = valorSuperficie;
    }

    public String getNombreTasa() {
        return nombreTasa;
    }

    public void setNombreTasa(String nombreTasa) {
        this.nombreTasa = nombreTasa;
    }

    public double getValorIndiceDeTasa() {
        return valorIndiceDeTasa;
    }

    public void setValorIndiceDeTasa(double valorIndiceDeTasa) {
        this.valorIndiceDeTasa = valorIndiceDeTasa;
    }

    public double getTasaMinimaAplicada() {
        return tasaMinimaAplicada;
    }

    public void setTasaMinimaAplicada(double tasaMinimaAplicada) {
        this.tasaMinimaAplicada = tasaMinimaAplicada;
    }

    public String getSerieCP() {
        return serieCP;
    }

    public void setSerieCP(String serieCP) {
        this.serieCP = serieCP;
    }

    public long getCodigoCP() {
        return codigoCP;
    }

    public void setCodigoCP(long codigoCP) {
        this.codigoCP = codigoCP;
    }
}
