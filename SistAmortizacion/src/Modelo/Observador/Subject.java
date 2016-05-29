/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Observador;

import DataTransferObject.*;
import java.util.ArrayList;

/**
 *
 * @author SilviaElena
 */
public class Subject {

    private ArrayList<Bitacora> bitacoras;

    public Subject(){
        this.bitacoras = new ArrayList<>();
    }

    public void setRegistro(DTOSistema sistema) {
        notificarObservadores(sistema);
    }

    public void adjuntar(Bitacora observador) {
        bitacoras.add(observador);
    }
    
    public void desAdjuntar(Bitacora observador){
        bitacoras.remove(observador);
    }

    public void notificarObservadores(DTOSistema sistema) {
        for (Bitacora bitacora : bitacoras) {
            bitacora.update(sistema);
        }
    }
}
