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
public class Sensor {
  
  /**
   * Objektvariable die eine ID für den Sennsor hat
   */
  private String id;
  
  /**
   * Sensor der alle Messungen speichert
   */
  private List<Messung> messungsListe;
  
  public Sensor(String id) {
    this.id=id;
    messungsListe=new ArrayList();
  }
  
  public void messungHinzufuegen(Messung messung) {
    messungsListe.add(messung);
  }
}
