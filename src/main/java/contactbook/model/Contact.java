package contactbook.model;

import java.util.List;

public class Contact {
    public static final int STRINGS_IN_ONE_CONTACT = 4;
    private Person person;
    private List<PhoneNumber> phoneNumbers;
    private EMail eMail;

    public Contact(Person person, List<PhoneNumber> phoneNumbers, EMail eMail) {
        this.person = person;
        this.phoneNumbers = phoneNumbers;
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return person.toString() + "\n" + "Phone numbers: " + phoneNumbers + "\nE-mail: " + eMail + "\n";
    }

    public Person getPerson() {
        return person;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public EMail getEMail() {
        return eMail;
    }
}
