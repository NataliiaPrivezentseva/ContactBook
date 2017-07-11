package contactbook.logic.validators;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    private EmailValidator validator = new EmailValidator();

    @Test
    public void testProperEMail(){
        String eMail = "asterisk0123456789@gmail.com";
        String eMail1 = "k.smith@letters.no";
        String eMail2 = "mother_tereza@not.here";
        String eMail3 = "Mike@hot.there";
        String eMail4 = "not-I@i.ua";
        String eMail5 = "eric.monte-carlo@Adjos55.amigo3";

        assertTrue(validator.isValid(eMail));
        assertTrue(validator.isValid(eMail1));
        assertTrue(validator.isValid(eMail2));
        assertTrue(validator.isValid(eMail3));
        assertTrue(validator.isValid(eMail4));
        assertTrue(validator.isValid(eMail5));
    }

    @Test
    public void testEMailWithMoreThanOneMonkey(){
        String eMail = "tata@@gmail.com";
        String eMail1 = "@mama@gmail.com";
        String eMail2 = "sister@gmail@.com";
        String eMail3 = "tree@@@monkey.com";

        assertFalse(validator.isValid(eMail));
        assertFalse(validator.isValid(eMail1));
        assertFalse(validator.isValid(eMail2));
        assertFalse(validator.isValid(eMail3));
    }

    @Test
    public void testEMailWithSpecialCharacters(){
        String eMail = "Tim:Roth@big.stars";
        String eMail1 = "Tim,Roth@big.stars";
        String eMail2 = "Tim.Roth@big,stars";
        String eMail3 = "Tim.Roth@big:stars";
        String eMail4 = "Tim;Roth@big;stars";
        String eMail5 = "!#$%&'*+/=?^`{|}~@yandex.ru";

        assertFalse(validator.isValid(eMail));
        assertFalse(validator.isValid(eMail1));
        assertFalse(validator.isValid(eMail2));
        assertFalse(validator.isValid(eMail3));
        assertFalse(validator.isValid(eMail4));
        assertFalse(validator.isValid(eMail5));
    }
}