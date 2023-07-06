package com.saurabh.dsa;

// Que --> Reverse the given int
// * --> 541 = 5 * 100 + 4 * 10 + 1 * 1 = 500 + 40 + 1 = 541
public class ReverseInt {
    public static void main(String[] args) {
        System.out.println("ReverseInt : " + reverse(541));
    }

    public static int reverse(int inputNum) {
        int reverseInt = 0;
        while(inputNum != 0) {
            int digit = inputNum % 10; // return last digit of number

            if((reverseInt >  Integer.MAX_VALUE/10) || (reverseInt <  Integer.MIN_VALUE/10)) // to check INT min and max length
                return 0;

            reverseInt = (reverseInt * 10) + digit; // * this is main formula which we already learn in childhood
            inputNum = inputNum / 10; // remove last digit from number
        }
        return reverseInt;
    }
}
