package contactbook.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        final Contact other = (Contact) o;
        return Objects.equals(this.person, other.getPerson()) &&
                Objects.equals(this.phoneNumbers, other.getPhoneNumbers()) &&
                Objects.equals(this.eMail, other.getEMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.person, this.phoneNumbers, this.eMail);
    }
}
