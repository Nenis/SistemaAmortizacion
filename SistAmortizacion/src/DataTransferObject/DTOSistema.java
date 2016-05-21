/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;
import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Kenneth
 */
public class DTOSistema {
    
    private double montoPrestamo;
    private int plazo;
    private String moneda;
    private Double interes;
    private ArrayList<Double> cuotas;
    private ArrayList<Double> intereses;
    private ArrayList<Double> amortizaciones;
    private Cliente cliente;
    private String tipo;
    
    public DTOSistema(Double montoPrestamo,int plazo,Double interes,String moneda, Cliente cliente){
        this.montoPrestamo = montoPrestamo;
        this.plazo = plazo;
        this.moneda = moneda;
        this.interes = interes;
        this.cliente = cliente;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }

    public int getPlazo() {
        return plazo;
    }

    public String getMoneda() {
        return moneda;
    }

    public Double getInteres() {
        return interes;
    }

    public ArrayList<Double> getCuotas() {
        return cuotas;
    }

    public ArrayList<Double> getIntereses() {
        return intereses;
    }

    public ArrayList<Double> getAmortizaciones() {
        return amortizaciones;
    }

    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public void setCuotas(ArrayList<Double> cuotas) {
        this.cuotas = cuotas;
    }

    public void setIntereses(ArrayList<Double> intereses) {
        this.intereses = intereses;
    }

    public void setAmortizaciones(ArrayList<Double> amortizaciones) {
        this.amortizaciones = amortizaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    
}
