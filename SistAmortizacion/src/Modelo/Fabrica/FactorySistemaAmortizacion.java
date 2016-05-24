/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Fabrica;

import DataTransferObject.DTOSistema;
import Modelo.SistemaAmortizacion;

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

    public SistemaAmortizacion crearSistemaAmortizacion(DTOSistema dtoSistema) {
        SistemaAmortizacion objeto = null;
        try {
            Class c = Class.forName("Modelo." + dtoSistema.getTipoSistema());
            objeto = (SistemaAmortizacion) c.getConstructor(DTOSistema.class).newInstance(dtoSistema);
        } catch (Exception ex) {
            System.out.println("No se pudo crear el Sistema");
        }
        return objeto;
    }

}
