/*
 * UIMostrarNoFacturadas.java
 *
 * Created on 10 de mayo de 2008, 01:07
 */

package vista;

import Datos.Baja;
import Datos.Modificacion;
import controlador.Algoritmos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.EncabezadoPago;

/**
 *
 * @author  marcelo gonzalez
 */
public class UIMostrarNoFacturadas extends javax.swing.JDialog
{
    private boolean bandera = false;
    private Collection cp = new ArrayList();
    private Collection ct = new ArrayList();
    private Collection cuotas = new ArrayList();
    private UICerrarCaja cerrarCaja = new UICerrarCaja();
    
    /** Creates new form UIMostrarNoFacturadas */
    public UIMostrarNoFacturadas(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.centrarVentana();
        this.inicializarColumnas();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAnular = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Documentos No Facturados");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serie", "Codigo", "Tipo Doc.", "Responsable", "Monto", "Seleccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonAnular.setText("Anular");
        jButtonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnularActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonSeleccionar.setText("Seleccionar");
        jButtonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jButtonAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(476, Short.MAX_VALUE)
                .addComponent(jButtonSeleccionar)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonSeleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarActionPerformed
// TODO add your handling code here:
    this.seleccionarTodas();
}//GEN-LAST:event_jButtonSeleccionarActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButtonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnularActionPerformed
// TODO add your handling code here:
    this.anular();
}//GEN-LAST:event_jButtonAnularActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new UIMostrarNoFacturadas(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAnular;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private void centrarVentana()
    {
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
    }
    
    private void inicializarColumnas()
    {
        TableColumn column = null;
    for (int i = 0; i < 5; i++) 
    {
        column = jTable1.getColumnModel().getColumn(i);
        switch(i)
        {
            case 0:
                    column.setPreferredWidth(20);
                    break;
            case 1:
                    column.setPreferredWidth(50);
                    break;
            case 2:
                    column.setPreferredWidth(102); 
                    break;
            case 3:
                    column.setPreferredWidth(230); 
                    break;
            case 4:
                    column.setPreferredWidth(55); 
                    break;
            case 5:
                    column.setPreferredWidth(39);
                    break;
    }
}
    }
    public void mostrarCT()
    {
        if(this.ct.size() != 0)
        {
            Iterator it = this.ct.iterator();
            String datos[] = new String[5];
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
            while(it.hasNext())
            {
                EncabezadoCT e = (EncabezadoCT)it.next();
                datos[0] = e.getSerieCT().trim();
                datos[1] = String.valueOf(e.getCodigoCT());
                datos[2] = "Constancia Total";
                datos[3] = e.getMatriculado().getMatricula()+" - "+e.getMatriculado().getApellido().trim()+", "+e.getMatriculado().getNombres().trim();
//                datos[3] = String.valueOf(e.getMatriculado().getMatricula());
                datos[4] = nf.format(e.getTotal());
                modelo.addRow(datos);
                e = null;
            }
            it = null;
            datos = null;
            modelo = null;
        }
    }
    
    public void mostrar(Collection cp, Collection ct, Collection cuotas, UICerrarCaja cerrarCaja)
    {
        this.cerrarCaja = cerrarCaja;
        this.ct = ct;
        this.cp = cp;
        this.cuotas = cuotas;
        this.mostrarCP();
        this.mostrarCT();
        this.mostrarCuota();
    }
    
    public void mostrarCP()
    {
        
        if(this.cp.size() != 0)
        {
            Iterator it = this.cp.iterator();
            String datos[] = new String[5];
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
            while(it.hasNext())
            {
                EncabezadoCP e = (EncabezadoCP)it.next();
                datos[0] = e.getSerieCP().trim();
                datos[1] = String.valueOf(e.getCodigoCP());
                datos[2] = "Constancia Parcial";
                datos[3] = e.getMatriculado().getMatricula()+" - "+e.getMatriculado().getApellido().trim()+", "+e.getMatriculado().getNombres().trim();
                datos[4] = nf.format(e.getTotal());
                modelo.addRow(datos);
                e = null;
            }
            it = null;
            datos = null;
            modelo = null;
        }
    }
    
    public void mostrarCuota()
    {
        
        if(this.cuotas.size() != 0)
        {
            Iterator it = this.cuotas.iterator();
            String datos[] = new String[5];
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
            while(it.hasNext())
            {
                EncabezadoPago e = (EncabezadoPago)it.next();
                datos[0] = "---";
                datos[1] = String.valueOf(e.getIdencabezado());
                datos[2] = "Pago Cuota";
                datos[3] = String.valueOf(e.getMatricula())+" - "+e.getApellidoMatriculado().trim()+", "+e.getNombresMatriculado().trim();
                datos[4] = nf.format(e.getTotal());
                modelo.addRow(datos);
                e = null;
            }
            it = null;
            datos = null;
            modelo = null;
        }
    }
    
    private void seleccionarTodas()
    {
        if(bandera)
            bandera = false;
        else
            bandera = true;
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        for(int i = 0; i<this.jTable1.getRowCount();i++)
            if(bandera)
                modelo.setValueAt(true, i, 5);
            else
                modelo.setValueAt(false, i, 5);
        modelo = null;
    }
    
    private void anularCT(int i)
    {
        Modificacion mod = new Modificacion();
        boolean band = true;
        int respuesta;
        EncabezadoCT e = new EncabezadoCT();
        band = Boolean.parseBoolean(String.valueOf(this.jTable1.getValueAt(i, 5)));
        if(band)
            {
                e = this.buscarCT(String.valueOf(this.jTable1.getValueAt(i, 0)), String.valueOf(this.jTable1.getValueAt(i, 1)));
                e.setAnulado("S");
                respuesta = mod.modificar(e);
            }
//        this.actualizarCT();
        mod = null;
        e = null;
    }
    
    private EncabezadoCT buscarCT(String serie, String codigo)
    {
        EncabezadoCT encabezado = new EncabezadoCT();
        Iterator it = this.ct.iterator();
        while(it.hasNext())
        {
            EncabezadoCT e = (EncabezadoCT)it.next();
            if((e.getSerieCT().trim().equals(serie.trim())) && (e.getCodigoCT() == Long.parseLong(codigo)))
            {
                encabezado = e;
                e = null;
                break;
            }
            e = null;
        }
        it = null;
        return encabezado;
    }
    
    private void actualizarCT()
    {
        Algoritmos algoritmos = new Algoritmos();
        this.ct.clear();
        this.ct = algoritmos.devolverCTImpaga();
        algoritmos = null;
    }
    
    private void anularCP(int i)
    {
        Modificacion mod = new Modificacion();
        boolean band = true;
        int respuesta;
        EncabezadoCP e = new EncabezadoCP();
        band = Boolean.parseBoolean(String.valueOf(this.jTable1.getValueAt(i, 5)));
        if(band)
            {
                e = this.buscarCP(String.valueOf(this.jTable1.getValueAt(i, 0)), String.valueOf(this.jTable1.getValueAt(i, 1)));
                e.setAnulado("S");
                respuesta = mod.modificar(e);
            }
        this.actualizarCP();
        mod = null;
        e = null;
    }
    
    private EncabezadoCP buscarCP(String serie, String codigo)
    {
        EncabezadoCP encabezado = new EncabezadoCP();
        Iterator it = this.cp.iterator();
        while(it.hasNext())
        {
            EncabezadoCP e = (EncabezadoCP)it.next();
            if((e.getSerieCP().trim().equals(serie.trim())) && (e.getCodigoCP() == Long.parseLong(codigo)))
            {
                encabezado = e;
                e = null;
                break;
            }
            e = null;
        }
        return encabezado;
    }
    
    private void actualizarCP()
    {
        Algoritmos algoritmos = new Algoritmos();
        this.cp.clear();
        this.cp = algoritmos.devolverCPImpaga();
        algoritmos = null;
    }
    
    private void anularCuota(int i)
    {
        boolean band = true;
        Baja baja = new Baja();
        int respuesta;
        band = Boolean.parseBoolean(String.valueOf(this.jTable1.getValueAt(i, 5)));
        if(band)
            {
                respuesta = baja.eliminarEncabezadoPago(Long.parseLong(String.valueOf(this.jTable1.getValueAt(i, 1))));
                if(respuesta != 0)
                    respuesta =baja.eliminarDetallePago(Long.parseLong(String.valueOf(this.jTable1.getValueAt(i, 1))));
            }
        baja = null;
        this.actualizarCuotas();
    }
    
    private void actualizarCuotas()
    {
        Algoritmos algoritmos = new Algoritmos();
        this.cuotas.clear();
        this.cuotas = algoritmos.devolverCuotaImpaga();
        algoritmos = null;
    }
    
    private void limpiar()
    {
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        while(this.jTable1.getRowCount() != 0)
            modelo.removeRow(0);
        modelo = null;
    }
    
    private void anular()
    {
        for(int i=0;i<this.jTable1.getRowCount();i++)
        {
            if(String.valueOf(this.jTable1.getValueAt(i, 2)).trim().equals("Constancia Parcial"))
                this.anularCP(i);
            else
                if(String.valueOf(this.jTable1.getValueAt(i, 2)).trim().equals("Constancia Total"))
                    this.anularCT(i);
                else
                    if(String.valueOf(this.jTable1.getValueAt(i, 2)).trim().equals("Pago Cuota"))
                        this.anularCuota(i);
        }
        this.limpiar();
        // limpio las colecciones
        this.actualizarCT();
        this.mostrarCP();
        this.mostrarCT();
        this.mostrarCuota();
        if(this.jTable1.getRowCount() == 0)
            this.cerrarCaja.habilitarCerrarCaja();
        
    }
}


