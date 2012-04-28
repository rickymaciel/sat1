package negocios;


public class DetalleCT {

    private long iddetalleCT;

    private String serieCT;

    private long codigoCT;

    private TipoSeccion tipoSeccion;

    private TipoSuperficie tipoSuperficie;

    private double superficie;

    public DetalleCT () {
    }

    public long getCodigoCT () {
        return codigoCT;
    }

    public void setCodigoCT (long val) {
        this.codigoCT = val;
    }

    public long getIddetalleCT () {
        return iddetalleCT;
    }

    public void setIddetalleCT (long val) {
        this.iddetalleCT = val;
    }

    public String getSerieCT () {
        return serieCT;
    }

    public void setSerieCT (String val) {
        this.serieCT = val;
    }

    public double getSuperficie () {
        return superficie;
    }

    public void setSuperficie (double val) {
        this.superficie = val;
    }

    public TipoSeccion getTipoSeccion () {
        return tipoSeccion;
    }

    public void setTipoSeccion (TipoSeccion val) {
        this.tipoSeccion = val;
    }

    public TipoSuperficie getTipoSuperficie () {
        return tipoSuperficie;
    }

    public void setTipoSuperficie (TipoSuperficie val) {
        this.tipoSuperficie = val;
    }

}

