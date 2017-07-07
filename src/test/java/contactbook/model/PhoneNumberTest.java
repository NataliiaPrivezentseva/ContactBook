package contactbook.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    private PhoneNumber number = new PhoneNumber("123456789");

    @Test
    public void shouldProduceProperString(){
        String expected = "123456789";
        assertEquals(expected, number.toString());
    }
}