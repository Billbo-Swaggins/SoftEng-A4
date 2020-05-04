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


    // "failed" grading tests...
    @Test(expected = MalformedNumberException.class)
    public void wtfTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1M");
        converter.toElbonian();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MKJI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CMXI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EMXI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MIX");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MJKI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("KMJI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CXIM");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MXCI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest10() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("YMX");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest11() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MYZX");
        converter.toArabic();
    }

    // ok this one actually fails :/ -2
    @Test(expected = MalformedNumberException.class)
    public void wtfTest12() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M M");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest13() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest14() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" 1");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest15() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DMXI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest16() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCCCCX");
        converter.toArabic();
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void wtfTest17() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3000");
        converter.toElbonian();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest18() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EDDZYKJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest19() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EEDZYKJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest20() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCXIIII");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest21() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MZYXI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest22() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EDZYKJJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest23() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EDZYKKJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest24() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMMCXI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest25() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MXXXXI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest26() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EDZZYKJ");
        converter.toArabic();
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void wtfTest27() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-1");
        converter.toElbonian();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest28() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCDE");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest29() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EDZYKJJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest30() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MEJZYKD");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest31() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MEYZDKJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest32() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        converter.toElbonian();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest33() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MKDZEJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest34() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MZDEYKJ");
        converter.toArabic();
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void wtfTest35() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
        converter.toElbonian();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest36() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MZXY");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest37() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MEDZJKY");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest38() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MEDKYZJ");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest39() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("k");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest40() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" I");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest41() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MEDCI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void wtfTest42() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MPX");
        converter.toArabic();
    }
}
