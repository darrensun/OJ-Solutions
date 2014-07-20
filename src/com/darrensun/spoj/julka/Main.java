package com.darrensun.spoj.julka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * SPOJ 54 - Julka
 * Created by Darren on 14-7-15.
 */
public class Main {
    public final static int TESTCASES = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int t = 0; t < TESTCASES; t++) {
            BigInteger sum = new BigInteger(in.readLine());
            BigInteger difference = new BigInteger(in.readLine());
            out.println(sum.add(difference).shiftRight(1));
            out.println(sum.subtract(difference).shiftRight(1));
        }
        out.flush();
    }
}
