/**
*
*
*
*/
package aufgabe1;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt xx, Aufgabe xx Verwendete Quellen:
 */
public class ArrayListe<T> {

  private int anzahlElemente;

  private Object[] elemente;

  public ArrayListe() {
    elemente = new Object[1];
  }

  public void hinzufuegen(T object) {
    if (anzahlElemente == elemente.length) {
      Object[] elementeNeu = new Object[anzahlElemente * 2];
      for (int i = 0; i < anzahlElemente; i++) {
        elementeNeu[i] = elemente[i];
      }
      elemente = elementeNeu;
    }
    elemente[anzahlElemente] = object;
    anzahlElemente++;
  }

  public T getAnzahlElemente(int index) {
    return (T)elemente[index];
  }
  
  public void entfernen(T object) {
    for (int i=0;i<elemente.length;i++) {
      if(elemente[i].equals(object)) {
        elemente[i]=null;
        anzahlElemente--;
      }
      if(elemente[i]==null&i<elemente.length-1) {
        elemente[i]=elemente[i+1];
        elemente[i+1]=null;
      }
    }
  }
  
  public void entferneElementAnIndex(int index) {
    elemente[index]=null;
  }
  
  public int getAnzahlElemente() {
    return anzahlElemente;
  }
  
  public Object[] getListe() {
    return elemente;
  }
  
  public String toString() {
    String result="";
    for(int i=0;i<elemente.length;i++) {
      result+="("+elemente[i].toString()+"),";
    }
    return result;
  }
  
  public T getKleinstesElement() {
    T result = null;
    if(AnwendungGenerics.istErsteElementZahl(this)) {
      for(int i=0;i<elemente.length;i++) {
        result=(T)elemente[i];
        if(elemente[i]!=null) {
          if(((Number)elemente[i]).doubleValue()<((Number)result).doubleValue()) {
            result=(T)elemente[i];
          }
        }
      }
    }
    return result;
    }
    
  
  
}
