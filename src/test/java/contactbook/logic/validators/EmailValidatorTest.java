package contactbook.logic.validators;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class EmailValidatorTest {

    private EmailValidator validator = new EmailValidator();

    @DataPoints("properEMails")
    public static String[] properEMails = {"asterisk0123456789@gmail.com",
            "k.smith@letters.no",
            "mother_tereza@not.here",
            "Mike@hot.there",
            "not-I@i.ua",
            "eric.monte-carlo@Adjos55.amigo3"};

    @DataPoints("moreThanOneMonkeyEMails")
    public static String[] monkeyEMails = {"tata@@gmail.com",
            "@mama@gmail.com",
            "sister@gmail@.com",
            "tree@@@monkey.com"};

    @DataPoints("specialCharactersEMails")
    public static String[] specialCharactersEMails = {"Tim,Roth@big.stars", "Tim.Roth@big,stars",
            "Tim:Roth@big.stars", "Tim.Roth@big:stars",
            "Tim;Roth@big.stars", "Tim.Roth@big;stars",
            "Tim!Roth@big.stars", "Tim.Roth@big!stars",
            "Tim#Roth@big.stars", "Tim.Roth@big#stars",
            "Tim$Roth@big.stars", "Tim.Roth@big$stars",
            "Tim%Roth@big.stars", "Tim.Roth@big%stars",
            "Tim&Roth@big.stars", "Tim.Roth@big&stars",
            "Tim'Roth@big.stars", "Tim.Roth@big'stars",
            "Tim*Roth@big.stars", "Tim.Roth@big*stars",
            "Tim+Roth@big.stars", "Tim.Roth@big+stars",
            "Tim/Roth@big.stars", "Tim.Roth@big/stars",
            "Tim=Roth@big.stars", "Tim.Roth@big=stars",
            "Tim?Roth@big.stars", "Tim.Roth@big?stars",
            "Tim^Roth@big.stars", "Tim.Roth@big^stars",
            "Tim`Roth@big.stars", "Tim.Roth@big`stars",
            "Tim{Roth@big.stars", "Tim.Roth@big{stars",
            "Tim|Roth@big.stars", "Tim.Roth@big|stars",
            "Tim}Roth@big.stars", "Tim.Roth@big}stars",
            "Tim~Roth@big.stars", "Tim.Roth@big~stars"};

    @Theory
    public void testProperEMail(@FromDataPoints("properEMails")String eMail){
        assertTrue(validator.isValid(eMail));
    }

    @Theory
    public void testEMailWithMoreThanOneMonkey(@FromDataPoints("moreThanOneMonkeyEMails")String eMail){
        assertFalse(validator.isValid(eMail));
    }

    @Theory
    public void testEMailWithSpecialCharacters(@FromDataPoints("specialCharactersEMails")String eMail){
        assertFalse(validator.isValid(eMail));
    }
}