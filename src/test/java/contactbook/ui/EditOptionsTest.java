package contactbook.ui;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditOptionsTest {

    private String[] allOptions = {"1 — Change first name",
            "2 — Change last name",
            "3 — Change phone number",
            "4 — Change e-mail",
            "5 — Add new phone number",
            "6 — Add e-mail (only if field is empty)",
            "7 — Delete phone number",
            "8 — Delete e-mail"};

    private EditOptions[] optionsFromEnum = EditOptions.values();


    @Test
    public void shouldReturnWithOrdinal(){
        for (int i = 0; i < allOptions.length; i++) {
            assertEquals(allOptions[i], optionsFromEnum[i].toString());
        }
    }

    @Test
    public void shouldConvertOrdinal(){
        for (int i = 0; i < allOptions.length; i++) {
            assertEquals(EditOptions.fromInteger(i + 1), optionsFromEnum[i]);
        }
    }
}