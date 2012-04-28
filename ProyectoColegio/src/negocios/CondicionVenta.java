package negocios;


public class CondicionVenta {

    private int idcondicionVenta;

    private String nombre;

    private String existe;

    public CondicionVenta () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdcondicionVenta () {
        return idcondicionVenta;
    }

    public void setIdcondicionVenta (int val) {
        this.idcondicionVenta = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

}

