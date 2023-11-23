package com.saurabh.dsa.recursion;

//https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/power-function_152

// Power Function
/**
 *  Given two integers x and n, write a function to determine xn.
 *  Example 1:
 *  Input : x = 2, n = 3
 *  Output :  8
 *
 */
public class Power {

    public static void main(String[] args) {
        int x = 4, n = 2;
        System.out.println("Power is : " + power(x, n));
    }

    public static int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }
}
