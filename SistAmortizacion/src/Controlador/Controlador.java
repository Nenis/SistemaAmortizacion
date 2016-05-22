/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DataTransferObject.DTOCliente;
import DataTransferObject.DTOSistema;
import Modelo.Cliente;
import Modelo.Fabrica.FactoryCliente;
import Modelo.Fabrica.FactorySistemaAmortizacion;
import Modelo.Observador.BitacoraCSV;
import Modelo.Observador.BitacoraXML;
import Modelo.Observador.Subject;
import Modelo.SistemaAmortizacion;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SilviaElena
 */
public class Controlador implements IControlador {

    public static Controlador instancia;

    private Controlador() {
    }

    public static Controlador getInstance() {
        if (instancia == null) {
            Controlador instancia = new Controlador();
            return instancia;
        }
        return Controlador.instancia;
    }

    @Override
    public Cliente crearCliente(DTOCliente dtoCliente) {
        FactoryCliente factory = FactoryCliente.getInstance();
        Cliente cliente = null;
        try {

            cliente = factory.crearCliente(dtoCliente);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
        return cliente;
    }

    @Override
    public SistemaAmortizacion crearAmortizacion(DTOSistema dtoSistema) {
        FactorySistemaAmortizacion factory = FactorySistemaAmortizacion.getInstance();
        SistemaAmortizacion amortizacion = null;
        try {

            amortizacion = factory.crearSistemaAmortizacion(dtoSistema);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
        return amortizacion;
    }

    @Override
    public void registrarBitacora(DTOCliente dtoCliente, DTOSistema dtoSistema) {
        
        Subject subject = new Subject();
        new BitacoraXML(subject);
        new BitacoraCSV(subject);
        subject.setRegistro(dtoCliente, dtoSistema);

    }

}
