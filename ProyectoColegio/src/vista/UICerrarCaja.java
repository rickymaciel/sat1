/*
 * UICerrarCaja.java
 *
 * Created on 10 de enero de 2008, 12:56
 */

package vista;

import Datos.Modificacion;
import controlador.Algoritmos;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.swing.JOptionPane;
import negocios.Caja;
import negocios.Usuario;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UICerrarCaja extends javax.swing.JFrame
{
    private UIMenu menu = new UIMenu();
    private Caja ultimaCaja = new Caja();
    private Collection cp = new ArrayList();
    private Collection ct = new ArrayList();
    private Collection cuotas = new ArrayList();
    
    public UICerrarCaja(){
        
    }
    
    /** Creates new form UICerrarCaja */
    public UICerrarCaja(UIMenu menu,Caja ultCaja)
    {
        this.menu = menu;
        this.ultimaCaja = ultCaja;
        initComponents();
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
        this.llenarDatos();
        this.jBImprimir.setEnabled(false);
        this.jBCerrar.setEnabled(true);
        this.verificarDocumentos();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBCerrar = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabelAviso = new javax.swing.JLabel();
        jButtonVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cerrar Caja");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Caja"));

        jLabel3.setBackground(new java.awt.Color(255, 255, 153));
        jLabel3.setText("Fecha de Apertura:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);

        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setBackground(new java.awt.Color(255, 255, 153));
        jLabel5.setText("Hora de Apertura:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setOpaque(true);

        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setBackground(new java.awt.Color(255, 255, 153));
        jLabel12.setText("Usuario:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setOpaque(true);

        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setBackground(new java.awt.Color(255, 255, 153));
        jLabel13.setText("Total:");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setOpaque(true);

        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setBackground(new java.awt.Color(255, 255, 153));
        jLabel8.setText("ID Caja:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jBCerrar.setText("Cerrar");
        jBCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarActionPerformed(evt);
            }
        });

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabelAviso.setFont(new java.awt.Font("Arial", 0, 18));
        jLabelAviso.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAviso.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jButtonVer.setText("Ver...");
        jButtonVer.setEnabled(false);
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jBCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButtonVer)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAviso, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButtonVer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
// TODO add your handling code here:
        cExport_thread imprime=new cExport_thread(29,String.valueOf(this.ultimaCaja.getIdcaja()));
        imprime.start();
}//GEN-LAST:event_jBImprimirActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBCancelarActionPerformed
    {//GEN-HEADEREND:event_jBCancelarActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarActionPerformed
       this.cargarCaja();
       this.guardarDatos();
       this.jBImprimir.setEnabled(true);
       this.jBCerrar.setEnabled(false);
    }//GEN-LAST:event_jBCerrarActionPerformed

private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
// TODO add your handling code here:
    this.verImpagas();
}//GEN-LAST:event_jButtonVerActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new UICerrarCaja().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBCerrar;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    Date fecha = new Date();
    Caja caja = new Caja();
      
    
    public void llenarDatos()
    {
        //defino la los objetos de tipo date para mostrar la fecha
        DateFormat dias = DateFormat.getDateInstance(); 
        DateFormat horas = DateFormat.getTimeInstance();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        //muestro los campos fecha y hora 
        this.jLabel4.setText(String.valueOf(dias.format(ultimaCaja.getFechaapertura())));     
        this.jLabel7.setText(String.valueOf(ultimaCaja.getIdcaja()));
        this.cargarTotal();
        this.jLabel10.setText(nf.format(ultimaCaja.getTotal()));
        this.jLabel6.setText(String.valueOf(horas.format(ultimaCaja.getFechaapertura())));
        this.jLabel11.setText(menu.usuario.getNombre().trim());
    }
    
    /**
     * Este metodo se encarga de verificar si existen documentos sin facturar
     * si existen, aparece el texto "Hay Documentos sin Facturar" y elboton Ver... se habilita
     */
    private void verificarDocumentos()
    {
        Algoritmos algoritmos = new Algoritmos();
        // limpio las colecciones
        this.cp.clear();
        this.ct.clear();
        this.cuotas.clear();
        // verifico si hay documentos impagos
        this.cp = algoritmos.devolverCPImpaga();
        this.ct = algoritmos.devolverCTImpaga();
        this.cuotas = algoritmos.devolverCuotaImpaga();
        if((this.cp.size() != 0) || (this.ct.size() != 0) || (this.cuotas.size() != 0))
        {
            this.jLabelAviso.setText("Hay Documentos sin Facturar");
            this.jButtonVer.setEnabled(true);
            this.jBCerrar.setEnabled(false);
        }
    }
    
    public void habilitarCerrarCaja()
    {
        this.jBCerrar.setEnabled(true);
        this.jLabelAviso.setText("");
        this.jButtonVer.setEnabled(false);
    }
    
    private void verImpagas()
    {
        UIMostrarNoFacturadas mostrar = new UIMostrarNoFacturadas(this,true);
        mostrar.mostrar(cp, ct, cuotas, this);
        mostrar.setVisible(true);
    }
    
    public void cargarTotal()
    {//cargo el total y lo guardo en el objeto caja
        CListar listar = new CListar();
        ultimaCaja.setTotal(listar.totalCaja(ultimaCaja));
        if(ultimaCaja.getTotal() == 1.0)
        {
            ultimaCaja.setTotal(0.0);
        }
        listar = null;
    }
    
    public void cargarCaja()
    {
        //obtengo fecha corecta:
        
        Algoritmos obtieneFechaSistema=new Algoritmos();
        Timestamp fechaCorrectaDeSistema=obtieneFechaSistema.obtenerFechayHoraDeSistema();
            
        
        //defino la forma en que quiero que guarde la fecha aaaa-mm-dd 00:00:00.00
        //Timestamp timestamp = new Timestamp(new Date().getTime());
        ultimaCaja.setFechacierre(fechaCorrectaDeSistema);//cargo la fecha en el objeto caja
        Usuario user = new Usuario();
        user.setIdusuario(menu.usuario.getIdusuario());
        ultimaCaja.setUsuariocierre(user);
        ultimaCaja.setEstado("C");
    }
    
    public void guardarDatos()
    {
        Modificacion modificacion = new Modificacion();
        int resp = modificacion.modificar(ultimaCaja);
        if(resp == 1)
        {
            JOptionPane.showMessageDialog(null,"Se ha guardado correctamente los datos","Atencion",JOptionPane.INFORMATION_MESSAGE);
            this.menu.inicializarVentanas();
//            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Realice la operacion nuevamente, ha ocurrido un error","Atencion",JOptionPane.ERROR_MESSAGE);        }
            modificacion = null;
    }
}
