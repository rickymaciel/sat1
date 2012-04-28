package negocios;


/**
 *  Clase basica, define un organismo como una empresa, escuela o entidad 
 *      externa cualquiera, un organismo es una institucion.
 */
public class Organismo 
{

    private String nombre;

    private Provincia provincia;

    private Departamento departamento;

    private Localidad localidad;

    private String direccion;

    private String telefono;

    private String mail;

    private String fax;

    private String codigoPostal;

    public Organismo () {
    }

    public String getCodigoPostal () {
        return codigoPostal;
    }

    public void setCodigoPostal (String val) {
        this.codigoPostal = val;
    }

    public Departamento getDepartamento () {
        return departamento;
    }

    public void setDepartamento (Departamento val) {
        this.departamento = val;
    }

    public String getDireccion () {
        return direccion;
    }

    public void setDireccion (String val) {
        this.direccion = val;
    }

    public String getFax () {
        return fax;
    }

    public void setFax (String val) {
        this.fax = val;
    }

    public Localidad getLocalidad () {
        return localidad;
    }

    public void setLocalidad (Localidad val) {
        this.localidad = val;
    }

    public String getMail () {
        return mail;
    }

    public void setMail (String val) {
        this.mail = val;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String val) {
        this.nombre = val;
    }

    public Provincia getProvincia () {
        return provincia;
    }

    public void setProvincia (Provincia val) {
        this.provincia = val;
    }

    public String getTelefono () {
        return telefono;
    }

    public void setTelefono (String val) {
        this.telefono = val;
    }

}

