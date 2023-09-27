package com.saurabh.dsa.practice.codingninjas.BinarySearch;

// https://www.codingninjas.com/studio/library/book-allocation-problem
// https://www.codingninjas.com/studio/problems/allocate-books_1090540
// Explanation https://www.youtube.com/watch?v=YTTdLgyqOLY&list=PLDzeHZWIZsTp4pb_WBRahP1tnipLuX9qM&index=4

public class BookAllocation {

    public static void main(String[] args) {
        System.out.println("Min book allocation: "+ allocateBooks(new int[]{2, 8, 8, 4, 5}, 5, 6));
    }
    public static int allocateBooks(int[] pageArr, int books, int numberOfStudent){
        int start = 0;
        int sum = 0;
        if(numberOfStudent > pageArr.length){
            return -1;
        }
        for (int i = 0; i < books; i++) {
            sum += pageArr[i];
        }
        int end = sum;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (isPossible(pageArr, books, numberOfStudent, mid)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] pageArr, int books, int numberOfStudent, int mid) {
        int studentCount = 1;
        int pageSum = 0;
        for (int i = 0; i < books; i++) {
            if (pageSum + pageArr[i] <= mid){
                pageSum += pageArr[i];
            } else {
                studentCount ++;
                if (studentCount > numberOfStudent || pageArr[i] > mid){
                    return false;
                }
                pageSum = pageArr[i];
            }
        }
        return true;
    }
}
