package contactbook;

import contactbook.logic.builders.ContactBuilder;
import contactbook.logic.builders.PersonBuilder;
import contactbook.logic.controller.ContactBookManager;
import contactbook.logic.creators.PhoneNumbersListCreator;
import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.ui.console.EMailGetter;
import contactbook.ui.console.InputFromConsole;
import contactbook.ui.console.PhoneNumberGetter;

import java.io.IOException;

class AppRunner {
    private static final String OPTIONS = "Please, choose what you want to do:\n" +
            "1 — Add new contact\n" +
            "2 — Show contacts\n" +
            "3 — Find contact\n" +
            "4 — Edit contact\n" +
            "5 — Delete contact\n" +
            "6 — Upload contacts from file\n" +
            "7 — Download contact book to file\n";
    private static final String EDIT_OPTIONS = "Choose, what do you want to do with chosen contact:\n" +
            "1 — Change first name\n" +
            "2 — Change last name\n" +
            "3 — Change phone number\n" +
            "4 — Change e-mail\n" +
            "5 — Add new phone number\n" +
            "6 — Add e-mail (only if field is empty)\n" +
            "7 — Delete phone number\n" +
            "8 — Delete e-mail";
    private ContactBookManager manager = new ContactBookManager();
    private InputFromConsole inFromConsole = new InputFromConsole();
    private EMailGetter eMailGetter = new EMailGetter();
    private PhoneNumbersListCreator phoneNumbersListCreator = new PhoneNumbersListCreator(new PhoneNumberGetter());

    void runApp() {
        manager.prepareForWork();
        int choice = inFromConsole.getChoiceFromUser(OPTIONS, 7);

        switch (choice) {
            case 1:
                //todo сделать это методом в классе ContactCreator
                Contact contact = new ContactBuilder()
                        .withPerson(new PersonBuilder()
                                .withFirstName(inFromConsole.getInfoFromUser("first name"))
                                .withLastName(inFromConsole.getInfoFromUser("last name"))
                                .build())
                        .withPhoneNumbers(phoneNumbersListCreator
                                .createNewListOfPersonsPhoneNumbers(inFromConsole
                                        .getNumberFromUser("Please, enter, how many phone numbers has this person")))
                        .withEMail(new EMail(eMailGetter.getProperEMailFromUser()))
                        .build();

                manager.addNewContact(contact);
                break;
            case 2:
                manager.showContacts();
                break;
            case 3:
                break;
            case 4:
                choice = inFromConsole.getChoiceFromUser(EDIT_OPTIONS, 8);
                switch (choice) {
                    case 1:
                        System.out.println("I work!");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    default:
                        throw new IllegalStateException();
                }
                break;
            case 5:
                break;
            case 6:
                String options = "How do you want upload contacts from file?\n" +
                        "1 — Add contacts to existing contact book\n" +
                        "2 — Replace existing contacts. " +
                        "ATTENTION! If you choose this option, your current contacts will be lost!\n";
                choice = inFromConsole.getChoiceFromUser(options, 2);
                switch (choice) {
                    case 1:
                        //todo уточнить вызов этого метода после окончания работы с методом
                        try {
                            manager.uploadExistingContactsToContactBook(inFromConsole.getInfoFromUser("name of the " +
                                    "file, from which you want to upload contacts."));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        break;
                    default:
                        throw new IllegalStateException();
                }
                break;
            case 7:
                try {
                    manager.downloadContactBookToFile(inFromConsole.getInfoFromUser("name of the file, " +
                            "where you want to download your contact book."));
                } catch (IOException e) {
                    System.out.println("Something wrong with the file, in which you want to download " +
                            "your contact book");
                }
                break;
            default:
                throw new IllegalStateException();
        }
    }
}