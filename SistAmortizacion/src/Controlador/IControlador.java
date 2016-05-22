/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DataTransferObject.DTOCliente;
import DataTransferObject.DTOSistema;
import Modelo.Cliente;
import Modelo.SistemaAmortizacion;

/**
 *
 * @author SilviaElena
 */
public interface IControlador {
    
    public Cliente crearCliente(DTOCliente dtoCliente);
    public SistemaAmortizacion crearAmortizacion(DTOSistema dtoSistema);
    public void registrarBitacora(DTOCliente dtoCliente,DTOSistema dtoSistema);
    
}
