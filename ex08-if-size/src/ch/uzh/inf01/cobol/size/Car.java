package ch.uzh.inf01.cobol.size;


public class Car
        implements ISize {

    private String mModel;
    private String mManufacturer;
    private double mWeight;
    private double mLength;      // as there are no setter methods for these (only throught constructor)
    private double mWidth;       // it is also possible to declare these variables final
    private double mHeight;


    public Car(double pLength, double pWidth, double pHeight) {
        mLength = pLength;
        mWidth = pWidth;
        mHeight = pHeight;
    }


    public String getModel() {
        return mModel;
    }

    public void setModel(String pModel) {
        mModel = pModel;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public void setManufacturer(String pManufacturer) {
        mManufacturer = pManufacturer;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double pWeight) {
        mWeight = pWeight;
    }


    // implementation of ISize

    @Override
    public double getLength() {
        return mLength;
    }

    @Override
    public double getWidth() {
        return mWidth;
    }

    @Override
    public double getHeight() {
        return mHeight;
    }

}
