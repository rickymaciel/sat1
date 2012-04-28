package negocios;


/**
 *  <font face="">Clase Basica, de la cual dependen otras clases hijas que 
 *    definen un lugar de ubicacion como provincia, departamento, localidad o 
 *    barrio.</font>
 */
public class Lugar {

    private String nombre;

    public Lugar () {
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

}

