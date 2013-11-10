package ch.uzh.inf01.cobol.inheritance;

/**
 * Adult is a subclass of a Person.
 */
public class Adult
        extends Person {

    public Adult(String pName, int pAge, boolean pMale) {
        super(pName, pAge, pMale);
    }

    /**
     * Prints a description on the console.
     * Overrides Person's printDescription.
     */
    @Override
    public void printDescription() {
        super.printDescription();
        String type = isMale() ? "ein Erwachsener." : "eine Erwachsene.";
        System.out.println(" und bin " + type);
    }
}
