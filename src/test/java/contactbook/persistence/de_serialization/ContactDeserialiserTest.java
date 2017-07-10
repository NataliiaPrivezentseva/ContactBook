package contactbook.persistence.de_serialization;

import contactbook.model.Contact;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactDeserialiserTest {

    @Test
    public void shouldDeserializeContact() {
        //given:
        List<String> contactStrings = Arrays.asList("First name: Vasya",
                "Last name: Pupkin",
                "Phone numbers: [444888999]",
                "E-mail: v.pupkin@pisem.net");

        //when:
        ContactDeserialiser deserialiser = new ContactDeserialiser();
        Contact contact = deserialiser.turnIntoContact(contactStrings, 0);

        //then:
        assertEquals("Vasya", contact.getPerson().getFirstName());
        assertEquals("Pupkin", contact.getPerson().getLastName());
        assertEquals("444888999", contact.getPhoneNumbers().get(0).toString());
        assertEquals("v.pupkin@pisem.net", contact.getEMail().toString());
    }
}