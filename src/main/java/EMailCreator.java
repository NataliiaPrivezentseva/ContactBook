class EMailCreator {

    static EMail createNewEmail() {
        Input in = new Input();
        String eMail = in.getInfoFromUser("e-mail");
        Validator checkEmail = new EmailValidator();

        while (!checkEmail.isValid(eMail)) {
            System.out.println(EmailValidator.EMAIL_VALIDATORS_MESSAGE);
            eMail = in.getInfoFromUser("e-mail");
        }
        return new EMail(eMail);
    }
}