package com.saurabh.dsa.searchingAlgorithm;

// Given an array of integers nums sorted in increasing order, find the starting and ending position of a given target value

// HINT : Apply Binary Search

/**
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Below for last occurrence
 * step 1 : calculate midIndex. If array[midIndex] == target then save the midIndex And increase starting index to midIndex+1
 * step 2 : if target > array[midIndex] then increase starting index to midIndex+1
 * step 2 : if target < array[midIndex] then decrease ending index to midIndex-1
 * step 3 : again calculate midIndex
 * <p>
 * Below for first occurrence
 * step 1 : calculate midIndex. If array[midIndex] == target then save the midIndex And decrease ending index to midIndex-1
 * step 2 : if target > array[midIndex] then increase starting index to midIndex+1
 * step 2 : if target < array[midIndex] then decrease ending index to midIndex-1
 * step 3 : again calculate midIndex
 */
public class FirstLastOccurrence {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3, 3, 6};
        int target = 3;
        System.out.println("First Occ at index : " + firstOccurrence(input, input.length, target));
        System.out.println("Last Occ at index : " + lastOccurrence(input, input.length, target));

        // find total number of occurrence formula --> (lastIndex - firstIndex) + 1
    }

    public static int firstOccurrence(int[] input, int size, int target) {
        int startingIndex = 0;
        int endingIndex = size - 1;
        int ans = -1;
        int midIndex = startingIndex + (endingIndex - startingIndex) / 2;
        while (startingIndex <= endingIndex) {
            if (target == input[midIndex]) {
                ans = midIndex;
                endingIndex = midIndex - 1;
            } else if (target > input[midIndex]) {
                startingIndex = midIndex + 1;
            } else if (target < input[midIndex]) {
                endingIndex = midIndex - 1;
            }
            midIndex = startingIndex + (endingIndex - startingIndex) / 2;
        }
        return ans;
    }

    public static int lastOccurrence(int[] input, int size, int target){
        int startingIndex = 0;
        int endingIndex = size-1;
        int midIndex = startingIndex + (endingIndex - startingIndex) / 2;
        int ans = -1;

        while (startingIndex <= endingIndex){
            if (target == input[midIndex]){
                ans = midIndex;
                startingIndex = midIndex + 1;
            } else if (target > input[midIndex]) {
                startingIndex = midIndex + 1;
            } else if (target < input[midIndex]) {
                endingIndex = midIndex - 1;
            }
            midIndex = startingIndex + (endingIndex - startingIndex) / 2;
        }
        return ans;
    }
}
