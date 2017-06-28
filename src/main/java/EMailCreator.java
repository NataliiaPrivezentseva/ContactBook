class EMailCreator {

    static EMail createNewEmail() {
        String eMail = Input.getInfoFromUser("e-mail");
        String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*" +
                "[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

        while (!eMail.matches(regex)) {
            System.out.println("Your e-mail contains improper characters! Please, enter proper e-mail");
            eMail = Input.getInfoFromUser("e-mail");
        }

        return new EMail(eMail);
    }
}
