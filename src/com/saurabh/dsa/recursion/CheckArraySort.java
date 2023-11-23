package com.saurabh.dsa.recursion;

// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/check-if-the-array-is-sorted_150
/**
 *  Check if the Array is Sorted
 *
 *  Check whether an array arr[] of size N is sorted in non-decreasing order.
 *  Example 1:
 *  Input:  N = 5
 *  arr[] = {1, 2, 3, 4, 5}
 *  Output: 1
 *  Explanation: The given array is sorted.
 *  Example 2:
 *  Input:  N = 4
 *  arr[] = {10, 20, 40, 25}
 *  Output: 0
 *  Explanation: The given array is not sorted.
 */
public class CheckArraySort {

    public static void main(String[] args) {
        int[] arr = {4,6,7,12,13};
        int n = 5;
        System.out.println("Array Sorted? " + arraySortedOrNot(arr, n));
    }

    public static boolean arraySortedOrNot(int []arr, int n){
        if(n == 0 || n == 1) return true;

        if(arr[n - 1] < arr[n - 2])
            return false;

        return arraySortedOrNot(arr, n - 1);
    }
}
