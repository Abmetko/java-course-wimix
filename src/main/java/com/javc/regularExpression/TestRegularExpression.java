package com.javc.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {

    private static final String ORDER_NUMBER = "Order #8674423";

    private static final String CURRENT_PRICE_1 = "current balance 100,51$";
    private static final String CURRENT_PRICE_2 = "current balance 100.51$";

    private static final String TEST = "Waived by John Doe 03/04/2021, 2:27:23 PM Europe/Warsaw\nReason: test";

    public static boolean checkWithRegExp(String string) {
        Pattern pattern = Pattern.compile("[A-z]{2,5}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    //заменяем все кроме цифр на ""
    public static String getOnlyDigits() {
        return ORDER_NUMBER
                .replaceAll("[^\\d]", "");
    }

    public static String getOnlyDigitsAndDotComma(String value) {
        return value
                .replaceAll("[^\\d.,]", "");
    }

    //заменяем все цифры на ""
    public static String removeDigitsFromValue(String value) {
        return value
                .replaceAll("\\d", "");
    }

    public static void main(String[] args) {
//        System.out.println(TEST.split("Waived by ")[1].split("\nReason")[0]);
//
//        System.out.println(getOnlyDigits());
//        System.out.println(getOnlyDigitsAndDotComma(CURRENT_PRICE_1));
//        System.out.println(getOnlyDigitsAndDotComma(CURRENT_PRICE_2));
//        System.out.println(removeDigitsFromValue(ORDER_NUMBER));
//        System.out.println(ORDER_NUMBER.replaceAll(" ",""));
//        System.out.println(TEST.split("Waived by John Doe ")[1].split("\n")[0]);
//        String str = getOnlyDigitsAndDotComma(CURRENT_PRICE_1).replaceAll(",", ".");
//        System.out.println(Double.parseDouble(str) + 100);
        System.out.println(checkWithRegExp("aBcDe"));//true
    }
}