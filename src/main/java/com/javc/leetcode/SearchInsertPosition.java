package com.javc.leetcode;


/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (target > nums[i] & target < nums[i + 1]) return i + 1;
        }
        return -1;
    }

    public static int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert2(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}