//package contactbook.persistence.de_serialization;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import contactbook.model.Contact;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ContactBookSerializerToJSON implements ContactBookSerializer {
//
//    @Override
//    public List<String> turnIntoListOfStrings(List<Contact> contactBook) {
//        List<String> contactsInString = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//
//        for (Contact contact : contactBook) {
//            try {
//                contactsInString.add(mapper.writeValueAsString(contact));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//        return contactsInString;
//    }
//}
