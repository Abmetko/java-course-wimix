package com.javc.leetcode;

import java.util.stream.IntStream;

/*
268. Missing Number


Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < min) {
                min = nums[i + 1];
            }
        }
        int[] fullArray = new int[nums.length + 1];//////////

        fullArray[0] = min;

        for (int i = 1; i < nums.length + 1; i++) {
            fullArray[i] = fullArray[i - 1] + 1;
        }
        return IntStream.of(fullArray).sum() - IntStream.of(nums).sum();
    }

    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < nums.length; i++) {
            actualSum = actualSum + nums[i];
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }
}