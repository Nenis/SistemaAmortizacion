/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Observador;

import DataTransferObject.DTOSistema;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SilviaElena
 */
public class BitacoraCSV extends Bitacora {

    private static String pathCSV;

    public BitacoraCSV(Subject subject) {
        BitacoraCSV.pathCSV = "Registro_Historico.csv";
        this.subject = subject;
        subject.adjuntar(this);
    }

    @Override
    public void crearArchivo() {
        try {
            FileWriter archivo = new FileWriter(BitacoraCSV.pathCSV);
            archivo.append("_____________________________________________________\n");
            archivo.append("  ------------- |  Sistema Amortizacion  | -------------\n");
            archivo.append("_____________________________________________________\n");
            archivo.close();
        } catch (IOException ex) {
            System.out.println("No se pudo crear el archivo");
        }
    }

    @Override
    public void añadirRegristro(DTOSistema sistema) {
        if (!validarArchivo(this.pathCSV)) 
            crearArchivo();
        crearNuevoRegistro(sistema);
        
    }

    @Override
    public void crearNuevoRegistro(DTOSistema sistema) {
        try {
            FileWriter archivo = new FileWriter(BitacoraCSV.pathCSV,true);
            archivo.append("-------------------------Registro------------------------------\n");
            archivo.append("Nombre_Cliente: " + sistema.getNombreCompletoCliente()+ "\n");
            archivo.append("Monto_Prestamo_Otorgado: " + String.valueOf(sistema.getMontoPrestamo()) + "\n");
            archivo.append("Plazo_Prestamo: " + String.valueOf(sistema.getPlazo()) + "\n");
            archivo.append("Interes_Prestamo: " + String.valueOf(sistema.getInteres()) + "\n");
            archivo.append("Sistema: " + sistema.getTipoSistema() + "\n");
            archivo.append("Moneda: " + sistema.getMoneda() + "\n");
            archivo.append("_____________________________________________________\n");
            archivo.flush();
            archivo.close();
        } catch (IOException ex) {
            System.out.println("No se pudo crear un nuevo registro");
        }
    }

}
