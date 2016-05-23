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
public class ClienteFisico extends Cliente {
    
    private static int cantidadInstancias = 0;
    
    public ClienteFisico(DTOSistema sistema){
        
        super(sistema);
        cantidadInstancias++;
        this.id = "Cli#" + this.cantidadInstancias;
    }  
}
