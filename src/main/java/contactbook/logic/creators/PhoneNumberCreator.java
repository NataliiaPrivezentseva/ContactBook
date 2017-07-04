package contactbook.logic.creators;

import contactbook.logic.validators.PhoneNumberValidator;
import contactbook.logic.validators.Validator;
import contactbook.ui.console.InputFromConsole;
import contactbook.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

class PhoneNumberCreator {

    //todo нужно вызвать этот метод из другого класса или сделать прайват
    static PhoneNumber createOnePhoneNumber() {
        InputFromConsole in = new InputFromConsole();
        String phoneNumber = in.getInfoFromUser("phone number");
        Validator checkPhoneNumber = new PhoneNumberValidator();

        while (!checkPhoneNumber.isValid(phoneNumber)) {
            System.out.println(PhoneNumberValidator.PHONE_NUMBER_VALIDATORS_MESSAGE);
            phoneNumber = in.getInfoFromUser("phone number");
        }
        return new PhoneNumber(phoneNumber);
    }

    static List<PhoneNumber> createNewListOfPersonsPhoneNumbers() {
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        InputFromConsole inFromConsole = new InputFromConsole();
        int amount = inFromConsole.getNumberFromUser("Please, enter, how many phone numbers has this person");
        for (int i = 0; i < amount; i++) {
            phoneNumbers.add(createOnePhoneNumber());
        }
        return phoneNumbers;
    }
}