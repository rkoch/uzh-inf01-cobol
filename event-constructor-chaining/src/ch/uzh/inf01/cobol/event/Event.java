/*
 * The MIT License (MIT)
 * Copyright © 2013 Remo Koch, http://rko.mit-license.org/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the “Software”), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package ch.uzh.inf01.cobol.event;

import java.util.Date;


/**
 * @author rko
 */
public class Event {

    private final long mEventId;
    private Date       mDate;
    private String     mTitle;
    private int        mNumberOfParticipants;


    /**
     * Default constructor
     */
    public Event() {
        mEventId = createUniqueID();
    }

    public Event(Date pDate, String pTitle, int pNumberOfParticipants) {
        this();
        mDate = pDate;
        mTitle = pTitle;
        mNumberOfParticipants = pNumberOfParticipants;
    }

    public Event(String pDateAsString, String pTitle, int pNumberOfParticipants) {
        this(dateFromString(pDateAsString), pTitle, pNumberOfParticipants);
    }

    /**
     * Copy constructor
     */
    public Event(Event pEventToCopy) {
        this(pEventToCopy.mDate, pEventToCopy.mTitle, pEventToCopy.mNumberOfParticipants);
    }


    public Date getDate() {
        return mDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getNumberOfParticipants() {
        return mNumberOfParticipants;
    }

    // static methods können aufgerufen werden, auch ohne dass die Klasse
    // instanziert wird. Mehr dazu später in der Vorlesung.
    private static Date dateFromString(String dateString) {
        int year = Integer.parseInt(dateString.substring(0, 4)) - 1900;
        int month = Integer.parseInt(dateString.substring(4, 6));
        int day = Integer.parseInt(dateString.substring(6, 8));
        return new Date(year, month, day);
    }

    private static long createUniqueID() {
        return System.nanoTime();
    }


    @Override
    public String toString() {
        return (mEventId + ": " +
                mTitle + ", " +
                mDate + ", " +
                mNumberOfParticipants + " participants");
    }

}
