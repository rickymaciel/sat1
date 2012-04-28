/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Gustavo
 */

public class PlanoTasa extends Tasa {
    
    private int idplanotasa;
    private int idplano;
    private int idtasa;
    private String existe;

    public PlanoTasa()
    {
        
    }

    public int getIdplanotasa() {
        return idplanotasa;
    }

    public void setIdplanotasa(int idplanotasa) {
        this.idplanotasa = idplanotasa;
    }

    public int getIdplano() {
        return idplano;
    }

    public void setIdplano(int idplano) {
        this.idplano = idplano;
    }

    public int getIdtasa() {
        return idtasa;
    }

    public void setIdtasa(int idtasa) {
        this.idtasa = idtasa;
    }

    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }
}
