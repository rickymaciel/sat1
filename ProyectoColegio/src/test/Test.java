/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Datos.AlumnosSql;
import java.util.Iterator;
import dominio.Alumno;
import vista.UIBuscarAlumnos;

/**
 *
 * @author marcelo
 */
public class Test 
{

    public Test() {
    }
    
    public static void main(String[] args)
    {
        // TODO code application logic here
//        AlumnosSql sql = new AlumnosSql();
//        Iterator<Alumno> it = sql.getAll();
//        while(it.hasNext())
//        {
//            Alumno a = it.next();
//            System.out.println("Apellido: "+a.getApellido().trim().toUpperCase());
//        }
        UIBuscarAlumnos ui = new UIBuscarAlumnos();
        ui.setVisible(true);
    }
    
}
