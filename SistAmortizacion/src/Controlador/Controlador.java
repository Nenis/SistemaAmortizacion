/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Adaptador.ClienteChucky;
import Adaptador.IIndicadorEconomico;
import Adaptador.ITiempo;
import Adaptador.WebServiceBCCR;
import DataTransferObject.DTOSistema;
import Modelo.Cliente;
import Modelo.Fabrica.FactoryCliente;
import Modelo.Fabrica.FactorySistemaAmortizacion;
import Modelo.Observador.BitacoraCSV;
import Modelo.Observador.BitacoraXML;
import Modelo.Observador.Subject;
import Modelo.SistemaAmortizacion;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SilviaElena
 */
public class Controlador implements IControlador {

    private static Controlador instancia;

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
    public DTOSistema crearAmortizacion(DTOSistema dtoSistema) {

        FactorySistemaAmortizacion factoryAmortizacion = FactorySistemaAmortizacion.getInstance();
        FactoryCliente factoryCliente = FactoryCliente.getInstance();

        SistemaAmortizacion amortizacion = null;
        Cliente cliente = null;
        try {

            cliente = factoryCliente.crearCliente(dtoSistema);
            amortizacion = factoryAmortizacion.crearSistemaAmortizacion(dtoSistema);
            amortizacion.setCliente(cliente);

            dtoSistema.setNombreCompletoCliente(cliente.toString());
            dtoSistema.setTabla(amortizacion.calcularTablaAmortizacion());

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
        return dtoSistema;
    }

    @Override
    public void registrarBitacora(DTOSistema dtoSistema) {

        Subject subject = new Subject();
        new BitacoraXML(subject);
        new BitacoraCSV(subject);
        subject.setRegistro(dtoSistema);

    }

    @Override
    public String getTipoCambioCompra() {
        IIndicadorEconomico tipoCambio = new WebServiceBCCR();
        return tipoCambio.obtenerTipoCambioDolar();
        
    }

    @Override
    public String getFechaHora() {
        ITiempo tiempo = new ClienteChucky();
        return tiempo.getFechaHora();
    }

}
