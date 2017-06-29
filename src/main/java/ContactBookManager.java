import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class ContactBookManager {

    static List<Contact> createContactBook() {
        return new ArrayList<Contact>();
    }

    static List<Contact> addNewContactToBook(Contact contact, List<Contact> contactBook) {
        if (contactBook == null){
            throw new NullPointerException();
        }
        contactBook.add(contact);
        return contactBook;
    }

    static List<Contact> removeContactFromBook(Contact contact, List<Contact> contactBook) {
        if (!contactBook.contains(contact)){
            throw new NoSuchElementException();
        }
        contactBook.remove(contact);
        return contactBook;
    }

    // rewrite this method! добавить сообщение для юзера о том, почему не могу записать книгу в файл
    // логика метода должна быть прописана не тут, а в Persistent Manager
    // выбросить IllegalStateException, обрабатываем в месте вызова метода
    static File saveBookIntoFile(List<Contact> contactBook) {
        if (contactBook == null){
            throw new NullPointerException();
        }

        File file = null;
        try {
            OutputToFile.writeToFile(contactBook., file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

//    static File createNewContactBook(String contactBookName) {
//        File contactBook = null;
//        try {
//            contactBook = new File("c:\\" + contactBookName + ".txt");
//            if (contactBook.createNewFile()) {
//                System.out.println("Contact book \'" + contactBookName + ".txt\' is created!");
//            } else {
//                System.out.println("Contact book \'" + contactBookName + ".txt\' already exists");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return contactBook;
//    }

//    static void addNewContactToBook(Contact contact, File contactBook) throws IOException {
//
//        FileWriter outputToFile;
//        try {
//            outputToFile = new FileWriter(contactBook, true);
//            outputToFile.write(contact.toString());
//            outputToFile.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}
