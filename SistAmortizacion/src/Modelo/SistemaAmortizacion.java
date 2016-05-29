/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DataTransferObject.*;
import Validacion.Validacion;
import java.util.ArrayList;

/**
 *
 * @author Kenneth
 */
public abstract class SistemaAmortizacion {

    private int cantidadInstancias = 0;
    protected String id;
    protected Double montoPrestamo;
    protected int plazo;
    protected Double interes;
    protected Cliente cliente;

    protected int plazoActual;
    protected Double montoActual;

    public SistemaAmortizacion(DTOSistema dtoSistema) {

        cantidadInstancias++;
        this.montoPrestamo = dtoSistema.getMontoPrestamo();
        this.plazo = dtoSistema.getPlazo();
        this.interes = dtoSistema.getInteres();
        this.plazoActual = 1;
        this.montoActual = montoPrestamo;
    }

    protected abstract Double calcularAmortizacion();

    protected abstract Double calcularInteres();

    protected abstract Double calcularCuota();

    protected void reducirMontoActual() {
        this.montoActual = montoActual - calcularAmortizacion();
    }

    protected Double calcularDeuda() {

        return this.montoActual;
    }

    public ArrayList<ArrayList<Double>> calcularTablaAmortizacion(Double tipoCambio) {

        ArrayList<Double> deudas = new ArrayList<>(),
                intereses = new ArrayList<>(),
                amortizaciones = new ArrayList<>(), cuotas = new ArrayList<>();
        Validacion v = new Validacion();

        for (; this.plazoActual <= plazo; this.plazoActual++) {
            deudas.add(v.formatearDouble(calcularDeuda()/tipoCambio));
            intereses.add(v.formatearDouble(calcularInteres()/tipoCambio));
            amortizaciones.add(v.formatearDouble(calcularAmortizacion()/tipoCambio));
            cuotas.add(v.formatearDouble(calcularCuota()/tipoCambio));
            reducirMontoActual();
        }

        ArrayList<ArrayList<Double>> tabla = new ArrayList<ArrayList<Double>>();
        tabla.add(deudas);
        tabla.add(intereses);
        tabla.add(amortizaciones);
        tabla.add(cuotas);
        ArrayList<ArrayList<Double>> tablaTotal = this.agregarTotales(tabla);
        return tablaTotal;
    }

    private ArrayList<ArrayList<Double>> agregarTotales(ArrayList<ArrayList<Double>> tabla) {
        double total = 0;
        Validacion v = new Validacion();
        ArrayList<Double> lista;
        for (int i = 1; i < tabla.size(); i++) {
            lista = tabla.get(i);
            for (Double elemento : lista) {
                total += elemento;
            }
            lista.add(v.formatearDouble(total));
            total = 0;
        }
        return tabla;
    }
    

    protected void aumentarPlazoActual() {

        this.plazoActual++;
    }

    public int getCantidadInstancias() {
        return cantidadInstancias;
    }

    public void setCantidadInstancias(int cantidadInstancias) {
        this.cantidadInstancias = cantidadInstancias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(Double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPlazoActual() {
        return plazoActual;
    }

    public void setPlazoActual(int plazoActual) {
        this.plazoActual = plazoActual;
    }

}
