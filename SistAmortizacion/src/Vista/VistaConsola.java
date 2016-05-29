/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Controlador.IControlador;
import DataTransferObject.DTOSistema;
import Datos.LectorData;
import Validacion.Validacion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kenneth
 */
public class VistaConsola {

    Scanner scanner = new Scanner(System.in);
    Validacion validacion = new Validacion();
    IControlador controlador = Controlador.getInstance();

    public void run() {

        String nombre, apellido1, apellido2, moneda, tipoAmortizacion;
        Double prestamo, interes;
        int plazo;

        // datos del cliente
        nombre = pedirNombre("Nombre");
        apellido1 = pedirNombre("Primer Apellido");
        apellido2 = pedirNombre("Segundo Apellido");
        // datos del sistema
        prestamo = pedirPrestamo();
        plazo = pedirPlazo();
        interes = pedirInteres();
        tipoAmortizacion = pedirAmortizacion();
        moneda = pedirMoneda();

        //creacion del sistema
        DTOSistema dtoSistema = crearSistema(nombre, apellido1, apellido2, "Fisico", prestamo, plazo, interes,
                moneda, tipoAmortizacion);
        controlador.registrarBitacora(dtoSistema);
        System.out.println(getTipoCambioCompra());
        String datos = mostrarDatosSistema(dtoSistema);
        System.out.println(datos);
        System.out.println(formatearTabla(dtoSistema));
        System.out.println(getFechaHora());

    }

    public String mostrarDatosSistema(DTOSistema dtoSistema) {
        String data = "Datos de la consulta:"
                + "\nCliente: " + dtoSistema.getNombreCompletoCliente()
                + "\nMonto del prestamo otrogado: " + String.valueOf(dtoSistema.getMontoPrestamo()) + " colones" 
                + "\nPlazo del prestamo: " + String.valueOf(dtoSistema.getPlazo()) + " annos"
                + "\nInteres anual: " + String.valueOf(dtoSistema.getInteres()) + "%"
                + "\nSistema de amortizacio: " + dtoSistema.getTipoSistema();
        return data;
    }
    
    public String getTipoCambioCompra() {
       return "Tipo de cambio compra BCCR: " + controlador.getTipoCambioCompra();
    }
    
    public String getFechaHora(){
        return controlador.getFechaHora();
    }

    public String formatearTabla(DTOSistema sistema) {
        String t1 = "      ";
        String t = "              ";
        String t2 = "        ";
        String t3 = "   ";
        ArrayList<ArrayList<Double>> tabla = sistema.getTabla();
        String columna = "Tabla de amortizacion:\n\n";
        columna = "Periodo k" + t1 + "Deuda inicial" + t2 + "Intereses(sk)" + t2
                + "Amortizacion" + t + "Cuota\n";
        for (int x = 0; x < tabla.get(1).size(); x++) {
            if (x == tabla.get(1).size() - 1) {
                columna += "Total" + t2 + t2 + t3;
            } else {
                columna += String.valueOf(x + 1) + t;
            }
            for (int i = 0; i < tabla.size(); i++) {
                if (x + 1 > tabla.get(0).size() && i == 0) {
                    columna += t;
                } else {
                    Double elemento = tabla.get(i).get(x);
                    columna += String.valueOf(elemento) + t;
                }
            }
            columna += "\n";
        }
        return columna;
    }

    public String pedirMoneda() {
        LectorData lector = new LectorData();
        ArrayList<String> monedas = lector.getRegistros("Monedas");
        System.out.println("Seleccione la moneda en el que desea la amortizacion ");
        int size = 1;
        for (String elemento : monedas) {
            System.out.println(size + ") " + elemento);
            size++;
        }

        System.out.println("Digite el numero: ");
        String entradaTeclado = "";
        entradaTeclado = scanner.nextLine();
        if (!validacion.validarNumero(entradaTeclado)) {
            System.out.println("Digite un numero:");
            return pedirMoneda();
        }
        if (Integer.parseInt(entradaTeclado) > monedas.size() || Integer.parseInt(entradaTeclado) < 1) {
            System.out.println("Seleccion incorrecta");
            return pedirMoneda();
        }
        return monedas.get(Integer.parseInt(entradaTeclado) - 1);
    }

    public String pedirAmortizacion() {

        LectorData lector = new LectorData();
        ArrayList<String> amortizaciones = lector.getRegistros("SistemasAmortizacion");

        System.out.println("Seleccione algun sistema de amortizacion ");
        int size = 1;
        for (String elemento : amortizaciones) {
            System.out.println(size + ") " + elemento);
            size++;
        }

        System.out.println("Digite el numero: ");
        String entradaTeclado = "";
        entradaTeclado = scanner.nextLine();
        if (!validacion.validarNumero(entradaTeclado)) {
            System.out.println("Digite un numero:");
            return pedirAmortizacion();
        }
        if (Integer.parseInt(entradaTeclado) > amortizaciones.size() || Integer.parseInt(entradaTeclado) < 1) {
            System.out.println("Seleccion incorrecta");
            return pedirAmortizacion();
        }
        return amortizaciones.get(Integer.parseInt(entradaTeclado) - 1);
    }

    public DTOSistema crearSistema(String nombreCliente,
            String apellido1, String apellido2, String tipoCliente, double prestamo, int plazo,
            double interes, String moneda, String tipoSistema) {

        DTOSistema dtoSistema = new DTOSistema();
        dtoSistema.setMontoPrestamo(prestamo);
        dtoSistema.setPlazo(plazo);
        dtoSistema.setInteres(interes);
        dtoSistema.setTipoSistema(tipoSistema);
        dtoSistema.setMoneda(moneda);
        dtoSistema.setNombreCliente(nombreCliente);
        dtoSistema.setPrimerApellidoCliente(apellido1);
        dtoSistema.setSegundoApellidoCliente(apellido2);
        dtoSistema.setTipoCliente(tipoCliente);

        return controlador.crearAmortizacion(dtoSistema);

    }

    public double pedirPrestamo() {
        System.out.println("Digite el Prestamo:");
        String entradaTeclado = "";
        entradaTeclado = scanner.nextLine();
        if (!validacion.validarDouble(entradaTeclado)) {
            System.out.println("Prestamo incorrecto");
            return pedirPrestamo();

        }
        return Double.parseDouble(entradaTeclado);
    }

    public int pedirPlazo() {
        System.out.println("Digite el plazo: (En cantidad de annos)");
        String entradaTeclado = "";
        entradaTeclado = scanner.nextLine();
        if (!validacion.validarNumero(entradaTeclado)) {
            System.out.println("Plazo incorrecto");
            return pedirPlazo();

        }
        return Integer.parseInt(entradaTeclado);
    }

    public double pedirInteres() {
        System.out.println("Digite el interes: (Digite un numero del 1 al 100)");
        String entradaTeclado = "";
        entradaTeclado = scanner.nextLine();
        if (!validacion.validarNumero(entradaTeclado)) {
            System.out.println("Interes incorrecto");
            return pedirPlazo();
        }
        return Double.parseDouble(entradaTeclado) / 100;
    }

    // El tipo puede ser nombre/apellido1/apeliido2
    public String pedirNombre(String tipo) {
        System.out.println("Escriba su " + tipo + ":");
        String entradaTeclado = "";
        entradaTeclado = scanner.nextLine();
        if (!validacion.validarNombre(entradaTeclado)) {
            System.out.println(tipo + " incorrecto");
            return pedirNombre(tipo);

        }
        return entradaTeclado;
    }
}
