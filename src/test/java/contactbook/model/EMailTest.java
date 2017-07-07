package contactbook.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EMailTest {

    EMail eMail = new EMail("bob.frankly@gmail.com");

    @Test
    public void shouldProduceProperString(){
        String expected = "bob.frankly@gmail.com";
        assertEquals(expected, eMail.toString());
    }
}