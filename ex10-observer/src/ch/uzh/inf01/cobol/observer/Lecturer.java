package ch.uzh.inf01.cobol.observer;

import java.util.List;
import java.util.Vector;


/**
 * Manages arbitrary amount of <ILectureListener> objects which get informed if any news is available (they observe this
 * instance). Interested <ILectureListeners> can register themselves to this object. The objects participate a loosely
 * coupled 1:n relationship.
 */
public class Lecturer {

    private final String                 mName;
    private final List<ILectureListener> mListeners; // Referencing only the raw type

    public Lecturer(String pName) {
        mName = pName;
        mListeners = new Vector<>(); // Since Java 7 we don't need to specify the generic type (insiden the diamonds) while instantiating anymore
    }


    /**
     * Adds given listener to the list of observer which get informed for any news available.
     *
     * @param pListener Observer to add
     */
    public void registerStudent(ILectureListener pListener) {
        mListeners.add(pListener);
    }

    /**
     * Removes given listener from observer list.
     *
     * @param pListener Observer to remove (won't be informed any more)
     */
    public void unregisterStudent(ILectureListener pListener) {
        mListeners.remove(pListener);
    }

    /**
     * Informs all registered observers.
     *
     * @param pInformations News to distribute to all observers
     */
    public void distributeInformation(String pInformations) {
        for (ILectureListener listener : mListeners) {
            listener.receiveInformation(mName, pInformations);
        }
    }
}
