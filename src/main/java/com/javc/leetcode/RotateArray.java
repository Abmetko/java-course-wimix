package com.javc.leetcode;

import java.util.Stack;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */
public class RotateArray {

    public static int[] rotate(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            stack.push(num);
        }

        for (int i = k - 1; i >= 0; i--) {
            nums[i] = stack.pop();
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = stack.pop();
        }
        return nums;
    }

    public static void main(String[] args) {
        rotate(new int[]{-1}, 2);
    }
}
