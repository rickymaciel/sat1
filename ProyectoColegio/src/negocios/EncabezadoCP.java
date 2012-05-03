package negocios;


/**
 *  EncabezadoCP es una transaccion, que se realiza cuando un matriculado esta 
 *      solicitando una constancia parcial y cumple con requisitos de solicitud.
 */
public class EncabezadoCP extends Transaccion {

    private Matriculado matriculado;

    private String serieCP;

    private long codigoCP;

    private Provincia provincia;

    private Departamento departamento;

    private Localidad localidad;

    private Barrio barrrio;

    private String calle;

    private String numero;

    private String manzana;

    private String lote;

    private int serieFactura;

    private long numeroFactura;

    private String propietario;

    private String comitente;

    private String anulado;
    
    private Double superficieRelevada;
    
    private Double superficieProyecto;
    
    private Double total;
    
    private String ordenTrabajo;
    
    private String leyenda;
    
    

    public EncabezadoCP () {
    }

    public String getAnulado () {
        return anulado;
    }

    public void setAnulado (String val) {
        this.anulado = val;
    }

    public Barrio getBarrrio () {
        return barrrio;
    }

    public void setBarrrio (Barrio val) {
        this.barrrio = val;
    }

    public String getCalle () {
        return calle;
    }

    public void setCalle (String val) {
        this.calle = val;
    }

    public long getCodigoCP () {
        return codigoCP;
    }

    public void setCodigoCP (long val) {
        this.codigoCP = val;
    }

    public String getComitente () {
        return comitente;
    }

    public void setComitente (String val) {
        this.comitente = val;
    }

    public Departamento getDepartamento () {
        return departamento;
    }

    public void setDepartamento (Departamento val) {
        this.departamento = val;
    }

    public Localidad getLocalidad () {
        return localidad;
    }

    public void setLocalidad (Localidad val) {
        this.localidad = val;
    }

    public String getLote () {
        return lote;
    }

    public void setLote (String val) {
        this.lote = val;
    }

    public String getManzana () {
        return manzana;
    }

    public void setManzana (String val) {
        this.manzana = val;
    }

    public String getNumero () {
        return numero;
    }

    public void setNumero (String val) {
        this.numero = val;
    }

    public long getNumeroFactura () {
        return numeroFactura;
    }

    public void setNumeroFactura (long val) {
        this.numeroFactura = val;
    }

    public String getPropietario () {
        return propietario;
    }

    public void setPropietario (String val) {
        this.propietario = val;
    }

    public Provincia getProvincia () {
        return provincia;
    }

    public void setProvincia (Provincia val) {
        this.provincia = val;
    }

    public String getSerieCP () {
        return serieCP;
    }

    public void setSerieCP (String val) {
        this.serieCP = val;
    }

    public int getSerieFactura () {
        return serieFactura;
    }

    public void setSerieFactura (int val) {
        this.serieFactura = val;
    }

    public Matriculado getMatriculado () {
        return matriculado;
    }

    public void setMatriculado (Matriculado val) {
        this.matriculado = val;
    }

    public Double getSuperficieRelevada() {
        return superficieRelevada;
    }

    public void setSuperficieRelevada(Double superficieRelevada) {
        this.superficieRelevada = superficieRelevada;
    }

    public Double getSuperficieProyecto() {
        return superficieProyecto;
    }

    public void setSuperficieProyecto(Double superficieProyecto) {
        this.superficieProyecto = superficieProyecto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(String ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public String getLeyenda()
    {
        return leyenda;
    }

    public void setLeyenda(String leyenda)
    {
        this.leyenda = leyenda;
    }

}

