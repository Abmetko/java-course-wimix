package com.javc.leetcode;

import java.util.Stack;

/*
Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.


Example 1:

Input: num = "51230100"
Output: "512301"
Explanation: Integer "51230100" has 2 trailing zeros, we remove them and return integer "512301".

Example 2:

Input: num = "123"
Output: "123"
Explanation: Integer "123" has no trailing zeros, we return integer "123".
 */
public class RemoveTrailingZerosFromString {

    public static String removeTrailingZeros(String num) {
        return num.replaceAll("0+$", "");
    }

    public static String removeTrailingZeros2(String num) {
        int ind = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') {
                ind = i;
                break;
            }
        }
        return num.substring(0, ind + 1);
    }

    public static String removeTrailingZeros3(String num) {
        Stack<Character> stack = new Stack<>();
        for (char i : num.toCharArray()) {
            stack.push(i);
        }
        while (stack.peek() == '0') {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (Character j : stack) {
            sb.append(j);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeTrailingZeros2("51230100"));
    }
}