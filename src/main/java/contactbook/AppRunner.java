package contactbook;

import contactbook.logic.controller.ContactBookManager;
import contactbook.logic.creators.ContactCreator;
import contactbook.ui.console.InputFromConsole;

class AppRunner {

    static void runApp() {
        ContactBookManager manager = new ContactBookManager();

        InputFromConsole inFromConsole = new InputFromConsole();
//        contactbook.persistence.file.InputFromFile inFromFile = new contactbook.persistence.file.InputFromFile();
//        OutputToConsole outToConsole = new OutputToConsole();
//        OutputToFile outToFile = new OutputToFile();

        int choice = inFromConsole.getChoiceFromUser(ContactBookManager.OPTIONS, 7);

        manager.prepareForWork();

        switch (choice) {
            case 1:
                manager.addNewContactToBook(ContactCreator.createNewContact());
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
            default:
                throw new IllegalStateException();
        }
    }
}

