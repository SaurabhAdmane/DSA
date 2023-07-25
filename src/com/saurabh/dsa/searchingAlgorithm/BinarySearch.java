package com.saurabh.dsa.searchingAlgorithm;

// input array should be sorted
public class BinarySearch {
    public static void main(String[] args) {

        int[] inputArray = {4, 8, 10, 15, 17, 20};
        int key = 4; // find this element in the array

        System.out.println("Element Found at index: " + binarySearch(inputArray, inputArray.length, key));

    }

    public static int binarySearch(int[] inputArray, int size, int key) {
        int startIndex = 0;
        int endIndex = size-1;

        int mid = startIndex + (endIndex - startIndex) / 2;

        while (startIndex <= endIndex) {
            if (inputArray[mid] == key) return mid; // key found at mid index

            if (key > inputArray[mid]) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
            mid = startIndex + (endIndex - startIndex) / 2;
        }
        return -1;
    }
}
