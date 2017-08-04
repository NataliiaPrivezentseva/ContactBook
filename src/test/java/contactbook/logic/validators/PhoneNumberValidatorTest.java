package contactbook.logic.validators;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Theories.class)
public class PhoneNumberValidatorTest {

    private PhoneNumberValidator validator = new PhoneNumberValidator();

    @DataPoints("tooShortNumbers")
    public static String[] tooShortNumbers = {"", "1", "12", "123", "1234", "12345", "123456", "1234567", "12345678"};

    @DataPoints("numbersWithLetters")
    public static String[] numbersWithLetters = {"0155s4568", "254fsa8e4", "number123", "g2S4567LB", "I10O25789"};

    @DataPoints("numbersWithSpecialCharacters")
    public static String[] numbersWithSpecialCharacters = {"*12345678", "123@45678", "123456/78", "1234!5678"};

    @DataPoints("properPhoneNumbers")
    public static String[] properPhoneNumbers = {"095654875", "000000000", "123456789", "987654321"};


    @Theory
    public void testTooShortNumber(@FromDataPoints("tooShortNumbers")String phoneNumber){
        assertFalse(validator.isValid(phoneNumber));
    }

    @Test
    public void testTooLongNumber(){
        String tooLongNumber = "0123456789";
        assertFalse(validator.isValid(tooLongNumber));
    }

    @Theory
    public void testNumberWithLetters(@FromDataPoints("numbersWithLetters")String phoneNumber){
        assertFalse(validator.isValid(phoneNumber));
    }

    @Theory
    public void testNumberWithSpecialCharacters(@FromDataPoints("numbersWithSpecialCharacters")String phoneNumber){
        assertFalse(validator.isValid(phoneNumber));
    }

    @Theory
    public void testProperNumber(@FromDataPoints("properPhoneNumbers")String phoneNumber){
        assertTrue(validator.isValid(phoneNumber));
    }
}