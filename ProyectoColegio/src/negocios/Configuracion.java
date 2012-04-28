package negocios;
public class Configuracion {

    private int idconfiguracion;

    private String host;

    private String directorioTemp;

    private long codigoMaximoCP;

    private long codigoMaximoCT;
    
    private int idproducto;

    public Configuracion () {
    }

    public long getCodigoMaximoCP () {
        return codigoMaximoCP;
    }

    public void setCodigoMaximoCP (long val) {
        this.codigoMaximoCP = val;
    }

    public long getCodigoMaximoCT () {
        return codigoMaximoCT;
    }

    public void setCodigoMaximoCT (long val) {
        this.codigoMaximoCT = val;
    }

    public String getDirectorioTemp () {
        return directorioTemp;
    }

    public void setDirectorioTemp (String val) {
        this.directorioTemp = val;
    }

    public String getHost () {
        return host;
    }

    public void setHost (String val) {
        this.host = val;
    }

    public int getIdconfiguracion () {
        return idconfiguracion;
    }

    public void setIdconfiguracion (int val) {
        this.idconfiguracion = val;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

}

