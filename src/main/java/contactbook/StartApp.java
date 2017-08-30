package contactbook;

import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.model.Person;
import contactbook.model.PhoneNumber;
import contactbook.persistence.de_serialization.ContactBookSerializer;
import contactbook.persistence.de_serialization.ContactBookSerializerToListOfStrings;
//import contactbook.persistence.de_serialization.ContactBookSerializerToXML;

import java.util.Arrays;
import java.util.List;

public class StartApp {

    public static void main(String[] args) {
        AppRunner runner = new AppRunner();
        runner.runApp();

/*//        ContactBookSerializer serializer = new ContactBookSerializerToXML();
        ContactBookSerializer serializer = new ContactBookSerializerToListOfStrings();

        Person person1 = new Person("Max", "Salliwan");
        PhoneNumber[] number1 = {new PhoneNumber("999888777")};
        List<PhoneNumber> phoneNumbers1 = Arrays.asList(number1);
        EMail eMail1 = new EMail("max@salliwan.com");
        Contact contact1 = new Contact(person1, phoneNumbers1, eMail1);

        Person person2 = new Person("Nad", "Stark");
        PhoneNumber number2 = new PhoneNumber("333222555");
        PhoneNumber number3 = new PhoneNumber("777666333");
        List<PhoneNumber> phoneNumbers2 = Arrays.asList(number2, number3);
        EMail eMail2 = new EMail("nad.stark@war.end");
        Contact contact2 = new Contact(person2, phoneNumbers2, eMail2);

        List<Contact> contactBook = Arrays.asList(contact1, contact2);

        serializer.turnIntoListOfStrings(contactBook);
//        List<String> xml = serializer.turnIntoListOfStrings(contactBook);
//        for(String s : xml){
//            System.out.println(s);
//        }*/

    }
}
