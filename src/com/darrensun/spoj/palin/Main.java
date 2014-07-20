package com.darrensun.spoj.palin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 5 - The Next Palindrome
 * Created by Darren on 14-7-16.
 * Basic idea: make the highest digit that has been changed as low as possible.
 * Two cases:
 *  1. The first half of the digits can remain unchanged: produce a palindrome by using the
 *  first half of the digits. If it is larger than the original one, we are done.
 *  2. The first half of the digits need to be changed: increment the integer represented by
 *  those digits by one, and produce a palindrome based on the incremented digits.
 * Note: When using BigInteger to implement the "add one" operation,
 * it seems to slow down the program and lead to TLE.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++)
            out.println(nextPalindrome(in.readLine()));
        out.flush();
    }

    /**
     * Find the next palindrome of a given integer.
     * @param k The given integer as a string.
     * @return The next palindrome of k.
     */
    public static String nextPalindrome(String k) {
        int n = k.length();
        // Construct a palindrome using the first half of k's digits (including the middle digit
        // if k has odd number of digits)
        StringBuilder temp = new StringBuilder(k.substring(0, (n-1)/2+1));
        StringBuilder reverse = new StringBuilder(temp);
        if ((n & 1) == 1)   // k has odd number of digits
            reverse.deleteCharAt(reverse.length()-1);
        reverse.reverse();
        temp.append(reverse);
        String result = temp.toString();

        // The constucted palindrome is larger than k; it is the next palindrome of k.
        if (result.compareTo(k) > 0)
            return result;

        // Otherwise, we add the integer formed by the first half of k's digits by one,
        // and produce a palindrome based on it.
        for (int i = (n-1)/2; i >= 0; i--) {
            if (k.charAt(i) != '9') {
                // The addition increments the digit at position i,
                // and set the remaining (n-1)/2-i digits to zeroes
                temp = new StringBuilder(k.substring(0, i));
                temp.append((char)(k.charAt(i)+1));
                for (int j = i+1; j <= (n-1)/2; j++)
                    temp.append('0');

                reverse = new StringBuilder(temp);
                if ((n & 1) == 1)
                    reverse.deleteCharAt(reverse.length()-1);
                reverse.reverse();
                temp.append(reverse);
                return temp.toString();
            }
        }

        // The integer formed by the first half of k's digits is 9...9 (say, of m digits).
        // Its next palindrome must be 10...01 (of m+1 digits)
        temp = new StringBuilder("1");
        for (int i = 1; i < n; i++)
            temp.append('0');
        temp.append('1');

        return temp.toString();
    }
}
