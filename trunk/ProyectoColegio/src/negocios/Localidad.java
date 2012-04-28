package negocios;


public class Localidad extends Lugar {

    private int idlocalidad;

    private Departamento departamento;

    private String existe;

    public Localidad () {
    }

    public Departamento getDepartamento () {
        return departamento;
    }

    public void setDepartamento (Departamento val) {
        this.departamento = val;
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdlocalidad () {
        return idlocalidad;
    }

    public void setIdlocalidad (int val) {
        this.idlocalidad = val;
    }

}

