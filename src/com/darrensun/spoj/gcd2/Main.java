package com.darrensun.spoj.gcd2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * SPOJ 2906 - GCD2
 * Created by Darren on 14-7-22.
 * The judge do not accept submission using Java.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

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
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        BigInteger bigA = new BigInteger(tokenizer.nextToken());
        BigInteger bigB = new BigInteger(tokenizer.nextToken());
        if (bigA.equals(BigInteger.ZERO))
            out.println(bigB.intValue());
        else
            out.println(gcd(bigA.intValue(), bigB.mod(bigA).intValue()));
        // Alternatively, we can do a modulo operation manually using Horner's rule and
        // properties of modulo operations
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
