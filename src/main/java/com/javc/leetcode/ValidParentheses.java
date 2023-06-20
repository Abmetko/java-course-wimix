package com.javc.leetcode;

import java.util.Stack;

//20. Valid Parentheses
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    /*
    --> { [ ( ) ] }
    Итерируем массив символов и если элементы попадают в первую выборку '(' или '{' или '[',
    то добавляем их в стек. Далее, для элементов которые не входят в первую выборку - если
    например следующий символ ')' то ему должно соответствовать '(' На вершине стека (peek() возвращает вершину стека)
    в нашем случае стек --> ( [ {. Если соответствует то удаляем вершину стека --> '('.
     */

    public static boolean isValid3(String s) {
        Stack<Character> stack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '{' || i == '[') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (i == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (i == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (i == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        System.out.println(isValid3("[{}(){}{}[]]{}"));
    }
}
