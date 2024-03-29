/*
 * UIAdministrarHabilitaciones.java
 *
 * Created on 11 de enero de 2008, 16:32
 */

package vista;

import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import negocios.Caja;
import reportes.cExport_thread;


/**
 *
 * @author  Administrador
 */
public class UIResumenCajaCerradas extends javax.swing.JDialog
{
    boolean inicio = true;
    /** Creates new form UIAdministrarHabilitaciones */
    public UIResumenCajaCerradas(java.awt.Frame parent, boolean modal)
    {
        initComponents();
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
                this.cargarCombos();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFechaCierre1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfechaApertura1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTTotal1 = new javax.swing.JTextField();
        jCCaja1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTFechaCierre2 = new javax.swing.JTextField();
        jTFechaApertura2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTTotal2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCCaja2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBGenerarReporte = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumen de Cajas Cerradas");
        setModal(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Caja Desde"));

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Fecha de Cierre:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel1.setOpaque(true);

        jTFechaCierre1.setEnabled(false);
        jTFechaCierre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFechaCierre1KeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Fecha de Apertura:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel2.setOpaque(true);

        jTfechaApertura1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTfechaApertura1.setEnabled(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Total de Caja ($):");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel3.setOpaque(true);

        jTTotal1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTTotal1.setEnabled(false);

        jCCaja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCaja1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 204));
        jLabel8.setText("N� Caja Desde:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTTotal1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jTFechaCierre1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jTfechaApertura1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jCCaja1, 0, 85, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jCCaja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfechaApertura1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFechaCierre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Caja hasta"));

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Fecha de Cierre:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel5.setOpaque(true);

        jTFechaCierre2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTFechaCierre2.setEnabled(false);

        jTFechaApertura2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTFechaApertura2.setEnabled(false);
        jTFechaApertura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFechaApertura2ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("Total de Caja($):");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel7.setOpaque(true);

        jTTotal2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTTotal2.setEnabled(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Fecha de Apertura:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);

        jCCaja2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCaja2ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("N� Caja Hasta:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFechaCierre2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jTFechaApertura2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jTTotal2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCCaja2, 0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jCCaja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFechaApertura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFechaCierre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte resumen:"));

        jBGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/printer.gif"))); // NOI18N
        jBGenerarReporte.setText("por Producto");
        jBGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarReporteActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/printer.gif"))); // NOI18N
        jButton1.setText("Gral.de Cajas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBGenerarReporte)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarReporteActionPerformed
    // TODO add your handling code here:
      if(Integer.parseInt(String.valueOf(this.jCCaja1.getSelectedItem())) <= Integer.parseInt(String.valueOf(this.jCCaja2.getSelectedItem())))   
        {
            String caja1 = (String.valueOf(this.jCCaja1.getSelectedItem()));
            String caja2 = (String.valueOf(this.jCCaja2.getSelectedItem()));
            cExport_thread reporte=new cExport_thread(40,caja1.trim(),this.jTfechaApertura1.getText().trim(),caja2.trim(),this.jTFechaCierre2.getText().trim());
            reporte.start();
        }else
            JOptionPane.showMessageDialog(this,"La segunda caja debe ser posterior a la primera...","Atencion",JOptionPane.INFORMATION_MESSAGE);
        
        
}//GEN-LAST:event_jBGenerarReporteActionPerformed

    private void jTFechaCierre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFechaCierre1KeyPressed
        
}//GEN-LAST:event_jTFechaCierre1KeyPressed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBSalirActionPerformed
    {//GEN-HEADEREND:event_jBSalirActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

private void jTFechaApertura2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFechaApertura2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTFechaApertura2ActionPerformed

private void jCCaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCaja1ActionPerformed
// TODO add your handling code here:
    this.mostrarCaja1();
    this.inicio=false;
    
}//GEN-LAST:event_jCCaja1ActionPerformed

private void jCCaja2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCaja2ActionPerformed
// TODO add your handling code here:
    this.mostrarCaja2();
}//GEN-LAST:event_jCCaja2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    if(Integer.parseInt(String.valueOf(this.jCCaja1.getSelectedItem())) <= Integer.parseInt(String.valueOf(this.jCCaja2.getSelectedItem())))   
        {
            String caja1 = (String.valueOf(this.jCCaja1.getSelectedItem()));
            String caja2 = (String.valueOf(this.jCCaja2.getSelectedItem()));
            cExport_thread reporte=new cExport_thread(42,caja1.trim(),this.jTfechaApertura1.getText().trim(),caja2.trim(),this.jTFechaCierre2.getText().trim());
            reporte.start();
        }else
            JOptionPane.showMessageDialog(this,"La segunda caja debe ser posterior a la primera...","Atencion",JOptionPane.INFORMATION_MESSAGE);
}//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
               UIResumenCajaCerradas dialog = new UIResumenCajaCerradas(new javax.swing.JFrame(), true);
               dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }       
               });
            dialog.setVisible(true);
            }    
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGenerarReporte;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCCaja1;
    private javax.swing.JComboBox jCCaja2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTFechaApertura2;
    private javax.swing.JTextField jTFechaCierre1;
    private javax.swing.JTextField jTFechaCierre2;
    private javax.swing.JTextField jTTotal1;
    private javax.swing.JTextField jTTotal2;
    private javax.swing.JTextField jTfechaApertura1;
    // End of variables declaration//GEN-END:variables
    
    private int traerNumeroCaja()
    {
        CListar listar = new CListar();
        int totalcajas = listar.cantidadCajas();
        listar = null;
        return totalcajas;
    }
    
    private void cargarCombos()
    {
        int n = this.traerNumeroCaja();
        for(int i=1;i<=n;i++)
        {
            this.jCCaja1.addItem(String.valueOf(i));
            this.jCCaja2.addItem(String.valueOf(i));
        }
    }
    
    private void mostrarCaja1()
    {
        CListar listar = new CListar();
        long idcaja = Long.parseLong(String.valueOf(this.jCCaja1.getSelectedItem()));
//        System.out.println("id caja elegida:"+idcaja);
        Caja elegida = listar.unaCaja(idcaja);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        this.jTfechaApertura1.setText(sdf.format(elegida.getFechaapertura()));
        this.jTFechaCierre1.setText(sdf.format(elegida.getFechacierre()));
        this.jTTotal1.setText(String.valueOf(elegida.getTotal()));
    }
    
    private void mostrarCaja2()
    {
        CListar listar = new CListar();
        long idcaja2 = Long.parseLong(String.valueOf(this.jCCaja2.getSelectedItem()));
//        System.out.println("id caja2 elegida:"+idcaja2);
        Caja elegida = listar.unaCaja(idcaja2);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        this.jTFechaApertura2.setText(sdf.format(elegida.getFechaapertura()));
        this.jTFechaCierre2.setText(sdf.format(elegida.getFechacierre()));
        this.jTTotal2.setText(String.valueOf(elegida.getTotal()));
               
    }
      
}
