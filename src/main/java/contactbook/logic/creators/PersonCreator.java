package contactbook.logic.creators;

import contactbook.ui.console.InputFromConsole;
import contactbook.model.Person;

class PersonCreator {

    static Person createNewPerson() {
        InputFromConsole outToConsole = new InputFromConsole();
        return new Person(outToConsole.getInfoFromUser("first name"), outToConsole.getInfoFromUser("last name"));
    }
}
