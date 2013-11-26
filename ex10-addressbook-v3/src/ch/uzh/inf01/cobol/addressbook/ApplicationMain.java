package ch.uzh.inf01.cobol.addressbook;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ch.uzh.inf01.cobol.addressbook.ui.AddressBookFrame;

public class ApplicationMain {

    public static void main(String[] pArgs) {

        // checking whether any arguments have been passed (from command line)
        if (pArgs.length > 0) {
            if (pArgs[0].equals("--cli")) {
                runCLI();
            } else {
                printUsage();
            }
        } else {
            runGUI();
        }
    }

    private static void runCLI() {
        // creating an instance of the command line interface and pass a new address book object
        CommandLineInterface cli = new CommandLineInterface(new AddressBook(10));
        // run the interface
        cli.run();
    }

    private static void runGUI() {
        /*
         * From Java-API: http://download.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
         * and following
         *
         * Swing event handling code runs on a special thread known as the event dispatch thread.
         * Most code that invokes Swing methods also runs on this thread.
         * This is necessary because most Swing object methods are not "thread safe":
         * invoking them from multiple threads risks thread interference or memory consistency errors
         */
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new AddressBookFrame(new AddressBook(10));
                frame.setVisible(true);
            }

        });
    }

    private static void printUsage() {
        System.out.println("Usage: java ApplicationMain <options>\nOptions:\n\t--cli\truns the command line interface\n\t--gui\truns the graphical user interface (default)");
    }

}
