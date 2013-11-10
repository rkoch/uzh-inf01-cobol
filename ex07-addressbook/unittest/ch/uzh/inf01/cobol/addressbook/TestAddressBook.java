package ch.uzh.inf01.cobol.addressbook;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Arrays;

import org.junit.Test;


/**
 * Add JUnit [4] library to Java Build Path.
 * Start with Run as - JUnit Test.
 */
public class TestAddressBook {

    @Test
    public void testInit() {
        AddressBook book = new AddressBook(1);
        assertThat(book.size(), is(0));
        assertThat(book.getContacts().length, is(0));
    }

    @Test
    public void testAddContact() {
        AddressBook book = new AddressBook(2);
        Contact contact1 = new Contact("Michael", "Wuersch");
        book.addContact(contact1);

        assertThat(book.size(), is(1));
        Contact[] contacts = book.getContacts();
        assertThat(contacts.length, is(1));
        assertThat(Arrays.asList(contacts), hasItem(contact1));

        Contact contact2 = book.addContact("Emanuel", "Giger");

        assertThat(book.size(), is(2));
        contacts = book.getContacts();
        assertThat(contacts.length, is(2));
        assertThat(Arrays.asList(contacts), hasItems(contact1, contact2));
    }

    @Test
    public void testDelete() {
        AddressBook book = new AddressBook(2);
        Contact contact1 = book.addContact("Michael", "Würsch");
        Contact contact2 = book.addContact("Emanuel", "Giger");

        book.deleteContact(contact1);
        assertThat(book.size(), is(1));
        Contact[] contacts = book.getContacts();
        assertThat(contacts.length, is(1));
        assertThat(Arrays.asList(contacts), hasItem(contact2));

        book.deleteContact(contact2);
        assertThat(book.size(), is(0));
        contacts = book.getContacts();
        assertThat(contacts.length, is(0));

        // deleting a contact twice (or one that does not exist) should have no effect
        book.deleteContact(contact2);
        assertThat(book.size(), is(0));
        contacts = book.getContacts();
        assertThat(contacts.length, is(0));

        // test if all occurrences of contact are deleted (especially when consecutive)
        AddressBook book2 = new AddressBook(3);
        book2.addContact(contact1);
        book2.addContact(contact1);
        book2.addContact(contact2);
        assertThat(book2.size(), is(3));
        Contact[] contacts2 = book2.getContacts();
        assertThat(contacts2.length, is(3));

        assertThat(Arrays.asList(contacts2), hasItem(contact1));
        assertThat(Arrays.asList(contacts2), hasItem(contact2));
        book2.deleteContact(contact1);
        contacts2 = book2.getContacts();
        assertThat(Arrays.asList(contacts2), not(hasItem(contact1)));
        assertThat(Arrays.asList(contacts2), hasItem(contact2));
        assertThat(book2.size(), is(1));
        assertThat(contacts2.length, is(1));
    }

    @Test
    public void testFindById() {
        AddressBook book = new AddressBook(2);
        Contact contact1 = book.addContact("Michael", "Würsch");
        Contact contact2 = book.addContact("Emanuel", "Giger");

        Contact contact3 = book.findById(contact1.getId());
        Contact contact4 = book.findById(contact2.getId());
        Contact contact5 = book.findById(250);

        assertThat(contact1, is(equalTo(contact3)));
        assertThat(contact2, is(equalTo(contact4)));
        assertThat(contact1, is(not(equalTo(contact4))));
        assertThat(contact5, is(nullValue()));
    }

    @Test
    public void testFindByLastName() {
        AddressBook book = new AddressBook(2);
        Contact contact1 = book.addContact("Michael", "Würsch");
        Contact contact2 = book.addContact("Emanuel", "Giger");

        Contact contact3 = book.findByLastName("Würsch");
        Contact contact4 = book.findByLastName("Giger");
        Contact contact5 = book.findByLastName("Gall");

        assertThat(contact1, is(equalTo(contact3)));
        assertThat(contact2, is(equalTo(contact4)));
        assertThat(contact1, is(not(equalTo(contact4))));
        assertThat(contact5, is(nullValue()));
    }

    @Test
    public void testSortByLastName() {
        AddressBook book = new AddressBook(3);
        Contact contact1 = book.addContact("Michael", "Würsch");
        Contact contact2 = book.addContact("Emanuel", "Giger");
        Contact contact3 = book.addContact("Harald", "Gall");

        assertThat(contact1, is(equalTo(book.getContacts()[0])));
        assertThat(contact2, is(equalTo(book.getContacts()[1])));
        assertThat(contact3, is(equalTo(book.getContacts()[2])));

        book.sortByLastName();
        assertThat(contact1, is(equalTo(book.getContacts()[2])));
        assertThat(contact2, is(equalTo(book.getContacts()[1])));
        assertThat(contact3, is(equalTo(book.getContacts()[0])));
    }

    @Test
    public void testSortByAge() {
        AddressBook book = new AddressBook(3);
        Contact contact1 = book.addContact("Rudolf", "Grossväterlich");
        Contact contact2 = book.addContact("Markus", "Kind");
        Contact contact3 = book.addContact("Helene", "Tante");
        contact1.setBirthday(1, 1, 1945);
        contact2.setBirthday(1, 1, 2006);
        contact3.setBirthday(1, 1, 1970);

        assertThat(contact1, is(equalTo(book.getContacts()[0])));
        assertThat(contact2, is(equalTo(book.getContacts()[1])));
        assertThat(contact3, is(equalTo(book.getContacts()[2])));

        book.sortByAge();
        assertThat(contact1, is(equalTo(book.getContacts()[2])));
        assertThat(contact2, is(equalTo(book.getContacts()[0])));
        assertThat(contact3, is(equalTo(book.getContacts()[1])));
    }


}
