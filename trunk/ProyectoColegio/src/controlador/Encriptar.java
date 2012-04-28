/*
 * Encriptar.java
 *
 * Created on 13 de agosto de 2007, 18:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controlador;

/**
 *
 * @author Administrador
 */
import java.math.*;

public class Encriptar 
{
    
    /** Creates a new instance of Encriptar */
    public Encriptar() 
    {
    }
    
    private int ascii(char letra)
    {
        int codigo = 0;
        char le;
        
        if(letra == 'A')
            codigo=0;
        if(letra == 'B')
            codigo=1;
        if(letra == 'C')
            codigo=2;
        if(letra == 'D')
            codigo=3;
        if(letra == 'E')
            codigo=4;
        if(letra == 'F')
            codigo=5;
        if(letra == 'G')
            codigo=6;
        if(letra == 'H')
            codigo=7;
        if(letra == 'I')
            codigo=8;
        if(letra == 'J')
            codigo=9;
        if(letra == 'K')
            codigo=10;
        if(letra == 'L')
            codigo=11;
        if(letra == 'M')
            codigo=12;
        if(letra == 'N')
            codigo=13;
        if(letra == 'Ñ')
            codigo=14;
        if(letra == 'O')
            codigo=15;
        if(letra == 'P')
            codigo=16;
        if(letra == 'Q')
            codigo=17;
        if(letra == 'R')
            codigo=18;
        if(letra == 'S')
            codigo=19;
        if(letra == 'T')
            codigo=20;
        if(letra == 'U')
            codigo=21;
        if(letra == 'V')
            codigo=22;
        if(letra == 'W')
            codigo=23;
        if(letra == 'X')
            codigo=24;
        if(letra == 'Y')
            codigo=25;
        if(letra == 'Z')
            codigo=26;
        if(letra == '0')
            codigo=27;
        if(letra == '1')
            codigo=28;
        if(letra == '2')
            codigo=29;
        if(letra == '3')
            codigo=30;
        if(letra == '4')
            codigo=31;
        if(letra == '5')
            codigo=32;
        if(letra == '6')
            codigo=33;
        if(letra == '7')
            codigo=34;
        if(letra == '8')
            codigo=35;
        if(letra == '9')
            codigo=36;
        return codigo;
    }
    
    private char devolverLetra(int index)
    {
        char letra = ' ';
        switch(index)
        {
            case 0:
                letra = 'A';
                break;
            case 1:
                letra = 'B';
                break;
            case 2:
                letra = 'C';
                break;
            case 3:
                letra = 'D';
                break;
            case 4:
                letra = 'E';
                break;
            case 5:
                letra = 'F';
                break;
            case 6:
                letra = 'G';
                break;
            case 7:
                letra = 'H';
                break;
            case 8:
                letra = 'I';
                break;
            case 9:
                letra = 'J';
                break;
            case 10:
                letra = 'K';
                break;
            case 11:
                letra = 'L';
                break;
            case 12:
                letra = 'M';
                break;
            case 13:
                letra = 'N';
                break;
            case 14:
                letra = 'Ñ';
                break;
            case 15:
                letra = 'O';
                break;
            case 16:
                letra = 'P';
                break;
            case 17:
                letra = 'Q';
                break;
            case 18:
                letra = 'R';
                break;
            case 19:
                letra = 'S';
                break;
            case 20:
                letra = 'T';
                break;
            case 21:
                letra = 'U';
                break;
            case 22:
                letra = 'V';
                break;
            case 23:
                letra = 'W';
                break;
            case 24:
                letra = 'X';
                break;
            case 25:
                letra = 'Y';
                break;
            case 26:
                letra = 'Z';
                break;
            case 27:
                letra = '0';
                break;
            case 28:
                letra = '1';
                break;
            case 29:
                letra = '2';
                break;
            case 30:
                letra = '3';
                break;
            case 31:
                letra = '4';
                break;
            case 32:
                letra = '5';
                break;
            case 33:
                letra = '6';
                break;
            case 34:
                letra = '7';
                break;
            case 35:
                letra = '8';
                break;
            case 36:
                letra = '9';
                break;
        }
        return letra;
    }
    
    public String codificar(String mensaje)
    {
        //String mensajeCodificado = "";
        StringBuffer temp = new StringBuffer();
        mensaje = mensaje.toUpperCase();
        //int c = 0;
        int indice;
        //String letra = "";
        for(int i=0;i<mensaje.length();i++)
        {
            indice = this.ascii(mensaje.charAt(i));
            indice = ((4*indice)+10)%37;
            temp.append(this.devolverLetra(indice));
        }
        return temp.toString();
    }
    
}
