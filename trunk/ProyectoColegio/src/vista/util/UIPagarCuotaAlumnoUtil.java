/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.util;

import Datos.CarrerasSql;
import Datos.CuotasSql;
import Datos.InscripcionesSql;
import dominio.Carrera;
import dominio.Cuota;
import dominio.Inscripcion;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcelo
 */
public class UIPagarCuotaAlumnoUtil 
{
    private Collection<Carrera> carreras;
    private Collection<Inscripcion> inscripciones;
    private Collection<Cuota> cuotas;
    private InscripcionesSql inscripcionesSql = new InscripcionesSql();
    private CarrerasSql carrerasSql = new CarrerasSql();
    private long idAlumno;

    public UIPagarCuotaAlumnoUtil() 
    {
    }
    public UIPagarCuotaAlumnoUtil(long idAlumno) 
    {
        this.idAlumno = idAlumno;
    }
    
    public void cargarComboCarreras(JComboBox combo, long idAlumno)
    {
        combo.removeAllItems();
//        this.carreras = carrerasSql.getCarrerasAlumno(idAlumno);
        this.carreras = carrerasSql.getCarrerasAlumno(idAlumno);
        Iterator<Carrera> it = carreras.iterator();
        while(it.hasNext())
        {
//            String c = it.next().getNombre().trim();
//            System.out.println(c);
//            combo.addItem(c);
            combo.addItem(it.next().getNombre().trim());
        }
    }
    
    public void cargarComboCursos(JComboBox combo, String nombreCarrera)
    {
        combo.removeAllItems();
        int id =  this.getIdCarrera(nombreCarrera.trim());
        this.inscripciones = inscripcionesSql.getCursos(id, this.idAlumno);
        Iterator<Inscripcion> it = this.inscripciones.iterator();
        boolean band = true;
        while(it.hasNext())
        {
//            combo.addItem(this.cursos.next().getCurso());
            combo.addItem(it.next().getAnio());
            if(band)
            {
                combo.setSelectedIndex(0);
                band = false;
            }
            
        }
    }
    
    public void cargarCuotas(JTable tabla, JComboBox comboCursos)
    {
        this.limpiarTabla(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        CuotasSql sql = new CuotasSql();
        this.cuotas = sql.getCuotasAlumnoInscripcion(idAlumno, this.getIdInscripcion(Integer.parseInt(String.valueOf(comboCursos.getSelectedItem()))));
        Iterator<Cuota> it = this.cuotas.iterator();
        String[] datos = new String[6];
        Calendar ca = Calendar.getInstance();
        while(it.hasNext())
        {
            Cuota c = it.next();
            ca.setTime(c.getPeriodo());
            datos[0] = String.valueOf(c.getId());
            datos[1] = String.valueOf(ca.get(Calendar.MONTH))+"/"+String.valueOf(ca.get(Calendar.YEAR));
            datos[2] = String.valueOf(c.getMonto());
            datos[3] = String.valueOf(c.getPago().getMonto());
            if(c.isCuota())
                datos[4] = "CUOTA";
            else
                datos[4] = "INSCRIPCION";
            if(c.isPagado())
                datos[5] = "PAGADO";
            else
                datos[5] = "IMPAGO";
            modelo.addRow(datos);
        }
    }
    
    private void limpiarTabla(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }
    
        
//    private int getIdCarrera(String nombre)
//    {
//        Carrera c = new Carrera();
//        while(this.carreras.hasNext())
//        {
//            c = this.carreras.next();
//            if(c.getNombre().trim().toUpperCase().equals(nombre.trim().toUpperCase()))
//                break;
//        }
//        return c.getId();
//    }
    
    private int getIdCarrera(String nombre)
    {
        Carrera c = new Carrera();
        Collection<Carrera> co = carrerasSql.getCarrerasAlumno(idAlumno);
        Iterator<Carrera> it = co.iterator();
        while(it.hasNext())
        {
            c = it.next();
            if(c.getNombre().trim().toUpperCase().equals(nombre.trim().toUpperCase()))
                break;
        }
        return c.getId();
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    private long getIdInscripcion(int anio)
    {
        long id = 0;
        Iterator<Inscripcion> it = this.inscripciones.iterator();
        while(it.hasNext())
        {
            Inscripcion i = it.next();
            if(i.getAnio() == anio)
                id = i.getId();
        }
            
        return id;
    }
    
    
}
