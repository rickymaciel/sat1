package negocios;


/**
 *  Tasa, es una tasa que se aplica a los detalles de las superficies que 
 *      pertenecen a las constancias.
 */
public class Tasa {

    private int idtasa;

    private String denominacion;

    private double indice;

    private double tasaMinima;

    private String observacion;

    private String existe;
    
    private double superficie;

    public Tasa () {
    }

    public String getDenominacion () {
        return denominacion;
    }

    public void setDenominacion (String val) {
        this.denominacion = val;
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdtasa () {
        return idtasa;
    }

    public void setIdtasa (int val) {
        this.idtasa = val;
    }

    public double getIndice () {
        return indice;
    }

    public void setIndice (double val) {
        this.indice = val;
    }

    public String getObservacion () {
        return observacion;
    }

    public void setObservacion (String val) {
        this.observacion = val;
    }

    public double getTasaMinima () {
        return tasaMinima;
    }

    public void setTasaMinima (double val) {
        this.tasaMinima = val;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

}

