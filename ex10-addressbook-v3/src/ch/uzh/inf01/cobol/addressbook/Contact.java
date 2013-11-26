package ch.uzh.inf01.cobol.addressbook;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Contact {

    private long   mId;

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mStreet;
    private String mZip;
    private String mCity;

    private Date   mBirthday;


    private Contact() {
        mId = System.nanoTime();
    }

    public Contact(String pFirstName, String pLastName) {
        this();
        mFirstName = pFirstName;
        mLastName = pLastName;
    }


    public long getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    public void setEmailAddress(String pEmail) {
        mEmail = pEmail;
    }

    public void setStreetAddress(String pStreet, String pZip, String pCity) {
        mStreet = pStreet;
        mZip = pZip;
        mCity = pCity;
    }

    public Date getBirthday() {
        return mBirthday;
    }

    public void setBirthday(int pDay, int pMonth, int pYear) {
        // Calendar.getInstance() returns an instance of a subclass of Calendar,
        // based on the locally used calendar type
        Calendar calendar = Calendar.getInstance();
        calendar.set(pYear, pMonth - 1, pDay);
        // converting date to Unix time representation
        mBirthday = calendar.getTime();
    }


    @Override
    public String toString() {
        // StringBuilder allows appending more Strings
        StringBuilder builder = new StringBuilder();

        builder.append(mId).append(".\t")
                .append(mFirstName).append(' ').append(mLastName);

        if (mBirthday != null) {
            // With SimpleDateFormat, it is possible to
            // format Date into desired String representation
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            builder.append('\n').append('\t')
                    .append(df.format(mBirthday));
        }

        if (mEmail != null) {
            builder.append('\n').append('\t')
                    .append(mEmail);
        }

        if (mStreet != null && mZip != null && mCity != null) {
            builder.append('\n').append('\t')
                    .append(mStreet)
                    .append('\n').append('\t')
                    .append(mZip).append(' ').append(mCity);
        }

        return builder.toString();
    }

}
