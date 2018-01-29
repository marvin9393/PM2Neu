/**
*
*
*
*/
package folie3Lambdas;

/**
* Praktikum TIPM2, WS16-17x
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class LambdaTest{
  
  public static void main(String[] args) {
    LambdaTest la = 
    
    Operatoren addieren =(int x, int y) -> { return x+y;};
    Operatoren minus =(int x, int y) -> {return x-y;};
    
    System.out.println(addieren.zweiZahlen(5, 6));
    System.out.println(minus.zweiZahlen(10, 5));
  }


}
