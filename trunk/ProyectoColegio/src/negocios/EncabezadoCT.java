package negocios;


/**
 *  EncabezadoCT es una transaccion, que se realiza cuando un matriculado esta
 *  solicitando 
 *      una constancia parcial y cumple con requisitos de solicitud.
 */
public class EncabezadoCT extends Transaccion {

    private Matriculado matriculado;

    private String serieCT;

    private long codigoCT;

    private Provincia provincia;

    private Departamento departamento;

    private Localidad localidad;
    
    private Barrio barrio;

    private int serieFactura;

    private long numeroFactura;

    private String perito;

    private String propietario;
    
    private String responsable;

    private String comitente;

    private PlanoCTotal planoCTotal;

    private String nombreProyectista;

    private String nombreDirector;

    private String nombreConductor;

    private String nombreConstructor;

    private String estadoFinDeObra;

    private String calle;

    private String numero;

    private String manzana;

    private String lote;

    private String anulado;
    
    private Double superficie;
    
    private Double total;
    
    private String ordenTrabajo;
    
    

    public EncabezadoCT () {
    }

    public String getAnulado () {
        return anulado;
    }

    public void setAnulado (String val) {
        this.anulado = val;
    }

    public String getCalle () {
        return calle;
    }

    public void setCalle (String val) {
        this.calle = val;
    }

    public long getCodigoCT () {
        return codigoCT;
    }

    public void setCodigoCT (long val) {
        this.codigoCT = val;
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

    public String getEstadoFinDeObra () {
        return estadoFinDeObra;
    }

    public void setEstadoFinDeObra (String val) {
        this.estadoFinDeObra = val;
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

    public String getNombreConductor () {
        return nombreConductor;
    }

    public void setNombreConductor (String val) {
        this.nombreConductor = val;
    }

    public String getNombreConstructor () {
        return nombreConstructor;
    }

    public void setNombreConstructor (String val) {
        this.nombreConstructor = val;
    }

    public String getNombreDirector () {
        return nombreDirector;
    }

    public void setNombreDirector (String val) {
        this.nombreDirector = val;
    }

    public String getNombreProyectista () {
        return nombreProyectista;
    }

    public void setNombreProyectista (String val) {
        this.nombreProyectista = val;
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

    public String getPerito () {
        return perito;
    }

    public void setPerito (String val) {
        this.perito = val;
    }

    public PlanoCTotal getPlanoCTotal () {
        return planoCTotal;
    }

    public void setPlanoCTotal (PlanoCTotal val) {
        this.planoCTotal = val;
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

    public String getSerieCT () {
        return serieCT;
    }

    public void setSerieCT (String val) {
        this.serieCT = val;
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

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
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

}

