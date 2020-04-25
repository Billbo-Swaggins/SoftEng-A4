package converter;

import java.lang.String;
import java.util.regex.Pattern;

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
    public int toArabic() throws MalformedNumberException {
        String s = number;
        int toReturn = 0;

        if (isValidElboNum()) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'M') {
                    toReturn += 1000;
                } else if (c == 'E') {
                    toReturn += 600;
                } else if (c == 'D') {
                    toReturn += 300;
                } else if (c == 'C') {
                    toReturn += 100;
                } else if (c == 'Z') {
                    toReturn += 60;
                } else if (c == 'Y') {
                    toReturn += 30;
                } else if (c == 'X') {
                    toReturn += 10;
                } else if (c == 'K') {
                    toReturn += 6;
                } else if (c == 'J') {
                    toReturn += 3;
                } else if (c == 'I') {
                    toReturn += 1;
                }
            }
        }

        return toReturn;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() throws ValueOutOfBoundsException, MalformedNumberException {
        String s = number; //ex. "115"
        String answer = "";
        if (isValidArabNum()) {
            int x = Integer.parseInt(s);
            while (x > 0) {
                if (x >= 1000) {
                    answer += "M";
                    x -= 1000;
                } else if (x >= 600) {
                    answer += "E";
                    x -= 600;
                } else if (x >= 300) {
                    answer += "D";
                    x -= 300;
                } else if (x >= 100) {
                    answer += "C";
                    x -= 100;
                } else if (x >= 60) {
                    answer += "Z";
                    x -= 60;
                } else if (x >= 30) {
                    answer += "Y";
                    x -= 30;
                } else if (x >= 10) {
                    answer += "X";
                    x -= 10;
                } else if (x >= 6) {
                    answer += "K";
                    x -= 6;
                } else if (x >= 3) {
                    answer += "J";
                    x -= 3;
                } else if (x >= 1) {
                    answer += "I";
                    x -= 1;
                }
            }

        }
        return answer;
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

        if (x <= 0 || x >= 3000) {
            throw new ValueOutOfBoundsException("Integer out of bounds");
        }
        return true;
    }

    /* RULES

    •	M, C, X, and I. These letters can only appear a maximum of two times in a number.
    •	D, E, Y, Z, J, and K. These letters can only appear once in a number.
    •	If both D and E appear, then C cannot appear in a number
    •	If both Y and Z appear, then X cannot appear in a number
    •	If both J and K appear, then I cannot appear in a number
    •	Numbers are represented by the letters from the greatest value down to the lowest value.
            In other words, the letter I would never appear before the letters M, D, X, or J.
            The letter D would never appear before E or M but would appear before Y.
            The letters are summed together to determine the value.
    •	Lowercase letters are not permitted
     */ //rules

    /**
     * checks the first rule
     * M, C, X, and I. These letters can only appear a maximum of two times in a number.
     *
     * @return
     * @throws MalformedNumberException
     */
    private Boolean ruleOne() throws MalformedNumberException {
        int numM = 0;
        int numC = 0;
        int numX = 0;
        int numI = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'M':
                    numM++;
                    break;
                case 'C':
                    numC++;
                    break;
                case 'X':
                    numX++;
                    break;
                case 'I':
                    numI++;
                    break;
            }

            if (numM > 2 || numC > 2 || numX > 2 || numI > 2) {
                throw new MalformedNumberException("Rule 1 Violated");
            }
        }


        return true;
    }

    /**
     * D, E, Y, Z, J, and K. These letters can only appear once in a number.
     *
     * @return
     * @throws MalformedNumberException
     */
    private Boolean ruleTwo() throws MalformedNumberException {
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
                    break;
                case 'E':
                    numE++;
                    break;
                case 'Y':
                    numY++;
                    break;
                case 'Z':
                    numZ++;
                    break;
                case 'J':
                    numJ++;
                    break;
                case 'K':
                    numK++;
                    break;
            }

            if (numD > 1 || numE > 1 || numY > 1 || numZ > 1 || numJ > 1 || numK > 1) {
                throw new MalformedNumberException("Rule 2 Violated");
            }
        }


        return true;
    }

    /**
     * If both D and E appear, then C cannot appear in a number
     *
     * @return
     * @throws MalformedNumberException
     */
    private Boolean ruleThree() throws MalformedNumberException {
        int numD = 0;
        int numE = 0;
        int numC = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'D':
                    numD++;
                    break;
                case 'E':
                    numE++;
                    break;
                case 'C':
                    numC++;
                    break;
            }
            if (numD > 0 && numE > 0 && numC > 0) {
                throw new MalformedNumberException("Rule 3 Violated");
            }
        }
        return true;
    }

    /**
     * If both Y and Z appear, then X cannot appear in a number
     *
     * @return
     * @throws MalformedNumberException
     */
    private Boolean ruleFour() throws MalformedNumberException {
        int numY = 0;
        int numZ = 0;
        int numX = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'Y':
                    numY++;
                    break;
                case 'Z':
                    numZ++;
                    break;
                case 'X':
                    numX++;
                    break;
            }
            if (numY > 0 && numZ > 0 && numX > 0) {
                throw new MalformedNumberException("Rule 4 Violated");
            }
        }
        return true;
    }

    /**
     * If both J and K appear, then I cannot appear in a number
     *
     * @return
     * @throws MalformedNumberException
     */
    private Boolean ruleFive() throws MalformedNumberException {
        int numJ = 0;
        int numK = 0;
        int numI = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case 'J':
                    numJ++;
                    break;
                case 'K':
                    numK++;
                    break;
                case 'I':
                    numI++;
                    break;
            }
            if (numJ > 0 && numK > 0 && numI > 0) {
                throw new MalformedNumberException("Rule 5 Violated");
            }
        }
        return true;
    }


    /**
     * Numbers are represented by the letters from the greatest value down to the lowest value.
     * M E D C Z Y X K J I
     *
     * @return true if the calling number
     * @throws MalformedNumberException
     */
    private Boolean ruleSix() throws MalformedNumberException {
        //variable for if each letter is the lowest number thus far
        Boolean containMSmaller = false;
        Boolean containESmaller = false;
        Boolean containDSmaller = false;
        Boolean containCSmaller = false;
        Boolean containZSmaller = false;
        Boolean containYSmaller = false;
        Boolean containXSmaller = false;
        Boolean containKSmaller = false;
        Boolean containJSmaller = false;

        //checks if number is too long
        if (number.length() >= 12) {
            throw new MalformedNumberException("Number not in Elbonian Domain");
        }

        //checks to make sure no letter is greater than that before it
        for (int i = 0; i < number.length(); i++) {
            char curr = number.charAt(i);
            switch (curr) {

                case 'M':
                    if (containMSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    break;

                case 'E':
                    if (containESmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    break;

                case 'D':
                    if (containDSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    containESmaller = true;
                    break;

                case 'C':
                    if (containCSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    containESmaller = true;
                    containDSmaller = true;
                    break;

                case 'Z':
                    if (containZSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    containESmaller = true;
                    containDSmaller = true;
                    containCSmaller = true;
                    break;

                case 'Y':
                    if (containYSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    containESmaller = true;
                    containDSmaller = true;
                    containCSmaller = true;
                    containZSmaller = true;
                    break;

                case 'X':
                    if (containXSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    containESmaller = true;
                    containDSmaller = true;
                    containCSmaller = true;
                    containZSmaller = true;
                    containYSmaller = true;
                    break;

                case 'K':
                    if (containKSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    containESmaller = true;
                    containDSmaller = true;
                    containCSmaller = true;
                    containZSmaller = true;
                    containYSmaller = true;
                    containXSmaller = true;
                    break;

                case 'J':
                    if (containJSmaller) {
                        throw new MalformedNumberException("Numerals Out Of Order");
                    }
                    containMSmaller = true;
                    containESmaller = true;
                    containDSmaller = true;
                    containCSmaller = true;
                    containZSmaller = true;
                    containYSmaller = true;
                    containXSmaller = true;
                    containKSmaller = true;
                    break;

                case 'I':
                    containMSmaller = true;
                    containESmaller = true;
                    containDSmaller = true;
                    containCSmaller = true;
                    containZSmaller = true;
                    containYSmaller = true;
                    containXSmaller = true;
                    containKSmaller = true;
                    containJSmaller = true;
                    break;

            }
        }
        return true;
    }


    /**
     * checks rule seven of elbonum formatting
     *
     * @return true if string is all upper case
     * @throws MalformedNumberException if string contains lower case letters
     */
    private boolean ruleSeven() throws MalformedNumberException {
        if (!number.equals(number.toUpperCase())) {
            throw new MalformedNumberException("Number Must Be All UPPERCASE");
        }

        return true;
    }


    public Boolean isValidElboNum() throws MalformedNumberException {
        //check validity of Elbonian number

        if (stringContainsNumber(number)) {
            throw new MalformedNumberException("Elbonian numbers cannot contain Arabic numerals");
        }


        if (!(ruleOne() && ruleTwo() && ruleThree() && ruleFour() && ruleFive() && ruleSix() && ruleSeven())) {
            throw new MalformedNumberException("Something didn't go right");
        }
        return true;
    }

    private boolean stringContainsNumber(String s) {
        return Pattern.compile("[0-9]").matcher(s).find();
    }

}
