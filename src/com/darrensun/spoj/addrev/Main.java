package com.darrensun.spoj.addrev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 42 - Adding Reversed Numbers
 * Created by Darren on 14-7-14.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());

        for (int i = 0; i < testcases; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            out.println(reverse(reverse(a)+reverse(b)));
        }
        out.flush();
    }

    /**
     * Reverse an integer.
     * @param n The integer to be reversed.
     * @return The reverse of n.
     */
    public static long reverse(long n) {
        long reverseN = 0;
        while (n != 0) {
            long remainder = n % 10;    // Last digit of n
            n /= 10;
            if (remainder != 0 || reverseN > 0) // reverseN > 0 -> this zero is not trailing
                reverseN = reverseN * 10 + remainder;
        }
        return reverseN;
    }
}
