package negocios;


public class Titulo {

    private int idtitulo;

    private String nombre;

    private String abreviacion;

    private String existe;

    public Titulo () {
    }

    public String getAbreviacion () {
        return abreviacion;
    }

    public void setAbreviacion (String val) {
        this.abreviacion = val;
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdtitulo () {
        return idtitulo;
    }

    public void setIdtitulo (int val) {
        this.idtitulo = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

}

