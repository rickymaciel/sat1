/*
 * UIGenerarPadron.java
 *
 * Created on 6 de marzo de 2008, 16:04
 */

package vista;

import Datos.Consulta;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import negocios.Departamento;
import negocios.Localidad;
import negocios.Provincia;
import negocios.Titulo;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UIGenerarPadron extends javax.swing.JFrame {
    
    private Collection departamentos = new ArrayList();
    private Collection localidades = new ArrayList();
    private Collection titulos = new ArrayList();
    private Collection especialidades = new ArrayList();
    
    /** Creates new form UIGenerarPadron */
    public UIGenerarPadron() {
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        this.inicializarFormulario();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoEstado = new javax.swing.ButtonGroup();
        grupoZonaPadron = new javax.swing.ButtonGroup();
        grupoTipoMatriculado = new javax.swing.ButtonGroup();
        grupoTipoDomicilio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRTodos = new javax.swing.JRadioButton();
        jRNoHabilitados = new javax.swing.JRadioButton();
        jRHabilitados = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jCDepartamento = new javax.swing.JComboBox();
        jRDepartamento = new javax.swing.JRadioButton();
        jRLocalidad = new javax.swing.JRadioButton();
        jRProvincia = new javax.swing.JRadioButton();
        jCLocalidad = new javax.swing.JComboBox();
        jRDomParticular = new javax.swing.JRadioButton();
        jRDomProfesional = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCTitulo = new javax.swing.JComboBox();
        jRTitulo = new javax.swing.JRadioButton();
        jREspecialidad = new javax.swing.JRadioButton();
        jRTodosTitulos = new javax.swing.JRadioButton();
        jCEspecialidad = new javax.swing.JComboBox();
        jBImprimir = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar Padr�n de Matriculados");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elegir Matriculados que esten:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 10));

        grupoEstado.add(jRTodos);
        jRTodos.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRTodos.setSelected(true);
        jRTodos.setText("Todos");

        grupoEstado.add(jRNoHabilitados);
        jRNoHabilitados.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRNoHabilitados.setText("No Habilitados");

        grupoEstado.add(jRHabilitados);
        jRHabilitados.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRHabilitados.setText("Habilitados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRTodos)
                    .addComponent(jRNoHabilitados)
                    .addComponent(jRHabilitados))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jRHabilitados)
                .addGap(4, 4, 4)
                .addComponent(jRNoHabilitados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRTodos)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elegir zona del padron:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 10));

        jCDepartamento.setFont(new java.awt.Font("Tahoma", 0, 10));
        jCDepartamento.setEnabled(false);

        grupoZonaPadron.add(jRDepartamento);
        jRDepartamento.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRDepartamento.setText("Departamento:");
        jRDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRDepartamentoMouseClicked(evt);
            }
        });
        jRDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRDepartamentoActionPerformed(evt);
            }
        });

        grupoZonaPadron.add(jRLocalidad);
        jRLocalidad.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRLocalidad.setText("Localidad:");
        jRLocalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRLocalidadMouseClicked(evt);
            }
        });
        jRLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRLocalidadActionPerformed(evt);
            }
        });

        grupoZonaPadron.add(jRProvincia);
        jRProvincia.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRProvincia.setSelected(true);
        jRProvincia.setText("Todos las zonas");
        jRProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRProvinciaMouseClicked(evt);
            }
        });
        jRProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRProvinciaActionPerformed(evt);
            }
        });

        jCLocalidad.setFont(new java.awt.Font("Tahoma", 0, 10));
        jCLocalidad.setEnabled(false);

        grupoTipoDomicilio.add(jRDomParticular);
        jRDomParticular.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRDomParticular.setText("Particular");
        jRDomParticular.setEnabled(false);

        grupoTipoDomicilio.add(jRDomProfesional);
        jRDomProfesional.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRDomProfesional.setSelected(true);
        jRDomProfesional.setText("De Trabajo");
        jRDomProfesional.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel1.setText("Considerar Domicilio:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jRLocalidad)
                        .addGap(24, 24, 24)
                        .addComponent(jCLocalidad, 0, 228, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jRDepartamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCDepartamento, 0, 228, Short.MAX_VALUE))
                    .addComponent(jRProvincia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jRDomParticular)
                        .addGap(35, 35, 35)
                        .addComponent(jRDomProfesional)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRLocalidad)
                    .addComponent(jCLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRProvincia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRDomParticular)
                        .addComponent(jRDomProfesional))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elija tipo de Matriculado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 10));

        jCTitulo.setFont(new java.awt.Font("Tahoma", 0, 10));
        jCTitulo.setEnabled(false);

        grupoTipoMatriculado.add(jRTitulo);
        jRTitulo.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRTitulo.setText("Titulo:");
        jRTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRTituloActionPerformed(evt);
            }
        });

        grupoTipoMatriculado.add(jREspecialidad);
        jREspecialidad.setFont(new java.awt.Font("Tahoma", 0, 10));
        jREspecialidad.setText("Especialidad:");
        jREspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jREspecialidadActionPerformed(evt);
            }
        });

        grupoTipoMatriculado.add(jRTodosTitulos);
        jRTodosTitulos.setFont(new java.awt.Font("Tahoma", 0, 10));
        jRTodosTitulos.setSelected(true);
        jRTodosTitulos.setText("Todos titulos o especialidades");
        jRTodosTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRTodosTitulosActionPerformed(evt);
            }
        });

        jCEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 10));
        jCEspecialidad.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRTodosTitulos)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRTitulo)
                            .addComponent(jREspecialidad))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCTitulo, 0, 230, Short.MAX_VALUE)
                            .addComponent(jCEspecialidad, javax.swing.GroupLayout.Alignment.LEADING, 0, 230, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRTitulo)
                    .addComponent(jCTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jREspecialidad)
                    .addComponent(jCEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRTodosTitulos))
        );

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

        jBSalir.setText("Salir");
        jBSalir.setToolTipText("Cierra la ventana  actual y vuelve al menu principal.");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        jBSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBSalirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jBImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBImprimir, jBSalir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBImprimirMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jBImprimirMouseClicked

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
       
        this.establecerTipoDePadron();
        
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBImprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBImprimirKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyCode()==10){
//            cExport_thread report = new cExport_thread(3);
//            report.start();
        }
    }//GEN-LAST:event_jBImprimirKeyPressed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSalirKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
    }//GEN-LAST:event_jBSalirKeyPressed

    private void jRProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRProvinciaActionPerformed
        // TODO add your handling code here:
        this.jCDepartamento.setEnabled(false);
        this.jCLocalidad.setEnabled(false);        
        this.jRDomParticular.setEnabled(false);
        this.jRDomProfesional.setEnabled(false);
        
    }//GEN-LAST:event_jRProvinciaActionPerformed

    private void jRLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRLocalidadActionPerformed
        // TODO add your handling code here:
        this.jCDepartamento.setEnabled(false);
        this.jCLocalidad.setEnabled(true);        
        this.jRDomParticular.setEnabled(true);
        this.jRDomProfesional.setEnabled(true);
    }//GEN-LAST:event_jRLocalidadActionPerformed

    private void jRLocalidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRLocalidadMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRLocalidadMouseClicked

    private void jRDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRDepartamentoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRDepartamentoMouseClicked

    private void jRProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRProvinciaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRProvinciaMouseClicked

    private void jRDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRDepartamentoActionPerformed
        // TODO add your handling code here:
        this.jCDepartamento.setEnabled(true);
        this.jCLocalidad.setEnabled(false);        
        this.jRDomParticular.setEnabled(true);
        this.jRDomProfesional.setEnabled(true);
    }//GEN-LAST:event_jRDepartamentoActionPerformed

    private void jRTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRTituloActionPerformed
        // TODO add your handling code here:
        this.jCTitulo.setEnabled(true);
        this.jCEspecialidad.setEnabled(false);        
    }//GEN-LAST:event_jRTituloActionPerformed

    private void jREspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jREspecialidadActionPerformed
        // TODO add your handling code here:
        this.jCTitulo.setEnabled(false);
        this.jCEspecialidad.setEnabled(true);
    }//GEN-LAST:event_jREspecialidadActionPerformed

    private void jRTodosTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRTodosTitulosActionPerformed
        // TODO add your handling code here:
        this.jCTitulo.setEnabled(false);
        this.jCEspecialidad.setEnabled(false);
    }//GEN-LAST:event_jRTodosTitulosActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIGenerarPadron().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoEstado;
    private javax.swing.ButtonGroup grupoTipoDomicilio;
    private javax.swing.ButtonGroup grupoTipoMatriculado;
    private javax.swing.ButtonGroup grupoZonaPadron;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox jCDepartamento;
    private javax.swing.JComboBox jCEspecialidad;
    private javax.swing.JComboBox jCLocalidad;
    private javax.swing.JComboBox jCTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRDepartamento;
    private javax.swing.JRadioButton jRDomParticular;
    private javax.swing.JRadioButton jRDomProfesional;
    private javax.swing.JRadioButton jREspecialidad;
    private javax.swing.JRadioButton jRHabilitados;
    private javax.swing.JRadioButton jRLocalidad;
    private javax.swing.JRadioButton jRNoHabilitados;
    private javax.swing.JRadioButton jRProvincia;
    private javax.swing.JRadioButton jRTitulo;
    private javax.swing.JRadioButton jRTodos;
    private javax.swing.JRadioButton jRTodosTitulos;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
 
    private void inicializarFormulario(){        
        this.llenarDepartamentos("JUJUY");    
        this.llenarLocalidades();
        this.llenarTitulos();
        this.llenarEspecialidades();
        
    }
    
    private void llenarDepartamentos(String nombreProvincia){
        //Obtengo el id de provincia en elobjeto completo
//        this.vaciarDepartamentos();
        Consulta con=new Consulta();
        Provincia prov=con.getIdProvincia(nombreProvincia);
        
        //Hago ellistado de departamentos por provincia
        Consulta con2=new Consulta();
        departamentos = con2.getDepartamentoxProv(prov.getIdprovincia());
        Iterator it = departamentos.iterator();
        Departamento d = new Departamento();
        Boolean seCargoDepto=false;
        
        while(it.hasNext()){
            d = (Departamento)it.next();
            if (d.getProvincia().getNombre().trim().equals("JUJUY")){
               this.jCDepartamento.addItem(d.getNombre().trim());
               seCargoDepto=true;
            }
        }
        if (!seCargoDepto){
              JOptionPane.showMessageDialog(null,"No se cargaron los DEPTOS. por que\n no hay departamentos cargados en la provincia de JUJUY","Atenci�n",JOptionPane.INFORMATION_MESSAGE);
        }
        d = null;
        it = null;
   }
    private void llenarLocalidades(){    
        Consulta con2=new Consulta();
        localidades = con2.getLocalidad();
        Iterator it = localidades.iterator();
        Localidad l = new Localidad();
        Boolean seCargoLocalidad=false;
        
        while(it.hasNext()){
            l = (Localidad)it.next();
            if (l.getDepartamento().getProvincia().getNombre().trim().equals("JUJUY")){
                this.jCLocalidad.addItem(l.getNombre().trim());
                seCargoLocalidad=true;
            }            
        }        
        if (!seCargoLocalidad){
              JOptionPane.showMessageDialog(null,"No se cargaron LOCALIDADES. por que\n no hay localidades cargados en la provincia de JUJUY","Atenci�n",JOptionPane.INFORMATION_MESSAGE);
        }
        l = null;
        it = null;
    }
    private void llenarTitulos(){    
        Consulta con=new Consulta();
        titulos = con.getTitulo();
        Iterator it = titulos.iterator();
        Titulo t = new Titulo();
        while(it.hasNext())
        {
            t = (Titulo)it.next();
            this.jCTitulo.addItem(t.getNombre().trim());
        }
        t = null;
        it = null;
    }
    private void llenarEspecialidades(){
        Consulta con=new Consulta();
        this.especialidades = con.getEspecialidades();
        Iterator it = especialidades.iterator();
        String especialidad = "";
        while(it.hasNext())
        {
            especialidad = (String)it.next();
            this.jCEspecialidad.addItem(especialidad.trim());
        }
        especialidad = null;
        it = null;    
    }
    public void establecerTipoDePadron(){
       //domicilio particular
       String d1="%";
       String l1="%";
       //domicilio profesional
       String d2="%"; 
       String l2="%";
       //Habilitados
       String estadoHabilitado="%";
       
       if (this.jRDomParticular.isSelected()){
            if (this.jRDepartamento.isSelected()){
                d1=this.jCDepartamento.getSelectedItem().toString().trim()+"%";
            }
            if (this.jRLocalidad.isSelected()){
                l1=this.jCLocalidad.getSelectedItem().toString().trim()+"%";
            }            
       } 
       if (this.jRDomProfesional.isSelected()){
            if (this.jRDepartamento.isSelected()){
                d2=this.jCDepartamento.getSelectedItem().toString().trim()+"%";
            }
            if (this.jRLocalidad.isSelected()){
                l2=this.jCLocalidad.getSelectedItem().toString().trim()+"%";
            }            
       } 
       if (this.jRHabilitados.isSelected()){
            estadoHabilitado="S%";       
       }
       if (this.jRNoHabilitados.isSelected()){
            estadoHabilitado="N%";       
       }
       //SI ESTA SELECCIONADO TODOS LOS TITULOS O ESPECIALIDADES
       if (this.jRTodosTitulos.isSelected()){
            cExport_thread report = new cExport_thread(37,estadoHabilitado,d1,l1,d2,l2);
            report.start();    
       }
       //SI ESTA SELECCIONADO TITULOS
       if (this.jRTitulo.isSelected()){
            String titulo=this.jCTitulo.getSelectedItem().toString().trim();            
            cExport_thread report = new cExport_thread(371,estadoHabilitado,d1,l1,d2,l2,titulo);
            report.start();    
       }
       //SI ESTA SELECCIONADO TODOS LOS TITULOS O ESPECIALIDADES
       if (this.jREspecialidad.isSelected()){
            String especialidad=this.jCEspecialidad.getSelectedItem().toString().trim();            
            cExport_thread report = new cExport_thread(372,estadoHabilitado,d1,l1,d2,l2,especialidad);
            report.start();    
       }
    }
    
}
