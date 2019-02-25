/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Usuario
 */
public class ControlBusqueda {
    public static void buscar (int tipo, String numero, boolean seleccion)
    {
        Modelo.BusquedaCancion.abrirCancion(tipo, numero,seleccion);
    }
    
}
