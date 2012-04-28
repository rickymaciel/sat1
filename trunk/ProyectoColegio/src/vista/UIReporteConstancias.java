/*
 * UIReporteConstancias.java
 *
 * Created on 14 de marzo de 2008, 13:41
 */

package vista;

import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.Matriculado;
import negocios.Tasa;
import negocios.Titulo;

/**
 *
 * @author  Administrador
 */
public class UIReporteConstancias extends javax.swing.JFrame 
{
    private Collection encabezadosParciales = new ArrayList();
    private Collection encabezadosTotales = new ArrayList();
//    private Collection detallesParciales = new ArrayList();
//    private Collection detallesTotales = new ArrayList();
    private Collection tasasCT = new ArrayList();
//    private Collection tasasCP = new ArrayList();
    
    
    /** Creates new form UIReporteConstancias */
    public UIReporteConstancias() {
        initComponents();
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        this.inicializarFormulario();
    }
    
    public UIReporteConstancias(String matricula) 
    {
        initComponents();
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();
        this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        this.inicializarFormulario();
        this.jTMatricula.setText(matricula.trim());
        this.buscarMatriculado();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jCTipoConstancia = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCDiaInicio = new javax.swing.JComboBox();
        jCMesInicio = new javax.swing.JComboBox();
        jCAnioInicio = new javax.swing.JComboBox();
        jCDiaFinal = new javax.swing.JComboBox();
        jCMesFinal = new javax.swing.JComboBox();
        jCAnioFinal = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTMatriculado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCHKTodosLasFechas = new javax.swing.JCheckBox();
        jBBuscar = new javax.swing.JButton();
        jTMatricula = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jBSalir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de Constancias");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Constancias"));

        jCTipoConstancia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PARCIAL", "TOTAL" }));

        jLabel1.setText("Ver Constancias");

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCDiaInicio.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCDiaInicio.setEnabled(false);
        jCDiaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCDiaInicioKeyPressed(evt);
            }
        });

        jCMesInicio.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCMesInicio.setEnabled(false);
        jCMesInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCMesInicioKeyPressed(evt);
            }
        });

        jCAnioInicio.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCAnioInicio.setEnabled(false);
        jCAnioInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCAnioInicioFocusLost(evt);
            }
        });
        jCAnioInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCAnioInicioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCAnioInicioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCAnioInicioKeyTyped(evt);
            }
        });

        jCDiaFinal.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCDiaFinal.setEnabled(false);
        jCDiaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCDiaFinalKeyPressed(evt);
            }
        });

        jCMesFinal.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCMesFinal.setEnabled(false);
        jCMesFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCMesFinalKeyPressed(evt);
            }
        });

        jCAnioFinal.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCAnioFinal.setEnabled(false);
        jCAnioFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCAnioFinalFocusLost(evt);
            }
        });
        jCAnioFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCAnioFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCAnioFinalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCAnioFinalKeyTyped(evt);
            }
        });

        jLabel2.setText("Fecha Inicio:");

        jLabel3.setText("Fecha Final:");

        jTMatriculado.setEnabled(false);

        jLabel4.setText("Matriculado:");

        jCHKTodosLasFechas.setSelected(true);
        jCHKTodosLasFechas.setText("Todo el historial");
        jCHKTodosLasFechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCHKTodosLasFechasMouseClicked(evt);
            }
        });

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/binoculars.gif"))); // NOI18N
        jBBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBBuscarMouseClicked(evt);
            }
        });
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jTMatricula.setToolTipText("Introduzca una matricula existente.");
        jTMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTMatriculaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTMatriculado, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBuscar)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jCTipoConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCAnioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCAnioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jCHKTodosLasFechas)
                        .addGap(44, 44, 44))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addComponent(jBBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCAnioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCAnioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCHKTodosLasFechas)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCTipoConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(25, 25, 25))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jButton2.setText("Ver");

        jButton4.setText("Imprimir Resumen");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Tasas", "Calle / Nro", "Localidad", "Orden Trabajo", "Factura", "Monto Factura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCDiaInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCDiaInicioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCMesInicio.requestFocus();
}//GEN-LAST:event_jCDiaInicioKeyPressed

    private void jCMesInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCMesInicioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCAnioInicio.requestFocus();
}//GEN-LAST:event_jCMesInicioKeyPressed

    private void jCAnioInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCAnioInicioFocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_jCAnioInicioFocusLost

    private void jCAnioInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioInicioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
       
}//GEN-LAST:event_jCAnioInicioKeyPressed

    private void jCAnioInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioInicioKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_jCAnioInicioKeyReleased

    private void jCAnioInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioInicioKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_jCAnioInicioKeyTyped

    private void jCDiaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCDiaFinalKeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_jCDiaFinalKeyPressed

    private void jCMesFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCMesFinalKeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_jCMesFinalKeyPressed

    private void jCAnioFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCAnioFinalFocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_jCAnioFinalFocusLost

    private void jCAnioFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioFinalKeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_jCAnioFinalKeyPressed

    private void jCAnioFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioFinalKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_jCAnioFinalKeyReleased

    private void jCAnioFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioFinalKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_jCAnioFinalKeyTyped

    private void jBBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBBuscarMouseClicked

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        this.buscarMatriculado();
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMatriculaKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        boolean numeroCorrecto=true;
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE)))) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 12","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTMatricula.setText("");
            this.jTMatricula.requestFocus();
            numeroCorrecto=false;
            evt.consume();
        }
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10 && numeroCorrecto)
            this.buscarMatriculado();
}//GEN-LAST:event_jTMatriculaKeyPressed

    private void jCHKTodosLasFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCHKTodosLasFechasMouseClicked
        // TODO add your handling code here:
        if (this.jCHKTodosLasFechas.isSelected()){
            this.jCDiaInicio.setEnabled(false);
            this.jCDiaFinal.setEnabled(false);
            this.jCMesInicio.setEnabled(false);
            this.jCMesFinal.setEnabled(false);
            this.jCAnioInicio.setEnabled(false);
            this.jCAnioFinal.setEnabled(false);
        }else{
            this.jCDiaInicio.setEnabled(true);
            this.jCDiaFinal.setEnabled(true);
            this.jCMesInicio.setEnabled(true);
            this.jCMesFinal.setEnabled(true);
            this.jCAnioInicio.setEnabled(true);
            this.jCAnioFinal.setEnabled(true);
        }
        
        
}//GEN-LAST:event_jCHKTodosLasFechasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String fecha1 = "0";
        String fecha2 = "0";
        if(!this.jCHKTodosLasFechas.isSelected())
        {
            fecha1 = String.valueOf(this.jCAnioInicio.getSelectedItem())+"-"+String.valueOf(this.jCMesInicio.getSelectedItem())+"-"+String.valueOf(this.jCDiaInicio.getSelectedItem());
            fecha2 = String.valueOf(this.jCAnioFinal.getSelectedItem())+"-"+String.valueOf(this.jCMesFinal.getSelectedItem())+"-"+String.valueOf(this.jCDiaFinal.getSelectedItem());
            //Date fe = new Date(String.valueOf(anio)+"/"+String.valueOf(mes)+"/"+String.valueOf(dia));
            //fe = fe.getTime()
            
        }
        if(this.jTMatriculado.getText().trim().length() != 0)
        {
            this.limpiarTabla();
            this.listarParciales(fecha1,fecha2);
        }
            
        else
            JOptionPane.showMessageDialog(null, "Debe introducir el numero de matricula de un matriculado", "Falta Matriculado",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIReporteConstancias().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jCAnioFinal;
    private javax.swing.JComboBox jCAnioInicio;
    private javax.swing.JComboBox jCDiaFinal;
    private javax.swing.JComboBox jCDiaInicio;
    private javax.swing.JCheckBox jCHKTodosLasFechas;
    private javax.swing.JComboBox jCMesFinal;
    private javax.swing.JComboBox jCMesInicio;
    private javax.swing.JComboBox jCTipoConstancia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTMatricula;
    private javax.swing.JTextField jTMatriculado;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
private void buscarMatriculado(){
    if (this.jTMatricula.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Agregue un numero en Matricula Solicitante para buscarla","No se puede Buscar", JOptionPane.WARNING_MESSAGE);
        } else {

            Matriculado m=new Matriculado(); 
            m.setMatricula(Integer.parseInt(this.jTMatricula.getText().trim()));

            CListar listamat=new CListar();
            Matriculado ma=listamat.soloMatriculado(m);        
            String nombreMatriculado="";
            
            if (ma.getMatricula()!=0){
                Titulo tit=ma.getTitulo();
                nombreMatriculado=String.valueOf(ma.getMatricula());
                
                if (tit.getAbreviacion()!=null){
                    nombreMatriculado=nombreMatriculado + "-"+tit.getAbreviacion().trim();
                }                
                if(ma.getApellido()!=null){                    
                    nombreMatriculado=nombreMatriculado+" - "+ma.getApellido().trim();
                }                  
                if(ma.getNombres()!=null){                    
                    nombreMatriculado=nombreMatriculado+", "+ma.getNombres().trim();
                }
                this.jTMatriculado.setText(nombreMatriculado);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un numero de matricula existente","Matricula Inexistente", JOptionPane.WARNING_MESSAGE);
            }
        } 
}


    
private void inicializarFormulario()
{
    this.cargarCombosFecha();
    this.ajustarTamanioColumna();
}

private void ajustarTamanioColumna()
{
    TableColumn column = null;
    for (int i = 0; i < 5; i++) {
    column = jTable1.getColumnModel().getColumn(i);
    switch(i)
    {
        case 0:
                column.setPreferredWidth(50);
                break;
        case 1:
                column.setPreferredWidth(110);
                break;
        case 2:
                column.setPreferredWidth(300); 
                break;
        case 3:
                column.setPreferredWidth(300); 
                break;
        case 4:
                column.setPreferredWidth(110); 
                break;
        case 5:
                column.setPreferredWidth(100);
                break;
        case 6:
                column.setPreferredWidth(120); 
                break;
        case 7:
                column.setPreferredWidth(100); 
                break;
    }
}
}
        
private void cargarCombosFecha()
    {
        for(int i = 1;i<=31;i++)
        {
            this.jCDiaFinal.addItem(String.valueOf(i));
            this.jCDiaInicio.addItem(String.valueOf(i));
        }
        for(int i = 1;i<=12;i++)
        {
            this.jCMesFinal.addItem(String.valueOf(i));
            this.jCMesInicio.addItem(String.valueOf(i));
        }
        GregorianCalendar fec = new GregorianCalendar();
        int anio = fec.get(Calendar.YEAR);
        for(int i=1930;i<=anio;i++)
        {
            this.jCAnioFinal.addItem(String.valueOf(i));
            this.jCAnioInicio.addItem(String.valueOf(i));
        }
        this.jCAnioFinal.setSelectedItem(anio);
        this.jCAnioInicio.setSelectedItem(anio);
    }
    
private void listarParciales(String fecha1, String fecha2)
{
    CListar listar = new CListar();
    if(String.valueOf(this.jCTipoConstancia.getSelectedItem()).equals("PARCIAL"))
    {
        this.encabezadosParciales.clear();
        EncabezadoCP encCP = new EncabezadoCP();
        Matriculado mat = new Matriculado();
        mat.setMatricula(Integer.parseInt(this.jTMatricula.getText().trim()));
        encCP.setMatriculado(mat);
        this.encabezadosParciales = listar.hacerListadoEncabezadoCP(encCP, 0, fecha1, fecha2);
        if(this.encabezadosParciales.size() == 0)
            JOptionPane.showMessageDialog(null, "El matriculado no tiene constancias parciales", "No tiene trabajos", JOptionPane.INFORMATION_MESSAGE);
        else
            this.agregarFilaCP();
    }
    else
    {
        this.encabezadosTotales.clear();
        this.tasasCT.clear();
        EncabezadoCT encCT = new EncabezadoCT();
        Matriculado mat = new Matriculado();
        mat.setMatricula(Integer.parseInt(this.jTMatricula.getText().trim()));
        encCT.setMatriculado(mat);
        this.encabezadosTotales = listar.hacerListadoEncabezadoCT(encCT, 0, fecha1, fecha2);
        if(this.encabezadosTotales.size() == 0)
            JOptionPane.showMessageDialog(null, "El matriculado no tiene constancias totales", "No tiene trabajos", JOptionPane.INFORMATION_MESSAGE);
        else
        this.agregarFilaCT();
    }
}

private void agregarFilaCT()
{
    Iterator it = this.encabezadosTotales.iterator();
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    DefaultTableModel  modelo= (DefaultTableModel)this.jTable1.getModel();
    String datos[] = new String[8];
    while(it.hasNext())
    {
        EncabezadoCT e = (EncabezadoCT)it.next();
        datos[0] = String.valueOf(e.getCodigoCT()).trim();
        
        DateFormat df = DateFormat.getDateInstance();
        datos[1] = String.valueOf(df.format(e.getFecha()));
        
        //datos[1] = e.getFecha().toString();
        
        
        datos[2] = this.getTasasCT(e);
        datos[3] = e.getCalle().trim();
        datos[4] = e.getLocalidad().getNombre().trim();
        datos[5] = e.getOrdenTrabajo().trim();
        datos[6] = String.valueOf(e.getSerieFactura()).concat("-").concat(String.valueOf(e.getNumeroFactura())).trim();
        datos[7] = nf.format(e.getTotal());
        modelo.addRow(datos);
        e = null;
    }
    modelo = null;
}

private void agregarFilaCP()
{
    Iterator it = this.encabezadosParciales.iterator();
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    DefaultTableModel  modelo= (DefaultTableModel)this.jTable1.getModel();
    String datos[] = new String[8];
    while(it.hasNext())
    {
        EncabezadoCP e = (EncabezadoCP)it.next();
        datos[0] = String.valueOf(e.getCodigoCP()).trim();
        
        
        DateFormat df = DateFormat.getDateInstance();
        datos[1] = String.valueOf(df.format(e.getFecha()));
        //datos[1] = String.valueOf(e.getFecha()).trim();
        datos[2] = this.getTasasCP(e);
        datos[3] = e.getCalle().trim();
        datos[4] = e.getLocalidad().getNombre().trim();
        datos[5] = e.getOrdenTrabajo().trim();
        datos[6] = String.valueOf(e.getSerieFactura()).concat("-").concat(String.valueOf(e.getNumeroFactura())).trim();
        datos[7] = nf.format(e.getTotal());
        modelo.addRow(datos);
        e = null;
    }
    modelo = null;
}


private void limpiarTabla()
{
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        while(this.jTable1.getRowCount() != 0)
            modelo.removeRow(0);
        modelo = null;
}

private String getTasasCP(EncabezadoCP encCP)
{
    StringBuffer cadena = new StringBuffer();
    boolean bandera = true;
    Collection tasas = new ArrayList();
    CListar listar = new CListar();
    tasas = listar.armarDetalleFactura(encCP.getSerieCP(), String.valueOf(encCP.getCodigoCP()), "CP");
    Iterator it = tasas.iterator();
    while(it.hasNext())
    {
        Tasa t = (Tasa)it.next();
        if(!bandera)
            cadena.append("-");
        else
            bandera = false;
        cadena.append(t.getDenominacion().trim());
        t = null;
    }
    it = null;
    tasas = null;
    listar = null;
    return cadena.toString();
}

private String getTasasCT(EncabezadoCT encCT)
{
    CListar listar = new CListar();
    boolean bandera = true;
    StringBuffer cadena = new StringBuffer();
    Collection tasas = new ArrayList();
    tasas = listar.armarDetalleFactura(encCT.getSerieCT(), String.valueOf(encCT.getCodigoCT()), "CT");
    Iterator it = tasas.iterator();
    while(it.hasNext())
    {
        Tasa t = (Tasa)it.next();
        if(!bandera)
            cadena.append("-");
        else
            bandera = false;
        cadena.append(t.getDenominacion().trim());
        t = null;
    }
    it = null;
    tasas = null;
    listar = null;
    return cadena.toString();
}


    
}
