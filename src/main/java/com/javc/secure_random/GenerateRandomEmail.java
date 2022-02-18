package com.javc.secure_random;

import java.security.SecureRandom;

public class GenerateRandomEmail {

    private static final String CHARS_DIGITS = "0123456789";
    private static final String CHARS_LETTERS = "qwertyuiopasdfghjklzxcvbnm";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomEmail() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("test.");
        for (int i = 0; i < 10; i++) {
            sb.append(CHARS_DIGITS.charAt(RANDOM.nextInt(CHARS_DIGITS.length())));
        }
        sb.append(".");
        for (int i = 0; i < 5; i++) {
            sb.append(CHARS_LETTERS.charAt(RANDOM.nextInt(CHARS_LETTERS.length())));
        }
        sb.append("@gmail.com");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomEmail());
        System.out.println(generateRandomEmail());
        System.out.println(generateRandomEmail());
        System.out.println(generateRandomEmail());
        System.out.println(generateRandomEmail());
    }
}