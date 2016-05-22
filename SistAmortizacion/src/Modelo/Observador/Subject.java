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

    private ArrayList<Bitacora> observers = new ArrayList<>();


    public void setRegistro(DTOCliente cliente, DTOSistema sistema) {
        notificarObservadores(cliente, sistema);
    }

    public void attach(Bitacora observer) {
        observers.add(observer);
    }

    public void notificarObservadores(DTOCliente cliente, DTOSistema sistema) {
        for (Bitacora observer : observers) {
            observer.update(cliente, sistema);
        }
    }
}
