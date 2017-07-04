package contactbook.logic.controller;

import contactbook.ui.console.InputFromConsole;
import contactbook.model.Contact;
import contactbook.persistence.file.FileCreator;
import contactbook.persistence.file.InputFromFile;
import contactbook.persistence.file.OutputToFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactBookManager {
    public static final String OPTIONS = "Please, choose what you want to do:\n" +
            "1 — Add new contact\n" +
            "2 — Show contacts\n" +
            "3 — Find contact\n" +
            "4 — Edit contact\n" +
            "5 — Delete contact\n" +
            "6 — Upload contacts from file\n" +
            "7 — Download contact book to file\n";

    private List<Contact> contactBook;
    private File fileToSaveContactBook;

    public List<Contact> getContactBook() {
        return contactBook;
    }

    void setContactBook(List<Contact> contactBook) {
        this.contactBook = contactBook;
    }

    public File getFileToSaveContactBook() {
        return fileToSaveContactBook;
    }

    void setFileToSaveContactBook(File fileToSaveContactBook) {
        this.fileToSaveContactBook = fileToSaveContactBook;
    }

    List<Contact> createContactBook() {
        return new ArrayList<>();
    }

    File createFileToSaveContactBook() {
        InputFromConsole inFromConsole = new InputFromConsole();
        int choice = inFromConsole.getChoiceFromUser("Where do you want to write your contact book?\n" +
                "1 — into default file named \'my_contacts\' which placed on disc C;\n" +
                "2 — I want to use another file.", 2);

        FileCreator fileCreator = new FileCreator();
        switch (choice) {
            case 1:
                return fileCreator.createFile("my_contacts");
            case 2:
                return fileCreator.createFile(inFromConsole.getInfoFromUser("name of file, where your contacts " +
                        "will be saved."));
            default:
                throw new IllegalStateException();
        }
    }


    public void prepareForWork(){
        this.setContactBook(this.createContactBook());
        this.setFileToSaveContactBook(this.createFileToSaveContactBook());
    }

    public List<Contact> addNewContactToBook(Contact contact) {
        OutputToFile outToFile = new OutputToFile();
        if (contactBook == null) {
            contactBook = createContactBook();
        }

        List<String> existingContacts;
        InputFromFile inFromFile = new InputFromFile();
        ContactBookDeserialiser deserialiser = new ContactBookDeserialiser();
        ContactBookSerializer serializer = new ContactBookSerializer();
        try {
            existingContacts = inFromFile.readFromFile(fileToSaveContactBook);
            contactBook.addAll(deserialiser.turnIntoContactBook(existingContacts));
        } catch (IOException e) {
            e.printStackTrace();
        }
        contactBook.add(contact);

        List<String> contactsInString = serializer.turnIntoListOfStrings(this.getContactBook());
        try {
            outToFile.writeToFile(contactsInString, this.getFileToSaveContactBook());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contactBook;
    }

    //todo rewrite this method после смены коллекции!
    Contact findContactInContactBook(String person) {
        Contact contact = null;
        return contact;
    }

    List<Contact> removeContactFromContactBook(Contact contact) {
        if (!contactBook.contains(contact)) {
            throw new NoSuchElementException();
        }
        contactBook.remove(contact);
        return contactBook;
    }

    //todo rewrite this method! добавить сообщение для юзера о том, почему не могу записать книгу в файл
    // логика метода должна быть прописана не тут, а в Persistent Manager
    //todo прописать логику в месте выбора пользователем сохранить книгу.
    File saveContactBookIntoFile() throws IOException {
        ContactBookManager manager = new ContactBookManager();
        if (this.contactBook.isEmpty()) {
            throw new IllegalStateException("This contact book contains no contacts. It won't be written in a file.");
        }

        if (fileToSaveContactBook == null) {
            fileToSaveContactBook = manager.createFileToSaveContactBook();
        }

        InputFromFile inFromFile = new InputFromFile();
        List<String> contacts = inFromFile.readFromFile(fileToSaveContactBook);

        for (Contact contact : contactBook) {
            contacts.add(contact.toString());
        }
        OutputToFile output = new OutputToFile();
        return output.writeToFile(contacts, fileToSaveContactBook);
    }
}
