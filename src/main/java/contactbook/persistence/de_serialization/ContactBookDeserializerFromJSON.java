package contactbook.persistence.de_serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import contactbook.model.Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactBookDeserializerFromJSON implements ContactBookDeserializer {

/*    public List<Contact> turnIntoBook(String input){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(input, List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        List<Contact> contactBook = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

//        String json = inputInStrings.get(0);
//        try {
//            contactBook.addAll(mapper.readValue(json, List.class));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return contactBook;


//        String contactsSeparator = "}}, ";
//        String[] contacts = inputInStrings.get(0).split(contactsSeparator, 0);
//        contacts[0] = contacts[0].substring(1);
//        contacts[contacts.length - 1] = contacts[contacts.length - 1].substring(0, contacts[contacts.length - 1].length());
//
//
//        for(String contactJSON : contacts){
//            try {
//                contactBook.add(mapper.readValue(contactJSON, Contact.class));
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        }


        for (String contactJSON : inputInStrings) {
            try {
                contactBook.add(mapper.readValue(contactJSON, Contact.class));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return contactBook;
    }

    //        String json = "{\"person\":{\"firstName\":\"Fox\",\"lastName\":\"Red\"}," +
//                "\"phoneNumbers\":[{\"phoneNumber\":\"222333444\"},{\"phoneNumber\":\"555666777\"}]," +
//                "\"email\":{\"email\":\"fox.red@gmail.com\"}}";
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            Contact contact = mapper.readValue(json, Contact.class);
//            System.out.println(contact.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
}
