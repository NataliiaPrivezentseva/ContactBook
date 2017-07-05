package contactbook.logic.controller;

import contactbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

class ContactBookDeserialiser {

    List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        ContactDeserialiser deserialiser = new ContactDeserialiser();
        List<Contact> contactBook = new ArrayList<>();

        for (int startOfContact = 0;
             startOfContact <= inputInStrings.size() - Contact.STRINGS_IN_ONE_CONTACT;
             startOfContact += Contact.STRINGS_IN_ONE_CONTACT) {
            contactBook.add(deserialiser.turnIntoContact(inputInStrings, startOfContact));
        }
        return contactBook;
    }
}
