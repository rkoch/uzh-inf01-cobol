package ch.uzh.inf01.cobol.inheritance;

/**
 * Represents a person.
 */
public abstract class Person {

    private String  mName;
    private boolean mMale;
    private int     mAge;

    public Person(String pName, int pAge, boolean pMale) {
        // Call internal variables directly!
        setName(pName);
        setAge(pAge);
        setMale(pMale);
    }

    public int getAge() {
        return mAge;
    }

    public boolean isMale() {
        return mMale;
    }

    public String getName() {
        return mName;
    }

    public void setName(String pName) {
        mName = pName;
    }

    public void setMale(boolean pMale) {
        mMale = pMale;
    }

    public void setAge(int pAge) {
        mAge = pAge;
    }

    /**
     * Prints a description of this object on the console.
     */
    public void printDescription() {
        String sex = mMale ? "maennlich" : "weiblich";
        System.out.print("Ich heisse " + getName() + ", bin " + sex + ", " + getAge() + " Jahre alt");
    }

}
