package com.javc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
1. Two Sum

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int increment = 0;
        for (int i = increment; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[increment] + nums[j] == target & j != increment) {
                    return new int[]{increment, j};
                }
            }
            increment++;
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = twoSum2(new int[]{2, 7, 11, 15}, 9);
//        int[] result = twoSum(new int[]{3, 2, 4}, 6);
//        int[] result = twoSum2(new int[]{3, 3}, 6);
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}