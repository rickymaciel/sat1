/*
 * UIAnulados.java
 *
 * Created on 6 de julio de 2008, 17:13
 */

package vista;

import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import reportes.cExport_thread;

/**
 *
 * @author  gustavo
 */
public class UIAnulados extends javax.swing.JFrame {

    /** Creates new form UIAnulados */
    public UIAnulados() {
        initComponents();
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        this.ajustarColumnas();
        this.llenarGrilla();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jRTodos = new javax.swing.JRadioButton();
        jRConstanciasParciales = new javax.swing.JRadioButton();
        jRConstanciasTotales = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jBImprimir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Constancias Anuladas");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Serie", "Codigo", "Serie Factura", "Numero Factura", "Tipo Constancia", "Fecha", "Matricula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRTodos);
        jRTodos.setSelected(true);
        jRTodos.setText("Todas");

        buttonGroup1.add(jRConstanciasParciales);
        jRConstanciasParciales.setText("Contancias Parciales");

        buttonGroup1.add(jRConstanciasTotales);
        jRConstanciasTotales.setText("Constancias Totales");
        jRConstanciasTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRConstanciasTotalesActionPerformed(evt);
            }
        });

        jButton1.setText("Actualizar Grilla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBImprimir1.setText("Reimprimir");
        jBImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRTodos)
                        .addGap(60, 60, 60)
                        .addComponent(jRConstanciasParciales)
                        .addGap(32, 32, 32)
                        .addComponent(jRConstanciasTotales)
                        .addGap(101, 101, 101)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRConstanciasParciales)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRTodos)
                    .addComponent(jRConstanciasTotales))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
// TODO add your handling code here:
     this.dispose();
}//GEN-LAST:event_jBSalirActionPerformed

private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
// TODO add your handling code here:
    if(this.jRConstanciasParciales.isSelected())
    {
        cExport_thread imp_CP =new cExport_thread(50);
        imp_CP.start();
    }else{
        if(this.jRConstanciasTotales.isSelected())
        {
            cExport_thread imp_CT = new cExport_thread(51);
            imp_CT.start();
        }
        if(this.jRTodos.isSelected())
        {
            cExport_thread imp_CT = new cExport_thread(52);
            imp_CT.start();
        }
    }
}//GEN-LAST:event_jBImprimirActionPerformed

private void jRConstanciasTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRConstanciasTotalesActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jRConstanciasTotalesActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    this.llenarGrilla();
    this.ajustarColumnas();
}//GEN-LAST:event_jButton1ActionPerformed

private void jBImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimir1ActionPerformed
// TODO add your handling code here:
    
     if (this.jTable1.getSelectedRow()!=-1){            
            if (this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString().toUpperCase().trim().equals("CT")){
                cExport_thread imprimeCT=new cExport_thread(34,this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString().toUpperCase().trim(),this.jTable1.getValueAt(this.jTable1.getSelectedRow(),1).toString().trim(),"ANULADA");
                imprimeCT.start();                    
            } 
            if (this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString().toUpperCase().trim().equals("CP")){
                cExport_thread imprimeCP=new cExport_thread(33,this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString().toUpperCase().trim(),this.jTable1.getValueAt(this.jTable1.getSelectedRow(),1).toString().trim(),"ANULADA");
                imprimeCP.start();                   
            } 
     }else{
            JOptionPane.showMessageDialog(this,"Elija una constancia de la tabla para tener una vista preliminar","Vista Preliminar",JOptionPane.INFORMATION_MESSAGE);
     }
}//GEN-LAST:event_jBImprimir1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIAnulados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBImprimir1;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jRConstanciasParciales;
    private javax.swing.JRadioButton jRConstanciasTotales;
    private javax.swing.JRadioButton jRTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    Collection anuladoscp = new ArrayList();
    Collection anuladosct = new ArrayList();
    
    private void llenarGrilla()
    {
        if(this.jRConstanciasParciales.isSelected())
        {
            this.obtenerConstanciasParciales();
            this.limpiarGrilla();
            this.llenarConstanciasCP();
        }else{
            if(this.jRConstanciasTotales.isSelected())
            {
                this.obtenerConstanciasTotales();
                this.limpiarGrilla();
                this.llenarConstanciasCT();
            }else{
                this.limpiarGrilla();
                this.obtenerConstanciasParciales();
                this.obtenerConstanciasTotales();
                this.llenarConstanciasCP();
                this.llenarConstanciasCT();
            }
        }
        
    }
    
    private void obtenerConstanciasParciales()
    {
        CListar listar = new CListar();
        this.anuladoscp = listar.listarAnuladosCP();
        listar = null;
    }
    
    private void obtenerConstanciasTotales()
    {
        CListar listar = new CListar();
        this.anuladosct = listar.listarAnuladosCT();
        listar = null;
    }
    
    private void llenarConstanciasCP()
    {
       Iterator it = this.anuladoscp.iterator();
       DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
       String datos[] = new String[9];
       EncabezadoCP cp = new EncabezadoCP();
       while(it.hasNext())
       {
           cp = (EncabezadoCP)it.next();
           datos[0] = String.valueOf(cp.getSerieCP());
           datos[1] = String.valueOf(cp.getCodigoCP());
           datos[2] = String.valueOf(cp.getSerieFactura());
           datos[3] = String.valueOf(cp.getNumeroFactura());
           datos[4] = "CP";
           DateFormat df = DateFormat.getDateInstance();           
           datos[5] = df.format(cp.getFecha());
//           datos[6] = cp.getUsuario().getNombre();
           datos[6] = String.valueOf(cp.getMatriculado().getMatricula());
//           datos[8] = String.valueOf(cp.getTotal());
           modelo.addRow(datos);
       }
       datos = null;
       it = null;
       cp = null;
     }
    
    private void llenarConstanciasCT()
    {
       Iterator it = this.anuladosct.iterator();
       DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
       String datos[] = new String[9];
       EncabezadoCT ct = new EncabezadoCT();
       while(it.hasNext())
       {
           ct = (EncabezadoCT)it.next();
           datos[0] = String.valueOf(ct.getSerieCT());
           datos[1] = String.valueOf(ct.getCodigoCT());
           datos[2] = String.valueOf(ct.getSerieFactura());
           datos[3] = String.valueOf(ct.getNumeroFactura());
           datos[4] = "CT";
           DateFormat df = DateFormat.getDateInstance();
           datos[5] = df.format(ct.getFecha());
//           datos[6] = ct.getUsuario().getNombre();
           datos[6] = String.valueOf(ct.getMatriculado().getMatricula());
//           datos[8] = String.valueOf(ct.getTotal());
           modelo.addRow(datos);
       }
       datos = null;
       it = null;
       ct = null;
    }
    
    private void limpiarGrilla()
    {
       DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        while(this.jTable1.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }
    
    private void ajustarColumnas()
     {
         TableColumn column = null;
         for (int i = 0; i < 7; i++) 
        {
            column = jTable1.getColumnModel().getColumn(i);
            switch(i)
            {
                case 0:
//                        System.out.println("El tama�o de la columna 1 es: "+column.getPreferredWidth());
			column.setPreferredWidth(48);
                        break;
                case 1:
//                        System.out.println("El tama�o de la columna 2 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(47);
                        break;
                case 2:
//                        System.out.println("El tama�o de la columna 3 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(76); 
                        break;
                case 3:
//                        System.out.println("El tama�o de la columna 4 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(89); 
                        break;
                case 4:
//                        System.out.println("El tama�o de la columna 5 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(95); 
                        break;
                case 5:
//                        System.out.println("El tama�o de la columna 6 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(87); 
                        break;
                case 6:
//                        System.out.println("El tama�o de la columna 7 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(85); 
                        break;
                case 7:
//                        System.out.println("El tama�o de la columna 8 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(47); 
                        break;
                case 8:
//                        System.out.println("El tama�o de la columna 9 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(63); 
                        break;
            }
        }
        column = null; 
     }
    
}
