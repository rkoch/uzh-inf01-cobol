package ch.uzh.inf01.cobol.sorting;

class Crumb {

    private float mWeight;
    private float mCalories;


    public Crumb(float pWeight, float pCalories) {
        mWeight = pWeight;
        mCalories = pCalories;
    }


    public float getWeight() {
        return mWeight;
    }

    public float getCalories() {
        return mCalories;
    }

    public float getRatio() {
        return mCalories / mWeight;
    }

    @Override
    public String toString() {
        return Float.toString(getRatio());
    }
}
