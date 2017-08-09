package contactbook.logic.controller;

import contactbook.model.Contact;
import contactbook.persistence.de_serialization.ContactBookDeserialiser;
import contactbook.persistence.de_serialization.ContactBookSerializer;
import contactbook.persistence.de_serialization.ContactDeserialiser;
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

    private FileCreator fileCreator = new FileCreator();
    private InputFromConsole inFromConsole = new InputFromConsole();
    private InputFromFile inFromFile = new InputFromFile();
    private OutputToConsole outToConsole = new OutputToConsole();
    private OutputToFile outToFile = new OutputToFile();
    private ContactBookDeserialiser deserialiser = new ContactBookDeserialiser(new ContactDeserialiser());
    private ContactBookSerializer serializer = new ContactBookSerializer();

    private List<Contact> getContactBook() {
        return contactBook;
    }

    public void setContactBook(List<Contact> contactBook) {
        this.contactBook = contactBook;
    }

    private File getFileToSaveContactBook() {
        return fileToSaveContactBook;
    }

    public void setFileToSaveContactBook(File fileToSaveContactBook) {
        this.fileToSaveContactBook = fileToSaveContactBook;
    }

    private List<Contact> createContactBook() {
        return new ArrayList<>();
    }

    private File createFileToSaveContactBook(String fileName) {
        return fileCreator.createFile(fileName);
    }

    private boolean isEmptyFile(File file) {
        return file.length() == 0;
    }

    private boolean isEmptyFileToSaveContactBook() {
        return isEmptyFile(getFileToSaveContactBook());
    }

    //todo а не выделить ли из части кода отдельный метод? типа getBaseFileNameFromUser
    //todo может, строку-вопрос сделать константой в этом классе?
    public void prepareForWork() {
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
                List<Contact> contactsFromFile = uploadContactsFromFile(getFileToSaveContactBook());
                setContactBook(contactsFromFile);
            } catch (IOException e) {
                System.out.println("Something wrong with the file, in which you keep your contact book");
            }
        } else {
            System.out.println("Your contact book contains no contacts.");
        }
    }

    private List<Contact> uploadContactsFromFile(File file) throws IOException {
        return deserialiser.turnIntoContactBook(inFromFile.readFromFile(file));
    }

    private void downloadContactsToFile(File file) throws IOException {
        List<String> contactsInString = serializer.turnIntoListOfStrings(getContactBook());
        outToFile.writeToFile(contactsInString, file);
    }

    //todo пробросить исключение еще выше, лучше обрабатывать в AppRunner
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

    //todo подумать, какой Exception выбросить
    //todo методы загрузки в файл везде - параметры?
    public List<Contact> uploadExistingContactsToContactBook(String fileName) throws IOException {
        File file = fileCreator.createFile(fileName);
        if (isEmptyFile(file)) {
            throw new IllegalStateException("This file contains no contacts.");
        }
        List<Contact> newContacts = uploadContactsFromFile(file);
        for (Contact contact : newContacts) {
            addNewContact(contact);
        }
        return getContactBook();
    }

    public void downloadContactBookToFile(String fileName) throws IOException {
        if (contactBook.isEmpty()) {
            throw new IllegalStateException("This contact book contains no contacts. It won't be written in a file.");
        }
        File file = createFileToSaveContactBook(fileName);
        downloadContactsToFile(file);
    }
}
