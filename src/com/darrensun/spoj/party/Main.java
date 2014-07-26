package com.darrensun.spoj.party;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 97 - Party Schedule
 * Created by Darren on 14-7-21.
 * This problem is almost the same as 0-1 knapsack problem, but with some additional constraints.
 * Solved by DP.
 * dpFun(p,b): maximum fun by attending parties up to p-th given budget b
 * dpFee(p,b): corresponding fee for dpFun(p,b)
 * dpFun(p,b) =
 *  (1) dp(p-1,b-fee(p))+fun(p), if
 *      (c1) fee(p) <= b and    // Can afford party p
 *      (c2) dp(p-1,b-fee(p))+fun(p) > dp(p-1,b), or    // More fun
 *      (c3) dp(p-1,b-fee(p))+fun(p) == dp(p-1,b) and dpFee[1-row][b-fee]+fee < dpFee[1-row][b]
 *          // Cost less
 *  (2) dp(p-1,b), otherwise
 * dpFee is updated according to the choice made for dpFun.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int budget = Integer.parseInt(tokenizer.nextToken());
        int parties = Integer.parseInt(tokenizer.nextToken());
        while (budget != 0 && parties != 0) {
            solve(budget, parties);
            in.readLine();
            tokenizer = new StringTokenizer(in.readLine());
            budget = Integer.parseInt(tokenizer.nextToken());
            parties = Integer.parseInt(tokenizer.nextToken());
        }
        out.flush();
    }

    void solve(int budget, int parties) throws Exception {
        int[][] dpFun = new int[2][budget+1];
        int[][] dpFee = new int[2][budget+1];
        int row = 1;    // Switch between the two rows of the table
        for (int p = 0; p < parties; p++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int fee = Integer.parseInt(tokenizer.nextToken());
            int fun = Integer.parseInt(tokenizer.nextToken());
            for (int b = 1; b <= budget; b++) {
                if (b >= fee &&
                        (dpFun[1-row][b-fee]+fun > dpFun[1-row][b] ||   // More fun
                        dpFun[1-row][b-fee]+fun == dpFun[1-row][b] &&   // Same fun but cheaper
                        dpFee[1-row][b-fee]+fee < dpFee[1-row][b])) {
                    dpFun[row][b] = dpFun[1-row][b-fee]+fun;
                    dpFee[row][b] = dpFee[1-row][b-fee]+fee;
                } else {
                    dpFun[row][b] = dpFun[1-row][b];
                    dpFee[row][b] = dpFee[1-row][b];
                }
            }
            row = 1 - row;
        }
        out.printf("%d %d\n", dpFee[1 - row][budget], dpFun[1 - row][budget]);
    }
}
