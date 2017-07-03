public class PhoneNumberValidator implements Validator {
    public static final String PHONE_NUMBER_VALIDATORS_MESSAGE = "Your phone number contains improper characters " +
            "or has improper amount of numbers in it! Make sure that it has exact 9 number character.";

    public boolean isValid(String input) {
        String regex = "[\\d]{9}";
        return input.matches(regex);
    }
}