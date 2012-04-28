/*
 * UINuevaTasa.java
 *
 * Created on 8 de enero de 2008, 12:30
 */

package vista;

import Datos.Baja;
import Datos.Modificacion;
import controlador.CAlta;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Tasa;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UINuevaTasa extends javax.swing.JFrame
{
    private Collection tasas = new ArrayList();
    private boolean guardar = false;
    
    /** Creates new form UINuevaTasa */
    public UINuevaTasa()
    {
        initComponents();
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
                this.llenarTabla(new Tasa());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTDenominacion = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTObservaciones = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTDenominacion1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTIndice = new javax.swing.JTextField();
        jTTasaMinima = new javax.swing.JTextField();
        jBNuevo = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBEliminar = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Tasas");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Denominacion");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel1.setOpaque(true);

        jTDenominacion.setToolTipText("ingrese letras para realizar un filtrado del listado.");
        jTDenominacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDenominacionKeyReleased(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.setToolTipText("Guarda la nueva tasa");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        jTObservaciones.setColumns(20);
        jTObservaciones.setLineWrap(true);
        jTObservaciones.setRows(5);
        jTObservaciones.setToolTipText("Ingrese alguna anotacion sobre esta tasa.");
        jScrollPane1.setViewportView(jTObservaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Indice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("Elija un elemento del listado para modificarlo o eliminarlo.");
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
        jScrollPane2.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Codigo");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel6.setOpaque(true);

        jTCodigo.setToolTipText("El codigo se genera automaticamente.");
        jTCodigo.setEnabled(false);
        jTCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCodigoActionPerformed(evt);
            }
        });
        jTCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCodigoKeyPressed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Denominacion");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel4.setOpaque(true);

        jTDenominacion1.setToolTipText("ingrese una denominacion valido.\n");
        jTDenominacion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDenominacion1KeyPressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Indice");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel5.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("Tasa Minima");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel7.setOpaque(true);

        jTIndice.setToolTipText("Ingrese un valor de tasa valida entre 0 y 1. Ej: 0.02");
        jTIndice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTIndiceFocusLost(evt);
            }
        });
        jTIndice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTIndiceKeyPressed(evt);
            }
        });

        jTTasaMinima.setToolTipText("Ingrese en valor de PESOS ARGENTINOS la tasa minima. Ej.: 15.00");
        jTTasaMinima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTasaMinimaFocusLost(evt);
            }
        });
        jTTasaMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTasaMinimaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTTasaMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTDenominacion1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(jTCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDenominacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTasaMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jBNuevo.setText("Nuevo");
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTDenominacion, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBModificar)
                    .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTDenominacionKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTDenominacionKeyReleased
    {//GEN-HEADEREND:event_jTDenominacionKeyReleased
// TODO add your handling code here:
        this.filtrar(this.jTDenominacion.getText().trim().toUpperCase());
    }//GEN-LAST:event_jTDenominacionKeyReleased

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBGuardarActionPerformed
    {//GEN-HEADEREND:event_jBGuardarActionPerformed
// TODO add your handling code here:
        if(this.controlar()==0)
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
            JOptionPane.showMessageDialog(null,"Debe seleccionar un registro de la lista y luego modificar sus datos","Faltan Datos",JOptionPane.INFORMATION_MESSAGE);
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
            this.jTDenominacion1.setText("");
            this.jTIndice.setText("");
            this.jTObservaciones.setText("");
            this.jTTasaMinima.setText("");
            this.jTDenominacion1.requestFocus();
        }
    }//GEN-LAST:event_jBNuevoKeyPressed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBNuevoActionPerformed
    {//GEN-HEADEREND:event_jBNuevoActionPerformed
// TODO add your handling code here:
        this.guardar = true;
        this.jBGuardar.setEnabled(true);
        this.jTCodigo.setText("");
        this.jTDenominacion1.setText("");
        this.jTIndice.setText("");
        this.jTObservaciones.setText("");
        this.jTTasaMinima.setText("");
        this.jTDenominacion1.requestFocus();
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jTCodigoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTCodigoActionPerformed
    {//GEN-HEADEREND:event_jTCodigoActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoActionPerformed

    private void jTCodigoKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTCodigoKeyPressed
    {//GEN-HEADEREND:event_jTCodigoKeyPressed
// TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 0.5","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTCodigo.setText("");
            this.jTCodigo.requestFocus();
            evt.consume();
        }
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTDenominacion1.requestFocus();

        
    }//GEN-LAST:event_jTCodigoKeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable1KeyPressed
    {//GEN-HEADEREND:event_jTable1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyCode()==127)
            this.borrarRegistro(this.jTable1.getSelectedRow());
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
// cuando se seleccione una fila, los datos de esa fila deben aparecer en los textbox de abajo solo si no se esta por cargar un nuevo elemento
        if(!this.guardar)
        {
            Iterator it = tasas.iterator();
            Tasa t = new Tasa();
            while(it.hasNext())
            {
                t = (Tasa)it.next();
                if(t.getIdtasa() == Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0))))
                {
                    this.jTCodigo.setText(String.valueOf(t.getIdtasa()).trim());
                    this.jTDenominacion1.setText(t.getDenominacion().trim());
                    this.jTIndice.setText(String.valueOf(t.getIndice()).trim());
                    this.jTTasaMinima.setText(String.valueOf(t.getTasaMinima()).trim());
                    this.jTObservaciones.setText(t.getObservacion().trim());
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBSalirActionPerformed
    {//GEN-HEADEREND:event_jBSalirActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTIndiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIndiceKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE) || (c == '.'))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 0.5","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTIndice.setText("");
            this.jTIndice.requestFocus();
            evt.consume();
        }
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTTasaMinima.requestFocus();
        
        
    }//GEN-LAST:event_jTIndiceKeyPressed

    private void jTTasaMinimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTasaMinimaKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE) || (c == '.'))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 0.5","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTTasaMinima.setText("");
            this.jTTasaMinima.requestFocus();
            evt.consume();
        }
        if(evt.getKeyCode()==27)
            this.dispose();
    }//GEN-LAST:event_jTTasaMinimaKeyPressed

    private void jTDenominacion1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDenominacion1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTIndice.requestFocus();

        
    }//GEN-LAST:event_jTDenominacion1KeyPressed

    private void jBEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBEliminarMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        if (this.jTable1.getSelectedRow()>0){
            this.borrarRegistro(jTable1.getSelectedRow());        
        }else {
            JOptionPane.showMessageDialog(null,"Debe seleccionar un registro de la lista para eliminarlo","Atencion",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBEliminarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
    }//GEN-LAST:event_jBEliminarKeyPressed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jBImprimirActionPerformed

    private void jBImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBImprimirMouseClicked
        // TODO add your handling code here:
        cExport_thread report = new cExport_thread(12);
        report.start();
}//GEN-LAST:event_jBImprimirMouseClicked

    private void jBImprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBImprimirKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyCode()==10){
            cExport_thread report = new cExport_thread(12);
            report.start();
        }
            
}//GEN-LAST:event_jBImprimirKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyChar()==27)
             this.dispose();
    }//GEN-LAST:event_formKeyPressed

    private void jTIndiceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTIndiceFocusLost
        // TODO add your handling code here:
        Double indice=(Double.parseDouble((this.jTIndice.getText())));
        if (!(indice>=0 && indice <=1)){
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 0.5","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTIndice.setText("");
            this.jTIndice.requestFocus();
        }
        
        
    }//GEN-LAST:event_jTIndiceFocusLost

    private void jTTasaMinimaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTasaMinimaFocusLost
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTTasaMinimaFocusLost
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new UINuevaTasa().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JTextField jTDenominacion;
    private javax.swing.JTextField jTDenominacion1;
    private javax.swing.JTextField jTIndice;
    private javax.swing.JTextArea jTObservaciones;
    private javax.swing.JTextField jTTasaMinima;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private void llenarTabla(Tasa t)
    {
        //De alguna forma obtengo una coleccion con los barrios cargados en la base de datos
        CListar listar = new CListar();
        tasas = listar.hacerListado(t);
        listar = null;
        Iterator it = tasas.iterator();
        // ahora obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        String datos[] = new String[3];
        while(it.hasNext())
        {
            t = (Tasa)it.next();
            datos[0] = String.valueOf(t.getIdtasa());
            datos[1] = t.getDenominacion();
            datos[2] = String.valueOf(t.getIndice());
            modelo.addRow(datos);
        }
    }
    
    private int controlar()
    {
        int control = 0;
        if(this.jTDenominacion1.getText().trim().length()==0)
            control = 1;
        if(this.jTIndice.getText().trim().length()==0)
            control = 1;
        if(this.jTTasaMinima.getText().trim().length() == 0)
            control = 1;
        return control;
    }
    
    private void guardar()
    {
        Iterator it = tasas.iterator();
        Tasa tasa = new Tasa();
        tasa.setExiste("S");
        tasa.setDenominacion(this.jTDenominacion1.getText().toUpperCase().trim());
        tasa.setIndice(Double.parseDouble(this.jTIndice.getText().trim()));
        tasa.setObservacion(this.jTObservaciones.getText());
        tasa.setTasaMinima(Double.parseDouble(this.jTTasaMinima.getText()));
        this.guardar = false;
        this.jBGuardar.setEnabled(false);
        // aqui va el codigo que guarda en la base de datos
        CAlta alta = new CAlta();
        int respuesta = alta.hacerAlta(tasa);
        if(respuesta != 0)
                JOptionPane.showMessageDialog(null,"Error en la carga de datos","Error",JOptionPane.ERROR_MESSAGE);
        else
                JOptionPane.showMessageDialog(null,"Los datos se cargaron correctamente","Carga Finalizada",JOptionPane.INFORMATION_MESSAGE);
        this.limpiar();
        this.llenarTabla(new Tasa());
        this.jTCodigo.setText("");
        this.jTDenominacion1.setText("");
        this.jTIndice.setText("");
        this.jTObservaciones.setText("");
        this.jTTasaMinima.setText("");
    }
    
    
    private void modificar()
    {
        Iterator it = tasas.iterator();
        Tasa tasa = new Tasa();
        tasa.setExiste("S");
        tasa.setDenominacion(this.jTDenominacion1.getText().toUpperCase().trim());
        tasa.setIndice(Double.parseDouble(this.jTIndice.getText().trim()));
        tasa.setObservacion(this.jTObservaciones.getText());
        tasa.setTasaMinima(Double.parseDouble(this.jTTasaMinima.getText()));
        tasa.setIdtasa(Integer.parseInt(this.jTCodigo.getText()));
        this.guardar = false;
        this.jBGuardar.setEnabled(false);
        // aqui va el codigo que guarda en la base de datos
        Modificacion mod = new Modificacion();
        int respuesta = mod.modificar(tasa);
        if(respuesta == 0)
                JOptionPane.showMessageDialog(null,"Error en la carga de datos","Error",JOptionPane.ERROR_MESSAGE);
        else
                JOptionPane.showMessageDialog(null,"Los datos se cargaron correctamente","Carga Finalizada",JOptionPane.INFORMATION_MESSAGE);
        this.limpiar();
        this.llenarTabla(new Tasa());
        this.jTCodigo.setText("");
        this.jTDenominacion1.setText("");
        this.jTIndice.setText("");
        this.jTObservaciones.setText("");
        this.jTTasaMinima.setText("");
    }
    
    private void limpiar()
    {
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        while(this.jTable1.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }
    
    private void borrarRegistro(int fila)
    {
        Iterator it = tasas.iterator();
        while(it.hasNext())
        {
            Tasa t = (Tasa)it.next();
            if(t.getIdtasa() == Integer.parseInt(String.valueOf(this.jTable1.getValueAt(fila,0))))
            {
                Baja baja = new Baja();
                int respuesta = baja.eliminar(t);
                baja = null;
                if(respuesta == 0)
                    JOptionPane.showMessageDialog(null,"Error al dar de baja la tasa","Error",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"La tasa se elimino correctamente","Baja Completada",JOptionPane.INFORMATION_MESSAGE);
            }
            t = null;
        }
        it = null;
        this.limpiar();
        this.limpiarCampos();
        this.llenarTabla(new Tasa());
    }
    
    private void filtrar(String cadena)
    {
        // de alguna forma mando la cadena para que otro objeto me devuelva una nueva coleccion con los barrios filtrados
        //barrios = algo(cadena);
        // solo queda limpiar la tabla y volverla a cargar
        this.limpiar();
        Tasa t = new Tasa();
        t.setDenominacion(cadena);
        this.llenarTabla(t);
    }
     private void limpiarCampos(){
        this.jTCodigo.setText("");
        this.jTDenominacion1.setText("");
        this.jTIndice.setText("");
        this.jTTasaMinima.setText("");
        this.jTObservaciones.setText("");
     }
}


