public class PhoneNumberValidator implements Validator {

    public boolean isValid(String input) {
        String regex = "[\\d]{9}";
        return input.matches(regex);
    }
}
