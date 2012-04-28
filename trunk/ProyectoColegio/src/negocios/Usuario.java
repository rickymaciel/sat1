package negocios;


/**
 *  Un usuario es una persona que hace uso del sistema.Tiene permisos de 
 *      acceso para realizar operaciones en el mismo.
 */
public class Usuario extends Persona {

    private int idusuario;

    private String nombre;

    private String password;

    private int nivel;

    public Usuario () {
    }

    public int getIdusuario () {
        return idusuario;
    }

    public void setIdusuario (int val) {
        this.idusuario = val;
    }

    public int getNivel () {
        return nivel;
    }

    public void setNivel (int val) {
        this.nivel = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String val) {
        this.password = val;
    }

}

