package contactbook.ui.console;


import contactbook.logic.validators.PhoneNumberValidator;
import contactbook.logic.validators.Validator;

public class PhoneNumberGetter {

    private InputFromConsole inFromConsole = new InputFromConsole();
    private Validator checkPhoneNumber = new PhoneNumberValidator();

    public String getProperPhoneNumberFromUser(){
        String phoneNumber = inFromConsole.getInfoFromUser("phone number");

        while (!checkPhoneNumber.isValid(phoneNumber)){
            System.out.println(PhoneNumberValidator.PHONE_NUMBER_VALIDATORS_MESSAGE);
            phoneNumber = inFromConsole.getInfoFromUser("phone number");
        }

        return phoneNumber;
    }
}
