package com.saurabh.dsa.searchingAlgorithm;

// Peak Index in a Mountain Array. You must solve it in O(log(arr.length)) time complexity
//Example 1:
//        Input: arr = [0,1,0]
//        Output: 1
// Example 3:
//        Input: arr = [0,10,5,2]
//        Output: 1

/**
 * step 1 : Calculate midIndex
 * step 2 : while(startingIndex < endingIndex) if array[midIndex] < array[midIndex + 1] then change startingIndex = mid + 1
 * step 2 : else change endingIndex = mid
 * step 3 : calculate mid
 * step 4 : return startingIndex
 */

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] input = {0,10,5,2};
        System.out.println("Peak Index is : " + findPeakIndex(input));
    }

    public static int findPeakIndex(int[] input){
        int startingIndex  = 0;
        int endingIndex = input.length - 1;
        int midIndex = startingIndex + (endingIndex - startingIndex) / 2;

        while(startingIndex < endingIndex){
            if (input[midIndex] < input[midIndex + 1])
                startingIndex = midIndex + 1;
            else
                endingIndex = midIndex;

            midIndex = startingIndex + (endingIndex - startingIndex) / 2;
        }

        return startingIndex;
    }
}
