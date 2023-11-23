package com.saurabh.dsa.recursion;

// CodingShuttle Week 3
/**
 * Factorial of a Number
 * Given a non-negative integer, N. Find the factorial of N.
 */
public class Factorial {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    public static int factorial(int n){
        if(n <= 1) return 1; // Base care factorial of 1 and 0 = 1
        return factorial(n-1) * n;
    }
}
