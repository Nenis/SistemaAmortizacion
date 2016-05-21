/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import DataTransferObject.*;
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
    protected String moneda;
    protected Cliente cliente;

    protected int plazoActual;
    protected Double montoActual;
     
    public SistemaAmortizacion(DTOSistema dtoSistema){
        
        cantidadInstancias ++;
        this.montoPrestamo = dtoSistema.getMontoPrestamo();
        this.plazo = dtoSistema.getPlazo();
        this.interes = dtoSistema.getInteres();
        this.moneda = dtoSistema.getMoneda();
        this.cliente = dtoSistema.getCliente();
        
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
    
    public ArrayList<ArrayList<Double>> calcularTablaAmortizacion(){
        
        ArrayList<Double> deudas = new ArrayList<>();
        ArrayList<Double> intereses = new ArrayList<>();
        ArrayList<Double> amortizaciones = new ArrayList<>();
        ArrayList<Double> cuotas = new ArrayList<>();
       
        for (;this.plazoActual <= plazo; this.plazoActual ++) {
            deudas.add(calcularDeuda());
            intereses.add(calcularInteres());
            amortizaciones.add(calcularAmortizacion());
            cuotas.add(calcularCuota());
            
            reducirMontoActual();
            
        }
        
        ArrayList<ArrayList<Double>> tabla = new ArrayList<ArrayList<Double>>();
        tabla.add(deudas);
        tabla.add(intereses);
        tabla.add(amortizaciones);
        tabla.add(cuotas);
        
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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
