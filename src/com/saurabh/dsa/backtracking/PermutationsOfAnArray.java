package com.saurabh.dsa.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// codingShuttle week 4
// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/permutations-of-an-array_160
// Given an array nums[] of distinct integers, return all the possible permutations.
// Return the answer in sorted order. See the examples for more clarification.
// Example 1:
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
public class PermutationsOfAnArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> out = permute(nums);
        System.out.println(out);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permuteHelper(nums,0, nums.length - 1, output);
        output.sort(new CustomComparator());
        return output;
    }

    static void permuteHelper(int[] num, int left, int right, List<List<Integer>> output) {
        if (left == right) {
            output.add(addValue(num));
            return;
        }

        for (int i = left; i <= right; i++) {
            swap(num, i, left);
            permuteHelper(num, left + 1, right, output);
            swap(num, i, left);
        }
    }

    private static List<Integer> addValue(int[] num) {
        List<Integer> subOut = new ArrayList<>();
        for (int n:num) {
            subOut.add(n);
        }
        return subOut;
    }

    static void swap(int[] num, int i, int left) {
        int temp = num[i];
        num[i] = num[left];
        num[left] = temp;
    }
}

class CustomComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (i >= list2.size()) {
                // List 2 is shorter, so List 1 comes after List 2
                return 1;
            } else if (list1.get(i).equals(list2.get(i))) {
                // Values are the same, continue to the next element
                continue;
            } else {
                // Values are different, compare them
                return list1.get(i).compareTo(list2.get(i));
            }
        }
        // All elements are the same until this point
        if (list1.size() < list2.size()) {
            // List 1 is shorter, so List 1 comes before List 2
            return -1;
        } else if (list1.size() > list2.size()) {
            // List 2 is shorter, so List 1 comes after List 2
            return 1;
        }
        // Lists are identical
        return 0;
    }
}

