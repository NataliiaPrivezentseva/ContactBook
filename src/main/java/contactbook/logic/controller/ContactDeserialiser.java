package contactbook.logic.controller;

import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.model.Person;
import contactbook.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class ContactDeserialiser {

    Contact turnIntoContact(List<String> inputInStrings, int start) {
        String fieldNameSeparator = ": ";
        String elementsSeparator = ", ";

        String[] firstName = inputInStrings.get(start).split(fieldNameSeparator, 2);
        String[] lastName = inputInStrings.get(start + 1).split(fieldNameSeparator, 2);
        String[] eMail = inputInStrings.get(start + 3).split(fieldNameSeparator, 2);

        int firstIndex = inputInStrings.get(start + 2).indexOf("[") + 1;
        int lastIndex = inputInStrings.get(start + 2).indexOf("]");
        String numbersOfPhone = inputInStrings.get(start + 2).substring(firstIndex, lastIndex);
        String[] numbers = numbersOfPhone.split(elementsSeparator, 0);

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        for (String phoneNumber : numbers) {
            phoneNumbers.add(new PhoneNumber(phoneNumber));
        }

        return new Contact(new Person(firstName[1], lastName[1]), phoneNumbers, new EMail(eMail[1]));
    }
}
