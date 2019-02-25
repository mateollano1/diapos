/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class BusquedaCancion {
    private static String cadenaFinal;
    /*Lee el archivo ruta txt y lo almacena en cadenaFinal*/
    public static void leerRuta() 
    {
        String cadena;
      FileReader f = null;
        try {
            f = new FileReader("ruta.txt");
            BufferedReader b = new BufferedReader(f);
          try {
              while((cadena = b.readLine())!=null) {
                  cadenaFinal=cadena;
              }
          } catch (IOException ex) {
              Logger.getLogger(BusquedaCancion.class.getName()).log(Level.SEVERE, null, ex);
          }
try {
                b.close();
          } catch (IOException ex) {
              Logger.getLogger(BusquedaCancion.class.getName()).log(Level.SEVERE, null, ex);
          }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BusquedaCancion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(BusquedaCancion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
/*Dirige al método correspondiente según la variable seleccion*/
    public static void abrirCancion(int libro, String numero, boolean seleccion) 
    {
       if (seleccion)
       {
           abrirModoPresentacion(libro, numero);
       }
       else
       {
           abrirPower(libro, numero);
       }
    }
    /*Abre la presentación seleccionada del libro seleccionado en modo visualización*/
    private static void abrirModoPresentacion(int libro, String numero)
    {
        try {
            String sep = File.separator;
            if (libro == 1) {
                String documento = cadenaFinal + " cantemos\\" + numero + ".pptx";
                Process proceso = Runtime.getRuntime().exec(documento);
            } else if (libro == 2) {
                String documento = cadenaFinal + " gloria\\" + numero + ".pptx";
                Process proceso = Runtime.getRuntime().exec(documento);
            } 
            else if (libro==3)
            {
                String documento = cadenaFinal + " alabanza\\" + numero + ".pptx";
                Process proceso = Runtime.getRuntime().exec(documento);
            }
            else {
                JOptionPane.showMessageDialog(null, "Seleccione libro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir archivo " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    /*Abre la presentación seleccionada del libro correspondiente en power point*/
    private static void abrirPower(int libro, String numero)
    {
        try {
            if (libro==1)
            {Desktop.getDesktop().open(new File("cantemos\\"+numero+".pptx"));}
            else if (libro==2)
            {Desktop.getDesktop().open(new File("gloria\\"+numero+".pptx"));}
            else if (libro==3)
            {
                Desktop.getDesktop().open(new File("alabanza\\"+numero+".pptx"));
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Seleccione libro");
            }
        } catch (IOException ex) {
            Logger.getLogger(BusquedaCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
