package com.saurabh.dsa.arrays;

//the substrings of string 'apple' are 'apple', 'appl', 'pple', 'app', 'ppl', 'ple', 'ap', 'pp', 'pl', 'le',
// 'a', 'p', 'l', 'e', ''
public class SubString {

    public static void main(String[] args) {
        printSubString("apple");
    }

    public static void printSubString(String input){
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                System.out.println(input.substring(i, j+1) + ", ");
            }
        }
    }
}
