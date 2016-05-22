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
    private int estado;

    public int getState() {
        return estado;
    }

    public void setEstado(int estado, DTOCliente cliente,DTOSistema sistema) {
        this.estado = estado;
        notificarObservadores(cliente,sistema);
    }

    public void attach(Bitacora observer) {
        observers.add(observer);
    }

    public void notificarObservadores(DTOCliente cliente, DTOSistema sistema) {
        for (Bitacora observer : observers) {
            observer.update(cliente,sistema);
        }
    }
}
