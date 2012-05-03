/*
 * UIAdministrarHabilitaciones.java
 *
 * Created on 11 de enero de 2008, 16:32
 */

package vista;

import Datos.Modificacion;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author  Administrador
 */
public class UIAdministrarHabilitaciones extends javax.swing.JDialog
{
    
    /** Creates new form UIAdministrarHabilitaciones */
    public UIAdministrarHabilitaciones(java.awt.Frame parent, boolean modal)
    {
        initComponents();
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
                this.mostrarFechas();
                this.cantidadMatriculados();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTMesesDeTolerancia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTMesesDeTolerancia1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTMesesDeTolerancia2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTMesesDeTolerancia3 = new javax.swing.JTextField();
        jBAceptar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTMesesDeTolerancia4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTMesesDeTolerancia5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTMesesDeTolerancia6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion de habilitaciones");
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tolerancia"));
        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Cuotas de Tolerancia:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel1.setOpaque(true);

        jTMesesDeTolerancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTMesesDeToleranciaKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Fecha Actual:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel2.setOpaque(true);

        jTMesesDeTolerancia1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTMesesDeTolerancia1.setEnabled(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Se habilitan a los que pagaron el mes:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel3.setOpaque(true);

        jTMesesDeTolerancia2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTMesesDeTolerancia2.setEnabled(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("del a\u00f1o:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel4.setOpaque(true);

        jTMesesDeTolerancia3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTMesesDeTolerancia3.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTMesesDeTolerancia1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTMesesDeTolerancia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTMesesDeTolerancia2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTMesesDeTolerancia3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTMesesDeTolerancia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTMesesDeTolerancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTMesesDeTolerancia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTMesesDeTolerancia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jBAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flechaDerecha.gif")));
        jBAceptar.setText("Aplicar Politica de Habilitaci\u00f3n");
        jBAceptar.setEnabled(false);
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen"));
        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Cantidad Actual de No Habilitados:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel5.setOpaque(true);

        jTMesesDeTolerancia4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTMesesDeTolerancia4.setEnabled(false);

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Cantidad Actual de Habilitados:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel6.setOpaque(true);

        jTMesesDeTolerancia5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTMesesDeTolerancia5.setEnabled(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("Total de Matriculados:");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 102), null));
        jLabel7.setOpaque(true);

        jTMesesDeTolerancia6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTMesesDeTolerancia6.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTMesesDeTolerancia5)
                    .addComponent(jTMesesDeTolerancia4)
                    .addComponent(jTMesesDeTolerancia6, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addGap(145, 145, 145))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTMesesDeTolerancia5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTMesesDeTolerancia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTMesesDeTolerancia6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(jBAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
    // TODO add your handling code here:
        Date fecha = this.calcularFecha();
//        System.out.println("fecha apartir de la cual tengo que habilitar : "+fecha);
        Modificacion modificacion = new Modificacion();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        String fec = String.valueOf(cal.get(Calendar.YEAR))+"-"+String.valueOf(cal.get(Calendar.MONTH)+1)+"-"+String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
//        System.out.println("fecha pago :"+fec);
        int cant = modificacion.modEncabezadoPago(fec,fecha);
//        System.out.println("cantidad de modificados :"+cant);
        if(cant > 0) JOptionPane.showMessageDialog(this,"Se aplico correctamente la politica de habilitacion","Atencion",JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(this,"Ocurrio un error","Atencion",JOptionPane.ERROR_MESSAGE);
        this.cantidadMatriculados();    
        
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jTMesesDeToleranciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMesesDeToleranciaKeyPressed
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(this,"Debe introducir un valor valido ej: 12","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTMesesDeTolerancia.setText("");
            this.jTMesesDeTolerancia.requestFocus();
            evt.consume();
        }
        if(evt.getKeyCode() == 10)
        {
            this.fechaHabilitacion();
            this.cantidadMatriculados();
            this.jBAceptar.setEnabled(true);
            this.jBAceptar.requestFocus();
        }
    }//GEN-LAST:event_jTMesesDeToleranciaKeyPressed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBSalirActionPerformed
    {//GEN-HEADEREND:event_jBSalirActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
               UIAdministrarHabilitaciones dialog = new UIAdministrarHabilitaciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTMesesDeTolerancia;
    private javax.swing.JTextField jTMesesDeTolerancia1;
    private javax.swing.JTextField jTMesesDeTolerancia2;
    private javax.swing.JTextField jTMesesDeTolerancia3;
    private javax.swing.JTextField jTMesesDeTolerancia4;
    private javax.swing.JTextField jTMesesDeTolerancia5;
    private javax.swing.JTextField jTMesesDeTolerancia6;
    // End of variables declaration//GEN-END:variables
    
    public void mostrarFechas()
    {
        Date hoy = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        this.jTMesesDeTolerancia1.setText(sdf.format(hoy));
        hoy = null;
        sdf = null;
    }
    
     public Date calcularFecha()
    {
        int cantidad = (-Integer.parseInt(this.jTMesesDeTolerancia.getText().trim()));
        System.out.println("cantidad a restar : "+cantidad);
        Date resp = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(resp);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.add(Calendar.MONTH,cantidad);
        resp = cal.getTime();
        System.out.println("fecha modificada :"+resp);
        return resp;
    }
    
    public void fechaHabilitacion()
    {
        Date hasta = this.calcularFecha();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hasta);
        this.jTMesesDeTolerancia2.setText(String.valueOf(cal.get(Calendar.MONTH)+1));
        this.jTMesesDeTolerancia3.setText(String.valueOf(cal.get(Calendar.YEAR)));
        
    }
    
    public void cantidadMatriculados()
    {
        CListar listar = new CListar();
        int habilitados = listar.cantidadMat("S");
        int nohabilitados = listar.cantidadMat("N");
        this.jTMesesDeTolerancia5.setText(String.valueOf(habilitados));
        this.jTMesesDeTolerancia4.setText(String.valueOf(nohabilitados));
        this.jTMesesDeTolerancia6.setText(String.valueOf(habilitados+nohabilitados));
    }
    
    
}