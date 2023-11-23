package com.saurabh.dsa.recursion;

// Fast Power Function with Modulo
// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/fast-power-function-with-modulo_151

// Formula for power
// Even :-- a^b = (a ^ b) b/2
// Odd :-- a^b = a * a ^ b-1
// Negative Power = (1/a)^b

// Formula for modulo
// addition :-- (a + b) % m = (a%m + b%m) %m
// multiplication :-- (a * b) % m = (a%m * b%m) %m

/**
 * Given three numbers x, n and p, compute (xn) % p.
 *
 * Example 1:
 * Input:
 * x = 2.00000, n = 10, p = 500
 * Output:
 * 24.00000
 * Explanation:
 * (x^n)%p = (2.00000^10)%500 = 1024.00000%500 = 24.00000
 */

public class FastPowerModulo {

    public static void main(String[] args) {
        System.out.println("Fast power with modulo is " + myPow(1, -100, 5));
    }

    public static double myPow(double x, int n, int p) {
        if (n == 0) return 1;

        if (n < 0) return myPow(1/x, Math.abs(n), p); // this is for negative power. this will make power positive

        if (n % 2 == 0) { // n && 1 == 0 bitwise operator
            // power is even
            return myPow((x%p * x%p) %p, n/2, p); // Formula for modulo
        } else {
            // power is odd
            return (x%p * myPow(x, n-1, p) %p) %p; // Formula for modulo
        }
    }

    public static double myFastPow(double x, int n, int p) {
        if (n == 0) return 1;

        if (n < 0) return myPow(1/x, n, p); // this is for negative power. this will make power positive

        if (n % 2 == 0) { // n && 1 == 0 bitwise operator
            // power is even
            return myPow(x * x, n/2, p);
        } else {
            // power is odd
            return (x * myPow(x, n-1, p));
        }
    }
}
