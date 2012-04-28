/*
 * Caja.java
 *
 * Created on 3 de septiembre de 2007, 10:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package negocios;
import java.util.Date;
/**
 *
 * @author Administrador
 */
public class Caja {
    
  private long idcaja;
  private Date fechaapertura;
  private Date fechacierre;
  private double total;
  private Usuario usuariocierre;
  private double saldoinicial;
  private String estado;
    
    
    /** Creates a new instance of Caja */
    public Caja() {
    }

    public long getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(long idcaja) {
        this.idcaja = idcaja;
    }

    public Date getFechaapertura() {
        return fechaapertura;
    }

    public void setFechaapertura(Date fechaapertura) {
        this.fechaapertura = fechaapertura;
    }

    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
        this.fechacierre = fechacierre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuariocierre() {
        return usuariocierre;
    }

    public void setUsuariocierre(Usuario usuariocierre) {
        this.usuariocierre = usuariocierre;
    }

    public double getSaldoinicial() {
        return saldoinicial;
    }

    public void setSaldoinicial(double saldoinicial) {
        this.saldoinicial = saldoinicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
