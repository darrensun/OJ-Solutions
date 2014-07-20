package com.darrensun.spoj.canton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 302 - Count on Cantor
 * Created by Darren on 14-7-16.
 * One number along diagonal line 1, two numbers along diagonal line 2, ...
 * Totol number above diagonal line n: S(n) = n(n+1)/2
 * The x-th term is on line (sqrt(8x+1)-1)/2, rounded up.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++) {
            int n = Integer.parseInt(in.readLine());
            // n is at the i-th position along the d-th diagonal line
            int d = (int) Math.ceil((Math.sqrt(8*n+1)-1)/2.0);
            int i = n - d*(d-1)/2;
            // Consider cases for reverse line directions
            if ((d & 1) == 0)
                out.printf("TERM %d IS %d/%d\n", n, i, d-i+1);
            else
                out.printf("TERM %d IS %d/%d\n", n, d-i+1, i);
        }
        out.flush();
    }
}
