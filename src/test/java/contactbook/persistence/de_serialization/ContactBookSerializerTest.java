package contactbook.persistence.de_serialization;

import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.model.Person;
import contactbook.model.PhoneNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactBookSerializerTest {
    private Person person1 = new Person("Max", "Salliwan");
    private PhoneNumber[] number1 = {new PhoneNumber("999888777")};
    private List<PhoneNumber> phoneNumbers1 = Arrays.asList(number1);
    private EMail eMail1 = new EMail("max@salliwan.com");
    private Contact contact1 = new Contact(person1, phoneNumbers1, eMail1);

    private Person person2 = new Person("Nad", "Stark");
    private PhoneNumber number2 = new PhoneNumber("333222555");
    private PhoneNumber number3 = new PhoneNumber("777666333");
    private List<PhoneNumber> phoneNumbers2 = Arrays.asList(number2, number3);
    private EMail eMail2 = new EMail("nad.stark@war.end");
    private Contact contact2 = new Contact(person2, phoneNumbers2, eMail2);

    private List<Contact> contactBook = Arrays.asList(contact1, contact2);

    @Test
    public void shouldSerializeContactBook() {
        ContactBookSerializer serializer = new ContactBookSerializer();
        assertEquals("First name: Max\nLast name: Salliwan\nPhone numbers: [999888777]\n" +
                "E-mail: max@salliwan.com\n", serializer.turnIntoListOfStrings(contactBook).get(0));
        assertEquals("First name: Nad\nLast name: Stark\nPhone numbers: [333222555, 777666333]\n" +
                "E-mail: nad.stark@war.end\n", serializer.turnIntoListOfStrings(contactBook).get(1));
    }
}