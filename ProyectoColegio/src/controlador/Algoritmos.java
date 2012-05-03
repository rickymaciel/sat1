/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JOptionPane;
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
            letra = cadena.charAt(i);
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
    
    public EncabezadoPago getEncabezadoPago(String cadena)
    {
        int contador = 0;
        StringBuffer subCadena = new StringBuffer();
        char letra;
        for(int i=0;i<cadena.length();i++)
        {
            letra = cadena.charAt(i);
            if(letra == '-')
            {
                contador++;
                this.cargarPago(contador, subCadena);                
                break;
            }
            else
            {
                if(letra == ':')
                {
                    contador++;
                    this.cargarPago(contador, subCadena);
                    subCadena.delete(0, subCadena.length());
                }
                else
                    subCadena.append(letra);
            }
        }
        return this.encPago;
    }
    
    private void cargarPago(int i, StringBuffer cadena )
    {
        switch(i)
        {           
            case 2:
                    System.out.println("cadena dos: "+cadena.toString().trim());
                    this.encPago.setIdencabezado(Long.parseLong(cadena.toString().trim()));
                    break;
            case 3:
                System.out.println("cadena tres: "+cadena.toString().trim());
                    this.encPago.setMatricula(Long.parseLong(cadena.toString().trim()));
                    break;
        }
    }
    
    public Collection devolverCPImpaga()
    {
        CListar listar = new CListar();
        Collection constancias = new ArrayList();
        constancias = listar.hacerListadoEncabezadoCP(new EncabezadoCP(),1,"0","0");
        listar = null;
        return constancias;
    }
    
    public Collection devolverCTImpaga()
    {
        CListar listar = new CListar();
        Collection constancias = new ArrayList();
        constancias = listar.hacerListadoEncabezadoCT(new EncabezadoCT(),1,"0","0");
        listar = null;
        return constancias;
    }
    
    public Collection devolverCuotaImpaga()
    {
        CListar listar = new CListar();
        Collection vCuotas = new ArrayList();
        Collection temp = new ArrayList();
        EncabezadoPago encabezado = new EncabezadoPago();
        encabezado.setIdencabezado(0);
        temp = listar.hacerListado(encabezado);
        Iterator it = temp.iterator();
        while(it.hasNext())
        {
            EncabezadoPago e = (EncabezadoPago)it.next();
            if(e.getNrofactura() == 0)
                vCuotas.add(e);
            e = null;
        }
        temp = null;
        it = null;
        listar = null;
        encabezado = null;
        return vCuotas;
    }
    
    public Timestamp obtenerFechayHoraDeSistema(){
        //permite obtener lafecha correcta del sistema operativo con zona
        //horaria indicada,
        // ay q tener correctamente configurado el sistemaopertivo con su hora
        //y zona horaria
        Locale l = new Locale("es","AR");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Jujuy"),l);
//        System.out.println("FECHA CORRECTA: " + cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));        
        String fecha=(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));

      Date date=null;      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");      
        try{
             date = sdf.parse(fecha);
        }catch(ParseException pe){
            JOptionPane.showMessageDialog(null, "Admin: hubo problemas con lafecha de cierre de caja, revise la configuracion horaria", "No se pudo parsear la fecha de cierre",JOptionPane.WARNING_MESSAGE);
        }      
      Timestamp fechaSistema = new Timestamp(date.getTime());      
//      System.out.println(fechaSistema.toString());      
        
      return fechaSistema;
    }


}
