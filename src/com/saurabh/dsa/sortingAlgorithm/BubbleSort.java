package com.saurabh.dsa.sortingAlgorithm;

/**
 * Compare each element with next element
 * */
public class BubbleSort {

    public static void main(String[] args) {

        int size = 5;
        int[] input = {6, 2, 8, 4, 10};
        // o/p = {2, 4, 6, 8, 10}
        for (int item = 0; item < bubbleSort(input, size).length ; item++) {
            System.out.println("BubbleSort: " + input[item]);
        }
    }

    public static int[] bubbleSort(int[] input, int size) {
        for (int i = 0; i < size - 1; i++) {
            boolean isSorted = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    isSorted = true;
                    swapPosition(input, j, j + 1);
                }
            }
            if (!isSorted) break;
        }
        return input;
    }

    public static void swapPosition(int[] input, int i1, int i2) {
        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
    }
}
