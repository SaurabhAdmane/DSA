package com.saurabh.dsa.sortingAlgorithm;

public class InsertionSort {

    public static void main(String[] args) {
        int[] inputArray = {6, 3, 9, 5, 2, 0, 8};

        insertionSort(inputArray);
    }

    public static void insertionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int temp = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > temp) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = temp;
        }
        for (int ip : input) {
            System.out.println("InsertionSort : " + ip);
        }
    }
}
