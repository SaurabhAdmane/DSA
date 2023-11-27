package com.saurabh.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

// codingShuttle week 4
// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/generate-brackets_161
// Generate Brackets
// Given an integer N representing the number of pairs of parentheses, The goal is to produce all possible combinations of balanced and well-formed brackets. Return the answer according to sorted order where '(' comes first and then ')'.
// Example 1:
// Input: n = 3
// Output: [((())), (()()), (())(), ()(()), ()()()]

public class GenerateBrackets {

    public static void main(String[] args) {
        System.out.println(AllParenthesis(3));
    }
    public static List<String> AllParenthesis(int n) {
        List<String> out = new ArrayList<>();
        getBrackets(n, 0, 0, "", 0, out);
        return out;
    }

    static void getBrackets(int n, int open, int close, String current, int index, List<String> out){
        if (index == 2*n){
            out.add(current);
            return;
        }

        if(open < n){
            current = current + "(";
            getBrackets(n, open + 1, close, current, index + 1, out);
            current = current.substring(0, current.length() - 1); // Backtracking
        }

        if (open > close){
            current = current + ")";
            getBrackets(n, open, close + 1, current, index + 1, out);
        }
    }
}
