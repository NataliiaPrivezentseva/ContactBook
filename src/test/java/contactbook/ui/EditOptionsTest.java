package contactbook.ui;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditOptionsTest {

    //    private static final String EDIT_OPTIONS = "Choose, what do you want to do with chosen contact:\n" +
//            "1 — Change first name\n" +
//            "2 — Change last name\n" +
//            "3 — Change phone number\n" +
//            "4 — Change e-mail\n" +
//            "5 — Add new phone number\n" +
//            "6 — Add e-mail (only if field is empty)\n" +
//            "7 — Delete phone number\n" +
//            "8 — Delete e-mail";

    @Test
    public void shouldReturnWithOrdinal(){
        assertEquals("3 — Change phone number", EditOptions.CHANGE_PHONE_NUMBER.toString());
    }

    @Test
    public void shouldConvertOrdinal(){
        assertEquals(EditOptions.fromInteger(2), EditOptions.CHANGE_LAST_NAME);
    }
}