/*
 * UITasasAplicables.java
 *
 * Created on 25 de febrero de 2008, 15:33
 */

package vista;

import Datos.Baja;
import Datos.Modificacion;
import controlador.CAlta;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Documento;
import negocios.Tasa;
import negocios.TasaAplicable;

/**
 *
 * @author  Administrador
 */
public class UITasasAplicables extends javax.swing.JFrame 
{
    private Collection tasas = new ArrayList();
    private Collection tasasAplicables = new ArrayList();
    private Collection documentos = new ArrayList();
    private Collection nuevasTasas = new ArrayList();
    private boolean guardar = true;
    private boolean modificar = false;
    
    /** Creates new form UITasasAplicables */
    public UITasasAplicables() 
    {
        initComponents();
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        this.llenarTablas();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTasas = new javax.swing.JTable();
        jBAgregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNuevasTasas = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDocumentos = new javax.swing.JTable();
        jLLocalidad1 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion de Tasas Aplicables");
        setResizable(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasas"));

        jTableTasas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableTasas);

        jBAgregar.setText("->");
        jBAgregar.setEnabled(false);
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevas Tasas"));

        jTableNuevasTasas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNuevasTasas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableNuevasTasasKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableNuevasTasas);

        jBGuardar.setText("Guardar");
        jBGuardar.setEnabled(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBNuevo.setText("Nuevo");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos"));

        jTableDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDocumentosMouseClicked(evt);
            }
        });
        jTableDocumentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableDocumentosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDocumentos);

        jLLocalidad1.setBackground(new java.awt.Color(255, 255, 204));
        jLLocalidad1.setText("Nombre");
        jLLocalidad1.setOpaque(true);
        jLLocalidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLLocalidad1KeyPressed(evt);
            }
        });

        jTNombre.setToolTipText("ingrese letras para realizar un filtrado del listado.");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAgregar)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(jLLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jBAgregar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:
        int fila = this.jTableTasas.getSelectedRow();
        int codigo = Integer.parseInt(String.valueOf(this.jTableTasas.getValueAt(fila, 0)));
        if(codigo != 0)
            this.agregarTasa();
        else 
        {
            this.limpiarPlanosTasas();
            this.tasasAplicables.clear();
            this.limpiarTasas();
            this.llenarTasas();
        }
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jTableNuevasTasasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableNuevasTasasKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 27)
            this.dispose();
        if(evt.getKeyCode() == 127)
            this.quitarTasa();
    }//GEN-LAST:event_jTableNuevasTasasKeyPressed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        if(this.control())
            if(this.guardar)
                this.guardar();
            else
                this.modificarTasasAplicables();
        else
            JOptionPane.showMessageDialog(null,"Debe llenar los campos Nombre y leyenda","Faltan datos",JOptionPane.ERROR_MESSAGE);
         
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        // TODO add your handling code here:
        this.jBGuardar.setEnabled(true);
        this.jBAgregar.setEnabled(true);
        this.modificar = false;
        this.guardar = true;
        this.jTNombre.setEnabled(true);
        this.jTNombre.requestFocus();
        this.limpiarPlanosTasas();
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        // TODO add your handling code here:
        this.jBGuardar.setEnabled(true);
        this.jBAgregar.setEnabled(true);
        this.jBModificar.setEnabled(false);
        this.guardar = false;
        this.modificar = true;
        this.jTNombre.setEnabled(true);
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        this.llenarTablas();
        this.jBGuardar.setEnabled(false);
        this.jBAgregar.setEnabled(false);
        this.jBModificar.setEnabled(true);
        //this.guardar = false;
        //this.modificar = true;
        this.limpiarPlanosTasas();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTableDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDocumentosMouseClicked
        // TODO add your handling code here:
        this.verDocumento();
}//GEN-LAST:event_jTableDocumentosMouseClicked

    private void jTableDocumentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDocumentosKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 27)
            this.dispose();
        if(evt.getKeyCode() == 127)
            this.quitarTipoDocumento();
}//GEN-LAST:event_jTableDocumentosKeyPressed

    private void jLLocalidad1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLLocalidad1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLLocalidad1KeyPressed

    private void jTNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyPressed
        // TODO add your handling code here:
/*        if(evt.getKeyCode() == 10)
            this.jTLeyenda.requestFocus();*/
        if(evt.getKeyCode() == 27)
            this.dispose();
    }//GEN-LAST:event_jTNombreKeyPressed

    private void jTNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UITasasAplicables().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLLocalidad1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTableDocumentos;
    private javax.swing.JTable jTableNuevasTasas;
    private javax.swing.JTable jTableTasas;
    // End of variables declaration//GEN-END:variables
    
    private void llenarTablas()
   {
       CListar listar = new CListar();
       this.tasas.clear();
       this.tasasAplicables.clear();
       this.documentos.clear();
       this.nuevasTasas.clear();
       
       // hay que obtener la coleccion de tasas
       this.tasas = listar.hacerListado(new Tasa());
       // ahora hay que traer las tasas aplicables ya cargadas
       this.tasasAplicables = listar.hacerListadoTasaAplicable(new TasaAplicable());
       // por ultimo hay que obtener los tipo de documentos
       this.documentos = listar.hacerListado(new Documento());
       
       this.llenarTasas();
       this.llenarDocumentos();
   }
   
   private void llenarTasas()
   {
       Iterator it = this.tasas.iterator();
       this.limpiarTasas();
       DefaultTableModel modelo = (DefaultTableModel)this.jTableTasas.getModel();
       String datos[] = new String[2];
       Tasa t = new Tasa();
       while(it.hasNext())
       {
           t = (Tasa)it.next();
           datos[0] = String.valueOf(t.getIdtasa());
           datos[1] = t.getDenominacion();
           modelo.addRow(datos);
       }
       datos = null;
       it = null;
       t = null;
   }
   
   private void llenarDocumentos()
   {
       Iterator it = this.documentos.iterator();
       this.limpiarDocumentos();
       DefaultTableModel modelo = (DefaultTableModel)this.jTableDocumentos.getModel();
       String datos[] = new String[2];
       Documento d = new Documento();
       while(it.hasNext())
       {
           d = (Documento)it.next();
           datos[0] = String.valueOf(d.getIdDocumento());
           datos[1] = d.getDescripcion();
           modelo.addRow(datos);
       }
       datos = null;
       it = null;
       d = null;
   }
   
   private void limpiarDocumentos()
   {
       DefaultTableModel modelo = (DefaultTableModel)this.jTableDocumentos.getModel();
        while(this.jTableDocumentos.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
   }
   
   private void limpiarTasas()
   {
       DefaultTableModel modelo = (DefaultTableModel)this.jTableTasas.getModel();
        while(this.jTableTasas.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
   }
   
   private void limpiarPlanosTasas()
   {
       DefaultTableModel modelo = (DefaultTableModel)this.jTableNuevasTasas.getModel();
        while(this.jTableNuevasTasas.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
   }
   
   private void agregarTasa()
   {
       DefaultTableModel modelo = (DefaultTableModel)this.jTableNuevasTasas.getModel();
       Tasa tasa = this.obtenerTasa();
       String datos[] = new String[1];
       datos[0] = tasa.getDenominacion();
       modelo.addRow(datos);
       this.nuevasTasas.add(tasa);
   }

    private void modificarTasasAplicables() 
    {
        boolean bandera = true;
       Modificacion mod = new Modificacion();
       // primero modifico el tipo de documento
       Documento documento = new Documento();
       Documento d = new Documento();
       
       Iterator it = this.documentos.iterator();
       int indice;
       while(it.hasNext())
       {
           d = (Documento)it.next();
           indice = Integer.parseInt(String.valueOf(this.jTableDocumentos.getValueAt(this.jTableDocumentos.getSelectedRow(),0)));
           if(d.getIdDocumento() == indice)
               documento = d;
           d = null;
       }
       it = null;
       documento.setDescripcion(this.jTNombre.getText().trim().toUpperCase());
       int respuesta = mod.modificar(documento);
       if(respuesta == 0)
           JOptionPane.showMessageDialog(null,"Error al modificar los datos, intente mas tarde"," Error en la base de datos",JOptionPane.ERROR_MESSAGE);
       else
       {
           // ahora modifico las tasas asignadas a ese tipo de documento
           // primero borro las tasas asignadas
           Baja baja = new Baja();
           TasaAplicable tasaAplicable = new TasaAplicable();
           tasaAplicable.setIdTipoConstancia(documento.getIdDocumento());
           tasaAplicable.setExiste("S");
           respuesta = baja.eliminar(tasaAplicable);
           // ahora agrego las nuevas tasas a la tea
           CAlta alta = new CAlta();
           Tasa tasa = new Tasa();
           for(int i=0;i<this.jTableNuevasTasas.getRowCount();i++)
           {
               tasa = this.obtenerTasaNombre(String.valueOf(this.jTableNuevasTasas.getValueAt(i, 0)).trim());
               tasaAplicable.setIdtasa(tasa.getIdtasa());
               int res = alta.hacerAlta(tasaAplicable);
               if( res != 0)
                   bandera = false;
           }
               
           if(!bandera)
               JOptionPane.showMessageDialog(null,"Error al actualizar los datos, intente de nuevo mas tarde","Error en la actualizacion",JOptionPane.ERROR_MESSAGE);
           else
           {
               this.llenarTablas();
               this.jBGuardar.setEnabled(false);
               this.jBModificar.setEnabled(true);
               this.jTNombre.setEnabled(false);
               this.jBAgregar.setEnabled(false);
               this.modificar = false;
               this.guardar = true;
               this.jTNombre.setText("");
               this.limpiarPlanosTasas();
           }
       }
    }
   
   private void quitarTasa()
   {
       DefaultTableModel modelo = (DefaultTableModel)this.jTableNuevasTasas.getModel();
       int fila = Integer.parseInt(String.valueOf(this.jTableNuevasTasas.getSelectedRow()));
       Tasa tasa = this.obtenerTasaNombre(String.valueOf(this.jTableNuevasTasas.getValueAt(fila, 0)));
       modelo.removeRow(this.jTableNuevasTasas.getSelectedRow());
       // ahaora quito el objeto de la coleccion
       this.nuevasTasas.remove(tasa);
       tasa = null;
   }
   
   private Tasa obtenerTasa()
   {
       Tasa tasa = new Tasa();
       int codigo;
       Tasa t = new Tasa();
       Iterator it = this.tasas.iterator();
       while(it.hasNext())
       {
           t = (Tasa)it.next();
           codigo = Integer.parseInt(String.valueOf(this.jTableTasas.getValueAt(this.jTableTasas.getSelectedRow(),0)));
           if(codigo == t.getIdtasa())
               tasa = t;
       }
       t = null;
       it = null;
       return tasa;
   }
   
   private Tasa obtenerTasa(int codigo)
   {
       Tasa tasa = new Tasa();
       Tasa t = new Tasa();
       Iterator it = this.tasas.iterator();
       while(it.hasNext())
       {
           t = (Tasa)it.next();
           if(codigo == t.getIdtasa())
               tasa = t;
       }
       t = null;
       it = null;
       return tasa;
   }
   
   private Tasa obtenerTasaNombre(String nombre)
   {
       Tasa tasa = new Tasa();
       Tasa t = new Tasa();
       Iterator it = this.tasas.iterator();
       while(it.hasNext())
       {
           t = (Tasa)it.next();
           if(nombre.trim().equals(t.getDenominacion().trim()))
               tasa = t;
       }
       t = null;
       it = null;
       return tasa;
   }
   
   private boolean control()
   {
       boolean bandera = true;
       if(this.jTNombre.getText().trim().length() == 0)
           bandera = false;
       return bandera;
   }
   
   private void guardar()
   {
       // tengo que guardar el nuevo tipo de documento
       
       boolean bandera = false;
       Documento doc = new Documento();
           //PlanoCTotal p = new PlanoCTotal();
       doc.setExiste("S");
       doc.setDescripcion(this.jTNombre.getText().trim().toUpperCase());
       CAlta alta = new CAlta();
       int respuesta = alta.hacerAlta(doc);
       if(respuesta != 0)
           {
               doc.setIdDocumento(respuesta);
               Iterator it = this.nuevasTasas.iterator();
               Tasa t = new Tasa();
               while(it.hasNext())
               {
                   t = (Tasa)it.next();
                   TasaAplicable ta = new TasaAplicable();
                   ta.setIdtasa(t.getIdtasa());
                   ta.setIdTipoConstancia(doc.getIdDocumento());
                   ta.setExiste("S");
                   // en el metodo encargado de hacer el alta en la tabla tasasaplicables
                   // hay que asignarle el id de tipo de documento al objeto ta y recien dar el 
                   // alta.
                   respuesta = alta.hacerAlta(ta);
                   if(respuesta != 0)
                       bandera = true;
                   t = null;
                   ta = null;
               }
               it = null;
               if(bandera)
                   JOptionPane.showMessageDialog(null,"Error en la carga de datos, intente de nuevo mas tarde","Error",JOptionPane.ERROR_MESSAGE);
               else
               {
                   this.llenarTablas();
                   this.jBGuardar.setEnabled(false);
                    this.jTNombre.setEnabled(false);
                    this.jBAgregar.setEnabled(false);
                    this.modificar = false;
                    this.guardar = true;
                    this.jTNombre.setText("");
                    this.limpiarPlanosTasas();
               }
           }
           else
               JOptionPane.showMessageDialog(null,"No se pudo hacer el alta de los datos, intente mas tarde","Error de Carga",JOptionPane.ERROR_MESSAGE);

     }
   
   
   
   
   
   private void verDocumento()
   {
       this.limpiarPlanosTasas();
       Iterator it = this.documentos.iterator();
       Documento d = new Documento();
       Documento documento = new Documento();
       DefaultTableModel modelo = (DefaultTableModel)this.jTableNuevasTasas.getModel();
       String datos[] = new String[1];
       int indice;
       while(it.hasNext())
       {
           d = (Documento)it.next();
           indice = Integer.parseInt(String.valueOf(this.jTableDocumentos.getValueAt(this.jTableDocumentos.getSelectedRow(),0)));
           if(d.getIdDocumento() == indice)
               documento = d;
           d = null;
       }
       it = null;
       this.jTNombre.setText(documento.getDescripcion().trim());
       Iterator pt = this.tasasAplicables.iterator();
       TasaAplicable t = new TasaAplicable();
       Tasa tasa = new Tasa();
       while(pt.hasNext())
       {
           t = (TasaAplicable)pt.next();
           if(t.getIdTipoConstancia() == documento.getIdDocumento())
           {
               tasa = this.obtenerTasa(t.getIdtasa());
               this.nuevasTasas.add(tasa);
               datos[0] = tasa.getDenominacion().trim();
               modelo.addRow(datos);
           }
       }
       t = null;
       pt = null;
   }
   
   private void quitarTipoDocumento()
   {
       // primero doy de baja al tipo de documento
       int fila = this.jTableDocumentos.getSelectedRow();
       //Documento plano = new PlanoCTotal();
       Documento documento = new Documento();
       Baja baja = new Baja();
       Iterator it = this.documentos.iterator();
       Documento doc = new Documento();
       while(it.hasNext())
       {
           doc = (Documento)it.next();
           if(Integer.parseInt(String.valueOf(this.jTableDocumentos.getValueAt(fila, 0))) == doc.getIdDocumento())
               documento = doc;
       }
       it = null;
       doc = null;
       int respuesta = baja.eliminar(documento);
       if(respuesta == 0)
           JOptionPane.showMessageDialog(null,"Se produjo un error cuando se intentaba eliminar el tipo de documento, intente mas tarde","Error en la baja",JOptionPane.ERROR_MESSAGE);
       else
       {
           //ahora doy de baja a las tasas de la tea planos_tasas
           if(this.jTableNuevasTasas.getRowCount() > 0) // solo elimino si hay tasas para eliminar
           {
               TasaAplicable t = new TasaAplicable();
               t.setIdTipoConstancia(documento.getIdDocumento());
               respuesta = baja.eliminar(t);
               if(respuesta == 0)
                   JOptionPane.showMessageDialog(null,"Se produjo un error cuando se intentaba eliminar las tasas del documento, intente mas tarde","Error en la baja",JOptionPane.ERROR_MESSAGE);
               else
                   System.out.println("Los registros se borraron correctamente");
           }
           this.llenarTablas();
           this.limpiarPlanosTasas();       
       }
   }
    
}
