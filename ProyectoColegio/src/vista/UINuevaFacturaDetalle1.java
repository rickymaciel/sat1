/*
 * UINuevaFacturaDetalle1.java
 *
 * Created on 3 de abril de 2008, 01:57
 */

package vista;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import negocios.DetalleFactura;
import negocios.Producto;
/**
 *
 * @author  Administrador
 */
public class UINuevaFacturaDetalle1 extends javax.swing.JDialog {
    private Collection productos=new ArrayList();
    private Producto productoElegido=new Producto();
    private DetalleFactura detalle=new DetalleFactura();
    private UINuevaFactura ventanaFactura = new UINuevaFactura(detalle);
    
    /** Creates new form UINuevaFacturaDetalle1 */
    public UINuevaFacturaDetalle1(java.awt.Frame parent, boolean modal) {
        ventanaFactura=(UINuevaFactura) parent;
        initComponents();       
        this.inicializaFormulario();
        
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
        setModal(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Detalle"));

        jCCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCodigoProductoActionPerformed(evt);
            }
        });
        jCCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCCodigoProductoKeyPressed(evt);
            }
        });

        jTDetalle.setEditable(false);
        jTDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDetalleKeyPressed(evt);
            }
        });

        jTDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDescripcionKeyPressed(evt);
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

        jTPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPrecioUnitarioKeyPressed(evt);
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

    private void jCCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCodigoProductoActionPerformed
        // TODO add your handling code here:
        this.llenarDatosDelProductoElegido(this.jCCodigoProducto.getSelectedItem().toString().trim());
    }//GEN-LAST:event_jCCodigoProductoActionPerformed

    private void jTCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCantidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(this,"Debe introducir un valor valido ej: 12","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTCantidad.setText("");
            this.jTCantidad.requestFocus();
            evt.consume();
        }

    }//GEN-LAST:event_jTCantidadKeyPressed

    private void jTCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCantidadKeyReleased
        // TODO add your handling code here:        
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
        if (this.jTCantidad.getText().trim().equals("")){
            this.jTCantidad.setText("1");
        }
        if (this.jTPrecioUnitario.getText().trim().equals("")){
            this.jTPrecioUnitario.setText("0");
        }
        if (this.jTSubTotal.getText().trim().equals("")){
            this.jTSubTotal.setText("0");
        }
        if (this.jTDescripcion.getText().trim().length()>230){
            JOptionPane.showMessageDialog(this, "El campo DESCRIPCION tiene mas letras que las permitidas\nSolo se permiten 230 caracteres", "Demasiadas Letras", JOptionPane.WARNING_MESSAGE);
        }else{
            this.enviarDetalleAVentanaFacturacion();
            int resp=JOptionPane.showConfirmDialog(this, "Facturar otro producto?", "Agregar", JOptionPane.OK_CANCEL_OPTION);
            if (resp==JOptionPane.CANCEL_OPTION){
                this.dispose();
            }
        }
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jCCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCCodigoProductoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTDetalle.requestFocus();
    }//GEN-LAST:event_jCCodigoProductoKeyPressed

    private void jTDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDetalleKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTDescripcion.requestFocus();
    }//GEN-LAST:event_jTDetalleKeyPressed

    private void jTDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDescripcionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTCantidad.requestFocus();
    }//GEN-LAST:event_jTDescripcionKeyPressed

    private void jTPrecioUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecioUnitarioKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE) || (c == '.') || (c == '-'))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(this,"Debe introducir un valor valido ej: 12.00","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTPrecioUnitario.setText("");
            this.jTPrecioUnitario.requestFocus();
            evt.consume();
        }

    }//GEN-LAST:event_jTPrecioUnitarioKeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UINuevaFacturaDetalle1 dialog = new UINuevaFacturaDetalle1(new javax.swing.JFrame(), true);
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
        //DetalleFactura detalle=new DetalleFactura();
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
        
        detalle.setProducto(productoElegido);
        detalle.getProducto().setPrecio(Double.valueOf(this.jTPrecioUnitario.getText().trim()));
        detalle.setDetalle(this.jTDescripcion.getText().trim());
        detalle.setCantidad(Integer.valueOf(this.jTCantidad.getText().trim()));        
        detalle.setSubTotal(Double.valueOf(this.jTSubTotal.getText().trim()));        
        
        //UINuevaFactura facturaTemp=new UINuevaFactura(detalle);
        //facturaTemp.agregarLineaDetalle(detalle);
        ventanaFactura.agregarLineaDetalle(detalle);
    }
}
