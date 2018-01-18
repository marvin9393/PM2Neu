/**
*
*
*
*/
package aufgabe1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class Verarbeitung {
  
  public static void xmlEinlesen(String verzeichniss) {
    File file =new File(verzeichniss);
    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
    try {
      DocumentBuilder builder=factory.newDocumentBuilder();
      try {
        Document document=builder.parse(file);
        Element element = document.getDocumentElement();
        Sensor sensor =new Sensor(element.getAttributes().item(0).toString());
        for(int i=0;i<element.getChildNodes().getLength();i++) {
          Node kindKnoten = element.getChildNodes().item(i);
          if(kindKnoten instanceof Element) {
            Element kindElement = (Element)kindKnoten;
            NamedNodeMap attribute = kindElement.getAttributes();
            String[] stringarray=new String[attribute.getLength()];
            for(int j=0;j<attribute.getLength();j++) {
              stringarray[j]=attribute.item(j).getNodeValue();
            }
            sensor.messungHinzufuegen(new Messung(stringarray[0], stringarray[1]));
          }
        }
      } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (ParserConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    xmlEinlesen("src"+File.separator+"aufgabe1"+File.separator+"Sensoren.xml");
  }
}
