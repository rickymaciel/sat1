/*
 * UINuevaCondicionVenta.java
 *
 * Created on 8 de enero de 2008, 11:45
 */

package vista;

import Datos.Baja;
import Datos.Modificacion;
import controlador.CAlta;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.CondicionVenta;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UINuevaCondicionVenta extends javax.swing.JFrame
{
    private Collection condiciones = new ArrayList();
    private boolean guardar = false;
    
    /** Creates new form UINuevaCondicionVenta */
    public UINuevaCondicionVenta()
    {
        initComponents();
        // Codigo necesario para centrar la ventana
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        this.llenarTabla(new CondicionVenta());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTNombreCondicionVta = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTNombre1 = new javax.swing.JTextField();
        jBNuevo = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar condicion de venta");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Nombre");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel1.setOpaque(true);

        jTNombreCondicionVta.setToolTipText("Ingrese letras para realizar un filtrado del listado.");
        jTNombreCondicionVta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreCondicionVtaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreCondicionVtaKeyReleased(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.setToolTipText("Guarda la nueva condicion de venta");
        jBGuardar.setEnabled(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.setToolTipText("Cierra la ventana");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("Seleccione un elemento para modificarlo o eliminarlo.");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jTCodigo.setToolTipText("El codigo se genera autom�ticamente.");
        jTCodigo.setEnabled(false);
        jTCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCodigoKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Codigo");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Nombre");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel4.setOpaque(true);

        jTNombre1.setToolTipText("Ingrese un nombre valido de condicion de venta.");
        jTNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombre1ActionPerformed(evt);
            }
        });
        jTNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombre1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBNuevo.setText("Nuevo");
        jBNuevo.setToolTipText("Presione nuevo si desea agregar un nuevo registro.");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });
        jBNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBNuevoKeyPressed(evt);
            }
        });

        jBModificar.setText("Modificar");
        jBModificar.setToolTipText("Permite guargar los cambios realizados al registro seleccionado.");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });
        jBModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBModificarKeyPressed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pllena.gif"))); // NOI18N
        jBEliminar.setToolTipText("eliminar un registro seleccionado del listado.");
        jBEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEliminarMouseClicked(evt);
            }
        });
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jBEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBEliminarKeyPressed(evt);
            }
        });

        jBImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/printer.gif"))); // NOI18N
        jBImprimir.setToolTipText("imprimir un reporte del listado completo de productos.");
        jBImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBImprimirMouseClicked(evt);
            }
        });
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        jBImprimir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBImprimirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNombreCondicionVta, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombreCondicionVta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNombreCondicionVtaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTNombreCondicionVtaKeyReleased
    {//GEN-HEADEREND:event_jTNombreCondicionVtaKeyReleased
// TODO add your handling code here:
        this.filtrar(this.jTNombreCondicionVta.getText().trim().toUpperCase());
    }//GEN-LAST:event_jTNombreCondicionVtaKeyReleased

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBGuardarActionPerformed
    {//GEN-HEADEREND:event_jBGuardarActionPerformed
// TODO add your handling code here:
        if(this.controlar() == 0)
            this.guardar();
        else
            JOptionPane.showMessageDialog(null,"Debe ingresar todos los datos solicitados","Faltan Datos",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBModificarKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jBModificarKeyPressed
    {//GEN-HEADEREND:event_jBModificarKeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jBModificarKeyPressed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBModificarActionPerformed
    {//GEN-HEADEREND:event_jBModificarActionPerformed
// TODO add your handling code here:
        if((this.controlar()==0) && (this.jTCodigo.getText().trim().length() != 0))
            this.modificar();
        else
            JOptionPane.showMessageDialog(null,"Debe ingresar los datos solicitados","Faltan Datos",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBNuevoKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jBNuevoKeyPressed
    {//GEN-HEADEREND:event_jBNuevoKeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyCode()==10)
        {
            this.guardar = true;
            this.jBGuardar.setEnabled(true);
            this.jTCodigo.setText("");
            this.jTNombre1.setText("");
            this.jTNombre1.requestFocus();
        }
    }//GEN-LAST:event_jBNuevoKeyPressed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBNuevoActionPerformed
    {//GEN-HEADEREND:event_jBNuevoActionPerformed
// TODO add your handling code here:
        this.guardar = true;
        this.jBGuardar.setEnabled(true);
        this.jTCodigo.setText("");
        this.jTNombre1.setText("");
        this.jTNombre1.requestFocus();
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jTNombre1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTNombre1KeyPressed
    {//GEN-HEADEREND:event_jTNombre1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
    }//GEN-LAST:event_jTNombre1KeyPressed

    private void jTNombre1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTNombre1ActionPerformed
    {//GEN-HEADEREND:event_jTNombre1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTNombre1ActionPerformed

    private void jTCodigoKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTCodigoKeyPressed
    {//GEN-HEADEREND:event_jTCodigoKeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoKeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable1KeyPressed
    {//GEN-HEADEREND:event_jTable1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyCode()==127)
        {
            this.borrarRegistro(this.jTable1.getSelectedRow());
            this.jTNombre1.setText("");
            this.jTCodigo.setText("");
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
// cuando se seleccione una fila, los datos de esa fila deben aparecer en los textbox de abajo solo si no se esta por cargar un nuevo elemento
        if(!this.guardar)
        {
            Iterator it = condiciones.iterator();
            CondicionVenta t = new CondicionVenta();
            while(it.hasNext())
            {
                t = (CondicionVenta)it.next();
                if(t.getIdcondicionVenta() == Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0))))
                {
                    this.jTCodigo.setText(String.valueOf(t.getIdcondicionVenta()));
                    this.jTNombre1.setText(t.getNombre());
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBSalirActionPerformed
    {//GEN-HEADEREND:event_jBSalirActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseClicked
        // TODO add your handling code here:
        this.borrarRegistro(jTable1.getSelectedRow());
    }//GEN-LAST:event_jBEliminarMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBEliminarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        this.borrarRegistro(jTable1.getSelectedRow());
    }//GEN-LAST:event_jBEliminarKeyPressed

    private void jBImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBImprimirMouseClicked
        // TODO add your handling code here:
        cExport_thread report = new cExport_thread(10);
        report.start();
    }//GEN-LAST:event_jBImprimirMouseClicked

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBImprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBImprimirKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyCode()==10){
            cExport_thread report = new cExport_thread(10);
            report.start();
        }
    }//GEN-LAST:event_jBImprimirKeyPressed

    private void jTNombreCondicionVtaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreCondicionVtaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
    }//GEN-LAST:event_jTNombreCondicionVtaKeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new UINuevaCondicionVenta().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JTextField jTNombre1;
    private javax.swing.JTextField jTNombreCondicionVta;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private int controlar()
    {
        int estado = 0;
        if(this.jTNombre1.getText().trim().length() == 0)
            estado = 1;
        return estado;
    }
 
    private void guardar()
    {
     CondicionVenta condicion = new CondicionVenta();
     condicion.setNombre(this.jTNombre1.getText().toUpperCase().trim());
     condicion.setExiste("S");
     this.jBGuardar.setEnabled(false);
     this.guardar = false;
     CAlta alta = new CAlta();
        int respuesta = alta.hacerAlta(condicion);
        if(respuesta != 0)
                JOptionPane.showMessageDialog(null,"Error en la carga de datos","Error",JOptionPane.ERROR_MESSAGE);
        else
                JOptionPane.showMessageDialog(null,"Los datos se cargaron correctamente","Carga Finalizada",JOptionPane.INFORMATION_MESSAGE);
     this.limpiar();
     this.llenarTabla(new CondicionVenta());
     this.jTNombre1.setText("");
     this.jTCodigo.setText("");
    }
    
    
    private void modificar()
    {
     CondicionVenta condicion = new CondicionVenta();
     condicion.setNombre(this.jTNombre1.getText().toUpperCase().trim());
     condicion.setIdcondicionVenta(Integer.parseInt(this.jTCodigo.getText()));
     condicion.setExiste("S");
     this.jBGuardar.setEnabled(false);
     this.guardar = false;
     Modificacion mod = new Modificacion();
     int respuesta = mod.modificar(condicion);
     if(respuesta == 0)
                JOptionPane.showMessageDialog(null,"Error en la modificacion de datos","Error",JOptionPane.ERROR_MESSAGE);
        else
                JOptionPane.showMessageDialog(null,"Los datos se modificaron correctamente","Carga Finalizada",JOptionPane.INFORMATION_MESSAGE);
     this.limpiar();
     this.llenarTabla(new CondicionVenta());
     this.jTNombre1.setText("");
     this.jTCodigo.setText("");
    }
    
    private void llenarTabla(CondicionVenta c)
    {
        //De alguna forma obtengo una coleccion con los barrios cargados en la base de datos
        CListar listar = new CListar();
        condiciones = listar.hacerListado(c);
        listar = null;
        Iterator it = condiciones.iterator();
        // ahora obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        String datos[] = new String[2];
        while(it.hasNext())
        {
            c = (CondicionVenta)it.next();
            datos[0] = String.valueOf(c.getIdcondicionVenta());
            datos[1] = c.getNombre();
            modelo.addRow(datos);
        }
        c = null;
        it = null;
        datos = null;
        modelo = null;
    }
    
    private void limpiar()
    {
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        while(this.jTable1.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }
    
    private void filtrar(String cadena)
    {
        // de alguna forma mando la cadena para que otro objeto me devuelva una nueva coleccion con los barrios filtrados
        //barrios = algo(cadena);
        // solo queda limpiar la tabla y volverla a cargar
        this.limpiar();
        CondicionVenta p = new CondicionVenta();
        p.setNombre(cadena);
        this.llenarTabla(p);
    }
    
    private void borrarRegistro(int fila)
    {
        Iterator it = condiciones.iterator();
        while(it.hasNext())
        {
            CondicionVenta p = (CondicionVenta)it.next();
            if(p.getIdcondicionVenta() == Integer.parseInt(String.valueOf(this.jTable1.getValueAt(fila,0))))
            {
                Baja baja = new Baja();
                int respuesta = baja.eliminar(p);
                baja = null;
                if(respuesta == 0)
                    JOptionPane.showMessageDialog(null,"Error al dar de baja el tipo de condicion de venta","Error",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"El tipo de condicion de venta se elimino correctamente","Baja Completada",JOptionPane.INFORMATION_MESSAGE);
            }
            p = null;
        }
        it = null;
        this.limpiar();
        this.llenarTabla(new CondicionVenta());
        this.jTNombre1.setText("");
        this.jTCodigo.setText("");
    }
}