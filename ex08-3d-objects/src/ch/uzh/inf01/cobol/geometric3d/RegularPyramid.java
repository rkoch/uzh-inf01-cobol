package ch.uzh.inf01.cobol.geometric3d;


public class RegularPyramid
        implements I3DObject {

    private double mHeight;
    private int    mVerticesAtBaseCount;
    private double mEdgeLengthAtBase;

    public RegularPyramid(double mHeight, int mVerticesAtBaseCount, double mEdgeLengthAtBase)
            throws Exception {
        setHeight(mHeight);
        setVerticesAtBaseCount(mVerticesAtBaseCount);
        setEdgeLengthAtBase(mEdgeLengthAtBase);
    }


    public double getHeight() {
        return mHeight;
    }

    public void setHeight(double height)
            throws Exception {
        checkNegativeDimension(height);
        mHeight = height;
    }

    public int getVerticesAtBaseCount() {
        return mVerticesAtBaseCount;
    }

    public void setVerticesAtBaseCount(int pCount)
            throws Exception {
        if (pCount >= 3) {
            mVerticesAtBaseCount = pCount;
        } else {
            throw new Exception("Vertices at base count must be >= 3");
        }
    }

    public double getEdgeLengthAtBase() {
        return mEdgeLengthAtBase;
    }

    public void setEdgeLengthAtBase(double pLength)
            throws Exception {
        checkNegativeDimension(pLength);
        mEdgeLengthAtBase = pLength;
    }


    // implementation of I3DObject

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * getBaseArea() * getHeight();
    }


    // private methods

    private double degreeToRad(double pDegree) {
        return ((Math.PI / 180) * pDegree);
    }

    private double getBaseArea() {
        double area = (mVerticesAtBaseCount * Math.pow(mEdgeLengthAtBase, 2)) / (4.0 * Math.tan(degreeToRad(180.0 / mVerticesAtBaseCount)));
        return area;
    }

    private void checkNegativeDimension(double pDim)
            throws Exception {
        if (pDim <= 0) {
            throw new Exception("Dimension must be > 0");
        }
    }

}
