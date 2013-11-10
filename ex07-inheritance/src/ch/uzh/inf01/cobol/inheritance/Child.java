package ch.uzh.inf01.cobol.inheritance;

/**
 * Child is a subclass of Person.
 */
public class Child
        extends Person {

    private int mNumberOfTeeth;

    public Child(String pName, int pAge, boolean pMale, int pNumberOfTeeth) {
        super(pName, pAge, pMale);
        setNumberOfTeeth(pNumberOfTeeth);
    }

    /**
     * Prints a description on the console.
     * Overrides Person's printDescription.
     */
    @Override
    public void printDescription() {
        super.printDescription();
        String teeth = mNumberOfTeeth == 1 ? " Zahn." : " Zaehnen.";
        System.out.println(" und bin ein Kind mit " + mNumberOfTeeth + teeth);
    }

    public void play() {
        System.out.println("Ich spiele mit meinen Baukloetzchen!");
    }

    public int getNumberOfTeeth() {
        return mNumberOfTeeth;
    }

    public void setNumberOfTeeth(int pNumberOfTeeth) {
        mNumberOfTeeth = pNumberOfTeeth;
    }
}
