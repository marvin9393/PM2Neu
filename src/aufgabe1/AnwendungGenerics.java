/**
*
*
*
*/
package aufgabe1;


/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class AnwendungGenerics {
  
  public static <T> boolean istErsteElementZahl(ArrayListe<T> liste) {
    if(liste.getListe()[0] instanceof Number) {
      System.out.println("True");
      return true;
    }
    System.out.println("false");
    return false;
  }
  
  public static void main(String[] args) {
    ArrayListe<Integer> arra = new ArrayListe<Integer>();
    int zahl=5;
    AnwendungGenerics a=new AnwendungGenerics();
    arra.hinzufuegen(zahl);
    AnwendungGenerics.istErsteElementZahl(arra);
    arra.hinzufuegen(4);
    System.out.println(arra.getKleinstesElement());
    
  }

}
