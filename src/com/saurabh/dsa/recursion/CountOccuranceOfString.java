package com.saurabh.dsa.recursion;

// Count the Occurrences of a String

// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/count-the-occurrences-of-a-string_154
// Create a function that counts the number of times a string (str2) appears in another string (str1).
// Example 1:
// Input :
// str1 = "hello world, hello universe"
// str2 = 'hello'
// Output :
// Explanation:
// 'hello' appears two times in str1.
public class CountOccuranceOfString {

    public static void main(String[] args) {
        String text = "hello world, hello universe";
        String target = "world";
        System.out.println("Count occurance of string : " + count(text, target));
    }
    public static int count(String text, String target) {
       return countHelper(text, target, 0);
    }

    static int countHelper(String s, String t, int i){
        if (i > s.length() - t.length()) return 0;

        int subAns = countHelper(s, t, i + 1);
        if (s.substring(i, i + t.length()).equals(t)){
            return subAns + 1;
        } else return subAns;
    }
}
