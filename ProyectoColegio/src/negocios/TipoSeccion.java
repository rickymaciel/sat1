package negocios;


/**
 *  TipoSeccion, es un tipo de seccion que corresponde a la superficie que se 
 *      esta detallando,puede ser Planta Baja,Planta Alta, 1er Piso, Voladizo, etc.
 */
public class TipoSeccion {

    private int idtipoSeccion;

    private String nombre;

    private String existe;

    public TipoSeccion () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdtipoSeccion () {
        return idtipoSeccion;
    }

    public void setIdtipoSeccion (int val) {
        this.idtipoSeccion = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

}

