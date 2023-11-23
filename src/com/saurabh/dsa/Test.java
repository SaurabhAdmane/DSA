package com.saurabh.dsa;

public class Test {
    public static void main(String[] args) {
     int[] array1 = {1,2,3};
     int[] array2 = array1;
     array1[0] = 10;
     System.out.println(array2[0]);

//     int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//     int sum = 0;
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                sum+=matrix[i][j];
//            }
//        }

//        System.out.println(sum);

        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i+j;
            }
        }

        System.out.println(matrix[2][1]);
    }
}
