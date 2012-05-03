/*
 * UIReimprimirConstancias.java
 *
 * Created on 12 de marzo de 2008, 14:48
 */

package vista;

import Datos.Baja;
import Datos.Consulta;
import Datos.Modificacion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UIReimprimirConstancias extends javax.swing.JFrame {
    
    /** Creates new form UIReimprimirConstancias */
    public UIReimprimirConstancias() {
        initComponents();     
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCTipoConstancia = new javax.swing.JComboBox();
        jTSerie = new javax.swing.JTextField();
        jTNumero = new javax.swing.JTextField();
        jBSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBGenerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reimpresión / Eliminacion Fisica");

        jCTipoConstancia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PARCIAL", "TOTAL" }));

        jTSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSerieActionPerformed(evt);
            }
        });
        jTSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTSerieKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTSerieKeyReleased(evt);
            }
        });

        jTNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNumeroKeyPressed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/printer.gif"))); // NOI18N
        jBGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBGenerarMouseClicked(evt);
            }
        });
        jBGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarActionPerformed(evt);
            }
        });
        jBGenerar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBGenerarKeyPressed(evt);
            }
        });

        jLabel1.setText("Tipo de Constancia");

        jLabel2.setText("Serie");

        jLabel3.setText("Numero");

        jButton1.setText("Eliminar Fisicamente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Poner Factura cero");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCTipoConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBGenerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel3)
                        .addGap(76, 76, 76)))
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCTipoConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBGenerar))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGenerarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBGenerarMouseClicked

    private void jBGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarActionPerformed
        // TODO add your handling code here:
        this.reimprimir();
        
//       
//                cExport_thread report = new cExport_thread(32,this.jTMatriculaSolicitante.getText().trim(),this.jTNombreEntidad.getText().trim());
//                report.start();
         
    }//GEN-LAST:event_jBGenerarActionPerformed

    private void jBGenerarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBGenerarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
    }//GEN-LAST:event_jBGenerarKeyPressed

    private void jTNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNumeroKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        boolean nroCorrecto=true;
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(this,"Debe introducir un valor valido ej: 12","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTNumero.setText("");
            this.jTNumero.requestFocus();
            nroCorrecto=false;
            evt.consume();
        }
        if(evt.getKeyCode()==10 && nroCorrecto)
            this.reimprimir();
        if(evt.getKeyCode()==27)
            this.dispose();
    }//GEN-LAST:event_jTNumeroKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.jTSerie.getText().length()>0 && this.jTNumero.getText().length()>0){
            int resp=JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar esta constancia\nse eliminara fisicamente de la base de datos\nsolo use esta opcion si quiere borrar una constancia mal confeccionada y no has sido facturada", "Precaucion", JOptionPane.WARNING_MESSAGE);
            if (resp==JOptionPane.OK_OPTION){
                this.eliminarConstancia();
            }else{
                JOptionPane.showMessageDialog(this, "Se canceló la eliminación", "Eliminacion cancelada", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            
            JOptionPane.showMessageDialog(this, "Ingrese una serie y nro de valido de constancia ", "Faltan datos", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSerieActionPerformed

    private void jTSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSerieKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSerieKeyPressed

    private void jTSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSerieKeyReleased
        // TODO add your handling code here:
        if(this.jTSerie.getText().trim().length() > 2)
        {
            JOptionPane.showMessageDialog(null, "El nombre de la serie no debe pasar de los dos caracteres","Atencion",JOptionPane.INFORMATION_MESSAGE);
            this.jTSerie.setText(this.jTSerie.getText().substring(0, 2));
        }

    }//GEN-LAST:event_jTSerieKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (this.jTSerie.getText().length()>0 && this.jTNumero.getText().length()>0)
        {
            int resp=JOptionPane.showConfirmDialog(this, "Esta s a punto de poner la constancia con numero de factura cero\n para que esta constancia pueda ser refacturada en una nueva factura\nsea cuidadoso al hacer esta operacion", "Precaucion", JOptionPane.WARNING_MESSAGE);
            if (resp==JOptionPane.OK_OPTION)
            {
                this.facturaCero();
            }else{
                JOptionPane.showMessageDialog(this, "Se canceló la modificación", "Modificacion cancelada", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            
            JOptionPane.showMessageDialog(this, "Ingrese una serie y nro de valido de constancia ", "Faltan datos", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIReimprimirConstancias().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGenerar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCTipoConstancia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTNumero;
    private javax.swing.JTextField jTSerie;
    // End of variables declaration//GEN-END:variables
    private void reimprimir(){
        //0 es constancia parcial
        //1 es constancia total
        switch (this.jCTipoConstancia.getSelectedIndex()) {
            case 0: cExport_thread imprimeCT=new cExport_thread(34,this.jTSerie.getText().trim().toUpperCase(),this.jTNumero.getText().trim(),"");
                    imprimeCT.start();                    
                    break;
            case 1: cExport_thread imprimeCP=new cExport_thread(33,this.jTSerie.getText().trim().toUpperCase(),this.jTNumero.getText().trim(),"");
                    imprimeCP.start();
                    break;   
        }
    }
    
    private void facturaCero()
    {
        Consulta con=new Consulta();
        boolean existe=false;
        
        switch (this.jCTipoConstancia.getSelectedIndex()) 
        {
            case 0: existe=con.verificarNroConstancia(this.jTNumero.getText().trim(),this.jTSerie.getText().trim().toUpperCase());                    
//                    System.out.println("CP: "+existe);
                    EncabezadoCP encCP=  new EncabezadoCP();
                    encCP.setCodigoCP(Long.parseLong(this.jTNumero.getText().trim()));
                    encCP.setSerieCP(this.jTSerie.getText().trim().toUpperCase());
                    encCP.setSerieFactura(0);
                    encCP.setNumeroFactura(0);
                    if (!existe)
                    {                        
                        Modificacion mod = new Modificacion();
                        int borrados=mod.modificarCPFacturaCero(encCP);
                        if (borrados>0){
                            JOptionPane.showMessageDialog(this, "Se actualizo correctamente la constancia:" + encCP.getSerieCP()+"-"+encCP.getSerieCP(), "Actualizacion Correcta", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break; 
            case 1: existe=con.verificarNroConstanciaTotal(this.jTNumero.getText().trim(),this.jTSerie.getText().trim().toUpperCase());                    
//                    System.out.println("CT: "+existe);
                    EncabezadoCT encCT=  new EncabezadoCT();
                    encCT.setCodigoCT(Long.parseLong(this.jTNumero.getText().trim()));
                    encCT.setSerieCT(this.jTSerie.getText().trim().toUpperCase());
                    if (!existe){//esta al reves,ver conculta, si existe entonces borra
                        Modificacion mod = new Modificacion();
//                        Baja baja=new Baja();
                        int borrados= mod.modificarPonerCTconFacturaEnCero(encCT.getSerieCT().trim(), encCT.getCodigoCT());
                        if (borrados>0){
                            JOptionPane.showMessageDialog(this, "Se modifico correctamente la constancia:" + encCT.getSerieCT()+"-"+encCT.getSerieCT(), "Modificacion correcta", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;
        }
    }
    
    /**
     * Permite cambiar el numero de factura asociado con la constancia
     */
    
     
    private void eliminarConstancia(){
        Consulta con=new Consulta();
        boolean existe=false;
        
        switch (this.jCTipoConstancia.getSelectedIndex()) {
            case 0: existe=con.verificarNroConstancia(this.jTNumero.getText().trim(),this.jTSerie.getText().trim().toUpperCase());                    
                    System.out.println("CP: "+existe);
                    EncabezadoCP encCP=  new EncabezadoCP();
                    encCP.setCodigoCP(Long.parseLong(this.jTNumero.getText().trim()));
                    encCP.setSerieCP(this.jTSerie.getText().trim().toUpperCase());
                    if (!existe){                        
                        Baja baja=new Baja();
                        int borrados=baja.eliminarFisicamente(encCP);
                        if (borrados>0){
                            JOptionPane.showMessageDialog(this, "Se elimino correctamente la constancia:" + encCP.getSerieCP()+"-"+encCP.getSerieCP(), "Eliminacion correcta", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break; 
            case 1: existe=con.verificarNroConstanciaTotal(this.jTNumero.getText().trim(),this.jTSerie.getText().trim().toUpperCase());                    
                    System.out.println("CT: "+existe);
                    EncabezadoCT encCT=  new EncabezadoCT();
                    encCT.setCodigoCT(Long.parseLong(this.jTNumero.getText().trim()));
                    encCT.setSerieCT(this.jTSerie.getText().trim().toUpperCase());
                    if (!existe){//esta al reves,ver conculta, si existe entonces borra
                        Baja baja=new Baja();
                        int borrados=baja.eliminarFisicamente(encCT);
                        if (borrados>0){
                            JOptionPane.showMessageDialog(this, "Se elimino correctamente la constancia:" + encCT.getSerieCT()+"-"+encCT.getSerieCT(), "Eliminacion correcta", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;
        }
        
    }
}
