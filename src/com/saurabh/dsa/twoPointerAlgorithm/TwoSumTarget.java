package com.saurabh.dsa.twoPointerAlgorithm;

import java.util.Arrays;

// Que -> Given int array of N element. If addition of that any two number is equal to target then print that number

public class TwoSumTarget {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 4};
        int target = 6;
        int[] output = twoSum(nums, target);
        for (int j : output) {
            System.out.println("twoSum : " + j);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums); // First sort the array - you can write your sorting logic here
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int addition = nums[i] + nums[j];
            if (addition > target) { // array is sorted and addition is > target so we have decrease j pointer
                j--;
            } else if (addition < target) { // array is sorted and addition is > target so we have increase i pointer
                i++;
            } else {
                return new int[]{nums[i], nums[j]}; // target == addition
            }
        }
        return new int[]{};
    }
}
