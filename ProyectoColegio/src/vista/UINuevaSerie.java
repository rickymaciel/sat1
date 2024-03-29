/*
 * UINuevaSerie.java
 *
 * Created on 4 de marzo de 2008, 10:06
 */

package vista;

import Datos.Modificacion;
import controlador.CAlta;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.SerieConstancia;

/**
 *
 * @author  Administrador
 */
public class UINuevaSerie extends javax.swing.JFrame 
{
    private Collection series = new ArrayList();
    private Collection tempParcial = new ArrayList();
    private Collection tempTotal = new ArrayList();
    
    /** Creates new form UINuevaSerie */
    public UINuevaSerie() 
    {
        initComponents();
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        this.inicio();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSerie = new javax.swing.JTable();
        jLLocalidad1 = new javax.swing.JLabel();
        jCTipoconstancia = new javax.swing.JComboBox();
        jBGuardar = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLLocalidad2 = new javax.swing.JLabel();
        jLLocalidad3 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTLimite = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jCTipoDeCarga = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion de Series");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasas"));

        jTableSerie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Defecto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSerie.setToolTipText("Series que estan efectivamente cargadas en el sistema");
        jTableSerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSerieMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSerieMouseReleased(evt);
            }
        });
        jTableSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableSerieKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSerieKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSerie);

        jLLocalidad1.setBackground(new java.awt.Color(255, 255, 204));
        jLLocalidad1.setText("Nombre");
        jLLocalidad1.setOpaque(true);
        jLLocalidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLLocalidad1KeyPressed(evt);
            }
        });

        jCTipoconstancia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONSTANCIA PARCIAL", "CONSTANCIA TOTAL" }));
        jCTipoconstancia.setToolTipText("Nombre del tipo de constancia a la que se administrara sus series");
        jCTipoconstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipoconstanciaActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.setToolTipText("Almacena la nueva serie");
        jBGuardar.setEnabled(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBNuevo.setText("Nuevo");
        jBNuevo.setToolTipText("Genera una nueva serie de constancia");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");
        jBModificar.setToolTipText("Modifica la serie, solo es valido para modificar la constancia que por defecto sera la activa al emitir constancias parciales o totales");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.setToolTipText("Cierra esta ventanay vuelve al menu principal");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLLocalidad2.setBackground(new java.awt.Color(255, 255, 204));
        jLLocalidad2.setText("Nombre");
        jLLocalidad2.setOpaque(true);
        jLLocalidad2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLLocalidad2KeyPressed(evt);
            }
        });

        jLLocalidad3.setBackground(new java.awt.Color(255, 255, 204));
        jLLocalidad3.setText("Limite");
        jLLocalidad3.setOpaque(true);
        jLLocalidad3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLLocalidad3KeyPressed(evt);
            }
        });

        jTNombre.setToolTipText("Nombre de la constancia (permite 2 letras como maximo por ej: AA)");
        jTNombre.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTNombre.setEnabled(false);
        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreKeyReleased(evt);
            }
        });

        jTLimite.setToolTipText("Es el limite correspondiente a la serie, es decir no se podran emitir un numero mayor de constancias de esta serie que ellimite indicado (valor maximo: 999999999999999)");
        jTLimite.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTLimite.setEnabled(false);
        jTLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTLimiteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTLimiteKeyReleased(evt);
            }
        });

        jLabel1.setText("Tipo de Carga");

        jCTipoDeCarga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AUTOMATICO", "MANUAL" }));
        jCTipoDeCarga.setToolTipText("Elija como se cargaran los codigos de las constancias que pertenezcan a esta serie.");
        jCTipoDeCarga.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCTipoconstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLLocalidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLLocalidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(jCTipoDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCTipoconstancia)
                    .addComponent(jLLocalidad1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLocalidad3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLLocalidad2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jCTipoDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLLocalidad1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLLocalidad1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLLocalidad1KeyPressed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        if(this.control())
            this.guardar();
        else
            JOptionPane.showMessageDialog(null, "Tiene que cargar todos los campos solicitados", "Faltan Datos", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        // TODO add your handling code here:
        this.jBGuardar.setEnabled(true);
        this.jBModificar.setEnabled(false);
        this.jBNuevo.setEnabled(false);
        this.jTNombre.setEnabled(true);
        this.jTNombre.setText("");
        this.jTNombre.requestFocus();
        this.jTLimite.setText("");
        this.jTLimite.setEnabled(true);
        this.jCTipoDeCarga.setEnabled(true);
        
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        // TODO add your handling code here:
        if(this.controlarDefecto())
            this.modificar();
        else
            JOptionPane.showMessageDialog(null, "Tiene que haber una serie por defecto, seleccione una","Falta serie por defecto", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jLLocalidad2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLLocalidad2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLLocalidad2KeyPressed

    private void jLLocalidad3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLLocalidad3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLLocalidad3KeyPressed

    private void jTNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyPressed
        // TODO add your handling code here:
        /*if(evt.getKeyCode() == 10)
            this.jTLeyenda.requestFocus();*/
        if(evt.getKeyCode() == 27)
            this.dispose();
        
        if(evt.getKeyChar()==10)
            this.jTLimite.requestFocus();
    }//GEN-LAST:event_jTNombreKeyPressed

    private void jTNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyReleased
        // TODO add your handling code here:
        if(this.jTNombre.getText().trim().length() > 2)
        {
            JOptionPane.showMessageDialog(null, "El nombre de la serie no debe pasar de los dos caracteres","Atencion",JOptionPane.INFORMATION_MESSAGE);
            this.jTNombre.setText(this.jTNombre.getText().substring(0, 2));
        }
    }//GEN-LAST:event_jTNombreKeyReleased

    private void jTLimiteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLimiteKeyPressed
        // TODO add your handling code here:        
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE)))){    
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 999999999999999","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTLimite.setText("");
//            this.jCTipoDeCarga.requestFocus();
            evt.consume();
            
            if(evt.getKeyCode()==27)
                this.dispose();
        }

        
}//GEN-LAST:event_jTLimiteKeyPressed

    private void jTLimiteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLimiteKeyReleased
        // TODO add your handling code here:
        if(this.jTLimite.getText().trim().length() > 15){
            JOptionPane.showMessageDialog(null, "El numero maximo que se acepta es 999999999999999","Atencion",JOptionPane.INFORMATION_MESSAGE);
            //this.jTLimite.setText(this.jTNombre.getText().substring(0, 15));
            this.jTLimite.setText("");
        }
}//GEN-LAST:event_jTLimiteKeyReleased

    private void jTableSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSerieKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableSerieKeyPressed

    private void jCTipoconstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoconstanciaActionPerformed
        // TODO add your handling code here:
        this.inicio();
    }//GEN-LAST:event_jCTipoconstanciaActionPerformed

    private void jTableSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSerieKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTableSerieKeyReleased

    private void jTableSerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSerieMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTableSerieMouseClicked

    private void jTableSerieMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSerieMouseReleased
        // TODO add your handling code here:
        int x = this.jTableSerie.getSelectedRow();
        int y = this.jTableSerie.getSelectedColumn();
        if(y == 2)
            this.controlarDefecto(x);
        this.mostrarSerie(this.jTableSerie.getSelectedRow());
    }//GEN-LAST:event_jTableSerieMouseReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UINuevaSerie().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox jCTipoDeCarga;
    private javax.swing.JComboBox jCTipoconstancia;
    private javax.swing.JLabel jLLocalidad1;
    private javax.swing.JLabel jLLocalidad2;
    private javax.swing.JLabel jLLocalidad3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTLimite;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTableSerie;
    // End of variables declaration//GEN-END:variables
    
    private void inicio()
    {
        this.limpiar();
        this.tempParcial.clear();
        this.tempTotal.clear();
        this.series.clear();
        CListar listar = new CListar();
        this.series = listar.hacerListado(new SerieConstancia());
        Iterator it = this.series.iterator();
        while(it.hasNext())
        {
            SerieConstancia s = (SerieConstancia)it.next();
            if(s.getTipoConstancia().equals("P"))
                    tempParcial.add(s);
            else
                    tempTotal.add(s);
            s = null;
        }
        if(String.valueOf(this.jCTipoconstancia.getSelectedItem()).trim().equals("CONSTANCIA PARCIAL"))
            this.cargarTabla(tempParcial);
        else
            this.cargarTabla(tempTotal);
        it = null;
    }
    
    private void limpiar()
   {
       DefaultTableModel modelo = (DefaultTableModel)this.jTableSerie.getModel();
        while(this.jTableSerie.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
   }
    
    private void cargarTabla(Collection objetos)
    {
        int fila = 0;
        DefaultTableModel modelo = (DefaultTableModel)this.jTableSerie.getModel();
        String datos[] = new String[2];
        Iterator it = objetos.iterator();
        while(it.hasNext())
        {
            SerieConstancia s = (SerieConstancia)it.next();
            datos[0] = String.valueOf(s.getIdserie());
            datos[1] = s.getSerie().trim();
            modelo.addRow(datos);
            if(s.getDefecto().trim().equals("S"))
                this.jTableSerie.setValueAt(true, fila, 2);
            else
                this.jTableSerie.setValueAt(false, fila, 2);
            s = null;
            fila++;
        }
        it = null;
        datos = null;
        
    }
    
    private SerieConstancia getSerie(int codigo)
    {
        Iterator it = this.series.iterator();
        SerieConstancia serie = new SerieConstancia();
        while(it.hasNext())
        {
            SerieConstancia s = (SerieConstancia)it.next();
            if(s.getIdserie() == codigo)
                serie = s;
            s = null;
        }
        it = null;
        return serie;
    }
    private void mostrarSerie(int fila)
    {
        int codigo = Integer.parseInt(String.valueOf(this.jTableSerie.getValueAt(fila, 0)));
        SerieConstancia serie = this.getSerie(codigo);
        this.jTNombre.setText(serie.getSerie().trim());
        this.jTLimite.setText(String.valueOf(serie.getLimite()));
        if (serie.getTipoDeCarga().trim().equals("M")){
            this.jCTipoDeCarga.setSelectedItem("MANUAL");
        }
        if  (serie.getTipoDeCarga().trim().equals("A")){
            this.jCTipoDeCarga.setSelectedItem("AUTOMATICO");
        }
        
    }
    
    private void controlarDefecto(int x)
    {
        if(Boolean.parseBoolean(String.valueOf(this.jTableSerie.getValueAt(x, 2))))
            for(int i=0;i<this.jTableSerie.getRowCount();i++)
                if(i != x)
                    this.jTableSerie.setValueAt(false, i, 2);
    }
    
    private boolean controlarDefecto()
    {
        boolean bandera = false;
        boolean b;
        for(int i=0;i<this.jTableSerie.getRowCount();i++)
        {
            b = Boolean.parseBoolean(String.valueOf(this.jTableSerie.getValueAt(i, 2)));
            if(b)
                bandera = true;
        }
        return bandera;
    }
    
    private boolean control()
    {
        boolean bandera = true;
        if(this.jTNombre.getText().trim().length() == 0)
            bandera = false;
        if(this.jTLimite.getText().trim().length() == 0)
            bandera = false;
        // ahora controlo que la nueva serie no exista ya
        Iterator it;
        if(String.valueOf(this.jCTipoconstancia.getSelectedItem()).trim().equals("CONSTANCIA PARCIAL"))
            it = this.tempParcial.iterator();
        else
            it = this.tempTotal.iterator();
        while(it.hasNext())
        {
            SerieConstancia s = (SerieConstancia)it.next();
            if(s.getSerie().trim().equals(this.jTNombre.getText().trim().toUpperCase()))
                bandera = false;
            s = null;
        }
        return bandera;
    }
    
    private void guardar()
    {
        SerieConstancia serie = new SerieConstancia();
        serie.setActivo("S");
        serie.setDefecto("N");        
        if (this.jTLimite.getText().length()>0){
            serie.setLimite(Long.parseLong(this.jTLimite.getText()));
        } else {
            String limite="999999999999999";
            serie.setLimite(Long.parseLong(limite));
        }        
        serie.setSerie(this.jTNombre.getText().trim().toUpperCase());
        if(String.valueOf(this.jCTipoconstancia.getSelectedItem()).trim().equals("CONSTANCIA PARCIAL"))
            serie.setTipoConstancia("P");
        else
            serie.setTipoConstancia("T");
        String tipoCarga="";
        
        if (this.jCTipoDeCarga.getSelectedItem().toString().trim().equals("AUTOMATICO")){
            tipoCarga="A";
        } else {
            if (this.jCTipoDeCarga.getSelectedItem().toString().trim().equals("MANUAL")){
                tipoCarga="M";
            }       
        }
        
        serie.setTipoDeCarga(tipoCarga);
        
        CAlta alta = new CAlta();
        int respuesta = alta.hacerAltaSerie(serie);
        if(respuesta != 0)
            JOptionPane.showMessageDialog(null, "Error al guardar la serie, intente mas tarde","Error de almacenamiento", JOptionPane.ERROR_MESSAGE);
        else
        {
            JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente","Almacenamiento exitoso", JOptionPane.INFORMATION_MESSAGE);
            this.jTNombre.setText("");
            this.jTLimite.setText("");
            this.jTNombre.setEnabled(false);
            this.jTLimite.setEnabled(false);
            this.jCTipoDeCarga.setEnabled(false);            
            this.jBGuardar.setEnabled(false);
            this.jBNuevo.setEnabled(true);
            this.jBModificar.setEnabled(true);
            
            this.inicio();
        }
    }
    
    
    private void modificar()
    {
        Modificacion mod = new Modificacion();
        boolean bandera = true;
        int respuesta;
        
        SerieConstancia serie = new SerieConstancia();
        serie.setIdserie(Integer.parseInt(this.jTableSerie.getValueAt(this.jTableSerie.getSelectedRow(),0).toString()));
        serie.setSerie(this.jTableSerie.getValueAt(this.jTableSerie.getSelectedRow(),1).toString().trim());        
        if(Boolean.parseBoolean(String.valueOf(this.jTableSerie.getValueAt(this.jTableSerie.getSelectedRow(), 2))))
                serie.setDefecto("S");
            else
                serie.setDefecto("N");        
        serie.setLimite(this.getSerie(serie.getIdserie()).getLimite());
        serie.setTipoConstancia(this.getSerie(serie.getIdserie()).getTipoConstancia());
        serie.setActivo("S");
        serie.setSerie(this.jTNombre.getText().trim().toUpperCase());
        if (this.jCTipoDeCarga.getSelectedItem().toString().trim().equals("AUTOMATICO")){
            serie.setTipoDeCarga("A");
        } else {
              if (this.jCTipoDeCarga.getSelectedItem().toString().trim().equals("MANUAL")){
                 serie.setTipoDeCarga("M");
             }       
        }              
        
        System.out.println("NOMRBE SERIE:"+serie.getSerie()+"POR DEFECTO:"+serie.getDefecto());
            
        respuesta = mod.modificar(serie);            
        if(respuesta == 0)
             bandera = false;        

        if(!bandera)
            JOptionPane.showMessageDialog(null, "Error al modificar los datos, intente mas tarde", "Error en la modificacion", JOptionPane.ERROR_MESSAGE);
        else{
            JOptionPane.showMessageDialog(null, "Los datos se modificaron con exito", "Modificacion completada", JOptionPane.INFORMATION_MESSAGE);
            this.jTLimite.setText("");
            this.jTNombre.setText("");
            this.inicio();
        }   
        serie = null;
    
    
    }
    
}
