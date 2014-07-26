package com.darrensun.spoj.crds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * SPOJ 10509 - Cards
 * Created by Darren on 14-7-22.
 * Arithmetic progression
 * S(n) = 3 + 6 + ... + 3(n-1) + 3n - n = (3n+1)n/2
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0)
            solve();
        out.flush();
    }

    void solve() throws Exception {
        int n = Integer.parseInt(in.readLine());
        out.println((((long)(3*n+1))*n/2) % 1000007);
    }
}
