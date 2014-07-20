package com.darrensun.spoj.fctrl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * SPOJ 24 - Small factorials
 * Created by Darren on 14-7-14.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());

        BigInteger[] factorials = new BigInteger[101];  // Factorials can grow very large
        factorials[0] = BigInteger.ONE;
        int maxN = 0;
        for (int i = 0; i < testcases; i++) {
            int n = Integer.parseInt(in.readLine());
            if (n > maxN) {
                for (int j = maxN+1; j <= n; j++)
                    factorials[j] = factorials[j-1].multiply(new BigInteger(Integer.toString(j)));
            }
            out.println(factorials[n]);
        }
        out.flush();
    }
}
