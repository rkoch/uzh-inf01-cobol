package ch.uzh.inf01.cobol.addressbook.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.uzh.inf01.cobol.addressbook.AddressBook;
import ch.uzh.inf01.cobol.addressbook.Contact;


/**
 * Class to display and allow interaction with AddressBook.
 */
public class AddressBookFrame
        extends JFrame
        implements ActionListener {

    private static final long   serialVersionUID     = 1L;
    private static final String DAY_DEFAULT_STRING   = "Day";
    private static final String MONTH_DEFAULT_STRING = "Month";
    private static final String YEAR_DEFAULT_STRING  = "Year";
    private static final int    X_POS                = 200, Y_POS = 150;
    private static final int    WIDTH                = 400, HEIGHT = 500;

    private JTextField          fnTextField;
    private JTextField          lnTextField;
    private JTextField          emailTextField;
    private JTextField          streetTextField;
    private JTextField          zipTextField;
    private JTextField          cityTextField;
    private JTextField          birthdayDayTextField;
    private JTextField          birthdayMonthTextField;
    private JTextField          birthdayYearTextField;

    private JTextArea           output;

    private AddressBook         mBook;

    /**
     * Create Frame with information of given address book.
     *
     * @param pBook
     *            Address book to be used.
     */
    public AddressBookFrame(AddressBook pBook) {
        super("Address Book v.03");

        setBounds(X_POS, Y_POS, WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mBook = pBook;

        createComponents();
    }

    /**
     * Catching ActionEvents, such as button clicks etc.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String buttonLabel = e.getActionCommand();

        if (buttonLabel.equals("Add")) {
            addContact();
        } else if (buttonLabel.equals("List all")) {
            listAllContacts();
        } else if (buttonLabel.equals("Search ...")) {
            searchForContact();
        } else if (buttonLabel.equals("Delete ...")) {
            deleteContact();
        }

    }

    private void deleteContact() {
        // Display pop-up for selection of contact to be deleted.
        String toBeDeleted = JOptionPane.showInputDialog(this, "Which contact dou you want to delete?", "Replace with ID of contact.");
        if (Pattern.matches("[0-9]", toBeDeleted)) {
            int id = Integer.parseInt(toBeDeleted);
            Contact candidate = mBook.findById(id);
            if (candidate != null) {
                mBook.deleteContact(candidate);
                output.append("Contact deleted.\n");
            } else {
                output.append("No such contact.\n");
            }
        } else {
            output.append("Incorrect ID format.\n");
        }
    }

    private void searchForContact() {
        String name = JOptionPane.showInputDialog(this, "Whose contact information are you looking for?", "Enter last name");
        Contact c = mBook.findByLastName(name);
        if (c != null) {
            output.append("Contact found:\n");
            output.append(c.toString());
            output.append("\n----------\n");
            output.setForeground(Color.BLACK);
        } else {
            output.append("No contact found!\n");
        }
    }

    private void listAllContacts() {
        output.append("All contacts:\n");
        output.setForeground(Color.BLACK);

        for (Contact c : mBook.getContacts()) {
            output.append(c.toString());
            output.append("\n----------\n");
        }
    }

    private void addContact() {

        // read all Strings from JTextFields
        String fn = fnTextField.getText();
        String ln = lnTextField.getText();
        String email = emailTextField.getText();
        String street = streetTextField.getText();
        String zip = zipTextField.getText();
        String city = cityTextField.getText();
        String dayString = birthdayDayTextField.getText();
        String monthString = birthdayMonthTextField.getText();
        String yearString = birthdayYearTextField.getText();

        Contact c;

        c = new Contact(fn, ln);
        c.setEmailAddress(email);
        c.setStreetAddress(street, zip, city);

        if (!isDefaultOrEmptyBirthdayFields(dayString, monthString, yearString)) {
            int day = Integer.parseInt(dayString);
            int month = Integer.parseInt(monthString);
            int year = Integer.parseInt(yearString);
            c.setBirthday(day, month, year);
        }

        mBook.addContact(c);
        resetTextFields();
        output.append("Contact added.\n");
        output.setForeground(Color.BLACK);

    }

    private boolean isDefaultOrEmptyBirthdayFields(String dayString, String monthString, String yearString) {
        if (dayString.equals(DAY_DEFAULT_STRING) || dayString.equals("")) {
            if (monthString.equals(MONTH_DEFAULT_STRING) || monthString.equals("")) {
                if (yearString.equals(YEAR_DEFAULT_STRING) || yearString.equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void createComponents() {
        // Der ContentPane ist der Teil des Fensters, wo wir
        // eigene Buttons, Textfelder, etc. hinzuf�gen k�nnen.
        Container pane = getContentPane();

        Container inputPanel = createInputPanel();
        JScrollPane scrollPane = createOutputArea();
        Container operationsPanel = createOperationsPanel();

        pane.add(inputPanel, BorderLayout.NORTH);
        pane.add(scrollPane, BorderLayout.CENTER);
        pane.add(operationsPanel, BorderLayout.SOUTH);
    }

    private Container createInputPanel() {

        // Layout manager sorgen daf�r, dass der Inhalt des
        // Fensters automatisch an dessen Gr�sse angepasst wird.
        Container inputPanel = new JPanel();
        GridLayout layout = new GridLayout(0, 2);
        inputPanel.setLayout(layout);

        // adding labels and text areas
        addLabelTo(inputPanel, "First Name:");
        fnTextField = addTextFieldTo(inputPanel);

        addLabelTo(inputPanel, "Last Name:");
        lnTextField = addTextFieldTo(inputPanel);

        addLabelTo(inputPanel, "Email:");
        emailTextField = addTextFieldTo(inputPanel);

        addLabelTo(inputPanel, "Street:");
        streetTextField = addTextFieldTo(inputPanel);

        addLabelTo(inputPanel, "Zip, City:");
        JPanel zipCityPanel = new JPanel();
        layout = new GridLayout(1, 2);
        zipCityPanel.setLayout(layout);
        zipTextField = addTextFieldTo(zipCityPanel);
        cityTextField = addTextFieldTo(zipCityPanel);
        inputPanel.add(zipCityPanel);

        addLabelTo(inputPanel, "Birthday:");
        JPanel birthdayPanel = new JPanel();
        layout = new GridLayout(1, 3);
        birthdayPanel.setLayout(layout);
        birthdayDayTextField = addTextFieldTo(birthdayPanel);
        birthdayMonthTextField = addTextFieldTo(birthdayPanel);
        birthdayYearTextField = addTextFieldTo(birthdayPanel);
        inputPanel.add(birthdayPanel);

        resetTextFields();

        // adding buttons
        JButton listButton = new JButton("List all");
        listButton.addActionListener(this);
        inputPanel.add(listButton);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        return inputPanel;
    }

    private JScrollPane createOutputArea() {

        // creating text area to display results/interaction with user
        output = new JTextArea();
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);

        // making text area scrollable
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }

    private Container createOperationsPanel() {

        Container operationsPanel = new JPanel();
        GridLayout layout = new GridLayout(0, 2);
        operationsPanel.setLayout(layout);

        JButton searchButton = new JButton("Search ...");
        searchButton.addActionListener(this);
        operationsPanel.add(searchButton);

        return operationsPanel;
    }

    private void addLabelTo(Container container, String text) {
        JLabel label = new JLabel(text);
        container.add(label);
    }

    private JTextField addTextFieldTo(Container container) {
        JTextField tf = new JTextField();
        container.add(tf);

        return tf;
    }

    private void resetTextFields() {
        fnTextField.setText("");
        lnTextField.setText("");
        emailTextField.setText("");
        streetTextField.setText("");
        zipTextField.setText("");
        cityTextField.setText("");
        birthdayDayTextField.setText(DAY_DEFAULT_STRING);
        birthdayMonthTextField.setText(MONTH_DEFAULT_STRING);
        birthdayYearTextField.setText(YEAR_DEFAULT_STRING);
    }

}
