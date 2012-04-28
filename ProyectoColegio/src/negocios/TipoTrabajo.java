package negocios;


/**
 *  TipoTrabajo, es un tipo de trabajo que se esta aplicando a una superficie 
 *      que se esta detallando en la constancia, puede ser Trabajo de 
 *      relevamiento, o Coduccion Tecnica, o eventualmente Calculo de Hormigon 
 *      Armado,puede  ser otro tipo, pero a la fecha (01/2008) solo son estas.
 */
public class TipoTrabajo {

    private int idtipoTrabajo;

    private String nombre;

    private String leyenda;

    private String existe;

    public TipoTrabajo () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdtipoTrabajo () {
        return idtipoTrabajo;
    }

    public void setIdtipoTrabajo (int val) {
        this.idtipoTrabajo = val;
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

