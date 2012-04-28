package negocios;

import java.util.Date;


/**
 *  Clase basica, corresponde a una persona cualquiera, puede ser un usuario 
 *      del sistema o un matriculado.
 */
public class Persona {

    private float diaNac;

    private float mesNac;

    private float anioNac;

    private String apellido;

    private String nombres;

    private String dni;

    private Provincia provincia;

    private Departamento departamento;

    private Localidad localidad;

    private Barrio barrio;

    private String calle;

    private Nacionalidad nacionalidad;

    private Date nacimiento;

    private String email;

    private String telefonoParticular;

    private String existe;

    public Persona () {
    }

    public String getApellido () {
        return apellido;
    }

    public void setApellido (String val) {
        this.apellido = val;
    }

    public Barrio getBarrio () {
        return barrio;
    }

    public void setBarrio (Barrio val) {
        this.barrio = val;
    }

    public String getCalle () {
        return calle;
    }

    public void setCalle (String val) {
        this.calle = val;
    }

    public Departamento getDepartamento () {
        return departamento;
    }

    public void setDepartamento (Departamento val) {
        this.departamento = val;
    }

    public String getDni () {
        return dni;
    }

    public void setDni (String val) {
        this.dni = val;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String val) {
        this.email = val;
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public Localidad getLocalidad () {
        return localidad;
    }

    public void setLocalidad (Localidad val) {
        this.localidad = val;
    }

    public Date getNacimiento () {
        return nacimiento;
    }

    public void setNacimiento (Date val) {
        this.nacimiento = val;
    }

    public Nacionalidad getNacionalidad () {
        return nacionalidad;
    }

    public void setNacionalidad (Nacionalidad val) {
        this.nacionalidad = val;
    }

    public String getNombres () {
        return nombres;
    }

    public void setNombres (String val) {
        this.nombres = val;
    }

    public Provincia getProvincia () {
        return provincia;
    }

    public void setProvincia (Provincia val) {
        this.provincia = val;
    }

    public String getTelefonoParticular () {
        return telefonoParticular;
    }

    public void setTelefonoParticular (String val) {
        this.telefonoParticular = val;
    }

    public float getAnioNac () {
        return anioNac;
    }

    public void setAnioNac (float val) {
        this.anioNac = val;
    }

    public float getDiaNac () {
        return diaNac;
    }

    public void setDiaNac (float val) {
        this.diaNac = val;
    }

    public float getMesNac () {
        return mesNac;
    }

    public void setMesNac (float val) {
        this.mesNac = val;
    }

}

