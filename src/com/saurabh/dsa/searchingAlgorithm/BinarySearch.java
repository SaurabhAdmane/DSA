package com.saurabh.dsa.searchingAlgorithm;

// Note:- input array should be sorted(increasing or decreasing order)
// Step 1: find mid element of the array(find the mid index element). In the given example mid index is 2 and element at index 2 is 10. Here, Array is divided in two part. Left part and right part.
// Step 2: Compare the key with the mid element
// Step 3: If key == mid element, congratulations you got your key. If not equal then follow below steps.
// Step 4: If key > mid element then go to right side. i.e. startIndex should mid + 1
// Step 5: If key < mid element then go to left side. i.e. endIndex should mid - 1
// Step 6: Again find the mid element and repeat from step 2
public class BinarySearch {
    public static void main(String[] args) {

        int[] inputArray = {4, 8, 10, 15, 17, 20};
        int key = 4; // find this element in the array

        System.out.println("Element Found at index: " + binarySearch(inputArray, inputArray.length, key));

    }

    public static int binarySearch(int[] inputArray, int size, int key) {
        int startIndex = 0;
        int endIndex = size-1;

        int mid = startIndex + (endIndex - startIndex) / 2; // to get mid index

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
