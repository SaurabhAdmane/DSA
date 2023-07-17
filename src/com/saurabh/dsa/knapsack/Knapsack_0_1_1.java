package com.saurabh.dsa.knapsack;

// Code for all 3 approaches: Recursion => Memoization (Top down) => DP (Bottom Up)
// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// N = 3 (SizeOfArray)
// W = 4 (Capacity)
// values[] = {1,2,3}
// weight[] = {4,5,1}
// Output: 3
public class Knapsack_0_1_1 {

    public static void main(String[] args) {
        //
        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int capacity = 4;
        int sizeOfArray = 3;

        System.out.println("Output : " + matrixApproch(capacity, weight, values, sizeOfArray));

    }

    public static int recursive(int[] weight, int[] value, int capacity, int sizeOfArray) {
        // base condition
        if (sizeOfArray == 0 || capacity == 0) return 0;

        // choice condition
        // 1. Choice to include item
        if (weight[sizeOfArray - 1] <= capacity)
            return Math.max(value[sizeOfArray - 1] + recursive(weight, value, capacity - weight[sizeOfArray - 1], sizeOfArray - 1), recursive(weight, value, capacity, sizeOfArray - 1));

            // 2. Choice to exclude item
        else if (weight[sizeOfArray - 1] > capacity) return recursive(weight, value, capacity, sizeOfArray - 1);

        else return 0;
    }

    // Memoize above recursive code (top-down)
//    public static int memoize(int weight[], int value[], int capacity, int sizeOfArray){
//        Vector<Integer> t1 = new Vector<Integer>();
//        t1.add(capacity + 1, -1);
//        Vector<Vector<Integer>> t = new Vector<>();
//        t.add(sizeOfArray + 1, t1);
//
//        //Base Case
//        if(sizeOfArray<=0 || capacity<=0) return 0;
//
//        //Check if result exists already
//        if(t[sizeOfArray][capacity] != -1) return t[sizeOfArray][capacity];
//
//        //If result doesn't exist
//        //Choice Diagram Code
//        //1. Choice to include item or not
//        if(weight[sizeOfArray-1] <= capacity){
//            t[sizeOfArray][capacity] = Math.max(value[sizeOfArray-1] + fun(capacity-weight[sizeOfArray-1], weight, value, sizeOfArray-1, t), 0+fun(capacity,weight,value,sizeOfArray-1, t));
//            return t[sizeOfArray][capacity];
//        }
//
//        //2. No choice
//        else if(weight[sizeOfArray-1] > capacity){
//            t[sizeOfArray][capacity] = 0 + fun(capacity,weight,value,sizeOfArray-1, t);
//            return t[sizeOfArray][capacity];
//        }
//        return 0;
//    }

    // Bottom Up Approach - Dynamic Programming
    public static int matrixApproch(int capacity, int[] weight, int[] value, int sizeOfArray) {
        // Initialize 2D matrix with size
        int[][] t = new int[sizeOfArray + 1][capacity + 1];

        // Adding default value 0 in 2D matrix
        for (int i = 0; i < capacity + 1; i++) t[0][i] = 0;
        for (int j = 0; j < sizeOfArray + 1; j++) t[j][0] = 0;

        for (int i = 1; i < sizeOfArray + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (weight[i - 1] <= j) {
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[sizeOfArray][capacity];
    }
}
