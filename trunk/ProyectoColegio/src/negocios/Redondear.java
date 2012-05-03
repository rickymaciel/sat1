/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author marcelo gonzalez
 */
public class Redondear 
{
    public Redondear()
    {
        
    }
    
    /**
     * Esta clase se encarga de edondear un número arbitrario a n decimales.
     * @param numero numero a redondear
     * @param decimales cantidad de decimales deseados
     * @return
     */
    public double redondear( double numero, int decimales ) {
        
//        long factor = (long)Math.pow(10,decimales);
//        numero = numero * factor;
//        long tmp = Math.round(numero);
//        return (double)tmp / factor;
        
        
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    
    
    }

}
