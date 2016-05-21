/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import DataTransferObject.DTOSistema;

/**
 *
 * @author Kenneth
 */
public class Aleman extends SistemaAmortizacion{
    
    public Aleman(DTOSistema dtoSistema){
        super(dtoSistema);
    }
    
    private Double calcularCuotaInicial(){
  
        Double cuota =  calcularAmortizacion() + (this.interes * this.montoPrestamo);
        return cuota;
    }
    
    @Override
    protected Double calcularAmortizacion(){
        
        Double amortizacion = (this.montoPrestamo/this.plazo);
        return amortizacion;
    }
    
    @Override
    protected Double calcularInteres(){
        
        Double interes = calcularDeuda() * this.interes;
        return interes;
    }
    @Override
    protected Double calcularCuota(){
        
        if (this.plazo == 1){
            return calcularCuotaInicial();
        }
    
        return calcularInteres() + calcularAmortizacion();
    } 
    

}
