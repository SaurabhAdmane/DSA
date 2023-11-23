package com.saurabh.dsa.recursion;

// CodingShuttle Week 3

// Josephus Problem
/**
 * Given a total of n people and the number k, which means that k-1 people are skipped and
 * the kth person is killed in a predetermined direction in a circle.
 * The count will begin at the k+1th individual after each operation.
 *
 * The goal is to select a safe location within the circle so that,
 * after performing these actions starting from the first position within the circle,
 * you are the only one left alive.
 *
 * Example 1:
 *  Input: n = 3 k = 2
 *  Output: 3
 *  Explanation: There are 3 people, hence the second person will die if the first
 *  person is skipped. The safe position is therefore 3.
 */
public class Josephus {

    public static void main(String[] args) {
        System.out.println(josephus(3, 2));
    }
    public static int josephus(int n, int k)
    {
        return helperJosephus(n, k) + 1;
    }
    static int helperJosephus(int n, int k){
        if( n == 1) return 0; // Base case
        return (helperJosephus(n - 1, k) + k) % n;
    }
}
