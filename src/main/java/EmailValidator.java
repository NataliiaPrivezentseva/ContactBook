public class EmailValidator implements Validator {
    public static final String EMAIL_VALIDATORS_MESSAGE =
            "Your e-mail contains improper characters! Please, enter proper e-mail";

    public boolean isValid(String input) {
        String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*" +
                "[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        return input.matches(regex);
    }
}