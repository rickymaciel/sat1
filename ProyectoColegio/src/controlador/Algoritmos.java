/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.EncabezadoPago;
import negocios.Matriculado;

/**
 *
 * @author SERVER
 */
public class Algoritmos 
{
    private EncabezadoCP encCP = new EncabezadoCP();
    private EncabezadoCT encCT = new EncabezadoCT();
    private EncabezadoPago encPago = new EncabezadoPago();
    
    public Algoritmos()
    {
        
    }
    //cadena del detalle de la factura CP
    //Devuelve: encabezadoCP cargado con serie,codigo y matriculado cargado con la matricula
    public EncabezadoCP getEncabezadoCP(String cadena)
    {
        
        int contador = 0;
        StringBuffer subCadena = new StringBuffer();
        char letra;
        for(int i=0;i<cadena.length();i++)
        {
            System.out.println("El valor de i es: "+i);
            letra = cadena.charAt(i);
            System.out.println("EL valor de la letra es: "+letra);
            if((letra == ':') || (letra == '-'))
            {
                contador++;
                this.cargarCP(contador, subCadena);
                subCadena.delete(0, subCadena.length());
            }
            else
                subCadena.append(letra);
        }
        this.cargarCP(contador, subCadena);
        return encCP;
    }
    
    private void cargarCP(int i, StringBuffer cadena )
    {
        System.out.println("La cadena que recive cargar es: "+cadena.toString());
        switch(i)
        {
            case 2:
                    this.encCP.setSerieCP(cadena.toString());
                    break;
            case 3:
                    this.encCP.setCodigoCP(Long.parseLong(cadena.toString().trim()));
                    break;
            case 5:
                    Matriculado m = new Matriculado();
                    m.setMatricula(Integer.parseInt(cadena.toString()));
                    this.encCP.setMatriculado(m);
                    break;
        }
    }
    
    
    public EncabezadoCT getEncabezadoCT(String cadena)
    {
        
        int contador = 0;
        StringBuffer subCadena = new StringBuffer();
        char letra;
        for(int i=0;i<cadena.length();i++)
        {
            letra = cadena.charAt(i);
            if((letra == ':') || (letra == '-'))
            {
                contador++;
                this.cargarCT(contador, subCadena);
                subCadena.delete(0, subCadena.length());
            }
            else
                subCadena.append(letra);
        }
        this.cargarCT(contador, subCadena);
        return encCT;
    }
    
    private void cargarCT(int i, StringBuffer cadena )
    {
        System.out.println("La cadena que recive cargar es: "+cadena.toString());
        switch(i)
        {
            case 2:
                    this.encCT.setSerieCT(cadena.toString());
                    break;
            case 3:
                    this.encCT.setCodigoCT(Long.parseLong(cadena.toString().trim()));
                    break;
            case 5:
                    Matriculado m = new Matriculado();
                    m.setMatricula(Integer.parseInt(cadena.toString()));
                    this.encCT.setMatriculado(m);
                    break;
        }
    }
    
    public EncabezadoPago getEncabezadoPago(String cadena){        
        int contador = 0;
        StringBuffer subCadena = new StringBuffer();
        char letra;
        for(int i=0;i<cadena.length();i++){
            letra = cadena.charAt(i);
            
            if(letra == '-'){
                contador++;
                this.cargarPago(contador, subCadena);
                break;
            }else{
                if(letra == ':'){
                    contador++;
                    this.cargarPago(contador, subCadena);
                    subCadena.delete(0, subCadena.length());
                }else
                    subCadena.append(letra);
            }
        }
        return this.encPago;
    }
    
    private void cargarPago(int i, StringBuffer cadena )
    {
//        System.out.println("el indice es: "+ i);
//        System.out.println("La cadena que recive cargar es: "+cadena.toString());
        
        
        switch(i)
        {
            case 2:
                    this.encPago.setIdencabezado(Long.parseLong(cadena.toString()));
                    break;
            case 3:
                    this.encPago.setMatricula(Long.parseLong(cadena.toString().trim()));
                    break;
        }
    }

}
