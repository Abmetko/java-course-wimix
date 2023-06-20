package com.javc.leetcode;


import java.util.Stack;

/*
1480. Running Sum of 1d Array


Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.



Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
 */
public class RunningSumOf1dArray {

    public static int[] runningSum(int[] nums) {
        int[] resultArray = new int[nums.length];

        for (int i = 0; i < nums.length / 2; i++) {
            int buffer = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[i];
            nums[i] = buffer;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i : nums) {
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                resultArray[i] = stack.peek();
                stack.pop();
            } else {
                resultArray[i] = resultArray[i - 1] + stack.peek();
                stack.pop();
            }
        }
        return resultArray;
    }

    public static int[] runningSum2(int[] nums) {
        int[] resultArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                resultArray[i] = nums[0];
            } else {
                resultArray[i] = resultArray[i - 1] + nums[i];
            }
        }
        return resultArray;
    }

    //Самый простой способ - первый индекс(нулевой = 0) всегда один и тот же,
    // поэтому начинаем со второго элемента(i = 1)
    public static int[] runningSum3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        runningSum3(new int[]{1, 2, 3, 4});
    }
}