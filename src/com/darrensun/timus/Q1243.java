package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Timus 1243 - Divorce of the Seven Dwarfs
 * Created by Darren on 14-7-9.
 * Apply Horner's Rule: a_n...a_0 = (...(((a_n * 10) + a_{n-1}) * 10 + ... + a_1) * 10 + a_0
 * and the fact that ax+b mod m = ((a mod m) * (x mod m) + b) mod m
 */
public class Q1243 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String number = in.readLine();
            int remainder = 0;
            for (int i = 0; i < number.length(); i++)
                remainder = (remainder * 3 + (number.charAt(i)-'0')) % 7;
            System.out.println(remainder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
