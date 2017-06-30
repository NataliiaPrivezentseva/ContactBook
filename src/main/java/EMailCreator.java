class EMailCreator {

    static EMail createNewEmail() {
        Input in = new Input();
        String eMail = in.getInfoFromUser("e-mail");
        String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*" +
                "[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

        while (!eMail.matches(regex)) {
            System.out.println("Your e-mail contains improper characters! Please, enter proper e-mail");
            eMail = in.getInfoFromUser("e-mail");
        }

        return new EMail(eMail);
    }
}
