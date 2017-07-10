package contactbook.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private String firstName = "Ray";
    private String lastName = "Bradbury";
    private Person person = new Person(firstName, lastName);

    @Test
    public void shouldProduceProperString(){
        String expected = "First name: Ray\nLast name: Bradbury\n";
        assertEquals(expected, person.toString());
    }

    @Test
    public void shouldReturnFirstName(){
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    public void shouldReturnLastName(){
        assertEquals(lastName, person.getLastName());
    }
}