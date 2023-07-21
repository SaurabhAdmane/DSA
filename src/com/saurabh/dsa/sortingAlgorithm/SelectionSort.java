package com.saurabh.dsa.sortingAlgorithm;

public class SelectionSort {

    public static void main(String[] args) {
        int size = 5;
        int[] input = {6, 2, 8, 4, 10};
        // o/p = {2, 4, 6, 8, 10}
        for (int item = 0; item < selectionSort(input, size).length ; item++) {
            System.out.println("BubbleSort: " + input[item]);
        }
    }

    public static int[] selectionSort(int[] inputArr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i; // index at which min value of array is present
            for (int j = i + 1; j < size; j++) {
                if (inputArr[j] < inputArr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { // minIndex is same as new index then dont need to swap
                swapPosition(inputArr, minIndex, i);
            }
        }
        return inputArr;
    }

    public static void swapPosition(int[] input, int i1, int i2) {
        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
    }
}
