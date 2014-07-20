package com.darrensun.spoj.numgame;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 7260 - Number Game
 * Created by Darren on 14-7-17.
 * See more at http://www.algorithmatica.com/number-game/
 * This implementation would lead to TLE probably due to slow Java IO.
 */
public class Main {
    BufferedReader in;
    PrintWriter out;
    final double phi = (Math.sqrt(5)+1) / 2;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in), 65536);
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 1; t <= testcases; t++) {
            out.printf("Case #%d: ", t);
            solve();
        }
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int a1 = Integer.parseInt(tokenizer.nextToken());
        int a2 = Integer.parseInt(tokenizer.nextToken());
        int b1 = Integer.parseInt(tokenizer.nextToken());
        int b2 = Integer.parseInt(tokenizer.nextToken());
        long result = 0;
        for (int b = b1; b <= b2; b++) {
            int winningUpper = (int) Math.ceil(b*phi);
            int winningLower = (int) Math.floor(b/phi);
            if (winningUpper <= a1 || winningLower >= a2) {
                result += a2 - a1 + 1;
            } else {
                result += Math.max(a2-winningUpper+1, 0);
                result += Math.max(winningLower-a1+1, 0);
            }
        }
        out.println(result);
    }
}
