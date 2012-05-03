/*
 * UIMatricualdos.java
 *
 * Created on 7 de enero de 2008, 12:26
 */

package vista;

//import Datos.Alta;
import Datos.Consulta;
import Datos.Consulta;
import Datos.Modificacion;
import controlador.CAlta;
import controlador.CListar;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
//import java.awt.image.ImageFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
//import javax.swing.Icon;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import negocios.Barrio;
import negocios.Configuracion;
import negocios.Copiar;
import negocios.Departamento;
import negocios.Escuela;
import negocios.Iva;
import negocios.Localidad;
import negocios.Matriculado;
import negocios.Nacionalidad;
import negocios.Provincia;
import negocios.Titulo;
import reportes.cExport_thread;

/**
 *
 * @author  Administrador
 */
public class UIMatriculados extends javax.swing.JFrame
{
    private Localidad localidad = new Localidad();
    private Localidad localidadLaboral = new Localidad();
    private Barrio barrio = new Barrio();
    private Barrio barrioLaboral = new Barrio();
    private Departamento departamento = new Departamento();
    private Departamento departamentoProfesional = new Departamento();
    private Provincia provincia = new Provincia();
    private Provincia provinciaLaboral = new Provincia();
    private Matriculado matriculado = new Matriculado();
    private Iva tipoiva = new Iva();
    private boolean ubicacion = false; // cuando ubicacion es false quiere decir que estoy cargando la direccion particular
                                        // si ubicacion es true entonces estoy cargando la direccion laboral
    private boolean origen = true; //cuando origen vale true quiere decir que esta pantalla fue llamada para crear un nuevo matriculado
    // eso quiere decir que hay que abrir la ventana con todos los campos en blanco
    private Collection nacionalidades = new ArrayList();
    private Collection titulos = new ArrayList();
    private Collection escuelas = new ArrayList();
    private Collection iva = new ArrayList();
    private Escuela escuela = new Escuela();
    private boolean imagenCargada = false;
//    private boolean imagenCargada;
    private File fotoOrigen;
    private File fotoDestino;
    private String modifica=null;
    private UIReporteMatriculados reporte = new UIReporteMatriculados();
    //private UIReporteMatriculados reporte = new UIReporteMatriculados("accedeALosMetodos");
    
    
    /** Creates new form UIMatricualdos */
    public UIMatriculados()
    {
        //initComponents();
    }
    /*
     * Este constructor se usa para dar de alta a un matriculado.
     */
    public UIMatriculados(String nuevo)
    {
        initComponents();
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
//                this.llenarCampos();
                this.cargarCombosFecha();
                this.cargarCombos();
                this.initCampos();
    }
    
    /**
     * solo ver los datos del matriculado, no permite la modificacion
     */
    public UIMatriculados(Matriculado matriculado)
    {
        
        this.matriculado = matriculado;
        this.escuela = matriculado.getEscuela();
        this.origen = false; // origen false es UPDATE y origen TRUE es INSERT
        initComponents();
        
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
                this.cargarCombosFecha();
                this.cargarCombos();                
                //System.out.println(matriculado.getIva().getNombre());                
                this.setearIva();
                this.llenarCampos();
                this.insertar(escuela);
    }
    
    /**
     * muestra los datos del matriculado y permite la modificacion de los datos
     */
    public UIMatriculados(Matriculado matriculado, String modif, UIReporteMatriculados reporte)
    {
        this.reporte = reporte;
        this.matriculado = matriculado;
        this.barrio = matriculado.getBarrio();
        this.barrioLaboral = matriculado.getBarrioProfesional();
        this.localidad = matriculado.getLocalidad();
        this.localidadLaboral = matriculado.getLocalidadProfesional();
        this.departamento = matriculado.getDepartamento();
        this.departamentoProfesional = matriculado.getDepartamentoProfesional();
        this.provincia = matriculado.getProvincia();
        this.provinciaLaboral = matriculado.getDepartamentoProfesional().getProvincia();
        this.escuela = matriculado.getEscuela();
        this.origen = false; // origen false es UPDATE y origen TRUE es INSERT
        this.modifica=modif;
        
        initComponents();
        
        // Codigo necesario para centrar la ventana
                Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
        //Fin del centrado
                this.cargarCombosFecha();
                this.cargarCombos();
                this.llenarCampos();
                this.setearIva();
                this.insertar(escuela);
                this.initCampos();
                this.jTMatriculaMatriculado.setEnabled(false);
                this.imagenCargada = false;
                this.jTFolioiMatriculado.setEnabled(true);
                this.jTLibroMatriculado.setEnabled(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLCalle = new javax.swing.JLabel();
        jLBarrio = new javax.swing.JLabel();
        jLDepartamento = new javax.swing.JLabel();
        jLLocalidad = new javax.swing.JLabel();
        jLProvincia = new javax.swing.JLabel();
        jTCalle = new javax.swing.JTextField();
        jTBarrio = new javax.swing.JTextField();
        jTDepartamento = new javax.swing.JTextField();
        jTLocalidad = new javax.swing.JTextField();
        jTProvincia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLCalle1 = new javax.swing.JLabel();
        jLBarrio1 = new javax.swing.JLabel();
        jLDepartamento1 = new javax.swing.JLabel();
        jLLocalidad1 = new javax.swing.JLabel();
        jLProvincia1 = new javax.swing.JLabel();
        jTCalle1 = new javax.swing.JTextField();
        jTBarrio1 = new javax.swing.JTextField();
        jTDepartamento1 = new javax.swing.JTextField();
        jTLocalidad1 = new javax.swing.JTextField();
        jTProvincia1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTLibroMatriculado = new javax.swing.JTextField();
        jTFolioiMatriculado = new javax.swing.JTextField();
        jLDni6 = new javax.swing.JLabel();
        jLDni7 = new javax.swing.JLabel();
        jLDni8 = new javax.swing.JLabel();
        jLDni9 = new javax.swing.JLabel();
        jLDni10 = new javax.swing.JLabel();
        jLDni11 = new javax.swing.JLabel();
        jCTitulo = new javax.swing.JComboBox();
        jCDiaInsc = new javax.swing.JComboBox();
        jCMesInsc = new javax.swing.JComboBox();
        jCAnioInsc = new javax.swing.JComboBox();
        jCDiaEgreso = new javax.swing.JComboBox();
        jCMesEgreso = new javax.swing.JComboBox();
        jCAnioEgreso = new javax.swing.JComboBox();
        jTEscuela = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTEspecialidad = new javax.swing.JTextField();
        jLDni12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLMatricula = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLDni = new javax.swing.JLabel();
        jTMatriculaMatriculado = new javax.swing.JTextField();
        jTApellidoMatriculado = new javax.swing.JTextField();
        jTNombreMatriculado = new javax.swing.JTextField();
        jTDniMatriculado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCNacionalidad = new javax.swing.JComboBox();
        jTTelefonoParcularMatriculado = new javax.swing.JTextField();
        jTTelefonoCelularMatriculado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTEmailMatriculado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCDiaNacimiento = new javax.swing.JComboBox();
        jCMesNacimiento = new javax.swing.JComboBox();
        jCAnioNacimiento = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLFoto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTTelefonoTrabajoMatriculado = new javax.swing.JTextField();
        jLTelefonoTrabajo = new javax.swing.JLabel();
        jLWeb = new javax.swing.JLabel();
        jTWebMatriculado = new javax.swing.JTextField();
        jLDni3 = new javax.swing.JLabel();
        jTCuitMatriculado = new javax.swing.JTextField();
        jLCuil = new javax.swing.JLabel();
        jTCuilMatriculado = new javax.swing.JTextField();
        jLDni13 = new javax.swing.JLabel();
        jTIngresosBrutos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCIva = new javax.swing.JComboBox();
        jLDni5 = new javax.swing.JLabel();
        jCHabilitado = new javax.swing.JComboBox();
        jBImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion de Matriculados");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección particular"));

        jLCalle.setBackground(new java.awt.Color(255, 255, 204));
        jLCalle.setText("Calle");
        jLCalle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCalle.setOpaque(true);

        jLBarrio.setBackground(new java.awt.Color(255, 255, 204));
        jLBarrio.setText("Barrio");
        jLBarrio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLBarrio.setOpaque(true);

        jLDepartamento.setBackground(new java.awt.Color(255, 255, 204));
        jLDepartamento.setText("Depto.");
        jLDepartamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDepartamento.setOpaque(true);

        jLLocalidad.setBackground(new java.awt.Color(255, 255, 204));
        jLLocalidad.setText("Localidad");
        jLLocalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLLocalidad.setOpaque(true);

        jLProvincia.setBackground(new java.awt.Color(255, 255, 204));
        jLProvincia.setText("Provincia");
        jLProvincia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLProvincia.setOpaque(true);

        jTCalle.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTCalle.setEnabled(false);
        jTCalle.setNextFocusableComponent(jTCalle1);
        jTCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCalleKeyPressed(evt);
            }
        });

        jTBarrio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTBarrio.setEnabled(false);
        jTBarrio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTBarrioKeyPressed(evt);
            }
        });

        jTDepartamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTDepartamento.setEnabled(false);
        jTDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDepartamentoKeyPressed(evt);
            }
        });

        jTLocalidad.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTLocalidad.setEnabled(false);
        jTLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTLocalidadKeyPressed(evt);
            }
        });

        jTProvincia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTProvincia.setEnabled(false);
        jTProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTProvinciaKeyPressed(evt);
            }
        });

        jButton1.setText("Inserta ubicacion");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLBarrio, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jTBarrio, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jTCalle, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jTLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jTProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Direccion Profesional"));

        jLCalle1.setBackground(new java.awt.Color(255, 255, 204));
        jLCalle1.setText("Calle");
        jLCalle1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCalle1.setOpaque(true);

        jLBarrio1.setBackground(new java.awt.Color(255, 255, 204));
        jLBarrio1.setText("Barrio");
        jLBarrio1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLBarrio1.setOpaque(true);

        jLDepartamento1.setBackground(new java.awt.Color(255, 255, 204));
        jLDepartamento1.setText("Depto.");
        jLDepartamento1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDepartamento1.setOpaque(true);

        jLLocalidad1.setBackground(new java.awt.Color(255, 255, 204));
        jLLocalidad1.setText("Localidad");
        jLLocalidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLLocalidad1.setOpaque(true);

        jLProvincia1.setBackground(new java.awt.Color(255, 255, 204));
        jLProvincia1.setText("Provincia");
        jLProvincia1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLProvincia1.setOpaque(true);

        jTCalle1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTCalle1.setEnabled(false);
        jTCalle1.setNextFocusableComponent(jTTelefonoTrabajoMatriculado);
        jTCalle1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCalle1KeyPressed(evt);
            }
        });

        jTBarrio1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTBarrio1.setEnabled(false);
        jTBarrio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTBarrio1KeyPressed(evt);
            }
        });

        jTDepartamento1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTDepartamento1.setEnabled(false);
        jTDepartamento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDepartamento1KeyPressed(evt);
            }
        });

        jTLocalidad1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTLocalidad1.setEnabled(false);
        jTLocalidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTLocalidad1KeyPressed(evt);
            }
        });

        jTProvincia1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTProvincia1.setEnabled(false);

        jButton2.setText("Inserta ubicacion");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLBarrio1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLProvincia1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLDepartamento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLLocalidad1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTProvincia1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(jTDepartamento1)
                            .addComponent(jTBarrio1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(jTLocalidad1)
                            .addComponent(jTCalle1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBarrio1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBarrio1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDepartamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDepartamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProvincia1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTProvincia1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion de matriculacion"));

        jTLibroMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTLibroMatriculado.setEnabled(false);
        jTLibroMatriculado.setNextFocusableComponent(jTFolioiMatriculado);
        jTLibroMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTLibroMatriculadoKeyPressed(evt);
            }
        });

        jTFolioiMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTFolioiMatriculado.setEnabled(false);
        jTFolioiMatriculado.setNextFocusableComponent(jCTitulo);
        jTFolioiMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFolioiMatriculadoKeyPressed(evt);
            }
        });

        jLDni6.setBackground(new java.awt.Color(255, 255, 204));
        jLDni6.setText("Escuela");
        jLDni6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni6.setOpaque(true);

        jLDni7.setBackground(new java.awt.Color(255, 255, 204));
        jLDni7.setText("Libro");
        jLDni7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni7.setOpaque(true);

        jLDni8.setBackground(new java.awt.Color(255, 255, 204));
        jLDni8.setText("Folio");
        jLDni8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni8.setOpaque(true);

        jLDni9.setBackground(new java.awt.Color(255, 255, 204));
        jLDni9.setText("Fecha Egreso");
        jLDni9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni9.setOpaque(true);

        jLDni10.setBackground(new java.awt.Color(255, 255, 204));
        jLDni10.setText("Fecha Insc.");
        jLDni10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni10.setOpaque(true);

        jLDni11.setBackground(new java.awt.Color(255, 255, 204));
        jLDni11.setText("Titulo");
        jLDni11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni11.setOpaque(true);

        jCTitulo.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCTitulo.setEnabled(false);
        jCTitulo.setNextFocusableComponent(jTEspecialidad);
        jCTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTituloActionPerformed(evt);
            }
        });
        jCTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTituloKeyPressed(evt);
            }
        });

        jCDiaInsc.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCDiaInsc.setEnabled(false);
        jCDiaInsc.setNextFocusableComponent(jCMesInsc);
        jCDiaInsc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCDiaInscKeyPressed(evt);
            }
        });

        jCMesInsc.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCMesInsc.setEnabled(false);
        jCMesInsc.setNextFocusableComponent(jCAnioInsc);
        jCMesInsc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCMesInscKeyPressed(evt);
            }
        });

        jCAnioInsc.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCAnioInsc.setEnabled(false);
        jCAnioInsc.setNextFocusableComponent(jCDiaEgreso);
        jCAnioInsc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCAnioInscKeyPressed(evt);
            }
        });

        jCDiaEgreso.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCDiaEgreso.setEnabled(false);
        jCDiaEgreso.setNextFocusableComponent(jCMesEgreso);
        jCDiaEgreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCDiaEgresoKeyPressed(evt);
            }
        });

        jCMesEgreso.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCMesEgreso.setEnabled(false);
        jCMesEgreso.setNextFocusableComponent(jCAnioEgreso);
        jCMesEgreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCMesEgresoKeyPressed(evt);
            }
        });

        jCAnioEgreso.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCAnioEgreso.setEnabled(false);
        jCAnioEgreso.setNextFocusableComponent(jTLibroMatriculado);
        jCAnioEgreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCAnioEgresoKeyPressed(evt);
            }
        });

        jTEscuela.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTEscuela.setEnabled(false);

        jButton4.setText("Insertar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        jTEspecialidad.setText("---");
        jTEspecialidad.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTEspecialidad.setEnabled(false);
        jTEspecialidad.setNextFocusableComponent(jCHabilitado);

        jLDni12.setBackground(new java.awt.Color(255, 255, 204));
        jLDni12.setText("Especialidad");
        jLDni12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni12.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLDni10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCDiaInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCMesInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCAnioInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDni7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTLibroMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDni8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFolioiMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLDni11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLDni6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLDni12, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                    .addComponent(jTEscuela, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addComponent(jButton4))
                            .addComponent(jCTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLDni9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCDiaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCMesEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCAnioEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDni10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCDiaInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCMesInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCAnioInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTLibroMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFolioiMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDni9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCDiaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCMesEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCAnioEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDni11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jBGuardar.setText("Guardar");
        jBGuardar.setEnabled(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jLMatricula.setBackground(new java.awt.Color(255, 255, 204));
        jLMatricula.setText("Matricula");
        jLMatricula.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLMatricula.setOpaque(true);

        jLApellido.setBackground(new java.awt.Color(255, 255, 204));
        jLApellido.setText("Apellido");
        jLApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLApellido.setOpaque(true);

        jLNombre.setBackground(new java.awt.Color(255, 255, 204));
        jLNombre.setText("Nombre");
        jLNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLNombre.setOpaque(true);

        jLDni.setBackground(new java.awt.Color(255, 255, 204));
        jLDni.setText("Dni");
        jLDni.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni.setOpaque(true);

        jTMatriculaMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTMatriculaMatriculado.setEnabled(false);
        jTMatriculaMatriculado.setNextFocusableComponent(jCDiaNacimiento);
        jTMatriculaMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTMatriculaMatriculadoKeyPressed(evt);
            }
        });

        jTApellidoMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTApellidoMatriculado.setEnabled(false);
        jTApellidoMatriculado.setNextFocusableComponent(jTNombreMatriculado);
        jTApellidoMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTApellidoMatriculadoKeyPressed(evt);
            }
        });

        jTNombreMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTNombreMatriculado.setEnabled(false);
        jTNombreMatriculado.setNextFocusableComponent(jTDniMatriculado);
        jTNombreMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreMatriculadoKeyPressed(evt);
            }
        });

        jTDniMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTDniMatriculado.setEnabled(false);
        jTDniMatriculado.setNextFocusableComponent(jTEmailMatriculado);
        jTDniMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDniMatriculadoKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 204));
        jLabel10.setText("Nacionalidad");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(255, 255, 204));
        jLabel11.setText("Nacimiento");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(255, 255, 204));
        jLabel12.setText("Tel. Particular");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(255, 255, 204));
        jLabel13.setText("Tel. Celular");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setOpaque(true);

        jCNacionalidad.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCNacionalidad.setEnabled(false);
        jCNacionalidad.setNextFocusableComponent(jTCalle);
        jCNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCNacionalidadActionPerformed(evt);
            }
        });
        jCNacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCNacionalidadKeyPressed(evt);
            }
        });

        jTTelefonoParcularMatriculado.setText("---");
        jTTelefonoParcularMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTTelefonoParcularMatriculado.setEnabled(false);
        jTTelefonoParcularMatriculado.setNextFocusableComponent(jCNacionalidad);
        jTTelefonoParcularMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTelefonoParcularMatriculadoKeyPressed(evt);
            }
        });

        jTTelefonoCelularMatriculado.setText("---");
        jTTelefonoCelularMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTTelefonoCelularMatriculado.setEnabled(false);
        jTTelefonoCelularMatriculado.setNextFocusableComponent(jTTelefonoParcularMatriculado);
        jTTelefonoCelularMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTelefonoCelularMatriculadoKeyPressed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 204));
        jLabel14.setText("E-mail");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel14.setOpaque(true);

        jTEmailMatriculado.setText("---");
        jTEmailMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTEmailMatriculado.setEnabled(false);
        jTEmailMatriculado.setNextFocusableComponent(jTTelefonoCelularMatriculado);
        jTEmailMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTEmailMatriculadoKeyPressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dia");

        jCDiaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCDiaNacimiento.setEnabled(false);
        jCDiaNacimiento.setNextFocusableComponent(jCMesNacimiento);
        jCDiaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCDiaNacimientoKeyPressed(evt);
            }
        });

        jCMesNacimiento.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCMesNacimiento.setEnabled(false);
        jCMesNacimiento.setNextFocusableComponent(jCAnioNacimiento);
        jCMesNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCMesNacimientoKeyPressed(evt);
            }
        });

        jCAnioNacimiento.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCAnioNacimiento.setEnabled(false);
        jCAnioNacimiento.setNextFocusableComponent(jTApellidoMatriculado);
        jCAnioNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCAnioNacimientoFocusLost(evt);
            }
        });
        jCAnioNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCAnioNacimientoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCAnioNacimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCAnioNacimientoKeyTyped(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mes");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Año");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jLDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTDniMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTEmailMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCNacionalidad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTTelefonoCelularMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTTelefonoParcularMatriculado, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTMatriculaMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCDiaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCMesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCAnioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTNombreMatriculado, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jTApellidoMatriculado, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTMatriculaMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCMesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCDiaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCAnioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTApellidoMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombreMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDniMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEmailMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTTelefonoCelularMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTTelefonoParcularMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165))
        );

        jButton3.setText("Insertar Foto");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLFoto.setText("NO IMAGE");
        jLFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTTelefonoTrabajoMatriculado.setText("---");
        jTTelefonoTrabajoMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTTelefonoTrabajoMatriculado.setEnabled(false);
        jTTelefonoTrabajoMatriculado.setNextFocusableComponent(jTWebMatriculado);
        jTTelefonoTrabajoMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTelefonoTrabajoMatriculadoKeyPressed(evt);
            }
        });

        jLTelefonoTrabajo.setBackground(new java.awt.Color(255, 255, 204));
        jLTelefonoTrabajo.setText("Tel. Trabajo");
        jLTelefonoTrabajo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLTelefonoTrabajo.setOpaque(true);

        jLWeb.setBackground(new java.awt.Color(255, 255, 204));
        jLWeb.setText("Web");
        jLWeb.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLWeb.setOpaque(true);

        jTWebMatriculado.setText("---");
        jTWebMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTWebMatriculado.setEnabled(false);
        jTWebMatriculado.setNextFocusableComponent(jTCuitMatriculado);
        jTWebMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTWebMatriculadoKeyPressed(evt);
            }
        });

        jLDni3.setBackground(new java.awt.Color(255, 255, 204));
        jLDni3.setText("Cuit");
        jLDni3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni3.setOpaque(true);

        jTCuitMatriculado.setText("---");
        jTCuitMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTCuitMatriculado.setEnabled(false);
        jTCuitMatriculado.setNextFocusableComponent(jTCuilMatriculado);
        jTCuitMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCuitMatriculadoKeyPressed(evt);
            }
        });

        jLCuil.setBackground(new java.awt.Color(255, 255, 204));
        jLCuil.setText("Cuil");
        jLCuil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCuil.setOpaque(true);

        jTCuilMatriculado.setText("---");
        jTCuilMatriculado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTCuilMatriculado.setEnabled(false);
        jTCuilMatriculado.setNextFocusableComponent(jCDiaInsc);
        jTCuilMatriculado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCuilMatriculadoKeyPressed(evt);
            }
        });

        jLDni13.setBackground(new java.awt.Color(255, 255, 204));
        jLDni13.setText("IB Nro:");
        jLDni13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni13.setOpaque(true);

        jTIngresosBrutos.setText("---");
        jTIngresosBrutos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTIngresosBrutos.setEnabled(false);
        jTIngresosBrutos.setNextFocusableComponent(jCDiaInsc);
        jTIngresosBrutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTIngresosBrutosKeyPressed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("I.V.A.");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);

        jCIva.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCIva.setEnabled(false);
        jCIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCIvaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTelefonoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTWebMatriculado)
                    .addComponent(jTTelefonoTrabajoMatriculado, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDni3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTCuitMatriculado)
                    .addComponent(jTCuilMatriculado, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLDni13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCIva, 0, 169, Short.MAX_VALUE)
                    .addComponent(jTIngresosBrutos, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefonoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTelefonoTrabajoMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCuitMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jCIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTWebMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCuilMatriculado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIngresosBrutos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLDni5.setBackground(new java.awt.Color(255, 255, 204));
        jLDni5.setText("Habilitado");
        jLDni5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLDni5.setOpaque(true);

        jCHabilitado.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCHabilitado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));
        jCHabilitado.setEnabled(false);
        jCHabilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCHabilitadoActionPerformed(evt);
            }
        });

        jBImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/printer.gif"))); // NOI18N
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(34, 34, 34))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jBGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jCHabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLDni5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLDni5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCHabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBGuardar, jBImprimir, jBSalir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
// TODO add your handling code here:
        UIListarEscuelas listar = new UIListarEscuelas(this);
        listar.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
// TODO add your handling code here:
        this.imagenCargada = true;
        
        this.cargarFoto();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBGuardarActionPerformed
    {//GEN-HEADEREND:event_jBGuardarActionPerformed
     
// TODO add your handling code here:
            if (this.controlar()) {
                try {
                    this.guardar();
                } catch (ParseException ex) {
                    Logger.getLogger(UIMatriculados.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Faltan Datos", JOptionPane.ERROR_MESSAGE);
            }//GEN-LAST:event_jBGuardarActionPerformed
       
    }                                         

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
// TODO add your handling code here:
        this.ubicacion = true;
        UIEligeDireccionBarrio barrios=new UIEligeDireccionBarrio(this,"JUJUY");
        barrios.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
// TODO add your handling code here:
        this.ubicacion = false;
        UIEligeDireccionBarrio barrios=new UIEligeDireccionBarrio(this);
        barrios.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCTituloActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCTituloActionPerformed
    {//GEN-HEADEREND:event_jCTituloActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jCTituloActionPerformed

    private void jCHabilitadoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCHabilitadoActionPerformed
    {//GEN-HEADEREND:event_jCHabilitadoActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jCHabilitadoActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCNacionalidadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCNacionalidadActionPerformed
    {//GEN-HEADEREND:event_jCNacionalidadActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jCNacionalidadActionPerformed

    private void jTMatriculaMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMatriculaMatriculadoKeyPressed
        // TODO add your handling code here:                   
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE)))){    
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 12","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jTMatriculaMatriculado.setText("");
            this.jTMatriculaMatriculado.requestFocus();
            evt.consume();
        }
        if(evt.getKeyCode()==27)
                this.dispose();
        if(evt.getKeyChar()==10)
                this.jCDiaNacimiento.requestFocus();
        
    }//GEN-LAST:event_jTMatriculaMatriculadoKeyPressed

    private void jCDiaNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCDiaNacimientoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCMesNacimiento.requestFocus();
    }//GEN-LAST:event_jCDiaNacimientoKeyPressed

    private void jCMesNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCMesNacimientoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCAnioNacimiento.requestFocus();
    }//GEN-LAST:event_jCMesNacimientoKeyPressed

    private void jCAnioNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioNacimientoKeyPressed
        // TODO add your handling code here:        
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTApellidoMatriculado.requestFocus();
    }//GEN-LAST:event_jCAnioNacimientoKeyPressed

    private void jTApellidoMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTApellidoMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTNombreMatriculado.requestFocus();
    }//GEN-LAST:event_jTApellidoMatriculadoKeyPressed

    private void jTNombreMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTDniMatriculado.requestFocus();
    }//GEN-LAST:event_jTNombreMatriculadoKeyPressed

    private void jTDniMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDniMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTEmailMatriculado.requestFocus();
    }//GEN-LAST:event_jTDniMatriculadoKeyPressed

    private void jTEmailMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEmailMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTTelefonoCelularMatriculado.requestFocus();
    }//GEN-LAST:event_jTEmailMatriculadoKeyPressed

    private void jTTelefonoCelularMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoCelularMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTTelefonoParcularMatriculado.requestFocus();
    }//GEN-LAST:event_jTTelefonoCelularMatriculadoKeyPressed

    private void jTTelefonoParcularMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoParcularMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCNacionalidad.requestFocus();
    }//GEN-LAST:event_jTTelefonoParcularMatriculadoKeyPressed

    private void jCNacionalidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCNacionalidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTCalle.requestFocus();
    }//GEN-LAST:event_jCNacionalidadKeyPressed

    private void jTCalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCalleKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jButton1.requestFocus();
    }//GEN-LAST:event_jTCalleKeyPressed

    private void jTBarrioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBarrioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTDepartamento.requestFocus();
    }//GEN-LAST:event_jTBarrioKeyPressed

    private void jTDepartamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDepartamentoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTLocalidad.requestFocus();
    }//GEN-LAST:event_jTDepartamentoKeyPressed

    private void jTLocalidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLocalidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTProvincia.requestFocus();
    }//GEN-LAST:event_jTLocalidadKeyPressed

    private void jTProvinciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProvinciaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTCalle1.requestFocus();
    }//GEN-LAST:event_jTProvinciaKeyPressed

    private void jTCalle1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCalle1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jButton2.requestFocus();
    }//GEN-LAST:event_jTCalle1KeyPressed

    private void jTBarrio1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBarrio1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTDepartamento1.requestFocus();
    }//GEN-LAST:event_jTBarrio1KeyPressed

    private void jTDepartamento1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDepartamento1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTLocalidad1.requestFocus();
    }//GEN-LAST:event_jTDepartamento1KeyPressed

    private void jTLocalidad1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLocalidad1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTProvincia1.requestFocus();
    }//GEN-LAST:event_jTLocalidad1KeyPressed

    private void jTTelefonoTrabajoMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoTrabajoMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTWebMatriculado.requestFocus();
    }//GEN-LAST:event_jTTelefonoTrabajoMatriculadoKeyPressed

    private void jTWebMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTWebMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTCuitMatriculado.requestFocus();
    }//GEN-LAST:event_jTWebMatriculadoKeyPressed

    private void jTCuitMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCuitMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTCuilMatriculado.requestFocus();
}//GEN-LAST:event_jTCuitMatriculadoKeyPressed

    private void jTCuilMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCuilMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCIva.requestFocus();
    }//GEN-LAST:event_jTCuilMatriculadoKeyPressed

    private void jCDiaInscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCDiaInscKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCMesInsc.requestFocus();
    }//GEN-LAST:event_jCDiaInscKeyPressed

    private void jCMesInscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCMesInscKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCAnioInsc.requestFocus();
    }//GEN-LAST:event_jCMesInscKeyPressed

    private void jCAnioInscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioInscKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTLibroMatriculado.requestFocus();

        
    }//GEN-LAST:event_jCAnioInscKeyPressed

    private void jCDiaEgresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCDiaEgresoKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCMesEgreso.requestFocus();
        
    }//GEN-LAST:event_jCDiaEgresoKeyPressed

    private void jCAnioEgresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioEgresoKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_ENTER) ||(c == KeyEvent.VK_DELETE)  ||(c == KeyEvent.VK_ESCAPE))))
        {    
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Debe introducir un valor valido ej: 12","Atencion",JOptionPane.ERROR_MESSAGE);
            this.jCAnioInsc.setSelectedItem("1");
            this.jTLibroMatriculado.requestFocus();
            evt.consume();
        }
    }//GEN-LAST:event_jCAnioEgresoKeyPressed

    private void jCMesEgresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCMesEgresoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCAnioEgreso.requestFocus();
    }//GEN-LAST:event_jCMesEgresoKeyPressed

    private void jTLibroMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLibroMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTFolioiMatriculado.requestFocus();
    }//GEN-LAST:event_jTLibroMatriculadoKeyPressed

    private void jTFolioiMatriculadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFolioiMatriculadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCTitulo.requestFocus();
    }//GEN-LAST:event_jTFolioiMatriculadoKeyPressed

    private void jCTituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTituloKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jButton4.requestFocus();
    }//GEN-LAST:event_jCTituloKeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTEspecialidad.requestFocus();
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1KeyPressed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:
        int res= JOptionPane.showConfirmDialog(null,"Desea Imprimir el carnet con foto?,Seleccione NO para imprimir elcarnet sin foto", "Imprimir Carnet",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (res==JOptionPane.YES_OPTION){
            Configuracion configuracion = new Configuracion();
            CListar listar = new CListar();
            configuracion = listar.hacerListado(configuracion);        
            String url="";
            if (configuracion.getHost().trim().equals("localhost")||configuracion.getHost().trim().equals("127.0.0.1")){
                url = configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
            }else{
                url = "\\\\"+"\\\\"+configuracion.getHost().trim()+"\\\\"+configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
            }
            cExport_thread imprime=new cExport_thread(96,String.valueOf(String.valueOf(this.matriculado.getMatricula()).trim()),url);
            imprime.start();
        }else {
            cExport_thread imprime=new cExport_thread(9,String.valueOf(String.valueOf(this.matriculado.getMatricula()).trim()));
            imprime.start();
        }
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jCAnioNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioNacimientoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jCAnioNacimientoKeyTyped

    private void jCAnioNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCAnioNacimientoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jCAnioNacimientoFocusLost

    private void jCAnioNacimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCAnioNacimientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCAnioNacimientoKeyReleased

    private void jTIngresosBrutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIngresosBrutosKeyPressed
        // TODO add your handling code here:
            if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jCDiaInsc.requestFocus();
}//GEN-LAST:event_jTIngresosBrutosKeyPressed

    private void jCIvaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCIvaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==27)
            this.dispose();
        if(evt.getKeyChar()==10)
            this.jTIngresosBrutos.requestFocus();
    }//GEN-LAST:event_jCIvaKeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new UIMatriculados().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jCAnioEgreso;
    private javax.swing.JComboBox jCAnioInsc;
    private javax.swing.JComboBox jCAnioNacimiento;
    private javax.swing.JComboBox jCDiaEgreso;
    private javax.swing.JComboBox jCDiaInsc;
    private javax.swing.JComboBox jCDiaNacimiento;
    private javax.swing.JComboBox jCHabilitado;
    private javax.swing.JComboBox jCIva;
    private javax.swing.JComboBox jCMesEgreso;
    private javax.swing.JComboBox jCMesInsc;
    private javax.swing.JComboBox jCMesNacimiento;
    private javax.swing.JComboBox jCNacionalidad;
    private javax.swing.JComboBox jCTitulo;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLBarrio;
    private javax.swing.JLabel jLBarrio1;
    private javax.swing.JLabel jLCalle;
    private javax.swing.JLabel jLCalle1;
    private javax.swing.JLabel jLCuil;
    private javax.swing.JLabel jLDepartamento;
    private javax.swing.JLabel jLDepartamento1;
    private javax.swing.JLabel jLDni;
    private javax.swing.JLabel jLDni10;
    private javax.swing.JLabel jLDni11;
    private javax.swing.JLabel jLDni12;
    private javax.swing.JLabel jLDni13;
    private javax.swing.JLabel jLDni3;
    private javax.swing.JLabel jLDni5;
    private javax.swing.JLabel jLDni6;
    private javax.swing.JLabel jLDni7;
    private javax.swing.JLabel jLDni8;
    private javax.swing.JLabel jLDni9;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLLocalidad;
    private javax.swing.JLabel jLLocalidad1;
    private javax.swing.JLabel jLMatricula;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLProvincia;
    private javax.swing.JLabel jLProvincia1;
    private javax.swing.JLabel jLTelefonoTrabajo;
    private javax.swing.JLabel jLWeb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTApellidoMatriculado;
    private javax.swing.JTextField jTBarrio;
    private javax.swing.JTextField jTBarrio1;
    private javax.swing.JTextField jTCalle;
    private javax.swing.JTextField jTCalle1;
    private javax.swing.JTextField jTCuilMatriculado;
    private javax.swing.JTextField jTCuitMatriculado;
    private javax.swing.JTextField jTDepartamento;
    private javax.swing.JTextField jTDepartamento1;
    private javax.swing.JTextField jTDniMatriculado;
    private javax.swing.JTextField jTEmailMatriculado;
    private javax.swing.JTextField jTEscuela;
    private javax.swing.JTextField jTEspecialidad;
    private javax.swing.JTextField jTFolioiMatriculado;
    private javax.swing.JTextField jTIngresosBrutos;
    private javax.swing.JTextField jTLibroMatriculado;
    private javax.swing.JTextField jTLocalidad;
    private javax.swing.JTextField jTLocalidad1;
    private javax.swing.JTextField jTMatriculaMatriculado;
    private javax.swing.JTextField jTNombreMatriculado;
    private javax.swing.JTextField jTProvincia;
    private javax.swing.JTextField jTProvincia1;
    private javax.swing.JTextField jTTelefonoCelularMatriculado;
    private javax.swing.JTextField jTTelefonoParcularMatriculado;
    private javax.swing.JTextField jTTelefonoTrabajoMatriculado;
    private javax.swing.JTextField jTWebMatriculado;
    // End of variables declaration//GEN-END:variables
    
    private void initCampos()
    {
        this.jTMatriculaMatriculado.setEnabled(true);
        this.jTNombreMatriculado.setEnabled(true);
        this.jTApellidoMatriculado.setEnabled(true);
        this.jTDniMatriculado.setEnabled(true);
        this.jTEmailMatriculado.setEnabled(true);
        this.jTTelefonoCelularMatriculado.setEnabled(true);
        this.jTTelefonoParcularMatriculado.setEnabled(true);
        this.jTTelefonoTrabajoMatriculado.setEnabled(true);
        this.jTCalle.setEnabled(true);
        this.jTCalle1.setEnabled(true);
        this.jTWebMatriculado.setEnabled(true);
        this.jTCuilMatriculado.setEnabled(true);
        this.jTCuitMatriculado.setEnabled(true);
        this.jTEspecialidad.setEnabled(true);
        this.jTFolioiMatriculado.setEnabled(true);
        this.jTLibroMatriculado.setEnabled(true);
        this.jTIngresosBrutos.setEnabled(true);
        
        //botones
        this.jBGuardar.setEnabled(true);
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(true);
        this.jButton4.setEnabled(true);
        //combos
        this.jCAnioEgreso.setEnabled(true);
        this.jCAnioInsc.setEnabled(true);
        this.jCAnioNacimiento.setEnabled(true);
        this.jCDiaEgreso.setEnabled(true);
        this.jCDiaInsc.setEnabled(true);
        this.jCDiaNacimiento.setEnabled(true);
        this.jCHabilitado.setEnabled(true);
        this.jCMesEgreso.setEnabled(true);
        this.jCMesInsc.setEnabled(true);
        this.jCMesNacimiento.setEnabled(true);
        this.jCNacionalidad.setEnabled(true);
        this.jCTitulo.setEnabled(true);
        this.jCIva.setEnabled(true);
        
    }
    
    
    public void cargarDatosDireccion(Barrio bar)
    {
        if(this.ubicacion)// ubicacion laboral
        {
            Consulta con = new Consulta();
            int idJujuy = 0;
            Collection co = new ArrayList();
            co = con.getProvincia("JUJUY");
            Iterator it = co.iterator();
            while(it.hasNext())
            {
                Provincia p = (Provincia)it.next();
                if(p.getNombre().trim().equals("JUJUY"))
                    idJujuy = p.getIdprovincia();
                p = null;
            }
            co = null;
            con = null;
            it = null;
            if(bar.getLocalidad().getDepartamento().getProvincia().getIdprovincia() == idJujuy)
            {
                this.jTProvincia1.setText(bar.getLocalidad().getDepartamento().getProvincia().getNombre().trim());
                this.jTDepartamento1.setText(bar.getLocalidad().getDepartamento().getNombre().trim());
                this.jTLocalidad1.setText(bar.getLocalidad().getNombre().trim());
                this.jTBarrio1.setText(bar.getNombre().trim());
                this.localidadLaboral = bar.getLocalidad();
                this.barrioLaboral = bar;
                this.departamentoProfesional = bar.getLocalidad().getDepartamento();
                this.provinciaLaboral = bar.getLocalidad().getDepartamento().getProvincia();
            }
            else
                JOptionPane.showMessageDialog(null,"EL domicilio laboral debe estar ubicado en la provincia de Jujuy","Error en el domicilio",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            this.jTProvincia.setText(bar.getLocalidad().getDepartamento().getProvincia().getNombre().trim());
            this.jTDepartamento.setText(bar.getLocalidad().getDepartamento().getNombre().trim());
            this.jTLocalidad.setText(bar.getLocalidad().getNombre().trim());
            this.jTBarrio.setText(bar.getNombre().trim());
            this.localidad = bar.getLocalidad();
            this.barrio = bar;
            this.departamento = bar.getLocalidad().getDepartamento();
            this.provincia = bar.getLocalidad().getDepartamento().getProvincia();
        }
    }
    
    private void llenarCampos()
    {
        this.jTMatriculaMatriculado.setText(String.valueOf(this.matriculado.getMatricula()).trim());
        this.jTApellidoMatriculado.setText(this.matriculado.getApellido().trim());        
        this.jTNombreMatriculado.setText(this.matriculado.getNombres().trim());
        this.jTDniMatriculado.setText(this.matriculado.getDni().trim());
        // cargar direcion del matriculado atanto personal como laboral
                // direccion personal
        this.jTCalle.setText(this.matriculado.getCalle().trim());
        this.jTBarrio.setText(this.matriculado.getBarrio().getNombre());
        this.jTLocalidad.setText(this.matriculado.getLocalidad().getNombre());
        this.jTDepartamento.setText(this.matriculado.getDepartamento().getNombre());
        this.jTProvincia.setText(this.matriculado.getProvincia().getNombre());
                // direccion laboral
        this.jTCalle1.setText(this.matriculado.getCalleProfesional().trim());
        this.jTBarrio1.setText(this.matriculado.getBarrioProfesional().getNombre());
        this.jTLocalidad1.setText(this.matriculado.getLocalidadProfesional().getNombre());
        this.jTDepartamento1.setText(this.matriculado.getDepartamentoProfesional().getNombre());
        this.jTProvincia1.setText("JUJUY");
        
        this.jTEmailMatriculado.setText(this.matriculado.getEmail().trim());
        this.jTTelefonoCelularMatriculado.setText(this.matriculado.getTelefonoCelular().trim());
        this.jTTelefonoParcularMatriculado.setText(this.matriculado.getTelefonoParticular().trim());
        this.jCNacionalidad.setSelectedItem(this.matriculado.getNacionalidad().getNombre().trim());
        this.jTTelefonoTrabajoMatriculado.setText(this.matriculado.getTelefonoTrabajo().trim());
        this.jTWebMatriculado.setText(this.matriculado.getWeb().trim());
        this.jTCuilMatriculado.setText(this.matriculado.getCuil().trim());
        this.jTCuitMatriculado.setText(this.matriculado.getCuit().trim());

//        System.out.println("INGRESOS BRITOS en CAJA: "+this.matriculado.getIngresosBrutos().trim());
        this.jTIngresosBrutos.setText(this.matriculado.getIngresosBrutos().trim());
                
        this.jCHabilitado.setSelectedItem(this.matriculado.getHabilitado().trim());
        this.jTLibroMatriculado.setText(this.matriculado.getLibro().trim());
        this.jTFolioiMatriculado.setText(this.matriculado.getFolio().trim());
        this.jCTitulo.setSelectedItem(this.matriculado.getTitulo().getAbreviacion().trim());        
        this.jTEspecialidad.setText(this.matriculado.getEspecialidad().trim());
//        this.jTIdMatriculado.setText(String.valueOf(this.matriculado.getIdmatriculado()).trim());
        // mostrar las fechas
        // fecha de nacimiento //
        
        this.jCDiaNacimiento.setSelectedItem(String.valueOf(Math.round(this.matriculado.getDiaNac())));
        this.jCMesNacimiento.setSelectedItem(String.valueOf(Math.round(this.matriculado.getMesNac())));
        this.jCAnioNacimiento.setSelectedItem(String.valueOf(Math.round(this.matriculado.getAnioNac())));
        
        // fecha de ingreso //
        this.jCDiaInsc.setSelectedItem(String.valueOf(Math.round(this.matriculado.getDiaIns())));
        this.jCMesInsc.setSelectedItem(String.valueOf(Math.round(this.matriculado.getMesIns())));
        this.jCAnioInsc.setSelectedItem(String.valueOf(Math.round(this.matriculado.getAnioIns())));
        
//        System.out.println("Fecha de Inscripcion:"+String.valueOf(Math.round(this.matriculado.getDiaIns()))+"/"+String.valueOf(Math.round(this.matriculado.getMesIns()))+"/"+String.valueOf(Math.round(this.matriculado.getAnioIns())));
        
        // fecha de egreso //
        this.jCDiaEgreso.setSelectedItem(String.valueOf(Math.round(this.matriculado.getDiaEgr())));
        this.jCMesEgreso.setSelectedItem(String.valueOf(Math.round(this.matriculado.getMesEgr())));
        this.jCAnioEgreso.setSelectedItem(String.valueOf(Math.round(this.matriculado.getAnioEgr())));
        
        // Cargar la foto del matriculado //
        this.loadFoto();
        //this.jLFoto.setIcon(new Icon());
    }
    
    public void insertar(Escuela escuela)
    {
        this.jTEscuela.setText(escuela.getNombre().trim());
        this.escuela = escuela;
        
    }
    
    private void cargarCombosFecha()
    {
        for(int i = 1;i<=31;i++)
        {
            this.jCDiaEgreso.addItem(String.valueOf(i));
            this.jCDiaInsc.addItem(String.valueOf(i));
            this.jCDiaNacimiento.addItem(String.valueOf(i));
        }
        for(int i = 1;i<=12;i++)
        {
            this.jCMesEgreso.addItem(String.valueOf(i));
            this.jCMesInsc.addItem(String.valueOf(i));
            this.jCMesNacimiento.addItem(String.valueOf(i));
        }
        GregorianCalendar fec = new GregorianCalendar();
        int anio = fec.get(Calendar.YEAR);
        for(int i=1925;i<=anio;i++)
        {
            this.jCAnioEgreso.addItem(String.valueOf(i));
            this.jCAnioInsc.addItem(String.valueOf(i));
            this.jCAnioNacimiento.addItem(String.valueOf(i));
        }
    }
    
    private void cargarCombos()
    {
        CListar listar = new CListar();
        this.nacionalidades = listar.hacerListado(new Nacionalidad());
        this.titulos = listar.hacerListado(new Titulo());
        this.escuelas = listar.hacerListado(new Escuela());
        this.iva = listar.hacerListado(new Iva());
        listar = null;
        Iterator it = this.nacionalidades.iterator();
        Iterator tit = this.titulos.iterator();
        Iterator ite = this.iva.iterator();
        //Iterator esc = this.escuelas.iterator();
        while(it.hasNext())
        {
            Nacionalidad n = (Nacionalidad)it.next();
            this.jCNacionalidad.addItem(n.getNombre().trim());
            n = null;
        }
        while(tit.hasNext())
        {
            Titulo t = (Titulo)tit.next();
            this.jCTitulo.addItem(t.getAbreviacion().trim());
            t = null;
        }
        while(ite.hasNext())
        {
            Iva i = (Iva)ite.next();
            this.jCIva.addItem(i.getNombre().trim());
//            System.out.println("estoy poniendo ;"+i.getNombre().trim());
            i = null;
        }        
    }
    
       
    private void setearIva()
    {
        CListar listar = new CListar();
        Collection co = new ArrayList();
        co = listar.hacerListado(tipoiva);
        int cantidad = co.size();
        int posicion = 0;
        for(int i = 0; i < cantidad; i++)            
        {
//            System.out.println("indices i: "+i);
            
            this.jCIva.setSelectedIndex(i);
            String nombre = String.valueOf(this.jCIva.getSelectedItem()).trim();
            if(this.matriculado.getIva().getNombre().trim().equals(nombre)){
                //this.jCIva.setSelectedIndex(i);
                posicion = i;
            }
        }
        this.jCIva.setSelectedIndex(posicion);
    }
    
    private boolean controlar()
    {
        boolean control = true;
        if(this.jTMatriculaMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTApellidoMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTNombreMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTDniMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTEmailMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTTelefonoCelularMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTTelefonoParcularMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTCalle.getText().trim().length() == 0)
            control = false;
        if(this.jTBarrio.getText().trim().length() == 0)
            control = false;
        if(this.jTDepartamento.getText().trim().length() == 0)
            control = false;
        if(this.jTLocalidad.getText().trim().length() == 0)
            control = false;
        if(this.jTProvincia.getText().trim().length() == 0)
            control = false;
        if(this.jTCalle1.getText().trim().length() == 0)
            control = false;
        if(this.jTBarrio1.getText().trim().length() == 0)
            control = false;
        if(this.jTDepartamento1.getText().trim().length() == 0)
            control = false;
        if(this.jTLocalidad1.getText().trim().length() == 0)
            control = false;
        if(this.jTProvincia1.getText().trim().length() == 0)
            control = false;
        if(this.jTTelefonoTrabajoMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTWebMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTLibroMatriculado.getText().trim().length() == 0)
            control = false;
        if(this.jTFolioiMatriculado.getText().trim().length() == 0)
            control = false;
        if((this.jTCuilMatriculado.getText().trim().length() == 0) && (this.jTCuitMatriculado.getText().trim().length() == 0))
            control = false;
        if(this.jTEscuela.getText().trim().length() == 0)
            control = false;
        if(this.jTEspecialidad.getText().trim().length() == 0)
            control = false;
        if(this.jTIngresosBrutos.getText().trim().length() == 0)
            control = false;
        
        if (this.jTMatriculaMatriculado.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Agregue un numero en Matricula Solicitante para buscarla","No se puede Buscar", JOptionPane.WARNING_MESSAGE);
        } else {
            if (this.jTMatriculaMatriculado.getText().trim().length() < 11){
                if(Long.valueOf(this.jTMatriculaMatriculado.getText().trim()) <= 2147483647){
    //              this.limpiarCampos();
                    Matriculado m=new Matriculado(); 
                    m.setMatricula(Integer.parseInt(this.jTMatriculaMatriculado.getText().trim()));
                    CListar listamat=new CListar();
                    Matriculado ma=listamat.soloMatriculado(m);

                    if (ma.getMatricula()!=0){
                        if(ma.getNombres()!=null && this.modifica==null){
                            JOptionPane.showMessageDialog(this, "El Nro de Matricula ya existe pertenece a:\n"+ma.getApellido().trim()+", "+ma.getNombres().trim(),"No se puede dar el ALTA", JOptionPane.WARNING_MESSAGE);   
                            control=false;
                        }else{
                            if (this.modifica.equals("")){
                                control=true;                    
                            }               
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El Nro de Matricula no puede ser superior a: 2147483647  \n","No se puede dar el ALTA", JOptionPane.WARNING_MESSAGE);   
                    control=false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Nro de Matricula no puede ser superior a: 2147483647  \n","No se puede dar el ALTA", JOptionPane.WARNING_MESSAGE);   
                control=false;
            }
        }
        
        return control;
    }
//    private Date pasarADateConFormato(String ddia, String mmes, String aanio)
//    {
//        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy" );
//        SimpleDateFormat outDateFormat = new SimpleDateFormat("MM-dd-yyyy*HH:mm:ss:z");
//        outDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//        java.util.Date fe=null;
//        java.util.Date date = new Date();
//        
////        try
////        {
////            Date dt = dateFormat.parse(date);
////            System.out.println(dt.toString());
////            this.date = outDateFormat.format(dt);
////            System.out.println("ORIGINAL IS: " + date + "     NEW IS:  "  + this.date.toString());
////        }
////        catch(ParseException e)
////        {
////            System.out.println(e);
////        }
//        
//        
//        try{            
//            fe = outDateFormat.parse(ddia + "/" + mmes + "/" + aanio);
//        } catch (ParseException ex) {
//            Logger.getLogger(UIMatriculados.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
////        java.util.Date fe=null;
////        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy"); //Las M en mayúsculas o interpretará minutos!!
////        try{            
////            fe = sdf.parse(ddia + "/" + mmes + "/" + aanio);
////        } catch (ParseException ex) {
////            Logger.getLogger(UIMatriculados.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        System.out.println("La fecha a devolver es: "+fe);
//        return fe;
//    }
    
    private Date pasarADateConFormato(String ddia, String mmes, String aanio){
        Locale l = new Locale("es","AR");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Jujuy"),l);
       
        //String fecha=(cal.get(Integer.parseInt(aanio)) + "/" + (cal.get(Integer.parseInt(mmes))) + "/" + cal.get(Integer.parseInt(ddia)));
        
        //seteo la fecha
        cal.set(Integer.parseInt(aanio), Integer.parseInt(mmes)-1, Integer.parseInt(ddia) + 1);
        
        String fecha=(cal.get(Calendar.DAY_OF_MONTH)+ "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR));
        
                
//        JOptionPane.showMessageDialog(null,fecha , "fecha en string es...",JOptionPane.WARNING_MESSAGE);
                
        java.util.Date fe=null;
//        java.sql.Date fe=null;
        java.sql.Date fo = null;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try{            
            //fe = sdf.parse(ddia + "/" + mmes + "/" + aanio);
            fe = sdf.parse(fecha);
            fo = new java.sql.Date(fe.getTime());
        }catch(ParseException pe){
            JOptionPane.showMessageDialog(null, "Admin: hubo problemas con la fecha", "No se pudo parsear la fecha",JOptionPane.WARNING_MESSAGE);
        }
//        System.out.println("La fecha a devolver es: "+fe);
        return fo;
    }
    
    
    private void guardar() throws ParseException{
        this.matriculado.setApellido(this.jTApellidoMatriculado.getText().trim().toUpperCase());
        this.matriculado.setBarrio(this.barrio);
        this.matriculado.setBarrioProfesional(this.barrioLaboral);
        this.matriculado.setCalle(this.jTCalle.getText().trim().toUpperCase());
        this.matriculado.setCalleProfesional(this.jTCalle1.getText().trim().toUpperCase());
        this.matriculado.setCuil(this.jTCuilMatriculado.getText().trim());
        this.matriculado.setCuit(this.jTCuitMatriculado.getText().trim());
        this.matriculado.setDepartamento(this.departamento);
        this.matriculado.setDepartamentoProfesional(this.departamentoProfesional);
        this.matriculado.setDni(this.jTDniMatriculado.getText().trim());
        this.matriculado.setEmail(this.jTEmailMatriculado.getText().trim().toUpperCase());
        this.matriculado.setEscuela(this.escuela);
        this.matriculado.setEspecialidad(this.jTEspecialidad.getText().trim().toUpperCase());
        this.matriculado.setIngresosBrutos(this.jTIngresosBrutos.getText().trim());
        this.obtenerIdIva();
        this.matriculado.setIva(tipoiva);
        this.matriculado.setExiste("S");
        //this.matriculado.setFechaEgresoDeEscuela(new Date(String.valueOf(this.jCDiaEgreso.getSelectedItem()) + "/" + String.valueOf(this.jCMesEgreso.getSelectedItem()) + "/" + String.valueOf(this.jCAnioEgreso.getSelectedItem())));
        this.matriculado.setFechaEgresoDeEscuela(this.pasarADateConFormato(String.valueOf(this.jCDiaEgreso.getSelectedItem()),String.valueOf(this.jCMesEgreso.getSelectedItem()), String.valueOf(this.jCAnioEgreso.getSelectedItem())));        
        //this.matriculado.setFechaInscripcion(new Date(String.valueOf(this.jCDiaInsc.getSelectedItem()) + "/" + String.valueOf(this.jCMesInsc.getSelectedItem()) + "/" + String.valueOf(this.jCAnioInsc.getSelectedItem())));
        this.matriculado.setFechaInscripcion(this.pasarADateConFormato(String.valueOf(this.jCDiaInsc.getSelectedItem()),String.valueOf(this.jCMesInsc.getSelectedItem()), String.valueOf(this.jCAnioInsc.getSelectedItem())));
        
        this.matriculado.setFolio(this.jTFolioiMatriculado.getText().trim());
        if(String.valueOf(this.jCHabilitado.getSelectedItem()).trim().toUpperCase().equals("SI"))
            this.matriculado.setHabilitado("S");
        else
            this.matriculado.setHabilitado("N");
        this.matriculado.setMatricula(Integer.parseInt(this.jTMatriculaMatriculado.getText().trim()));
        this.matriculado.setLibro(this.jTLibroMatriculado.getText().trim());
        this.matriculado.setLocalidad(this.localidad);
        this.matriculado.setLocalidadProfesional(this.localidadLaboral);
        //this.matriculado.setNacimiento(new Date(String.valueOf(this.jCDiaNacimiento.getSelectedItem()) + "/" + String.valueOf(this.jCMesNacimiento.getSelectedItem()) + "/" + String.valueOf(this.jCAnioNacimiento.getSelectedItem())));
        
        //java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy"); //Las M en mayúsculas o interpretará minutos!!
        //java.util.Date fecha = sdf.parse(String.valueOf(this.jCDiaNacimiento.getSelectedItem()) + "/" + String.valueOf(this.jCMesNacimiento.getSelectedItem()) + "/" + String.valueOf(this.jCAnioNacimiento.getSelectedItem()));
        
        this.matriculado.setNacimiento(this.pasarADateConFormato(String.valueOf(this.jCDiaNacimiento.getSelectedItem()),String.valueOf(this.jCMesNacimiento.getSelectedItem()), String.valueOf(this.jCAnioNacimiento.getSelectedItem())));
        
        this.matriculado.setNacionalidad(this.getNacionalidad());
        this.matriculado.setNombres(this.jTNombreMatriculado.getText().trim().toUpperCase());
        this.matriculado.setProvincia(this.provincia);
        this.matriculado.setTelefonoCelular(this.jTTelefonoCelularMatriculado.getText().trim());
        this.matriculado.setTelefonoParticular(this.jTTelefonoParcularMatriculado.getText().trim());
        this.matriculado.setTelefonoTrabajo(this.jTTelefonoTrabajoMatriculado.getText().trim());
        this.matriculado.setTitulo(this.getTitulo());
        this.matriculado.setWeb(this.jTWebMatriculado.getText().trim().toUpperCase());
//        this.matriculado.setMatricula(Integer.parseInt(this.jTMatriculaMatriculado.getText()));
        if(this.imagenCargada) // se hace el alta o la modificacion del matriculado y la foto
            this.copiarFoto();
        
        // procedimiento de guardado y/o actualizacion
        // primero el alta o modificacion de matriculado
        
        if(this.origen)
            // comienza el alta de matriculado
            if(this.guardarMatriculado()) // guardo el matriculado
                // ahora guardo la foto solo si hay una foto para guardar
                if(this.imagenCargada)
                    if(this.guardarFoto())
                    {
                        JOptionPane.showMessageDialog(null,"Los datos se guardaron con exito","Carga Completa",JOptionPane.INFORMATION_MESSAGE);
                        this.reporte.reiniciar();
                        this.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Error en el almacenamiento de los datos","Error 1",JOptionPane.ERROR_MESSAGE);
                else
                {
                    JOptionPane.showMessageDialog(null,"Los datos se guardaron con exito","Carga Completa",JOptionPane.INFORMATION_MESSAGE);
                    this.reporte.reiniciar();
                    this.dispose();
                }
            else
                JOptionPane.showMessageDialog(null,"Error en el almacenamiento de los datos","Error 2",JOptionPane.ERROR_MESSAGE);
        else // se hace la modificacion de los datos
        {
            if(this.modificarMatriculado()) // modifico el matriculado y modifico la foto solo si hay una foto para modificar
                if(this.imagenCargada)
                    if(this.hayFoto()) // si es true hay que modificar el registro
                        if(this.modificarFoto())
                        {
                            JOptionPane.showMessageDialog(null,"Los datos se guardaron con exito","Carga Completa",JOptionPane.INFORMATION_MESSAGE);
                            this.reporte.reiniciar();
                            this.dispose();
                        } // si es falso hay que agregar una foto
                        else
                        {
                            if(this.guardarFoto())
                            {
                                JOptionPane.showMessageDialog(null,"Los datos se guardaron con exito","Carga Completa",JOptionPane.INFORMATION_MESSAGE);
                                this.reporte.reiniciar();
                                this.dispose();
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Error en el almacenamiento de los datos","Error 3",JOptionPane.ERROR_MESSAGE);
                        }
                            
                    else // hay que dar de alta
                        if(this.guardarFoto())
                        {
                            JOptionPane.showMessageDialog(null,"Los datos se guardaron con exito","Carga Completa",JOptionPane.INFORMATION_MESSAGE);
                            this.reporte.reiniciar();
                            this.dispose();
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Error en el almacenamiento de los datos","Error 4",JOptionPane.ERROR_MESSAGE);
                else
                {
                    JOptionPane.showMessageDialog(null,"Los datos se guardaron con exito","Carga Completa",JOptionPane.INFORMATION_MESSAGE);
                    this.reporte.reiniciar();
                    this.dispose();
                }
            else
                JOptionPane.showMessageDialog(null,"Error en el almacenamiento de los datos","Error 5",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private boolean guardarMatriculado()
    {
        boolean guardado = false;
        CAlta alta = new CAlta();
        int respuesta = alta.hacerAlta(this.matriculado);
        if(respuesta == 0)
            guardado = true;
        alta = null;
        return guardado;
    }
    
    private boolean modificarMatriculado()
    {
        boolean guardado = false;
        Modificacion mod = new Modificacion();
        int respuesta = mod.modificar(this.matriculado);
        if(respuesta != 0)
            guardado = true;
        mod = null;
        return guardado;
    }
    
    private boolean guardarFoto()
    {
        boolean guardado = false;
        Configuracion configuracion = new Configuracion();
        CListar listar = new CListar();
        CAlta alta = new CAlta();
        configuracion = listar.hacerListado(configuracion);
        listar = null;
        String url="";
        if (configuracion.getHost().trim().equals("localhost")||configuracion.getHost().trim().equals("127.0.0.1")){
                //Cuando el destino una sola pc que es la actual
                url = configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
        }else{
                //Cuando el destino esta en el server
                url = "\\\\"+"\\\\"+configuracion.getHost().trim()+"\\\\"+configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
        }
        
        //Alta alta = new Alta();
        int respuesta = alta.hacerAltaFoto(url,String.valueOf(this.matriculado.getMatricula()));
        if(respuesta == 0)// todo ok
            guardado = true;
        configuracion = null;
        alta = null;
        return guardado;
    }
    
    private boolean modificarFoto()
    {
        boolean guardado = false;
        Configuracion configuracion = new Configuracion();
        CListar listar = new CListar();
        configuracion = listar.hacerListado(configuracion);
        
        String url="";
        if (configuracion.getHost().trim().equals("localhost")||configuracion.getHost().trim().equals("127.0.0.1")){
            url = configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
        }else{
            url = "\\\\"+"\\\\"+configuracion.getHost().trim()+"\\\\"+configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
        }
        
        Modificacion mod = new Modificacion();
        int respuesta = mod.modificarFoto(url,String.valueOf(this.matriculado.getMatricula()));
        if(respuesta == 1)// todo ok
            guardado = true;
        configuracion = null;
        mod = null;
        listar = null;
        return guardado;
    }
    
    private boolean hayFoto()
    {
        Consulta con = new Consulta();
        return con.existeFoto(String.valueOf(this.matriculado.getMatricula()));
    }
    
    private Nacionalidad getNacionalidad()
    {
        Nacionalidad nacionalidad = new Nacionalidad();
        Iterator it = this.nacionalidades.iterator();
        while(it.hasNext())
        {
            Nacionalidad n = (Nacionalidad)it.next();
            if(n.getNombre().trim().equals(String.valueOf(this.jCNacionalidad.getSelectedItem()).trim()))
                nacionalidad = n;
            n = null;
        }
        it = null;
        return nacionalidad;
    }
    
    private Titulo getTitulo()
    {
        Titulo titulo = new Titulo();
        Iterator it = this.titulos.iterator();
        while(it.hasNext())
        {
            Titulo t = (Titulo)it.next();
            if(t.getAbreviacion().trim().equals(String.valueOf(this.jCTitulo.getSelectedItem()).trim()))
                titulo = t;
            t = null;
        }
        it = null;
        return titulo;
    }
    
    
    private void loadFoto()
    {
        Configuracion conf=new Configuracion();
            CListar listaConf=new CListar();        
            Configuracion c=listaConf.hacerListado(conf);        
            String nombreFoto=String.valueOf(this.matriculado.getMatricula()).trim()+".jpg";

            CListar listaFoto=new CListar();        
            
            String destino="";
            
            if (c.getHost().trim().equals("localhost")||c.getHost().trim().equals("127.0.0.1")){
                //Cuando el destino una sola pc que es la actual
                destino=c.getDirectorioTemp().trim()+"\\\\"+nombreFoto; 
            }else{
                //Cuando el destino esta en el server
                destino="\\\\\\"+"\\"+c.getHost().trim()+"\\\\"+c.getDirectorioTemp().trim()+"\\\\"+nombreFoto; 
            }
            
            boolean fotoExiste = listaFoto.obtenerfoto(destino, String.valueOf(this.matriculado.getMatricula()));

            if (fotoExiste){
                //File file = new File("\\"+"\\"+"192.168.0.1"+"\\"+"temp"+"\\"+"logo.jpg");
                
                if (c.getHost().trim().equals("localhost")||c.getHost().trim().equals("127.0.0.1")){
                    File file = new File(c.getDirectorioTemp().trim()+"\\"+nombreFoto);
                    ImageIcon i = new ImageIcon(file.getPath());
                    ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLFoto.getWidth(), this.jLFoto.getHeight(), Image.SCALE_DEFAULT));
                    this.jLFoto.setIcon(tmpIcon);
                }else{
                    File file = new File("\\"+"\\"+c.getHost().trim()+"\\"+c.getDirectorioTemp().trim()+"\\"+nombreFoto);
                    ImageIcon i = new ImageIcon(file.getPath());
                    ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLFoto.getWidth(), this.jLFoto.getHeight(), Image.SCALE_DEFAULT));
                    this.jLFoto.setIcon(tmpIcon);
                }
                this.jLFoto.setText("");
                this.imagenCargada = true;
            } else {
//                System.out.println("no existe"+fotoExiste);
            }
//             System.out.println("valor de recuperarFoto: "+fotoExiste);
    }
    
    
    private void cargarFoto()
    {
        JFileChooser fc = new JFileChooser();

	    //Add a custom file filter and disable the default
	    //(Accept All) file filter.
            fc.addChoosableFileFilter(new ImageFilter());
            fc.setAcceptAllFileFilterUsed(false);

	    //Add custom icons for file types.
            fc.setFileView(new ImageFileView());

	    //Add the preview pane.
            fc.setAccessory(new ImagePreview(fc));
            
            int returnVal = fc.showDialog(this,"Insertar");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = fc.getSelectedFile();
            this.fotoOrigen = file;
            ImageIcon i = new ImageIcon(file.getPath());
            ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLFoto.getWidth(), this.jLFoto.getHeight(), Image.SCALE_DEFAULT));
            this.jLFoto.setIcon(tmpIcon);
            this.imagenCargada = true;
        } 
        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);
    }
    
    
    
    private void copiarFoto()
    {
        Copiar cop = new Copiar();
        try
        {
            Configuracion configuracion = new Configuracion();
            CListar listar = new CListar();
            configuracion = listar.hacerListado(configuracion);
            String url="";
            if (configuracion.getHost().trim().equals("localhost")||configuracion.getHost().trim().equals("127.0.0.1")){            
                url = configuracion.getDirectorioTemp().trim()+"\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
//                String url2 = "\\\\"+"\\\\"+configuracion.getHost().trim()+"\\\\"+configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
            }else{
                url = "\\"+"\\"+configuracion.getHost().trim()+"\\"+configuracion.getDirectorioTemp().trim()+"\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
//                String url2 = "\\\\"+"\\\\"+configuracion.getHost().trim()+"\\\\"+configuracion.getDirectorioTemp().trim()+"\\\\"+this.jTMatriculaMatriculado.getText().trim()+".jpg";
            }
            this.fotoDestino = new File(url);
            //this.fotoDestino = new File(configuracion.getDirectoriotemp()+this.jTMatriculaMatriculado.getText().trim()+".jpg");
            cop.copy(this.fotoOrigen,this.fotoDestino);
            
            /*Alta alta = new Alta();
            //CListar listar = new CListar();
            //Configuracion configuraciones = new Configuracion();
            //configuraciones = listar.hacerListado(configuraciones);
            //int respuesta = alta.insertarFoto(configuracion.getDirectoriotemp()+String.valueOf(this.matriculado.getMatricula())+".jpg",String.valueOf(this.matriculado.getMatricula()));
            int respuesta = alta.insertarFoto(url2,String.valueOf(this.matriculado.getMatricula()));
            // si la respuesta es cero no inserto nada y si es 1 esta bien.
            if(respuesta == 0)
                JOptionPane.showMessageDialog(null,"Error en la carga de la imagen","Error",JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"La foto se cargo exitosamente","Operacion Completa",JOptionPane.INFORMATION_MESSAGE);
            //configuraciones = null;
            alta = null;
            */
            
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
       
    public void obtenerIdIva()
    {
       String seleccion = String.valueOf(this.jCIva.getSelectedItem()).trim();
       CListar listar = new CListar();
       Iva iva2 =  new Iva();
       Collection co = new ArrayList();
       co = listar.hacerListado(iva2);
       Iterator it = co.iterator();
       listar = null;
       while (it.hasNext())
       {
           iva2 = (Iva)it.next();
           if (seleccion.equals(iva2.getNombre().trim()))
                tipoiva = iva2;
       }
       iva2 = null;
       co = null;
        
    }
}
