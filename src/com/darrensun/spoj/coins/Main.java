package com.darrensun.spoj.coins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * SPOJ 346 - Bytelandian gold coins
 * Created by Darren on 14-7-16.
 * Optimal strategy: when n < 12, we exchange it directly for USD; when n >= 12,
 * we always make exchange with the bank.
 * Observation: we won't get better off by making exchange with the bank when n < 12,
 * or get worse off by making exchange with the bank when n >= 12.
 * The above observation can be proved by strong induction.
 * For the second part of the observation, the base cases are when n = 12, ..., 23.
 * n = 12 + x, x >= 12
 * n/2+n/3+n/4 = 13+(x/2+x/3+x/4) >= 13+x > n
 */
public class Main {

    // Used to memorize intermediate results by the DP approach
    private static Map<Integer, Long> table = new HashMap<Integer, Long>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            out.println(maxDollars(n));
        }
        out.flush();
    }

    /**
     * Find the maximum dollars one can make from a coin.
     * @param n The value of the coin.
     * @return The maximum dollars made from a coin of value n.
     */
    public static long maxDollars(int n) {
        if (n < 12)
            return n;
        if (table.containsKey(n))
            return table.get(n);

        // Take the optimal strategy by exchanging with the bank.
        // int type is not sufficient to hold the result when n is large.
        long maxDollarsOfNCoins = maxDollars(n/2)+maxDollars(n/3)+maxDollars(n/4);

        // Save the result to avoid duplicate computation
        table.put(n, maxDollarsOfNCoins);

        return maxDollarsOfNCoins;
    }
}
