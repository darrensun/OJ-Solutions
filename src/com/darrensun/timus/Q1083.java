package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1083 - Factorials!!!
 * Created by Darren on 14-7-11.
 */
public class Q1083 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = tokenizer.nextToken().length();

            // Calculate the factorial in the special format
            int factorial = 1;
            while (n >= k) {
                factorial *= n;
                n -= k;
            }
            if (n != 0)
                factorial *= n;

            System.out.println(factorial);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
