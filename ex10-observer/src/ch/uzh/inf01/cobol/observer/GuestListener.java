package ch.uzh.inf01.cobol.observer;


/**
 * Represents a guest listener who can participate in a lecture.
 */
public class GuestListener
        implements ILectureListener {

    private String mName;

    public GuestListener(String pName) {
        mName = pName;
    }


    @Override
    public void receiveInformation(String pLecturerName, String pInformations) {
        System.out.println("Gasthoerer " + mName + "Dozent " + pLecturerName + " hat mir mitgeteilt, dass "
                + pInformations);
    }

}
