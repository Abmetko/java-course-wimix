package com.javc.leetcode;

//1672. Richest Customer Wealth
public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int maxWealthSoFar = 0;

        for (int[] customer : accounts) {
            int currentCustomerWealth = 0;
            for (int bank : customer) {
                currentCustomerWealth += bank;
            }
            maxWealthSoFar = Math.max(maxWealthSoFar, currentCustomerWealth);
        }
        return maxWealthSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{
                {1, 2, 3}, {2, 3, 3}, {-4, 10, 5},
                {1, 0, 3}, {2, 6, 3}, {0, 10, 5}
        }));
    }
}