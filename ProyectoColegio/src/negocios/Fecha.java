/*
 * Fecha.java
 *
 * Created on 1 de febrero de 2008, 12:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package negocios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marcelo gonzalez
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int anio;
    
    /** Creates a new instance of Fecha */
    public Fecha()
    {
    }

    public int getDia()
    {
        return dia;
    }

    public void setDia(int dia)
    {
        this.dia = dia;
    }

    public int getMes()
    {
        return mes;
    }

    public void setMes(int mes)
    {
        this.mes = mes;
    }

    public int getAnio()
    {
        return anio;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }
    
    public boolean validarFecha()
    {
        boolean devolver = true; // si devuelve true es porque todo esta ok
        if(this.validarDiaValido())
            devolver = true;
        else
            devolver = false;
        return devolver;
    }
    
    private boolean validarDiaValido()
    {
        boolean devolver = true;
        switch(this.mes)
        {
            case 1:
                    if(this.dia <= 31)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 2:
                    if(this.dia <= 29)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 3:
                    if(this.dia <= 31)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 4:
                    if(this.dia <= 30)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 5:
                    if(this.dia <= 31)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 6:
                    if(this.dia <= 30)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 7:
                    if(this.dia <= 31)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 8:
                    if(this.dia <= 30)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 9:
                    if(this.dia <= 30)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 10:
                    if(this.dia <= 31)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 11:
                    if(this.dia <= 30)
                        devolver = true;
                    else
                        devolver = false;
                    break;
            case 12:
                    if(this.dia <= 31)
                        devolver = true;
                    else
                        devolver = false;
                    break;
        }
        return devolver;
    }
    
    public int verficarVencimiento(Date fecha)
    {
        int dias = 0;
        Date hoy = new Date();
        if(hoy.compareTo(fecha)>0)
        {
            dias = (int)this.restarFechas(hoy, fecha);
        }
        return dias;
    }
    
    private double restarFechas(Date fechaInicial, Date fechaFinal)
    {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
        fechaInicial = df.parse(fechaInicioString);
        }
        catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
        fechaFinal = df.parse(fechaFinalString);
        }
        catch (ParseException ex) 
        {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return dias;
    }
    
    public Date convertirStringEnDate(String fechaStr)
    {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
         try 
         {
            fecha = formatoDelTexto.parse(fechaStr);
        } catch (ParseException ex) {

         ex.printStackTrace();

        }
         return fecha;
    }
    
}
