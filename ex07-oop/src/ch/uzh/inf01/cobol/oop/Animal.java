package ch.uzh.inf01.cobol.oop;

public abstract class Animal
        extends Creature {

    private String mCoatColor;
    private Human  mOwner;

    public void setCoatColor(String pCoatColor) {
        mCoatColor = pCoatColor;
    }

    public String getCoatColor() {
        return mCoatColor;
    }

    public void setOwner(Human pOwner) {
        mOwner = pOwner;
    }

    public Human getOwner() {
        return mOwner;
    }

    public abstract void giveSound();

}
