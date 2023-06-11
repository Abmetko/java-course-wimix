package com.javc.exceptions;

/**
 * Difference Between Checked and Unchecked Exceptions in Java
 * A checked exception is caught at COMPILE TIME whereas a RUNTIME or unchecked exception is,
 * as it states, at runtime.
 * A checked exception must be handled either by re-throwing or with a try catch block,
 * whereas an unchecked isn't required to be handled.
 */
public class ExceptionsTest {

    public static void calculate(int[] array, int index) {
        try {
            System.out.println(array[index]);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NumberFoundException {
        calculate(new int[]{1, 4, 5, 6, 7}, 5);
        System.out.println("\n");
        NumberValidator.validateNumber(5);
    }
}