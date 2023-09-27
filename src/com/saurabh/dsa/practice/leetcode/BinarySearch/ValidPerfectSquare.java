package com.saurabh.dsa.practice.leetcode.BinarySearch;

// 367 https://leetcode.com/problems/valid-perfect-square/
// Given a positive integer num, return true if num is a perfect square or false otherwise.

// A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

// You must not use any built-in library function, such as sqrt.

// Example 1:
// Input: num = 16
// Output: true
// Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

// Example 2:
// Input: num = 14
// Output: false
// Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

//Constraints:
//1 <= num <= 231 - 1

public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println("IsPerfectSquare: " + isPerfectSquare(16));
    }

    public static boolean isPerfectSquare(int x) {
        long start = 1;
        long end  = x;
        boolean ans = false;
        if (x == 1 || x == 0) {
            return true;
        }

        while (start <= end){
            long mid = start + (end - start) / 2; // Step 1
            long square = mid * mid; // Step 2
            if (square == x)  // Step 3
                ans = true;

            if (square < x) {  // Step 4
                ans = false;
                start = mid + 1;
            } else {
                end = mid - 1; // Step 5
            }
        }
        return ans;
    }
}
