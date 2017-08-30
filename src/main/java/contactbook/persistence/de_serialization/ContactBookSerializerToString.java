package contactbook.persistence.de_serialization;

import contactbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactBookSerializerToString implements ContactBookSerializer {

    @Override
    public String turnIntoString(List<Contact> contactBook) {
        List<String> contactsInString = new ArrayList<>();
        for (Contact contact : contactBook) {
            contactsInString.add(contact.toString());
        }
        return contactsInString.toString();
    }

    @Override
    public String getFileExtension() {
        return ".txt";
    }
}
