/*
 * cExport_thread.java
 *
 * Created on 18 de junio de 2007, 13:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportes;
//import vista.VentanaListarProductos;
import java.io.File;
import java.net.URL; //sirve para obtener la ruta (path) de la clase actual
import java.util.*;
import java.sql.Connection;
import java.awt.event.*;
/*Librerías necesarias para Jasper Reports*/
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.*;
import java.lang.*;
import it.businesslogic.ireport.*;
import it.businesslogic.ireport.barcode.BcImage.*;
import net.sourceforge.barbecue.Barcode.*;

import Datos.DataManager;

/**
 *
 * @author Jorge R. Mendoza
 * 
 */
public class cExport_thread extends Thread {
    DataManager conexion;
//    private VentanaListarProductos listarProductos=new VentanaListarProductos();
    
    /**Listado de Reportes y descripcion de archivos que ejecuta:
         * 1-Listado de Productos : rep01.jasper
         * 2-Listado de Clientes: rep02.jasper
         * 3-Listado de Mozos : rep03.jasper
         * 4-Listado de Mesas : rep04.jasper
         * 5-Listado de Usuarios : rep05.jasper
    */
//    public cExport_thread(int tipoReporte,VentanaListarProductos listarProductos) {
//            this.listarProductos=listarProductos;
//            String reporte="";
//            switch (tipoReporte){
//                case 1: reporte="\\reportes\\rep01.jasper";break;
//                case 2: reporte="\\reportes\\rep02.jasper";break;
//                case 3: reporte="\\reportes\\rep03.jasper";break;
//                case 4: reporte="\\reportes\\rep04.jasper";break;
//                case 5: reporte="\\reportes\\rep05.jasper";break;
//            }
//            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
//            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());
//            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
//            rutaReporte=rutaReporte+reporte;            
////            listarProductos.listarMensaje("OK getParent getParent con FILE NOSE Funca: "+ rutaReporte);
//            this.lanzaJasperSimple(rutaReporte);
//    }
    
    public cExport_thread() {
    }
    
    public cExport_thread(int tipoReporte) {
            //this.listarProductos=listarProductos;
            String reporte="";
            switch (tipoReporte){
//              Las cadena relativa comienzan desde la raiz del proyecto cuando se compila el JAR
                case 1: reporte="\\reportes\\rep01Provincias.jasper";break;
                case 2: reporte="\\reportes\\rep02Departamentos.jasper";break;
                case 3: reporte="\\reportes\\rep03Localidades.jasper";break;
                case 4: reporte="\\reportes\\rep04Barrios.jasper";break;
                case 5: reporte="\\reportes\\rep05Escuelas.jasper";break;
                case 6: reporte="\\reportes\\rep06Usuarios.jasper";break;
                case 7: reporte="\\reportes\\rep07Nacionalidades.jasper";break;
                case 8: reporte="\\reportes\\rep08Titulos.jasper";break;
                case 91: reporte="\\reportes\\rep09Matriculados.jasper";break;//Todos los matriculados                
                case 10: reporte="\\reportes\\rep10CondicionVenta.jasper";break;
                case 11: reporte="\\reportes\\rep11Iva.jasper";break;
                case 12: reporte="\\reportes\\rep12Tasas.jasper";break;
                case 13: reporte="\\reportes\\rep13Empresa.jasper";break;
                //case 14: reporte="\\reportes\\rep04.jasper";break;
                case 15: reporte="\\reportes\\rep15Productos.jasper";break;
                //case 17: reporte="\\reportes\\rep01.jasper";break;
                case 18: reporte="\\reportes\\rep18TipoSecciones.jasper";break;
                case 19: reporte="\\reportes\\rep19TipoSuperficies.jasper";break;
                case 20: reporte="\\reportes\\rep20TipoTrabajos.jasper";break;
                //case 21: reporte="\\reportes\\rep05.jasper";break;
                case 22: reporte="\\reportes\\rep22Roles.jasper";break;
                //case 23: reporte="\\reportes\\rep05.jasper";break;
                case 24: reporte="\\reportes\\rep24EntidadesExternas.jasper";break;
//                case 32: reporte="\\reportes\\rep32CHabilitacion.jasper";break;
                case 50:reporte="\\reportes\\rep50AnuladosCP.jasper";break;
                case 51:reporte="\\reportes\\rep51AnuladosCT.jasper";break;
                case 52:reporte="\\reportes\\rep52AnuladosTodos.jasper";break;
                case 53:reporte="\\reportes\\rep53ConstanciasGralCT.jasper";break;
                case 54:reporte="\\reportes\\rep54ConstanciasGralCP.jasper";break;
                
            }            
            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());    
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            rutaReporte=rutaReporte+reporte;
            this.lanzaJasperSimple(rutaReporte);
            
    }
  
    /**Listado de Reportes y descripcion de archivos que ejecuta:
         * 10-Factura : rep10.jasper que llama a rep10a.jasper 
         * 11-Ticket : rep11.jasper que llama a rep11a.jasper
         * 21-Caja x Ejercicio : rep21.jasper que llama a rep21a,rep21b,rep21c,rep21d,rep21e,rep21f.jasper
         */
    public cExport_thread(int tipoReporte,String valorParametro1) {            
         
            String reporte=""; //despues le asigno el nombre del archivo de reporte jasper que se inciara
           
            String nombreParametro1="";
            switch (tipoReporte){
                    case 9: reporte="\\reportes\\rep091Matriculados.jasper";
                             nombreParametro1="MATRICULA";
                             break;
                    case 92: reporte="\\reportes\\rep092Matriculados.jasper";
                             nombreParametro1="ESPECIALIDAD";
                             break;
                    case 93: reporte="\\reportes\\rep093Matriculados.jasper";
                             nombreParametro1="APELLID";
                             break;
                    case 94: reporte="\\reportes\\rep094Matriculados.jasper";
                             nombreParametro1="HABILITADO";
                             break;
                    case 95: reporte="\\reportes\\rep095Matriculados.jasper";
                             nombreParametro1="MATRICULA";
                             break;
                    case 35: reporte="\\reportes\\rep35HistorialPagoMatricula.jasper";
                             nombreParametro1="MATRICULA";
                             break;
                    case 36: reporte="\\reportes\\rep36PagoMatricula.jasper";
                             nombreParametro1="IDENCABEZADOPAGO";
                             break;
                    case 28: reporte="\\reportes\\rep28CajaDiariaEncabezado.jasper";
                             nombreParametro1="IDCAJA";
                             break;
                    case 29: reporte="\\reportes\\rep28CajaDiariaEncabezado2.jasper";
                             nombreParametro1="IDCAJA";
                             break;
                    case 37: reporte="\\reportes\\rep35aHistorialSimple.jasper";
                             nombreParametro1="MATRICULA";
                             break;
                    case 38: reporte="\\reportes\\rep38HistorialCP.jasper";
                             nombreParametro1="MATRICULA";
                             break;
                    case 39: reporte="\\reportes\\rep39HistorialCT.jasper";
                             nombreParametro1="MATRICULA";
                             break;
                             
                     
            }

            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());            
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            String rutaCarpetaReportes=rutaReporte+"\\reportes\\";//a partir de la raiz del proyecto JAR compilado
            String rutaReporteMaestro=rutaReporte+reporte;//con el nombre del archivo      
            
            this.lanzaJasper1Parametro(rutaReporteMaestro,rutaCarpetaReportes,nombreParametro1,valorParametro1);
    }
    
    public cExport_thread(int tipoReporte,String valorParametro1,String valorParametro2) {            
         
            String reporte=""; //despues le asigno el nombre del archivo de reporte jasper que se inciara
           
            String nombreParametro1="";
            String nombreParametro2="";
            switch (tipoReporte){
                    case 96: reporte="\\reportes\\rep091aMatriculados.jasper";
                             nombreParametro1="MATRICULA";
                             nombreParametro2="RUTAFOTO";
                             break;
                    case 97: reporte="\\reportes\\rep095aMatriculados.jasper";
                             nombreParametro1="MATRICULA";
                             nombreParametro2="RUTAFOTO";
                             break;
                    case 32: reporte="\\reportes\\rep32CHabilitacion.jasper";
                             nombreParametro1="MATRICULA";
                             nombreParametro2="ENTIDADEXTERNA";
                             break;
                    case 33: reporte="\\reportes\\rep33EncCtotal.jasper";
                             nombreParametro1="SERIE";
                             nombreParametro2="CODIGO";
                             break;
                    case 34: reporte="\\reportes\\rep34EncCparcial.jasper";
                             nombreParametro1="SERIE";
                             nombreParametro2="CODIGO";
                             break;
                    case 27: reporte="\\reportes\\rep27EncFactura.jasper";
                             nombreParametro1="SERIE";
                             nombreParametro2="NUMERO";
                             break;   
                    case 28: reporte="\\reportes\\rep27EncFacturaConFormatoCopia.jasper";
                             nombreParametro1="SERIE";
                             nombreParametro2="NUMERO";
                             break;   
            }

            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());            
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            String rutaCarpetaReportes=rutaReporte+"\\reportes\\";//a partir de la raiz del proyecto JAR compilado
            String rutaReporteMaestro=rutaReporte+reporte;//con el nombre del archivo      
            
            this.lanzaJasper2Parametro(rutaReporteMaestro,rutaCarpetaReportes,nombreParametro1,valorParametro1,nombreParametro2,valorParametro2);
    }
    
public cExport_thread(int tipoReporte,String valorParametro1,String valorParametro2,String valorParametro3) {            
         
            String reporte=""; //despues le asigno el nombre del archivo de reporte jasper que se inciara
           
            String nombreParametro1="";
            String nombreParametro2="";
            String nombreParametro3="";
            switch (tipoReporte){
                    case 321: reporte="\\reportes\\rep32aCHabilitacion.jasper";
                             nombreParametro1="RUTAFOTO";
                             nombreParametro2="MATRICULA";
                             nombreParametro3="ENTIDADEXTERNA";
                             break;
                   
                    case 33: reporte="\\reportes\\rep33EncCtotal.jasper";
                             nombreParametro1="SERIE";
                             nombreParametro2="CODIGO";
                             nombreParametro3="COPIA";
                             break;
                    case 34: reporte="\\reportes\\rep34EncCparcial.jasper";
                             nombreParametro1="SERIE";
                             nombreParametro2="CODIGO";
                             nombreParametro3="COPIA";
                             break;
                   case 322: reporte="\\reportes\\rep32CHabilitacion.jasper";
                             nombreParametro1="MATRICULA";
                             nombreParametro2="ENTIDADEXTERNA";
                             nombreParametro3="VALIDOHASTA";
                             break;
//                    case 40: reporte="\\reportes\\rep40HistorialCPxfechas.jasper";
//                             nombreParametro1="MATRICULA";
//                             nombreParametro2="FECHA1";
//                             nombreParametro3="FECHA2";
//                             break;
            }            
            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());            
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            String rutaCarpetaReportes=rutaReporte+"\\reportes\\";//a partir de la raiz del proyecto JAR compilado
            String rutaReporteMaestro=rutaReporte+reporte;//con el nombre del archivo      
            
            this.lanzaJasper3Parametro(rutaReporteMaestro,rutaCarpetaReportes,nombreParametro1,valorParametro1,nombreParametro2,valorParametro2,nombreParametro3,valorParametro3);
    }

public cExport_thread(int tipoReporte,String valorParametro1,java.sql.Timestamp valorParametro2,java.sql.Timestamp valorParametro3) {            
         
            String reporte=""; //despues le asigno el nombre del archivo de reporte jasper que se inciara
           
            String nombreParametro1="";
            String nombreParametro2="";
            String nombreParametro3="";
            switch (tipoReporte){
                    
                    case 40: reporte="\\reportes\\rep40HistorialCPxfechas.jasper";
                             nombreParametro1="MATRICULA";
                             nombreParametro2="FECHA1";
                             nombreParametro3="FECHA2";
                             break;
                    case 41: reporte="\\reportes\\rep41HistorialCTxfechas.jasper";
                             nombreParametro1="MATRICULA";
                             nombreParametro2="FECHA1";
                             nombreParametro3="FECHA2";
                             break;
            }            
            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());            
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            String rutaCarpetaReportes=rutaReporte+"\\reportes\\";//a partir de la raiz del proyecto JAR compilado
            String rutaReporteMaestro=rutaReporte+reporte;//con el nombre del archivo      
            
            this.lanzaJasper3Parametro(rutaReporteMaestro,rutaCarpetaReportes,nombreParametro1,valorParametro1,nombreParametro2,valorParametro2,nombreParametro3,valorParametro3);
    }
  public void lanzaJasper3Parametro(String rutaReporteMaestro,String rutaCarpetaReportes,String nombreParametro1,String valorParametro1,String nombreParametro2,java.sql.Timestamp valorParametro2,String nombreParametro3,java.sql.Timestamp valorParametro3){
        try {        
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //Pasamos parametros al reporte Jasper.
            Map parameters = new HashMap();
            
            parameters.put(nombreParametro1,valorParametro1);
            parameters.put(nombreParametro2,valorParametro2);
            parameters.put(nombreParametro3,valorParametro3);            
            parameters.put("SUBREPORT_DIR",rutaCarpetaReportes);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporteMaestro,parameters,con);
            
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }

public cExport_thread(int tipoReporte,String valorParametro1,String valorParametro2,String valorParametro3,String valorParametro4) {            
         
            String reporte=""; //despues le asigno el nombre del archivo de reporte jasper que se inciara
           
            String nombreParametro1="";
            String nombreParametro2="";
            String nombreParametro3="";
            String nombreParametro4="";
            switch (tipoReporte){
                    case 40:
                            reporte="\\reportes\\rep40ResumenCajasCerradas.jasper";
                            nombreParametro1="CAJA1";
                            nombreParametro2="FECHA1";
                            nombreParametro3="CAJA2";
                            nombreParametro4="FECHA2";
                            break;
                     case 42:
                            reporte="\\reportes\\rep42ResumenTotalesDeCajas.jasper";
                            nombreParametro1="CAJA1";
                            nombreParametro2="FECHA1";
                            nombreParametro3="CAJA2";
                            nombreParametro4="FECHA2";
                            break;
                     case 3211: reporte="\\reportes\\rep32aCHabilitacion.jasper";
                             nombreParametro1="RUTAFOTO";
                             nombreParametro2="MATRICULA";
                             nombreParametro3="ENTIDADEXTERNA";
                             nombreParametro4="VALIDOHASTA";
                             break;
            }            
            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());            
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            String rutaCarpetaReportes=rutaReporte+"\\reportes\\";//a partir de la raiz del proyecto JAR compilado
            String rutaReporteMaestro=rutaReporte+reporte;//con el nombre del archivo      
            
            this.lanzaJasper4Parametro(rutaReporteMaestro,rutaCarpetaReportes,nombreParametro1,valorParametro1,nombreParametro2,valorParametro2,nombreParametro3,valorParametro3,nombreParametro4,valorParametro4);
    }
public cExport_thread(int tipoReporte,String valorParametro1,String valorParametro2,String valorParametro3,String valorParametro4,String valorParametro5) {            
         
            String reporte=""; //despues le asigno el nombre del archivo de reporte jasper que se inciara
           
            String nombreParametro1="";
            String nombreParametro2="";
            String nombreParametro3="";
            String nombreParametro4="";
            String nombreParametro5="";
            switch (tipoReporte){
                    case 37: reporte="\\reportes\\rep37Padron.jasper";
                             nombreParametro1="ESTADOHABILITADO";
                             nombreParametro2="DEP1";
                             nombreParametro3="LOC1";
                             nombreParametro4="DEP2";
                             nombreParametro5="LOC2";
                             break;                   
            }            
            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());            
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            String rutaCarpetaReportes=rutaReporte+"\\reportes\\";//a partir de la raiz del proyecto JAR compilado
            String rutaReporteMaestro=rutaReporte+reporte;//con el nombre del archivo      
            
            this.lanzaJasper5Parametro(rutaReporteMaestro,rutaCarpetaReportes,nombreParametro1,valorParametro1,nombreParametro2,valorParametro2,nombreParametro3,valorParametro3,nombreParametro4,valorParametro4,nombreParametro5,valorParametro5);
    }
public cExport_thread(int tipoReporte,String valorParametro1,String valorParametro2,String valorParametro3,String valorParametro4,String valorParametro5,String valorParametro6) {            
         
            String reporte=""; //despues le asigno el nombre del archivo de reporte jasper que se inciara
           
            String nombreParametro1="";
            String nombreParametro2="";
            String nombreParametro3="";
            String nombreParametro4="";
            String nombreParametro5="";
            String nombreParametro6="";
            switch (tipoReporte){
                    case 371: reporte="\\reportes\\rep37PadronTitulo.jasper";
                             nombreParametro1="ESTADOHABILITADO";
                             nombreParametro2="DEP1";
                             nombreParametro3="LOC1";
                             nombreParametro4="DEP2";
                             nombreParametro5="LOC2";
                             nombreParametro6="TITULO";
                             break;                   
                     case 372: reporte="\\reportes\\rep37PadronEspecialidad.jasper";
                             nombreParametro1="ESTADOHABILITADO";
                             nombreParametro2="DEP1";
                             nombreParametro3="LOC1";
                             nombreParametro4="DEP2";
                             nombreParametro5="LOC2";
                             nombreParametro6="ESPECIALIDAD";
                             break;                   
            }            
            String archivoNombre1=""; //Para que se obtenga la ruta del directorio de esta clase
            File sourceFile1= new File(this.getClass().getResource(archivoNombre1).getPath());            
            String rutaReporte=obtenerRutaArriba(3,sourceFile1);
            String rutaCarpetaReportes=rutaReporte+"\\reportes\\";//a partir de la raiz del proyecto JAR compilado
            String rutaReporteMaestro=rutaReporte+reporte;//con el nombre del archivo      
            
            this.lanzaJasper6Parametro(rutaReporteMaestro,rutaCarpetaReportes,nombreParametro1,valorParametro1,nombreParametro2,valorParametro2,nombreParametro3,valorParametro3,nombreParametro4,valorParametro4,nombreParametro5,valorParametro5,nombreParametro6,valorParametro6);
    }
public void lanzaJasperSimple(String rutaReporte){
        try {
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //como no hay que pasarle parametros al JASPER dejo en blanco el Map, solo lo creo.
            Map parameters = new HashMap(); 
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporte,parameters,con);

            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }

  public void lanzaJasper1Parametro(String rutaReporteMaestro,String rutaCarpetaReportes,String nombreParametro1,String valorParametro1){
        try {             
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //Pasamos parametros al reporte Jasper.
            Map parameters = new HashMap();
            
            parameters.put(nombreParametro1,valorParametro1);
            parameters.put("SUBREPORT_DIR",rutaCarpetaReportes);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporteMaestro,parameters,con);
            
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }
  public void lanzaJasper2Parametro(String rutaReporteMaestro,String rutaCarpetaReportes,String nombreParametro1,String valorParametro1,String nombreParametro2,String valorParametro2){
        try {        
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //Pasamos parametros al reporte Jasper.
            Map parameters = new HashMap();
            
            parameters.put(nombreParametro1,valorParametro1);
            parameters.put(nombreParametro2,valorParametro2);//
            parameters.put("SUBREPORT_DIR",rutaCarpetaReportes);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporteMaestro,parameters,con);
            
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }
  public void lanzaJasper3Parametro(String rutaReporteMaestro,String rutaCarpetaReportes,String nombreParametro1,String valorParametro1,String nombreParametro2,String valorParametro2,String nombreParametro3,String valorParametro3){
        try {        
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //Pasamos parametros al reporte Jasper.
            Map parameters = new HashMap();
            
            parameters.put(nombreParametro1,valorParametro1);
            parameters.put(nombreParametro2,valorParametro2);
            parameters.put(nombreParametro3,valorParametro3);            
            parameters.put("SUBREPORT_DIR",rutaCarpetaReportes);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporteMaestro,parameters,con);
            
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }
  public void lanzaJasper4Parametro(String rutaReporteMaestro,String rutaCarpetaReportes,String nombreParametro1,String valorParametro1,String nombreParametro2,String valorParametro2,String nombreParametro3,String valorParametro3,String nombreParametro4,String valorParametro4){
        try {        
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //Pasamos parametros al reporte Jasper.
            Map parameters = new HashMap();
            
            parameters.put(nombreParametro1,valorParametro1);
            parameters.put(nombreParametro2,valorParametro2);
            parameters.put(nombreParametro3,valorParametro3);
            parameters.put(nombreParametro4,valorParametro4);
            parameters.put("SUBREPORT_DIR",rutaCarpetaReportes);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporteMaestro,parameters,con);
            
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }
    public void lanzaJasper5Parametro(String rutaReporteMaestro,String rutaCarpetaReportes,String nombreParametro1,String valorParametro1,String nombreParametro2,String valorParametro2,String nombreParametro3,String valorParametro3,String nombreParametro4,String valorParametro4,String nombreParametro5,String valorParametro5){
        try {        
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //Pasamos parametros al reporte Jasper.
            Map parameters = new HashMap();
            
            parameters.put(nombreParametro1,valorParametro1);
            parameters.put(nombreParametro2,valorParametro2);
            parameters.put(nombreParametro3,valorParametro3);
            parameters.put(nombreParametro4,valorParametro4);
            parameters.put(nombreParametro5,valorParametro5);
            parameters.put("SUBREPORT_DIR",rutaCarpetaReportes);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporteMaestro,parameters,con);
            
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }
    public void lanzaJasper6Parametro(String rutaReporteMaestro,String rutaCarpetaReportes,String nombreParametro1,String valorParametro1,String nombreParametro2,String valorParametro2,String nombreParametro3,String valorParametro3,String nombreParametro4,String valorParametro4,String nombreParametro5,String valorParametro5,String nombreParametro6,String valorParametro6){
        try {        
            //Obtener una conexión a la base de datos
            conexion = new DataManager();
            Connection con = conexion.getConection();
            //Pasamos parametros al reporte Jasper.
            Map parameters = new HashMap();
            
            parameters.put(nombreParametro1,valorParametro1);
            parameters.put(nombreParametro2,valorParametro2);
            parameters.put(nombreParametro3,valorParametro3);
            parameters.put(nombreParametro4,valorParametro4);
            parameters.put(nombreParametro5,valorParametro5);
            parameters.put(nombreParametro6,valorParametro6);
            parameters.put("SUBREPORT_DIR",rutaCarpetaReportes);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporteMaestro,parameters,con);
            
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setVisible(true);
        } catch (Exception j){
            System.out.println("Mensaje de Error:"+j.getMessage());
        } 
    }
    public String obtenerRutaArriba(int nivel,File fileConRutaInicial){              
        // Por Ejemplo, Si el nivel es:
        //1 nivel-LA RUTA ES: E:\FuentesJava\ReportesEjemplos\build\classes\Reportes
        //2 nivel-LA RUTA ES: E:\FuentesJava\ReportesEjemplos\build\classes
        //3 nivel-LA RUTA ES: E:\FuentesJava\ReportesEjemplos\build
        //4 nivel-LA RUTA ES: E:\FuentesJava\ReportesEjemplos
        //5 nivel-LA RUTA ES: E:\FuentesJava

       File rutaActual=fileConRutaInicial;
       for (int i=1;i<nivel;i++){
            rutaActual=new File(rutaActual.getParent());
       }       
       String ruta=rutaActual.getPath().replaceAll("file:","");
       ruta=ruta.replaceAll("%20"," ");
       return ruta;
  }
}
