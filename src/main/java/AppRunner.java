class AppRunner {

    static void runApp() {
        ContactBookManager manager = new ContactBookManager();

        InputFromConsole inFromConsole = new InputFromConsole();
//        InputFromFile inFromFile = new InputFromFile();
//        OutputToConsole outToConsole = new OutputToConsole();
//        OutputToFile outToFile = new OutputToFile();

        int choice = inFromConsole.getChoiceFromUser(ContactBookManager.OPTIONS, 7);

        manager.setContactBook(manager.createContactBook());
        manager.setFileToSaveContactBook(manager.createFileToSaveContactBook());

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

