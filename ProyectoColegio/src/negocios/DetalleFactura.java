package negocios;


public class DetalleFactura {

    private int serieFactura;

    private Long numeroFactura;
    
    private int iddetalle;

    private Producto producto;

    private String detalle;

    private int cantidad;

    private double subTotal;

    public DetalleFactura () {
    }

    public int getCantidad () {
        return cantidad;
    }

    public void setCantidad (int val) {
        this.cantidad = val;
    }

    public String getDetalle () {
        return detalle;
    }

    public void setDetalle (String val) {
        this.detalle = val;
    }

    public int getIddetalle () {
        return iddetalle;
    }

    public void setIddetalle (int val) {
        this.iddetalle = val;
    }

    public Long getNumeroFactura () {
        return numeroFactura;
    }

    public void setNumeroFactura (Long val) {
        this.numeroFactura = val;
    }

    public Producto getProducto () {
        return producto;
    }

    public void setProducto (Producto val) {
        this.producto = val;
    }

    public int getSerieFactura () {
        return serieFactura;
    }

    public void setSerieFactura (int val) {
        this.serieFactura = val;
    }

    public double getSubTotal () {
        return subTotal;
    }

    public void setSubTotal (double val) {
        this.subTotal = val;
    }

}

