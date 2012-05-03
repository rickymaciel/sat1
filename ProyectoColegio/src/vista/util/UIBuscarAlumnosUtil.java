/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.util;

import Datos.AlumnosSql;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dominio.Alumno;
import vista.UIPagarCuotaAlumno;

/**
 *
 * @author marcelo
 */
public class UIBuscarAlumnosUtil 
{
    private Iterator<Alumno> alumnos;

    public UIBuscarAlumnosUtil() {
    }
    
    public void cargarGrid(JTable tabla)
    {
        this.limpiarTabla(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[4];
        AlumnosSql sql = new AlumnosSql();
//        Iterator<Alumno> it = sql.getAll();
        alumnos = sql.getAll();
        while(alumnos.hasNext())
        {
            Alumno a = alumnos.next();
            datos[0] = String.valueOf(a.getId());
            datos[1] = String.valueOf(a.getDni());
            datos[2] = a.getApellido().trim().toUpperCase();
            datos[3] = a.getNombres().trim().toUpperCase();
            modelo.addRow(datos);
            a = null;
        }
    }
    
    public void filtrarListaDni(JTable tabla, String dni)
    {
        this.limpiarTabla(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[4];
        AlumnosSql sql = new AlumnosSql();
        Alumno a = sql.getAlumno(Long.parseLong(dni));
        if(a!=null)
        {
            datos[0] = String.valueOf(a.getId());
            datos[1] = String.valueOf(a.getDni());
            datos[2] = a.getApellido().trim().toUpperCase();
            datos[3] = a.getNombres().trim().toUpperCase();
            modelo.addRow(datos);
            a = null;
        }
        else
            JOptionPane.showMessageDialog(null, "No se encontro un alumno con DNI "+dni,"No existe el alumno",JOptionPane.ERROR_MESSAGE);
    }
    
    private void limpiarTabla(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }
    
    public void verCuotas(long idAlumno)
    {
        UIPagarCuotaAlumno uiPagarCuota = new UIPagarCuotaAlumno(idAlumno);
        uiPagarCuota.setVisible(true);
    }
    
    
    
}
