package com.saurabh.dsa.backtracking;

// codingShuttle week 4
// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/rat-in-a-maze_159
// Rat in a Maze

// Problem Statement
// In a square matrix of order N * N, imagine a rat placed at position (0, 0). The final location must be reached at (N - 1, N - 1).
// Find every route the rat might possibly take to go from point A to point B. The rat can move in the following directions: "U" (up), "D" (down), "L" (left), and "R" (right).
// Rats cannot move to a cell with a value of 0 in the matrix because it is blocked, while rats can pass through cells with a value of 1 in the matrix.
// No cell can be visited more than once in a journey. The rat cannot go to any other cell if the originating cell is 0.
// Complete the function findPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order.

// Example 1:
// Input: N = 4
// m[][] = {{1, 0, 0, 0},
//         {1, 1, 0, 1},
//         {1, 1, 0, 0},
//         {0, 1, 1, 1}}
// Output: DDRDRR DRDDRR

// Explanation:
// The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR
// and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

// Example 2:
// Input: N = 2
// m[][] = {{1, 1},
//         {1, 1}}
//Output: DR RD

//   3
// 0 1 1
// 1 1 1
// 1 1 1

// DDRR DDRURD DDRUURDD DRDR DRRD DRURDD RDDR RDLDRR RDRD RRDD RRDLDR RRDLLDRR

import java.util.ArrayList;

public class RatInAMaze {

    // Always follow D --> L --> R --> U
    public static void main(String[] args) {
//        int[][] mat = {{1, 1, 1, 0},
//                {1, 0, 0, 1},
//                {1, 1, 0, 0},
//                {1, 1, 1, 1}};

        int[][] mat = {{0, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};

        int n = mat.length; // number of row in mat
        int m = mat[0].length; // number of column in mat
        boolean[][] visited = new boolean[n][m]; // visited array
        visited[0][0] = true;
        ratInAMaze(m, n, mat, visited, 0, 0, ""); // to print result in string

        ArrayList<String> path = new ArrayList<>();
        ratInAMaze(m, n, mat, visited, 0, 0, path, ""); // to return arrayList
        for (int i = 0; i < path.size(); i++) {
            System.out.println("Path are : " + path.get(i));
        }
    }

    static void ratInAMaze(int m, int n, int[][] mat, boolean[][] visited, int i, int j, String pathAnswer) {
        if (i == n - 1 && j == m - 1) { // Base condition bottom right corner reached
            System.out.println(pathAnswer);
            return;
        }

        if (isValid(i + 1, j, m, n, mat, visited)) { // D
            visited[i + 1][j] = true;
            ratInAMaze(m, n, mat, visited, i + 1, j, pathAnswer + "D");
            visited[i + 1][j] = false;
        }

        if (isValid(i, j - 1, m, n, mat, visited)) { // L
            visited[i][j - 1] = true;
            ratInAMaze(m, n, mat, visited, i, j - 1, pathAnswer + "L");
            visited[i][j - 1] = false;
        }

        if (isValid(i, j + 1, m, n, mat, visited)) { // R
            visited[i][j + 1] = true;
            ratInAMaze(m, n, mat, visited, i, j + 1, pathAnswer + "R");
            visited[i][j + 1] = false;
        }

        if (isValid(i - 1, j, m, n, mat, visited)) { // U
            visited[i - 1][j] = true;
            ratInAMaze(m, n, mat, visited, i - 1, j, pathAnswer + "U");
            visited[i - 1][j] = false;
        }

    }


    static void ratInAMaze(int m, int n, int[][] mat, boolean[][] visited, int i, int j, ArrayList<String> path, String pathAnswer) {
        if (mat[i][j] == 0){
            return;
        }
        if (i == n - 1 && j == m - 1) { // Base condition bottom right corner reached
            path.add(pathAnswer);
            return;
        }

        if (isValid(i + 1, j, m, n, mat, visited)) { // D
            visited[i + 1][j] = true;
            ratInAMaze(m, n, mat, visited, i + 1, j, path, pathAnswer + "D");
            visited[i + 1][j] = false;
        }

        if (isValid(i, j - 1, m, n, mat, visited)) { // L
            visited[i][j - 1] = true;
            ratInAMaze(m, n, mat, visited, i, j - 1, path, pathAnswer + "L");
            visited[i][j - 1] = false;
        }

        if (isValid(i, j + 1, m, n, mat, visited)) { // R
            visited[i][j + 1] = true;
            ratInAMaze(m, n, mat, visited, i, j + 1, path, pathAnswer + "R");
            visited[i][j + 1] = false;
        }

        if (isValid(i - 1, j, m, n, mat, visited)) { // U
            visited[i - 1][j] = true;
            ratInAMaze(m, n, mat, visited, i - 1, j, path, pathAnswer + "U");
            visited[i - 1][j] = false;
        }
        // return path;
    }

    static boolean isValid(int i, int j, int m, int n, int[][] mat, boolean[][] visited) {
        return (i < n && i >= 0 && j < m && j >= 0 && !visited[i][j] && mat[i][j] == 1); // mat[i][j] == 1 --> Rats cannot move to a cell with a value of 0 in the matrix because it is blocked, rats can pass through cells with a value of 1 in the matrix
        // !visited[i][j] --> No cell can be visited more than once in a journey.
    }
}
