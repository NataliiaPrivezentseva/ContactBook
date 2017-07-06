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

    //todo метод лишний, потому как теперь в нем нет опций выбора?
    private File createFileToSaveContactBook(String fileName) {
        FileCreator fileCreator = new FileCreator();
        return fileCreator.createFile(fileName);
    }

    private boolean isEmptyFile(File file) {
        InputFromFile inFromFile = new InputFromFile();
        List<String> previousContacts = new ArrayList<>();
        try {
            previousContacts = inFromFile.readFromFile(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return previousContacts.isEmpty();
    }

    private boolean isEmptyFileToSaveContactBook() {
        return isEmptyFile(getFileToSaveContactBook());
    }

    //todo а не выделить ли из части кода отдельный метод? типа getBaseFileNameFromUser
    //todo может, строку-вопрос сделать константой в этом классе?
    public void prepareForWork() {
        InputFromConsole inFromConsole = new InputFromConsole();
        String message = "In which file do you want to store your contact book?\n" +
                "1 — into default file named \\'my_contacts\\' which placed on disc C\n" +
                "2 — I want to use another file";
        int choice = inFromConsole.getChoiceFromUser(message, 2);
        String fileName;
        switch (choice) {
            case 1:
                fileName = "my_contacts";
                break;
            case 2:
                fileName = inFromConsole.getInfoFromUser("Please, enter name of file, " +
                        "where your contacts will be saved.");
                break;
            default:
                throw new IllegalStateException();
        }

        setContactBook(createContactBook());
        setFileToSaveContactBook(createFileToSaveContactBook(fileName));
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
    public List<Contact> addNewContact(Contact contact) {
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

    public void showContacts() {
        OutputToConsole outToConsole = new OutputToConsole();
        ContactBookSerializer serializer = new ContactBookSerializer();

        outToConsole.printToConsole(serializer.turnIntoListOfStrings(getContactBook()));
    }

    //todo rewrite this method после смены коллекции!
    Contact findContact(String person) {
        Contact contact = null;
        return contact;
    }

    List<Contact> deleteContact(Contact contact) {
        //todo вызвать тут метод findContact, проверка на наличие контакта должна быть в методе findContact
        if (!contactBook.contains(contact)) {
            throw new NoSuchElementException();
        }
        contactBook.remove(contact);
        return contactBook;
    }

    //todo доделать метод
    public void uploadContactsFromFile(String fileName) {
        FileCreator creator = new FileCreator();
        File file = creator.createFile(fileName);
        if (isEmptyFile(file)) {

        }
    }

    public void downloadContactBookToFile(String fileName) throws IOException {
        if (contactBook.isEmpty()) {
            throw new IllegalStateException("This contact book contains no contacts. It won't be written in a file.");
        }
        File file = createFileToSaveContactBook(fileName);
        downloadContactsToFile(file);
    }
}
