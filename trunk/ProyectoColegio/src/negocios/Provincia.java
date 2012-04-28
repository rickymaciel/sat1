package negocios;


public class Provincia extends Lugar {

    private int idprovincia;

    private String existe;

    public Provincia () {
    }

    public String getExiste () {
        return existe;
    }

    public void setExiste (String val) {
        this.existe = val;
    }

    public int getIdprovincia () {
        return idprovincia;
    }

    public void setIdprovincia (int val) {
        this.idprovincia = val;
    }

}

