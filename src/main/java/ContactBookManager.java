import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class ContactBookManager {
//    List<Contact> contactBook;
//
//    ContactBookManager(List<Contact> contactBook){
//        this.contactBook = contactBook;
//    }

    static List<Contact> createContactBook() {
        return new ArrayList<Contact>();
    }

    static List<Contact> addNewContactToBook(Contact contact, List<Contact> contactBook) {
        if (contactBook == null) {
            throw new NullPointerException();
        }
        contactBook.add(contact);
        return contactBook;
    }

    static List<Contact> removeContactFromBook(Contact contact, List<Contact> contactBook) {
        if (!contactBook.contains(contact)) {
            throw new NoSuchElementException();
        }
        contactBook.remove(contact);
        return contactBook;
    }

    // rewrite this method! добавить сообщение для юзера о том, почему не могу записать книгу в файл
    // логика метода должна быть прописана не тут, а в Persistent Manager
    // выбросить IllegalStateException, обрабатываем в месте вызова метода
    static File saveBookIntoFile(List<Contact> contactBook){
        List<String> contacts = null;
        for (Contact contact : contactBook) {
            contacts.add(contact.toString());
        }

//        if (contacts == null) {
//            throw new IllegalStateException();
//        }

        File file = null;
//        try {
//            OutputToFile.writeToFile(contacts, Input.getInfoFromUser("name of the file " +
//                    "in which you want to write your contact book"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return file;
    }
}
