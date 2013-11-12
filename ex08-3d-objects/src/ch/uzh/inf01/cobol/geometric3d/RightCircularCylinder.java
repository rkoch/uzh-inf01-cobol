package ch.uzh.inf01.cobol.geometric3d;


public class RightCircularCylinder
        implements I3DObject {

    private double mRadius;
    private double mHeight;


    public RightCircularCylinder(double pRadius, double mHeight)
            throws Exception {
        setRadius(pRadius);
        setHeight(mHeight);
    }


    public double getRadius() {
        return mRadius;
    }

    public void setRadius(double pRadius)
            throws Exception {
        checkNegativeDimension(pRadius);
        mRadius = pRadius;
    }

    public double getHeight() {
        return mHeight;
    }

    public void setHeight(double pHeight)
            throws Exception {
        checkNegativeDimension(pHeight);
        mHeight = pHeight;
    }


    // implementation of I3DObject

    @Override
    public double getVolume() {
        return getCircleArea() * getHeight();
    }


    // private methods

    private double getCircleArea() {
        return Math.PI * Math.pow(mRadius, 2);
    }

    private void checkNegativeDimension(double pDim)
            throws Exception {
        if (pDim <= 0) {
            throw new Exception("Dimension must be > 0");
        }
    }

}
