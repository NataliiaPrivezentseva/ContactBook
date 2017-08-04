package contactbook.ui.console;

import contactbook.logic.validators.EmailValidator;
import contactbook.logic.validators.Validator;

public class EMailGetter {
    private InputFromConsole inFromConsole = new InputFromConsole();
    private Validator checkEmail = new EmailValidator();

    public String getProperEMailFromUser(){
        String eMail = inFromConsole.getInfoFromUser("e-mail");

        while (!checkEmail.isValid(eMail)){
            System.out.println(EmailValidator.EMAIL_VALIDATORS_MESSAGE);
            eMail = inFromConsole.getInfoFromUser("e-mail");
        }

        return eMail;
    }
}
