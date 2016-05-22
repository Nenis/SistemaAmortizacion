/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
    
    public ArrayList<String> getSistemasRegistrados(){
        ArrayList<String> sistemas = new ArrayList<>();
        try {
            File xml = new File("SistemasAmortizacion.xml"); //Lee archivo xml
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = documentFactory.newDocumentBuilder();
            Document document = (Document) db.parse(xml);

            NodeList list = document.getElementsByTagName("Sistemas_Registrados");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    sistemas.add(element.getElementsByTagName("Sistema").item(0).getTextContent());
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            System.out.println("No pudo acceder al archivo");
        }
        return sistemas;
    }
}
