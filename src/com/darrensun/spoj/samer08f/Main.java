package com.darrensun.spoj.samer08f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 3410 - Feynman
 * Created by Darren on 14-7-15.
 * S(n) = S(n-1) + n^2, for n > 1; S(1) = 1
 * Or S(n) = n(n+1)(2n+1)/6
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n;
        while ((n = Integer.parseInt(in.readLine())) != 0) {
            out.println(n*(n+1)*(2*n+1)/6);
        }
        out.flush();
    }
}
