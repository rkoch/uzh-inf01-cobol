package ch.uzh.inf01.cobol.inheritance;

/**
 * Pensioner is a subclass of Person.
 */
public class Pensioner
        extends Person {

    public Pensioner(String pName, int pAge, boolean pMale) {
        super(pName, pAge, pMale);
    }

    /**
     * Prints a description on the console.
     * Overrides Person's printDescription.
     */
    @Override
    public void printDescription() {
        super.printDescription();
        String type = isMale() ? "ein Pensionaer." : "eine Pensionaerin.";
        System.out.println(" und bin " + type);
    }

    /**
     * Sets the Age.
     * Overrides Person's setAge(int)-method.
     *
     * @param pAge the age to set. Must be at least 61.
     */
    @Override
    public void setAge(int pAge) {
        if (pAge < 61) {
            System.out.println("The age must be > 60 to be pensionar.");
        } else {
            super.setAge(pAge);
            System.out.println("The age has been correctly set.");
        }
    }
}
