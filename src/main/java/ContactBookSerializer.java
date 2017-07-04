import java.util.ArrayList;
import java.util.List;

public class ContactBookSerializer {

    List<String> turnIntoListOfStrings(List<Contact> contactBook){
        List<String> contactsInString = new ArrayList<>();
        for (Contact contact : contactBook) {
            contactsInString.add(contact.toString());
        }
        return contactsInString;
    }
}
