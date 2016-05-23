/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import DataTransferObject.DTOSistema;
import java.util.ArrayList;

/**
 *
 * @author SilviaElena
 */
public interface IControlador {

    public DTOSistema crearAmortizacion(DTOSistema dtoSistema);

    public String getTipoCambioCompra();
    
    public String getFechaHora();
    
    public void registrarBitacora(DTOSistema dtoSistema);
}
