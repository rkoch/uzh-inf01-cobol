package ch.uzh.inf01.cobol.addressbook;

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
        // TODO Start Graphical User Interface here.
        System.out.println("GUI not yet implemented.");
    }

    private static void printUsage() {
        System.out.println("Usage: java ApplicationMain <options>\nOptions:\n\t--cli\truns the command line interface\n\t--gui\truns the graphical user interface (default)");
    }

}
