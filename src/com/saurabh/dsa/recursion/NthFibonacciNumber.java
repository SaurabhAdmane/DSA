package com.saurabh.dsa.recursion;


// Write a program to find Nth Fibonacci number.
// The integers in the following order are the Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144.
// Example 1:
// Input: n = 1
// Output: 1
// Explanation: 1 is the 1st number of fibonacci series.

public class NthFibonacciNumber {

    public static void main(String[] args) {
        int n = 8;
        System.out.println("Fibonacci Number at " + n + " is : " + nthFibonacci(n));
    }

    public static int nthFibonacci(int n){
        if (n <= 1) return n;
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }
}
