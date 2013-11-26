package ch.uzh.inf01.cobol.observer;

/**
 * A class can implement the this interface when it wants to be informed of changes in <Lecturer> objects.
 */
public interface ILectureListener {

    /**
     * This method is called whenever the observed object has news to distribute.
     *
     * @param pName Name of the <Lecturer> distributing news
     * @param pInformations News
     */
    void receiveInformation(String pName, String pInformations);

}
