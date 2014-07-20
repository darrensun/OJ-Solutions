package com.darrensun.spoj.bytesm2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 3923 - Philosophers Stone
 * Created by Darren on 14-7-20.
 * Solved using DP.
 * dp(i,j): the maximum number of stones collected when arriving at tile (i,j)
 * s(i,j): stones at tile (i,j)
 * dp(i,j) = s(i,j) + max{dp(i-1,j-1), dp(i-1,j), dp(i-1,j+1)}
 * See a similar problem at SPOJ 7588 - Wise And Miser (MISERMAN)
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int rows = Integer.parseInt(tokenizer.nextToken());
        int columns = Integer.parseInt(tokenizer.nextToken());
        int[] dp = new int[columns+2];  // Two extra columns to avoid boundary check

        // Special treatment to the first row
        // Note that the actual test cases do not ensure w integers in each line.
        for (int j = 1; j <= columns; j++) {
            if (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(in.readLine());
            dp[j] = Integer.parseInt(tokenizer.nextToken());
        }

        // Main body for DP
        for (int i = 2; i <= rows; i++) {
            int temp1 = dp[0], temp2;
            for (int j = 1; j <= columns; j++) {
                if (!tokenizer.hasMoreTokens())
                    tokenizer = new StringTokenizer(in.readLine());
                temp2 = dp[j];
                dp[j] = Integer.parseInt(tokenizer.nextToken()) + maxOfThree(temp1, temp2, dp[j + 1]);
                temp1 = temp2;
            }
        }
          
        // Find the most stones at the last row of tiles
        int mostStones = 0;
        for (int j = 1; j <= columns; j++)
            mostStones = (mostStones < dp[j]) ? dp[j] : mostStones;

        out.println(mostStones);
    }

    // Find the maximum among a, b, and c.
    int maxOfThree(int a, int b, int c) {
        if (a >= b) {
            if (a >= c)
                return a;
            return c;
        } else {
            if (b >= c)
                return b;
            return c;
        }
    }
}
