/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Observador;

import DataTransferObject.*;
import java.io.File;

/**
 *
 * @author SilviaElena
 */
public abstract class Bitacora {

    protected Subject subject;

    public abstract void crearArchivo();

    public Boolean validarArchivo(String path) {
        File archivo = new File(path);
        return archivo.exists();
    }

    public abstract void añadirRegristro(DTOCliente cliente, DTOSistema sistema);

    public abstract void crearNuevoRegistro(DTOCliente cliente, DTOSistema sistema);

    public void update(DTOCliente cliente, DTOSistema sistema) {
        añadirRegristro(cliente, sistema);
    }

}
