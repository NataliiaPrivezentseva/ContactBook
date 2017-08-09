package contactbook.persistence.de_serialization;

import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.model.PhoneNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactBookDeserialiserTest {

    @Test
    public void shouldDeserializeContactBook() {
        List<String> contacts = Arrays.asList("First name: Andrej",
                "Last name: Sirotenko",
                "Phone numbers: [095875654]",
                "E-mail: andrej.sirotenko@filarmonija.kh",
                "First name: Masha",
                "Last name: Ferry",
                "Phone numbers: [444444444, 555555555]",
                "E-mail: masha.ferry@j.com");

        ContactBookDeserialiser deserialiser = new ContactBookDeserialiser(new ContactDeserialiser());
        List<Contact> contactBook = deserialiser.turnIntoContactBook(contacts);

        assertEquals("Andrej", contactBook.get(0).getPerson().getFirstName());
        assertEquals("Masha", contactBook.get(1).getPerson().getFirstName());

        assertEquals("Sirotenko", contactBook.get(0).getPerson().getLastName());
        assertEquals("Ferry", contactBook.get(1).getPerson().getLastName());

        assertEquals(Collections.singletonList(new PhoneNumber("095875654")),
                contactBook.get(0).getPhoneNumbers());
        List<PhoneNumber> numbers = new ArrayList<>(2);
        numbers.add(new PhoneNumber("444444444"));
        numbers.add(new PhoneNumber("555555555"));
        assertEquals(numbers,contactBook.get(1).getPhoneNumbers());

        assertEquals(new EMail("andrej.sirotenko@filarmonija.kh"), contactBook.get(0).getEMail());
        assertEquals(new EMail("masha.ferry@j.com"), contactBook.get(1).getEMail());
    }
}