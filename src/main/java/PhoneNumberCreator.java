import java.util.ArrayList;
import java.util.List;

class PhoneNumberCreator {

    @SuppressWarnings("WeakerAccess")
    static PhoneNumber createOnePhoneNumber() {
        String phoneNumber = Input.getInfoFromUser("phone number");
        String regex = "[\\d]{9}";

        while (!phoneNumber.matches(regex)) {
            System.out.println("Your phone number contains improper characters!");
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
