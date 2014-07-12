package org.tappoz.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

/**
 * Created by tappoz on 29/05/14.
 */
public class AmountStaticUtil {

    private static final String[] NUMBERS_AS_STRING = {"zero", "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine" , "ten"};

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
     * @param ratio
     * @return
     */
    public static double parseFraction(String ratio) {
        // http://stackoverflow.com/a/13250063/1264920
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }

    /**
     * Expecting strings like "2 1/2". The method will compute to total amount compounding all the components (splitting the original string on the blank space).
     * @param amount
     * @return
     */
    public static double parseComplexAmountsWithSpacesAndFractions(String amount) {
        String[] amounts = amount.split(" ");
        double compundedAmount = 0;
        for(String currentAmount : amounts) {
            compundedAmount += parseFraction(currentAmount);
        }

        return compundedAmount;
    }

    public static boolean isFractionGreaterThanOne(String amount) {

        Double parsedAmount;

        // http://stackoverflow.com/a/13250063/1264920
        if (amount.contains("/")) {
            String[] rat = amount.split("/");
            parsedAmount = Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            parsedAmount = Double.parseDouble(amount);
        }

        return parsedAmount > 1;
    }

    /**
     * With divisions here we need BigDecimal with rounding context, rather than double.
     *
     * @param arrayOfExpectedNumbers
     * @return
     */
    public static double getMean(String[] arrayOfExpectedNumbers) {

        BigDecimal sumAsBigDecimal = new BigDecimal(0, MathContext.DECIMAL64);
        for (String expectedNumber : arrayOfExpectedNumbers) {
            BigDecimal currentParsedNumber = new BigDecimal(parseNumber(expectedNumber), MathContext.DECIMAL64);
            sumAsBigDecimal.add(currentParsedNumber);
        }
        BigDecimal arrayLength = new BigDecimal(arrayOfExpectedNumbers.length, MathContext.DECIMAL64);

        return sumAsBigDecimal.divide(arrayLength).doubleValue();
    }

}
