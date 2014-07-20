package com.darrensun.spoj.hubullu;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 1028 - Hubulullu
 * Created by Darren on 14-7-19.
 * The first play always wins the game.
 * Lemma: if 1...n is a winning/losing position, 2...n is a losing/winning position for the
 * first player (n>3)
 * This is due to the fact that 1 is a divisor of all integers
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public final static String AIRBORNE = "Airborne wins.";
    public final static String PAGFLOYD = "Pagfloyd wins.";

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        tokenizer.nextToken();
        int first = Integer.parseInt(tokenizer.nextToken());
        // The first player wins
        if (first == 0)
            out.println(AIRBORNE);
        else
            out.println(PAGFLOYD);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
