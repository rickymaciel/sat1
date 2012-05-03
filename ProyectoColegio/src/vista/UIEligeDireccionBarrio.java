/*
 * UIEligeDireccion.java
 *
 * Created on 8 de febrero de 2008, 17:34
 */

package vista;

import Datos.Consulta;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import negocios.Barrio;
import negocios.Departamento;
import negocios.Localidad;
import negocios.Provincia;

/**
 *
 * @author  Administrador
 */
public class UIEligeDireccionBarrio extends javax.swing.JFrame {
    private Collection provincias = new ArrayList();
    private Collection allProvincias = new ArrayList();
    private Collection departamentos = new ArrayList();
    private Collection allDepartamentos = new ArrayList();
    private Collection localidades = new ArrayList();
    private Collection allLocalidades = new ArrayList();
    private Collection barrios = new ArrayList();
    private Collection allBarrios = new ArrayList();
    
    private String origen = "";
    private String provinciaOrigen="";// definira nua interfase restringida a la
                                //seleccion de departamentos,loc,barrios de una unica provincia
//    private UIEscuelas escuelas = new UIEscuelas();
//    private UIDatosEmpresa empresa = new UIDatosEmpresa();
//    private UIMatriculados matriculados = new UIMatriculados();
//    private UINuevaCT ct=new UINuevaCT();
//    private UINuevaCP cp=new UINuevaCP();
    
    private UIEscuelas escuelas;//
    private UIDatosEmpresa empresa;
    private UIMatriculados matriculados;
    private UINuevaCT ct;
    private UINuevaCP cp;
    
    
    private Provincia vProvincia = new Provincia();
    private Departamento vDepartamento = new Departamento();
    private Localidad vLocalidad = new Localidad();
    private Barrio vBarrio = new Barrio();
    
    
    /** Creates new form UIEligeDireccion */
    public UIEligeDireccionBarrio() {
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
//        this.llenarProvincias();
        this.inicio();
    }
    public UIEligeDireccionBarrio(UIEscuelas escuelas) 
    {
        
        this.escuelas = escuelas;
        this.origen = "ESCUELAS";
        
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
//        this.llenarProvincias();
        this.inicio();
    }
    public UIEligeDireccionBarrio(UIMatriculados matriculados) {
        this.matriculados = matriculados;
        this.origen = "MATRICULADOS";
        
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
//        this.llenarProvincias();
        this.inicio();
    }
     public UIEligeDireccionBarrio(UIMatriculados matriculados,String prov) {
        this.matriculados = matriculados;
        this.provinciaOrigen=prov;
        this.origen = "MATRICULADOS";
        
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
//        this.llenarProvincias();
        this.inicio();
    }
     public UIEligeDireccionBarrio(UIDatosEmpresa emp) {
        this.empresa = emp;
        this.origen = "EMPRESA";
        
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
//        this.llenarProvincias();
        this.inicio();
    }
    public UIEligeDireccionBarrio(UINuevaCT encabezadoct,String prov) {
        this.ct = encabezadoct;
        this.provinciaOrigen=prov;
        this.origen = "CT";
        
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
//        this.llenarProvincias();
        this.inicio();
    }
    public UIEligeDireccionBarrio(UINuevaCP encabezadocp,String prov) {
        this.cp = encabezadocp;
        this.provinciaOrigen=prov;
        this.origen = "CP";
        
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
//        this.llenarProvincias();
        this.inicio();
    } 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jCProvincia = new javax.swing.JComboBox();
        jCDepartamento = new javax.swing.JComboBox();
        jCLocalidad = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCBarrio = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jBAbreProvincias = new javax.swing.JButton();
        jBAbreDepartamentos = new javax.swing.JButton();
        jBAbreLocalidades = new javax.swing.JButton();
        jBAbreBarrios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Elija una Ubicacion:"));

        jCProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCProvinciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCProvinciaMouseEntered(evt);
            }
        });
        jCProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCProvinciaItemStateChanged(evt);
            }
        });
        jCProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCProvinciaActionPerformed(evt);
            }
        });

        jCDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCDepartamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCDepartamentoMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCDepartamentoMouseReleased(evt);
            }
        });
        jCDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCDepartamentoItemStateChanged(evt);
            }
        });
        jCDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCDepartamentoActionPerformed(evt);
            }
        });

        jCLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCLocalidadItemStateChanged(evt);
            }
        });
        jCLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCLocalidadActionPerformed(evt);
            }
        });

        jLabel1.setText("Provincia:");

        jLabel2.setText("Departamento:");

        jLabel3.setText("Localidad:");

        jCBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBarrioActionPerformed(evt);
            }
        });

        jLabel4.setText("Barrio:");

        jBAbreProvincias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.gif"))); // NOI18N
        jBAbreProvincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbreProvinciasActionPerformed(evt);
            }
        });

        jBAbreDepartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.gif"))); // NOI18N
        jBAbreDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbreDepartamentosActionPerformed(evt);
            }
        });

        jBAbreLocalidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.gif"))); // NOI18N
        jBAbreLocalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbreLocalidadesActionPerformed(evt);
            }
        });

        jBAbreBarrios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.gif"))); // NOI18N
        jBAbreBarrios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbreBarriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCDepartamento, 0, 244, Short.MAX_VALUE)
                    .addComponent(jCProvincia, 0, 244, Short.MAX_VALUE)
                    .addComponent(jCLocalidad, 0, 244, Short.MAX_VALUE)
                    .addComponent(jCBarrio, 0, 244, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBAbreLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAbreProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBAbreBarrios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAbreDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAbreProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAbreDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBAbreLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBAbreBarrios, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(109, 109, 109))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCProvinciaItemStateChanged
        // TODO add your handling code here:
      
}//GEN-LAST:event_jCProvinciaItemStateChanged

    private void jCProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCProvinciaActionPerformed
//        this.llenarDepartamentos(this.jCProvincia.getSelectedItem().toString().trim());
        this.vProvincia = this.getProvincia(String.valueOf(this.jCProvincia.getSelectedItem()));
        this.llenarDepartamentos(this.vProvincia);
}//GEN-LAST:event_jCProvinciaActionPerformed

    private void jCLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCLocalidadActionPerformed
        // TODO add your handling code here:   
//        if (this.jCLocalidad.getItemCount()>0){
//            this.llenarBarrios(this.jCLocalidad.getSelectedItem().toString().trim());
//        }
        this.vLocalidad = this.getLocalidad(String.valueOf(this.jCLocalidad.getSelectedItem()));
        this.llenarBarrios();
    }//GEN-LAST:event_jCLocalidadActionPerformed

    private void jCDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDepartamentoActionPerformed
        // TODO add your handling code here:    
        
        if (this.jCDepartamento.getItemCount()>0){
//            this.llenarLocalidades(this.jCDepartamento.getSelectedItem().toString().trim());
            this.vDepartamento = this.getDepartamento(String.valueOf(this.jCDepartamento.getSelectedItem()));
            this.llenarLocalidades();
        }
    }//GEN-LAST:event_jCDepartamentoActionPerformed

    private void jCProvinciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCProvinciaMouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jCProvinciaMouseEntered

    private void jCProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCProvinciaMouseClicked
        // TODO add your handling code here:
          
    }//GEN-LAST:event_jCProvinciaMouseClicked

    private void jCDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCDepartamentoItemStateChanged
    }//GEN-LAST:event_jCDepartamentoItemStateChanged

    private void jCDepartamentoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCDepartamentoMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCDepartamentoMouseReleased

    private void jCDepartamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCDepartamentoMouseEntered
        // TODO add your handling code here:
    
        
    }//GEN-LAST:event_jCDepartamentoMouseEntered

    private void jCDepartamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCDepartamentoMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jCDepartamentoMouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.control())
        {
            if(this.origen.equals("MATRICULADOS"))
            {
                int res= JOptionPane.showConfirmDialog(this,"¿Esta seguro se insertar esta direccion?", "Advertencia...",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (res==JOptionPane.YES_OPTION)
                {
                    this.matriculados.cargarDatosDireccion(this.vBarrio);                    
                    this.dispose();
                }
            }
            if(this.origen.equals("EMPRESA"))
            {
                int res= JOptionPane.showConfirmDialog(this,"¿Esta seguro de insertar esta direccion?", "Advertencia...",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (res==JOptionPane.YES_OPTION)
                {
                    this.empresa.cargarDatosDireccion(this.vBarrio);
                    this.dispose();
                }
            }
            if(this.origen.equals("CP"))
            {
                int res= JOptionPane.showConfirmDialog(this,"¿Esta seguro de insertar esta direccion?", "Advertencia...",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (res==JOptionPane.YES_OPTION)
                {
                    this.cp.cargarDatosDireccion(this.vBarrio);
                    this.dispose();
                }
            }
            
            if(this.origen.equals("CT"))
            {
                int res= JOptionPane.showConfirmDialog(this,"¿Esta seguro de insertar esta direccion?", "Advertencia...",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (res==JOptionPane.YES_OPTION)
                {
                    this.ct.cargarDatosDireccion(this.vBarrio);
                    this.dispose();
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Debe elegir un barrio", "No selecciono el barrio", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBAbreProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbreProvinciasActionPerformed
        // TODO add your handling code here:
        UINuevaProvincia ventProvincia=new UINuevaProvincia();
        ventProvincia.setVisible(true);
        
}//GEN-LAST:event_jBAbreProvinciasActionPerformed

    private void jBAbreDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbreDepartamentosActionPerformed
        // TODO add your handling code here:
        UIDepartamento ventDepartamento=new UIDepartamento();
        ventDepartamento.setVisible(true);
}//GEN-LAST:event_jBAbreDepartamentosActionPerformed

    private void jBAbreLocalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbreLocalidadesActionPerformed
        // TODO add your handling code here:
        UILocalidades2 ventLocalidades=new UILocalidades2();
        ventLocalidades.setVisible(true);
}//GEN-LAST:event_jBAbreLocalidadesActionPerformed

    private void jBAbreBarriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbreBarriosActionPerformed
        // TODO add your handling code here:
        UIBarrio ventBarrios=new UIBarrio();
        ventBarrios.setVisible(true);
}//GEN-LAST:event_jBAbreBarriosActionPerformed

    private void jCLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCLocalidadItemStateChanged
        // TODO add your handling code here:
        if (this.jCLocalidad.getItemCount()>0){
//            this.llenarBarrios(this.jCLocalidad.getSelectedItem().toString().trim());
            this.llenarBarrios();
        }
    }//GEN-LAST:event_jCLocalidadItemStateChanged

    private void jCBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBarrioActionPerformed
        // TODO add your handling code here:
        this.getBarrio(String.valueOf(this.jCBarrio.getSelectedItem()));
    }//GEN-LAST:event_jCBarrioActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIEligeDireccion().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAbreBarrios;
    private javax.swing.JButton jBAbreDepartamentos;
    private javax.swing.JButton jBAbreLocalidades;
    private javax.swing.JButton jBAbreProvincias;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCBarrio;
    private javax.swing.JComboBox jCDepartamento;
    private javax.swing.JComboBox jCLocalidad;
    private javax.swing.JComboBox jCProvincia;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
    
    private void inicio()
    {
        CListar listar = new CListar();
        this.allDepartamentos = listar.hacerListado(new Departamento());
        this.allLocalidades = listar.hacerListado(new Localidad());
        this.allBarrios = listar.hacerListado(new Barrio());
        this.allProvincias = listar.hacerListado(new Provincia());
        this.llenarProvincias();
        listar = null;
    }
    private void llenarProvincias()
    {       
        int bandera = 0;
        Iterator it = this.allProvincias.iterator();
        Provincia p = new Provincia();
        if (this.provinciaOrigen.equals("JUJUY"))
        {
            while(it.hasNext()){
                p = (Provincia)it.next();
                if (p.getNombre().trim().equals(this.provinciaOrigen)){
                    this.jCProvincia.addItem(p.getNombre().trim());                
                    this.vProvincia = p;
                }
            }            
        } else {
            while(it.hasNext())
            {
                p = (Provincia)it.next();
                this.jCProvincia.addItem(p.getNombre().trim());
                if (bandera == 0)
                    this.vProvincia = p;
                bandera++;
            }   
        }
        p = null;
        it = null;        
        this.llenarDepartamentos(this.vProvincia);        
    }
    
    private Provincia getProvincia(String nombre)
    {
        Provincia p = new Provincia();
        Iterator it = this.allProvincias.iterator();
        while(it.hasNext())
        {
            Provincia pro = (Provincia)it.next();
            if(pro.getNombre().trim().equals(nombre.equals(nombre)))
            {
                p = pro;
                break;
            }
            pro = null;
        }
        it = null;
        return p;
    }
    
    private void llenarDepartamentos(Provincia prov)
    {
        //Obtengo el id de provincia en elobjeto completo
        this.vaciarDepartamentos();
        int bandera = 0;
        //Hago ellistado de departamentos por provincia
        departamentos = this.getDepartamentos(prov);
        Iterator it = departamentos.iterator();
        Departamento d = new Departamento();
        while(it.hasNext())
        {
            d = (Departamento)it.next();
            this.jCDepartamento.addItem(d.getNombre().trim());
            if(bandera == 0)
                this.vDepartamento = d;
            bandera++;
        }
        d = null;
        it = null;
        
        this.vaciarLocalidades();
    }
    
    private Collection getDepartamentos(Provincia prov)
    {
        Collection deptos = new ArrayList();
        Iterator it = this.allDepartamentos.iterator();
        while(it.hasNext())
        {
            Departamento d = (Departamento)it.next();
            if(d.getProvincia().getIdprovincia() == prov.getIdprovincia())
                deptos.add(d);
            d = null;
        }
        it = null;
        return deptos;
    }
    
    private Departamento getDepartamento(String nombre)
    {
        Departamento depto = new Departamento();
        Iterator it = this.departamentos.iterator();
        while(it.hasNext())
        {
            Departamento d = (Departamento)it.next();
            if(d.getNombre().trim().equals(nombre.trim()))
            {
                depto = d;
                break;
            }
            d = null;
        }
        it = null;
        return depto;
    }
    
    
    private void llenarLocalidades()
    {
        //Obtengo el id de provincia en elobjeto completo
        this.vaciarLocalidades();
//        Hago ellistado de departamentos por provincia
        this.getLocalidades();
        Iterator it = this.localidades.iterator();
        Localidad l = new Localidad();
        while(it.hasNext())
        {
            l = (Localidad)it.next();
            this.jCLocalidad.addItem(l.getNombre().trim());
        }
        l = null;
        it = null;
        this.vaciarBarrios();
    }
    
    private void getLocalidades()
    {
        int bandera = 0;
        Iterator it = this.allLocalidades.iterator();
        while(it.hasNext())
        {
            Localidad l = (Localidad)it.next();
            if(l.getDepartamento().getIddepartamento() == this.vDepartamento.getIddepartamento())
            {
                this.localidades.add(l);
                if(bandera == 0)
                    this.vLocalidad = l;
                bandera ++;
            }
            l = null;
        }
        it = null;
    }
    
    private Localidad getLocalidad(String nombre)
    {
        Localidad loc = new Localidad();
        Iterator it = this.localidades.iterator();
        while(it.hasNext())
        {
            Localidad l = (Localidad)it.next();
            if(l.getNombre().trim().equals(nombre.trim()))
            {
                loc = l;
                break;
            }
            l = null;
        }
        it = null;
        return loc;
    }
    
    private void llenarBarrios()
    {
        //Obtengo el id de provincia en elobjeto completo
        this.vaciarBarrios();
//        Hago ellistado de departamentos por provincia
        this.getBarrios();
        Iterator it = this.barrios.iterator();
        Barrio b = new Barrio();
        while(it.hasNext())
        {
            b = (Barrio)it.next();
            this.jCBarrio.addItem(b.getNombre().trim());
        }
        b = null;
        it = null;
    }
    
    private void getBarrios()
    {
        int bandera = 0;
        Iterator it = this.allBarrios.iterator();
        while(it.hasNext())
        {
            Barrio b = (Barrio)it.next();
            if(b.getLocalidad().getIdlocalidad() == this.vLocalidad.getIdlocalidad())
            {
                this.barrios.add(b);
                if(bandera == 0)
                    this.vBarrio = b;
                bandera++;
            }
        }
        it = null;
    }
    
    private void getBarrio(String nombre)
    {
        Iterator it = this.barrios.iterator();
        while(it.hasNext())
        {
            Barrio b = (Barrio)it.next();
            if(b.getNombre().trim().equals(nombre.trim()))
            {
                this.vBarrio = b;
                break;
            }
            b = null;
        }
        it = null;
    }
    private void vaciarDepartamentos(){
        this.jCDepartamento.removeAllItems();
        this.departamentos.clear();
    }
    private void vaciarLocalidades(){
        this.jCLocalidad.removeAllItems();
        this.localidades.clear();
    }
    private void vaciarBarrios(){
        this.jCBarrio.removeAllItems();
        this.barrios.clear();
    }
    
    private boolean control()
    {
        boolean bandera = true;
        if(this.jCBarrio.getSelectedItem() == null)
            bandera = false;
        return bandera;
    }
}

