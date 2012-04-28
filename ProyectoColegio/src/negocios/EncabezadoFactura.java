package negocios;

import java.util.Collection;

/**
 *  EncabezadoFactura, es un tipo de transaccion, que es generada cuando un 
 *      matriculado va a pagar por un servicio o producto.
 */
public class EncabezadoFactura extends Transaccion {

    private int serieFactura;

    private long numeroFactura;
    
    private int idempresa;
        
    private Caja caja;

    private CondicionVenta condicionVenta;

    private Iva iva;

    private String numeroRemito;

    private double total;

    private String cuit;

    private String domicilio;

    private Matriculado matriculado;

    private String nombreCliente;

    private String anulado;

    private Collection detalleFactura;

       
    public EncabezadoFactura () {
    }

    public String getAnulado () {
        return anulado;
    }

    public void setAnulado (String val) {
        this.anulado = val;
    }

    public CondicionVenta getCondicionVenta () {
        return condicionVenta;
    }

    public void setCondicionVenta (CondicionVenta val) {
        this.condicionVenta = val;
    }

    public String getCuit () {
        return cuit;
    }

    public void setCuit (String val) {
        this.cuit = val;
    }

    public String getDomicilio () {
        return domicilio;
    }

    public void setDomicilio (String val) {
        this.domicilio = val;
    }

    public Iva getIva () {
        return iva;
    }

    public void setIva (Iva val) {
        this.iva = val;
    }

    public Collection getDetalleFactura () {
        return detalleFactura;
    }

    public void setDetalleFactura (Collection detalle) {
        this.detalleFactura = detalle;
    }

    public Matriculado getMatriculado () {
        return matriculado;
    }

    public void setMatriculado (Matriculado val) {
        this.matriculado = val;
    }

    public String getNombreCliente () {
        return nombreCliente;
    }

    public void setNombreCliente (String val) {
        this.nombreCliente = val;
    }

    public long getNumeroFactura () {
        return numeroFactura;
    }

    public void setNumeroFactura (long val) {
        this.numeroFactura = val;
    }

    public String getNumeroRemito () {
        return numeroRemito;
    }

    public void setNumeroRemito (String val) {
        this.numeroRemito = val;
    }

    public int getSerieFactura () {
        return serieFactura;
    }

    public void setSerieFactura (int val) {
        this.serieFactura = val;
    }

    public double getTotal () {
        return total;
    }

    public void setTotal (double val) {
        this.total = val;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

}

