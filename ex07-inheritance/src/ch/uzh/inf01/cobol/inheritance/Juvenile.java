package ch.uzh.inf01.cobol.inheritance;

/**
 * Juvenile is a subclass of Person.
 */
public class Juvenile
        extends Person {

    public Juvenile(String name, int age, boolean male) {
        super(name, age, male);
    }

    /**
     * Prints a description on the console.
     * Overrides Person's printDescription.
     */
    @Override
    public void printDescription() {
        super.printDescription();
        String type = isMale() ? "ein Jugendlicher." : "eine Jugendliche.";
        System.out.println(" und bin " + type);
    }
}
