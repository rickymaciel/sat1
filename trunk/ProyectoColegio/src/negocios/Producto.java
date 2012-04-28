package negocios;


public class Producto {

    private int idproducto;

    private String denominacion;

    private double precio;

    private String existe;

    public Producto () {
    }

    public String getDenominacion () {
        return denominacion;
    }

    public void setDenominacion (String val) {
        this.denominacion = val;
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdproducto () {
        return idproducto;
    }

    public void setIdproducto (int val) {
        this.idproducto = val;
    }

    public double getPrecio () {
        return precio;
    }

    public void setPrecio (double val) {
        this.precio = val;
    }

}

