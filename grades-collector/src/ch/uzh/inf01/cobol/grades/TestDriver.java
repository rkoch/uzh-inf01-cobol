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


/**
 * @author rko
 */
public class TestDriver {

    public static void main(String[] pArgs) {
        // Instantiate our app
        Grades app = new Grades();

        // Test default max grade
        if (app.getMaxGrade() != 6) {
            System.err.println("Default max grade should be 6 but was " + app.getMaxGrade());
        }

        // Test printing the collected grades
        app.printGrades();

        // Collect grades (pay attention to title lines - no subject given yet)
        // Try to input negative values, zero, or values greater than 6
        app.collectGrades();

        // Set subject
        app.setSubject("Informatics");
        if (!"Informatics".equals(app.getSubject())) {
            System.err.println("Subject should be Informatics but was " + app.getSubject());
        }

        // Print grades (pay attention to title lines - subject is now given)
        app.printGrades();
    }

}
