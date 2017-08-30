package contactbook.persistence.de_serialization;

import contactbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactBookSerializerToListOfStrings implements ContactBookSerializer {

    public String turnIntoListOfStrings(List<Contact> contactBook) {
        List<String> contactsInString = new ArrayList<>();
        for (Contact contact : contactBook) {
            contactsInString.add(contact.toString());
        }
        return contactsInString.toString();
    }

/*    public List<String> turnIntoListOfStrings(List<Contact> contactBook) {
        List<String> contactsInString = new ArrayList<>();
        for (Contact contact : contactBook) {
            contactsInString.add(contact.toString());
        }
        return contactsInString;
    }*/
}
