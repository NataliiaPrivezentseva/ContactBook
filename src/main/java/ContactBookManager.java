import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class ContactBookManager {
    public static final String OPTIONS = "Please, choose what you want to do:\n" +
            "1 — Show contacts\n" +
            "2 — Add new contact\n" +
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

    List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        int stringsInOneContact = 4;
        int amountOfStrings = inputInStrings.size();
        int amountOfIterations = amountOfStrings / stringsInOneContact;
        List<Contact> contactBook = new ArrayList<>();
        int startOfContact = -4;
        while (amountOfIterations > 0) {
            contactBook.add(turnIntoContact(inputInStrings, startOfContact + 4));
            startOfContact += 4;
            amountOfIterations--;
        }
        //todo не присваивать тут значение contactBook, а присваивать его из возвращаемого значнеия метода
        this.contactBook = contactBook;
        return contactBook;
    }

    //todo Сделать его в отдельном классе
    Contact turnIntoContact(List<String> inputInStrings, int start) {
        String fieldNameSeparator = ": ";
        String elementsSeparator = ", ";

        String[] firstName = inputInStrings.get(start).split(fieldNameSeparator, 2);
        String[] lastName = inputInStrings.get(start + 1).split(fieldNameSeparator, 2);
        String[] eMail = inputInStrings.get(start + 3).split(fieldNameSeparator, 2);

        int firstIndex = inputInStrings.get(start + 2).indexOf("[") + 1;
        int lastIndex = inputInStrings.get(start + 2).indexOf("]");
        String numbersOfPhone = inputInStrings.get(start + 2).substring(firstIndex, lastIndex);
        String[] numbers = numbersOfPhone.split(elementsSeparator, 0);

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        for (String phoneNumber : numbers) {
            phoneNumbers.add(new PhoneNumber(phoneNumber));
        }

        return new Contact(new Person(firstName[1], lastName[1]), phoneNumbers, new EMail(eMail[1]));
    }

    List<Contact> addNewContactToBook(Contact contact) {
        if (contactBook == null) {
            contactBook = createContactBook();
        }

        List<String> existingContacts;
        InputFromFile inFromFile = new InputFromFile();
        try {
            existingContacts = inFromFile.readFromFile(fileToSaveContactBook);
            this.turnIntoContactBook(existingContacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (Contact existingContact : contactBook) {
//            String s = existingContact.toString();
//            existingContacts.add(s);
//        }

        contactBook.add(contact);
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
