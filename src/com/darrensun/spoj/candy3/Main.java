package com.darrensun.spoj.candy3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * SPOJ 2148 - Candy III
 * Created by Darren on 14-7-16.
 * Use BigInteger to handle extremly large integers.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases =  Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++) {
            in.readLine();  // Ignore the empty line between testcases
            int n = Integer.parseInt(in.readLine());
            // Calculate the total number of candies
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < n; i++)
                sum = sum.add(new BigInteger(in.readLine()));
            // The candies can be evenly distributed iff sum is divisible by n
            if (sum.mod(new BigInteger(Integer.toString(n))).equals(BigInteger.ZERO))
                out.println("YES");
            else
                out.println("NO");
        }
        out.flush();
    }
}
