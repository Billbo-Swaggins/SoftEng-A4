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
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertTrue(converter.toArabic() == 1);
    }

    @Test
    public void ElbonianToArabicTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMEDZYKJ");
        assertTrue(converter.toArabic() == 2999);
    }

    @Test
    public void ElbonianToArabicTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MM");
        assertTrue(converter.toArabic() == 2000);
    }

    @Test
    public void ElbonianToArabicTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MECZXJI");
        assertTrue(converter.toArabic() == 1774);
    }

    @Test
    public void ElbonianToArabicTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("II");
        assertTrue(converter.toArabic() == 2);
    }


    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertTrue(converter.toElbonian().equals( "I"));
    }

    @Test
    public void ArabicToElbonianTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2999");
        assertTrue(converter.toElbonian().equals( "MMEDZYKJ"));
    }
    @Test
    public void ArabicToElbonianTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2000");
        assertTrue(converter.toElbonian().equals( "MM"));
    }
    @Test
    public void ArabicToElbonianTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1774");
        assertTrue(converter.toElbonian().equals( "MECZXJI"));
    }
    @Test
    public void ArabicToElbonianTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2");
        assertTrue(converter.toElbonian().equals( "II"));
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
        ElbonianArabicConverter tCon = new ElbonianArabicConverter(dd);
        tCon.isValidElboNum();
    }

    //rule 2 test 2
    @Test(expected = MalformedNumberException.class)
    public void ruleTwoTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        String dd = "EZZ";
        ElbonianArabicConverter tCon = new ElbonianArabicConverter(dd);
        tCon.isValidElboNum();
    }

    //rule 2 test 3 expected
    @Test
    public void ruleTwoTest3() throws MalformedNumberException, ValueOutOfBoundsException{
        String oneEach = "EDZYKJ";
        ElbonianArabicConverter tCon = new ElbonianArabicConverter(oneEach);
        assertTrue(tCon.isValidElboNum());
    }


    //rule 3 test 1
    @Test(expected = MalformedNumberException.class)
    public void ruleThreeTest1() throws MalformedNumberException, ValueOutOfBoundsException{
        String edc = "EDC";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(edc);
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
    public void ruleFourTest1() throws MalformedNumberException, ValueOutOfBoundsException{
        String zyx = "ZYX";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(zyx);
        conv.isValidElboNum();
    }

    //rule 4 test
    @Test
    public void ruleFourTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        String yx = "YX";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(yx);
        assertTrue(conv.isValidElboNum());
    }

    //rule 5 test expected to fail
    @Test(expected = MalformedNumberException.class)
    public void ruleFiveTest1() throws MalformedNumberException, ValueOutOfBoundsException{
        String jki = "KJI";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(jki);
        conv.isValidElboNum();
    }

    //rule 5 test expected to pass
    @Test
    public void ruleFiveTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        String ji = "JI";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(ji);
        assertTrue(conv.isValidElboNum());
    }

    //rule 6 set
    @Test(expected = MalformedNumberException.class)
    public void ruleSixTest1() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "XM";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidElboNum();
    }

    //rule 6 test 2
    @Test
    public void ruleSixTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "MXXI";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        assertTrue(conv.isValidElboNum());
    }

    //rule 6 set 3
    @Test(expected = MalformedNumberException.class)
    public void ruleSixTest3() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "EXCZ";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidElboNum();
    }

    //rule 6 test 4
    @Test(expected = MalformedNumberException.class)
    public void ruleSixTest4() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "IMXJI";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidElboNum();
    }

    //rule 7 set
    @Test(expected = MalformedNumberException.class)
    public void ruleSevenTest1() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "i";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidElboNum();
    }

    //rule 7 set
    @Test(expected = MalformedNumberException.class)
    public void ruleSevenTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "mcxi";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidElboNum();
    }

    //rule 7 set
    @Test
    public void ruleSevenTest3() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "MCXI";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        assertTrue(conv.isValidElboNum());
    }

    //rule 7 set
    @Test(expected = MalformedNumberException.class)
    public void ruleSevenTest4() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "MMCxiI";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidElboNum();
    }

    //rule 7 set
    @Test(expected = MalformedNumberException.class)
    public void ruleSevenTest5() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "ABCDEFG";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidElboNum();
    }


    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        String s = "-1";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidArabNum();
    }

    @Test(expected = MalformedNumberException.class)
    public void valueOutOfBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        String s = "1a";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidArabNum();
    }

    @Test
    public void valueOutOfBoundsTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        String s = "305";
        ElbonianArabicConverter conv = new ElbonianArabicConverter(s);
        conv.isValidArabNum();
    }

}
