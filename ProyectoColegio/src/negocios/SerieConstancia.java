/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class SerieConstancia {

    private int idserie;
    
    private String serie;
    
    private String defecto;
    
    private long limite;
    
    private String tipoConstancia;
    
    private String activo;
    
    private String tipoDeCarga;
    
    public SerieConstancia()
    {
        
    }
   
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDefecto() {
        return defecto;
    }

    public void setDefecto(String defecto) {
        this.defecto = defecto;
    }

    public long getLimite() {
        return limite;
    }

    public void setLimite(long limite) {
        this.limite = limite;
    }

    public String getTipoConstancia() {
        return tipoConstancia;
    }

    public void setTipoConstancia(String tipoConstancia) {
        this.tipoConstancia = tipoConstancia;
    }

    public int getIdserie() {
        return idserie;
    }

    public void setIdserie(int idserie) {
        this.idserie = idserie;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

  
    
    
}
