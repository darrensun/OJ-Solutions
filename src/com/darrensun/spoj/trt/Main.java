package com.darrensun.spoj.trt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 740 - Treats for the Cows
 * Created by Darren on 14-7-22.
 * Solved by DP.
 * dp(i,j,k): maximum outcome by selling treats i...j starting from day k
 * dp(i,j,k) = max{v[i]*k+dp(i+1,j,k+1), v[j]*k+dp(i,j-1,k+1)}
 * What we want is dp(0,n-1,1).
 * Note that k = j-i+1. So it can be reduced to two-dimensional DP.
 * By exploring the relation, space usage can be further reduced to O(n).
 * Note that the greedy strategy by selling the treat of smaller value does not guarantee maximum
 * outcome. For examle: 10, 1, 10, 9.
 * The greedy strategy yields 72 by selling 9, 10, 1, 10 one on a day,
 * but the maximum outcome is 79 by selling 10, 1, 9, 10
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int n = Integer.parseInt(in.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = Integer.parseInt(in.readLine());

        int[] dp = new int[n];

        // dp[i] = dp(i,i), maximum outcome by selling treat i on the last day (n-th day)
        for (int i = 0; i < n; i++)
            dp[i] = values[i] * n;

        // Main body for DP
        // dp[i] = dp(i,i+n-d), maximum outcome by selling treats i...i+n-d starting from day d
        for (int d = n-1; d >= 1; d--) {
            for (int i = 0; i < d; i++) {
                // Maximum outcome by selling treat i on day d
                int sellAtHead = d * values[i] + dp[i+1];
                // Maximum outcome by selling treat i+n-d on day d
                int sellAtTail = d * values[i+n-d] + dp[i];
                // Get the larger of them
                dp[i] = (sellAtHead >= sellAtTail) ? sellAtHead : sellAtTail;
            }
        }

        // dp[0]: maximum outcome by selling treats 0...n-1 starting from day 1
        out.println(dp[0]);
    }
}
