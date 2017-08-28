package contactbook.persistence.de_serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import contactbook.model.Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactBookDeserializerFromJSON implements ContactBookDeserializer {

    @Override
    public List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        List<Contact> contactBook = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (String contactJSON : inputInStrings) {
            try {
                contactBook.add(mapper.readValue(contactJSON, Contact.class));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return contactBook;
    }
}
