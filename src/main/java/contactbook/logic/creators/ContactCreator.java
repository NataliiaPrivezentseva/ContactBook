package contactbook.logic.creators;

import contactbook.model.Contact;

public class ContactCreator {

    public static Contact createNewContact() {
        return new Contact(PersonCreator.createNewPerson(), PhoneNumberCreator.createNewListOfPersonsPhoneNumbers(),
                EMailCreator.createNewEmail());
    }
}