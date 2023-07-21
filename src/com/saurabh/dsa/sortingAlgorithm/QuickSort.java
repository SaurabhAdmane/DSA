package com.saurabh.dsa.sortingAlgorithm;

public class QuickSort {


    public static void main(String[] args) {

        int[] inputArray = {6, 3, 9, 5, 2, 0, 8};

        divideArray(inputArray, 0, inputArray.length - 1);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("QuickSort : " + inputArray[i]);
        }
    }

    public static void divideArray(int[] inputArray, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex) {
            // size is zero then array is divided in single element
            return;
        }

        // to divide array need to find mid point
        int mid = startingIndex + (endingIndex - startingIndex) / 2;

        divideArray(inputArray, startingIndex, mid); // divide first half array

        divideArray(inputArray, mid + 1, endingIndex); // divide second half array

        sortArray(inputArray, startingIndex, mid, endingIndex);
    }

    public static void sortArray(int[] inputArray, int startingIndex, int midIndex, int endingIndex) {
        int[] mergedArray = new int[endingIndex - startingIndex + 1]; // original array size

        int array1StartIndex = startingIndex; // starting index of array 1
        int array2StartIndex = midIndex + 1; // starting index of array 2
        int mergeArrayIndex = 0; // index of merge array

        while (array1StartIndex <= midIndex && array2StartIndex <= endingIndex) {
            if (inputArray[array1StartIndex] <= inputArray[array2StartIndex]) {
                // element of array1 is smaller than element of array2 --> add element of array1 to final merged array
                mergedArray[mergeArrayIndex] = inputArray[array1StartIndex];
                mergeArrayIndex++;
                array1StartIndex++;
            } else {
                // element of array2 is smaller than element of array1 --> add element of array2 to final merged array
                mergedArray[mergeArrayIndex] = inputArray[array2StartIndex];
                mergeArrayIndex++;
                array2StartIndex++;
            }
        }

        /**
         * below anyone while loop will execute,
         * if condition of below both while loop is true then above while loop will get execute
         */
        // array1 remains element --> add all elements on merged array
        while (array1StartIndex <= midIndex) {
            mergedArray[mergeArrayIndex] = inputArray[array1StartIndex];
            mergeArrayIndex++;
            array1StartIndex++;
        }

        // array2 remains element --> add all elements on merged array
        while (array2StartIndex <= endingIndex) {
            mergedArray[mergeArrayIndex] = inputArray[array2StartIndex];
            mergeArrayIndex++;
            array2StartIndex++;
        }

        // copy all element of mergedArray into inputArray(Original Array)
        for (int i = 0, j = startingIndex; i < mergedArray.length; i++, j++) {
            inputArray[j] = mergedArray[i];
        }
    }

}
