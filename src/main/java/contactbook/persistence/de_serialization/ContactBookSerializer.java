package contactbook.persistence.de_serialization;

import contactbook.model.Contact;

import java.util.List;

public interface ContactBookSerializer {

    String turnIntoString(List<Contact> contactBook);

    String getFileExtension();
}
