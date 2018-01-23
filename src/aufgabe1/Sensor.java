/**
*
*
*
*/
package aufgabe1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;








/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt xx, Aufgabe xx Verwendete Quellen:
 */
public class Sensor {

  /**
   * Objektvariable die eine ID für den Sennsor hat
   */
  private String id;

  /**
   * Sensor der alle Messungen speichert
   */
  private List<Messung> messungsListe = new ArrayList();

  public Sensor() {
    id = "";
  }

  public Sensor(String id) {
    this.id = id;
  }

  public void ausXMLLesen(String string) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(string + ".xml");
      Element element = document.getDocumentElement();

      id = element.getAttributeNode("id").toString();

      for (int i = 0; i < element.getChildNodes().getLength(); i++) {
        Node kindKnoten = element.getChildNodes().item(i);
        if (kindKnoten instanceof Element) {
          Element kindElement = (Element) kindKnoten;
          NamedNodeMap attribute = kindElement.getAttributes();
          String[] stringArray = new String[attribute.getLength()];
          for (int j = 0; j < attribute.getLength(); j++) {
            stringArray[j] = attribute.item(j).getNodeValue().toString();
          }
          messungsListe.add(new Messung(stringArray[0], stringArray[1]));
        }
      }

    } catch (SAXException | IOException | ParserConfigurationException e) {

    }

  }

  public void inXMLSchreiben() {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument();
      Element element = document.getDocumentElement();
      
      TransformerFactory transformerFactory=TransformerFactory.newInstance();
      Transformer transformer=transformerFactory.newTransformer();
      DOMSource source =new DOMSource(document);
      DOMImplementation domImpl = document.getImplementation();
      DocumentType docType = domImpl.createDocumentType("Sensor", "", "Sensor.dtd");
      document.appendChild(docType);
      
      Element rootElement = document.createElement("Sensor");
      document.appendChild(rootElement);
      
      Attr attId=document.createAttribute("id");
      attId.setValue(id);
      rootElement.setAttributeNode(attId);
      
      for(int i=0;i<messungsListe.size();i++) {
        Element messung=document.createElement("Messung");
        rootElement.appendChild(messung);
        
        Attr attWert=document.createAttribute("wert");
        attWert.setValue(messungsListe.get(i).getWertString());
        rootElement.setAttributeNode(attWert);
        
        Attr attTime=document.createAttribute("zeitstempel");
        attTime.setValue(messungsListe.get(i).getZeitStempel());
        rootElement.setAttributeNode(attTime);
      }
    } catch (ParserConfigurationException |
        TransformerConfigurationException e) {

    }
  }

  public static void main(String[] args) {
    Sensor sensor = new Sensor();
    sensor.ausXMLLesen("src/aufgabe1/Sensoren");
    sensor.inXMLSchreiben();
  }
}
