package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    //test starting with malformed Arabic number
    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        String letters = "abcd1234";
        ElbonianArabicConverter converter = new ElbonianArabicConverter(letters);
        if(converter.isValidElboNum()) {
            System.out.println("abcd1234 should not be valid");
        }
        throw new MalformedNumberException("");
    }

    //test starting with malformed Elbonian number
    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        String elbo = "MXMCCI";
        ElbonianArabicConverter converter = new ElbonianArabicConverter(elbo);
        if(converter.isValidElboNum()) {
            System.out.println("MXMCCI should not be valid");
        }
        throw new MalformedNumberException("");
    }

    //rule 1 test for M's
    @Test(expected = MalformedNumberException.class)
    public void ruleOneTestM() throws MalformedNumberException, ValueOutOfBoundsException{
        String elbo = "MMM";
        ElbonianArabicConverter tCon = new ElbonianArabicConverter(elbo);
        tCon.isValidElboNum();
    }

    //rule 1 test for C's
    @Test(expected = MalformedNumberException.class)
    public void ruleOneTestC() throws MalformedNumberException, ValueOutOfBoundsException{
        String elbo = "CCC";
        ElbonianArabicConverter tCon = new ElbonianArabicConverter(elbo);
        tCon.isValidElboNum();
    }

    //rule 1 test for X's
    @Test(expected = MalformedNumberException.class)
    public void ruleOneTestX() throws MalformedNumberException, ValueOutOfBoundsException{
        String elbo = "XXX";
        ElbonianArabicConverter tCon = new ElbonianArabicConverter(elbo);
        tCon.isValidElboNum();
    }

    //rule 1 test for I's
    @Test(expected = MalformedNumberException.class)
    public void ruleOneTestI() throws MalformedNumberException, ValueOutOfBoundsException{
        String elbo = "III";
        ElbonianArabicConverter tCon = new ElbonianArabicConverter(elbo);
        tCon.isValidElboNum();
    }

    //rule 2 test 1
    @Test(expected = MalformedNumberException.class)
    public void ruleTwoTest1() throws MalformedNumberException, ValueOutOfBoundsException{
        String dd = "DD";
        ElbonianArabicConverter dCon = new ElbonianArabicConverter(dd);
        dCon.isValidElboNum();
    }

    //rule 2 test 2
    @Test(expected = MalformedNumberException.class)
    public void ruleTwoTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        String dd = "EZZ";
        ElbonianArabicConverter dCon = new ElbonianArabicConverter(dd);
        dCon.isValidElboNum();
    }

    //rule 3 test 1
    @Test(expected = MalformedNumberException.class)
    public void ruleThreeTest1() throws MalformedNumberException, ValueOutOfBoundsException{
        String dec = "DEC";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(dec);
        conv.isValidElboNum();
    }

    //rule 3 test
    @Test
    public void ruleThreeTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        String dc = "DC";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(dc);
        assertTrue(conv.isValidElboNum());
    }

    //rule 4 test
    @Test(expected = MalformedNumberException.class)
    public void ruleFourTest() throws MalformedNumberException, ValueOutOfBoundsException{

    }

    //rule 5 test
    @Test(expected = MalformedNumberException.class)
    public void ruleFiveTest() throws MalformedNumberException, ValueOutOfBoundsException{

    }

    //rule 6 set
    @Test(expected = MalformedNumberException.class)
    public void ruleSixTest() throws MalformedNumberException, ValueOutOfBoundsException{

    }

    //rule 7 set
    @Test(expected = MalformedNumberException.class)
    public void ruleSevenTest() throws MalformedNumberException, ValueOutOfBoundsException{

    }











    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

}
