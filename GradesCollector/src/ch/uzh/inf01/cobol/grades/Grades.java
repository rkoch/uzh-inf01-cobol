/*
 * The MIT License (MIT)
 * Copyright © 2013 Remo Koch
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
package ch.uzh.inf01.cobol.grades;

import java.util.Scanner;



/**
 * @author rko
 */
public class Grades {

    private static final int DEFAULT_MAX_GRADE = 6;

    private String           mSubject;
    private int              mMaxGrade;
    private int[]            mCollectedGrades;


    /**
     * Default constructor
     */
    public Grades() {
        // Initialize max grade with default value as long as nothing else is given
        mMaxGrade = DEFAULT_MAX_GRADE;
    }


    // Getters and setters for fields (so called "members")

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String pSubject) {
        mSubject = pSubject;
    }


    public int getMaxGrade() {
        return mMaxGrade;
    }

    public void setMaxGrade(int pMaxGrade) {
        // Only set new max grade if new value is at least 2
        if (pMaxGrade >= 2) {
            mMaxGrade = pMaxGrade;
        }
    }


    // Class functionality

    public void collectGrades() {
        // Initialize the array - from this moment on, the max grade is fixed
        // until restarting this collectGrades() method
        final int currentMaxGrade = mMaxGrade; // Remember: final "freezes" the variable
        mCollectedGrades = new int[currentMaxGrade]; // Remember: Default value of each entry is 0

        // Print some nice message
        System.out.print("Please enter all grades that are to collect");
        if ((mSubject != null) && !mSubject.isEmpty()) {
            System.out.print(" for the subject " + mSubject);
        }
        System.out.println(":");

        // Collect grades from command line

        // Create the scanner for reading the command line input
        Scanner in = new Scanner(System.in);

        boolean leave = false;
        while (!leave) { // Enter an endless loop as long as leave was not requested
            try {
                int grade = in.nextInt(); // Read integer

                // Validate if the grade is in range
                if ((grade > 0) && (grade <= currentMaxGrade)) {
                    mCollectedGrades[grade - 1] += 1; // Increment value on correct location (Remember: grade - 1 is used because array indexing starts at 0)
                } else {
                    System.err.println("Grade " + grade + " was not in range of 1.." + currentMaxGrade + "!");
                }
            } catch (Exception pEx) {
                // We use a try/catch block to catch the error thrown when input is not an integer anymore
                // This means that we need to leave the whole thing now.
                leave = true;
                in.close(); // We need to close the scanner to free the resources
                System.out.println("Done collecting grades.");
            }
        }
    }

    public void printGrades() {
        // Check if the grades were already collected
        if (mCollectedGrades == null) {
            System.err.println("Please collect your grades before trying to print them.");
            return;
        }

        // Print some nice message (depending whether subject is defined or not)
        System.out.print("Collected grades");
        if ((mSubject != null) && !mSubject.isEmpty()) {
            System.out.print(" for the subject " + mSubject);
        }
        System.out.println(":");

        // At this point we assume that the grades have been collected and we iterate through the collection array
        for (int i = 0; i < mCollectedGrades.length; i++) {
            System.out.print("Grade " + (i + 1) + ": " + mCollectedGrades[i] + " student");
            if (mCollectedGrades[i] != 1) { // Add an 's' to the end of student if student count is not 1
                System.out.print("s");
            }
            System.out.println(); // Remember: For just entering a new line you can call println() without any argument
        }
    }

}
