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

    private ArrayList<Bitacora> observadores = new ArrayList<>();

    public Subject(){}

    public void setRegistro(DTOSistema sistema) {
        notificarObservadores(sistema);
    }

    public void adjuntar(Bitacora observador) {
        observadores.add(observador);
    }
    
    public void desAdjuntar(Bitacora observador){
        observadores.remove(observador);
    }

    public void notificarObservadores(DTOSistema sistema) {
        for (Bitacora observer : observadores) {
            observer.update(sistema);
        }
    }
}
