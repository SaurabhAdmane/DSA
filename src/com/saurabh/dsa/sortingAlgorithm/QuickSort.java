package com.saurabh.dsa.sortingAlgorithm;


public class QuickSort {

    public static void main(String[] args) {

        int[] inputArray = {6, 3, 9, 5, 2, 0, 8};

        quickSort(inputArray, 0, inputArray.length - 1);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("QuickSort : " + inputArray[i]);
        }
    }

    public static void quickSort(int[] inputArray, int l, int h) {
        if (l < h) {
            int pivot = partitionLogic(inputArray, l, h);
            quickSort(inputArray, l, pivot - 1);
            quickSort(inputArray, pivot + 1, h);
        }
    }

    // l = low(starting point of array), h= high(ending point of array)
    public static int partitionLogic(int[] inputArray, int l, int h) {
        int pivot = inputArray[l];
        int i = l;
        int j = h;
        while (i < j) {
            while (inputArray[i] <= pivot && i < inputArray.length - 1) {
                i++;
            }

            while (inputArray[j] > pivot) {
                j--;
            }

            if (i < j) {
                swapPosition(inputArray, i, j);
            }
        }
        swapPosition(inputArray, j, l);

        return j;
    }

    public static void swapPosition(int[] input, int i1, int i2) {
        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
    }

}
