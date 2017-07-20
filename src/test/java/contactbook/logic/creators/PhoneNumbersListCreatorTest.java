package contactbook.logic.creators;

import contactbook.model.PhoneNumber;
import contactbook.ui.console.PhoneNumberGetter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhoneNumbersListCreatorTest {

    @Mock
    private PhoneNumberGetter phoneNumberGetter;

    @InjectMocks
    private PhoneNumbersListCreator phoneNumbersListCreator = new PhoneNumbersListCreator(phoneNumberGetter);

    @Test
    public void checkListSize(){
        when(phoneNumberGetter.getProperPhoneNumberFromUser()).thenReturn("123456789");
        int amount = 4;
        List<PhoneNumber> numbers = phoneNumbersListCreator.createNewListOfPersonsPhoneNumbers(amount);
        assertEquals(amount, numbers.size());
        verify(phoneNumberGetter, times(amount)).getProperPhoneNumberFromUser();
    }
}