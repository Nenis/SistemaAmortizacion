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
public abstract class Cliente {
    
    private static int cantidadInstancias = 0;
    protected String id;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    
    public Cliente(DTOCliente cliente){
        this.nombre = cliente.getNombre();
        this.primerApellido = cliente.getPrimerApellido();
        this.segundoApellido = cliente.getSegundoApellido();
        cantidadInstancias ++; 
    }    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    
    @Override
    public String toString(){
        return this.nombre + " " +  this.primerApellido + " " + this.segundoApellido;
    }
    
    
    
}
