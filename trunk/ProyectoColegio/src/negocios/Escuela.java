package negocios;


/**
 *  Escuela, es un organismo, permite crear objetos de escuela que son el 
 *      lugar de
 *  donde egresan los matriculados.
 *  solo tiene metodos basicos 
 *      set y get.
 */
public class Escuela extends Organismo {

    private int idescuela;

    private String existe;

    public Escuela () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdescuela () {
        return idescuela;
    }

    public void setIdescuela (int val) {
        this.idescuela = val;
    }

}

