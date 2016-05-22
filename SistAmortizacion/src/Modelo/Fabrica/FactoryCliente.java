/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Fabrica;

import DataTransferObject.DTOCliente;
import DataTransferObject.DTOSistema;
import Modelo.Cliente;
import Modelo.SistemaAmortizacion;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Kenneth
 */
public class FactoryCliente {
    
        public Cliente crearCliente(DTOCliente dtoCliente) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Class c = Class.forName("Modelo." + dtoCliente.getTipo());
        Cliente objeto = (Cliente) c.getConstructor(DTOCliente.class).newInstance(dtoCliente);
        return objeto;
    }
    
}
