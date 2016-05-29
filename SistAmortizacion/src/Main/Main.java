/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Adaptador.ClienteChucky;
import Adaptador.ITiempo;
import DataTransferObject.*;
import Modelo.*;
import Modelo.Fabrica.FactorySistemaAmortizacion;
import Modelo.Observador.BitacoraCSV;
import Modelo.Observador.BitacoraXML;
import Modelo.Observador.Subject;
import Vista.VistaConsola;
import Vista.VistaGUI;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author SilviaElena
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        VistaConsola consola = new VistaConsola();

        consola.run();

    }

}
