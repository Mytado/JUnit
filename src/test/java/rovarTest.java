import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class rovarTest {

    //test to see that an empty string is rejected and given null in return
    @Test public void testNullEnrov (){
        rovar rovar = new rovar();
        String testString = null;
        String result = rovar.enrov(testString);
        assertNull(result);
    }

    //test to see that a valid lowercase string with all the characters is accepted and approved.
    @Test public void testValidUpperEnrov () {
        rovar rovar = new rovar();
        String testString = "QWERTYUIOPÅASDFGHJKLÖÄZXCVBNM";
        String expected = "QoQWoWERoRToTYUIOPoPÅASoSDoDFoFGoGHoHJoJKoKLoLÖÄZoZXoXCoCVoVBoBNoNMoM";
        String actual = rovar.enrov(testString);
        assertEquals(expected, actual);
    }

    @Test public void testValidLowerEnrov () {
        rovar rovar = new rovar();
        String testString = "qwertyuiopåasdfghjklöäzxcvbnm";
        String expected = "qoqwowerortotyuiopopåasosdodfofgoghohjojkoklolöäzozxoxcocvovbobnonmom";
        String actual = rovar.enrov(testString);
        assertEquals(expected, actual);
    }

    @Test public void testValidNumSpecCharEnrov () {
        rovar rovar = new rovar();
        String testString = "1234567890\n" +
                "!\"#€%&/";
        String expected = "1234567890\n" +
                "!\"#€%&/";
        String actual = rovar.enrov(testString);
        assertEquals(expected, actual);
    }

    //test to see that the empty string returns an empty string
    @Test public void testEmptyEnrov () {
        rovar rovar = new rovar();
        String testString = "";
        String expected = "";
        String actual = rovar.enrov(testString);
        assertEquals(actual, expected);
    }

    //DEROV

    //test to see that an empty string is rejected and given null in return
    @Test public void testNullDerov (){
        rovar rovar = new rovar();
        String testString = null;
        String result = rovar.derov(testString);
        assertNull(result);
    }

    //test to see that a valid lowercase string with all the characters is accepted and approved.
    @Test public void testValidUpperDerov () {
        rovar rovar = new rovar();
        String expected = "QWERTYUIOPÅASDFGHJKLÖÄZXCVBNM";
        String testString = "QoQWoWERoRToTYUIOPoPÅASoSDoDFoFGoGHoHJoJKoKLoLÖÄZoZXoXCoCVoVBoBNoNMoM";
        String actual = rovar.derov(testString);
        assertEquals(expected, actual);
    }

    @Test public void testValidLowerDerov () {
        rovar rovar = new rovar();
        String expected = "qwertyuiopåasdfghjklöäzxcvbnm";
        String testString = "qoqwowerortotyuiopopåasosdodfofgoghohjojkoklolöäzozxoxcocvovbobnonmom";
        String actual = rovar.derov(testString);
        assertEquals(expected, actual);
    }

    @Test public void testValidNumSpecCharDerov () {
        rovar rovar = new rovar();
        String expected = "1234567890\n" +
                "!\"#€%&/";
        String testString = "1234567890\n" +
                "!\"#€%&/";
        String actual = rovar.derov(testString);
        assertEquals(expected, actual);
    }

    //test to see that the empty string returns an empty string
    @Test public void testEmptyDerov () {
        rovar rovar = new rovar();
        String testString = "";
        String expected = "";
        String actual = rovar.derov(testString);
        assertEquals(actual, expected);
    }


}
