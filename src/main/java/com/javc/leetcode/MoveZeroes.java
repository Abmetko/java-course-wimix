package com.javc.leetcode;


/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.


Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = 0;
                }
            }
        }
    }

    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0});
    }
}