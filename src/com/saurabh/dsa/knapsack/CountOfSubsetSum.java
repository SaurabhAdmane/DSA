package com.saurabh.dsa.knapsack;


// return count of subset sum
public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("countOfSubset: " + countOfSubset(arr, arr.length, sum));
    }

    public static int countOfSubset(int[] arr, int size, int sum) {
        int[][] matrix = new int[size + 1][sum + 1];

        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) matrix[i][j] = 0; // row 0 initialize with false

                if (j == 0) matrix[i][j] = 1; // column 0 initialize with true
            }
        }
        // logic same as 0/1 knapsack
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - arr[i - 1]] + matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        return matrix[size][sum];
    }
}
