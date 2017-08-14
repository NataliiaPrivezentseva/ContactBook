package contactbook.logic.creators;

import contactbook.logic.builders.ContactBuilder;
import contactbook.logic.builders.PersonBuilder;
import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.ui.console.EMailGetter;
import contactbook.ui.console.InputFromConsole;
import contactbook.ui.console.PhoneNumberGetter;

public class ContactCreator {
    private InputFromConsole inFromConsole = new InputFromConsole();
    private PhoneNumbersListCreator phoneNumbersListCreator = new PhoneNumbersListCreator(new PhoneNumberGetter());
    private EMailGetter eMailGetter = new EMailGetter();

    public Contact createNewContact(){
        return new ContactBuilder()
                .withPerson(new PersonBuilder()
                        .withFirstName(inFromConsole.getInfoFromUser("first name"))
                        .withLastName(inFromConsole.getInfoFromUser("last name"))
                        .build())
                .withPhoneNumbers(phoneNumbersListCreator
                        .createNewListOfPersonsPhoneNumbers(inFromConsole
                                .getNumberFromUser("Please, enter, how many phone numbers has this person")))
                .withEMail(new EMail(eMailGetter.getProperEMailFromUser()))
                .build();
    }
}
