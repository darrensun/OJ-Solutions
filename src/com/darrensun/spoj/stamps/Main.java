package com.darrensun.spoj.stamps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ 3375 - Stamps
 * Created by Darren on 14-7-17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int gap = Integer.parseInt(tokenizer.nextToken());
            int friends = Integer.parseInt(tokenizer.nextToken());

            int[] offers = new int[friends];
            tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < friends; i++)
                offers[i] = Integer.parseInt(tokenizer.nextToken());

            Arrays.sort(offers);    // Always select a friend with the most every time

            out.printf("Scenario #%d:\n", t + 1);
            for (int i = friends-1; i >= 0; i--) {
                gap -= offers[i];
                if (gap <= 0) {
                    out.println(friends-i);
                    break;
                }
            }
            if (gap > 0)
                out.println("impossible");
            out.println();
        }
        out.flush();
    }
}
