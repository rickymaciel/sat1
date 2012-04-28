package negocios;


public class EntidadExterna extends Organismo {

    private int identidadExterna;

    private String existe;

    public EntidadExterna () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdentidadExterna () {
        return identidadExterna;
    }

    public void setIdentidadExterna (int val) {
        this.identidadExterna = val;
    }

}

