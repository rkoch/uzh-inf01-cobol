package ch.uzh.inf01.cobol.addressbook;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Contact {

	private long mId;

	private String mFirstName;
	private String mLastName;
	private String mEmail;
	private String mStreet;
	private String mZip;
	private String mCity;

	private Date mBirthday;

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

	public void setLastName(String lastName) {
		this.mLastName = lastName;
	}

	public void setEmailAdress(String email) {
		this.mEmail = email;
	}

	public void setStreetAddress(String street, String zip, String city) {
		this.mStreet = street;
		this.mZip = zip;
		this.mCity = city;
	}

	public void setBirthday(int day, int month, int year) {
		// Calendar.getInstance() returns an instance of a subclass of Calendar,
		// based on the locally used calendar type
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		// converting date to Unix time representation
		mBirthday = calendar.getTime();
	}

	public Date getBirthday() {
		return mBirthday;
	}

	@Override
	public String toString() {
		// StringBuilder allows appending more Strings
		StringBuilder builder = new StringBuilder();

		builder.append(mId).append(".\t")
			   .append(mFirstName).append(' ').append(mLastName);

		if(mBirthday != null) {
			// With SimpleDateFormat, it is possible to
			// format Date into desired String representation
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			builder.append('\n').append('\t')
				   .append(df.format(mBirthday));
		}

		if(mEmail != null) {
			builder.append('\n').append('\t')
				   .append(mEmail);
		}

		if(mStreet != null && mZip != null && mCity != null) {
			builder.append('\n').append('\t')
				   .append(mStreet)
				   .append('\n').append('\t')
				   .append(mZip).append(' ').append(mCity);
		}


		return builder.toString();
	}
}
