package contactbook.logic.validators;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberValidatorTest {

    @Test
    public void testTooShortNumber(){
        String tooShortNumber = "12345";
        PhoneNumberValidator validator = new PhoneNumberValidator();

        assertFalse(validator.isValid(tooShortNumber));
    }

    @Test
    public void testTooLongNumber(){
        String tooLongNumber = "0123456789";
        PhoneNumberValidator validator = new PhoneNumberValidator();

        assertFalse(validator.isValid(tooLongNumber));
    }

    @Test
    public void testNumberWithLetters(){
        String numberWithLetters = "0155s4568";
        PhoneNumberValidator validator = new PhoneNumberValidator();

        assertFalse(validator.isValid(numberWithLetters));
    }

    @Test
    public void testNumberWithSpecialCharacters(){
        String numberWithSpecialCharacters = "*12345678";
        String numberWithSpecialCharacters1 = "123@45678";
        String numberWithSpecialCharacters2 = "123456/78";

        PhoneNumberValidator validator = new PhoneNumberValidator();

        assertFalse(validator.isValid(numberWithSpecialCharacters));
        assertFalse(validator.isValid(numberWithSpecialCharacters1));
        assertFalse(validator.isValid(numberWithSpecialCharacters2));
    }

    @Test
    public void testProperNumber(){
        String phoneNumber = "095654875";
        String phoneNumber1 = "000000000";
        String phoneNumber2 = "123456789";

        PhoneNumberValidator validator = new PhoneNumberValidator();

        assertTrue(validator.isValid(phoneNumber));
        assertTrue(validator.isValid(phoneNumber1));
        assertTrue(validator.isValid(phoneNumber2));
    }
}