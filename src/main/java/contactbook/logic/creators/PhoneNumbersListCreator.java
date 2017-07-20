package contactbook.logic.creators;

import contactbook.model.PhoneNumber;
import contactbook.ui.console.PhoneNumberGetter;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumbersListCreator {
    private PhoneNumberGetter phoneNumberGetter;

    public PhoneNumbersListCreator(PhoneNumberGetter phoneNumberGetter) {
        this.phoneNumberGetter = phoneNumberGetter;
    }

    public List<PhoneNumber> createNewListOfPersonsPhoneNumbers(int amountOfPhoneNumbers) {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        for (int i = 0; i < amountOfPhoneNumbers; i++) {
            phoneNumbers.add(new PhoneNumber(phoneNumberGetter.getProperPhoneNumberFromUser()));
        }
        return phoneNumbers;
    }
}