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
    private ArrayList<ArrayList<Double>> tabla;
    private String tipoSistema;
    //Cliente data
    private String nombreCliente;
    private String primerApellidoCliente;
    private String segundoApellidoCliente;
    private String nombreCompletoCliente;
    private String tipoCliente;
    private Double tipoCambio;


    public DTOSistema() {
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPrimerApellidoCliente() {
        return primerApellidoCliente;
    }

    public void setPrimerApellidoCliente(String primerApellidoCliente) {
        this.primerApellidoCliente = primerApellidoCliente;
    }

    public String getSegundoApellidoCliente() {
        return segundoApellidoCliente;
    }

    public void setSegundoApellidoCliente(String segundoApellidoCliente) {
        this.segundoApellidoCliente = segundoApellidoCliente;
    }

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public Double getMontoPrestamo() {
        return montoPrestamo;
    }

    public int getPlazo() {
        return plazo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getInteres() {
        return interes;
    }

    public void setMontoPrestamo(Double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public ArrayList<ArrayList<Double>> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<ArrayList<Double>> tabla) {
        this.tabla = tabla;
    }

    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
    
    public Double getTipoCambio() {
        return tipoCambio;
    }
}
