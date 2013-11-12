package ch.uzh.inf01.cobol.addressbook;

import java.util.Arrays;


public class AddressBook {

    private Contact[] mContacts;
    private int       mSize;


    public AddressBook(int pCapacity) {
        mContacts = new Contact[pCapacity];
        mSize = 0;
    }


    public int size() {
        return mSize;
    }

    public void addContact(Contact pContact) {
        mContacts[mSize] = pContact;
        mSize++;
    }

    public Contact addContact(String pFirstName, String pLastName) {
        Contact contact = new Contact(pFirstName, pLastName);
        addContact(contact);
        return contact;
    }

    public Contact[] getContacts() {
        return Arrays.copyOf(mContacts, mSize); // returning copy of contacts array
    }

    public void deleteContact(Contact pContact) {
        for (int i = 0; i < mSize; i++) {
            if (mContacts[i].equals(pContact)) {
                remove(i--); // i--: correcting left shift in remove/merge methods
                             // in order to still iterate over whole array
            }
        }
    }

    public Contact findById(long pId) {
        for (int i = 0; i < mSize; i++) {
            Contact candidate = mContacts[i];
            long candidateId = candidate.getId();
            if (pId == candidateId) {
                return candidate;
            }
        }
        return null;
    }

    public Contact findByLastName(String pLastName) {
        for (int i = 0; i < mSize; i++) {
            Contact candidate = mContacts[i];
            String candidateLastName = candidate.getLastName();
            if (pLastName.equals(candidateLastName)) {
                return candidate;
            }
        }

        return null;
    }

    private void remove(int pIndex) {
        Contact[] head = Arrays.copyOfRange(mContacts, 0, pIndex);
        Contact[] tail = Arrays.copyOfRange(mContacts, pIndex + 1, mSize);

        // removing Contact at index;
        // reducing contacts array length by shifting all elements
        // right of index to left and not leaving empty slots at end of array
        mContacts = merge(head, tail);
        mSize--;
    }

    private Contact[] merge(Contact[] pHead, Contact[] pTail) {
        Contact[] merged = new Contact[pHead.length + pTail.length];

        for (int i = 0; i < pHead.length; i++) {
            merged[i] = pHead[i];
        }

        for (int i = 0; i < pTail.length; i++) {
            merged[i + pHead.length] = pTail[i];
        }
        return merged;
    }

    // You might notice the two following functions are nearly identical. This
    // is a good example for why we need polymorphism! We really want to re-use
    // the sorting algorithm any only specify a comparator.
    public void sortByLastName() {
        boolean swapped = true;
        int j = 0;
        Contact tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < this.size() - j; i++) {
                if (mContacts[i].getLastName().compareTo(mContacts[i + 1].getLastName()) > 0) {
                    tmp = mContacts[i];
                    mContacts[i] = mContacts[i + 1];
                    mContacts[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public void sortByAge() {
        boolean swapped = true;
        int j = 0;
        Contact tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < this.size() - j; i++) {
                if (mContacts[i].getBirthday().compareTo(mContacts[i + 1].getBirthday()) < 0) {
                    tmp = mContacts[i];
                    mContacts[i] = mContacts[i + 1];
                    mContacts[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

}
