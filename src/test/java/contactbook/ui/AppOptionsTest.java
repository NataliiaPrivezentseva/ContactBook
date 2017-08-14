package contactbook.ui;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppOptionsTest {

    private String[] allOptions = {"1 — Add new contact",
            "2 — Show contacts",
            "3 — Find contact",
            "4 — Edit contact",
            "5 — Delete contact",
            "6 — Upload contacts from file",
            "7 — Download contact book to file"};

    private AppOptions[] optionsFromEnum = AppOptions.values();


    @Test
    public void shouldReturnWithOrdinal() {
        for (int i = 0; i < allOptions.length; i++) {
            assertEquals(allOptions[i], optionsFromEnum[i].toString());
        }
    }

    @Test
    public void shouldConvertOrdinal() {
        for (int i = 0; i < allOptions.length; i++) {
            assertEquals(AppOptions.fromInteger(i + 1), optionsFromEnum[i]);
        }
    }
}