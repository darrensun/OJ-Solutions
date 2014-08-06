package com.darrensun.spoj.permut1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SPOJ 64 - Permutations
 * Created by Darren on 14-8-4.
 * Solved by DP.
 * dp(i,j): number of permutations for 1...i with j inversions
 * (what we want is dp(n,k))
 * dp(i,j) = \sum_{0<=k<=j and k<i} dp(i-1,j-k)
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
            solve();
        out.flush();
    }

    void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[][] dp = new int[2][k+1];
        dp[0][0] = dp[1][0] = 1;    // The number of permutations with no inversion is always 1

        // Main body of DP
        int row = 1;    // Switch between the two rows
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[row][j] = 0;
                for (int l = 0; l < i && l <= j; l++)
                    dp[row][j] += dp[row^1][j-l];
            }
            row ^= 1;
        }

        out.println(dp[row^1][k]);
    }
}
