package negocios;

import java.util.Date;

/**
 *  Clase Basica, una transaccion es una clase de operacion que genera 
 *      procesos transaccionales en la base de datos, es decir se pueden generar 
 *      operacionalmente facturas, constancias parciales, y constancias totales.
 */
public class Transaccion {

    private float dia;

    private float mes;

    private float anio;
    
    private float hora;

    private float minutos;

    private float segundos;

    private Usuario usuario;

    private Date fecha;
    
    public Transaccion () {
    }

   

    public Usuario getUsuario () {
        return usuario;
    }

    public void setUsuario (Usuario val) {
        this.usuario = val;
    }

    public float getDia() {
        return dia;
    }

    public void setDia(float dia) {
        this.dia = dia;
    }

    public float getMes() {
        return mes;
    }

    public void setMes(float mes) {
        this.mes = mes;
    }

    public float getAnio() {
        return anio;
    }

    public void setAnio(float anio) {
        this.anio = anio;
    }

    public float getHora() {
        return hora;
    }

    public void setHora(float hora) {
        this.hora = hora;
    }

    public float getMinutos() {
        return minutos;
    }

    public void setMinutos(float minutos) {
        this.minutos = minutos;
    }

    public float getSegundos() {
        return segundos;
    }

    public void setSegundos(float segundos) {
        this.segundos = segundos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}

