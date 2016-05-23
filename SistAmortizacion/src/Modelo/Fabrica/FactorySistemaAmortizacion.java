/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Fabrica;

import DataTransferObject.DTOSistema;
import Modelo.SistemaAmortizacion;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 *
 * @author Kenneth
 */
public class FactorySistemaAmortizacion {

    private static FactorySistemaAmortizacion instancia;

    private FactorySistemaAmortizacion() {
    }

    public static FactorySistemaAmortizacion getInstance() {
        if (instancia == null) {
            FactorySistemaAmortizacion instancia = new FactorySistemaAmortizacion();
            return instancia;
        }
        return FactorySistemaAmortizacion.instancia;
    }

    public SistemaAmortizacion crearSistemaAmortizacion(DTOSistema dtoSistema) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Class c = Class.forName("Modelo." + dtoSistema.getTipoSistema());
        SistemaAmortizacion objeto = (SistemaAmortizacion) c.getConstructor(DTOSistema.class).newInstance(dtoSistema);
        return objeto;
    }

}
