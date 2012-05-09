/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.util;

import Datos.ProductosSql;
import controlador.CListar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocios.Producto;

/**
 *
 * @author marcelo
 */
public class UIAsociarProductosAlumnosUtil 
{
    private Collection<Producto> productos = new ArrayList<Producto>();
    private Collection<Producto> productosAsociados = new ArrayList<Producto>();

    public UIAsociarProductosAlumnosUtil() {
    }
    
    
    public void llenarTabla(JTable tabla)
    {
        this.limpiar(tabla);
        //De alguna forma obtengo una coleccion con los barrios cargados en la base de datos
        CListar listar = new CListar();
        productos = listar.hacerListado(new Producto());
//        this.conf = listar.hacerListado(conf);
        listar = null;
        this.recargarProductos(tabla);
    }
    
    
    private void limpiar(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }
    
    public void AgregarProducto(JTable origen, JTable destino)
    {
        int id = Integer.parseInt(String.valueOf(origen.getValueAt(origen.getSelectedRow(), 0)));
        Iterator<Producto> it = this.productos.iterator();
        while(it.hasNext())
        {
            Producto p = it.next();
            if(p.getIdproducto() == id)
            {
                this.productosAsociados.add(p);
                System.out.println("Se agrego el producto "+p.getDenominacion());
                DefaultTableModel modelo = (DefaultTableModel)destino.getModel();
                String datos[] = new String[2];
                datos[0] = String.valueOf(p.getIdproducto());
                datos[1] = p.getDenominacion().trim();
                modelo.addRow(datos);
                this.quitarProducto(p, origen);
                break;
            }
        }
    }
    
    private void quitarProducto(Producto p,JTable tabla)
    {
        this.productos.remove(p);
        this.limpiar(tabla);
        this.recargarProductos(tabla);
    }
    
    private void recargarProductos(JTable tabla)
    {
        Iterator<Producto> it = productos.iterator();
        // ahora obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[2];
        while(it.hasNext())
        {
            Producto p = it.next();
            datos[0] = String.valueOf(p.getIdproducto()).trim();
            datos[1] = p.getDenominacion().trim();
            modelo.addRow(datos);
        }
    }
    
    public void guardar()
    {
        ProductosSql sql = new ProductosSql();
        Iterator<Producto> it = this.productosAsociados.iterator();
        while(it.hasNext())
        {
            Producto p = it.next();
            sql.guardarProducto(p);
        }
    }
    
}
