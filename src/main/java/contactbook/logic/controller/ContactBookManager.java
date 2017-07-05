package contactbook.logic.controller;

import contactbook.model.Contact;
import contactbook.persistence.de_serialization.ContactBookDeserialiser;
import contactbook.persistence.de_serialization.ContactBookSerializer;
import contactbook.persistence.file.FileCreator;
import contactbook.persistence.file.InputFromFile;
import contactbook.persistence.file.OutputToFile;
import contactbook.ui.console.InputFromConsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactBookManager {

    private List<Contact> contactBook;
    private File fileToSaveContactBook;

    List<Contact> getContactBook() {
        return contactBook;
    }

    void setContactBook(List<Contact> contactBook) {
        this.contactBook = contactBook;
    }

    File getFileToSaveContactBook() {
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

    private boolean isEmptyFileToSaveContactBook() {
        InputFromFile inFromFile = new InputFromFile();
        List<String> previousContacts = new ArrayList<>();
        try {
            previousContacts = inFromFile.readFromFile(getFileToSaveContactBook());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return previousContacts.isEmpty();
    }

    public void prepareForWork() {
        setContactBook(createContactBook());
        setFileToSaveContactBook(createFileToSaveContactBook());
        if (!isEmptyFileToSaveContactBook()) {
            uploadContactsFromDefaultFile();
        } else {
            System.out.println("Your contact book contains no contacts.");
        }
    }

    //    todo добавить входящий параметр
    private void uploadContactsFromDefaultFile() {
        ContactBookDeserialiser deserialiser = new ContactBookDeserialiser();
        InputFromFile inFromFile = new InputFromFile();

        try {
            setContactBook(deserialiser.turnIntoContactBook (inFromFile.readFromFile(getFileToSaveContactBook())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    todo добавить входящий параметр
    private void downloadContactsToDefaultFile() {
        OutputToFile outToFile = new OutputToFile();
        ContactBookSerializer serializer = new ContactBookSerializer();
        List<String> contactsInString = serializer.turnIntoListOfStrings(getContactBook());
        try {
            outToFile.writeToFile(contactsInString, getFileToSaveContactBook());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> addNewContactToBook(Contact contact) {
        if (contactBook == null) {
            throw new IllegalStateException("Something went wrong! There is no contact book.");
        }

        contactBook.add(contact);
        downloadContactsToDefaultFile();
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
