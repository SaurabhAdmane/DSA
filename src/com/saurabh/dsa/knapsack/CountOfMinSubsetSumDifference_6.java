package com.saurabh.dsa.knapsack;

// Given an array Arr[] and a difference diff, find the number of subsets that array can be divided so that each the difference between the two subset is the given diff.
// Input:
// Arr[] : 1,1,2,3
// diff: 1
// Output: 3 .
public class CountOfMinSubsetSumDifference_6 {

    public static void main(String[] args) {
        int[] input = {1,1,2,3};
        int diff = 1;
        System.out.println("countOfMinSubsetSumDifference: " + countOfMinSubsetSumDifference(input, diff));
    }

    public static int countOfMinSubsetSumDifference(int[] inputArray, int givenDiff){
        int sumOfArray = 0;
        for (int i :
                inputArray) {
            sumOfArray += i;
        }
        int sum = (givenDiff + sumOfArray) / 2;

        return countOfSubset(inputArray, inputArray.length, sum);
    }

    // this is same code as countOfSubset
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
