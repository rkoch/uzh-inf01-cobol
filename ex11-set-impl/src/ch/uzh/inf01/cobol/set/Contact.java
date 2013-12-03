package ch.uzh.inf01.cobol.set;


public class Contact {

    private String mName;
    private String mSurname;


    public Contact(String pName, String pSurname) {
        mName = pName;
        mSurname = pSurname;
    }

    /**
     * @return the name
     */
    public String getName() {
        return mName;
    }

    /**
     * @param pName the name to set
     */
    public void setName(String pName) {
        mName = pName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return mSurname;
    }

    /**
     * @param pSurname the surname to set
     */
    public void setSurname(String pSurname) {
        mSurname = pSurname;
    }

    @Override
    public boolean equals(Object pObj) {
        if (pObj == this) {
            return true;
        }

        if (pObj instanceof Contact) {
            Contact other = (Contact) pObj;
            if (mName.equals(other.mName) && mSurname.equals(other.mSurname)) {
                return true;
            }
        }

        return false;
    }

}
