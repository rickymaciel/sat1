/*
 * UIListadoDeCajas.java
 *
 * Created on 17 de abril de 2008, 16:27
 */

package vista;

import Datos.Consulta;
import Datos.Modificacion;
import controlador.Algoritmos;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Caja;
import negocios.DetalleFactura;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.EncabezadoFactura;
import negocios.EncabezadoPago;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UIListadoDeFacturas extends javax.swing.JDialog {
    private Caja caja;
    private Collection listaDeCajas=new ArrayList();
    private String[] array1TipoDoc;    
    private String[] array2Serie;
    private String[] array3Id;
    /** Creates new form UIListadoDeCajas */
    public UIListadoDeFacturas(java.awt.Frame parent, boolean modal,Caja ca) {
        super(parent, modal);
        caja=ca;
        
        initComponents();
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);        
        this.mostrarDatos();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBImprimir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBSalir = new javax.swing.JButton();
        jBAnular = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLCaja = new javax.swing.JLabel();
        jCCajas = new javax.swing.JComboBox();
        jBImprimir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Facturas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serie Factura", "N� Factura", "Fecha", "Condicion Venta", "Total($)", "Nombre Cliente", "Anulado"
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
        jBImprimir.setText("Copia");
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

        jBAnular.setText("Anular");
        jBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ver facturas de:"));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Todas las Cajas");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Otra Caja");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Caja Actual");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jCCajas.setEnabled(false);
        jCCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCajasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jRadioButton3)
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jLCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton3)
                        .addComponent(jRadioButton2)
                        .addComponent(jCCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jBImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/printer.gif"))); // NOI18N
        jBImprimir1.setText("Original");
        jBImprimir1.setToolTipText("Imprime la caja seleccionada");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(jBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBImprimir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBAnular, jBImprimir, jBSalir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:
       if (this.jTable1.getSelectedRow()>-1){//es decir,si selecciono un elemento de la tabla 
            cExport_thread imprime=new cExport_thread(28,String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)).trim(),String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)).trim()); 
            imprime.start(); 
        }else{ 
            JOptionPane.showMessageDialog(this,"Debe seleccionar una factura de la tabla�","Atencion",JOptionPane.INFORMATION_MESSAGE); 
        }
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jBSalirActionPerformed

    private void jBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularActionPerformed
        if (this.jTable1.getSelectedRow()>-1){//es decir,si selecciono un elemento de la tabla 
            if (String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6)).trim().equals("N")){
                if (caja.getEstado().equals("A")){
                    this.anularFactura(Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0))),Long.parseLong(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1))));                    
                }else{
                    JOptionPane.showMessageDialog(this,"La factura seleccionada no pertenece a una caja abierta\nno podra anularla porque la caja a la que pertenece dicha factura ya ha sido cerrada","No se permite anular", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,"La factura seleccionada ya esta anulada","Ya esta anulada", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{ 
            JOptionPane.showMessageDialog(this,"Debe seleccionar una factura de la tabla�","Atencion",JOptionPane.INFORMATION_MESSAGE); 
        }
        
}//GEN-LAST:event_jBAnularActionPerformed

    private void jCCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCajasActionPerformed
        // TODO add your handling code here:
        this.borrarGrilla();
        Caja ca=new Caja();
        ca.setIdcaja(Long.parseLong(String.valueOf(this.jCCajas.getSelectedItem())));
        this.traerFacturas(ca);
    }//GEN-LAST:event_jCCajasActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        this.jCCajas.setEnabled(false);
        this.jBAnular.setEnabled(false);
        this.traerFacturas();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        this.jCCajas.setEnabled(true);
        this.jBAnular.setEnabled(false);
        Caja ca=new Caja();
        ca.setIdcaja(Long.parseLong(String.valueOf(this.jCCajas.getSelectedItem())));
        this.traerFacturas(ca);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        this.traerFacturas(this.caja);
        this.jBAnular.setEnabled(true);
        this.jCCajas.setEnabled(false);
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

private void jBImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimir1ActionPerformed
// TODO add your handling code here:
        if (this.jTable1.getSelectedRow()>-1){//es decir,si selecciono un elemento de la tabla 
            cExport_thread imprime=new cExport_thread(27,String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)).trim(),String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)).trim());
            imprime.start();
        }else{ 
            JOptionPane.showMessageDialog(this,"Debe seleccionar una factura de la tabla�","Atencion",JOptionPane.INFORMATION_MESSAGE); 
        }
    
}//GEN-LAST:event_jBImprimir1ActionPerformed
    
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBImprimir1;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox jCCajas;
    private javax.swing.JLabel jLCaja;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
 
//    private int cantCajas = 0;
//    private Caja ultimaCaja = new Caja();
    
    public void mostrarDatos(){
        this.cargarComboCajas();
        this.traerFacturas(caja);
        this.jLCaja.setText(caja.getIdcaja() + " Estado: "+caja.getEstado());        
        
    }
    public void cargarComboCajas(){
        this.traerCajas();
        Iterator it = listaDeCajas.iterator();
        while(it.hasNext()){
            Caja c = (Caja)it.next();
            //if (c.getIdcaja()!=this.caja.getIdcaja())
            this.jCCajas.addItem(c.getIdcaja());
        }
    }
    
    private void traerCajas()
    {
       Caja c=new Caja();
       CListar listaCaja=new CListar();
       this.listaDeCajas=listaCaja.hacerListadoCajas();  
       listaCaja = null;
    }
    
    private void traerFacturas(Caja c){
        this.borrarGrilla();
        EncabezadoFactura encf = new EncabezadoFactura();
        encf.setCaja(c);
        CListar listar=new CListar();        
        //System.out.println("LA CAJA QUE ESTA MOSTRANDO ES: "+encf.getCaja().getIdcaja());
        Collection facturas = listar.hacerListado(encf);
        this.mostrarFacturas(facturas);
    }
    
    private void traerFacturas(){//FALTA VER ARA TODAS LAS CAJAS
        this.borrarGrilla();
        CListar listar=new CListar();        
        //System.out.println("LA CAJA QUE ESTA MOSTRANDO ES: "+encf.getCaja().getIdcaja());
        Collection facturas = listar.hacerListadoTodasLasFacturas();
        this.mostrarFacturas(facturas);
    }
       
    private void mostrarFacturas(Collection facturas){
        
        Iterator it = facturas.iterator();
        // ahora obtengo el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        String datos[] = new String[7];
        while(it.hasNext()){
            EncabezadoFactura c = (EncabezadoFactura)it.next();
            datos[0] = String.valueOf(c.getSerieFactura());
            datos[1] = String.valueOf(c.getNumeroFactura());
            
            DateFormat df = DateFormat.getDateInstance();
            datos[2] = String.valueOf(df.format(c.getFecha()));
            
            datos[3] = c.getCondicionVenta().getNombre().trim();
            datos[4] = String.valueOf(c.getTotal());
            datos[5] = c.getNombreCliente().trim();
            datos[6] = c.getAnulado().trim();            
            modelo.addRow(datos);
        }
    }
    
    public void borrarGrilla()
    {
        DefaultTableModel modelo = (DefaultTableModel)this.jTable1.getModel();
        while(this.jTable1.getRowCount() != 0)
                modelo.removeRow(0);
    }
    
    private void anularFactura(int ser,Long nro){        
        Modificacion modif=new Modificacion();
        EncabezadoFactura enca=new EncabezadoFactura();
        enca.setSerieFactura(ser);
        enca.setNumeroFactura(nro);
        
        int respuesta=modif.anularFactura(enca);
        
        if (respuesta!=0){
            JOptionPane.showMessageDialog(this,"La Factura: "+enca.getSerieFactura()+"-"+enca.getNumeroFactura()+" a sido anulada","Anulacion de Factura",JOptionPane.INFORMATION_MESSAGE);
            //no esta en funcionamiento,se debe arreglar la clase Algoritmos
            this.ponerFacturaEnCeroDeDocumentosAsociados(enca);
//            JOptionPane.showMessageDialog(this,"Verifique si la factura anulada "+enca.getSerieFactura()+"-"+enca.getNumeroFactura()+"\ntiene documentos asociados como CT,CP,Pago de Matricula\nde ser asi anulelos o asigneles Nro de Factura CERO para poder facturarlos\nen otra factura diferente","IMPORTANTE!",JOptionPane.WARNING_MESSAGE);
 
            this.mostrarDatos();
            enca=null;
        }else{
            JOptionPane.showMessageDialog(this,"No se pudo anular la Factura, seguira siendo NO ANULADA","Error en la Anulacion",JOptionPane.ERROR_MESSAGE);
        }
    }
    //LEERRRRRRRRRRRR
    //el metodo: ponerFacturaEnCeroDeDocumentosAsociados no se usa
    //porque no esta funcinando la clase Algortmos que trae la identificacion
    //de documentos asociados a partir de la cadena de detalle de factura que
    //se le manda al objeto para que traiga encabezado de Pago,CT o CT
    //de esa manera se daria la puesta en cero a la factura asociada a esos
    //documentos
    private void ponerFacturaEnCeroDeDocumentosAsociados(EncabezadoFactura en){
        Consulta con=new Consulta();
        Algoritmos sacarCodigo=new Algoritmos();
        Collection detallesDeLaFactura=con.getDetalleFactura(en);
        
        Iterator it = detallesDeLaFactura.iterator();
        // ahora obtengo el modelo de la tabla
        String detalle="";
        
        this.array1TipoDoc=new String[detallesDeLaFactura.size()];
        this.array2Serie=new String[detallesDeLaFactura.size()];
        this.array3Id=new String[detallesDeLaFactura.size()];
//        boolean chequeDetalleDistinto=true;
        
        
        StringBuffer tipoDocumento = new StringBuffer();
        int i=0;
        
        
        while(it.hasNext()){
            DetalleFactura d = (DetalleFactura)it.next();
//            if (detalle.equals(d.getDetalle().trim())){
//                chequeDetalleDistinto=false;
//                detalle=d.getDetalle().trim();
//            }else{
//                chequeDetalleDistinto=true;
//                detalle=d.getDetalle().trim();
//            }
            //verificar si el detalle comienza con la siguiente cadena:
            //CP: CT: CU:  si es alguno de estos significa que es 
            //un documento relacionado en la cadena
            
            
            if (d.getDetalle().length()>0){
                tipoDocumento.append(d.getDetalle().charAt(0));
                tipoDocumento.append(d.getDetalle().charAt(1));
                tipoDocumento.append(d.getDetalle().charAt(2));

    //            System.out.println("LINEA DETALLE A LEER TIPODOC 3 LETRAS: "+tipoDocumento);

                if (tipoDocumento.toString().equals("CP:")){//si es CP: recien analiza que serie y codigo tiene
                    EncabezadoCP eCP=new EncabezadoCP();
                    eCP=sacarCodigo.getEncabezadoCP(d.getDetalle().trim());                

                    if (!sePusoEnCeroElDocumento(tipoDocumento.toString(),String.valueOf(eCP.getSerieCP()).trim(),String.valueOf(eCP.getCodigoCP()).trim())){
                            Modificacion ponerFacturaDeCPenCero=new Modificacion();
                            int resp=ponerFacturaDeCPenCero.modificarPonerCPconFacturaEnCero(eCP.getSerieCP(), eCP.getCodigoCP());
                            if (resp!=0){
                                JOptionPane.showMessageDialog(this,"La Constancia Parcial: "+eCP.getSerieCP()+":"+eCP.getCodigoCP()+" podra ser facturada en otro documento de factura","Documento CP podra ser facturado",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(this,"La Constancia Parcial: "+eCP.getSerieCP()+":"+eCP.getCodigoCP()+" no podra ser facturada en otro documento de factura, debera crear uno nuevo para facturarlo","Error!",JOptionPane.ERROR_MESSAGE);
                            }
                            this.array1TipoDoc[i]=(tipoDocumento.toString());
                            this.array2Serie[i]=(eCP.getSerieCP());
                            this.array3Id[i]=(String.valueOf(eCP.getCodigoCP()));
                            ponerFacturaDeCPenCero=null;
                            i++;
                    }           
    //                System.out.println("SE ENCONTRO OK: "+tipoDocumento);
                }
                if (tipoDocumento.toString().equals("CT:")){//si es CP: recien analiza que serie y codigo tiene
                    EncabezadoCT eCT=new EncabezadoCT();
                    eCT=sacarCodigo.getEncabezadoCT(d.getDetalle().trim());                

                    if (!sePusoEnCeroElDocumento(tipoDocumento.toString(),String.valueOf(eCT.getSerieCT()).trim(),String.valueOf(eCT.getCodigoCT()).trim())){
                            Modificacion ponerFacturaDeCTenCero=new Modificacion();
                            int resp=ponerFacturaDeCTenCero.modificarPonerCTconFacturaEnCero(eCT.getSerieCT(), eCT.getCodigoCT());
                            if (resp!=0){
                                JOptionPane.showMessageDialog(this,"La Constancia Total: "+eCT.getSerieCT()+":"+eCT.getCodigoCT()+" podra ser facturada en otro documento de factura","Documento CT podra ser facturado",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(this,"La Constancia Total: "+eCT.getSerieCT()+":"+eCT.getCodigoCT()+" no podra ser facturada en otro documento de factura, debera crear uno nuevo para facturarlo","Error!",JOptionPane.ERROR_MESSAGE);
                            }
                            this.array1TipoDoc[i]=(tipoDocumento.toString());
                            this.array2Serie[i]=(eCT.getSerieCT());
                            this.array3Id[i]=(String.valueOf(eCT.getCodigoCT()));
                            ponerFacturaDeCTenCero=null;
                            i++;
                    }           
    //                System.out.println("SE ENCONTRO OK: "+tipoDocumento);
                }
                if (tipoDocumento.toString().equals("CU:")){//si es CP: recien analiza que serie y codigo tiene
                    EncabezadoPago eP=new EncabezadoPago();
                    eP=sacarCodigo.getEncabezadoPago(d.getDetalle().trim()); 


    //                JOptionPane.showMessageDialog(this,"detalle pasado: "+d.getDetalle(),"==",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(this,"encabezado Pago obtenido IDENCABEZADO: "+eP.getIdencabezado(),"==",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(this,"encabezado Pago obtenido MATRICULA: "+eP.getMatricula(),"==",JOptionPane.INFORMATION_MESSAGE);
                    if (!sePusoEnCeroElDocumento(tipoDocumento.toString(),"PAGO",String.valueOf(eP.getIdencabezado()).trim())){
                            Modificacion ponerFacturaDePagoenCero=new Modificacion();
                            int resp=ponerFacturaDePagoenCero.modificarPonerEncabezadoPagoconFacturaEnCero(eP.getIdencabezado());
                            if (resp!=0){
                                JOptionPane.showMessageDialog(this,"El documento de pago de matricula: "+eP.getIdencabezado()+" podra ser facturado en otro documento de factura","Documento de Pago podra ser facturado",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(this,"El documento de pago de matricula: "+eP.getIdencabezado()+" no podra ser facturado en otro documento de factura\ngenere un nuevo documento de pago","Error!",JOptionPane.ERROR_MESSAGE);
                            }
                            this.array1TipoDoc[i]=(tipoDocumento.toString());
                            this.array2Serie[i]=("PAGO");
                            this.array3Id[i]=(String.valueOf(eP.getIdencabezado()));
                            ponerFacturaDePagoenCero=null;
                            i++;
                    }           
    //                System.out.println("SE ENCONTRO OK: "+tipoDocumento);
                }
                //pongo en cero al tipo de documento
                tipoDocumento.delete(0, tipoDocumento.length());
            }
            
            
            
        
        
        
        }
    }
    
    
    private boolean sePusoEnCeroElDocumento(String tipoDoc,String serie, String codigo){
        boolean sePusoEnCero=false;
        
        for (int i=0;i<this.array1TipoDoc.length;i++){
            if (array1TipoDoc[i]!=null){//solo entra si no es nulo el regitro del array
                if(tipoDoc.equals("CP:") && this.array1TipoDoc[i].equals("CP:")){
                    if(this.array2Serie[i].equals(serie) && this.array3Id[i].equals(codigo)){
                        sePusoEnCero=true;
//                        System.out.println("SE PUSO EN CERO LA CP, LAS SIGUIENTES LINEAS DE DETALLE NO ENTRARAN MAS AQUI ");
                    }
                }
                if(tipoDoc.equals("CT:") && this.array1TipoDoc[i].equals("CT:")){
                    if(this.array2Serie[i].equals(serie) && this.array3Id[i].equals(codigo)){
                        sePusoEnCero=true;
                    }
                }
                if(tipoDoc.equals("CU:") && this.array1TipoDoc[i].equals("CU:")){
                    if(this.array3Id[i].equals(codigo)){
                        sePusoEnCero=true;
                    }
                }
            }
        }
        return sePusoEnCero;
    }
    /**
     * Este metodo no esta siendo usado,funciona,pero le falta
     * determinar si en la factura que se pretende cambiar su numero
     * hay o no constancias parciales o totales que ya tengan asignado
     * una serie y numero de factura
     * si es asi, deberan ser moficadas tambien, en dichos campos
     */
    private void cambiarNumeroDeFactura(){
        if (this.jTable1.getSelectedRow()>-1){//es decir,si selecciono un elemento de la tabla 
            if (String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6)).trim().equals("N")){                
                if (caja.getEstado().equals("A")){
                    int respu=JOptionPane.showConfirmDialog(this,"Esta seguro de hacer eta operacion, puede provocar errores graves sino tiene claro lo que esta haciendo,\nEsta por modificar el numero de factura que ya se ha facturado\nLuego de cerrar la caja,no podra volver a hacer esta operacion", "CUIDADO, Operacion Critica!",JOptionPane.YES_NO_OPTION);
                    if (respu==JOptionPane.OK_OPTION){
                        EncabezadoFactura encF1=new EncabezadoFactura();
                        EncabezadoFactura encF2=new EncabezadoFactura();

                        encF1.setSerieFactura(Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0))));
                        encF1.setNumeroFactura(Long.parseLong(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1))));
                        encF2.setSerieFactura(encF1.getSerieFactura());

                        String respNuevoNroFac=JOptionPane.showInputDialog(this, "Ingrese el nuevo numero de factura sin ceros no significativos...", "");

                        if (respNuevoNroFac!=null){
                            try{
                                Long.parseLong(respNuevoNroFac);
                                encF2.setNumeroFactura(Long.parseLong(respNuevoNroFac.trim()));                              
                                //Se hace la modificaion del numero de factura
                                Modificacion modifNroFactura=new Modificacion();
                                int modificados=modifNroFactura.modificarNumeroDeFactura(encF1, encF2);                                
                                
                                if (modificados>0){
                                    JOptionPane.showMessageDialog(this,"Se modifico correctamente el numero de factura", "Modificacion de Numero de Factura",JOptionPane.INFORMATION_MESSAGE);
                                    this.mostrarDatos();
                                    encF1=null;
                                    encF2=null;
                                }else{
                                    if (modificados==0){
                                        JOptionPane.showMessageDialog(this,"El numero de factura que esta ingresando pertenece a otra factura\nNo se puede modificar", "Modificacion de Numero de Factura",JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }                                
                            }catch (NumberFormatException ne){
                                JOptionPane.showMessageDialog(this,"Debe ingresar un NUMERO ENTERO, no incluir letras ni simbolos\nNo se pudo cambiar el numero de factura", "Valor Incorrecto!",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"La factura seleccionada no pertenece a una caja abierta\nno podra cambiarse su numero porque la caja a la que pertenece dicha factura ya ha sido cerrada","No se permite modificar", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,"La factura seleccionada esta anulada","No se puede modificar", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{ 
            JOptionPane.showMessageDialog(this,"Debe seleccionar una factura de la tabla�","Atencion",JOptionPane.INFORMATION_MESSAGE); 
        }
    }
}

