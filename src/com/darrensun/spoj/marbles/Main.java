package com.darrensun.spoj.marbles;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * SPOJ 78 - Marbles
 * Created by Darren on 14-7-20.
 * Equivalent to "stars and bars"
 */
public class Main {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    void run() throws Exception {
        int testcases = in.nextInt();
        while (testcases-- > 0) {
            int n = in.nextInt(), k = in.nextInt();
            out.println(combinations(n-1, k-1));
        }
        out.flush();
    }

    /**
     * Calculate the binomial coefficient C(n,k)
     * @param n
     * @param k
     * @return C(n,k)
     */
    long combinations(int n , int k) {
        if (k > n-k)
            k = n-k;
        double result = 1.0;
        for (double i = n; i >= n-k+1; i--)
            result *= i / (i-n+k);
        return Math.round(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
