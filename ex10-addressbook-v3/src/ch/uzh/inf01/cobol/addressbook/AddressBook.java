package ch.uzh.inf01.cobol.addressbook;

import java.util.ArrayList;
import java.util.List;


public class AddressBook {

    private List<Contact> mContacts;


    public AddressBook(int pCapacity) {
        mContacts = new ArrayList<>(pCapacity);
    }


    public int size() {
        return mContacts.size();
    }

    public void addContact(Contact pContact) {
        mContacts.add(pContact);
    }

    public Contact addContact(String pFirstName, String pLastName) {
        Contact contact = new Contact(pFirstName, pLastName);
        addContact(contact);
        return contact;
    }

    public Contact[] getContacts() {
        Contact[] ret = new Contact[mContacts.size()];
        return mContacts.toArray(ret);
    }

    public void deleteContact(Contact pContact) {
        mContacts.remove(pContact);
    }

    public Contact findById(long pId) {
        for (Contact entry : mContacts) {
            if (pId == entry.getId()) {
                return entry;
            }
        }
        return null;
    }

    public Contact findByLastName(String pLastName) {
        for (Contact entry : mContacts) {
            if (pLastName.equals(entry.getLastName())) {
                return entry;
            }
        }
        return null;
    }

}
