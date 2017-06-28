import java.util.List;

public class Contact {
    private Person person;
    private List<PhoneNumber> phoneNumbers;
    private EMail eMail;

    Contact(Person person, List<PhoneNumber> phoneNumbers, EMail eMail) {
        this.person = person;
        this.phoneNumbers = phoneNumbers;
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return person.toString() + "\n" + "Phone numbers: " + phoneNumbers + "\n" + eMail + "\n\n" ;
    }
}
