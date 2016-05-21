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
public class Americano extends SistemaAmortizacion {
    
    public Americano(DTOSistema dtoSistema){
        super(dtoSistema);
    }
    
    @Override
    protected Double calcularAmortizacion(){
        
        if (this.plazoActual == this.plazo){
            
            return this.montoPrestamo;
 
        }
       return 0.0;
    }
    
    @Override
    protected Double calcularInteres(){
        return this.interes * calcularDeuda();
    }
    @Override
    protected Double calcularCuota(){
        return calcularInteres() + calcularAmortizacion();
    }
    
}
