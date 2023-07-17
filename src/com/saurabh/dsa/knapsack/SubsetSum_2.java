package com.saurabh.dsa.knapsack;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// Input:
// N = 6
// arr[] = {3, 34, 4, 12, 5, 2}
// sum = 9
// Output: 1 (true)
// Explanation: Here there exists a subset with
// sum = 9, 4+3+2 = 9.
public class SubsetSum_2 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        int size = 5;
        System.out.println("Output : " + subsetSum(arr, size, sum));
    }
/**
    size          sum----->
     |         0 1 2 3 4 5 6 7 8 9 10 11
     |    0   |T|F|F|F|F|F|F|F|F|F|F|F|
  2  |    1   |T|_|_|_|_|_|_|_|_|_|_|_|
  3  |    2   |T|_|_|_|_|_|_|_|_|_|_|_|
  7  V    3   |T|_|_|_|_|_|_|_|_|_|_|_|
  8       4   |T|_|_|_|_|_|_|_|_|_|_|_|
  10      5   |T|_|_|_|_|_|_|_|_|_|_|_|

 */
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
