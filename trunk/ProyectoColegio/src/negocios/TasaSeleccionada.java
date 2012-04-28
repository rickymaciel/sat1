/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author SERVER
 */
public class TasaSeleccionada 
{
    private String SerieCT;
    private long codigoCT;
    private int idTasa;
    private double monto;
    private long idMatriculado;
    
    public TasaSeleccionada()
    {
        
    }

    public String getSerieCT() 
    {
        return SerieCT;
    }

    public void setSerieCT(String SerieCT) 
    {
        this.SerieCT = SerieCT;
    }

    public long getCodigoCT() 
    {
        return codigoCT;
    }

    public void setCodigoCT(long codigoCT) 
    {
        this.codigoCT = codigoCT;
    }

    public int getIdTasa() {
        return idTasa;
    }

    public void setIdTasa(int idTasa) {
        this.idTasa = idTasa;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public long getIdMatriculado() {
        return idMatriculado;
    }

    public void setIdMatriculado(long idMatriculado) {
        this.idMatriculado = idMatriculado;
    }
}
