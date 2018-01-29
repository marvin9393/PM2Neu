/**
*
*
*
*/
package folie3Lambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class Person {
    private int alter;
    private String name;
    private LocalDate geburtstag;
    public Person(String name, int alter) {
    this.name = name;
    this.alter = alter; }
    public Person(String name, LocalDate geburtstag) { this.name = name;
    this.geburtstag = geburtstag;
    }
    @Override
    public String toString() {
    return String.format("%s %s (%d)", name, geburtstag,
    alter); }
    public boolean istErwachsen() { return alter >= 18;
    }
    public String getName() {
    return name; }
    private int getAlter() { return alter;
    }
    public LocalDate getGeburtstag() {
    return geburtstag; }
    
    
    public static void main(String [] args) {
      List<Person> personen = new ArrayList<>(); 
      personen.add(new Person("Micha", 43)); personen.add(new Person("Barbara", 40)); personen.add(new Person("Yannis", 5)); 
      Predicate<Person> istErwachsen = person ->
      person.istErwachsen();
      personen.stream().filter(istErwachsen)
      .forEach(System.out::println);
    }
    
}
