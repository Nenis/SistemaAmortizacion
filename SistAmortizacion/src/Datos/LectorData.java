/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author SilviaElena
 */
public class LectorData {

    public LectorData() {
    }

    public ArrayList<String> getRegistros(String tipo) {
        ArrayList<String> registros = new ArrayList<>();
        if (tipo == "Monedas") {
            registros = getRegistroArchivo(tipo, "Monedas_Registradas", "Moneda");
        } else if (tipo == "SistemasAmortizacion") {
            registros = getRegistroArchivo(tipo, "Sistemas_Registrados", "Sistema");
        } else {
            return registros;
        }
        return registros;
    }

    private ArrayList<String> getRegistroArchivo(String nombre, String etiquetaChild, String etiquetaNodo) {
        ArrayList<String> sistemas = new ArrayList<>();
        try {
            File inputFile = new File(nombre + ".xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(etiquetaChild);
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    sistemas.add(element.getElementsByTagName(etiquetaNodo).item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            e.printStackTrace();
        }
        return sistemas;
    }
}
