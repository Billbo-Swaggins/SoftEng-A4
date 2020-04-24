package converter;

import java.lang.String;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException  Thrown if the value is an Elbonian number that does not conform
     *                                   to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     *                                   in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        return 1;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

    /**
     * @return true if the calling number
     * @throws MalformedNumberException
     */
    public Boolean isValidArabNum() throws MalformedNumberException, ValueOutOfBoundsException {
        String s = this.number;
        int x;

        try {
            x = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new MalformedNumberException("Invalid Integer");
        }

        return (x >= 0 && x < 3000);
    }

    /* RULES

    •	M, C, X, and I. These letters can only appear a maximum of two times in a number.
    •	D, E, Y, Z, J, and K. These letters can only appear once in a number.
    •	If both D and E appear, then C cannot appear in a number
    •	If both Y and Z appear, then X cannot appear in a number
    •	If both J and K appear, then I cannot appear in a number
    •	Numbers are represented by the letters from the greatest value down to the lowest value. In other words, the letter I would never appear before the letters M, D, X, or J. The letter D would never appear before E or M but would appear before Y. The letters are summed together to determine the value.
    •	Lowercase letters are not permitted
     */

    /** checks the first rule
     *
     * @return
     * @throws MalformedNumberException
     */
    public Boolean ruleOne() throws MalformedNumberException {
        int numM = 0;
        int numC = 0;
        int numX = 0;
        int numI = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'M':
                    numM++;
                case 'C':
                    numC++;
                case 'X':
                    numX++;
                case 'I':
                    numI++;
            }

            if (numM > 2 || numC > 2 || numX > 2 || numI > 2) {
                throw new MalformedNumberException("Rule 1 Violated");
            }
        }



        return true;
    }

    /**
     *
     * @return
     * @throws MalformedNumberException
     */
    public Boolean ruleTwo() throws MalformedNumberException {
        int numD = 0;
        int numE = 0;
        int numY = 0;
        int numZ = 0;
        int numJ = 0;
        int numK = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'D':
                    numD++;
                case 'E':
                    numE++;
                case 'Y':
                    numY++;
                case 'Z':
                    numZ++;
                case 'J':
                    numJ++;
                case 'K':
                    numK++;
            }

            if (numD > 1 || numE > 1 || numY > 1 || numZ > 1 || numJ > 1 || numK > 1) {
                throw new MalformedNumberException("Rule 2 Violated");
            }
        }



        return true;
    }

    /**
     *
     * @return
     * @throws MalformedNumberException
     */
    public Boolean ruleThree() throws MalformedNumberException {
        int numD = 0;
        int numE = 0;
        int numC = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'D':
                    numD++;
                case 'E':
                    numE++;
                case 'C':
                    numC++;
            }
            if (numD > 0 && numE > 0 && numC > 0) {
                throw new MalformedNumberException("Rule 3 Violated");
            }
        }
        return true;
    }

    public Boolean ruleFour() throws MalformedNumberException {
        int numY = 0;
        int numZ = 0;
        int numX = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'Y':
                    numY++;
                case 'Z':
                    numZ++;
                case 'X':
                    numX++;
            }
            if (numY > 0 && numZ > 0 && numX > 0) {
                throw new MalformedNumberException("Rule 4 Violated");
            }
        }
        return true;
    }

    public Boolean ruleFive() throws MalformedNumberException {
        int numJ = 0;
        int numK = 0;
        int numI = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'J':
                    numJ++;
                case 'K':
                    numK++;
                case 'I':
                    numI++;
            }
            if (numJ > 0 && numK > 0 && numI > 0) {
                throw new MalformedNumberException("Rule 5 Violated");
            }
        }
        return true;
    }

    /**
     * @return true if the calling number
     * @throws MalformedNumberException
     */
    /*public Boolean isValidElboNum() throws MalformedNumberException {
        String s = this.number;
        return false;
    }*/
}
}
