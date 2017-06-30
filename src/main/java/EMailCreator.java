class EMailCreator {

    static EMail createNewEmail() {
        String eMail = Input.getInfoFromUser("e-mail");
        Validator checkEmail = new EmailValidator();

        while (!checkEmail.isValid(eMail)) {
            System.out.println("Your e-mail contains improper characters! Please, enter proper e-mail");
            eMail = Input.getInfoFromUser("e-mail");
        }

        return new EMail(eMail);
    }
}
