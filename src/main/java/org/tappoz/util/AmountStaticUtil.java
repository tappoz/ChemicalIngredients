package org.tappoz.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class AmountStaticUtil {

    private static final String[] NUMBERS_AS_STRING = {"zero", "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine" , "ten"};

    /**
     * This is a general purpose method for many different scenarios,
     * the output is a double type number representing the input string.
     * Scenarios might be of different kinds: "one", "1/2", "2 1/2".
     *
     * @param number a string representing a number
     * @return a parsed number
     */
    public static double parseNumber(String number) {
        int value = Arrays.asList(NUMBERS_AS_STRING).indexOf(number);
        if(value != -1) {
            return (double) value;
        } else {
            return parseComplexAmountsWithSpacesAndFractions(number);
        }
    }
    
    /**
     * Expecting strings like "1/2" or "2/3" etc.
     * The method provides a double type representing the input string as a number.
     *
     * @param ratio a string representing a ratio (fraction)
     * @return a parsed number
     */
    public static double parseFraction(String ratio) {

        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }

    /**
     * Expecting strings like "2 1/2". The method will compute to total amount compounding all
     * the components (splitting the original string on the blank space).
     *
     * @param amount a string representing a complex number that needs to be compounded (e.g. "2 1/2")
     * @return a parsed number
     */
    public static double parseComplexAmountsWithSpacesAndFractions(String amount) {
        String[] amounts = amount.split(" ");
        double compundedAmount = 0;
        for(String currentAmount : amounts) {
            compundedAmount += parseFraction(currentAmount);
        }

        return compundedAmount;
    }

    /**
     * This method provides the mean of an input array of strings representing numbers.
     * Given that we are using divisions here then we need BigDecimal types with rounding context,
     * rather than double types.
     *
     * @param arrayOfExpectedNumbers an array of strings representing even complex numbers e.g. "1", "2 1/2", or "three"
     * @return a parsed number
     */
    public static double getMean(String[] arrayOfExpectedNumbers) {

        BigDecimal sumAsBigDecimal = new BigDecimal(0, MathContext.DECIMAL64);
        for (String expectedNumber : arrayOfExpectedNumbers) {
            BigDecimal currentParsedNumber = new BigDecimal(parseNumber(expectedNumber), MathContext.DECIMAL64);
            sumAsBigDecimal = sumAsBigDecimal.add(currentParsedNumber);
        }
        BigDecimal arrayLength = new BigDecimal(arrayOfExpectedNumbers.length, MathContext.DECIMAL64);

        return sumAsBigDecimal.divide(arrayLength).doubleValue();
    }

}
