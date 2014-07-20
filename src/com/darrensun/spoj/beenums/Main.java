package com.darrensun.spoj.beenums;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 7406 - Beehive Numbers
 * Created by Darren on 14-7-18.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        while (true) {
            int n = Integer.parseInt(in.readLine());
            if (n == -1)
                break;
            solve(n);
        }
        out.flush();
    }

    void solve(long n) {    // long here due to the computation of level
        if (n == 1) {
            out.println('Y');
            return;
        }
        double level = (Math.sqrt(9+12*(n-1))-3) / 6;
        if (level == (int) level)
            out.println('Y');
        else
            out.println('N');
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
