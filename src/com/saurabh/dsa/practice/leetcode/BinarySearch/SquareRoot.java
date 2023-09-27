package com.saurabh.dsa.practice.leetcode.BinarySearch;

// 69. Sqrt(x) https://leetcode.com/problems/sqrtx/
// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
// You must not use any built-in exponent function or operator.
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

// Example 1:
// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.

// Example 2:
// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

// x = 2147483647 exp: 46340
/*
* Step 1: Calculate mid of the given number
* Step 2: Calculate square of the above mid
* Step 3: If square == given number, Congratulation you got the answer return mid
* Step 4: If square < given number, store the mid and go to right side of array(start = mid + 1)
* Step 5: If square > given number, go to left side of array(end = mid - 1)
*/
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println("SURABH");
        System.out.println("Sq: " + mySqrt(37));
        System.out.println("Sq Precision: " + morePrecision(37, 2, mySqrt(37)));
    }
    public static int mySqrt(long x) {
        long start = 1;
        long end  = x;
        long ans = -1;
        if (x == 1 || x == 0){
            return (int) x;
        }
        while (start <= end){
            long mid = start + (end - start) / 2; // Step 1
            long square = mid * mid; // Step 2
            if (square == x)  // Step 3
                return (int) mid;
            if (square < x){  // Step 4
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1; // Step 5
            }
        }
        return (int) ans;
    }

    /**
     * @param x --> input number
     * @param precision --> number of digit after decimal
     * @param sqRt --> square root of input number int
     * */
    public static double morePrecision(long x, int precision, int sqRt){
        double factor = 1;
        double ans = sqRt;
        for (int i = 0; i < precision; i++) { // precision --> number of digit after decimal point
            factor = factor / 10; // this will make 0.1, 0.01, 0.001 depend on precision
            for (double j = ans; j * j < x; j = j + factor) { // j*j < x --> j = j + factor
                ans = j;
            }
        }
        return ans;
    }
}