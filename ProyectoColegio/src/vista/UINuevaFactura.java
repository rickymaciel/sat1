/*
 * UINuevaFactura.java
 *
 * Created on 10 de enero de 2008, 10:57
 */

package vista;

import Datos.AlumnosSql;
import Datos.Consulta;
import Datos.CuotasSql;
import Datos.Modificacion;
import Datos.PagosSql;
import controlador.CFacturacion;
import controlador.CListar;
import controlador.CUltimo;
import dominio.Alumno;
import dominio.Cuota;
import dominio.Pago;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import negocios.Caja;
import negocios.CondicionVenta;
import negocios.DetalleCPParaFacturacion;
import negocios.DetalleCT;
import negocios.DetalleFactura;
import negocios.DetallePago;
import negocios.EncabezadoCP;
import negocios.EncabezadoCT;
import negocios.EncabezadoFactura;
import negocios.EncabezadoPago;
import negocios.Iva;
import negocios.Matriculado;
import negocios.Producto;
import negocios.Redondear;
import negocios.SerieFactura;
import negocios.Tasa;
import negocios.TasaSeleccionada;
import negocios.Usuario;
import reportes.cExport_thread;

/**
 *
 * @author  jorge
 */
public class UINuevaFactura extends javax.swing.JFrame {
    public Collection detallesFactura=new ArrayList();
    private Usuario usuario=new Usuario();
    private Caja caja=new Caja();
    private Matriculado matriculado=new Matriculado();
    private Alumno alumno = new Alumno();
    //maRCELIN****
    private Collection constanciasParciales = new ArrayList();
    private Collection constanciasTotales = new ArrayList();
    private Collection tasasSeleccionadas = new ArrayList();
    private Collection<Pago> cuotasAlumnos = new ArrayList<Pago>();
    private Collection<Pago> cuotasAlumnosFacturadas = new ArrayList<Pago>();
    private Collection series = new ArrayList();
    private Boolean nroAutomatico=false;
    
    private String[] array1TipoDoc;    
    private String[] array2Serie;
    private String[] array3Id;
    
    private Collection bloquedas = new ArrayList();    
    
    private Collection cuotas = new ArrayList();
    
    private String pagoMatricula="104";
    private String inscripcion="101";
    private String reinscripcion="102";
    private String reinscripcion2vez="103";
    
    /** Creates new form UINuevaFactura */
    public UINuevaFactura() {
        initComponents();
        // Codigo necesario para centrar la ventana                
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
                this.inicializarFormulario();
    }
    public UINuevaFactura(Usuario user) {
        initComponents();
        // Codigo necesario para centrar la ventana
                this.usuario=user;
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
                this.inicializarFormulario();
    }
    public UINuevaFactura(Usuario user,Caja ca) {
        /**
         * Viene del Menu principal, recibe un usuario y lacaja abierta que esta activa
         * si no esta abierta la caja, entonces no se puede abrir
         */
        if (ca.getEstado().toUpperCase().equals("C")){
            JOptionPane.showMessageDialog(null,"LA CAJA ESTA CERRADA, DEBE ABRIRLA PARA FACTURAR","Atencion",JOptionPane.WARNING_MESSAGE);
            this.dispose();
        }else{
                initComponents();
        // Codigo necesario para centrar la ventana                
                this.usuario=user;
                this.caja=ca;
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
                this.inicializarFormulario();
                
//                System.out.println("La caja Abierta recibida en Facturacion es: " +ca.getIdcaja());
                
        }   
    }
    
    /** Permite crear una interase que no se ve solo se usa para acceder
     a sus metodos, viene de UINuevaFacturaDetalle*/
    public UINuevaFactura(DetalleFactura det) {        
        //this.agregarLineaDetalle(det);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFecha = new javax.swing.JTextField();
        jTNumeroFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTDomicilio = new javax.swing.JTextField();
        jCCondicionVenta = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTNombreClientes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTCuilCuit = new javax.swing.JTextField();
        jTMatricula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jTNumeroRemito = new javax.swing.JTextField();
        jCIva = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jBAgregarDetalle = new javax.swing.JButton();
        jBQuitarDetalle = new javax.swing.JButton();
        jCSeries = new javax.swing.JComboBox();
        jLNombreMatriculado = new javax.swing.JLabel();
        jBTotalizar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBAnular = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalleFactura = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jBImprimeDetalle = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBFacturar = new javax.swing.JButton();
        jBVer = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Factura");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Serie - Nro.");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Fecha ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        jTNumeroFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTNumeroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNumeroFacturaActionPerformed(evt);
            }
        });
        jTNumeroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNumeroFacturaKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Matricula");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Domicilio");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Cond. Vta.");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);

        jTDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDomicilioKeyPressed(evt);
            }
        });

        jCCondicionVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCondicionVentaActionPerformed(evt);
            }
        });
        jCCondicionVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCCondicionVentaKeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("Cliente");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setOpaque(true);

        jTNombreClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreClientesKeyPressed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 204));
        jLabel8.setText("Cuit/Cuil");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);

        jTCuilCuit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCuilCuitKeyPressed(evt);
            }
        });

        jTMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTMatriculaKeyPressed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 204));
        jLabel9.setText("Remito");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setOpaque(true);

        jTNumeroRemito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNumeroRemitoKeyPressed(evt);
            }
        });

        jCIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCIvaKeyPressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Iva");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setOpaque(true);

        jBAgregarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.gif"))); // NOI18N
        jBAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarDetalleActionPerformed(evt);
            }
        });

        jBQuitarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/remove.gif"))); // NOI18N
        jBQuitarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarDetalleActionPerformed(evt);
            }
        });

        jCSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSeriesActionPerformed(evt);
            }
        });

        jBTotalizar.setText("Tot");
        jBTotalizar.setToolTipText("Realiza la suma de subtotales, solo sirve en caso de modificar los subtotales,tener en cuenta que si cambia la CANTIDAD o PU calcule manualmente el SUBTOTAL y presione finalmente TOT para recalcular el TOTAL");
        jBTotalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTotalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCIva, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCCondicionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNumeroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAgregarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jBQuitarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBTotalizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLNombreMatriculado, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTNombreClientes)
                                    .addComponent(jTCuilCuit, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLNombreMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTNombreClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTCuilCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCCondicionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jTNumeroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jBAgregarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBQuitarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTotalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jTFecha});

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBAnular.setText("Anular");
        jBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularActionPerformed(evt);
            }
        });

        jBImprimir.setText("Imprimir");
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

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ord.", "Producto", "Detalle", "Descripcion", "Cantidad", "PU ($)", "Subtotal ($)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDetalleFactura);

        jLabel10.setBackground(new java.awt.Color(255, 255, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TOTAL ($):");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setOpaque(true);

        jTTotal.setEditable(false);
        jTTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jBImprimeDetalle.setText("Imprimir Detalle");
        jBImprimeDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimeDetalleActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Documento", "Serie", "Codigo", "Matricula"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jBFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flechaDerecha.gif"))); // NOI18N
        jBFacturar.setText("Facturar");
        jBFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFacturarActionPerformed(evt);
            }
        });

        jBVer.setText("Ver");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBVer, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jBFacturar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBVer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jBNuevo.setText("Nuevo");
        jBNuevo.setEnabled(false);
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImprimeDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTotal)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNuevo)
                    .addComponent(jBImprimeDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBImprimeDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimeDetalleActionPerformed
        for (int i=0;i<this.array1TipoDoc.length;i++){
//            System.out.println("SE IMPRIME TIPODOC: "+ this.array1TipoDoc[i]);
//            System.out.println("SE IMPRIME SERIE: "+ this.array2Serie[i]);
//            System.out.println("SE IMPRIME ID: "+ this.array3Id[i]);
            if(this.array1TipoDoc[i].equals("CP")){
                String encCPSerie = this.array2Serie[i];
                String encCPCodigo = this.array3Id[i];
                cExport_thread imprime=new cExport_thread(34,encCPSerie,encCPCodigo);
                imprime.start();                
            }
            if (this.array1TipoDoc[i].equals("CT")){
                String encCTSerie = this.array2Serie[i];
                String encCTCodigo = this.array3Id[i];
                cExport_thread imprime=new cExport_thread(33,encCTSerie,encCTCodigo);
                imprime.start();
            }
            if (this.array1TipoDoc[i].equals("CUOTA")){
                //String encCTSerie = String.valueOf(this.jTable2.getValueAt(item, 1));
                String encPago = this.array3Id[i];
                cExport_thread imprime=new cExport_thread(36,encPago);
                imprime.start();
            }
        }
}//GEN-LAST:event_jBImprimeDetalleActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBSalirActionPerformed
    {//GEN-HEADEREND:event_jBSalirActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMatriculaKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        boolean numeroCorrecto=true;
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE))))        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(this,"Debe introducir un valor valido ej: 12","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTMatricula.setText("");
            this.jTMatricula.requestFocus();
            numeroCorrecto=false;
            evt.consume();
        }
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10 && numeroCorrecto)
            if (JOptionPane.showConfirmDialog(new JFrame(),"�Desea buscar un matriculado?", "Buscar Matriculado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                this.buscarMatriculado();    
            else
                this.buscarAlumno();

            
            
            
            this.buscarMatriculado();    
    }//GEN-LAST:event_jTMatriculaKeyPressed

    private void jTNombreClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClientesKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTCuilCuit.requestFocus();

    }//GEN-LAST:event_jTNombreClientesKeyPressed

    private void jTCuilCuitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCuilCuitKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTDomicilio.requestFocus();

    }//GEN-LAST:event_jTCuilCuitKeyPressed

    private void jTDomicilioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDomicilioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCIva.requestFocus();

    }//GEN-LAST:event_jTDomicilioKeyPressed

    private void jCIvaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCIvaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCCondicionVenta.requestFocus();

    }//GEN-LAST:event_jCIvaKeyPressed

    private void jCCondicionVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCCondicionVentaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTNumeroRemito.requestFocus();

    }//GEN-LAST:event_jCCondicionVentaKeyPressed

    private void jTNumeroRemitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNumeroRemitoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jBAgregarDetalle.requestFocus();

    }//GEN-LAST:event_jTNumeroRemitoKeyPressed

    private void jBAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarDetalleActionPerformed
        // TODO add your handling code here:
        /**
         * Abre una ventana de dialgo donde se puede seleccionar un producto
         * para agregar una linea de detalle a la jtable
         */
        //System.out.println("VALOR DEL ULTIMO ID DETALLE: "+this.jTableDetalleFactura.getValueAt(this.jTableDetalleFactura.getRowCount()-1,0));
        
        if (this.jTableDetalleFactura.getRowCount()<19){
            UINuevaFacturaDetalle1 ventanaDetalle=new UINuevaFacturaDetalle1(this,true);        
            ventanaDetalle.setVisible(true);        
        } else {
            JOptionPane.showMessageDialog(this, "El numero maximo de filas permitido para detalles es 18", "Limite de lineas de Detalle", JOptionPane.INFORMATION_MESSAGE);
        }
        
//        UINuevaFacturaDetalle ventanaDetalle=new UINuevaFacturaDetalle(this);        
//        ventanaDetalle.setVisible(true);
        
    }//GEN-LAST:event_jBAgregarDetalleActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        if(this.controlarCampos()){
            if (this.jTableDetalleFactura.getRowCount()>0){//sihay mas de una linea de detalle
                int n = JOptionPane.showConfirmDialog(this, "Realmente desea almacenar, ya controlo los datos a almacenar?","Control de datos",JOptionPane.YES_NO_OPTION);
                if (n==JOptionPane.YES_OPTION){
                    this.guardar();
                }else{
                    if (n==JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(this, "Almacenamiento cancelado","Operacion cancelada",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "No hay linea de detalle, debe abregar al menos una linea para facturar","No podra facturar sin lineas de detalle",JOptionPane.INFORMATION_MESSAGE);
            }            
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBQuitarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarDetalleActionPerformed
        // TODO add your handling code here:
        this.quitarLineaDetalle();
    }//GEN-LAST:event_jBQuitarDetalleActionPerformed

    private void jCCondicionVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCondicionVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCCondicionVentaActionPerformed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:      
        cExport_thread imprime=new cExport_thread(27,String.valueOf(this.jCSeries.getSelectedItem()).trim(),this.jTNumeroFactura.getText().trim());
        imprime.start();
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFacturarActionPerformed
        // TODO add your handling code here:
        int fila = this.jTable2.getSelectedRow();
        if(fila >= 0)
            if(this.controlarFila(fila))
                this.facturar(fila);
            else
                JOptionPane.showMessageDialog(this,"El documento seleccionado ya fue elegido para facturar","Elija Otro",JOptionPane.WARNING_MESSAGE);
        else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar un documento para facturar","No hay seleccion",JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_jBFacturarActionPerformed

    private void jCSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSeriesActionPerformed
        // TODO add your handling code here:
        this.cargarNroFactura();       
    }//GEN-LAST:event_jCSeriesActionPerformed

    private void jBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularActionPerformed
        // TODO add your handling code here:
        this.anularFactura();
        this.nuevaFactura();
    }//GEN-LAST:event_jBAnularActionPerformed

    private void jBTotalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTotalizarActionPerformed
        // TODO add your handling code here:
        this.calcularTotal();        
}//GEN-LAST:event_jBTotalizarActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        this.nuevaFactura();
        this.actualizar();
        this.jBVer.setEnabled(false);
}//GEN-LAST:event_jBNuevoActionPerformed

    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerActionPerformed
        // TODO add your handling code here:
        this.actualizar();
        this.jBVer.setEnabled(false);
}//GEN-LAST:event_jBVerActionPerformed

private void jTNumeroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNumeroFacturaActionPerformed
// TODO add your handling code here:
    
    
}//GEN-LAST:event_jTNumeroFacturaActionPerformed

private void jTNumeroFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNumeroFacturaKeyPressed
// TODO add your handling code here:
    if(evt.getKeyCode()==27)
            this.dispose();
    if(evt.getKeyChar()==10)
            this.jTMatricula.requestFocus();
}//GEN-LAST:event_jTNumeroFacturaKeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UINuevaFactura().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarDetalle;
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBFacturar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBImprimeDetalle;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBQuitarDetalle;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBTotalizar;
    private javax.swing.JButton jBVer;
    private javax.swing.JComboBox jCCondicionVenta;
    private javax.swing.JComboBox jCIva;
    private javax.swing.JComboBox jCSeries;
    private javax.swing.JLabel jLNombreMatriculado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTCuilCuit;
    private javax.swing.JTextField jTDomicilio;
    private javax.swing.JTextField jTFecha;
    private javax.swing.JTextField jTMatricula;
    private javax.swing.JTextField jTNombreClientes;
    private javax.swing.JTextField jTNumeroFactura;
    private javax.swing.JTextField jTNumeroRemito;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableDetalleFactura;
    // End of variables declaration//GEN-END:variables
    
    
    private void inicializarFormulario(){
        
        this.cargarCombos();
        this.llenarSeriesActivas();
        this.cargarNroFactura();
        this.cargarFecha();                
        this.habilitarBotones(true);
        this.ajustarColumnas();
        
    }
    
    private void nuevaFactura(){
        this.quitarLineaDetalle();
        this.jLNombreMatriculado.setText("");
        this.jTMatricula.setText("");
        this.jTNombreClientes.setText("");
        this.jTNumeroRemito.setText("");
        this.jTNumeroFactura.setText("");
        this.jTDomicilio.setText("");
        this.jTCuilCuit.setText("");
        this.jTFecha.setText("");
        this.jTTotal.setText("");        
        this.cargarFecha();               
        this.cargarNroFactura();
        this.habilitarBotones(true);
        this.detallesFactura.clear();
        
        //--------------------PROBANDO
//        array1TipoDoc=null;    
//        array2Serie=null;
//        array3Id=null;
//        bloquedas.clear();    
//        cuotas.clear();
        //--------------
        
    }
    private void habilitarBotones(Boolean habilitar){
        //False es antes de guardar, MODO EDICION
        //True es MODO BLOQUEO        
        
        this.jBNuevo.setEnabled(!habilitar);
        
        this.jBGuardar.setEnabled(habilitar);
        this.jBFacturar.setEnabled(habilitar);
//        this.jBPagarCuota.setEnabled(habilitar);
        this.jBAnular.setEnabled(!habilitar);
        this.jBImprimir.setEnabled(!habilitar);
        this.jBImprimeDetalle.setEnabled(!habilitar);
        //this.jBSalir.setEnabled(habilitar);
    }
    private void cargarNroFactura(){
  /*
   *Carga el numero de constancia parcial correspondiente para una nueva constancia
   *de acuerdo a la Serie Elegida 
   */    
      this.nroAutomatico=this.esAutomatico();  
      if(this.nroAutomatico){
        this.jTNumeroFactura.setText("Nro Automatico");
        this.jTNumeroFactura.setEnabled(false);
      }else{
          this.jTNumeroFactura.setText("");
          this.jTNumeroFactura.setEnabled(true);
      }
  }
    
    private void llenarSeriesActivas(){
        Boolean habilitarNro=false;
        CListar listaSeries=new CListar();
        SerieFactura se=new SerieFactura();se.setActivo("S");
        series=listaSeries.hacerListado(se);
        listaSeries=null;
        
        Iterator it=series.iterator();
        while (it.hasNext()){
           SerieFactura serF=(SerieFactura)it.next();
           this.jCSeries.addItem(serF.getSerie());
           if (serF.getDefecto().trim().equals("S")){
                    this.jCSeries.setSelectedItem(serF.getSerie());
                    if (serF.getTipoDeCarga().trim().equals("M"))//Si es manualla carga
                        habilitarNro=true;
           }
           if (!it.hasNext() && habilitarNro==false){
                if (serF.getTipoDeCarga().trim().equals("M")){//Si es manualla carga
                        habilitarNro=true;
                    }else{
                        habilitarNro=false;
                 }                
           }
           serF=null;
        }        
        this.jTNumeroFactura.setEnabled(habilitarNro);
        if (this.jCSeries.getItemCount()==0){
            JOptionPane.showMessageDialog(this, "No hay series de factura que\nse encuentren activas, debe dar de alta una nueva serie para factura\n de lo contrario no podra emitir facturas","No se podra almacenar la factura", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void cargarFecha(){
//        Obtenemos la fecha actual del sistema
        Date fecha=new Date();//fecha actual
        //DateFormat df=DateFormat.getInstance();
        
        DateFormat df=DateFormat.getDateInstance();
        
//        Calendar cal=Calendar.getInstance();
//        cal.setTime(fecha);
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        
        this.jTFecha.setText(sdf.format(fecha)); 
        
        
        //this.jTFecha.setText(df.format(fecha)); 
        //this.jTFecha.setText(String.valueOf(cal.get(cal.DAY_OF_MONTH))+"/"+String.valueOf(cal.get(cal.get(cal.MONTH))+"/"+String.valueOf(cal.get(cal.get(cal.YEAR)))));
        
    }
    private void cargarCombos(){
        Collection iva=new ArrayList();
        Collection condicionVenta=new ArrayList();
        
        CListar listar = new CListar();        
        iva = listar.hacerListado(new Iva());
        condicionVenta=listar.hacerListado(new CondicionVenta());
        
        listar = null;        
        Iterator ite = iva.iterator();          
        while(ite.hasNext()){
            Iva i = (Iva)ite.next();            
            this.jCIva.addItem(i.getNombre().trim());
            i = null;
        }
        ite = condicionVenta.iterator();
        while(ite.hasNext()){
            CondicionVenta c = (CondicionVenta)ite.next();
            this.jCCondicionVenta.addItem(c.getNombre().trim());
            c = null;
        }        
    }
    private void buscarMatriculado(){
    if (this.jTMatricula.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Agregue un numero en Matricula Solicitante para buscarla","No se puede Buscar", JOptionPane.WARNING_MESSAGE);
        } else {
            this.limpiarCampos();
            Matriculado m=new Matriculado(); 
            m.setMatricula(Integer.parseInt(this.jTMatricula.getText().trim()));

            CListar listamat=new CListar();
            Matriculado ma=listamat.soloMatriculado(m);                    
            if (ma.getMatricula()!=0){
                this.matriculado=null;
                this.matriculado=ma;
                if(ma.getNombres()!=null){
                    this.jLNombreMatriculado.setText(ma.getApellido().trim()+", "+ma.getNombres().trim());
                    //this.jTNombreClientes.setText(ma.getApellido().trim()+", "+ma.getNombres().trim());
                }
                if(ma.getCuit()!=null){
                    this.jTCuilCuit.setText(ma.getCuit());
                }
//                Titulo tit=ma.getTitulo();
//                if (tit.getAbreviacion()!=null){
//                    this.jTTitulo.setText(tit.getAbreviacion().trim());
//                } 
                if(ma.getCalleProfesional()!=null && ma.getLocalidadProfesional().getNombre()!=null){
                    this.jTDomicilio.setText(ma.getCalleProfesional().trim()+" - "+ma.getLocalidadProfesional().getNombre().trim());
                }
                
                
                //System.out.println("Iva del matriculado: "+ma.getIva().getNombre());
                //Hago un listado de los tipos de iva
                //y averigua cual es el que corresponde al matriculado
                //y lo dejo seleccionado
                CListar listar = new CListar();
                Collection co = new ArrayList();
                co = listar.hacerListado(new Iva());
                int cantidad = co.size();
                int posicion = 0;
                for(int i = 0; i < cantidad; i++){
                    //String nombre = String.valueOf(this.jCIva.getSelectedItem()).trim();                    
                    if(ma.getIva().getNombre().trim().equals(this.jCIva.getItemAt(i).toString())){                        
                        //System.out.println("Item at: "+i+" - "+this.jCIva.getItemAt(i).toString());
                        posicion = i;
                    }
                }                
                listar=null;
                this.jCIva.setSelectedIndex(posicion);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un numero de matricula existente","Matricula Inexistente", JOptionPane.WARNING_MESSAGE);
            }
        } 
    }
     private void limpiarCampos(){
        this.jTNombreClientes.setText("");
        this.jTCuilCuit.setText("");
        this.jTDomicilio.setText("");        
    }
//    private void guardar(){
//        //**********ENCABEZADO DE FACTURA        
//        EncabezadoFactura encFactura=new EncabezadoFactura();
//        //encFactura.setSerieFactura(Integer.valueOf(this.jTSerieFactura.getText().trim()));
//        encFactura.setSerieFactura(Integer.valueOf(String.valueOf(this.jCSeries.getSelectedItem()).trim()));
//                
//        if(this.nroAutomatico==true){
//            Long nroFactura=this.obtenerNumeroDeFactura(encFactura);
//            encFactura.setNumeroFactura(nroFactura);
//            
//        }else{
//            if(!this.controlarNumeroRepetido()){
//                JOptionPane.showMessageDialog(this, "El numero de factura ingresado ya existe, cargue otro numero", "Error de duplicacion de clave", JOptionPane.ERROR_MESSAGE);
//            }else{    
//                CUltimo compruebaNumeroFactura=new CUltimo();
//                encFactura.setNumeroFactura(Long.valueOf(this.jTNumeroFactura.getText().trim()));                
//                //Controlo si el nro es valido, es decir si no supera al limite establecido para la serie
//                //por eso paso el objeto encabezadoFactura con el nro y serie cargados
//                //Si no es valido recibe un cero 0, entonces no va a entrar a guardar la factura
//                Long nroFacturaValido=compruebaNumeroFactura.getUltimoManual(encFactura);
//                encFactura.setNumeroFactura(nroFacturaValido);       
//                if (nroFacturaValido==0)
//                    JOptionPane.showMessageDialog(this, "Se llego al limite del numero de factura", "Tiene que generar una nueva serie de factura para seguir facturando", JOptionPane.WARNING_MESSAGE);
//            }
//        }
//          
//        
//        if (encFactura.getNumeroFactura()!=0){// si el numero de factura es permitido (no supero al limite permitido por la serie)
//            encFactura.setUsuario(this.usuario);        
//            
//            //DateFormat df=DateFormat.getInstance(); //funciona OK si esta
//            
//            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
//            
//            //Date fecha=new Date();//fecha actual por defecto            
//            java.util.Date fecha=null;
//            try{
//                fecha=sdf.parse(this.jTFecha.getText().trim());
//            }catch(ParseException pe){
////                System.out.println(pe.getMessage()+" FECHA no v�lida");
//            }        
//            encFactura.setFecha(fecha);
//            encFactura.setCaja(this.caja);
//            
//            CondicionVenta condVenta=this.obtenerCondicionVenta();
//            encFactura.setCondicionVenta(condVenta);            
//            Iva iva=this.obtenerIva();            
//            encFactura.setIva(iva);
//            
//            encFactura.setIdempresa(1);//LE ASIGNO EL CODIGO DE EMPRESA 1 por defecto CAMBIAR!!!!!!
//            encFactura.setNumeroRemito(this.jTNumeroRemito.getText().trim());
//            encFactura.setTotal(Double.parseDouble(this.jTTotal.getText().trim()));
//            encFactura.setCuit(this.jTCuilCuit.getText().trim());
//            encFactura.setDomicilio(this.jTDomicilio.getText().trim());
//            encFactura.setMatriculado(this.matriculado);
//            
//            encFactura.setNombreCliente(this.jLNombreMatriculado.getText().trim()+"-"+this.jTNombreClientes.getText().toUpperCase().trim());
//            //encFactura.setNombreCliente(this.jTNombreClientes.getText().trim());
//            
//            
//            encFactura.setAnulado("N");
//            //**********ENCABEZADO DE FACTURA**FIN
//            CFacturacion factura=new CFacturacion();            
//            this.armarCollectionDetallesFactura(encFactura);            
//            
//            //----------Solo muestra por consola la collection - BORRAR LUEGO
///*            Iterator it = detallesFactura.iterator();        
//            while(it.hasNext()){
//                DetalleFactura d = (DetalleFactura)it.next();            
//                System.out.println("Se cargaron: "+d.getIddetalle()+"-"+d.getDetalle()+"-IDDETALLE:"+d.getIddetalle()+"-"+d.getProducto().getDenominacion());
//                d=null;
//            }
//            it=null;*/
//            //----------
//            
//            int respuesta=factura.facturar(encFactura, detallesFactura);            
//            if (respuesta==1){
//                JOptionPane.showMessageDialog(this, "Se ha guardado la factura correctamente", "Guardar Factura",JOptionPane.INFORMATION_MESSAGE);
//                this.armarVectorImpresion();//JORGE AGREGO ESTA LINEA PARA HACER IMPRESIONES DE CT CP CUOTA                
//                this.jTNumeroFactura.setText(String.valueOf(encFactura.getNumeroFactura()));
//                this.habilitarBotones(false);//Pone a los botones en modo bloqueo (NO EDICION)
//                this.actualizarDocumentos();
//                this.actualizar();
//            } else {
//                if (respuesta==0){
//                    JOptionPane.showMessageDialog(this, "No se pudo almacenar la factura correctamente, revise el formulario", "Guardar Factura",JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        }
//    }    
    private void guardar(){
        //**********ENCABEZADO DE FACTURA 
        boolean repetido=false;///////**************
        boolean llegoAlLimite=false;///////**************
        
        EncabezadoFactura encFactura=new EncabezadoFactura();
        //encFactura.setSerieFactura(Integer.valueOf(this.jTSerieFactura.getText().trim()));
        encFactura.setSerieFactura(Integer.valueOf(String.valueOf(this.jCSeries.getSelectedItem()).trim()));
                
        if(this.nroAutomatico==true){
            Long nroFactura=this.obtenerNumeroDeFactura(encFactura);
            encFactura.setNumeroFactura(nroFactura);
        }else{
            if(!this.controlarNumeroRepetido()){
                JOptionPane.showMessageDialog(this, "El numero de factura ingresado ya existe, cargue otro numero", "Error de duplicacion de clave", JOptionPane.ERROR_MESSAGE);
                repetido=true;///////**************
            }else{    
                CUltimo compruebaNumeroFactura=new CUltimo();
                encFactura.setNumeroFactura(Long.valueOf(this.jTNumeroFactura.getText().trim()));                
                //Controlo si el nro es valido, es decir si no supera al limite establecido para la serie
                //por eso paso el objeto encabezadoFactura con el nro y serie cargados
                //Si no es valido recibe un cero 0, entonces no va a entrar a guardar la factura
                Long nroFacturaValido=compruebaNumeroFactura.getUltimoManual(encFactura);
//                encFactura.setNumeroFactura(nroFacturaValido);       
                if (nroFacturaValido==0){
                    JOptionPane.showMessageDialog(this, "Se llego al limite del numero de factura", "Tiene que generar una nueva serie de factura para seguir facturando", JOptionPane.WARNING_MESSAGE);
                    llegoAlLimite=true;///////**************
                }
            }
        }
          
        
        if (encFactura.getNumeroFactura()!=0 && !repetido && !llegoAlLimite){// si el numero de factura es permitido (no supero al limite permitido por la serie)
            System.out.println("nro de factura q deberia guardar es: "+encFactura.getNumeroFactura());
            
            encFactura.setUsuario(this.usuario);        
            
            //DateFormat df=DateFormat.getInstance(); //funciona OK si esta
            
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            
            //Date fecha=new Date();//fecha actual por defecto            
            java.util.Date fecha=null;
            try{
                fecha=sdf.parse(this.jTFecha.getText().trim());
            }catch(ParseException pe){
//                System.out.println(pe.getMessage()+" FECHA no v�lida");
            }        
            encFactura.setFecha(fecha);
            encFactura.setCaja(this.caja);
            
            CondicionVenta condVenta=this.obtenerCondicionVenta();
            encFactura.setCondicionVenta(condVenta);            
            Iva iva=this.obtenerIva();            
            encFactura.setIva(iva);
            
            encFactura.setIdempresa(1);//LE ASIGNO EL CODIGO DE EMPRESA 1 por defecto CAMBIAR!!!!!!
            encFactura.setNumeroRemito(this.jTNumeroRemito.getText().trim());
            if (this.jTTotal.getText().trim().length()==0){
                encFactura.setTotal(0);                
            }else{
                encFactura.setTotal(Double.parseDouble(this.jTTotal.getText().trim()));
            }            
            encFactura.setCuit(this.jTCuilCuit.getText().trim());
            encFactura.setDomicilio(this.jTDomicilio.getText().trim());
            encFactura.setMatriculado(this.matriculado);
            
            encFactura.setNombreCliente(this.jLNombreMatriculado.getText().trim()+"-"+this.jTNombreClientes.getText().toUpperCase().trim());
            //encFactura.setNombreCliente(this.jTNombreClientes.getText().trim());
            
            
            encFactura.setAnulado("N");
            //**********ENCABEZADO DE FACTURA**FIN
            CFacturacion factura=new CFacturacion();            
            this.armarCollectionDetallesFactura(encFactura);            
            
            //----------Solo muestra por consola la collection - BORRAR LUEGO
/*            Iterator it = detallesFactura.iterator();        
            while(it.hasNext()){
                DetalleFactura d = (DetalleFactura)it.next();            
                System.out.println("Se cargaron: "+d.getIddetalle()+"-"+d.getDetalle()+"-IDDETALLE:"+d.getIddetalle()+"-"+d.getProducto().getDenominacion());
                d=null;
            }
            it=null;*/
            //----------
            
            int respuesta=factura.facturar(encFactura, detallesFactura);            
             
//            System.out.println("respuesta es: "+respuesta);
            
            if (respuesta==1){
                JOptionPane.showMessageDialog(this, "Se ha guardado la factura correctamente", "Guardar Factura",JOptionPane.INFORMATION_MESSAGE);
                this.armarVectorImpresion();//JORGE AGREGO ESTA LINEA PARA HACER IMPRESIONES DE CT CP CUOTA                
                this.jTNumeroFactura.setText(String.valueOf(encFactura.getNumeroFactura()));
                this.habilitarBotones(false);//Pone a los botones en modo bloqueo (NO EDICION)
                this.actualizarDocumentos();
                this.actualizar();
            } else {
                if (respuesta==0){
                    JOptionPane.showMessageDialog(this, "No se pudo almacenar la factura correctamente, revise el formulario", "Guardar Factura",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void armarVectorImpresion(){
                //+++++++++++++++++++
                this.array1TipoDoc=new String[this.bloquedas.size()];
                this.array2Serie=new String[this.bloquedas.size()];
                this.array3Id=new String[this.bloquedas.size()];

//                System.out.println("LOS ARRAY BLOQUEDAS TIENEN LENGHT= A: "+this.bloquedas.size());

                Iterator it = this.bloquedas.iterator();
                int fil;
                int indice=0;
                while(it.hasNext()){
                    fil = (Integer)it.next();                    
                    this.array1TipoDoc[indice] = String.valueOf(this.jTable2.getValueAt(fil, 0));
                    this.array2Serie[indice] = String.valueOf(this.jTable2.getValueAt(fil, 1));
                    this.array3Id[indice] = String.valueOf(this.jTable2.getValueAt(fil, 2));
                    indice++;
                }
//                for (int i=0;i<this.array1TipoDoc.length;i++){
//                    System.out.println("SE IMPRIME TIPODOC: "+ this.array1TipoDoc[i]);
//                    System.out.println("SE IMPRIME SERIE: "+ this.array2Serie[i]);
//                    System.out.println("SE IMPRIME ID: "+ this.array3Id[i]);
//                }
                //+++++++++++++++++++
    }
    
    private boolean controlarNumeroRepetido(){
        boolean bandera = true;
        Consulta con = new Consulta();
        bandera = con.verificarNroFactura(this.jTNumeroFactura.getText().trim(), this.jCSeries.getSelectedItem().toString().trim());
        con = null;
        return bandera;
    }
   
    
    private void armarCollectionDetallesFactura(EncabezadoFactura encF){
        for(Integer fila=0;fila<this.jTableDetalleFactura.getRowCount();fila++){
            DetalleFactura det=new DetalleFactura();                                                        

            det.setSerieFactura(encF.getSerieFactura());
            det.setNumeroFactura(encF.getNumeroFactura());
            det.setIddetalle(Integer.parseInt(String.valueOf(this.jTableDetalleFactura.getValueAt(fila,0))));
            det.setDetalle(String.valueOf(this.jTableDetalleFactura.getValueAt(fila,3)).trim());
            det.setCantidad(Integer.parseInt(String.valueOf(this.jTableDetalleFactura.getValueAt(fila,4))));
            det.setSubTotal(Double.parseDouble(String.valueOf(this.jTableDetalleFactura.getValueAt(fila,6))));
            
            
            
            Producto prod=new Producto();
            CListar obtenerProducto=new CListar();
            prod = obtenerProducto.obtenerProducto(Integer.parseInt(String.valueOf(this.jTableDetalleFactura.getValueAt(fila,1))));
            //------------Agrgue nada mas
            prod.setPrecio(Double.parseDouble(String.valueOf(this.jTableDetalleFactura.getValueAt(fila,5))));
            //------------
            det.setProducto(prod);
            
            
            this.detallesFactura.add(det);
            //det=null;
        }
        
    }
    
    private Long obtenerNumeroDeFactura(EncabezadoFactura enc){
        CUltimo buscaUltimoNroFactura=new CUltimo();
        Long nroFactura=buscaUltimoNroFactura.getUltimo(enc);        
        if (nroFactura==0){
            JOptionPane.showMessageDialog(this, "Se llego al limite del numero de factura", "Tiene que generar una nueva serie de factura para seguir fcturando", JOptionPane.WARNING_MESSAGE);
        }        
        return nroFactura;
    }
    
    public void agregarLineaDetalle(DetalleFactura detalle){
    /**Metodo que permite agregar un detalle a la interfase de la pantalla
     * de facturacion, los datos de detalle vienen UINuevaFacturaDetalle
     */ 
        DetalleFactura detAux=new DetalleFactura();
        detAux=detalle;
        detalle.setIddetalle(this.jTableDetalleFactura.getRowCount()+1);        
        //Obtengo un modelo de la jtable
        DefaultTableModel modelo=(DefaultTableModel)this.jTableDetalleFactura.getModel();        
        //armo la linea de detalle para agregar a la jtable        
        Redondear r = new Redondear();
        
        detalle.setSubTotal(r.redondear(detalle.getSubTotal(), 2));
        
        r = null;
        Object[] datos={detalle.getIddetalle(),detalle.getProducto().getIdproducto(),detalle.getProducto().getDenominacion(),detalle.getDetalle(),detalle.getCantidad(),detalle.getProducto().getPrecio(),detalle.getSubTotal()};        
        //agrego la linea de detalle datos a la jtable
        modelo.addRow(datos);        
        detalle=null;
        detAux=null;
        //---------------        
        this.calcularTotal();
   }

   public void agregarACollectionDeImpresion(int itemTabla){
    /**Metodo que agrega lo que viene de el boton FACTURAR
     * es decir, los docuementos,su serie y codigo para agregarlos
     * a una collection y mandarlos a imprimir
     */      
//     this.arrayNroDeItemsDeDocumentoAImprimir.add(itemTabla);
   }
   
   
   private void calcularTotal(){
        double montoTotal=0.0;
        double subtot = 0.0;
        
        for(int i=0;i<this.jTableDetalleFactura.getRowCount();i++){
            if(this.jTableDetalleFactura.getValueAt(i, 6) != null && this.jTableDetalleFactura.getValueAt(i, 5) != null && this.jTableDetalleFactura.getValueAt(i, 4) != null){
                subtot=Double.parseDouble(String.valueOf(this.jTableDetalleFactura.getValueAt(i, 4)))*Double.parseDouble(String.valueOf(this.jTableDetalleFactura.getValueAt(i, 5)));
                this.jTableDetalleFactura.setValueAt(subtot,i, 6);
                montoTotal = montoTotal + subtot;             
            }
        }        
        Redondear r = new Redondear();
        montoTotal = r.redondear(montoTotal, 2);
        r = null;
        this.jTTotal.setText(String.valueOf(montoTotal));  
        
      
        
   }

   private void quitarLineaDetalle() {
       DefaultTableModel modelo = (DefaultTableModel)this.jTableDetalleFactura.getModel();
  
       
       while(this.jTableDetalleFactura.getRowCount() != 0)
                modelo.removeRow(0);
       
       modelo = null;
       this.bloquedas.clear();
       
   }
   //***************MARCELIN
   private EncabezadoCP getEncabezadoCP(long codigo)
    {
        EncabezadoCP enc = new EncabezadoCP();
        Iterator it = this.constanciasParciales.iterator();
        while(it.hasNext())
        {
            EncabezadoCP e = (EncabezadoCP)it.next();
            if(e.getCodigoCP() == codigo)
            {
                enc = e;
                e = null;
                break;
            }
                
            e = null;
        }
        return enc;
    }
    
    private EncabezadoCT getEncabezadoCT(long codigo)
    {
        EncabezadoCT enc = new EncabezadoCT();
        Iterator it = this.constanciasTotales.iterator();
        while(it.hasNext())
        {
            EncabezadoCT e = (EncabezadoCT)it.next();
            if(e.getCodigoCT() == codigo)
            {
                enc = e;
                e = null;
                break;
            }
                
            e = null;
        }
        return enc;
    }
    
//    private void facturar(int fila)
//    {
//        EncabezadoCP encCP = new EncabezadoCP();
//        EncabezadoCT encCT = new EncabezadoCT();
//        Collection tasas = new ArrayList();
//        // dependiendo del tipo de documento voy a obtener su objeto encabezado
//        if(String.valueOf(this.jTable2.getValueAt(fila, 0)).equals("CP"))
//            encCP = this.getEncabezadoCP(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
//        else
//            encCT = this.getEncabezadoCT(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
//        
//        // ahora tengo que obtener los detalles de la constancia
//        CListar listar = new CListar();
//        Collection detalle = new ArrayList();
//        if(String.valueOf(this.jTable2.getValueAt(fila, 0)).equals("CP"))
//        {
//            DetalleCP d = new DetalleCP();
//            d.setCodigoCP(encCP.getCodigoCP());
//            d.setSerieCP(encCP.getSerieCP());
//            detalle = listar.hacerListadoDetalleCP(d);
//        }
//        else
//        {
//            DetalleCT d = new DetalleCT();
//            d.setCodigoCT(encCT.getCodigoCT());
//            d.setSerieCT(encCT.getSerieCT());
//            detalle = listar.hacerListadoDetalleCT(d);
//        }
//        // en este punto ya tengo el detalle de la constancia
//        // ahora tengo que calcular las lines de detalle y armar el objeto
//        // detalleFactura para pasarcelo al metodo encargado de llenar la grilla
//        // de detalles.
//        System.out.println("La coleccion detalles tiene "+detalle.size()+" elementos");
//        //Collection detallesFactura2 = new ArrayList();
//        
//        // tengo que obtener las tasas que integran la constancia
//        if(String.valueOf(this.jTable2.getValueAt(fila, 0)).equals("CP"))
//            tasas = listar.armarDetalleFactura(encCP.getSerieCP(), String.valueOf(encCP.getCodigoCP()), "CP");
//        // aqui falta el else para traer las tasas aplicables a las constancias totales
//        else
//        {
//            tasas = listar.armarDetalleFactura(encCT.getSerieCT(), String.valueOf(encCT.getCodigoCT()), "CT");
//            this.tasasSeleccionadas = listar.listar(encCT.getSerieCT(), encCT.getCodigoCT());
//        }
//            
//        System.out.println("Las tasas aplicadas a este documento son "+tasas.size());
//        // ahora que tengo las tasas aplicables tengo que calcular la linea de detalle
//        if(String.valueOf(this.jTable2.getValueAt(fila, 0)).equals("CP"))
//        {
//            Iterator it = detalle.iterator();
//            double superficieRelevamiento = 0.0;
//            double superficieProyecto = 0.0;
//            String det; // contienen el detalle de la factura
//            det = "CP:"+encCP.getSerieCP()+"-"+encCP.getCodigoCP()+" - MAT:"+encCP.getMatriculado().getMatricula();
//            // aqui solo se suman las superficies de los tipos de trabajo
//            while(it.hasNext())
//            {
//                DetalleCP d = (DetalleCP)it.next();
//                if(d.getTipoTrabajo().getNombre().trim().equals("RELEVAMIENTO"))
//                    superficieRelevamiento += d.getSuperficie();
//                else
//                    superficieProyecto += d.getSuperficie();
//                d=null;
//            }
//            // ya tengo los valores de superficie, ahora armo el detalle
//            it = null;
//            Iterator i = tasas.iterator();
//            double indiceRelevamiento = 0.0; // tiene el valor en pesos 
//            double tasaMinimaCalculo = 0.0;
//            double indiceConduccion = 0.0; // tiene el valor en pesos
//            double indiceCalculo = 0.0; // tiene la suma de indices
//            // ahora es cuando se realiza el calculo
//            while(i.hasNext())
//            {
//                Tasa t = (Tasa)i.next();
//                Producto producto = new Producto();
//                producto = listar.listar(t);
//                DetalleFactura detalleFactura = new DetalleFactura();
//                if(t.getDenominacion().trim().equals("RELEVAMIENTO"))
//                {
//                    indiceRelevamiento = superficieRelevamiento * t.getIndice();
//                    if(indiceRelevamiento < t.getTasaMinima())
//                        indiceRelevamiento = t.getTasaMinima();
//                    detalleFactura = this.llenarDetalleFactura(detalleFactura, det, indiceRelevamiento, producto);
//                }
//                
//                else
//                    if(t.getDenominacion().trim().equals("CONDUCCION TECNICA"))
//                    {
//                        indiceConduccion = superficieProyecto * t.getIndice();
//                        if(indiceConduccion < t.getTasaMinima())
//                            indiceConduccion = t.getTasaMinima();
//                        detalleFactura = this.llenarDetalleFactura(detalleFactura, det, indiceConduccion, producto);
//                    }
//                    else
//                    {
//                        indiceCalculo = superficieProyecto * t.getIndice();
//                        //tasaMinimaCalculo = t.getTasaMinima();
//                        if(indiceCalculo < t.getTasaMinima())
//                            indiceCalculo = t.getTasaMinima();
//                        detalleFactura = this.llenarDetalleFactura(detalleFactura, det, indiceCalculo, producto);
//                    }
//                t = null;
//                // aqui tengo que pasarle el objeto detalleFactura al metodo que se encarga de agregarlo a la grilla
//                this.agregarLineaDetalle(detalleFactura);
//                
//                
//                producto = null;
//                detalleFactura = null;
//            }
//            
//        }
//            // aqui se calcula el monto de cada linea de detalle
//        else
//        {
//            Iterator i = tasas.iterator();
//            String det = "CT:"+encCT.getSerieCT()+"-"+encCT.getCodigoCT()+" - MAT:"+encCT.getMatriculado().getMatricula();
//            while(i.hasNext())
//            {
//                Tasa t = (Tasa)i.next();
//                Producto producto = new Producto();
//                producto = listar.listar(t);
//                
//                DetalleFactura detalleFactura = new DetalleFactura();
//                detalleFactura = this.llenarDetalleFactura(detalleFactura, det, this.getMontoTasa(t.getIdtasa()), producto);
//                // solo queda pasarle el objeto detalleFactura para que sea cargado en la grilla
//                this.agregarLineaDetalle(detalleFactura);
//            }
//        }
////JORGE**************************************************************            
//        //ESTA LINEA LA AGREGUE PARA IDENTIFICAR LA FILA
//        //DE QUE DOCUMENTO SE DEBE IMPRIMIR        
//        this.agregarACollectionDeImpresion(Integer.parseInt(String.valueOf(this.jTable2.getSelectedRow())));        
//    }
    
    
    
    private void mostrarConstancias()
    {
        CListar listar = new CListar();
        this.constanciasParciales = this.mostrarConstanciasParciales(listar);
        this.constanciasTotales = this.mostrarConstanciasTotales(listar);
        this.cuotas = this.mostrarCuotas(listar);
        this.cuotasAlumnos = this.mostrarCuotasAlumnos();
    }
    
    private Collection<Pago> mostrarCuotasAlumnos()
    {
        PagosSql sql = new PagosSql();
        Collection<Pago> co = sql.getPagosAFacturar();
        Iterator<Pago> it = co.iterator();
        DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
        String datos[] = new String[4];
        datos[0] = "CA";
        while(it.hasNext())
        {
            Pago p = it.next();
            datos[1] = String.valueOf(p.getIdCuota());
            datos[2] = String.valueOf(p.getIdPago());
            datos[3] = this.getDni(p.getIdCuota());
            modelo.addRow(datos);
        }
        return co;
    }
    
    private String getDni(long idCuota)
    {
        long dni = 0;
        CuotasSql sql = new CuotasSql();
        return sql.getDni(idCuota);
    }
    
    private Collection mostrarConstanciasParciales(CListar listar)
    {
        Collection constancias = new ArrayList();
        constancias = listar.hacerListadoEncabezadoCP(new EncabezadoCP(),1,"0","0");
        Iterator it = constancias.iterator();
        DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
        String datos[] = new String[4];
        datos[0] = "CP";
        while(it.hasNext())
        {
            EncabezadoCP e = (EncabezadoCP)it.next();
            // ahora cargo la grilla
            datos[1] = e.getSerieCP();
            datos[2] = String.valueOf(e.getCodigoCP());
            datos[3] = String.valueOf(e.getMatriculado().getMatricula());
            modelo.addRow(datos);
            e = null;
        }
        datos = null;
        return constancias;
    }

    private Collection mostrarConstanciasTotales(CListar listar)
    {
        Collection constancias = new ArrayList();
        constancias = listar.hacerListadoEncabezadoCT(new EncabezadoCT(),1,"0","0");
        Iterator it = constancias.iterator();
        DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
        String datos[] = new String[4];
        datos[0] = "CT";
        while(it.hasNext())
        {
            EncabezadoCT e = (EncabezadoCT)it.next();
            // ahora cargo la grilla
            datos[1] = e.getSerieCT();
            datos[2] = String.valueOf(e.getCodigoCT());
            datos[3] = String.valueOf(e.getMatriculado().getMatricula());
            modelo.addRow(datos);
            e = null;
        }
        datos = null;
        return constancias;
    }

    private double getMontoTasa(int idTasa)
    {
        double devolver = 0.0;
        Iterator it = this.tasasSeleccionadas.iterator();
        while(it.hasNext())
        {
            TasaSeleccionada t = (TasaSeleccionada)it.next();
            if(t.getIdTasa() == idTasa)
            {
                devolver = t.getMonto();
                break;
            }
                
        }
        return devolver;
    }
    
    private DetalleFactura llenarDetalleFactura(DetalleFactura d, String detalle, double subtotal, Producto prod){
        d.setCantidad(1);
        d.setDetalle(detalle.trim());
        d.setSubTotal(subtotal);
        prod.setPrecio(subtotal);
        d.setProducto(prod);
        return d;
    }
    private boolean esAutomatico()
    {
        boolean bandera = true;
        int serieSeleccionada = Integer.valueOf(this.jCSeries.getSelectedItem().toString().trim());
        Iterator it = this.series.iterator();
        while(it.hasNext())
        {
            SerieFactura s = (SerieFactura)it.next();
            if(s.getSerie()==serieSeleccionada){
                    if(s.getTipoDeCarga().trim().equals("M"))
                        bandera = false;
            }            
            s = null;
        }        
        return bandera;
    }
    private void anularFactura(){        
        Modificacion modif=new Modificacion();
        EncabezadoFactura enca=new EncabezadoFactura();
        enca.setSerieFactura(Integer.valueOf(this.jCSeries.getSelectedItem().toString().trim()));
        enca.setNumeroFactura(Long.valueOf(this.jTNumeroFactura.getText().trim()));
        
        int respuesta=modif.anularFactura(enca);
        
        if (respuesta!=0){
            JOptionPane.showMessageDialog(this,"La Factura: "+enca.getSerieFactura()+"-"+enca.getNumeroFactura()+" a sido anulada","Anulacion de Factura",JOptionPane.INFORMATION_MESSAGE);
            //pasar los documentos a ventana izquierda
            for (int i=0;i<this.array1TipoDoc.length;i++){
//                System.out.println("SE IMPRIME TIPODOC: "+ this.array1TipoDoc[i]);
//                System.out.println("SE IMPRIME SERIE: "+ this.array2Serie[i]);
//                System.out.println("SE IMPRIME ID: "+ this.array3Id[i]);
                
                if(this.array1TipoDoc[i].equals("CP")){
                    String encCPSerie = this.array2Serie[i];
                    String encCPCodigo = this.array3Id[i];
                    
                    Modificacion ponerFacturaDeCPenCero=new Modificacion();
                    int resp=ponerFacturaDeCPenCero.modificarPonerCPconFacturaEnCero(encCPSerie, Long.parseLong(encCPCodigo.trim()));
                    if (resp!=0){
                        JOptionPane.showMessageDialog(this,"La Constancia Total: "+encCPSerie+":"+encCPCodigo+" podra ser facturada en otro documento de factura","Documento CP podra ser facturado",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this,"La Constancia Total: "+encCPSerie+":"+encCPCodigo+" no podra ser facturada en otro documento de factura, debera crear uno nuevo para facturarlo","Error!",JOptionPane.ERROR_MESSAGE);
                    }
                    ponerFacturaDeCPenCero=null;
                }
                
                
                if (this.array1TipoDoc[i].equals("CT")){
                    String encCTSerie = this.array2Serie[i];
                    String encCTCodigo = this.array3Id[i];
                    
                    Modificacion ponerFacturaDeCTenCero=new Modificacion();
                    int resp=ponerFacturaDeCTenCero.modificarPonerCTconFacturaEnCero(encCTSerie, Long.parseLong(encCTCodigo.trim()));
                    if (resp!=0){
                        JOptionPane.showMessageDialog(this,"La Constancia Total: "+encCTSerie+":"+encCTCodigo+" podra ser facturada en otro documento de factura","Documento CT podra ser facturado",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this,"La Constancia Total: "+encCTSerie+":"+encCTCodigo+" no podra ser facturada en otro documento de factura, debera crear uno nuevo para facturarlo","Error!",JOptionPane.ERROR_MESSAGE);
                    }
                    ponerFacturaDeCTenCero=null;
                }
                
                if (this.array1TipoDoc[i].equals("CUOTA")){
                    //String encCTSerie = String.valueOf(this.jTable2.getValueAt(item, 1));
                    String encPago = this.array3Id[i];
                    
                    Modificacion ponerFacturaDePagoEnCero=new Modificacion();
                    int resp=ponerFacturaDePagoEnCero.modificarPonerEncabezadoPagoconFacturaEnCero(Long.parseLong(encPago.trim()));
                    if (resp!=0){
                        JOptionPane.showMessageDialog(this,"El documendo de PAGO: "+encPago+" podra ser facturada en otro documento de factura","Documento de Pago podra ser facturado",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this,"El documendo de PAGO: "+encPago+" no podra ser facturado en otro documento de factura\ndebera crear uno nuevo para facturarlo","Error!",JOptionPane.ERROR_MESSAGE);
                    }
                    ponerFacturaDePagoEnCero=null;
                }
            }
            //despues de la anulacion, se muestra los documentos recuperados
            //que podran ser facturados en otra factura
            this.actualizar();
        }else{
            JOptionPane.showMessageDialog(this,"No se pudo anular la Factura, seguira siendo NO ANULADA","Error en la Anulacion",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public Iva obtenerIva()
    {
       String seleccion = String.valueOf(this.jCIva.getSelectedItem()).trim();
       CListar listar = new CListar();
       Iva iva1 =  new Iva();
       Iva iva2 =  new Iva();
       Collection co = new ArrayList();
       co = listar.hacerListado(iva2);
       Iterator it = co.iterator();
       listar = null;
       while (it.hasNext())
       {
           iva2 = (Iva)it.next();
           if (seleccion.trim().equals(iva2.getNombre().trim()))
           {
               iva1 = iva2;
               break;
           }
                
       }
       iva2 = null;
       co = null;
       return iva1;
    }
    public CondicionVenta obtenerCondicionVenta()
    {
       String seleccion = String.valueOf(this.jCCondicionVenta.getSelectedItem()).trim();
       CListar listar = new CListar();
       CondicionVenta cond1 =  new CondicionVenta();
       CondicionVenta cond2 =  new CondicionVenta();
       Collection co = new ArrayList();
       co = listar.hacerListado(cond2);
       Iterator it = co.iterator();
       listar = null;
       while (it.hasNext())
       {
           cond2 = (CondicionVenta)it.next();
           if (seleccion.trim().equals(cond2.getNombre().trim()))
           {
               cond1 = cond2;
               break;
           }
                
       }
       cond2 = null;
       co = null;
       return cond1;
    }
    
    
    private Collection mostrarCuotas(CListar listar)
    {
        Collection vCuotas = new ArrayList();
        Collection temp = new ArrayList();
        EncabezadoPago encabezado = new EncabezadoPago();
        encabezado.setIdencabezado(0);
        temp = listar.hacerListado(encabezado);
        Iterator it = temp.iterator();
        while(it.hasNext())
        {
            EncabezadoPago e = (EncabezadoPago)it.next();
            if(e.getNrofactura() == 0)
                vCuotas.add(e);
            e = null;
        }
        temp = null;
        DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
        String datos[] = new String[4];
        datos[0] = "CUOTA";
        it = vCuotas.iterator();
        while(it.hasNext())
        {
            EncabezadoPago e = (EncabezadoPago)it.next();
            // ahora cargo la grilla
            datos[1] = "---";
            datos[2] = String.valueOf(e.getIdencabezado());
            datos[3] = String.valueOf(e.getMatricula());
            //datos[3] = String.valueOf(this.getMatriculado(e.getIdmatriculado(), listar).getMatricula());
            modelo.addRow(datos);
            e = null;
        }
        it = null;
        return vCuotas;
    }

    private void facturarCT(CListar listar, Collection tasas, int fila)
    {
        int filas = 0;
        DetalleCT d = new DetalleCT();
        EncabezadoCT encCT = new EncabezadoCT();
        encCT = this.getEncabezadoCT(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
            d.setCodigoCT(encCT.getCodigoCT());
            d.setSerieCT(encCT.getSerieCT());
            //detalle = listar.hacerListadoDetalleCT(d);
//            tasas = listar.armarDetalleFactura(encCT.getSerieCT(), String.valueOf(encCT.getCodigoCT()), "CT");
            Consulta con = new Consulta();
            tasas = con.armarDetalleCT2(encCT.getSerieCT(), String.valueOf(encCT.getCodigoCT()));
            filas = this.jTableDetalleFactura.getRowCount();
            if((18-filas) >= tasas.size()) // aqui controlo que el detalle entre en la grilla (Que no supere las 18 lineas)
            {
                this.tasasSeleccionadas = listar.listar(encCT.getSerieCT(), encCT.getCodigoCT());
                Iterator i = tasas.iterator();
                StringBuffer det = new StringBuffer();
                det.append("CT:");
                det.append(encCT.getSerieCT());
                det.append("-");
                det.append(encCT.getCodigoCT());
                det.append(" - MAT:");
                det.append(encCT.getMatriculado().getMatricula());
                while(i.hasNext())
                {
                    Tasa t = (Tasa)i.next();
                    String deta;
                    Producto producto = new Producto();
                    producto = listar.listar(t);
                    DetalleFactura detalleFactura = new DetalleFactura();
                    deta = det.toString()+" - "+t.getSuperficie()+"X"+t.getIndice();
                    detalleFactura = this.llenarDetalleFactura(detalleFactura, deta, this.getMontoTasa(t.getIdtasa()), producto);
                // solo queda pasarle el objeto detalleFactura para que sea cargado en la grilla
                    this.agregarLineaDetalle(detalleFactura);
                }
                this.bloquedas.add(fila);
            }
            else
                JOptionPane.showMessageDialog(null, "No se pueden agregar el documento a la factura", "El doc supera las lineas disponibles",JOptionPane.ERROR_MESSAGE);
    }
    private void facturarCP(int fila)
    {
        Collection detalleFacturacionCP = new ArrayList();
        Consulta con = new Consulta();
        CListar listar = new CListar();
        int filas = 0;
        EncabezadoCP encCP = new EncabezadoCP();
        encCP = this.getEncabezadoCP(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
        detalleFacturacionCP = con.getDetalleFacturacionCP(encCP.getSerieCP().trim(), encCP.getCodigoCP());
        // hasta aqui tengo la coleccion con los detalles de facturacion
        // ahora tengo que cargar los datos en la calse DetalleCP
        
        filas = this.jTableDetalleFactura.getRowCount();
        if((18-filas) >= detalleFacturacionCP.size()) // aqui controlo que el detalle entre en la grilla (Que no supere las 18 lineas)
        {
            Iterator it = detalleFacturacionCP.iterator();
            while(it.hasNext())
            {
                DetalleCPParaFacturacion d = (DetalleCPParaFacturacion)it.next();
                DetalleFactura detalleFactura = new DetalleFactura();
                Producto producto = new Producto();
                Tasa t = new Tasa();
                t = con.getTasa(d.getNombreTasa().trim(), "algo");
                producto = listar.listar(t);
                t = null;
                producto.setPrecio(d.getSubTotal());
                detalleFactura.setCantidad(1);
                detalleFactura.setDetalle(d.getDetalle().trim()+" - "+d.getValorSuperficie()+"X"+d.getValorIndiceDeTasa());
                
                detalleFactura.setSubTotal(d.getSubTotal());
                //producto.setPrecio(d.getSubTotal());
                //prod.setDenominacion(d.getNombreTasa().trim());
                detalleFactura.setProducto(producto);
                this.agregarLineaDetalle(detalleFactura);
                producto = null;
                detalleFactura = null;
            }
            this.bloquedas.add(fila);
        }
        else
                JOptionPane.showMessageDialog(null, "No se pueden agregar el documento a la factura", "El doc supera las lineas disponibles",JOptionPane.ERROR_MESSAGE);
    }
    
    private void facturarCuota(CListar listar, int fila)
    {
        if((18-this.jTableDetalleFactura.getRowCount()) == 0)
            JOptionPane.showMessageDialog(this, "No se pueden agregar el documento a la factura", "El doc supera las lineas disponibles",JOptionPane.ERROR_MESSAGE);
        else
        {
            // obtener las cuotas a pagar de la linea seleccionada
            boolean bandera = true;
            int anioBase = 0;
            Collection vCuotas = new ArrayList();
            DetalleFactura detalleFactura = new DetalleFactura();
            DetalleFactura detalleFactura2 = new DetalleFactura();
            
            DetallePago detallePago = new DetallePago();
            EncabezadoPago encPago = new EncabezadoPago();
            encPago = this.getEncabezadoPago(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
            // ya tengo el objeto encabezado Pago
            detallePago.setIdencabezadopago(encPago.getIdencabezado());
            
            GregorianCalendar fec = new GregorianCalendar();
            fec.setGregorianChange(encPago.getFechapago());
            detallePago.setAnio(fec.get(Calendar.YEAR));
            
            Consulta con=new Consulta();
            vCuotas = con.getDetallePago(detallePago.getIdencabezadopago());
            //-----
            Iterator it = vCuotas.iterator();
            StringBuffer detalleFac = new StringBuffer();
            double importe = 0.0;
            while(it.hasNext()){
                DetallePago d = (DetallePago)it.next();
                
                //---
                if (d.getIdproducto()==Integer.parseInt(this.reinscripcion)||d.getIdproducto()==Integer.parseInt(this.inscripcion)||d.getIdproducto()==Integer.parseInt(this.reinscripcion2vez)){
                    detalleFactura2.setCantidad(1);
                    detalleFactura2.setDetalle("");
                    detalleFactura2.setSubTotal(importe);
                    Producto prod2 = new Producto();                                       
                    prod2 = this.getProducto(Integer.parseInt(String.valueOf(d.getIdproducto()).trim()), listar);
                    prod2.setPrecio(d.getImporte());
                    detalleFactura2.setProducto(prod2);
                    this.agregarLineaDetalle(detalleFactura2);
                }
                //---
                
                
                if (d.getIdproducto()==Integer.parseInt(this.pagoMatricula)){ //--------
                    if(bandera){
                        bandera = false;
                        anioBase = d.getAnio();
                        detalleFac.append("CU:"+d.getIdencabezadopago()+":"+encPago.getMatricula()+"-");
                 
                        detalleFac.append(anioBase);
                        detalleFac.append(":");
                        detallePago.setIdproducto(d.getIdproducto());
                    }else {
                        if(anioBase != d.getAnio()){
                            detalleFac.append(";");
                            detalleFac.append(d.getAnio());
                            detalleFac.append(":");
                            anioBase = d.getAnio();
                        }else
                            detalleFac.append(",");
                    }
                    detalleFac.append(this.getMes(d.getMes()));                
                    importe = importe + d.getImporte();
                    d = null;
                    
                } //--------
            }
            
            detalleFactura.setCantidad(1);
            detalleFactura.setDetalle(detalleFac.toString());
            detalleFactura.setSubTotal(importe);
            
            Producto prod = new Producto();
            prod = this.getProducto(Integer.parseInt(String.valueOf(detallePago.getIdproducto())), listar);
            prod.setPrecio(importe);
            detalleFactura.setProducto(prod);
            this.agregarLineaDetalle(detalleFactura);
            
            
            it = null;
            this.bloquedas.add(fila);
        }
    }
    
//    private void facturarCuotaAlumno(int fila)
//    {
//        if((18-this.jTableDetalleFactura.getRowCount()) == 0)
//            JOptionPane.showMessageDialog(this, "No se pueden agregar el documento a la factura", "El doc supera las lineas disponibles",JOptionPane.ERROR_MESSAGE);
//        else
//        {
//            //obtener el pago a realizar
//            Pago p = this.facturarCuota(Long.parseLong(String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2))));
//            DetalleFactura detalleFactura2 = new DetalleFactura();
//            detalleFactura2.setCantidad(1);
//            detalleFactura2.setDetalle("");
//            detalleFactura2.setSubTotal(p.getMonto());
//            Producto prod2 = new Producto();                                       
//            prod2 = this.getProducto(Integer.parseInt(String.valueOf(d.getIdproducto()).trim()), listar);
//            prod2.setPrecio(d.getImporte());
//            detalleFactura2.setProducto(prod2);
//            this.agregarLineaDetalle(detalleFactura2);
//            
//            
//            // obtener las cuotas a pagar de la linea seleccionada
//            boolean bandera = true;
//            int anioBase = 0;
//            Collection vCuotas = new ArrayList();
//            DetalleFactura detalleFactura = new DetalleFactura();
//            
//            
//            DetallePago detallePago = new DetallePago();
//            EncabezadoPago encPago = new EncabezadoPago();
//            encPago = this.getEncabezadoPago(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
//            // ya tengo el objeto encabezado Pago
//            detallePago.setIdencabezadopago(encPago.getIdencabezado());
//            
//            GregorianCalendar fec = new GregorianCalendar();
//            fec.setGregorianChange(encPago.getFechapago());
//            detallePago.setAnio(fec.get(Calendar.YEAR));
//            
//            Consulta con=new Consulta();
//            vCuotas = con.getDetallePago(detallePago.getIdencabezadopago());
//            //-----
//            Iterator it = vCuotas.iterator();
//            StringBuffer detalleFac = new StringBuffer();
//            double importe = 0.0;
//            while(it.hasNext()){
//                DetallePago d = (DetallePago)it.next();
//                
//                //---
//                if (d.getIdproducto()==Integer.parseInt(this.reinscripcion)||d.getIdproducto()==Integer.parseInt(this.inscripcion)||d.getIdproducto()==Integer.parseInt(this.reinscripcion2vez)){
//                    detalleFactura2.setCantidad(1);
//                    detalleFactura2.setDetalle("");
//                    detalleFactura2.setSubTotal(importe);
//                    Producto prod2 = new Producto();                                       
//                    prod2 = this.getProducto(Integer.parseInt(String.valueOf(d.getIdproducto()).trim()), listar);
//                    prod2.setPrecio(d.getImporte());
//                    detalleFactura2.setProducto(prod2);
//                    this.agregarLineaDetalle(detalleFactura2);
//                }
//                //---
//                
//                
//                if (d.getIdproducto()==Integer.parseInt(this.pagoMatricula)){ //--------
//                    if(bandera){
//                        bandera = false;
//                        anioBase = d.getAnio();
//                        detalleFac.append("CU:"+d.getIdencabezadopago()+":"+encPago.getMatricula()+"-");
//                 
//                        detalleFac.append(anioBase);
//                        detalleFac.append(":");
//                        detallePago.setIdproducto(d.getIdproducto());
//                    }else {
//                        if(anioBase != d.getAnio()){
//                            detalleFac.append(";");
//                            detalleFac.append(d.getAnio());
//                            detalleFac.append(":");
//                            anioBase = d.getAnio();
//                        }else
//                            detalleFac.append(",");
//                    }
//                    detalleFac.append(this.getMes(d.getMes()));                
//                    importe = importe + d.getImporte();
//                    d = null;
//                    
//                } //--------
//            }
//            
//            detalleFactura.setCantidad(1);
//            detalleFactura.setDetalle(detalleFac.toString());
//            detalleFactura.setSubTotal(importe);
//            
//            Producto prod = new Producto();
//            prod = this.getProducto(Integer.parseInt(String.valueOf(detallePago.getIdproducto())), listar);
//            prod.setPrecio(importe);
//            detalleFactura.setProducto(prod);
//            this.agregarLineaDetalle(detalleFactura);
//            
//            
//            it = null;
//            this.bloquedas.add(fila);
//        }
//    }


    
    
    
    
    private Producto getProducto(int id, CListar listar)
    {
        Producto producto = new Producto();
        producto.setIdproducto(id);
        Iterator it = listar.hacerListado(producto).iterator();
        while(it.hasNext())
        {
            Producto p = (Producto)it.next();
            producto = p;
            p = null;
        }
        return producto;
    }
    
    private String getMes(int numero)
    {
        String mes = "";
        switch (numero)
        {
            case 1:
                    mes = "ENE";
                    break;
            case 2:
                    mes = "FEB";
                    break;
            case 3:
                    mes = "MAR";
                    break;
            case 4:
                    mes = "ABR";
                    break;
            case 5:
                    mes = "MAY";
                    break;
            case 6:
                    mes = "JUN";
                    break;
            case 7:
                    mes = "JUL";
                    break;
            case 8:
                    mes = "AGO";
                    break;
            case 9:
                    mes = "SEP";
                    break;
            case 10:
                    mes = "OCT";
                    break;
            case 11:
                    mes = "NOV";
                    break;
            case 12:
                    mes = "DIC";
                    break;
        }
        return mes;
    }
private void facturar(int fila)
{
        Collection tasas = new ArrayList();
        CListar listar = new CListar();
        String doc = String.valueOf(this.jTable2.getValueAt(fila, 0));
        if(doc.equals("CP"))
            this.facturarCP(fila);
        else
            if(doc.equals("CT"))
                this.facturarCT(listar, tasas, fila);
            else
                if(doc.equals("CA"))
                    System.out.println();
                else        
                    this.facturarCuota(listar, fila);

        //JORGE**************************************************************            
        //ESTA LINEA LA AGREGUE PARA IDENTIFICAR LA FILA
        //DE QUE DOCUMENTO SE DEBE IMPRIMIR        
        this.agregarACollectionDeImpresion(Integer.parseInt(String.valueOf(this.jTable2.getSelectedRow())));
    }

private EncabezadoPago getEncabezadoPago(long id)
    {
        EncabezadoPago en = new EncabezadoPago();
        Iterator it = this.cuotas.iterator();
        while(it.hasNext())
        {
            EncabezadoPago e = (EncabezadoPago)it.next();
            if(e.getIdencabezado() == id)
            {
                en = e;
                e = null;
                break;
            }
                
            e = null;
        }
        it = null;
        return en;
    }
private boolean controlarFila(int fila)
    {
        boolean bandera = true;
        Iterator it = this.bloquedas.iterator();
        int fil;
        while(it.hasNext())
        {
            fil = (Integer)it.next();
            if (fil == fila)
                bandera = false;
        }
        return bandera;
    }
private boolean controlarCampos()
    {
        boolean bandera = true;
        
        if (!this.fechaCorrectaControl()){
            JOptionPane.showMessageDialog(this,"El Formato de Fecha es incorrecta Ingrese DD/MM/AAAA HH:MM:SS","Formato de Fecha incorrecta",JOptionPane.WARNING_MESSAGE);
            bandera = false;            
        }
        
//        if(this.jTNumeroFactura.getText().trim().length()==0){
//            bandera = false;            
//            JOptionPane.showMessageDialog(this,"El numero de factura esta vacio","Nro de factura vacia",JOptionPane.WARNING_MESSAGE);
//        }        
        if(!this.esAutomatico()){
            if(this.jTNumeroFactura.getText().trim().length()==0){
                bandera = false;            
                JOptionPane.showMessageDialog(this,"Debe cargar un numero de factura","Nro de Factura nula",JOptionPane.ERROR_MESSAGE);
            }            
            if(this.jCSeries.getSelectedItem().toString().trim().length()==0){
                bandera = false;            
                JOptionPane.showMessageDialog(this,"Debe cargar un numero de serie de factura","Nro de Serie de Factura nula",JOptionPane.WARNING_MESSAGE);
            }
        }
        // control        
        if(this.jTNombreClientes.getText().trim().length() == 0){
            //JOptionPane.showMessageDialog(this,"Debe cargar un nombre de cliente","Especifique Cliente",JOptionPane.WARNING_MESSAGE);            
            //bandera = false;
            this.jTNombreClientes.setText("-");
        }   
        if(this.jTDomicilio.getText().trim().length() == 0){
            this.jTDomicilio.setText("-");
        }
        if(this.jTCuilCuit.getText().trim().length() == 0){
            this.jTCuilCuit.setText("-");
        }
        if(this.jTNumeroRemito.getText().trim().length() == 0){
            this.jTNumeroRemito.setText("-");
        }        
        return bandera;
    }

private boolean fechaCorrectaControl(){
        Boolean fechaCorrecta=false;
        
        //DateFormat df=DateFormat.getInstance();//el formato de fecha debe ser DD/MM/AAAA si quiero formato DD/MM/AAAA HH:MM:SS uso getInstance
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        
        //Date fecha;//fecha actual por defecto
        try{
            java.util.Date fecha=sdf.parse(this.jTFecha.getText().trim()); 
            fechaCorrecta=true;
//            System.out.println("FECHA CORRECTA.......");
        }catch(ParseException pe){
            fechaCorrecta=false;
//            System.out.println(pe.getMessage());
        }        
        return fechaCorrecta;
    }
private void actualizarDocumentos()
    {
        Iterator it = this.bloquedas.iterator();
        String doc = "";
        while(it.hasNext())
        {
            int fila = (Integer)it.next();
            doc = String.valueOf(this.jTable2.getValueAt(fila, 0));
            if(doc.trim().equals("CP"))
                this.actualizarCP(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
            else
                if(doc.trim().equals("CT"))
                    this.actualizarCT(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
                else
                    this.actualizarCuota(Long.parseLong(String.valueOf(this.jTable2.getValueAt(fila, 2))));
        }
    }
    
    private void actualizarCT(long codigo){
        EncabezadoCT encabezado = new EncabezadoCT();
        encabezado = this.getEncabezadoCT(codigo);
        encabezado.setSerieFactura(Integer.parseInt(String.valueOf(this.jCSeries.getSelectedItem())));
        encabezado.setNumeroFactura(Long.parseLong(this.jTNumeroFactura.getText()));
        Modificacion mod = new Modificacion();
        if(mod.modificar(encabezado) == 0)
            JOptionPane.showMessageDialog(null, "Falla en la modificacion de los datos, intente de nuevo mas tarde", "Falla de modificacion", JOptionPane.ERROR_MESSAGE);
    }
    
    private void actualizarCP(long codigo)
    {
        
        EncabezadoCP encabezado = new EncabezadoCP();
        encabezado = this.getEncabezadoCP(codigo);
        encabezado.setSerieFactura(Integer.parseInt(String.valueOf(this.jCSeries.getSelectedItem())));
        encabezado.setNumeroFactura(Long.parseLong(this.jTNumeroFactura.getText()));
        Modificacion mod = new Modificacion();
        if(mod.modificar(encabezado) == 0)
            JOptionPane.showMessageDialog(null, "Falla en la modificacion de los datos, intente de nuevo mas tarde", "Falla de modificacion", JOptionPane.ERROR_MESSAGE);
    }
    
    private void actualizarCuota(long codigo) {        
        EncabezadoPago encabezado = new EncabezadoPago();
        encabezado = this.getEncabezadoPago(codigo);
        encabezado.setSeriefactura(Long.parseLong(String.valueOf(this.jCSeries.getSelectedItem())));
        encabezado.setNrofactura(Long.parseLong(this.jTNumeroFactura.getText()));
        Modificacion mod = new Modificacion();
        if(mod.modificar(encabezado) == 0)
            JOptionPane.showMessageDialog(null, "Falla en la modificacion de los datos, intente de nuevo mas tarde", "Falla de modificacion", JOptionPane.ERROR_MESSAGE);
    }
    
    private void limpiarDocumentos()
    {
        DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
        while(this.jTable2.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }
    
    private void actualizar(){
        this.constanciasParciales.clear();
        this.constanciasTotales.clear();
        this.cuotasAlumnos.clear();
        this.cuotas.clear();
        if(this.jTableDetalleFactura.getRowCount() == 0)
            this.bloquedas.clear();
        this.limpiarDocumentos();
        this.mostrarConstancias();
    }
    
    private void ajustarColumnas()
    {
        TableColumn column = null;
         for (int i = 0; i < 7; i++) 
        {
            column = jTableDetalleFactura.getColumnModel().getColumn(i);
            switch(i)
            {
                case 0:
                        column.setPreferredWidth(18);
                        break;
                case 1:
                        column.setPreferredWidth(45);
                        break;
                case 2:
                        column.setPreferredWidth(261); 
                        break;
                case 3:
                        column.setPreferredWidth(171); 
                        break;
                case 4:
                        column.setPreferredWidth(15);                     
                        break;
                case 5:
                        column.setPreferredWidth(51); 
                        break;
                case 6:
                        column.setPreferredWidth(51);
                        break;
            }
        }
    }
    
    private void buscarAlumno()
    {
        AlumnosSql sql = new AlumnosSql();
        this.alumno = sql.getAlumno(Long.parseLong(this.jTMatricula.getText()));
        if(alumno != null)
        {
            this.jLNombreMatriculado.setText(this.alumno.getApellido().trim()+", "+this.alumno.getNombres().trim());
        }
    }
    
    private Pago facturarCuota(long idPago)
    {
        Iterator<Pago> it = this.cuotasAlumnos.iterator();
        Pago pago = null;
        while(it.hasNext())
        {
            Pago p = it.next();
            if(p.getIdPago() == idPago)
            {
                this.cuotasAlumnosFacturadas.add(p);
                pago = p;
                break;
            }
        }
        return pago;
    }
}
