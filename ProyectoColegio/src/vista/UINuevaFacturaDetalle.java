/*
 * UINuevaFacturaDetalle.java
 *
 * Created on 27 de marzo de 2008, 19:06
 */

package vista;

import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import negocios.DetalleFactura;
import negocios.Producto;

/**
 *
 * @author  Administrador
 */
public class UINuevaFacturaDetalle extends javax.swing.JFrame {
    private Collection productos=new ArrayList();
    private Producto productoElegido=new Producto();
    private DetalleFactura detalle=new DetalleFactura();
    private UINuevaFactura ventanaFactura = new UINuevaFactura(detalle);
    
    /** Creates new form UINuevaFacturaDetalle */
    public UINuevaFacturaDetalle() {
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);        
        this.inicializaFormulario();
    }
    public UINuevaFacturaDetalle(UINuevaFactura ventanaFacturacion) {
        /**
         * Este constructor se llama desde la interfase UINuevaFactura
         * y permite enviar datos de una linea de detalle a esa misma interfase
         * es decir, esta ventana UINuevaFacturaDetalle actua como una
         * ventana de dialogo
         */
        ventanaFactura=ventanaFacturacion;
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);                
        this.inicializaFormulario();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCCodigoProducto = new javax.swing.JComboBox();
        jTDetalle = new javax.swing.JTextField();
        jTDescripcion = new javax.swing.JTextField();
        jTCantidad = new javax.swing.JTextField();
        jTPrecioUnitario = new javax.swing.JTextField();
        jTSubTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBAgregar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Detalle de Factura");
        setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Detalle"));

        jCCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCodigoProductoActionPerformed(evt);
            }
        });

        jTCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCantidadKeyReleased(evt);
            }
        });

        jLabel1.setText("Codigo:");

        jLabel2.setText("Detalle:");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("Subtotal:");

        jLabel5.setText("PU:");

        jLabel6.setText("Cantidad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTDetalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jTDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jCCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jTPrecioUnitario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jTSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jBCancelarActionPerformed

    private void jCCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCodigoProductoActionPerformed
        // TODO add your handling code here:
        this.llenarDatosDelProductoElegido(this.jCCodigoProducto.getSelectedItem().toString().trim());
    }//GEN-LAST:event_jCCodigoProductoActionPerformed

    private void jTCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCantidadKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTCantidadKeyPressed

    private void jTCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCantidadKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10){
            if (this.jTCantidad.getText().trim()!=null && this.jTCantidad.getText().trim().length()>0){
                Double subtotal=Integer.valueOf(this.jTCantidad.getText().trim())*Double.valueOf(this.jTPrecioUnitario.getText().trim());
                this.jTSubTotal.setText(String.valueOf(subtotal));
                this.jBAgregar.requestFocus();
            }        
        }
    }//GEN-LAST:event_jTCantidadKeyReleased

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:
        this.enviarDetalleAVentanaFacturacion();
    }//GEN-LAST:event_jBAgregarActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UINuevaFacturaDetalle().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JComboBox jCCodigoProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTCantidad;
    private javax.swing.JTextField jTDescripcion;
    private javax.swing.JTextField jTDetalle;
    private javax.swing.JTextField jTPrecioUnitario;
    private javax.swing.JTextField jTSubTotal;
    // End of variables declaration//GEN-END:variables
    private void inicializaFormulario(){
        this.cargarComboProductos();
    
    
    }
    private void cargarComboProductos(){
        CListar listaProductos=new CListar();
        //Producto prod=new Producto();
        this.productos=listaProductos.hacerListado(new Producto());
        Iterator it=productos.iterator();
        while (it.hasNext()){
            Producto prod=(Producto)it.next();
            this.jCCodigoProducto.addItem(prod.getIdproducto());
            prod=null;
        }
        it=null;
    }
    private void llenarDatosDelProductoElegido(String codigoProducto){
        this.limpiarCampos();
        
        Iterator it=this.productos.iterator();
        while (it.hasNext()){
            Producto prod=(Producto)it.next();
            if (prod.getIdproducto()==Integer.valueOf(codigoProducto)){
                this.productoElegido=prod;
                this.jTDetalle.setText(prod.getDenominacion().trim());
                this.jTPrecioUnitario.setText(String.valueOf(prod.getPrecio()));
            }            
            prod=null;
        }
        it=null;
    }
    private void limpiarCampos(){
        this.jTCantidad.setText("");
        this.jTDescripcion.setText("");
        this.jTDetalle.setText("");
        this.jTPrecioUnitario.setText("");
        this.jTSubTotal.setText("");
    }
    
    
    private void enviarDetalleAVentanaFacturacion(){
        DetalleFactura detalle2=new DetalleFactura();
        /** Los campos de detalleFatura son:
        private long iddetalle; //No se carga ahora,sino en otra pantalla
        private int serieFactura;//No se carga ahora,sino en otra pantalla
        private Long numeroFactura;//No se carga ahora,sino en otra pantalla
        private Producto producto;
        private String detalle;
        private int cantidad;
        private double subTotal;
         Se cargan todos escepto iddetalle,seriefactura,numerofactura, los cuales se carga en la ventana 
         de facturacion*/
        
        detalle2.setProducto(productoElegido);
        detalle2.setDetalle(this.jTDescripcion.getText().trim());
        detalle2.setCantidad(Integer.valueOf(this.jTCantidad.getText().trim()));
        detalle2.setSubTotal(Double.valueOf(this.jTSubTotal.getText().trim()));        
        
        
        //UINuevaFactura facturaTemp=new UINuevaFactura(detalle);
        //facturaTemp.agregarLineaDetalle(detalle);
        ventanaFactura.agregarLineaDetalle(detalle2);
    }
    
}
