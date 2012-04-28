package negocios;


/**
 *  Nacionalidades una clase que define la nacionalidad de una persona.
 */
public class Nacionalidad {

    private int idnacionalidad;

    private String nombre;

    private String existe;

    public Nacionalidad () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdnacionalidad () {
        return idnacionalidad;
    }

    public void setIdnacionalidad (int val) {
        this.idnacionalidad = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

}

