package contactbook.logic.controller;

import contactbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

class ContactBookDeserialiser {

    List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        ContactDeserialiser deserialiser = new ContactDeserialiser();
        int stringsInOneContact = 4;
        List<Contact> contactBook = new ArrayList<>();

        for (int startOfContact = 0;
             startOfContact <= inputInStrings.size() - stringsInOneContact;
             startOfContact += stringsInOneContact) {
            contactBook.add(deserialiser.turnIntoContact(inputInStrings, startOfContact));
        }
        return contactBook;
    }
}
