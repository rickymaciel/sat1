/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.util;

import Datos.CarrerasSql;
import Datos.CuotasSql;
import Datos.InscripcionesSql;
import Datos.PagosSql;
import dominio.Carrera;
import dominio.Cuota;
import dominio.DetallePago;
import dominio.Inscripcion;
import dominio.Pago;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocios.Fecha;
import negocios.Producto;
import vista.UISeleccionarProductoAplicable;

/**
 *
 * @author marcelo
 */
public class UIPagarCuotaAlumnoUtil 
{
    private Collection<Carrera> carreras;
    private Collection<Inscripcion> inscripciones;
    private Collection<Cuota> cuotas;
    private Collection<Pago> pagos;
    private InscripcionesSql inscripcionesSql = new InscripcionesSql();
    private CarrerasSql carrerasSql = new CarrerasSql();
    private long idAlumno;
    private Collection<Producto> productos = new ArrayList<Producto>();
    private JTextField jTextMonto;
    private JTextField jTextEntregado;
    private JTextField jTextSaldo;

    public UIPagarCuotaAlumnoUtil() 
    {
    }
    public UIPagarCuotaAlumnoUtil(long idAlumno,JTextField monto, JTextField entregado, JTextField saldo) 
    {
        this.idAlumno = idAlumno;
        this.jTextMonto = monto;
        this.jTextEntregado = entregado;
        this.jTextSaldo = saldo;
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
    
    public void llenarDatosDePago(JTextField monto, JTextField entregado, JTextField saldo, JTextField aPagar, JTable tabla, JLabel mensaje)
    {
        PagosSql sql = new PagosSql();
        this.pagos = sql.getPagosAlumno(Long.parseLong(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0))));
//        if(!this.verificarProducto())
//        {
            UISeleccionarProductoAplicable uiSeleccionar = new UISeleccionarProductoAplicable(this);
            uiSeleccionar.setVisible(true);
//        }
//        else
//        {
            monto.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 2)));
            entregado.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 3)));
            saldo.setText(String.valueOf(Double.parseDouble(monto.getText()) - Double.parseDouble(entregado.getText())));
            aPagar.setText(saldo.getText());
//        }
        Fecha f= new Fecha();
        int dias = f.verficarVencimiento(this.getFechaVencimiento(Long.parseLong(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0)))));
        if(dias !=0)
        {
            mensaje.setForeground(Color.red);
            mensaje.setText("CUOTA VENCIDA");
        }
        else
        {
            if(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 5)).trim().equals("PAGADO"))
            {
                mensaje.setForeground(Color.green);
                mensaje.setText("CUOTA CANCELADA");
            }
            else
                mensaje.setText("");
        }
    }
    
    private boolean verificarProducto()
    {
        boolean bandera = true;
        Iterator<Pago> it = this.pagos.iterator();
        while(it.hasNext())
        {
            Pago p = it.next();
            if(p.getDetalles().isEmpty())
            {
                bandera = false;
                break;
            }
        }
        return bandera;
    }
    
    private double calcularMontoEntregado()
    {
        double total =0.0;
        Iterator<Pago> it = this.pagos.iterator();
        while(it.hasNext())
        {
            Pago p = it.next();
            total += p.getMonto();
        }
        return total;
    }
    
    public void actualizarSaldo(JTextField recargo, JTextField saldo, JTextField aPagar)
    {
        saldo.setText(String.valueOf(Double.parseDouble(saldo.getText()) + Double.parseDouble(recargo.getText())));
        aPagar.setText(saldo.getText());
    }
    
    public void pagarCuota(JTable tabla, JTextField pago)
    {
        Pago p = new Pago();
        p.setSerFactura(0);
        p.setNumeroFactura(0);
        p.setFecha(new Date());
        p.setIdCuota(Long.parseLong(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0))));
        p.setMonto(Double.parseDouble(pago.getText()));
        //ahora tengo que guardar el detalle de pago
        p.setDetalles(this.getDetalle(p));
        //ahora tengo que ver si es necesario actualizar el valor del campo "monto" en cuotas
        if(Double.parseDouble(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 2))) == 0)
        {
            //actualizo el campo monto
            Cuota c = this.getCuota(Long.parseLong(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0))));
            c.setMonto(Double.parseDouble(this.jTextMonto.getText()));
            CuotasSql sqlCuotas = new CuotasSql();
            sqlCuotas.modificarCuota(c);
        }
        PagosSql sql = new PagosSql();
        sql.guardarPago(p);
    }
    
    private Cuota getCuota(long idCuota)
    {
        Cuota c = null;
        Iterator<Cuota> it = this.cuotas.iterator();
        while(it.hasNext())
        {
            Cuota cu = it.next();
            if(cu.getId() == idCuota)
            {
                c = cu;
                break;
            }
        }
        return c;
    }
    
    private Collection<DetallePago> getDetalle(Pago pa)
    {
        Collection<DetallePago> detalles = new ArrayList<DetallePago>();
        Iterator<Producto> it = this.productos.iterator();
        while(it.hasNext())
        {
            Producto p = it.next();
            DetallePago d = new DetallePago();
            d.setProducto(p);
            d.setIdPago(pa.getIdPago());
            detalles.add(d);
        }
        return detalles;
    }
    
    
    
    private Date getFechaVencimiento(long idCuota)
    {
        Date fecha = null;
        Iterator<Cuota> it = this.cuotas.iterator();
        while(it.hasNext())
        {
            Cuota c = it.next();
            if(c.getId() == idCuota)
            {
                fecha = c.getPeriodo();
                break;
            }
        }
        return fecha;
    }
    
//    public void setProducto(Producto p)
//    {
//        this.producto = p;
//    }

    public JTextField getjTextEntregado() {
        return jTextEntregado;
    }

    public void setjTextEntregado(JTextField jTextEntregado) {
        this.jTextEntregado = jTextEntregado;
    }

    public JTextField getjTextMonto() {
        return jTextMonto;
    }

    public void setjTextMonto(JTextField jTextMonto) {
        this.jTextMonto = jTextMonto;
    }

    public JTextField getjTextSaldo() {
        return jTextSaldo;
    }

    public void setjTextSaldo(JTextField jTextSaldo) {
        this.jTextSaldo = jTextSaldo;
    }
    
    
    public void aplicarProducto(Producto p)
    {
        this.productos.add(p);
        this.recalcularSaldo();
    }
    
    private void recalcularSaldo()
    {
        double saldo = 0.0;
        Iterator<Producto> it = this.productos.iterator();
        boolean bandera = true;
        while(it.hasNext())
        {
            Producto p = it.next();
            saldo += p.getPrecio();
            if(bandera)
            {
                this.jTextMonto.setText(String.valueOf(p.getPrecio()));
                bandera = false;
            }
        }
        this.jTextSaldo.setText(String.valueOf(saldo));
    }
    
}
