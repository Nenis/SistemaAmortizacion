/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistamortizacion;

import DataTransferObject.*;
import Modelo.*;
import Modelo.Fabrica.FactorySistemaAmortizacion;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SilviaElena
 */
public class SistAmortizacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // TODO code application logic here
        DTOCliente dtoCliente = new DTOCliente("silvia","elena","alpizar");
        Cliente cliente = new ClienteFisico(dtoCliente);
        DTOSistema dtoSistema = new DTOSistema(1000000.0,5,0.15,"colones", cliente);
        dtoSistema.setTipo("Aleman");
        SistemaAmortizacion aleman = new Aleman(dtoSistema);
        SistemaAmortizacion frances = new Frances(dtoSistema);
        SistemaAmortizacion americano = new Americano(dtoSistema);
        
        System.out.println(aleman.getClass());
        
       /* System.out.println(aleman.calcularTablaAmortizacion().toString());
        System.out.println(frances.calcularTablaAmortizacion().toString());
        System.out.println(americano.calcularTablaAmortizacion().toString());
        */
        FactorySistemaAmortizacion factory = new FactorySistemaAmortizacion();
        SistemaAmortizacion aleman2 = factory.crearSistemaAmortizacion(dtoSistema);
        
        System.out.println(aleman2.getMoneda());
        
        
                
    }
    
}
