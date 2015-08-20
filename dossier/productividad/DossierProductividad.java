/*
 * @(#)DossierProductividad.java
 * 0
 * @Computadora utilizada: TOSHIBA Satellite S855D CPU: AMD A10-4600M APU with
 *                         Radeon(tm) HD Graphics (4CPUs), ~2.30GHz 
 *                         RAM: 6144MB 
 *                         SO: Windows 8 Pro 64-bit(6.2, Build 9200) 
 *                         IDE: NetBeans IDE 7.3.1
 * @Colegio: ITESM Prepa Tec Campus Eugenio Garza Sada
 *
 * * * * * * * * * * * * * *  D E S C R I P C I O N * * * * * * * * * * * * * * 
 * El Dosier Productividad, se encargara de manejar los trabajos y tareas
 * pendientes del cliente Carlos. También se encarga de administrar el tiempo 
 * de trabajo del cliente utilizando el método de productividad “Pomodoro
 * Technique”. La ventana principal consiste en 3 paneles donde se despliegan
 * tareas y examenes pendientes, botones para modificar, borrar y agregar una
 * tarea o examen nueva, un panel central donde se muestra la descripcion de la
 * tarea actual y un boton de empezar, donde se inicia el trabajo.
 * DossierProductividad.java es la clase que se encarga de cargar la interface
 * grafica y de aplicar argumentos esteticos.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * @autor (Irvel Nduva Matias Vega)
 * @version 0.40 2013/09/15
 */
package dossier.productividad;

//~--- Importacion de librerias-------------------------------------------------

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class DossierProductividad {
    public static int diaActual=0,mesActual=0,anoActual=0;
    private static void aplicarCentroPane(StyledDocument pane, SimpleAttributeSet center) {    // Establece que el texto de cada panel aparezca centrado
        pane.setParagraphAttributes(0, pane.getLength(), center, false);
    }
    
    
    public static void main(String[] args) throws IOException {
        /*Cargar Fuentes
        //InputStream istream = getClass().getResourceAsStream("/dossier/productividad/Fonts/Roboto-Bold.ttf");
        try {
            Font myFont = Font.createFont(Font.TRUETYPE_FONT, istream);
        } catch (FontFormatException ex) {
            Logger.getLogger(DossierProductividad.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        //Obtiene el dia, ano y mes actual para el indice de las listas
        String ddiaActual = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        diaActual = Integer.parseInt(ddiaActual)-1;
        System.out.println("El dia es: "+diaActual);
        String mmesActual = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        mesActual = Integer.parseInt(mmesActual)-1;
        System.out.println("El mes es: "+mesActual);
        String aanoActual = new SimpleDateFormat("YY").format(Calendar.getInstance().getTime());
        anoActual = Integer.parseInt(aanoActual);
        System.out.println("El ano es: "+anoActual);
        // Se crea y despliega la interfaz grafica
        DossierProductividadGUI dossier = new DossierProductividadGUI();
        dossier.setVisible(true);
        dossier.setframeicon(dossier, "icono.png");    // Pone el icono de la aplicacion
        // Pone deja como default el texto centrado en el estilo
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyledDocument     pane   = DossierProductividadGUI.paneDisplay1.getStyledDocument();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        aplicarCentroPane(pane, center);
        pane = DossierProductividadGUI.paneDisplay2.getStyledDocument();
        aplicarCentroPane(pane, center);
        pane = DossierProductividadGUI.paneDisplay3.getStyledDocument();
        aplicarCentroPane(pane, center);
        StyledDocument     pane2   = DossierProductividadGUI.paneDisplay4.getStyledDocument();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        aplicarCentroPane(pane2, center);
        pane2 = DossierProductividadGUI.paneDisplay5.getStyledDocument();
        aplicarCentroPane(pane2, center);
        pane2 = DossierProductividadGUI.paneDisplay6.getStyledDocument();
        aplicarCentroPane(pane2, center);
        // Carga el texto en los paneles y tablas
        manejaTexto.actualizarTexto(6); // Actualiza los datos de la lista de tareas
        manejaTexto.actualizarTexto(0); // Actualiza el texto en los paneles de tareas
        manejaTexto.actualizarTexto(4); // Actualiza los valores de las tablas
        manejaTexto.actualizarTexto(2); // Actualiza los valores de las tablas
    }
}
