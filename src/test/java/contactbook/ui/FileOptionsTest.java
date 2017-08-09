package contactbook.ui;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileOptionsTest {

    @Test
    public void shouldReturnWithOrdinal(){
        assertEquals("2 — I want to use another file", FileOptions.CUSTOM.toString());
    }

    @Test
    public void shouldConvertOrdinal(){
        assertEquals(FileOptions.fromInteger(2), FileOptions.CUSTOM);
    }

}