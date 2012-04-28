package negocios;


public class PlanoCTotal {

    private int idplanoCTotal;

    private String nombre;

    private String leyenda;

    private String existe;

    public PlanoCTotal () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdplanoCTotal () {
        return idplanoCTotal;
    }

    public void setIdplanoCTotal (int val) {
        this.idplanoCTotal = val;
    }

    public String getLeyenda () {
        return leyenda;
    }

    public void setLeyenda (String val) {
        this.leyenda = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

}

