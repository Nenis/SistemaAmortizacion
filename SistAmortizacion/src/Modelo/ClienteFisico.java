/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import DataTransferObject.DTOCliente;

/**
 *
 * @author Kenneth
 */
public class ClienteFisico extends Cliente {
    
    private static int cantidadInstancias = 0;
    
    public ClienteFisico(DTOCliente cliente){
        
        super(cliente);
        cantidadInstancias++;
        this.id = "Cli#" + this.cantidadInstancias;
    }  
}
