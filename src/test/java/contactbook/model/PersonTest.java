package contactbook.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person = new Person("Ray", "Bradbury");

    @Test
    public void shouldProduceProperString(){
        String expected = "First name: Ray\nLast name: Bradbury\n";
        assertEquals(expected, person.toString());
    }
}