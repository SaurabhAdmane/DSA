package com.saurabh.dsa.searchingAlgorithm;

// Also known as Equilibrium index of an array
// The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal
// to the sum of all the numbers strictly to the index's right.
// Input: nums = [1,7,3,6,5,6]
// Output: 3
// Explanation:
//      The pivot index is 3.
//      Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
//      Right sum = nums[4] + nums[5] = 5 + 6 = 11

//Input: nums = [1,2,3]
//Output: -1

//Input: nums = [2,1,-1]
//Output: 0

/**
 * step 1 : get the sum of array and consider this as rightSum
 * step 2 : consider leftSum is 0
 * step 3 : Iterate loop on array, rightSum = rightSum - array[i]
 * step 4 : check if leftSum == rightSum then return i
 * step 5 : minus array[i] from righIndex and add it in leftIndex
 * repeat step 3-4-5 till loop get end
 * step 6 : if pivot not found in that case return -1
 */
public class FindPivotOfAnArray {

    public static void main(String[] args) {
        System.out.println("Pivot : " + findPivot(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int getSum(int[] input) {
        int sum = 0;
        for (int j : input) {
            sum += j;
        }
        return sum;
    }

    public static int findPivot(int[] inputArray) {
        int leftSum = 0;
        int rightSum = getSum(inputArray);
        for (int i = 0; i < inputArray.length; i++) {
            rightSum = rightSum - inputArray[i];
            if (leftSum == rightSum) return i;
            leftSum = leftSum + inputArray[i];
        }
        return -1;
    }
}
