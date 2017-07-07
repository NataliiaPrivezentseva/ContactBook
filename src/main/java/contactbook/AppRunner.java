package contactbook;

import contactbook.logic.controller.ContactBookManager;
import contactbook.logic.creators.ContactCreator;
import contactbook.ui.console.InputFromConsole;

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

    static void runApp() {
        ContactBookManager manager = new ContactBookManager();
        InputFromConsole inFromConsole = new InputFromConsole();

        manager.prepareForWork();
        int choice = inFromConsole.getChoiceFromUser(OPTIONS, 7);

        switch (choice) {
            case 1:
                manager.addNewContact(ContactCreator.createNewContact());
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
                switch (choice){
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

