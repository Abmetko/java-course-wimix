package com.javc.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for (char i : s.toCharArray()) {
            list1.add(i);
        }
        for (char i : t.toCharArray()) {
            list2.add(i);
        }
        return list1.stream().sorted().collect(Collectors.toList()).equals(list2.stream().sorted().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
}