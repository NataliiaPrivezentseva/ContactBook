package contactbook.logic.builders;

import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.model.Person;
import contactbook.model.PhoneNumber;

import java.util.List;

public class ContactBuilder {
    private Person person;
    private List<PhoneNumber> phoneNumbers;
    private EMail eMail;

    public ContactBuilder withPerson(Person person){
        this.person = person;
        return this;
    }

    public ContactBuilder withPhoneNumbers(List<PhoneNumber> phoneNumbers){
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public ContactBuilder withEMail(EMail eMail){
        this.eMail = eMail;
        return this;
    }

    public Contact build() {
        return new Contact(this.person, this.phoneNumbers, this.eMail);
    }
}
