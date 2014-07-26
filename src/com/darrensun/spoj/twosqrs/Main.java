package com.darrensun.spoj.twosqrs;

import java.io.*;

/**
 * SPOJ 91 - Two squares or not two squares
 * Created by Darren on 14-7-24.
 * A number n is a sum of two squares if and only if all prime factors of n of the form 4m+3
 * have even exponent in the prime factorization of n.
 * See more details at http://www.math.uga.edu/~pete/4400twosquares.pdf
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve(Long.parseLong(in.readLine()));
        }
        out.flush();
    }

    void solve(long n) {
        for (int i = 2; i <= n/i; i++) {
            int count = 0;
            while (n % i == 0) {
                n /= i;
                count++;
            }
            if ((i&3) == 3 && (count&1) == 1) {
                out.println("No");
                return;
            }
        }
        if ((n&3) == 3)
            out.println("No");
        else
            out.println("Yes");
    }
}
