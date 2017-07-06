package contactbook.logic.controller;

import contactbook.model.Contact;
import contactbook.persistence.de_serialization.ContactBookDeserialiser;
import contactbook.persistence.de_serialization.ContactBookSerializer;
import contactbook.persistence.file.FileCreator;
import contactbook.persistence.file.InputFromFile;
import contactbook.persistence.file.OutputToFile;
import contactbook.ui.console.InputFromConsole;
import contactbook.ui.console.OutputToConsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactBookManager {

    private List<Contact> contactBook;
    private File fileToSaveContactBook;

    private List<Contact> getContactBook() {
        return contactBook;
    }

    private void setContactBook(List<Contact> contactBook) {
        this.contactBook = contactBook;
    }

    private File getFileToSaveContactBook() {
        return fileToSaveContactBook;
    }

    private void setFileToSaveContactBook(File fileToSaveContactBook) {
        this.fileToSaveContactBook = fileToSaveContactBook;
    }

    private List<Contact> createContactBook() {
        return new ArrayList<>();
    }

    private File createFileToSaveContactBook() {
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

    //todo решить, где спросить юзера, из какого файла подгружать данные
    public void prepareForWork() {
        setContactBook(createContactBook());
        setFileToSaveContactBook(createFileToSaveContactBook());
        if (!isEmptyFileToSaveContactBook()) {
            try {
                uploadContactsFromFile(getFileToSaveContactBook());
            } catch (IOException e) {
                System.out.println("Something wrong with the file, in which you keep your contact book");
            }
        } else {
            System.out.println("Your contact book contains no contacts.");
        }
    }

    private void uploadContactsFromFile(File file) throws IOException {
        ContactBookDeserialiser deserialiser = new ContactBookDeserialiser();
        InputFromFile inFromFile = new InputFromFile();
        setContactBook(deserialiser.turnIntoContactBook(inFromFile.readFromFile(file)));
    }

    private void downloadContactsToFile(File file) throws IOException {
        OutputToFile outToFile = new OutputToFile();
        ContactBookSerializer serializer = new ContactBookSerializer();
        List<String> contactsInString = serializer.turnIntoListOfStrings(getContactBook());
        outToFile.writeToFile(contactsInString, file);
    }

    //todo обсудить, а не пробросить ли исключение еще выше.
    //todo Мне оно тут нравится, но, может, лучше обрабатывать в AppRunner
    public List<Contact> addNewContactToBook(Contact contact) {
        if (contactBook == null) {
            throw new IllegalStateException("Something went wrong! There is no contact book.");
        }

        contactBook.add(contact);
        try {
            downloadContactsToFile(getFileToSaveContactBook());
        } catch (IOException e) {
            System.out.println("Sorry, something went wrong! Can't save added contact in the file.");
            e.printStackTrace();
        }
        return contactBook;
    }

    public void showContacts(){
        OutputToConsole outToConsole = new OutputToConsole();
        ContactBookSerializer serializer = new ContactBookSerializer();

        outToConsole.printToConsole(serializer.turnIntoListOfStrings(getContactBook()));
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

    //todo rewrite and rename this method! добавить сообщение для юзера о том, почему не могу записать книгу в файл
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
