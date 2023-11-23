package com.saurabh.dsa.recursion;

// Palindrome String

// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/palindrome-string_153
// Given a string S, check if it is palindrome or not.
// Example 1:
// Input: S = "racecar"
// Output: 1
// Explanation: S is a palindrome

public class PalindromeString {
    public static boolean isPalindrome(String str) {
        return palindromeSubProb(str, 0, str.length() - 1);
    }

    public static boolean palindromeSubProb(String s, int left, int right){
        if (left >= right) return true;
        if (s.charAt(left) == s.charAt(right)){
            return palindromeSubProb(s, left+1, right-1);
        }
        return false;
    }
}
