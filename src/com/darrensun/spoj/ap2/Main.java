package com.darrensun.spoj.ap2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SPOJ 11063 - AP - Complete The Series (Easy)
 * Created by Darren on 14-7-18.
 * The time limit is too strict for Java solutions.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        long third = Long.parseLong(tokenizer.nextToken());
        long thirdLast = Long.parseLong(tokenizer.nextToken());
        long sum = Long.parseLong(tokenizer.nextToken());
        long n = 2*sum / (third+thirdLast);
        long d = (thirdLast-third) / (n-5);  // n >= 7
        out.println(n);
        for (long a = third-2*d; a <= thirdLast+2*d; a += d) {
            out.print(a);
            out.print(' ');
        }
        out.println();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
