package com.saurabh.dsa.arrays;

import java.util.Arrays;
import java.util.List;

// A subarray is a slice from a contiguous array (i.e., occupy consecutive positions) and inherently maintains the
// order of elements. For example, the subarrays of array {1, 2, 3} are {1}, {1, 2}, {1, 2, 3}, {2}, {2, 3}, and {3}.
public class IntSubarray {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3);
        printSubArray(input);
    }

    public static void printSubArray(List<Integer> input){
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                System.out.println(input.subList(i, j+1));
            }
        }
    }
}
