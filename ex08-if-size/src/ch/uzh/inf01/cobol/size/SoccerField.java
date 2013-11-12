package ch.uzh.inf01.cobol.size;


public class SoccerField
        implements ISize {

    private String       mLocation;
    private String       mHomeTeam;

    private double       mLength;
    private double       mWidth;
    private final double mHeight;  // As there is no height on the SoccerField this variable is final and initially set to 0


    public SoccerField(double pLength, double pWidth) {
        mLength = pLength;
        mWidth = pWidth;
        mHeight = 0;
    }


    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String pLocation) {
        mLocation = pLocation;
    }

    public String getHomeTeam() {
        return mHomeTeam;
    }

    public void setHomeTeam(String pHomeTeam) {
        mHomeTeam = pHomeTeam;
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
