/*
 * Main.java
 *
 * Created on 7 de enero de 2008, 11:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controlador;

/**
 *
 * @author Administrador
 */
import vista.Login;

public class Main
{
    
    /** Creates a new instance of Main */
    public Main()
    {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Login login = new Login();
        login.setVisible(true);
    }
    
}
