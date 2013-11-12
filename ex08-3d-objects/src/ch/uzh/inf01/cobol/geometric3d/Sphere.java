package ch.uzh.inf01.cobol.geometric3d;


public class Sphere
        implements I3DObject {

    private double mRadius;


    public Sphere(double pRadius)
            throws Exception {
        setRadius(pRadius);
    }


    public double getRadius() {
        return mRadius;
    }

    public void setRadius(double pRadius)
            throws Exception {
        checkNegativeDimension(pRadius);
        mRadius = pRadius;
    }


    // implementation of I3DObject

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(getRadius(), 3);
    }

    // private methods

    private void checkNegativeDimension(double pDim)
            throws Exception {
        if (pDim <= 0) {
            throw new Exception("Dimension must be > 0");
        }
    }

}
