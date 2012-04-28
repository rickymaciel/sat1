/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Gustavo
 */
public class PuntodeVenta {
    
    private int idpuntodeventa;
    private String nombreusuarioapertura;
    private String tipofactura;
    private long numerofacturainicial;
    private String iniciofacturacion;
    private Empresa empresa;
    private long limite;
    private String existe;  
    
    
    public int getIdpuntodeventa() {
        return idpuntodeventa;
    }

    public void setIdpuntodeventa(int idpuntodeventa) {
        this.idpuntodeventa = idpuntodeventa;
    }

    public String getNombreusuarioapertura() {
        return nombreusuarioapertura;
    }

    public void setNombreusuarioapertura(String nombreusuarioapertura) {
        this.nombreusuarioapertura = nombreusuarioapertura;
    }

    public String getTipofactura() {
        return tipofactura;
    }

    public void setTipofactura(String tipofactura) {
        this.tipofactura = tipofactura;
    }

    public long getNumerofacturainicial() {
        return numerofacturainicial;
    }

    public void setNumerofacturainicial(long numerofacturainicial) {
        this.numerofacturainicial = numerofacturainicial;
    }

    public String getIniciofacturacion() {
        return iniciofacturacion;
    }

    public void setIniciofacturacion(String iniciofacturacion) {
        this.iniciofacturacion = iniciofacturacion;
    }

   
    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }

    public long getLimite() {
        return limite;
    }

    public void setLimite(long limite) {
        this.limite = limite;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
