package contactbook.logic.controller;

import contactbook.model.Contact;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ContactBookManagerTest {

    @Test
    public void shouldDeserializeContact() {
        //given:
        List<String> contactStrings = Arrays.asList("First name: Vasya",
                "Last name: Pupkin",
                "Phone numbers: [444888999]",
                "E-mail: v.pupkin@pisem.net");
        ContactBookManager manager = new ContactBookManager();

        /*List<contactbook.model.PhoneNumber> phones = new ArrayList<>();
        phones.add(new contactbook.model.PhoneNumber("444888999"));

        contactbook.model.Contact expected = new contactbook.model.Contact(new contactbook.model.Person("Vasya",
        "Pupkin"), phones, new contactbook.model.EMail("v.pupkin@pisem.net"));*/

        //when:
        ContactDeserialiser deserialiser = new ContactDeserialiser();
        Contact contact = deserialiser.turnIntoContact(contactStrings, 0);

        //then:
//        assertEquals(expected, contact);
        assertEquals("Vasya", contact.getPerson().getFirstName());
    }
}