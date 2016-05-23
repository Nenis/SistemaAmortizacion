package Validacion;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SilviaElena
 */
public class Validacion {

    public Validacion() {
    }
    
    public boolean validarNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean validarNombre(String cadena) {
        Pattern patron = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = patron.matcher(cadena);
        return !matcher.find();
    }

    public boolean validarDouble(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Double formatearDouble(Double valor) {
        DecimalFormat decimales = new DecimalFormat("0.00");
        decimales.format(valor);
        return valor;
    }

}
