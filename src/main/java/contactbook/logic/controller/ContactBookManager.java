package contactbook.logic.controller;

import contactbook.model.Contact;
import contactbook.persistence.de_serialization.ContactBookDeserialiserFromListOfStrings;
import contactbook.persistence.de_serialization.ContactBookDeserializer;
import contactbook.persistence.de_serialization.ContactBookDeserializerFromJSON;
import contactbook.persistence.de_serialization.ContactBookSerializer;
//import contactbook.persistence.de_serialization.ContactBookSerializerToJSON;
import contactbook.persistence.de_serialization.ContactBookSerializerToListOfStrings;
import contactbook.persistence.de_serialization.ContactDeserialiser;
import contactbook.persistence.file.FileCreator;
import contactbook.persistence.file.InputFromFile;
import contactbook.persistence.file.OutputToFile;
import contactbook.ui.FileOptions;
import contactbook.ui.console.InputFromConsole;
import contactbook.ui.console.MessageForUserCreator;
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
    private MessageForUserCreator messageForUserCreator = new MessageForUserCreator();

    private InputFromConsole inFromConsole = new InputFromConsole();
    private InputFromFile inFromFile = new InputFromFile();
    private OutputToConsole outToConsole = new OutputToConsole();
    private OutputToFile outToFile = new OutputToFile();

//    private ContactBookDeserializer deserialiser = new ContactBookDeserializerFromJSON();
//    private ContactBookSerializer serializer = new ContactBookSerializerToJSON();

    private ContactBookDeserializer deserialiser = new ContactBookDeserialiserFromListOfStrings(new ContactDeserialiser());
    private ContactBookSerializer serializer = new ContactBookSerializerToListOfStrings();

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

    public void prepareForWork() {
        setContactBook(createContactBook());
        setFileToSaveContactBook(createFileToSaveContactBook(getNameOfStoringFileFromUser()));

        if (!isEmptyFileToSaveContactBook()) {
            try {
                List<Contact> contactsFromFile = uploadContactsFromFile(getFileToSaveContactBook());
                setContactBook(contactsFromFile);
            } catch (IOException e) {
                System.out.println("Something wrong with the file, in which you keep your contact book.");
            }
        } else {
            System.out.println("Your contact book contains no contacts.");
        }
    }

    private String getNameOfStoringFileFromUser() {
        String messageForUser = messageForUserCreator
                .createMessageFromEnum("In which file do you want to store your contact book?",
                        FileOptions.values());

        int choice = inFromConsole.getChoiceFromUser(messageForUser, 2);
        FileOptions chosenOption = FileOptions.fromInteger(choice);
        switch (chosenOption) {
            case DEFAULT:
                return "my_contacts";
            case CUSTOM:
                return inFromConsole.getInfoFromUser("Please, enter name of file, where your contacts will be saved.");
            default:
                throw new IllegalStateException();
        }
    }

    private List<Contact> uploadContactsFromFile(File file) throws IOException {
        return deserialiser.turnIntoContactBook(inFromFile.readFromFile(file));
    }

    private void downloadContactsToFile(File file) throws IOException {
//        List<String> contactsInString = serializer.turnIntoListOfStrings(getContactBook());
        String contactsInString = serializer.turnIntoListOfStrings(getContactBook());
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
        // NO! JUST DELETE, IF EXIST
        // вывести пользователю сообщение, что контакт не был удален, т.к. такого контакта нет в списке
        // удалять контакт надо по Person
        if (!contactBook.contains(contact)) {
            throw new NoSuchElementException();
        }
        contactBook.remove(contact);
        return contactBook;
    }

    //todo подумать, какой Exception выбросить
    //todo методы загрузки в файл везде - параметры? - о чем это я?
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
