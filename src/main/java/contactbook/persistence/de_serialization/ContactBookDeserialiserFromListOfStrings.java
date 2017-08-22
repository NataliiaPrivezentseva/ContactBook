package contactbook.persistence.de_serialization;

import contactbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactBookDeserialiserFromListOfStrings implements ContactBookDeserializer {

    private ContactDeserialiser deserialiser;

    public ContactBookDeserialiserFromListOfStrings(ContactDeserialiser deserialiser) {
        this.deserialiser = deserialiser;
    }

    public List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        List<Contact> contactBook = new ArrayList<>();

        for (int startOfContact = 0;
             startOfContact <= inputInStrings.size() - Contact.STRINGS_IN_ONE_CONTACT;
             startOfContact += Contact.STRINGS_IN_ONE_CONTACT) {
            contactBook.add(deserialiser.turnIntoContact(inputInStrings, startOfContact));
        }
        return contactBook;
    }
}
