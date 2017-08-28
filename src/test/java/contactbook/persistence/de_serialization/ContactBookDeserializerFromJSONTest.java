package contactbook.persistence.de_serialization;

import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.model.PhoneNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ContactBookDeserializerFromJSONTest {

    @Test
    public void shouldDeserializeContactBook(){
        List<String> contacts = Arrays
                .asList("{\"person\":{\"firstName\":\"Fox\",\"lastName\":\"Red\"}," +
                                "\"phoneNumbers\":[{\"phoneNumber\":\"222333444\"},{\"phoneNumber\":\"555666777\"}]," +
                                "\"email\":{\"email\":\"fox.red@gmail.com\"}}",
                        "{\"person\":{\"firstName\":\"Wolf\",\"lastName\":\"Grey\"}," +
                                "\"phoneNumbers\":[{\"phoneNumber\":\"888777888\"}]," +
                                "\"email\":{\"email\":\"wolf.grey@no.letters\"}}");

        ContactBookDeserializer deserialiser = new ContactBookDeserializerFromJSON();
        List<Contact> contactBook = deserialiser.turnIntoContactBook(contacts);

        assertEquals("Fox", contactBook.get(0).getPerson().getFirstName());
        assertEquals("Wolf", contactBook.get(1).getPerson().getFirstName());

        assertEquals("Red", contactBook.get(0).getPerson().getLastName());
        assertEquals("Grey", contactBook.get(1).getPerson().getLastName());

        List<PhoneNumber> numbers = new ArrayList<>(2);
        numbers.add(new PhoneNumber("222333444"));
        numbers.add(new PhoneNumber("555666777"));
        assertEquals(numbers,contactBook.get(0).getPhoneNumbers());
        assertEquals(Collections.singletonList(new PhoneNumber("888777888")),
                contactBook.get(1).getPhoneNumbers());

        assertEquals(new EMail("fox.red@gmail.com"), contactBook.get(0).getEMail());
        assertEquals(new EMail("wolf.grey@no.letters"), contactBook.get(1).getEMail());
    }
}