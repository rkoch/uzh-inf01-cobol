package ch.uzh.inf01.cobol.oop;

public class Human
        extends Creature {

    private Human mNephew; // = null not needed

    public void read() {
        System.out.println("I can read! Lorem ipsum dolor sit amet.");
    }

    public void write(String text) {
        System.out.print("I can write: ");
        System.out.println(text);
    }

    public void setNephew(Human nephew) {
        this.mNephew = nephew;
    }

    public Human getNephew() {
        return mNephew;
    }

    public boolean hasNephew() {
        return (mNephew != null);
    }
}
