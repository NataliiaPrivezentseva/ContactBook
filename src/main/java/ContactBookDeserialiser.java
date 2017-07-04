import java.util.ArrayList;
import java.util.List;

public class ContactBookDeserialiser {

    List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        ContactDeserialiser deserialiser = new ContactDeserialiser();
        int stringsInOneContact = 4;
        int amountOfStrings = inputInStrings.size();
        int amountOfIterations = amountOfStrings / stringsInOneContact;
        List<Contact> contactBook = new ArrayList<>();
        int startOfContact = -4;
        while (amountOfIterations > 0) {
            contactBook.add(deserialiser.turnIntoContact(inputInStrings, startOfContact + 4));
            startOfContact += 4;
            amountOfIterations--;
        }
        return contactBook;
    }
}
