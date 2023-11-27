package com.saurabh.dsa.backtracking;

// codingShuttle week 4
// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/the-knights-tour_162

// You are given an NxM chessboard and the starting position (0, 0) of a knight. Your goal is to find a sequence of moves 
// for the knight such that it visits every square on the chessboard exactly once, following the rules of knight movement.
// The function should return a 2D array of integers representing the order in which the knight visits each square.

// Note: There may be multiple possible orders in which the knight can visit the squares. Your function should return just one
// of these possible orders.
// If it is not possible to complete the knight's tour, return an NxM matrix having all values equal to -1.

// Example 1:
// Input: n = 5, m = 5
// Output: [[0, 5, 14, 9, 20],
//         [13, 8, 19, 4, 15],
//         [18, 1, 6, 21, 10],
//         [7, 12, 23, 16, 3],
//         [24, 17, 2, 11, 22]]
// Explanation: This is one of the order of each cell in which they are visited by knight.
// Input :
//
//2 3
//Output :
//
//0 -1 -1
//-1 -1 -1
//Expected :
//
//-1 -1 -1
//-1 -1 -1

public class TheKnightTour {

    public static void main(String[] args) {
        int n = 5, m = 5;
        int[][] a= knightTour(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] knightTour(int n, int m) {
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = -1;
            }
        }
        array[0][0] = 0;
        int[] movesX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] movesY = {1, 2, 2, 1, -1, -2, -2, -1};

        if (!knightTourHelper(array, n, m, movesX, movesY, 0, 0, 1)){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = -1;
                }
            }
        }
        return array;
    }

    static boolean knightTourHelper(int[][] array, int n, int m, int[] movesX, int[] movesY, int currentX, int currentY, int steps) {
        if (steps == n * m) return true;

        for (int i = 0; i < 8; i++) {
            int nextX = currentX + movesX[i];
            int nextY = currentY + movesY[i];
            if (isValidMoves(n, m, array, nextX, nextY)) {
                array[nextX][nextY] = steps;
                boolean isTourComp = knightTourHelper(array, n, m, movesX, movesY, nextX, nextY, steps + 1);
                if (isTourComp)
                    return true;
                else {
                    array[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    private static boolean isValidMoves(int n, int m, int[][] array, int currentX, int currentY) {
        return (currentX >= 0 && currentY >= 0 && currentX < n && currentY < m && array[currentX][currentY] == -1);
    }
}
