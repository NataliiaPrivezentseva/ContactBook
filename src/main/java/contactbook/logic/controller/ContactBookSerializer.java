package contactbook.logic.controller;

import contactbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

class ContactBookSerializer {

    List<String> turnIntoListOfStrings(List<Contact> contactBook){
        List<String> contactsInString = new ArrayList<>();
        for (Contact contact : contactBook) {
            contactsInString.add(contact.toString());
        }
        return contactsInString;
    }
}
