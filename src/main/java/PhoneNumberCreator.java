import java.util.ArrayList;
import java.util.List;

class PhoneNumberCreator {

    // нужно вызвать этот метод из другого класса или сделать прайват
    static PhoneNumber createOnePhoneNumber() {
        Input in = new Input();
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
        Input in = new Input();
        int amount = in.getNumberFromUser("Please, enter, how many phone numbers has this person");
        for (int i = 0; i < amount; i++) {
            phoneNumbers.add(createOnePhoneNumber());
        }
        return phoneNumbers;
    }
}