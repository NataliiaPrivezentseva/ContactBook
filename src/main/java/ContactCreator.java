class ContactCreator {

    static Contact createNewContact() {
        return new Contact(PersonCreator.createNewPerson(), PhoneNumberCreator.createNewListOfPersonsPhoneNumbers(),
                EMailCreator.createNewEmail());
    }
}