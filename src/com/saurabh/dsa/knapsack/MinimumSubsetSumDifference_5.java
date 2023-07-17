package com.saurabh.dsa.knapsack;

// https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
// Input:  arr[] = {1, 6, 11, 5}
// Output: 1
// Explanation:
//      Subset1 = {1, 5, 6}, sum of Subset1 = 12
//      Subset2 = {11}, sum of Subset2 = 11
// 12 - 11 = 1 O/P
public class MinimumSubsetSumDifference_5 {

    public static void main(String[] args) {
        int[] input = {1, 6, 5, 11};
        System.out.println("::" + getMinSubsetSumDiff(input));
    }

    public static int getMinSubsetSumDiff(int[] inputArray) {
        int mn = Integer.MAX_VALUE;
        int range = 0;
        int arraySize = inputArray.length;
        for (int value : inputArray) {
            range += value;
        }
        boolean[][] martix = subsetSum(inputArray, arraySize, range);
        for (int i = 0; i < range/2 + 1; i++) {
            if (martix[arraySize][i]) mn = Integer.min(mn, range - (2 * i));
        }

        return mn;
    }

    public static boolean[][] subsetSum(int[] arr, int size, int sum) {
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

        return matrix;
    }
}
