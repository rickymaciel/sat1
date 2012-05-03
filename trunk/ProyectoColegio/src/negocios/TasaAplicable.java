/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class TasaAplicable extends Tasa
{
    private int idTasaAplicable;
    private int idTipoConstancia;
    private String leyenda;
    
    public TasaAplicable()
    {
        
    }

    public int getIdTasaAplicable() {
        return idTasaAplicable;
    }

    public void setIdTasaAplicable(int idTasaAplicable) {
        this.idTasaAplicable = idTasaAplicable;
    }

    public int getIdTipoConstancia() {
        return idTipoConstancia;
    }

    public void setIdTipoConstancia(int idTipoConstancia) {
        this.idTipoConstancia = idTipoConstancia;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }
}
