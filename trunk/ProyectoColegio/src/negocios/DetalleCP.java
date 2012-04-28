package negocios;


public class DetalleCP {

    private long iddetalleCP;

    private String serieCP;

    private long codigoCP;

    private TipoTrabajo tipoTrabajo;

    private TipoSeccion tipoSeccion;

    private TipoSuperficie tipoSuperficie;

    private double superficie;

    public DetalleCP () {
    }

    public long getCodigoCP () {
        return codigoCP;
    }

    public void setCodigoCP (long val) {
        this.codigoCP = val;
    }

    public long getIddetalleCP () {
        return iddetalleCP;
    }

    public void setIddetalleCP (long val) {
        this.iddetalleCP = val;
    }

    public String getSerieCP () {
        return serieCP;
    }

    public void setSerieCP (String val) {
        this.serieCP = val;
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

    public TipoTrabajo getTipoTrabajo () {
        return tipoTrabajo;
    }

    public void setTipoTrabajo (TipoTrabajo val) {
        this.tipoTrabajo = val;
    }

}

