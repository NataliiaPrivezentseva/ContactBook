package contactbook.persistence.de_serialization;

import contactbook.model.Contact;

import java.util.List;

public interface ContactBookDeserializer {

    List<Contact> turnIntoContactBook(List<String> inputInStrings);
}
