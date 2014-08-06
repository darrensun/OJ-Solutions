package com.darrensun.spoj.favdice;

import java.io.*;

/**
 * SPOJ 1026 - Favorite Dice
 * Created by Darren on 14-7-30.
 * Analogous to the coupon collector's problem.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0)
            solve(Integer.parseInt(in.readLine()));
        out.flush();
    }

    void solve(int n) {
        double result = 0.0;
        for (int i = 1; i <= n; i++)    // Sum of n/i, 1 <= i <= n
            result += n / (double)i;
        out.printf("%.2f\n", result);
    }
}
