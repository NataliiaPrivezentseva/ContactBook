package contactbook.logic.creators;

import contactbook.logic.validators.EmailValidator;
import contactbook.logic.validators.Validator;
import contactbook.ui.console.InputFromConsole;
import contactbook.model.EMail;

class EMailCreator {

    static EMail createNewEmail() {
        InputFromConsole outToConsole = new InputFromConsole();
        String eMail = outToConsole.getInfoFromUser("e-mail");
        Validator checkEmail = new EmailValidator();

        while (!checkEmail.isValid(eMail)) {
            System.out.println(EmailValidator.EMAIL_VALIDATORS_MESSAGE);
            eMail = outToConsole.getInfoFromUser("e-mail");
        }
        return new EMail(eMail);
    }
}