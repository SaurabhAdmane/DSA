package com.saurabh.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://www.codingshuttle.com/classroom/dsa-prime-jul-23_2/problems/smart-keypad-problem_165

// Smart Keypad Problem
// You are given a string digits that contains digits from [2 - 9], both inclusive. Return all possible letter combinations
// that the number could represent in sorted order.
// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:
// Input: digits = "9"
// Output: ["w", "x", "y", "z"]

public class SmartKeypad {

    public static void main(String[] args) {
        String strDigit = "23";
        List<String> ans = letterCombinations(strDigit);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();
        letterCombinationsHelper(keys, digits,0, ans, "");
        return ans;
    }

    static void letterCombinationsHelper(String[] keys, String inputDigits, int startIndex, List<String> output, String currentString) {
        // Base Case
        if (startIndex == inputDigits.length()) {
            output.add(currentString);
            return;
        }
        // Convert input string number to number
        int buttonNum = inputDigits.charAt(startIndex) - '0';
        String buttonCharacters = keys[buttonNum];
        for (int i = 0; i <buttonCharacters.length(); i++) {
            currentString = currentString + buttonCharacters.charAt(i);
            letterCombinationsHelper(keys, inputDigits, startIndex + 1, output, currentString);
            currentString = currentString.substring(0, currentString.length() - 1);// Backtracking
        }
    }
}
