package negocios;

import java.util.Date;


/**
 *  Un matriculado es una persona que solicita servicios para que el usuario 
 *      genere las operaciones adecuadas.
 */
public class Matriculado extends Persona {

    private float diaIns;

    private float mesIns;

    private float anioIns;

    private float diaEgr;

    private float mesEgr;

    private float anioEgr;

    private long idmatriculado;

    private int matricula;

    private String telefonoCelular;

    private String telefonoTrabajo;

    private String web;

    private String cuit;

    private String cuil;

    private String habilitado;

    private Date fechaInscripcion;

    private String libro;

    private String folio;

    private Escuela escuela;

    private Date fechaEgresoDeEscuela;

    private Titulo titulo;

    private Departamento departamentoProfesional;

    private Localidad localidadProfesional;

    private Barrio barrioProfesional;

    private String calleProfesional;

    private String especialidad;
    
    private String ingresosBrutos;
    
    private Iva Iva;

    public Matriculado() {
    }

    public Barrio getBarrioProfesional () {
        return barrioProfesional;
    }

    public void setBarrioProfesional (Barrio val) {
        this.barrioProfesional = val;
    }

    public String getCalleProfesional () {
        return calleProfesional;
    }

    public void setCalleProfesional (String val) {
        this.calleProfesional = val;
    }

    public String getCuil () {
        return cuil;
    }

    public void setCuil (String val) {
        this.cuil = val;
    }

    public String getCuit () {
        return cuit;
    }

    public void setCuit (String val) {
        this.cuit = val;
    }

    public Departamento getDepartamentoProfesional () {
        return departamentoProfesional;
    }

    public void setDepartamentoProfesional (Departamento val) {
        this.departamentoProfesional = val;
    }

    public Escuela getEscuela () {
        return escuela;
    }

    public void setEscuela (Escuela val) {
        this.escuela = val;
    }

    public String getEspecialidad () {
        return especialidad;
    }

    public void setEspecialidad (String val) {
        this.especialidad = val;
    }

    public Date getFechaEgresoDeEscuela () {
        return fechaEgresoDeEscuela;
    }

    public void setFechaEgresoDeEscuela (Date val) {
        this.fechaEgresoDeEscuela = val;
    }

    public Date getFechaInscripcion () {
        return fechaInscripcion;
    }

    public void setFechaInscripcion (Date val) {
        this.fechaInscripcion = val;
    }

    public String getFolio () {
        return folio;
    }

    public void setFolio (String val) {
        this.folio = val;
    }

    public String getHabilitado () {
        return habilitado;
    }

    public void setHabilitado (String val) {
        this.habilitado = val;
    }

    public long getIdmatriculado () {
        return idmatriculado;
    }

    public void setIdmatriculado (long val) {
        this.idmatriculado = val;
    }

    public String getLibro () {
        return libro;
    }

    public void setLibro (String val) {
        this.libro = val;
    }

    public Localidad getLocalidadProfesional () {
        return localidadProfesional;
    }

    public void setLocalidadProfesional (Localidad val) {
        this.localidadProfesional = val;
    }

    public int getMatricula () {
        return matricula;
    }

    public void setMatricula (int val) {
        this.matricula = val;
    }

    public String getTelefonoCelular () {
        return telefonoCelular;
    }

    public void setTelefonoCelular (String val) {
        this.telefonoCelular = val;
    }

    public String getTelefonoTrabajo () {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo (String val) {
        this.telefonoTrabajo = val;
    }

    public Titulo getTitulo () {
        return titulo;
    }

    public void setTitulo (Titulo val) {
        this.titulo = val;
    }

    public String getWeb () {
        return web;
    }

    public void setWeb (String val) {
        this.web = val;
    }

    public float getAnioEgr () {
        return anioEgr;
    }

    public void setAnioEgr (float val) {
        this.anioEgr = val;
    }

    public float getAnioIns () {
        return anioIns;
    }

    public void setAnioIns (float val) {
        this.anioIns = val;
    }

    public float getDiaEgr () {
        return diaEgr;
    }

    public void setDiaEgr (float val) {
        this.diaEgr = val;
    }

    public float getDiaIns () {
        return diaIns;
    }

    public void setDiaIns (float val) {
        this.diaIns = val;
    }

    public float getMesEgr () {
        return mesEgr;
    }

    public void setMesEgr (float val) {
        this.mesEgr = val;
    }

    public float getMesIns () {
        return mesIns;
    }

    public void setMesIns (float val) {
        this.mesIns = val;
    }

    public String getIngresosBrutos() {
        return ingresosBrutos;
    }

    public void setIngresosBrutos(String ingresosBrutos) {
        this.ingresosBrutos = ingresosBrutos;
    }

    public Iva getIva() {
        return Iva;
    }

    public void setIva(Iva Iva) {
        this.Iva = Iva;
    }

   

}

