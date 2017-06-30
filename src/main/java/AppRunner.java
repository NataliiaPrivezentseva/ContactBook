import java.io.File;
import java.io.IOException;
import java.util.List;

public class AppRunner {

    static void runApp() {

        // code that reads from file and outputs it to console
        File fileToRead = new File("c:\\" + Input.getInfoFromUser("name of file, where your contacts" +
                " are saved") + ".txt");
        try {
            List<String> inputInStrings = Input.readFromFile(fileToRead);
            OutputToConsole.printToConsole(inputInStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }

        choseAction();

//        File book = ContactBookManager.createNewContactBook(Input.getInfoFromUser("name of contact book"));
//        try {
//            ContactBookManager.addNewContactToBook(ContactCreator.createNewContact(), book);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        OutputToFile.printToConsole(book);

    }

    private static void choseAction() {
        int choice;
        do {
            choice = Input.getNumberFromUser("Please, choose what you want to do:\n" +
                    "1 — Create new contact and add it into new contact book\n" +
                    "2 — Create new contact, add it into new contact book, save contact book in a file\n" +
                    "3 — Create new contact book, create new contact and add to book, than add second contact, " +
                    "save book to file and print it\n");

            if (choice > 3) {
                System.out.println("\'" + choice + "\' is not proper choice! Try again!");
            }

        } while (choice > 3);

//        List<Contact> contactBook = null;
        switch (choice) {
            case 1:
                ContactBookManager.addNewContactToBook(ContactCreator.createNewContact(),
                        ContactBookManager.createContactBook());
                break;
            case 2:
                ContactBookManager.saveBookIntoFile(ContactBookManager.addNewContactToBook
                        (ContactCreator.createNewContact(), ContactBookManager.createContactBook()));
                break;
            case 3:
                break;
            default:
        }
    }


}

