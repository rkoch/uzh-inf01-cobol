package ch.uzh.inf01.cobol.geometric3d;


public class Cuboid
        implements I3DObject {

    private int mWidth;
    private int mHeight;
    private int mLength;


    public Cuboid(int pWidth, int pHeight, int pLength)
            throws Exception {
        setWidth(pWidth);
        setHeight(pHeight);
        setLength(pLength);
    }


    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int pWidth)
            throws Exception {
        checkNegativeDimension(pWidth);
        mWidth = pWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int pHeight)
            throws Exception {
        checkNegativeDimension(pHeight);
        mHeight = pHeight;
    }

    public int getLength() {
        return mLength;
    }

    public void setLength(int pLength)
            throws Exception {
        checkNegativeDimension(pLength);
        mLength = pLength;
    }


    // implementation of I3DObject

    @Override
    public double getVolume() {
        int volume = mWidth * mHeight * mLength;
        return volume;
    }


    // private methods

    private void checkNegativeDimension(double pLength)
            throws Exception {
        if (pLength <= 0) {
            throw new Exception("Dimension must be > 0");
        }
    }

}
