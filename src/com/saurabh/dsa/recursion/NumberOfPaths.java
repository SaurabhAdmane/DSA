package com.saurabh.dsa.recursion;

// CodingShuttle Week 3
/**
 *   Number of Matrix paths
 *     Count every path that can lead from the top left to the bottom right of a M X N matrix,
 *     with the restriction that you can only move right or down from each cell
 *
 *   Example 1:
 *     Input: M = 2, N = 2
 *     Output : 2
 *
 *   Explanation:
 *      There are only two paths
 *      (0, 0) -> (0, 1) -> (1, 1)
 *      (0, 0) -> (1, 0) -> (1, 1)
 */
public class NumberOfPaths {

    public static void main(String[] args) {
        int n = 2, m = 2;
        System.out.println("Number of path for " + m + " and " + n + " is " + numberOfPath(m, n));
    }

    static int numberOfPath(int m, int n){
        if (m == 1 || n == 1) return 1;
        return numberOfPath(m - 1, n) + numberOfPath(m, n - 1);
    }
}
