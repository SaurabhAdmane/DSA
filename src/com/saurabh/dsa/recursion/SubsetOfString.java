package com.saurabh.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/subsets-of-a-string_149

// CodingShuttle Week 3
/**
 *  Subsets of a string
 *  Given a string, write a program to output every non-empty substring of the given string in a Lexographically
 *  sorted order.
 *  Note: Here we will not consider an empty string as the subset of a String
 *
 * Example 1:
 * Input: s = abc
 * Output: [a, ab, abc, ac, b, bc, c]
 */

public class SubsetOfString {

    public static void main(String[] args) {
        System.out.println(findSubstrings("abc"));
    }

    public static List<String> findSubstrings(String s) {
        List<String> output = new ArrayList<String>();
        helperSubstring(s, 0, "", output);
        Collections.sort(output);
        return output;
    }

    static void helperSubstring(String s, int i, String list, List<String> out){
        if(i == s.length()){
            if (list.isEmpty()) return;
            out.add(list);
            return;
        }
        helperSubstring(s, i + 1, list+s.charAt(i), out);
        helperSubstring(s, i + 1, list, out);
    }
}
