package com.saurabh.dsa.backtracking;

// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/n-queens-problem_166

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a Queen and an empty space, respectively.
// Example 1:
// Sample Input: 4
// Sample Output:
// [[".Q..","...Q","Q...","..Q."],
// ["..Q.","Q...","...Q",".Q.."]]

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {

    public static void main(String[] args) {
        List<List<String>> and = new ArrayList<>();
        and = solveNQueens(4);
        for (int i = 0; i < and.size(); i++) {
            for (int j = 0; j < and.size(); j++) {
                System.out.print(and.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(new String(new char[n]).replace("\0", "."));
        }
        solveNQueensHelper(result, board, 0, n);
        return result;
    }

    private static void solveNQueensHelper(List<List<String>> result, List<String> board, int row, int n) {
        if (row == n) {
            result.add(new ArrayList<>(board));
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, col, row, n)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                solveNQueensHelper(result, board, row + 1, n);
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }

    private static boolean isSafe(List<String> board, int col, int row, int n) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }
}
