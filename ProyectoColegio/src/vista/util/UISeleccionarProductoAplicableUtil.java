/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.util;

import Datos.ProductosSql;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import negocios.Producto;

/**
 *
 * @author marcelo
 */
public class UISeleccionarProductoAplicableUtil 
{

    private Collection<Producto> productos = new ArrayList<Producto>();
    private UIPagarCuotaAlumnoUtil pagarCuota;
    
    public UISeleccionarProductoAplicableUtil() {
    }

    public UIPagarCuotaAlumnoUtil getPagarCuota() {
        return pagarCuota;
    }

    public void setPagarCuota(UIPagarCuotaAlumnoUtil pagarCuota) {
        this.pagarCuota = pagarCuota;
    }
    
    public void cargarCombo(JComboBox combo)
    {
        ProductosSql sql = new ProductosSql();
        this.productos = sql.getAll();
        Iterator<Producto> it = this.productos.iterator();
        while(it.hasNext())
        {
            Producto p = it.next();
            combo.addItem(p.getDenominacion().trim());
        }
    }
    
    public void mostrarDatos(JComboBox combo,JTextField monto, JTextField id, JTextField denominacion)
    {
        Producto p = this.getProducto(String.valueOf(combo.getSelectedItem()));
        monto.setText(String.valueOf(p.getPrecio()));
        id.setText(String.valueOf(p.getIdproducto()));
        denominacion.setText(p.getDenominacion().trim());
    }
    
    public void aplicarProducto(JComboBox combo,JTextField monto, JTextField id, JTextField denominacion)
    {
        Producto p = this.getProducto(String.valueOf(combo.getSelectedItem()));
        this.limpiarTodo(monto, id, denominacion);
        this.pagarCuota.aplicarProducto(p);
    }
    
    private void limpiarTodo(JTextField monto, JTextField id, JTextField denominacion)
    {
        monto.setText("");
        id.setText("");
        denominacion.setText("");
    }
    
    private Producto getProducto(String nombre)
    {
        Iterator<Producto> it = this.productos.iterator();
        Producto prod = null;
        while(it.hasNext())
        {
            Producto p = it.next();
            if(p.getDenominacion().trim().toUpperCase().equals(nombre.trim().toUpperCase()))
            {
                prod = p;
                break;
            }
        }
        return prod;
    }
    
}
