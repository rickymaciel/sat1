/*
 * UIHistorialPagos.java
 *
 * Created on 1 de mayo de 2008, 21:42
 */

package vista;

import Datos.Baja;
import Datos.Consulta;
import Datos.Modificacion;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.EncabezadoDetallePago;
import negocios.EncabezadoPago;
import negocios.Matriculado;
import negocios.Titulo;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UIHistorialPagos extends javax.swing.JDialog {
    private Matriculado matri;
    
    /** Creates new form UIHistorialPagos */
    public UIHistorialPagos(java.awt.Frame parent, boolean modal,Matriculado mat) {
        
        super(parent, modal);
        initComponents();
        
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        
        this.matri=mat;
        
        if (mat.getMatricula()!=0){
            this.llenarTablaHistorialDePagos();
        }
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
        jBQuitar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jTMatricula = new javax.swing.JTextField();
        jTMatriculado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de pagos de Matricula");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pago", "Fecha de Pago", "SerieFactura", "Nro.Factura", "A�o", "Mes", "Importe($)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
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
        jScrollPane1.setViewportView(jTable1);

        jBQuitar.setText("Eliminar");
        jBQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarActionPerformed(evt);
            }
        });

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

        jTMatricula.setToolTipText("Introduzca una matricula existente.");
        jTMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTMatriculaKeyPressed(evt);
            }
        });

        jTMatriculado.setEnabled(false);

        jLabel4.setText("Matriculado:");

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

        jBListar.setText("Listar");
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBListar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBListar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // cuando se seleccione una fila, los datos de esa fila deben aparecer en los textbox de abajo solo si no se esta por cargar un nuevo elemento
        
}//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
}//GEN-LAST:event_jTable1KeyPressed

    private void jBQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarActionPerformed
        if (this.jTable1.getSelectedRow()!=-1) {
            this.quitarLineaDetalleHistorial();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila de la tabla...","Atencion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBQuitarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:
        this.imprimir();
    }//GEN-LAST:event_jBImprimirActionPerformed

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

    private void jBBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBBuscarMouseClicked

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        this.buscarMatriculado();
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
        // TODO add your handling code here:        
        this.limpiarTabla();
        
        if (this.matri.getMatricula()!=0){
            this.llenarTablaHistorialDePagos();
        }
}//GEN-LAST:event_jBListarActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIHistorialPagos dialog = new UIHistorialPagos(new javax.swing.JFrame(), true,new Matriculado());
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
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBListar;
    private javax.swing.JButton jBQuitar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTMatricula;
    private javax.swing.JTextField jTMatriculado;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private void llenarTablaHistorialDePagos(){
        EncabezadoDetallePago ep=new EncabezadoDetallePago();
        Consulta consu=new Consulta();
        
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2); 
        
        Collection historialPagosEncDet=consu.getDetallePagoXMatricula(matri.getMatricula());
        
        
        Iterator it = historialPagosEncDet.iterator();        
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        
        String datos[] = new String[7];
        //Vector datos = new Vector();
        
        while(it.hasNext()){
            ep = (EncabezadoDetallePago)it.next();
            datos[0] = String.valueOf(ep.getIdencabezado());
            
            DateFormat df = DateFormat.getDateInstance();
            datos[1] = String.valueOf(df.format(ep.getFechapago()));            
            //datos[1] = String.valueOf(ep.getFechapago());
            datos[2] = String.valueOf(ep.getSeriefactura());
            datos[3] = String.valueOf(ep.getNrofactura());            
            datos[4] = String.valueOf(ep.getAnio());
            datos[5] = String.valueOf(ep.getMes());
//            datos[6] = String.valueOf(ep.getImporte()); 
            datos[6] = nf.format(ep.getImporte());
            
            modelo.addRow(datos);
        }
        it=null;
        modelo=null;
        historialPagosEncDet=null;
    }
    private void quitarLineaDetalleHistorial(){        
        Long idpago=Long.parseLong(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
        DefaultTableModel  modelo=new DefaultTableModel();
        modelo=(DefaultTableModel) this.jTable1.getModel();       
        
        if (this.jTable1.getSelectedRow()>-1){
            int res= JOptionPane.showConfirmDialog(this,"�Esta seguro que desea eliminar esta cuota del matriculado?", "Borrar Cuota de Matriculado",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (res==JOptionPane.YES_OPTION){
                if (this.hayMasDeDosCuotasEnPago(idpago)){
                        Baja eliminar=new Baja();                        
                        //System.out.println(Integer.parseInt("COLUMNA ANIO:"+String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4)))+"COLUMNA MES: "+Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5))));        
                        int resp=eliminar.eliminarItemDetallePago(idpago, Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4))), Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5))));
                        if (resp!=0){
                            JOptionPane.showMessageDialog(this, "La Cuota ha sido eliminada correctamente","Eliminacion", JOptionPane.INFORMATION_MESSAGE);
                            //Quito la linea de la tabla
                            this.recalcularTotalDeEncabezadoPago(idpago);
                            modelo.removeRow(this.jTable1.getSelectedRow());                            
                        }else{
                            JOptionPane.showMessageDialog(this, "Ocurrio problemas al intentar eliminar la cuota","Eliminacion", JOptionPane.ERROR_MESSAGE);
                        }
                }else{
                        //aliminar el pago
                        int respu= JOptionPane.showConfirmDialog(this,"�Al eliminar esta cuota, eliminara todo el pago\ncorrespondiente a su numero de factura, esta seguro de eliminar?", "Borrar Cuota de Matriculado",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if (respu == JOptionPane.YES_OPTION){
                            this.borrarEncabezadoPago(idpago);
                            modelo.removeRow(this.jTable1.getSelectedRow());
                        }
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento de la tabla","Eliminacion", JOptionPane.INFORMATION_MESSAGE);
        }   
    }
  
    private void recalcularTotalDeEncabezadoPago(Long idpag){                
        //DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        Double nuevoTotal=0.0;
        int mesUltimo=0;
        int anioUltimo=0;
        int ultimoDiaDelMes=30;
        
        //NumberFormat nf = NumberFormat.getInstance();
        
        //CALCULO EL NUEVO TOTAL DEL ENCABEZADO DEL PAGO, EL ULTIMO ANIO Y ULTIMO MES
        for (int i=0;i<this.jTable1.getRowCount();i++){
            if (Long.parseLong(String.valueOf(this.jTable1.getValueAt(i, 0)))==idpag){
                nuevoTotal=nuevoTotal+Double.parseDouble(String.valueOf(this.jTable1.getValueAt(i, 6)));
                //nuevoTotal=nuevoTotal+nf.format(Double.parseDouble(String.valueOf(this.jTable1.getValueAt(i, 6))));                
                if (anioUltimo<Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i, 4)))){
                    anioUltimo=Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i, 4)));
                }                
                if (Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i, 4)))==anioUltimo){
                    if (Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i, 5)))>mesUltimo){
                        mesUltimo=Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i, 5)));
                    }
                }
            }    
        }
        if (mesUltimo==2){
            ultimoDiaDelMes=28;
        }
        
        System.out.println ("nuevo total del idpago es : "+ nuevoTotal);
        
        EncabezadoPago encPago=new EncabezadoPago();
        encPago.setIdencabezado(Long.parseLong(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0))));
        encPago.setTotal(nuevoTotal);
        
        
        
        String fecha=ultimoDiaDelMes+"/"+mesUltimo+"/"+anioUltimo;
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        try{
            java.util.Date d=sdf.parse(fecha); 
            encPago.setHabilitacionhasta(d);
        }catch(ParseException pe){
            System.out.println("LA FECHA ESTA INCORRECTA ENTRO AL CATCH...");
        }
        
        Modificacion modifica=new Modificacion();
        int resp=modifica.modificarTotalEncPago(encPago);        
    }
    
    
    private boolean hayMasDeDosCuotasEnPago(Long idpago){
        boolean masCuotas=false;
        int cantDeDosCuotasEnEncabezado=0;
        for (int i=0;i<this.jTable1.getRowCount();i++){
            if (Long.parseLong(String.valueOf(this.jTable1.getValueAt(i, 0)))==idpago){
                cantDeDosCuotasEnEncabezado=cantDeDosCuotasEnEncabezado+1;
                if (cantDeDosCuotasEnEncabezado>1){
                    masCuotas=true;
                    System.out.println("HAY MAS DE DOS CUOTAS PARA EL PAGO: "+ idpago);
                    break;
                    
                }else{
                    System.out.println("HAY menos DE DOS CUOTAS PARA EL PAGO: "+ idpago);
                }
            } 
        }
        return masCuotas;
    }
    
    private void borrarEncabezadoPago(long idpa){
        Baja baja = new Baja();
        int resp1 = baja.eliminarDetallePago(idpa);
        if(resp1 != 0)
        {
            int resp2 =baja.eliminarEncabezadoPago(idpa);
            if(resp2 != 0)
            {
                JOptionPane.showMessageDialog(this,"Se ha eleminado correctamente","Atencion",JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                JOptionPane.showMessageDialog(this,"Ocurrio un error no se pudo borrar correctamente","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void imprimir(){
        cExport_thread imprime=new cExport_thread(37,String.valueOf(this.matri.getMatricula()).trim());
        imprime.start();
    }

    private void buscarMatriculado(){
        if (this.jTMatricula.getText().trim().equals("")){
                JOptionPane.showMessageDialog(this, "Escriba un numero de matricula en el campo de busqueda","Campo matricula vac�a", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Matriculado m=new Matriculado(); 
                m.setMatricula(Integer.parseInt(this.jTMatricula.getText().trim()));

                CListar listamat=new CListar();
                Matriculado ma=listamat.soloMatriculado(m);        
                String nombreMatriculado="";

                if (ma.getMatricula()!=0){
                    Titulo tit=ma.getTitulo();
                    nombreMatriculado=String.valueOf(ma.getMatricula());
                    
                    //Asigno al matriculado global el matriculado encontrado
                    this.matri=ma;//
                    //
                    
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
    private void limpiarTabla(){
            DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
            while(this.jTable1.getRowCount() != 0)
                modelo.removeRow(0);
            modelo = null;
    }
}