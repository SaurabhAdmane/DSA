package com.saurabh.dsa.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/permutations-of-a-string_167

// Permutations of a String
// Given a string s, write a program that prints all unique permutations of the string in lexicographically sorted order.

// Example 1:
// Input: s = “ABC”
// Output:  “ABC”, “ACB”, “BAC”, “BCA”, “CAB”, “CBA”

// Example 2:
// Input: s = “AB”
// Output: “AB”, “BA”

// Example 3:
// Input: s = "RRMRR"
// Output: "[MRRRR, RMRRR, RRMRR, RRRMR, RRRRM]"

public class PermutationsOfString {

    public static void main(String[] args) {
        List<String> arr = permute("RRMRR");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    static void permuteHelper(String str, int left, int right, List<String> output) {
        if (left == right) {
            output.add(str);
            return;
        }

        for (int i = left; i < right; i++) {
            String sr = swap(str, i, left);
            permuteHelper(sr, left + 1, right, output);
            swap(sr, i, left);
        }
    }

    public static List<String> permute(String str) {
        List<String> output = new ArrayList<>();
        if (allCharactersSame(str)) {
            output.add(str);
            return output;
        }
        permuteHelper(str, 0, str.length(), output);
        output.sort(new CustomStringComparator());
        return output;
    }

    static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    static boolean allCharactersSame(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}

class CustomStringComparator implements Comparator<String>{

    @Override
    public int compare(String list1, String list2) {
        for (int i = 0; i < list1.length(); i++) {
            if (i >= list2.length()) {
                // List 2 is shorter, so List 1 comes after List 2
                return 1;
            } else if (list1.charAt(i) == list2.charAt(i)) {
                // Values are the same, continue to the next element
                continue;
            } else {
                // Values are different, compare them
                return String.valueOf(list1.charAt(i)).compareTo(String.valueOf(list2.charAt(i)));
            }
        }
        return 0;
    }
}