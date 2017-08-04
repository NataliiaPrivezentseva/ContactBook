package contactbook.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactTest {
    private PhoneNumber[] numbers = {new PhoneNumber("111222333")};
    private List<PhoneNumber> phoneNumbers = Arrays.asList(numbers);
    private Person person = new Person("Lada", "Dance");
    private EMail eMail = new EMail("l.dance@stars.com");
    private Contact contact = new Contact(person, phoneNumbers, eMail);

    @Test
    public void shouldReturnPerson() {
        assertEquals(person, contact.getPerson());
    }

    @Test
    public void shouldReturnListOfPhoneNumbers(){
        assertEquals(phoneNumbers, contact.getPhoneNumbers());
    }

    @Test
    public void shouldReturnEMail() {
        assertEquals(eMail, contact.getEMail());
    }

    @Test
    public void shouldProduceProperString(){
        String expected = "First name: Lada\nLast name: Dance\nPhone numbers: [111222333]\nE-mail: l.dance@stars.com\n";
        assertEquals(expected, contact.toString());
    }
}