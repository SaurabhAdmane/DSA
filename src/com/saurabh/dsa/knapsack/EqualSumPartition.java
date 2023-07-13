package com.saurabh.dsa.knapsack;

// array of sum should be EVEN so that we can divide the array in two part
// arr[] = 1 , 5, 11, 5
// o/p = t/f
public class EqualSumPartition {

    public static void main(String[] args) {
        int[] inputArray = {1, 5, 11, 5};
        System.out.println("EqualSumPartition Output: " + equalSumPartition(inputArray));
    }

    public static boolean equalSumPartition(int[] inputArray) {
        int sum = 0;

        for (int j : inputArray) {
            sum = sum + j;
        }

        if (sum % 2 != 0) // sum getting ODD means equal partition is not available in the array
            return false;

        if (sum % 2 == 0) { // sum getting EVEN means equal partition is available in the array
            return subsetSum(inputArray, inputArray.length, sum / 2);
        }

        return false;
    }

    public static boolean subsetSum(int[] arr, int size, int sum) {
        boolean[][] matrix = new boolean[size + 1][sum + 1];

        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) matrix[i][j] = false; // row 0 initialize with false

                if (j == 0) matrix[i][j] = true; // column 0 initialize with true
            }
        }
        // logic same as 0/1 knapsack
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - arr[i - 1]] || matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        return matrix[size][sum];
    }
}
