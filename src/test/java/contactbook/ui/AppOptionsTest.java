package contactbook.ui;

import contactbook.ui.AppOptions;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class AppOptionsTest {

   //todo check all values of Enum
/*    @DataPoints("appOptions")
    public static String[] allOptions = {"1 — Add new contact",
            "2 — Show contacts",
            "3 — Find contact",
            "4 — Edit contact",
            "5 — Delete contact",
            "6 — Upload contacts from file",
            "7 — Download contact book to file"};

    @DataPoints("fromEnum")
    public static AppOptions[] optionsFromEnum = AppOptions.values();

    @Theory
    public void shouldReturnWithOrdinal(@FromDataPoints("appOptions")String option,
                                        @FromDataPoints("fromEnum")AppOptions optionFromEnum) {
        assertEquals(option, optionFromEnum.toString());
    }*/

    @Test
    public void shouldReturnWithOrdinal(){
        assertEquals("2 — Show contacts", AppOptions.SHOW_CONTACTS.toString());
    }

    @Test
    public void shouldConvertOrdinal(){
        assertEquals(AppOptions.fromInteger(2), AppOptions.SHOW_CONTACTS);
    }
}