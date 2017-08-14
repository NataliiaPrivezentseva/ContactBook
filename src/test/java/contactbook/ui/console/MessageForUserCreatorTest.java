package contactbook.ui.console;

import contactbook.ui.AppOptions;
import contactbook.ui.EditOptions;
import contactbook.ui.FileOptions;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageForUserCreatorTest {

    private MessageForUserCreator messageCreator = new MessageForUserCreator();


    @Test
    public void shouldCreateMessageFromEnum(){
        String messageFromFileOptions = "In which file do you want to store your contact book?\n" +
                "1 — into default file named 'my_contacts' which placed on disc C\n" +
                "2 — I want to use another file";
        String messageFromAppOptions = "Please, choose what you want to do:\n" +
                "1 — Add new contact\n2 — Show contacts\n3 — Find contact\n" +
                "4 — Edit contact\n5 — Delete contact\n6 — Upload contacts from file\n" +
                "7 — Download contact book to file";
        String messageFromEditOptions = "Choose, what do you want to do with chosen contact:\n" +
                "1 — Change first name\n2 — Change last name\n3 — Change phone number\n" +
                "4 — Change e-mail\n5 — Add new phone number\n6 — Add e-mail (only if field is empty)\n" +
                "7 — Delete phone number\n8 — Delete e-mail";

        assertEquals(messageFromFileOptions, messageCreator
                .createMessageFromEnum("In which file do you want to store your contact book?",
                FileOptions.values()));
        assertEquals(messageFromAppOptions, messageCreator
                .createMessageFromEnum("Please, choose what you want to do:",
                AppOptions.values()));
        assertEquals(messageFromEditOptions, messageCreator
                .createMessageFromEnum("Choose, what do you want to do with chosen contact:",
                        EditOptions.values()));
    }
}