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
public class Frances extends SistemaAmortizacion{
    
    public Frances(DTOSistema dtoSistema){
        super(dtoSistema);
    }
    
    @Override
    protected Double calcularAmortizacion(){
        
        Double amortizacion = calcularCuota()/(Math.pow((1+interes),
                (this.plazo + 1 - this.plazoActual)));
        return amortizacion;
    }
    
    @Override
    protected Double calcularInteres(){
        
        Double interes = this.calcularDeuda() * this.interes;
        return interes;
    }
    @Override
    protected Double calcularCuota(){
        
        Double cuota = calcularInteres()/(1 - 1/(Math.pow((1 + this.interes),
                this.plazo + 1 - this.plazoActual)));
        return cuota;
    }
    

}
