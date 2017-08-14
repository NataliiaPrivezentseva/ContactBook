package contactbook.ui;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileOptionsTest {

    private String[] allOptions = {"1 — into default file named \'my_contacts\' which placed on disc C",
            "2 — I want to use another file"};

    private FileOptions[] optionsFromEnum = FileOptions.values();

    @Test
    public void shouldReturnWithOrdinal(){
        for (int i = 0; i < allOptions.length; i++) {
            assertEquals(allOptions[i], optionsFromEnum[i].toString());
        }
    }

    @Test
    public void shouldConvertOrdinal(){
        for (int i = 0; i < allOptions.length; i++) {
            assertEquals(FileOptions.fromInteger(i + 1), optionsFromEnum[i]);
        }
    }

}