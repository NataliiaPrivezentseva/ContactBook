import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactBookManagerTest {
    @Test
    public void shouldDeserializeContact() {
        //given:
        List<String> contactStrings = Arrays.asList("First name: Vasya",
                "Last name: Pupkin",
                "Phone numbers: [444888999]",
                "E-mail: v.pupkin@pisem.net");
        ContactBookManager bookManager = new ContactBookManager();

        /*List<PhoneNumber> phones = new ArrayList<>();
        phones.add(new PhoneNumber("444888999"));

        Contact expected = new Contact(new Person("Vasya", "Pupkin"), phones, new EMail("v.pupkin@pisem.net"));*/

        //when:
        ContactDeserialiser deserialiser = new ContactDeserialiser();
        Contact contact = deserialiser.turnIntoContact(contactStrings, 0);

        //then:
//        assertEquals(expected, contact);
        assertEquals("Vasya", contact.getPerson().getFirstName());
    }

}