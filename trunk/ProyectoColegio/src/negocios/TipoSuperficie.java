package negocios;


/**
 *  TipoSuperficie, es el tipo de superficie que determina el tipo a la 
 *      superficie detallada, puede ser cubierta, semicubierta, modificada, o 
 *      cambio de techo.
 */
public class TipoSuperficie {

    private int idtipoSuperficie;

    private String nombre;

    private String existe;
    
    private double modificador;

    public TipoSuperficie () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdtipoSuperficie () {
        return idtipoSuperficie;
    }

    public void setIdtipoSuperficie (int val) {
        this.idtipoSuperficie = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

    public double getModificador() {
        return modificador;
    }

    public void setModificador(double modificador) {
        this.modificador = modificador;
    }

}

