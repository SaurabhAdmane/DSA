package com.saurabh.dsa.searchingAlgorithm;

// Given the array nums after the possible rotation and an integer target,
// return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(getIndex(new int[]{5, 1, 3}, 1));
    }

    public static int getIndex(int[] input, int target) {
        int startIndex = 0;
        int endIndex = input.length;
        int pivot = getPivot(input);
        if (target >= input[pivot] && target <= input[endIndex - 1]) {
            // Binary search on second line
            return binary(input, pivot, endIndex - 1, target);
        } else {
            // Binary search on first line
            return binary(input, 0, pivot - 1, target);
        }
    }

    public static int binary(int[] inputArray, int start, int end, int target) {
        int startIndex = start;
        int endIndex = end;

        int mid = startIndex + (endIndex - startIndex) / 2;

        while (startIndex <= endIndex) {
            if (inputArray[mid] == target) return mid; // key found at mid index

            if (target > inputArray[mid]) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
            mid = startIndex + (endIndex - startIndex) / 2;
        }
        return -1;
    }

    public static int getPivot(int[] input) {
        int startIndex = 0;
        int endIndex = input.length - 1;
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        while (startIndex < endIndex) {
            if (input[midIndex] >= input[0]) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex;
            }
            midIndex = startIndex + (endIndex - startIndex) / 2;
        }
        return startIndex;
    }

}
