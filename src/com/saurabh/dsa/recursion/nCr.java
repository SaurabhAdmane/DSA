package com.saurabh.dsa.recursion;

// CodingShuttle Week 3

// Calculate the value of nCr (Pascals Triangle)
/**
 *  Given two integers n and r, find nCr (Combination)
 *
 *  Example 1:
 *      Input: n = 3, r = 2
 *      Output: 3
 */

public class nCr {

    public static void main(String[] args) {
        int n = 3, r = 2;
        System.out.println("nCr is " + nCr(n, r));
    }

    public static int nCr(int n, int r) {
        //You can code here
        if(r > n) return 0; // base case
        if(n == r || r == 0) return 1; // base case
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}
