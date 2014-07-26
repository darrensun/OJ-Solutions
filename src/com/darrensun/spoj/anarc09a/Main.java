package com.darrensun.spoj.anarc09a;

import java.io.*;

/**
 * SPOJ 5449 - Seinfeld
 * Created by Darren on 14-7-25.
 * Solved by a greedy algorithm.
 * For a pair of matched braces, they do not need any operation.
 * Upon encountering an opening brace, we increment the counter for opening braces by one.
 * Upon encountering an closing brace, we
 *  1. match it against an opening brace (if any) that precedes it,
 *  and leave them out of consideration, or
 *  2. replace it with an opening brace if no opening brace precedes it.
 * DP also works, but is two orders of magnitude slower than the greedy one.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int count = 1;
        String line;
        while (true) {
            line = in.readLine();
            if (line.equals(""))
                out.printf("%d. 0\n", count++);
            else if (line.charAt(0) == '-')
                break;
            else
                out.printf("%d. %d\n", count++, solve(line));
        }
        out.flush();
    }

    // Greedy: O(n)
    int solve(String str) {
        int n = str.length();
        int opening = 0, operations = 0;

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            // Ignore characters that are not braces.
            // It is reported in the comments that there may be trailing '\r' in each line.
            if (c != '{' && c != '}')
                continue;

            if (c == '{') {     // Opening brace
                opening++;
            } else {        // Closing brace
                if (opening > 0) {  // At least one opening brace available for matching
                    opening--;
                } else {    // No opening brace available
                    opening++;
                    operations++;
                }
            }
        }

        operations += opening / 2;  // For unmatched opening braces, we need to change half of them
        return operations;
    }

//    // DP: O(n^3)
//    int solve(String str) {
//        int n = str.length();
//        int[][] dp = new int[n][n];
//
//        for (int d = 1; d < n; d += 2) {
//            for (int i = 0; i < n-d; i++) {
//                int j = i+d;
//                dp[i][j] = dp[i+1][j-1];
//                if (str.charAt(i) != '{')
//                    dp[i][j]++;
//                if (str.charAt(j) != '}')
//                    dp[i][j]++;
//
//                for (int k = i+1; k < j-1; k += 2)
//                    dp[i][j] = (dp[i][j] <= dp[i][k]+dp[k+1][j]) ? dp[i][j] :
//                            dp[i][k]+dp[k+1][j];
//            }
//        }
//        return dp[0][n-1];
//    }
}
