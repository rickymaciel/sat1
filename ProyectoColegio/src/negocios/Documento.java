/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class Documento 
{
    private int idDocumento;
    private String descripcion;
    private String existe;
    
    public Documento()
    {
        
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }
}
