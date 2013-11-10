package ch.uzh.inf01.cobol.addressbook;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


/**
 * Add JUnit [4] library to Java Build Path.
 * Start with Run as - JUnit Test.
 */
public class TestContact {

    @Test
    public void testToString() {
        Contact contact1 = new Contact("Michael", "Würsch");
        assertThat(contact1.toString(), is(contact1.getId() + ".\tMichael Würsch"));

        contact1.setBirthday(3, 10, 1980);
        assertThat(contact1.toString(), is(contact1.getId() + ".\tMichael Würsch\n\t1980-10-03"));

        contact1.setEmailAdress("wuersch@ifi.uzh.ch");
        assertThat(contact1.toString(), is(contact1.getId() + ".\tMichael Würsch\n\t1980-10-03\n\twuersch@ifi.uzh.ch"));

        contact1.setStreetAddress("Binzmühlestrasse 14", "8050", "Zürich");
        assertThat(contact1.toString(), is(contact1.getId() + ".\tMichael Würsch\n\t1980-10-03\n\twuersch@ifi.uzh.ch\n\tBinzmühlestrasse 14\n\t8050 Zürich"));
    }
}
