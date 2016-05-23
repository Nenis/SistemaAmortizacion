/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Fabrica;

import DataTransferObject.DTOSistema;
import Modelo.Cliente;
import Modelo.SistemaAmortizacion;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Kenneth
 */
public class FactoryCliente {
        
        private static FactoryCliente instancia = null;
    
        private FactoryCliente(){}
    

        public static FactoryCliente getInstance(){
            if(instancia == null){
                FactoryCliente instancia = new FactoryCliente();
                return instancia;
            }
            return FactoryCliente.instancia;  
        }
        
        public Cliente crearCliente(DTOSistema dtoSistema) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Class c = Class.forName("Modelo.Cliente" + dtoSistema.getTipoCliente());
        Cliente objeto = (Cliente) c.getConstructor(DTOSistema.class).newInstance(dtoSistema);
        return objeto;
    }
    
}
