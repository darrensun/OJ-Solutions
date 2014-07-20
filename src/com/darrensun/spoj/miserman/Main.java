package com.darrensun.spoj.miserman;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 7588 - Wise And Miser
 * Created by Darren on 14-7-20.
 * Solved by DP.
 * Analogous to SPOJ 3923 - Philosophers Stone (BYTESM2).
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int rows = Integer.parseInt(tokenizer.nextToken());
        int columns = Integer.parseInt(tokenizer.nextToken());

        int[] dp = new int[columns+2];  // Two extra columns to avoid boundary check
        dp[0] = dp[columns+1] = Integer.MAX_VALUE;

        // Special treatment to the first row
        tokenizer = new StringTokenizer(in.readLine());
        for (int j = 1; j <= columns; j++) {
            dp[j] = Integer.parseInt(tokenizer.nextToken());
        }

        // Main body for DP
        for (int i = 2; i <= rows; i++) {
            int temp1 = dp[0], temp2;
            tokenizer = new StringTokenizer(in.readLine());
            for (int j = 1; j <= columns; j++) {
                temp2 = dp[j];
                dp[j] = Integer.parseInt(tokenizer.nextToken()) + minOfThree(temp1, temp2, dp[j+1]);
                temp1 = temp2;
            }
        }

        // Find the minimum fare at the last city
        int minFare = Integer.MAX_VALUE;
        for (int j = 1; j <= columns; j++)
            minFare = (minFare > dp[j]) ? dp[j] : minFare;
        out.println(minFare);
        out.flush();
    }

    // Find the minimum among a, b, and c.
    int minOfThree(int a, int b, int c) {
        if (a <= b) {
            if (a <= c)
                return a;
            return c;
        } else {
            if (b <= c)
                return b;
            return c;
        }
    }

}
