package contactbook;

import contactbook.logic.controller.ContactBookManager;
import contactbook.logic.creators.ContactCreator;
import contactbook.ui.AppOptions;
import contactbook.ui.EditOptions;
import contactbook.ui.console.InputFromConsole;
import contactbook.ui.console.MessageForUserCreator;

import java.io.IOException;

class AppRunner {
    private ContactBookManager manager = new ContactBookManager();
    private InputFromConsole inFromConsole = new InputFromConsole();
    private MessageForUserCreator messageForUserCreator = new MessageForUserCreator();
    private ContactCreator contactCreator = new ContactCreator();

    void runApp() {
        manager.prepareForWork();
        String messageForUser = messageForUserCreator
                .createMessageFromEnum("Please, choose what you want to do:", AppOptions.values());
        int choice = inFromConsole.getChoiceFromUser(messageForUser, 7);
        AppOptions chosenOption = AppOptions.fromInteger(choice);

        switch (chosenOption) {
            case ADD_CONTACT:
                manager.addNewContact(contactCreator.createNewContact());
                break;
            case SHOW_CONTACTS:
                manager.showContacts();
                break;
            case FIND_CONTACT:
                break;
            case EDIT_CONTACT:
                String message = messageForUserCreator
                        .createMessageFromEnum("Choose, what do you want to do with chosen contact:",
                                EditOptions.values());
                choice = inFromConsole.getChoiceFromUser(message, 8);
                EditOptions chosenEditOption = EditOptions.fromInteger(choice);

                switch (chosenEditOption) {
                    case CHANGE_FIRST_NAME:
                        break;
                    case CHANGE_LAST_NAME:
                        break;
                    case CHANGE_PHONE_NUMBER:
                        break;
                    case CHANGE_EMAIL:
                        break;
                    case ADD_PHONE_NUMBER:
                        break;
                    case ADD_EMAIL:
                        break;
                    case DELETE_PHONE_NUMBER:
                        break;
                    case DELETE_EMAIL:
                        break;
                    default:
                        throw new IllegalStateException();
                }
                break;
            case DELETE_CONTACT:
                break;
            case UPLOAD_CONTACTS:
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
            case DOWNLOAD_CONTACTS:
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