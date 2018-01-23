/**
*
*
*
*/
package aufgabe1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class Messung {
  
  private double wert;
  
  private LocalDateTime zeitStempel;
  
  public Messung(double wert) {
    this.wert=wert;
    zeitStempel=LocalDateTime.now();
  }
  
  public Messung(String wert, String zeitStempel) {
    this.wert=Double.parseDouble(wert.replace(',', '.'));
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern();
    this.zeitStempel=LocalDateTime.parse(zeitStempel,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }
  
  public String getWertString() {
    String stringwert=Double.toString(wert);
    stringwert.replace('.',',');
    return stringwert; 
  }
  
  public String getZeitStempel() {
    String zeitStempel=this.zeitStempel.toString();
    return zeitStempel;
  }
}
