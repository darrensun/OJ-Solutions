package com.darrensun.spoj.edist;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 6219 - Edit distance
 * Created by Darren on 14-7-20.
 * Solved by DP.
 * dp(i,j): minimum number of operations for transforming a[0...i-1] to b[0...j-1]
 * dp(i,j) = min{dp(i-1,j)+1, dp(i,j-1)+1, dp(i-1,j-1)+(a[i-1]==b[j-1?0:1)}
 * Note the reason why we consider only deleting/replacing the last character or inserting a
 * character after the last character. This is because when a[i-1]!=b[j-1],
 * something must be done to the last character of a such that it matches b[j-1],
 * and the sequence to make such change is insignificant.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0)
            solve();
        out.flush();
    }

    void solve() throws Exception {
        String a = in.readLine(), b = in.readLine();
        int m = a.length(), n = b.length();
        int[] dp = new int[n+1];

        // Transform empty string to b[0...j-1]; all operations are insertions
        for (int j = 1; j <= n; j++)
            dp[j] = j;

        // Main body of DP
        for (int i = 1; i <= m; i++) {
            dp[0] = i;  // Transform a[0...i-1] to empty string; all operations are deletions
            int temp1 = i-1, temp2; // temp1 acts as dp(i-1,j-1)
            for (int j = 1; j <= n; j++) {
                // Get the cost for each operation
                int costOfDeletion = dp[j] + 1;
                int costOfInsertion = dp[j-1] + 1;
                int costOfReplacement = temp1 + ((a.charAt(i-1)==b.charAt(j-1))?0:1);
                // Update dp(i,j)
                temp2 = dp[j];
                dp[j] = minOfThree(costOfDeletion, costOfInsertion, costOfReplacement);
                temp1 = temp2;
            }
        }
        out.println(dp[n]);
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
