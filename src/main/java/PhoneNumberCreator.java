import java.util.ArrayList;
import java.util.List;

class PhoneNumberCreator {

    @SuppressWarnings("WeakerAccess")
    static PhoneNumber createOnePhoneNumber() {
        String phoneNumber = Input.getInfoFromUser("phone number");
        Validator checkPhoneNumber = new PhoneNumberValidator();

        while (!checkPhoneNumber.isValid(phoneNumber)) {
            // need to change message for user: number should consists of 9 characters
            System.out.println("Your phone number contains improper characters" +
                    "or has improper amount of numbers in it! Make sure that it has exact 9 number character.");
            phoneNumber = Input.getInfoFromUser("phone number");
        }

        return new PhoneNumber(phoneNumber);
    }

    static List<PhoneNumber> createNewListOfPersonsPhoneNumbers() {
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        int amount = Input.getNumberFromUser("Please, enter, how many phone numbers has this person");
        for (int i = 0; i < amount; i++) {
            phoneNumbers.add(createOnePhoneNumber());
        }
        return phoneNumbers;
    }
}
