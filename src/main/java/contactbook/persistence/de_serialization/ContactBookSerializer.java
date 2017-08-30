package contactbook.persistence.de_serialization;

import contactbook.model.Contact;

import java.util.List;

public interface ContactBookSerializer {

//    List<String> turnIntoListOfStrings(List<Contact> contactBook);
    String turnIntoListOfStrings(List<Contact> contactBook);
}
