/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Kenneth
 */
public class ClienteChucky implements ITiempo {

    private String direccion = "localhost";
    private int puerto = 8666;

    private Socket socketChucky() throws IOException {
        Socket socketChucky = new Socket(this.direccion, this.puerto);
        return socketChucky;
    }

    @Override
    public String getFechaHora() {
        String tiempo = "";
        try {
            Socket chucky = this.socketChucky();
            BufferedReader buff = new BufferedReader(new InputStreamReader(chucky.getInputStream()));
            tiempo = buff.readLine();      
        } catch (Exception e) { 
            return e.getMessage();
        }
        return tiempo;
    }
}
