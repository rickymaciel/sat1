package negocios;


public class Barrio extends Lugar {

    private int idbarrio;

    private Localidad localidad;

    private String existe;

    public Barrio () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdbarrio () {
        return idbarrio;
    }

    public void setIdbarrio (int val) {
        this.idbarrio = val;
    }

    public Localidad getLocalidad () {
        return localidad;
    }

    public void setLocalidad (Localidad val) {
        this.localidad = val;
    }

}

