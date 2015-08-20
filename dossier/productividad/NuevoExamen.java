/* 
* @(#)NuevoExamen.java
* 
* * * * * * * * * * * * * * * * * * * * * D E S C R I P C I O N * * * * * * * * * * * * * * * * * * * * * *
* Esta clase se encarga de administrar los procesos que lleva a cabo el ventana de examens nueva.
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* @author (Irvel Nduva)
* @version 0.1 2013/10/02
*/
package dossier.productividad;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author irvel_000
 */
public class NuevoExamen {
    private static PrintWriter fileOut;
    private static BufferedReader fileIn;
    
    public static void main(String args[]){}
    
    //----------------------------  Agregar nueva examen al archivo de texto   -----------------------------------
    public static void agregarNuevoExamen() throws IOException {
        fileOut = new PrintWriter(new FileWriter("Examenes" + ".txt", true));
        String titulo = "", materia = "", fecha = "", descripcion = ""; //Declaracion de variables
        boolean seguir = false;
        try {
            titulo = NuevoExamenGUI.inputTitulo.getText();
            if (titulo.equals("")) {
                DossierProductividadGUI.mensajeError("el nombre de el examen correctamete");
                seguir = false;
            } else {
                //Si el titulo no viene vacio, continuar con tomar los datos de el interfaz
                titulo = titulo.trim();
                titulo = titulo.replace("\n", "").replace("\r", "");
                materia = NuevoExamenGUI.comboMaterias.getSelectedItem().toString();
                try {
                    descripcion = NuevoExamenGUI.inputDescripcion.getText();
                    descripcion = descripcion.replace("\n", "").replace("\r", "");
                    if(descripcion.equalsIgnoreCase("")){
                        descripcion = " ";
                    }
                } catch (NullPointerException e) {
                    descripcion = " ";
                }
                //Construye fecha con los separadores necesarios
                fecha = NuevoExamenGUI.comboDia.getSelectedItem().toString() + "/"
                        + NuevoExamenGUI.comboMes.getSelectedItem().toString() + "/"
                        + NuevoExamenGUI.comboAno.getSelectedItem().toString();
                seguir = true;
            }
        } catch (NullPointerException e) {
            //En caso de que vengan datos mal, marca error
            DossierProductividadGUI.mensajeError("el nombre de el examen correctamete");
            seguir = false;
        }
        if (seguir) {
            //Si no hubo error, imprimir los datos, ordenar y actualizar los datos
            String datosBien = titulo + "%" + materia + "%" + descripcion + "%" + fecha;
            fileOut.println(datosBien);
            fileOut.close();
            manejaTexto.actualizarTexto(11);//Ordena los datos
            manejaTexto.actualizarTexto(1);//Actualiza los paneles
            //manejaTexto.actualizarTexto(6); // Actualiza los datos de el lista de examens
        }
        else{
            fileOut.close();
        }
    }
}
