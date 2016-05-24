/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Fabrica;

import DataTransferObject.DTOSistema;
import Modelo.Cliente;

/**
 *
 * @author Kenneth
 */
public class FactoryCliente {

    private static FactoryCliente instancia = null;

    private FactoryCliente() {
    }

    public static FactoryCliente getInstance() {
        if (instancia == null) {
            instancia = new FactoryCliente();
            return instancia;
        }
        return FactoryCliente.instancia;
    }

    public Cliente crearCliente(DTOSistema dtoSistema) {
        Cliente objeto = null;
        try {
            Class c = Class.forName("Modelo.Cliente" + dtoSistema.getTipoCliente());
            objeto = (Cliente) c.getConstructor(DTOSistema.class).newInstance(dtoSistema);
        } catch (Exception ex) {
            System.out.println("No se pudo crear el Cliente");
        }
        return objeto;
    }

}
