/*
 * UIListadoDeCajas.java
 *
 * Created on 17 de abril de 2008, 16:27
 */

package vista;

import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Caja;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UIListadoDeCajas extends javax.swing.JDialog {
    
    /** Creates new form UIListadoDeCajas */
    public UIListadoDeCajas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);        
        this.mostrarCajas();
    }

//    UIListadoDeCajas() {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBImprimir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Cajas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Caja", "F.Apertura", "F.Cierre", "Total($)", "Usuario que Cerro", "Saldo Inicial($)", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("La tabla presenta un listado de las cajas que se han abierto y cerrado, si cuentan con fechas de apertura y cierre, significa que esta abierta, ver Estado de Caja");
        jScrollPane1.setViewportView(jTable1);

        jBImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/printer.gif"))); // NOI18N
        jBImprimir.setText("Imprimir");
        jBImprimir.setToolTipText("Imprime la caja seleccionada");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jBImprimir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:
        if (this.jTable1.getSelectedRow()>-1){//es decir,si selecciono un elemento de la tabla
            cExport_thread imprime=new cExport_thread(29,String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)).trim());
            imprime.start();
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar una caja de la tabla�","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jBSalirActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIListadoDeCajas dialog = new UIListadoDeCajas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
 
    private void mostrarCajas(){
        Caja c=new Caja();
        
        CListar listaCaja=new CListar();
        Collection todasLasCajas=listaCaja.hacerListadoCajas();
        
        listaCaja = null;
        Iterator it = todasLasCajas.iterator();
        // ahora obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        String datos[] = new String[7];
        while(it.hasNext())
        {
            c = (Caja)it.next();
            datos[0] = String.valueOf(c.getIdcaja());
            datos[1] = String.valueOf(c.getFechaapertura());
            datos[2] = String.valueOf(c.getFechacierre());
            datos[3] = String.valueOf(c.getTotal());
            datos[4] = c.getUsuariocierre().getNombre().trim();
            datos[5] = String.valueOf(c.getSaldoinicial());
            datos[6] = String.valueOf(c.getEstado());            
            modelo.addRow(datos);
        }
        
    }
    
    
}
