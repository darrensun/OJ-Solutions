package com.darrensun.spoj.danger;

import java.io.*;

/**
 * SPOJ 1786 - In Danger
 * Created by Darren on 14-7-29.
 * An instance of Josephus problem when k = 2, solved with O(logn) time and O(1) space.
 * J(2m) = 2J(m)-1, J(2m+1) = 2J(m)+1.
 * If n = 2^t + l and 0 <= l < 2^t, J(n) = 2l+1, i.e., one-bit left cyclic shift of n.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int n;
        while ((n = nextInt()) != 0) {
            solve(n);
        }
        out.flush();
    }

    void solve(int n) {
        int probe = 1;
        while (n >= probe)
            probe <<= 1;
        out.println(((n - (probe >> 1)) << 1) | 1); // One-bit left cyclic shift of n
    }

    int nextInt() throws IOException {
        int next = 0;
        next = (in.read()-'0') * 10;
        next += in.read()-'0';
        in.read();
        int exp = in.read() - '0';
        in.read();
        return next*(int)Math.pow(10,exp);
    }
}
