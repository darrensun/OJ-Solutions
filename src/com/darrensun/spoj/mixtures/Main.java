package com.darrensun.spoj.mixtures;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SPOJ 345 - Mixtures
 * Created by Darren on 14-7-24.
 * Solved by DP.
 * dp(i,j): minimum smoke when mixing mixtures i...j.
 * c(i,j): the color after mixing the mixtures with the minimum smoke.
 * dp(i,j) = min{ dp(i,k)+dp(k+1,j)+c(i,k)*c(k+1,j)} for i <= k <= j.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private int n;
    private int[][] color;
    private int[][] dp;

    void run() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            n = Integer.parseInt(line);
            color = new int[n][n];
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
                color[i][i] = Integer.parseInt(tokenizer.nextToken());
            solve();
        }
        out.flush();
    }

    /**
     * Find the minimum amount of smoke using DP.
     */
    void solve() {
        dp = new int[n][n];

        // Main body of DP
        for (int d = 1; d <= n-1; d++) {    // d = j-i
            for (int i = 0; i < n-d; i++) {
                dp[i][i+d] = Integer.MAX_VALUE;
                for (int k = i; k < i+d; k++) {
                    if (dp[i][i+d] > dp[i][k]+ dp[k+1][i+d]+
                            color[i][k]*color[k+1][i+d]) {
                        dp[i][i+d] = dp[i][k]+ dp[k+1][i+d]+color[i][k]*color[k+1][i+d];
                        color[i][i+d] = (color[i][k]+color[k+1][i+d]) % 100;
                    }
                }
            }
        }

        out.println(dp[0][n-1]);
    }
}
