package ch.uzh.inf01.cobol.observer;

/**
 * Represents a student who can participate in a lecture.
 */
public class Student
        implements ILectureListener {

    private String mName;

    public Student(String pName) {
        mName = pName;
    }


    @Override
    public void receiveInformation(String pLecturerName, String pInformations) {
        System.out.println("Student " + mName + ": Dozent " + pLecturerName + " hat mir mitgeteilt, dass " + pInformations);
    }

}
