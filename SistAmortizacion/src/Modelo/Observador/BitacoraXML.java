/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Observador;

import DataTransferObject.DTOSistema;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author SilviaElena
 */
public class BitacoraXML extends Bitacora {

    private static String pathXML;

    public BitacoraXML(Subject subject) {
        this.pathXML = "Registro_Historico.xml";
        this.subject = subject;
        this.subject.adjuntar(this);
    }

    @Override
    public void crearArchivo() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element element = document.createElement("Sistema_Amortizacion");
            Element registro = document.createElement("Registro_Historico");
            document.appendChild(element);
            element.appendChild(registro);
            transformarArchivo(document);

        } catch (ParserConfigurationException ex) {
            System.out.println("No se pudo crear el archivo");
        }
    }

    @Override
    public void añadirRegristro(DTOSistema sistema) {
        if (!validarArchivo(BitacoraXML.pathXML)) {
            crearArchivo();
        }
        crearNuevoRegistro(sistema);
    }

    @Override
    public void crearNuevoRegistro(DTOSistema sistema) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(BitacoraXML.pathXML);

            Element etiqueta = doc.getDocumentElement();
            Element tagRegistro = (Element) etiqueta.getElementsByTagName("Registro_Historico").item(0);

            //Añadir nuevo registro
            Element nuevoRegistro = doc.createElement("Registro");

            Element nombreCliente = doc.createElement("Nombre_Cliente");
            nombreCliente.setTextContent(" " + sistema.getNombreCompletoCliente() + " ");

            Element montoPrestamo = doc.createElement("Monto_Prestamo_Otorgado");
            montoPrestamo.setTextContent(String.valueOf(" " + sistema.getMontoPrestamo() + " "));

            Element plazoPrestamo = doc.createElement("Plazo_Prestamo");
            plazoPrestamo.setTextContent(String.valueOf(" " + sistema.getPlazo() + " "));

            Element interesPrestamo = doc.createElement("Interes_Prestamo");
            interesPrestamo.setTextContent(String.valueOf(" " + sistema.getInteres() + " "));

            Element sistemaAmortizacion = doc.createElement("Sistema");
            sistemaAmortizacion.setTextContent(" " + sistema.getTipoSistema() + " ");

            Element moneda = doc.createElement("Moneda");
            moneda.setTextContent(" " + sistema.getMoneda() + " ");

            nuevoRegistro.appendChild(nombreCliente);
            nuevoRegistro.appendChild(montoPrestamo);
            nuevoRegistro.appendChild(plazoPrestamo);
            nuevoRegistro.appendChild(interesPrestamo);
            nuevoRegistro.appendChild(sistemaAmortizacion);
            nuevoRegistro.appendChild(moneda);

            tagRegistro.appendChild(nuevoRegistro);
            transformarArchivo(doc);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("No se pudo crear un nuevo registro");
        }
    }

    private void transformarArchivo(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);

            StreamResult streamResult = new StreamResult(new File(this.pathXML));
            transformer.transform(source, streamResult);
        } catch (TransformerException ex) {
            System.out.println("No se pudo tranformar el archivo");
        }
    }
}
