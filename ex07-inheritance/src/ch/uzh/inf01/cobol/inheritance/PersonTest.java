package ch.uzh.inf01.cobol.inheritance;

/**
 * Test driver for class Person and it's subclasses.
 */
public class PersonTest {

    public static void main(String[] args) {
        Person[] list = new Person[5];
        list[0] = new Child("Alice", 4, false, 1);
        list[1] = new Juvenile("Anita", 17, false);
        list[2] = new Adult("Michael", 24, true);
        list[3] = new Pensioner("Hans", 76, true);
        list[4] = new Adult("Peter", 35, true);

        for (Person person : list) {
            person.printDescription();
        }

        // person[0].play(); //-->Fehlermeldung: The method play() is undefined for
        // the type Person.
        // -->Grund: play() ist kein Verhalten, das Person-Objekte besitzen.
        // -->Loesung: Casten
        if (list[0] instanceof Child) {
            Child child = (Child) list[0];
            child.play(); // Oder Kurzform: ((Child) list[0]).play();
        }
    }

}
