package negocios;


/**
 *  Empresa es un organismo que esta haciendo uso del sistema.Sus datos son 
 *      utiles para la  facturacion en el sistema.
 */
public class Empresa extends Organismo {

    private int idempresa;

    private String titular;

    private String cuit;

    private String ingresosBrutos;

    private String inicioActividades;

    private Iva iva;

    private String existe;
    
    private Barrio barrio;

    public Empresa () {
    }

    public String getCuit () {
        return cuit;
    }

    public void setCuit (String val) {
        this.cuit = val;
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdempresa () {
        return idempresa;
    }

    public void setIdempresa (int val) {
        this.idempresa = val;
    }

    public String getIngresosBrutos () {
        return ingresosBrutos;
    }

    public void setIngresosBrutos (String val) {
        this.ingresosBrutos = val;
    }

    public String getInicioActividades () {
        return inicioActividades;
    }

    public void setInicioActividades (String val) {
        this.inicioActividades = val;
    }

    public Iva getIva () {
        return iva;
    }

    public void setIva (Iva val) {
        this.iva = val;
    }

    public String getTitular () {
        return titular;
    }

    public void setTitular (String val) {
        this.titular = val;
    }

    public Barrio getBarrio()
    {
        return barrio;
    }

    public void setBarrio(Barrio barrio)
    {
        this.barrio = barrio;
    }

}

