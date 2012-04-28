package negocios;


public class Departamento extends Lugar {

    private int iddepartamento;

    private Provincia provincia;

    private String existe;

    public Departamento () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIddepartamento () {
        return iddepartamento;
    }

    public void setIddepartamento (int val) {
        this.iddepartamento = val;
    }

    public Provincia getProvincia () {
        return provincia;
    }

    public void setProvincia (Provincia val) {
        this.provincia = val;
    }

}

