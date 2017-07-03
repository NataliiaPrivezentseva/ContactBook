class EMailCreator {

    static EMail createNewEmail() {
        String eMail = Input.getInfoFromUser("e-mail");
        Validator checkEmail = new EmailValidator();

        while (!checkEmail.isValid(eMail)) {
            System.out.println(EmailValidator.EMAIL_VALIDATORS_MESSAGE);
            eMail = Input.getInfoFromUser("e-mail");
        }

        return new EMail(eMail);
    }
}