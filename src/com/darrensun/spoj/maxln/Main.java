package com.darrensun.spoj.maxln;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 8670 - THE MAX LINES
 * Created by Darren on 14-7-20.
 * a^2+b = 4r^2-b^2+b; it reaches it maximum when b = 0.5
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public final static double CONSTANT = 0.25;     // -b^2+b when b = 0.5

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= testcases; i++) {
            double r = Double.parseDouble(in.readLine());
            out.printf("Case %d: %.2f\n", i, 4*r*r+CONSTANT);
        }
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

}
