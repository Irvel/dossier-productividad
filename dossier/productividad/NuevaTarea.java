/* 
* @(#)NuevaTarea.java
* 
* * * * * * * * * * * * * * * * * * * * * D E S C R I P C I O N * * * * * * * * * * * * * * * * * * * * * *
* Esta clase se encarga de administrar los procesos que lleva a cabo la ventana de tareas nueva.
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
public class NuevaTarea {
    private static PrintWriter fileOut;
    private static BufferedReader fileIn;
    
    public static void main(String args[]){}
    
    //----------------------------  Agregar nueva tarea al archivo de texto   -----------------------------------
    public static void agregarNuevaTarea() throws IOException {
        fileOut = new PrintWriter(new FileWriter("Tareas" + ".txt", true));
        String titulo = "", materia = "", fecha = "", descripcion = ""; //Declaracion de variables
        boolean seguir = false;
        try {
            titulo = NuevaTareaGUI.inputTitulo.getText();
            if (titulo.equals("")) {
                DossierProductividadGUI.mensajeError("el nombre de la tarea correctamete");
                seguir = false;
            } else {
                //Si el titulo no viene vacio, continuar con tomar los datos de la interfaz
                titulo = titulo.trim();
                titulo = titulo.replace("\n", "").replace("\r", "");
                materia = NuevaTareaGUI.comboMaterias.getSelectedItem().toString();
                try {
                    descripcion = NuevaTareaGUI.inputDescripcion.getText();
                    descripcion = descripcion.replace("\n", "").replace("\r", "");
                    if(descripcion.equalsIgnoreCase("")){
                        descripcion = " ";
                    }
                } catch (NullPointerException e) {
                    descripcion = " ";
                }
                //Construye fecha con los separadores necesarios
                fecha = NuevaTareaGUI.comboDia.getSelectedItem().toString() + "/"
                        + NuevaTareaGUI.comboMes.getSelectedItem().toString() + "/"
                        + NuevaTareaGUI.comboAno.getSelectedItem().toString();
                seguir = true;
            }
        } catch (NullPointerException e) {
            //En caso de que vengan datos mal, marca error
            DossierProductividadGUI.mensajeError("el nombre de la tarea correctamete");
            seguir = false;
        }
        if (seguir) {
            //Si no hubo error, imprimir los datos, ordenar y actualizar los datos
            String datosBien = titulo + "%" + materia + "%" + descripcion + "%" + fecha;
            fileOut.println(datosBien);
            fileOut.close();
            manejaTexto.actualizarTexto(2);//Ordena los datos
            manejaTexto.actualizarTexto(0);//Actualiza los paneles
            manejaTexto.actualizarTexto(6); // Actualiza los datos de la lista de tareas
        }
        else{
            fileOut.close();
        }
    }
}
