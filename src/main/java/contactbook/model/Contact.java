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
        return person.toString() + "Phone numbers: " + phoneNumbers + "\nE-mail: " + eMail + "\n";
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

    // тут ли надо переопределить, чтобы починить тест? Как переопределить?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (!person.equals(contact.person)) return false;
        if (!phoneNumbers.equals(contact.phoneNumbers)) return false;
        if (!eMail.equals(contact.eMail)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = person.hashCode();
        result = 31 * result + phoneNumbers.hashCode();
        result = 31 * result + eMail.hashCode();
        return result;
    }
}
