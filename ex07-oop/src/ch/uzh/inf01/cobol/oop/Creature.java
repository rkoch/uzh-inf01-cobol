package ch.uzh.inf01.cobol.oop;

public class Creature {

    private String  mName;
    private boolean mMale;           // Is wird normalerweise nicht vorangestellt
    private int     mAge;
    private String  mFavoriteDish ; // = "" sollte im Constructor passieren


    public Creature() {
        mFavoriteDish  = "";
    }


    public void setName(String pName) {
        mName = pName;
    }

    public String getName() {
        return mName;
    }

    public void setMale(boolean pIsMale) {
        mMale = pIsMale;
    }

    public boolean isMale() {
        return mMale;
    }

    public void setAge(int pAge) {
        if (pAge >= 0) {
            mAge = pAge;
        } else {
            System.out.println("Age should be at least 0.");
        }
    }

    public int getAge() {
        return mAge;
    }

    public void setFavoriteDish(String pFavoriteDish) {
        mFavoriteDish = pFavoriteDish;
    }

    public String getFavoriteDish() {
        if (mFavoriteDish == null) {
            setFavoriteDish("");
        }
        return mFavoriteDish;
    }


    public void eat(String pMeal) {
        if (getFavoriteDish().equals(pMeal)) {
            System.out.println("Yippie! I eat " + pMeal + ". This is my favorite dish!");
        } else {
            System.out.println("I'm eating " + pMeal);
        }
    }

    @Override
    public String toString() {
        return "My name is " + getName() + " and I'm " + getAge() + " years old.";
    }

}
